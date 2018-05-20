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


public class RepHotel extends JPanel
{

	JLabel lblPlaceName , lblGrade;
	JComboBox cmbPlaceName , cmbGrade;
	JButton butView,butCancel;
	public RepHotel()
	{
		setLayout(null);
		lblPlaceName = new JLabel("Place Name : ");
		lblPlaceName.setBounds(20,10,130,30);

		lblGrade = new JLabel("Grade : ");
		lblGrade.setBounds(20,50,130,30);

		cmbPlaceName = new JComboBox();
		cmbPlaceName.setBounds(130,10,150,25);

		cmbGrade = new JComboBox();
		cmbGrade.setBounds(130,50,150,25);
		cmbGrade.addItem("Star");
		cmbGrade.addItem("Duluxe");
		cmbGrade.addItem("Both");

		butView = new JButton("View Reports");
		butView.setBounds(20,90,120,30);

		butCancel = new JButton("Cancel");
		butCancel.setBounds(160,90,120,30);

		add(lblPlaceName);
		add(cmbPlaceName);
		add(lblGrade);
		add(cmbGrade);
		add(butView);
		add(butCancel);

		butView.addActionListener(new ALRephotel());
		butCancel.addActionListener(new ALRephotel());


	}//RepHotel constr

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
				  cmbPlaceName.addItem(rsPlace.getString(1));

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
		RepHotel rephotelobj = new RepHotel();
		JFrame frmrephotel = new JFrame("Hotel Reports");
		frmrephotel.setContentPane(rephotelobj);

		frmrephotel.setVisible(true);
		frmrephotel.setSize(310,170);

		WindowListener listener = new WindowAdapter()
				{
					public void windowClosing(WindowEvent wndEvt)
					{
						System.exit(0);
					}
				};

		frmrephotel.addWindowListener(listener);
	}//main

	public class ALRephotel implements ActionListener
	{
		public void actionPerformed(ActionEvent actEvt)
		{
			if(actEvt.getSource() == butView)
			{
				   Runtime iexp;
				   Process pro;
				   iexp = Runtime.getRuntime();

				   String sql = "";
				   String strcity = (String)cmbPlaceName.getSelectedItem();
				   String strgrade1 = (String)cmbGrade.getSelectedItem();
				   String strgrade = "";


				   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\fHotelList.html"};
				   try
				   {
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection  con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);


						if(strgrade1.equals("Both"))
						{
							strgrade = "Star/Deluxe";
							sql = "Select * from Hotel where HCity = ?";
						}
						else
						{
							strgrade = strgrade1;
							sql = "Select * from Hotel where HCity = ? and Grade = ?";
						}

						PreparedStatement stmt = con.prepareStatement(sql);

						if(strgrade1.equals("Both"))
						{
							stmt.setString(1,(String)strcity);
						}
						else
						{
							stmt.setString(1,(String)strcity);
							stmt.setString(2,(String)strgrade);
						}
						ResultSet rs = stmt.executeQuery();

						File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\HotelList.html");
						FileWriter out = new FileWriter(outFile);

						java.util.Date now = new java.util.Date();
						out.write("<html><head><title>Hotel Listing</title></html><body bgcolor=#d3d3d3><h4>");
						out.write("<table border=0 ><tr><td></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>HOTEL LISTING</u> </center></h2></td></tr><p>");
						out.write("<table border=0 align=center><tr><td>CITY: "+strcity+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td>GRADE: "+strgrade+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td> DATE: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1><p>");
						out.write("<table border = 1 width=100% bgcolor = #EEEEFF>");


						out.write("<th>Name &nbsp;&nbsp;");
						out.write("<th>Address &nbsp;&nbsp;&nbsp;&nbsp; </th>");
						out.write("<th>Phone#1&nbsp;&nbsp; </th>");
						out.write("<th>Phone#2&nbsp;&nbsp; </th>");
						out.write("<th>Email&nbsp;&nbsp; </th>");
						out.write("<th>Fax&nbsp;&nbsp;  </th>");
						out.write("<th>Ac Rate&nbsp;</th>");
						out.write("<th>NAc Rate&nbsp;</th>");
						while (rs.next())
						{
						out.write("<tr> <td>" +rs.getString(1)+"</td> <td>" +rs.getString(2)+"</td> <td>" +rs.getString(5)+"</td> <td>" +rs.getString(6)+"</td> <td>" +rs.getString(4)+"</td> <td>" +rs.getString(7)+"</td> <td>" +rs.getInt(9)+"</td> <td>" +rs.getInt(10)+"</td>");
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
	}//ALhotel


}//RepHotel