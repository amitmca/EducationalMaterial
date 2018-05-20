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

public class RepReceipt extends JPanel
{

	JLabel lblCustNo , lblCustNF, lblCustNL, lblType ,lblPackName;
	JComboBox cmbCustNo , cmbPackName  ;
	JTextField txtCustNF , txtCustNL, txtType;
	JButton butView,butCancel;
	public RepReceipt()
	{
		setLayout(null);
		lblCustNo = new JLabel("Customer No : ");
		lblCustNo.setBounds(20,10,130,30);

		lblCustNF = new JLabel("First Name : ");
		lblCustNF.setBounds(20,50,130,30);

		lblCustNL = new JLabel("Last Name : ");
		lblCustNL.setBounds(20,90,130,30);

		lblPackName = new JLabel("Package : ");
		lblPackName.setBounds(20,130,130,30);

		lblType = new JLabel("Package Type : ");
		lblType.setBounds(20,170,130,30);

		cmbCustNo = new JComboBox();
		cmbCustNo.setBounds(130,10,150,25);

		txtCustNF = new JTextField(50);
		txtCustNF.setBounds(130,50,150,25);
		txtCustNF.setEditable(false);

		txtCustNL = new JTextField(50);
		txtCustNL.setBounds(130,90,150,25);
		txtCustNL.setEditable(false);

		cmbPackName = new JComboBox();
		cmbPackName.setBounds(130,130,150,25);

		txtType = new JTextField();
		txtType.setBounds(130,170,150,25);
		txtType.setEditable(false);


		butView = new JButton("View Reports");
		butView.setBounds(20,210,120,30);

		butCancel = new JButton("Cancel");
		butCancel.setBounds(160,210,120,30);

		add(lblCustNo);
		add(cmbCustNo);
		add(lblCustNF);
		add(txtCustNF);
		add(lblCustNL);
		add(txtCustNL);
		add(lblPackName);
		add(cmbPackName);
		add(lblType);
		add(txtType);

		add(butView);
		add(butCancel);

		butView.addActionListener(new ALRepReceipt());
		butCancel.addActionListener(new ALRepReceipt());
		cmbCustNo.addActionListener(new ALRepReceipt());
		cmbPackName.addActionListener(new ALRepReceipt());

	}//RepReceipt constr

	public void connectcmbCustNo()
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				Statement stmt = conn.createStatement();
				String cmdCust = "Select DISTINCT CustNo from Receipt";
				ResultSet rsCust = stmt.executeQuery(cmdCust);
				while(rsCust.next())
				{
				  cmbCustNo.addItem(rsCust.getString(1));

				}//while
				stmt.close();
				conn.close();
			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}//catch
		}//connectcmbCustNo


	public void connectCustNames()
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				String cmdCust = "Select DISTINCT CustFirstName , CustLastName, PackName, CustAddress from Customer,Receipt " +
				 " where Customer.CustNo = Receipt.CustNo and Issued = 'NO' and Receipt.CustNo = ?";

				PreparedStatement pstmt = conn.prepareStatement(cmdCust);
				String strCust= (String)cmbCustNo.getSelectedItem();
				pstmt.setString(1,strCust);
				String custAdd ="";

				ResultSet rsCust = pstmt.executeQuery();
				cmbPackName.removeAllItems();
				while(rsCust.next())
				{
				  txtCustNF.setText(rsCust.getString(1));
				  txtCustNL.setText(rsCust.getString(2));
				  cmbPackName.addItem(rsCust.getString(3));
				  custAdd = rsCust.getString(4) ;

				}//while
				pstmt.close();
				conn.close();
			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}//catch
		}//connectcmbRefDb

