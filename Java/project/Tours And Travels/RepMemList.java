
// 			This screen accepts the Customer Code and Dispalys information         //
//			about the Members  			   //

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension.*;
import java.awt.TextArea;
import javax.swing.border.*;
import java.sql.*;
import java.lang.Runtime.*;
import java.io.*;

public class RepMemList extends JPanel
{
	JLabel lblCustCode ,  lblCustFName , lblCustLName , lblAddress ,lblPackages,lblPhoto;
	JTextField txtCustFName, txtCustLName;
	TextArea  txtAddress,txtPackages;
	JComboBox cmbCustCode;
	JButton buttonOk , buttonCancel;
	ImageIcon imgPhoto;
	String photoPath;
	static JFrame frm ;

	public RepMemList() // Constructor begins
	{
		setLayout(null);

		photoPath = "";
		imgPhoto = new ImageIcon(photoPath);
		lblPhoto = new JLabel("",imgPhoto,JLabel.CENTER);
		lblPhoto.setBounds(280,10,190,230);

		lblCustCode = new JLabel("Customer Code : ");
		lblCustCode .setBounds(20,10,100,30);

		lblCustFName = new JLabel("First Name : ");
		lblCustFName .setBounds(20,50,100,30);

		lblCustLName = new JLabel("Last Name : ");
		lblCustLName .setBounds(20,90,100,30);

		lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(20,130,100,30);

		lblPackages = new JLabel("Packages: ");
		lblPackages.setBounds(20,190,100,30);

		txtCustFName = new JTextField (50);
		txtCustFName.setBounds(120,50,150,25);
		txtCustFName.setEditable(false);

		txtCustLName = new JTextField (50);
		txtCustLName.setBounds(120,90,150,25);
		txtCustLName.setEditable(false);

		txtAddress = new TextArea ("",5,400,1);
		txtAddress.setBounds(120,135,150,50);
		txtAddress.setEditable(false);

		txtPackages = new TextArea ("",5,400,1);
		txtPackages.setBounds(120,200,150,50);
		txtPackages.setEditable(false);

		cmbCustCode = new JComboBox();
		cmbCustCode .setBounds(120,10,150,25);

		buttonOk = new JButton("View Report");
		buttonOk.setBounds(140,275,120,30);

		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(290 ,275,80,30);

		//Add labels to panel
		add(lblPhoto);
		add(lblCustFName);
		add(lblCustLName);
		add(lblCustCode);
		add(lblAddress);
		add(lblPackages);
		add(txtCustFName);
		add(txtCustLName);
		add(cmbCustCode);
		add(txtAddress);
		add(txtPackages);
		add(buttonOk);
		add(buttonCancel);
		//Add the Action Listeners
		cmbCustCode.addActionListener(new AHupdCust()); //For the Customer Id
		buttonOk.addActionListener(new AHupdCust());    //For the Ok button
		buttonCancel.addActionListener(new AHupdCust());    //For the CANCEL button

	}//End of the Constructor

	public void setDbConnection() // This method connects to the Database
	{
		String custCode;
		//Connect to the Customer table in the Tours Database
				try {
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
						Statement stmt = con.createStatement();
						String cmdCust = "Select custno from Booking";
						ResultSet rsCust = stmt.executeQuery(cmdCust);
						while (rsCust.next())
						{
							custCode = rsCust.getString(1);
							cmbCustCode.addItem(custCode);
						}
						stmt.close();
						con.close();


					} // End of try block

					catch (Exception e)
					{
						System.out.println(e);
					}// End of catch block
}

	public static void mainFunc()
	{

	    RepMemList	meminfo = new RepMemList();
	    meminfo.setDbConnection();
		Border border = new EmptyBorder(1,1,1,1);
		border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);
		//set the label on to the Frame
		frm = new JFrame("Member Details");
		frm.setResizable(false);
		frm.setContentPane(meminfo);
		frm.setSize(500,350);
		Dimension dim = frm.getToolkit().getScreenSize();
		frm.setLocation(dim.width/2 - frm.getWidth()/2 ,
					    dim.height/2 - frm.getHeight()/2 );

