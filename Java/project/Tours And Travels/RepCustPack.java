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


public class RepCustPack extends JPanel
{

	JLabel lblPackName , lblPackDate ,lblType;
	JComboBox cmbPackName , cmbPackDate , cmbType;
	JButton butView,butCancel;
	static JFrame frmrepcust ;
	public RepCustPack()
	{
		//setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		setLayout(null);
		//setLayout(new GridLayout(10,10));
		lblPackName = new JLabel("Package Name : ");
		lblPackName.setBounds(20,10,130,30);

		lblPackDate = new JLabel("Package From : ");
		lblPackDate.setBounds(20,50,130,30);

		lblType = new JLabel("Package Type : ");
		lblType.setBounds(20,90,130,30);

		cmbPackName = new JComboBox();
		cmbPackName.setBounds(130,10,180,25);

		cmbPackDate = new JComboBox();
		cmbPackDate.setBounds(130,50,180,25);

		cmbType = new JComboBox();
		cmbType.setBounds(130,90,180,25);
		cmbType.addItem("Budget");
		cmbType.addItem("Luxury");

		butView = new JButton("View Reports");
		butView.setBounds(50,130,120,30);

		butCancel = new JButton("Cancel");
		butCancel.setBounds(180,130,120,30);

		add(lblPackName);
		add(cmbPackName);
		add(lblPackDate);
		add(cmbPackDate);
		add(lblType);
		add(cmbType);
		add(butView);
		add(butCancel);

		butView.addActionListener(new ALRepCust());
		butCancel.addActionListener(new ALRepCust());
		cmbPackName.addItemListener(new ILRepCust());

	}//RepCustPack constr

	public void connectcmbDate()
		{

			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

				String cmdPack = "Select fromdate from PackageDate where packname = ?";
				PreparedStatement stmt = conn.prepareStatement(cmdPack);

				String pnm = (String)cmbPackName.getSelectedItem();
				stmt.setString(1,(String)pnm);
				cmbPackDate.removeAllItems();
				ResultSet rsPack = stmt.executeQuery();
				while(rsPack.next())
				{

				  cmbPackDate.addItem(rsPack.getString(1));
				}//while
				stmt.close();
				conn.close();
			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}//catch
		}//connectcmbRefDb


	public void connectcmbName()
		{

			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				Statement stmt = conn.createStatement();
				String cmdPack = "Select distinct packname from Package";
				ResultSet rsPack = stmt.executeQuery(cmdPack);
				while(rsPack.next())
				{
				  cmbPackName.addItem(rsPack.getString(1));

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
		RepCustPack repcustobj  = new RepCustPack();
		 frmrepcust = new JFrame("Package wise Customer Listing");
		frmrepcust.setContentPane(repcustobj);
		frmrepcust.setVisible(true);
		frmrepcust.setSize(340,200);

		WindowListener listener = new WindowAdapter()
				{
					public void windowClosing(WindowEvent wndEvt)
					{
						System.exit(0);
					}
				};

		frmrepcust.addWindowListener(listener);
	}//main

	public class ALRepCust implements ActionListener
	{
		public void actionPerformed(ActionEvent actEvt)
		{
			if(actEvt.getSource() == butView)
			{
			Runtime iexp;
   Process pro;
   iexp = Runtime.getRuntime();

   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\CustPack.html"};
   try
   {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection  con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
        Statement stmt = con.createStatement();
        String sql  = "Select Customer.CustNo , CustFirstName,CustLastName,Occupation, Age,CustAddress,PhNo1,PhNo2,Email,Fax,HealthConstraints from " +
		"Customer , Booking  " +
 		 " where Customer.CustNo = Booking.CustNo "+
		" and Booking.PackName='"  +cmbPackName.getSelectedItem() +"'" +
		" and Booking.PackFromDate=#" +cmbPackDate.getSelectedItem() +"#" +
		" and Booking.PackType='"+ cmbType.getSelectedItem() +"'";

        ResultSet rs = stmt.executeQuery(sql);

        File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\CustPack.html");
        FileWriter out = new FileWriter(outFile);

        java.util.Date now = new java.util.Date();
        out.write("<html><head><title>Package wise Customer Listing</title></html><body bgcolor=#d3d3d3><h4>");
        out.write("<table border=0 ><tr><td><img src='D:\\Tours And Travels\\Tours And Travels\\images\\people.jpg'></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>CUSTOMER LISTING</u> </center></h2></td></tr><p>");
        out.write("<table border=0 align=right><tr><td > Date: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>");
        out.write("<table border = 1 width=100% bgcolor = #EEEEFF>");


		out.write("<th>Number &nbsp;&nbsp;");
		out.write("<th>Name &nbsp;&nbsp;&nbsp;&nbsp; </th>");
		out.write("<th>Age</th>");
		out.write("<th>Address&nbsp;&nbsp;&nbsp;&nbsp; </th>");
		out.write("<th>Phone#1&nbsp;&nbsp; </th>");
		out.write("<th>Phone#2&nbsp;&nbsp;   </th>");
		out.write("<th>Occupation&nbsp;&nbsp; </th>");
		out.write("<th>Email&nbsp;&nbsp; </th>");
		out.write("<th>Fax&nbsp;&nbsp;  </th>");
		out.write("<th>Health Constraints&nbsp;&nbsp;</th>");

while (rs.next())
        {

            out.write("<tr> <td>" +rs.getString("CustNo")+"</td> <td>" +rs.getString("CustFirstName") +"&nbsp;"+rs.getString("CustLastName") +"</td> <td>" +rs.getInt("Age")+"</td> <td>" +rs.getString("CustAddress")+"</td> <td>" +rs.getString("PhNo1")+"</td> <td>" +rs.getString("PhNo2")+"</td> <td>" +rs.getString("Occupation")+"</td> <td>" +rs.getString("Email")+"</td> <td>" +rs.getString("Fax")+"</td> <td>" +rs.getString("HealthConstraints")+"</td>");

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
	}//ALRepCust

	public class ILRepCust implements ItemListener
	{
		public void itemStateChanged(ItemEvent evt)
			{
				if (evt.getSource() == cmbPackName)
				{
					connectcmbDate();
				}//cmbPackDate
			}

	}//ILRepCust

}//RepCustPack