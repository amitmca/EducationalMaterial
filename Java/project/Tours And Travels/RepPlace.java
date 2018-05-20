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

public class RepPlace extends JPanel
{
	JLabel lblState;
	JComboBox cmbState;
	JButton butView , butCancel;

	RepPlace()
	{
		setLayout(null);
		lblState = new JLabel("State : ");
		lblState.setBounds(20,10,100,30);

		cmbState = new JComboBox();
		cmbState.setBounds(100,10,150,25);
		cmbState.setEditable(true);

		butView = new JButton("View Report");
		butView.setBounds(20,50,120,30);

		butCancel = new JButton("Cancel");
		butCancel.setBounds(150,50,100,30);

		add(lblState);
		add(cmbState);
		add(butView);
		add(butCancel);

		butView.addActionListener(new ALRepPlace());
		butCancel.addActionListener(new ALRepPlace());
	}//const

	public void connectcmbState()
	{
		try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				Statement stmt = conn.createStatement();
				String cmdPlace = "Select distinct State from Places";
				ResultSet rsPlace = stmt.executeQuery(cmdPlace);
				while(rsPlace.next())
				{
				  cmbState.addItem(rsPlace.getString(1));

				}//while
				stmt.close();
				conn.close();
			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}//catch
	}//connectcmbState

	public static void main(String []args)
	{
		RepPlace repPlaceobj = new RepPlace();
		JFrame frmrepPlace = new JFrame("Place Reports");
		frmrepPlace.setContentPane(repPlaceobj);
		repPlaceobj.connectcmbState();
		frmrepPlace.setVisible(true);
		frmrepPlace.setSize(280,120);

		WindowListener listener = new WindowAdapter()
				{
					public void windowClosing(WindowEvent wndEvt)
					{
						System.exit(0);
					}
				};

		frmrepPlace.addWindowListener(listener);
	}//main

	public class ALRepPlace implements ActionListener
	{
		public void actionPerformed(ActionEvent actEvt)
		{
			if(actEvt.getSource() == butView)
			{
			   Runtime iexp;
			   Process pro;
			   iexp = Runtime.getRuntime();

			   String sql = "";
			   String strstate = (String)cmbState.getSelectedItem();

			   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\PlaceStateList.html"};
			   try
			   {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection  con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
					sql = "select * from Places where State = ?";
					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1,(String)strstate);
					ResultSet rs = stmt.executeQuery();

					File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\PlaceStateList.html");
					FileWriter out = new FileWriter(outFile);

					java.util.Date now = new java.util.Date();
					out.write("<html><head><title>Hotel Listing</title></html><body bgcolor=#d3d3d3><h4>");
					out.write("<table border=0 ><tr><td></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>PLACE LISTING</u> </center></h2></td></tr><p>");
					out.write("<table border=0 align=center><tr><td>STATE: "+strstate+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td> DATE: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1><p>");
					out.write("<table border = 1 width=100% bgcolor = #EEEEFF>");

					out.write("<th>Name &nbsp;&nbsp;");
					out.write("<th>Season From &nbsp;&nbsp;&nbsp;&nbsp; </th>");
					out.write("<th>Season To&nbsp;&nbsp; </th>");
					out.write("<th>Temperature&nbsp;&nbsp; </th>");
					out.write("<th>Rain&nbsp;&nbsp;  </th>");
					out.write("<th>Tourist Spots&nbsp;&nbsp; </th>");

					while (rs.next())
					{
					out.write("<tr> <td>" +rs.getString(1)+"</td> <td>" +rs.getString(4)+"</td> <td>" +rs.getString(5)+"</td> <td>" +rs.getString(3)+"</td> <td>" +rs.getString(7)+"</td> <td>" +rs.getString(6)+"</td>");
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
			else
			if(actEvt.getSource() == butCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//butCancel
		}//actionPerformed
	}//ALRepPlace

}//RepPlace