		meminfo.setBorder(border);
		frm.setVisible(true);



		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent wndEvt)
			{
				frm.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);;
			}
		};

		frm.addWindowListener(listener);


	}//End of Main

	//Implement the Action Listener
	class AHupdCust implements ActionListener
{
	public String custFName,custLName,custAdd,custPackages;
		public void actionPerformed(ActionEvent actEvt)
		{

//Execute this code if the Combo box content changes
			if(actEvt.getSource() ==  cmbCustCode)
			{

				//Refresh the Customer details
				try
				{

					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

					//Request for the connection
					Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

					//Prepare the qquery
					String cmdCustDetails = "Select custfirstname,custlastname,custaddress,Photo from customer where custno=?";
					PreparedStatement updCustStmt = con.prepareStatement(cmdCustDetails);

					//Bind the variable to the required string
					updCustStmt.setString(1,(String)cmbCustCode.getSelectedItem());
					ResultSet rsCustDetails = updCustStmt.executeQuery();

					//Loop thru' the resultset
					while(rsCustDetails.next())
					{
						custFName =  rsCustDetails.getString(1);
						txtCustFName.setText(custFName);

						custLName =  rsCustDetails.getString(2);
						txtCustLName.setText(custLName);

						custAdd =  rsCustDetails.getString(3);
						txtAddress.setText(custAdd);

					/*	custPackages =  rsCustDetails.getString(4);
						txtPackages.setText(custPackages);*/

						photoPath =  rsCustDetails.getString(4);
						imgPhoto = new ImageIcon(photoPath);
						lblPhoto.setIcon(imgPhoto);
					}



					updCustStmt.close();
					con.close();

			    }//End of try block

			    catch(Exception e)
			    {
					 System.out.println(e);
				}//End of catch block

			}//End of cmbCustCode Event

//Execute this code if the Ok button is clicked by the User
			if(actEvt.getSource() ==  buttonOk)
			{
//Display the Report
						//Display the Report

			   Runtime iexp;
			   Process pro;
			   iexp = Runtime.getRuntime();

			   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\Members.html"};
			   try
			   {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection  con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);


					Statement stmtCust = con.createStatement();
					String sqlCust  = "Select CustFirstName, CustLastName from " +
					" Customer where CustNo = '"+ cmbCustCode.getSelectedItem() +"'";

					ResultSet rsCust = stmtCust.executeQuery(sqlCust);


					File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\Members.html");
					FileWriter out = new FileWriter(outFile);

					java.util.Date now = new java.util.Date();
					out.write("<html><head><title>Customer wise Member Listing</title></html><body bgcolor=#d3d3d3><h4>");
					out.write("<table border=0 ><tr><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>MEMBER LISTING</u> </center></h2></td></tr><p>");
					out.write("<table border=0 align=right><tr><td > Date: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>");
					out.write("<table border = 1 width=100% bgcolor = #EEEEFF>");

					while(rsCust.next())
					{
						out.write("Customer Code " + cmbCustCode.getSelectedItem() +"<p>");
						out.write("Customer Name " + rsCust.getString(1) + " " + rsCust.getString(2) +"<p>");
					}

					System.out.println("After Cust Name");
					stmtCust.close();

					Statement stmt = con.createStatement();
					String sql  = "Select MemFirstName,MemLastName,"+
					" HealthConstraints,Age,TransportDetails from " +
					" Members  " +
					" where CustNo ='" + cmbCustCode.getSelectedItem() +"'";

					ResultSet rs = stmt.executeQuery(sql);

					out.write("<th>Name &nbsp;&nbsp;&nbsp;&nbsp; </th>");
					out.write("<th>Age</th>");
					out.write("<th>Health Constraints&nbsp;&nbsp;</th>");
					out.write("<th>Transport Details&nbsp;&nbsp;</th>");

			while (rs.next())
				{

						out.write("<tr> <td>" +rs.getString("MemFirstName") +
						"&nbsp;"+rs.getString("MemLastName")+
						"</td> <td>" +
						rs.getInt("Age")+
						"</td> <td>" +
						rs.getString("HealthConstraints")
						+"</td> <td>" +rs.getString("TransportDetails")+
						"</td>");

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



			}//End of buttonOk Event

			if(actEvt.getSource() == buttonCancel)
			{
				frm.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//End of ButtonCancel

		}
	}//AHupdCust

}//Update CustomerFrm
