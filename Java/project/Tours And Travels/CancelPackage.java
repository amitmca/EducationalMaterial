
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.TextArea;
import javax.swing.border.*;
import java.sql.*;
import javax.swing.table.*;
import java.awt.Toolkit.*;
import javax.swing.event.*;
import java.lang.Runtime.*;
import java.io.*;

public class CancelPackage extends JPanel
{
	JLabel lblCustCode,lblCustFName,lblCustLName,lblAddress,lblPackName,lblPackDate,lblPackType,lblAmt,lblDisc,lblBal,lblSeat;
	JTextField txtCustFName, txtCustLName,txtPackName,txtPackDate,txtPackType,txtAmt,txtDisc,txtBal,txtSeat;
	JTextField txtAddress;
	JComboBox cmbCustCode;
	JButton buttonOk , buttonCancel,buttonPrint;
	Members pnlMembers;
	Expend pnlExpend;

	public CancelPackage()
	{
		setLayout(null);

		pnlMembers = new Members();
		Border memBorder = BorderFactory.createEtchedBorder();
		Border memTitle = BorderFactory.createTitledBorder(memBorder,"Member Count :");


		pnlMembers.setBorder(memTitle);
		pnlMembers.setBounds(20,210,240,100);


		pnlExpend = new Expend();
		Border expBorder = BorderFactory.createEtchedBorder();
		Border expTitle = BorderFactory.createTitledBorder(expBorder,"Package Expenditure :");


		pnlExpend.setBorder(expTitle);
		pnlExpend.setBounds(280,210,220,100);


		lblCustCode = new JLabel("Customer Code : ");
		lblCustCode .setBounds(20,10,120,30);

		lblCustFName = new JLabel("First Name : ");
		lblCustFName .setBounds(20,50,120,30);

		lblCustLName = new JLabel("Last Name : ");
		lblCustLName .setBounds(280,50,120,30);

		lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(20,90,120,30);

		lblPackName = new JLabel("Package Name : ");
		lblPackName.setBounds(20,130,120,30);

		lblPackType = new JLabel("Package Type : ");
		lblPackType.setBounds(280,130,120,30);

		lblPackDate = new JLabel("Package Date : ");
		lblPackDate.setBounds(20,170,120,30);

		lblSeat = new JLabel("Seat Status : ");
		lblSeat.setBounds(280,170,120,30);

		lblAmt = new JLabel("Amount Paid : Rs. ");
		lblAmt.setBounds(20,210,120,30);

		lblBal = new JLabel("Balance : Rs. ");
		lblBal.setBounds(280,210,120,30);

		txtCustFName = new JTextField (50);
		txtCustFName.setBounds(140,50,120,25);
		txtCustFName.setEditable(false);

		txtCustLName = new JTextField (50);
		txtCustLName.setBounds(380,50,120,25);
		txtCustLName.setEditable(false);

		txtAddress = new JTextField (300);
		txtAddress.setBounds(140,90,360,25);
		txtAddress.setEditable(false);

		txtPackName = new JTextField(50);
		txtPackName.setBounds(140,130,120,25);
		txtPackName.setEditable(false);

		txtPackType = new JTextField(50);
		txtPackType.setBounds(380,130,120,25);
		txtPackType.setEditable(false);

		txtPackDate = new JTextField(50);
		txtPackDate.setBounds(140,170,120,25);
		txtPackDate.setEditable(false);

		txtSeat = new JTextField(50);
		txtSeat.setBounds(380,170,120,25);
		txtSeat.setEditable(false);

		txtAmt = new JTextField(50);
		txtAmt.setBounds(140,210,120,25);
		txtAmt.setEditable(false);

		txtBal = new JTextField(50);
		txtBal.setBounds(380,210,120,25);
		txtBal.setEditable(false);

		cmbCustCode = new JComboBox();
		cmbCustCode .setBounds(140,10,120,25);

		buttonOk = new JButton("Ok");
		buttonOk.setBounds(100,250,80,30);

		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(320,250,80,30);

		buttonPrint = new JButton("Refund Slip");
		buttonPrint.setBounds(200,250,100,30);
		buttonPrint.setEnabled(false);

		//Add labels to panel
		add(lblCustFName);
		add(lblCustLName);
		add(lblCustCode);
		add(lblAddress);
		add(txtCustFName);
		add(txtCustLName);
		add(cmbCustCode);
		add(txtAddress);
		add(lblPackName);
		add(lblPackType);
		add(lblPackDate);
		add(txtPackName);
		add(txtPackType);
		add(txtPackDate);
		add(lblSeat);
		add(txtSeat);
		//add(pnlMembers);
		//add(pnlExpend);
		add(lblAmt);
		add(lblBal);
		add(txtAmt);
		add(txtBal);
		add(buttonOk);
		add(buttonCancel);
		add(buttonPrint);
		//Add the Action Listeners
		cmbCustCode.addActionListener(new AHCancelPack());
		buttonOk.addActionListener(new AHCancelPack());
		buttonCancel.addActionListener(new AHCancelPack());
		buttonPrint.addActionListener(new AHCancelPack());

	}//Constructor


