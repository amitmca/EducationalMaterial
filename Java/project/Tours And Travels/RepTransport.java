import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.Toolkit.*;
import javax.swing.event.*;
import java.lang.Runtime.*;
import java.io.*;

public class RepTransport extends JPanel
{

	JLabel lblPlaceName ,lblPlaceNameD , lblMode;
	JComboBox cmbPlaceName ,cmbPlaceNameD , cmbMode;
	JButton butView,butCancel;

	public RepTransport()
	{
		setLayout(null);
		lblPlaceName = new JLabel("Place Name : ");
		lblPlaceName.setBounds(20,10,130,30);

		lblPlaceNameD = new JLabel("Destination : ");
		lblPlaceNameD.setBounds(20,50,130,30);

		lblMode = new JLabel("Mode : ");
		lblMode.setBounds(20,90,130,30);

		cmbPlaceName = new JComboBox();
		cmbPlaceName.setBounds(130,10,150,25);

		cmbPlaceNameD = new JComboBox();
		cmbPlaceNameD.setBounds(130,50,150,25);

		cmbMode = new JComboBox();
		cmbMode.setBounds(130,90,150,25);
		cmbMode.addItem("Railway");
		cmbMode.addItem("Airway");
		cmbMode.addItem("Roadway");
		cmbMode.addItem("All");

		butView = new JButton("View Reports");
		butView.setBounds(20,130,120,30);

		butCancel = new JButton("Cancel");
		butCancel.setBounds(170,130,110,30);

		add(lblPlaceName);
		add(cmbPlaceName);
		add(lblPlaceNameD);
		add(cmbPlaceNameD);
		add(lblMode);
		add(cmbMode);
		add(butView);
		add(butCancel);

		butView.addActionListener(new ALRepTransport());
		butCancel.addActionListener(new ALRepTransport());


	}//RepTransport constr

	public void connectcmbName()
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				Statement stmt = conn.createStatement();
				String cmdPlace = "Select Pname from Places";
				ResultSet rsPlace = stmt.executeQuery(cmdPlace);
				while(rsPlace.next())
				{
				 String strPlace = rsPlace.getString(1);
				  cmbPlaceName.addItem(strPlace);
				  cmbPlaceNameD.addItem(strPlace);

				}//while
				stmt.close();
				conn.close();
			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}//catch
		}//connectcmbRefDb

	public static void main(String []args)
	{
		RepTransport repTransportobj = new RepTransport();
		JFrame frmrepTransport = new JFrame("Transport Reports");
		frmrepTransport.setContentPane(repTransportobj);

		frmrepTransport.setVisible(true);
		frmrepTransport.setSize(300,200);

		WindowListener listener = new WindowAdapter()
				{
					public void windowClosing(WindowEvent wndEvt)
					{
						System.exit(0);
					}
				};

		frmrepTransport.addWindowListener(listener);
	}//main

	public class ALRepTransport implements ActionListener
	{
		public void actionPerformed(ActionEvent actEvt)
		{
			if(actEvt.getSource() == butView)
			{

				Runtime iexp;
				Process pro;
				iexp = Runtime.getRuntime();

				String strMode = (String)cmbMode.getSelectedItem();
				String strSource = (String)cmbPlaceName.getSelectedItem();
				String strDest = (String)cmbPlaceNameD.getSelectedItem();
				String sql = "";
				if(strMode.equals("All"))
				{
					sql = "Select * from Transport where SourcePlace = ? and DestPlace = ?";
				}
				else
				{
					sql = "Select * from Transport where SourcePlace = ? and DestPlace = ? and TMode = ?";
				}


				   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\TransList.html"};
				   try
				   {
				        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				        Connection  con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				        PreparedStatement stmt = con.prepareStatement(sql);
				        //String sql ="Select * from Customer";
				        if(strMode.equals("All"))
				        {
							stmt.setString(1,(String)strSource);
							stmt.setString(2,(String)strDest);
						}
						else
						{
							stmt.setString(1,(String)strSource);
							stmt.setString(2,(String)strDest);
							stmt.setString(3,(String)strMode);
						}
				        ResultSet rs = stmt.executeQuery();

				        File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\TransList.html");
				        FileWriter out = new FileWriter(outFile);

						java.util.Date now = new java.util.Date();
				        out.write("<html><head><title>Transport Details</title></html><body bgcolor=#d3d3d3><h4>");
				        out.write("<table border=0 ><tr><td></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>TRANSPORT DETAILS</u> </center></h2></td></tr><p>");
				        out.write("<table border=0 align=center><tr><td>SOURCE: "+strSource+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>DESTINATION: "+strDest+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td> Date: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>");
				        out.write("<table border = 1 width=100% bgcolor = #EEEEFF>");


						out.write("<th>TId &nbsp;&nbsp; </th>");
						out.write("<th>Mode &nbsp;&nbsp; </th>");
						out.write("<th>Name&nbsp;&nbsp; </th>");
						out.write("<th>Departure&nbsp;&nbsp; </th>");
						out.write("<th>Arrival&nbsp;&nbsp; </th>");
						out.write("<th>Distance</th>");
						out.write("<th>Days&nbsp;&nbsp;&nbsp;&nbsp; </th>");
						out.write("<th>Luxury Cost(Adult)&nbsp; </th>");
						out.write("<th>Budget Cost(Adult)&nbsp;  </th>");
						out.write("<th>Luxury Cost(Child)&nbsp;</th>");
						out.write("<th>Budget Cost(Child)&nbsp;</th>");
						while (rs.next())
				        {
						out.write("<tr> <td>" +rs.getString(1)+"</td> <td>" +rs.getString(2) +"</td> <td>" + rs.getString(3) + "</td> <td>" +rs.getString(6)+"</td> <td>" +rs.getString(7)+"</td> <td>" +rs.getInt(8)+"</td> <td>" +rs.getString(11)+"</td> <td>" +rs.getInt(9)+"</td> <td>" +rs.getInt(10)+"</td> <td>" +rs.getInt(12)+"</td> <td>" +rs.getInt(13)+"</td>");
						}
						out.write("</table>");
						out.write("</body></html>");
				        out.close();
				        pro = iexp.exec(en);

				       pro.waitFor();


				   } // end of try

				   catch(Exception e)
				   {
				        System.out.println(e);
				   }

			}//butView

			if(actEvt.getSource() == butCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//butCancel
		}//actionPerformed
	}//ALTransport


}//RepTransport