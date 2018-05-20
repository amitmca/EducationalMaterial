
// This screen accepts the Source Place and the Budget      		   //
// and creates a report showing the Packages statisfying the constraint	   //

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


public class RepPackPlace extends JPanel
{
	JLabel lblSrcPlace ,  lblBudget , lblDateFrom ;
	JComboBox cmbSrcPlace;
	JTextField txtBudget;
	JButton buttonOk , buttonCancel;
	DateComboBox dateFrom;



	public RepPackPlace() // Constructor begins
	{
		setLayout(null);


		lblSrcPlace = new JLabel("Destination Place: ");
		lblSrcPlace.setBounds(20,10,130,30);
		lblSrcPlace.setSize(130,30);

		cmbSrcPlace = new JComboBox();
		cmbSrcPlace.setSize(130,25);
		cmbSrcPlace.setBounds(135,10,130,25);

		lblBudget = new JLabel("Budget : ");
		lblBudget.setSize(150,30);
		lblBudget.setBounds(20,50,130,30);

		txtBudget = new JTextField(10);
		txtBudget.setSize(130,30);
		txtBudget.setBounds(135,50,130,25);

		lblDateFrom = new JLabel("Date from : ");
		lblDateFrom.setSize(130,25);
		lblDateFrom.setBounds(20,90,130,30);

		dateFrom = new DateComboBox();
		dateFrom.setBounds(135,90,130,25);


		buttonOk = new JButton("     Ok     ");
		buttonOk.setSize(100,30);
		buttonOk.setBounds(40,150,100,30);

		buttonCancel = new JButton("Cancel");
		buttonCancel.setSize(100,30);
		buttonCancel.setBounds(150,150,100,30);


		//Add labels to panel
		add(lblSrcPlace);
		add(cmbSrcPlace);

		add(lblBudget);
		add(txtBudget);

		add(lblDateFrom);
		add(dateFrom);
		add(buttonOk);
		add(buttonCancel);

		//Add the Action Listeners

		buttonOk.addActionListener(new AHupdCust());    //For the Ok button
		buttonCancel.addActionListener(new AHupdCust());    //For the CANCEL button

	}//End of the Constructor

	public void setDbConnection() // This method connects to the Database
	{
		String place;
		//Connect to the Places table in the Tours Database
				try {
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
						Statement stmt = con.createStatement();
						String cmdPlace = "Select distinct PlaceName from PackagePlace";
						ResultSet rsPlace = stmt.executeQuery(cmdPlace);
						while (rsPlace.next())
						{
							place = rsPlace.getString(1);
							cmbSrcPlace.addItem(place);
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

	    	RepPackPlace repPack = new RepPackPlace();
	    	repPack.setDbConnection();
		JFrame frm = new JFrame("Package Listing");
		frm.setContentPane(repPack);
		frm.setSize(290,350);
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
		      String strSql="" , strWhereBud="", strWhereDate="";
			//Connect to the Places table in the Tours Database
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				Statement stmt = con.createStatement();

				//Determine the data entered

				strSql = "Select distinct P.packname , PP.placename, ExpenditureAdult, FromDate  from Package P, PackagePlace PP, PackageDate PD where P.packname = PP.packname and P.packname= PD.packname and PP.placename='" + cmbSrcPlace.getSelectedItem()+"'";
				if (txtBudget.getText()!=null)
				{
                  strWhereBud = " and ExpenditureAdult Between 0 and " + txtBudget.getText();

				}

				if (dateFrom.getSelectedItem()!=null)
				{
				  strWhereDate = " and  FromDate =#" + dateFrom.getSelectedItem() +"#";
				}

				strSql = strSql + strWhereBud + strWhereDate ;
				showList(strSql);



				} // End of try block

				catch (Exception e)
				{
					System.out.println(e);
				}// End of catch block



			// Generate the Report


			}//End of buttonOk Event

			if(actEvt.getSource() == buttonCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//End of ButtonCancel

		}
	}//AHupdCust


public static void showList(String strSql)
 {
   Runtime iexp;
   Process pro;
   iexp = Runtime.getRuntime();
   Statement stmt = null;
   Connection con = null;
   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","d:\\Tours And Travels\\Tours And Travels\\PackBugList.html"};
   try
   {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
        stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(strSql);

        File outFile = new File("d:\\Tours And Travels\\Tours And Travels\\PackBugList.html");
        FileWriter out = new FileWriter(outFile);

		java.util.Date now = new java.util.Date();
        out.write("<html><head><title>Package-Budget Listing</title></html><body bgcolor=#d3d3d3><h4>");
        out.write("<table border=0 ><tr><td><img src='d:\\Tours And Travels\\Tours And Travels\\images\\people.jpg'></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>PACKAGE-BUDGET  LISTING</u> </center></h2></td></tr><p>");
        out.write("<table border=0 align=right><tr><td > Date: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>");
        out.write("<table border = 1 width=100% bgcolor = #EEEEFF>");


		out.write("<th>Package &nbsp;&nbsp;");
		out.write("<th>Places Visited&nbsp;&nbsp;&nbsp;&nbsp; </th>");
		out.write("<th>Expenditure(per person)</th>");
		out.write("<th>Date&nbsp;&nbsp;&nbsp;&nbsp; </th>");

		String strPack,strPName= "",strPlace="";

while (rs.next())
   {
	    strPName= "";strPlace="";strPack="";
        strPack = rs.getString(1);
		strPlace ="Select distinct placename from PackagePlace where PackName='" +strPack  + "'";

		Statement stmtPlace = con.createStatement();
		ResultSet rsPlace = stmtPlace.executeQuery(strPlace);

		 while(rsPlace.next())
		        {
					strPName = strPName+" "+rsPlace.getString("placename");
		}
		out.write("<tr> <td>" +strPack+"</td> <td>" +strPName + " </td> <td>"+"&nbsp;"+rs.getInt(3) +"</td> <td>" +rs.getDate(4) +" </td>");
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

  }//end

}//Update CustomerFrm