public void setPackType()
{
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
		String cmdCust = "Select PackType from Receipt , Customer " +
		 " where Customer.CustNo = Receipt.CustNo and Receipt.CustNo = ? and PackName = ?";

		PreparedStatement pstmt = conn.prepareStatement(cmdCust);
		String strCust= (String)cmbCustNo.getSelectedItem();
		String strPack= (String)cmbPackName.getSelectedItem();
		pstmt.setString(1,strCust);
		pstmt.setString(2,strPack);

		ResultSet rsCust = pstmt.executeQuery();

	while(rsCust.next())
	{
		txtType.setText(rsCust.getString(1));
	}
	}//try
	catch(Exception e)
	{
			System.out.println(e);
	}//catch
	}//setPackType

	public static void main(String []args)
	{
		RepReceipt repReceiptobj = new RepReceipt();
		JFrame frmrepReceipt = new JFrame("Receipt Reports");
		frmrepReceipt.setContentPane(repReceiptobj);
		repReceiptobj.connectcmbCustNo();
		frmrepReceipt.setVisible(true);
		frmrepReceipt.setSize(310,280);

		WindowListener listener = new WindowAdapter()
				{
					public void windowClosing(WindowEvent wndEvt)
					{
						Tours.frmLog.setVisible(false);
						Tours.frmTours.setVisible(true);
						Tours.frmTours.setEnabled(true);
					}
				};

		frmrepReceipt.addWindowListener(listener);
	}//main

	public class ALRepReceipt implements ActionListener
	{
		public void actionPerformed(ActionEvent actEvt)
		{
			if(actEvt.getSource() == butView)
			{
				//Diplay the Report
			   Runtime iexp;
			   Process pro;
			   iexp = Runtime.getRuntime();
			   FileWriter out= null;;
			   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\Receipt.html"};//c:\\Rip\\Receipt.html
			   try
			   {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection  con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

					String sqlR = "Select Rno,Amt,PaymentMode,PaymentTerms," +
					" CustAddress,PackDate from Receipt,Customer where " +
					" Receipt.CustNo = Customer.CustNo and Receipt.CustNo = ? and PackName = ? and PackType =?";

					PreparedStatement rstmt = con.prepareStatement(sqlR);
					String strCNo= (String)cmbCustNo.getSelectedItem();
					String strPName= (String)cmbPackName.getSelectedItem();
					String strPType = (String)txtType.getText();

					rstmt.setString(1,strCNo);
					rstmt.setString(2,strPName);
					rstmt.setString(3,strPType);

					ResultSet rsReceipt = rstmt.executeQuery();

					String rno ="";

					File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\Receipt.html");
					out = new FileWriter(outFile);
					java.util.Date now = new java.util.Date();
					out.write("<html><head><title>Receipt</title></html><body bgcolor=#d3d3d3><h4>");
					out.write("<table border=0 align=center><tr><td></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>RECEIPT</u> </center></h2></td></tr><p>");


					while(rsReceipt.next())
					{
						rno = rsReceipt.getString(1);

					out.write("<table border=0 align=left><tr><td><b>Receipt Number: "+ rno +" &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp DATE: "+now + "</b></tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1>");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("<table border = 1 align=center width=70%");

					out.write("<tr><td><p><font size = 4><p> To  Mr/Mrs/Ms   <u><i><b>"+ txtCustNF.getText() + " " + txtCustNL.getText() +"</u></i></b>");
					out.write("<u><i><b> " +rsReceipt.getString(5) +  "</u></i></b>, the  sum  of  Rs.  <u><b>"+ rsReceipt.getInt(2)+"</u></b>");
					out.write(" by <u><b> "+rsReceipt.getString(3)  +"</u></b> in <u><b>" +rsReceipt.getString(4)  + "</u></b>");
					out.write(" for the Package <u><b>" + cmbPackName.getSelectedItem()  +"</u></b> starting  on  <u><b>"+ rsReceipt.getString(6) +" .</u></b><p><p><p>");
					out.write("   Signed  By  : </font></td>");
					out.write("</table>");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("<p><p>");
					out.write("==========================================================");
					out.write("<br>");

					//Update Issued = "YES"

					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection  conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
						Statement stmtUp = conn.createStatement();
						String sqlUp = "Update Receipt set Issued = 'YES' where " +
						"RNo = '" + rno + "'";

						int rsUp = stmtUp.executeUpdate(sqlUp);
						stmtUp.close();
						conn.close();
					}



					}
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

			if(actEvt.getSource() == cmbCustNo)
			{
				connectCustNames();

			}//cmbCustNo

			if(actEvt.getSource() == butCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//butCancel
			else
			if(actEvt.getSource() == cmbPackName)
			{
				setPackType();
		    }
		}//actionPerformed
	}//ALReceipt


}//RepReceipt