	public void setDbConnection()
	{
		String custCode;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement stmt = con.createStatement();
			String cmdCust = "Select custno from Booking where Cancelled = 'NO'";
			ResultSet rsCust = stmt.executeQuery(cmdCust);
			while (rsCust.next())
			{
				custCode = rsCust.getString(1);
				cmbCustCode.addItem(custCode);
			}
			stmt.close();
			con.close();
		} //try

		catch (Exception e)
		{
			System.out.println(e);
		}// End of catch block
	}//setDbConnection

	public void ClearFields()
	{
	//txtCustFName, txtCustLName,txtPackName,txtPackDate,txtPackType,txtAmt,txtDisc,txtBal,txtSeat
		txtCustFName.setText("");
		txtCustLName.setText("");
		txtAddress.setText("");
		txtPackName.setText("");
		txtPackDate.setText("");
		txtPackType.setText("");
		txtAmt.setText("");
		txtDisc.setText("");
		txtBal.setText("");
		txtSeat.setText("");
	}//ClearFields

	public static void main(String []args)
	{

	    CancelPackage cancelPack = new CancelPackage();
	    cancelPack.setDbConnection();
		Border border = new EmptyBorder(1,1,1,1);
		border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);
		//set the label on to the Frame
		JFrame frm = new JFrame("Cancel Package");
		frm.setResizable(false);
		frm.setContentPane(cancelPack);
		frm.setSize(525,320);
		cancelPack.setBorder(border);
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
	class AHCancelPack implements ActionListener
{
	public String custFName,custLName,custAdd;
		public void actionPerformed(ActionEvent actEvt)
		{
			if(actEvt.getSource() == cmbCustCode)
			{

				try
				{

					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

					String cmdCustDetails = "Select CustFirstName,CustLastName,CustAddress from Customer where CustNo = ?";
					PreparedStatement cancelStmt = con.prepareStatement(cmdCustDetails);
					cancelStmt.setString(1,(String)cmbCustCode.getSelectedItem());
					ResultSet rsCustDetails = cancelStmt.executeQuery();
					while(rsCustDetails.next())
					{
						custFName =  rsCustDetails.getString(1);
						txtCustFName.setText(custFName);

						custLName =  rsCustDetails.getString(2);
						txtCustLName.setText(custLName);

						custAdd =  rsCustDetails.getString(3);
						txtAddress.setText(custAdd);

					}
					cancelStmt.close();

					java.util.Date now = new java.util.Date();
					//String cmdCustDetails1 = "Select PackName , PackType , PackFromDate ,Seat from Booking where custno=? and PackFromDate > ?";

					String cmdCustDetails1 = "Select PackName , PackType , PackFromDate ,Seat,TotalAmtDisc , Balance from Booking where custno = ?";
					PreparedStatement cancelStmt1 = con.prepareStatement(cmdCustDetails1);
					cancelStmt1.setString(1,(String)cmbCustCode.getSelectedItem());
					//cancelStmt1.setDate(2,now);
					ResultSet rsCustDetails1 = cancelStmt1.executeQuery();
					while(rsCustDetails1.next())
					{
						String PackName = rsCustDetails1.getString(1);
						txtPackName.setText(PackName);

						String PackType = rsCustDetails1.getString(2);
						txtPackType.setText(PackType);

						String PackDate = rsCustDetails1.getString(3);
						txtPackDate.setText(PackDate);

						String strSeat = rsCustDetails1.getString(4);
						txtSeat.setText(strSeat);

						String strAmt = rsCustDetails1.getString(5);
						txtAmt.setText(strAmt);

						String strBal = rsCustDetails1.getString(6);
						txtBal.setText(strBal);

					}
					cancelStmt1.close();
					con.close();

			    }//try

			    catch(Exception e)
			    {
					 System.out.println(e);
				}//catch

			}//cmbCustCode

			if(actEvt.getSource() ==  buttonOk)
			{
				int CNum = 0, ANum = 0;
				int numSeats = 0;
				String strSeats="";
				String seatStatus = (String)txtSeat.getText();
/*------------------------------------------------------------------------------------------*/
				//decrease the number of seats in PackageDate
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

					String cmdSeat = "Select SeatsLeft from PackageDate where PackName = ? and FromDate = ?";
					PreparedStatement stmtSeat = con.prepareStatement(cmdSeat);
					stmtSeat.setString(1,(String)txtPackName.getText());
					stmtSeat.setString(2,(String)txtPackDate.getText());

					ResultSet rsSeat = stmtSeat.executeQuery();
					while (rsSeat.next())
					{
						 strSeats = rsSeat.getString(1);

					}
					numSeats = Integer.parseInt(strSeats);
					System.out.println("numSeats = "+ numSeats);
					stmtSeat.close();

					String cmdSeat1 = "Select ChildNum , AdultNum from Booking where CustNo = ? and PackName = ? and PackType = ? and PackFromDate = ?";
					PreparedStatement stmtSeat1 = con.prepareStatement(cmdSeat1);
					stmtSeat1.setString(1,(String)cmbCustCode.getSelectedItem());
					stmtSeat1.setString(2,(String)txtPackName.getText());
					stmtSeat1.setString(3,(String)txtPackType.getText());
					stmtSeat1.setString(4,(String)txtPackDate.getText());

					ResultSet rsSeat1 = stmtSeat1.executeQuery();
					while (rsSeat1.next())
					{
						String strChildNum = rsSeat1.getString(1);
						String strAdultNum = rsSeat1.getString(2);
						CNum = Integer.parseInt(strChildNum);
						System.out.println("CNum = " + CNum);
						ANum = Integer.parseInt(strAdultNum);
						System.out.println("ANum = " + ANum);
					}

					stmtSeat1.close();

					int NewSeatNum = numSeats + (CNum + ANum);
					System.out.println("NewSeatNum = " + NewSeatNum);

					String updSeats = "UPDATE PackageDate "
									   + "SET SeatsLeft = " + NewSeatNum
									   + " WHERE PackName = '" + txtPackName.getText() + "'"
									   + " and PackType = '" + txtPackType.getText() + "'"
									   + " and FromDate = #" + txtPackDate.getText() + "#";

					System.out.println("updSeats = " + updSeats);
					Statement stmtUpdSeat = con.createStatement();
					int rsUpdSeat = stmtUpdSeat.executeUpdate(updSeats);

					stmtUpdSeat.close();
					con.close();
				} //try

				catch (Exception e)
				{
					System.out.println(e);
				}// End of catch block

/*------------------------------------------------------------------------------------------*/
				//set Cancelled Field in Booking Table as Cancelled
				try {
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

						Statement stmtupd = con.createStatement();
						String cmdUpd = "Update Booking Set Cancelled = 'YES' where "
										+ "CustNo = '" + (String)cmbCustCode.getSelectedItem()
										+ "' and PackName = '" + txtPackName.getText()
										+ "' and PackType = '" + txtPackType.getText() + "'"
										+  " and PackFromDate = # " + txtPackDate.getText() + "#" ;

						System.out.println("cmdUpd = " + cmdUpd);
						int rsUpd = stmtupd.executeUpdate(cmdUpd);

						stmtupd.close();
						con.close();
					} //try

					catch (Exception e)
					{
						System.out.println(e);
					}//catch
/*------------------------------------------------------------------------------------------*/
				if(seatStatus.equals("Reserved"))
				{
					JOptionPane.showMessageDialog(null,"Booking Cancelled. Amount not Refundable.","Seats Reserved",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				else
				{
					buttonPrint.setEnabled(true);
					JOptionPane.showMessageDialog(null,"Booking Cancelled.","Cancel Booking",JOptionPane.INFORMATION_MESSAGE);
					return;
				}//else
			}//buttonOk
			else
			if(actEvt.getSource() == buttonPrint)
			{
				   buttonPrint.setEnabled(false);

				   Runtime iexp;
				   Process pro;
				   iexp = Runtime.getRuntime();

				   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","c:\\Rip\\RefundSlip.html"};
				   try
				   {
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection  con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

						File outFile = new File("c:\\Rip\\RefundSlip.html");
						FileWriter out = new FileWriter(outFile);

						java.util.Date now = new java.util.Date();
						out.write("<html><head><title>Refund Slip</title></html><body bgcolor=#d3d3d3><h4>");
						out.write("<table border=0 ><tr><td><img src='c:\\rip\\images\\tower.bmp'></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>REFUND SLIP</u> </center></h2></td></tr><p>");
						out.write("<table border=0 align=center><tr><td><b> DATE: "+now + "</b></tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h1><p>");
						out.write("<table border = 1 align=center width=70%");
						out.write("<tr><td><p><font size = 4><p> To  Mr/Mrs/Ms   <u><i><b>"+ txtCustFName.getText() + " " + txtCustLName.getText() +"</u></i></b>");
						out.write("   the  amount  of  Rs.  <u><b>"+ txtAmt.getText()+"</u></b>");
						out.write("   has  been  refunded  for  the  cancellation  of  the  package  <u><b>"+ txtPackName.getText()+"</u></b>");
						out.write("   starting  on    <u><b>"+ txtPackDate.getText()+" .</u></b><p><p><p>");
						out.write("   Signed  By  : </font></td>");
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

			}//buttonPrint
			else
			if(actEvt.getSource() == buttonCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//ButtonCancel

		}
	}//AHCancelPack


	public class Members extends JPanel
	{
		JLabel lblAdult ,lblChild;
		JTextField txtAdult , txtChild;

		public Members()
		{
			setLayout(null);

			lblAdult = new JLabel("No. Of Adults : ");
			lblAdult.setBounds(20,20,120,30);

			lblChild = new JLabel("No. Of Children : ");
			lblChild.setBounds(20,60,120,30);

			txtAdult = new JTextField(50);
			txtAdult.setBounds(130,20,90,25);
			txtAdult.setEditable(false);

			txtChild = new JTextField(50);
			txtChild.setBounds(130,60,90,25);
			txtChild.setEditable(false);

			add(lblAdult);
			add(lblChild);
			add(txtAdult);
			add(txtChild);

		}
	}//Members


	public class Expend extends JPanel
	{
		JLabel lblAdult,lblChild;
		JTextField txtAdultAmt , txtChildAmt;
		public Expend()
		{
			setLayout(null);

			lblAdult = new JLabel("Adult : Rs. ");
			lblAdult.setBounds(20,20,120,30);

			lblChild = new JLabel("Child : Rs. ");
			lblChild.setBounds(20,60,120,30);

			txtAdultAmt = new JTextField(50);
			txtAdultAmt.setBounds(110,20,90,25);
			txtAdultAmt.setEditable(false);

			txtChildAmt = new JTextField(50);
			txtChildAmt.setBounds(110,60,90,25);
			txtChildAmt.setEditable(false);

			add(lblChild);
			add(lblAdult);
			add(txtAdultAmt);
			add(txtChildAmt);
		}
	}//Expend

}//Cancel Package
