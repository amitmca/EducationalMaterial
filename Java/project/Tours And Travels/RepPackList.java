
// This screen accepts the package name
// and creates a report showing either all the Packages or the ones selected by the user.

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension.*;
import java.awt.TextArea;
import javax.swing.border.*;
import java.sql.*;
import java.lang.Runtime.*;
import java.io.*;
import java.sql.*;

public class RepPackList extends JPanel
{
	JRadioButton radAll , radSingle;
	JButton buttonOk , buttonCancel;
	JComboBox cmbPack;
	public static String strPackName="";


	public RepPackList () // Constructor begins
	{
		setLayout(null);

		ButtonGroup grpPack = new ButtonGroup();

		radAll = new JRadioButton ("All Packages ",true);
		radAll.setBounds(20,10,130,30);

		radSingle = new JRadioButton ("Package Name ",false);
		radSingle.setBounds(20,50,120,30);


		grpPack.add(radAll);
		grpPack.add(radSingle);

		cmbPack = new JComboBox();
		cmbPack.setSize(130,30);
		cmbPack.setBounds(145,50,130,25);
		cmbPack.setVisible(false);


		buttonOk = new JButton("View Report");
		buttonOk.setSize(100,30);
		buttonOk.setBounds(20,120,120,30);

		buttonCancel = new JButton("Cancel");
		buttonCancel.setSize(100,30);
		buttonCancel.setBounds(150,120,100,30);


		//Add labels to panel
		add(radAll);
		add(radSingle);
		add(cmbPack);
		add(buttonOk);
		add(buttonCancel);

		//Add the Action Listeners

		buttonOk.addActionListener(new AHupdCust());    //For the Ok button
		buttonCancel.addActionListener(new AHupdCust());    //For the CANCEL
//button
		radAll.addActionListener(new AHupdCust());
		radSingle.addActionListener(new AHupdCust());
	}//End of the Constructor

	public void setDbConnection() // This method connects to the Database
	{
		String place;
		//Connect to the Places table in the Tours Database
				try {
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
						Statement stmt = con.createStatement();
						String cmdPlace = "Select distinct PackName from Package";
						ResultSet rsPlace = stmt.executeQuery(cmdPlace);
						while (rsPlace.next())
						{
							place = rsPlace.getString(1);
							cmbPack.addItem(place);
						}
						stmt.close();
						con.close();


					} // End of try block

					catch (Exception e)
					{
						System.out.println(e);
					}// End of catch block



	} // End of DbConnection mthd

	public static void main(String []args)
	{

		RepPackList repPackList = new RepPackList ();
		repPackList.setDbConnection();
		JFrame frm = new JFrame("Package Listing");
		frm.setContentPane(repPackList);
		frm.setSize(290,200);
		Dimension dim = frm.getToolkit().getScreenSize();
		frm.setLocation(dim.width/2 - frm.getWidth()/2 ,
				    dim.height/2 - frm.getHeight()/2 );
		frm.setVisible(true);



		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent wndEvt)
			{
				System.exit(0);
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

//Execute this code if the Ok button is clicked by the User
			if(actEvt.getSource() ==  buttonOk)
			{
			//determine the radio buton selection


			String strSql="";

			if(radAll.isSelected() == true)
			{
				strSql ="Select * from Package";

			}
			else
			{
				strPackName = (String)cmbPack.getSelectedItem();
				strSql ="Select * from Package where PackName='" + strPackName + "'";


			}

			// Generate the Report

			RepPackList.showList(strSql); // Call the method to display the report


			}//End of buttonOk Event

			if(actEvt.getSource() == buttonCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//End of ButtonCancel

			if(actEvt.getSource() ==  radAll)
			{
				cmbPack.setVisible(false);

			} // End of radAll

			if(actEvt.getSource() ==  radSingle)
			{
				cmbPack.setVisible(true);
			} // End of radPack


		}
	}//AHupdCust


// Method to Disaply the Report
public static void showList(String strSql)
 {
   Runtime iexp;
   Process pro;

   iexp = Runtime.getRuntime();
   Statement stmt = null;
   Connection con = null;
   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\RepPackList.html"};
   try
   {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(strSql);


        File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\RepPackList.html");
        FileWriter out = new FileWriter(outFile);

		java.util.Date now = new java.util.Date();
        out.write("<html><head><title>Package Listing</title></html><body bgcolor=#d3d3d3><h4>");
        out.write("<table border=0 ><tr><td><img src='D:\\Tours And Travels\\Tours And Travels\\images\\people.jpg'></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>PACKAGE LISTING</u> </center></h2></td></tr><p>");
        out.write("<table border=0 align=right><tr><td > Date: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>");
        out.write("<table border = 1 width=100% bgcolor = #EEEEFF>");


		out.write("<th>Package Name &nbsp;&nbsp;");
		out.write("<th>Type </th>");
		out.write("<th>Starting Place &nbsp;&nbsp;</th>");
		out.write("<th>Places Visited&nbsp;&nbsp;&nbsp;&nbsp; </th>");
		out.write("<th>Total Days &nbsp;&nbsp; </th>");
		out.write("<th>Capacity &nbsp;&nbsp;   </th>");
		out.write("<th>Adult Cost &nbsp;&nbsp; </th>");
		out.write("<th>Child Cost&nbsp;&nbsp; </th>");


		String strPName="",strPlace="";

while (rs.next())
    {
		String strPack = rs.getString("PackName");
        strPlace ="Select Distinct placename from PackagePlace where PackName='" +strPack  + "'";

        Statement stmtPlace= con.createStatement();
        ResultSet rsPlaces = stmtPlace.executeQuery(strPlace);

		strPName ="";strPlace="";
        while(rsPlaces.next())
        {
			strPName = strPName+" "+rsPlaces.getString("placename");
		}

		//out.write("<tr> <td>" +rs.getString("PackName")+"</td> <td>" +rs.getString("PackType") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp"+rs.getString("StartingPlace") +"</td> <td>" +"&nbsp;"+strPName+"</td> <td>" +"&nbsp;"+rs.getInt("NoOfDays")+"</td> <td>" +"&nbsp;&nbsp;"+rs.getInt("NoOfPeople")+"</td> <td>"+"&nbsp;"+rs.getInt("ExpenditureAdult") + "</td> <td>"+"&nbsp;"+rs.getInt("ExpenditureChild") +"</td>");
		out.write("<tr> <td>" +strPack+"</td> <td>" +rs.getString("PackType")+ "</td> <td>"+rs.getString("StartingPlace")+"&nbsp;" +"</td> <td>" + strPName +"</td> <td>" +rs.getInt("NoOfDays")+"</td> <td>" +rs.getInt("NoOfPeople")+"</td> <td>"+rs.getInt("ExpenditureAdult") + "</td> <td>"+rs.getInt("ExpenditureChild") +"</td>");
	}


		out.write("</table>");
		out.write("</body></html>");
        out.close();
        pro = iexp.exec(en);

       pro.waitFor();
	stmt.close();
	con.close();

   } // end of try

   catch(Exception e)
   {
        System.out.println(e);
   }

  }//end of ShowList

}//RepPackList form
