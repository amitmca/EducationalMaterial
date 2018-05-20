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

public class RepPlaceName extends JPanel
{
	JLabel lblPlace;
	JComboBox cmbPlace;
	JButton butView , butCancel;

	RepPlaceName()
	{
		setLayout(null);
		lblPlace = new JLabel("Place : ");
		lblPlace.setBounds(20,10,100,30);

		cmbPlace = new JComboBox();
		cmbPlace.setBounds(100,10,150,25);
		cmbPlace.setEditable(true);

		butView = new JButton("View Report");
		butView.setBounds(20,50,120,30);

		butCancel = new JButton("Cancel");
		butCancel.setBounds(150,50,100,30);

		add(lblPlace);
		add(cmbPlace);
		add(butView);
		add(butCancel);

		butView.addActionListener(new ALRepPlaceName());
		butCancel.addActionListener(new ALRepPlaceName());
	}//const

	public void connectcmbPlace()
	{
		try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				Statement stmt = conn.createStatement();
				String cmdPlace = "Select distinct PName from Places";
				ResultSet rsPlace = stmt.executeQuery(cmdPlace);
				while(rsPlace.next())
				{
				  cmbPlace.addItem(rsPlace.getString(1));

				}//while
				stmt.close();
				conn.close();
			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}//catch
	}//connectcmbPlace

	public static void main(String []args)
	{
		RepPlaceName repPlaceobj = new RepPlaceName();
		JFrame frmrepPlace = new JFrame("Place Reports");
		frmrepPlace.setContentPane(repPlaceobj);
		repPlaceobj.connectcmbPlace();
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

	public class ALRepPlaceName implements ActionListener
	{
		public void actionPerformed(ActionEvent actEvt)
		{
			if(actEvt.getSource() == butView)
			{
			   Runtime iexp;
			   Process pro;
			   iexp = Runtime.getRuntime();

			   String sql = "";
			   String strplace = (String)cmbPlace.getSelectedItem();

			   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\PlaceList.html"};
			   try
			   {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection  con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
					sql = "select * from Places where PName = ?";
					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1,(String)strplace);
					ResultSet rs = stmt.executeQuery();

					File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\PlaceList.html");//d:\\Tours And Travels\\Tours And Travels\\PlaceList.html
					FileWriter out = new FileWriter(outFile);

					java.util.Date now = new java.util.Date();
					out.write("<html><head><title>Hotel Listing</title></html><body bgcolor=#d3d3d3><h4>");
					out.write("<table border=0 ><tr><td></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>PLACE LISTING</u> </center></h2></td></tr><p><p><p>");
					out.write("<table border=0 align=center><tr><td> DATE: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1><p>");

					while (rs.next())
					{
					out.write("<table border=0 align=left><tr><td>PLACE NAME    : </td><td> "+ rs.getString(1) + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1>");
					out.write("<table border=0 align=left><tr><td>STATE NAME    : </td><td> "+ rs.getString(2) + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1>");
					out.write("<table border=0 align=left><tr><td>SEASON FROM   : </td><td> "+ rs.getString(4) + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1>");
					out.write("<table border=0 align=left><tr><td>SEASON TO     : </td><td> "+ rs.getString(5) + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1>");
					out.write("<table border=0 align=left><tr><td>TEMPERATURE   : </td><td> "+ rs.getString(3) + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1>");
					out.write("<table border=0 align=left><tr><td>RAINFALL      : </td><td> "+ rs.getString(7) + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1>");
					out.write("<table border=0 align=left><tr><td>TOURIST SPOTS : </td><td> "+ rs.getString(6) + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1>");
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
	}//ALRepPlaceName

}//RepPlaceName