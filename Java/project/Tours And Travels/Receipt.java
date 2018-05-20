import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Calendar.*;

public class Receipt extends JPanel
{

		JLabel lblRNo,lblRDate,lblCName,lblPName,lblPType,lblPDate,lblAmt,lblMode,lblTerm,lblSign,lblDetails,lblCNo;
		JTextField txtRNo,txtRDate,txtCName,txtPName,txtPType,txtPDate,txtAmt,txtSign,txtDetails;
		JComboBox cmbMode,cmbTerms,cmbCNo,cmbPName;
		JButton butOk,butCancel;
		ImageIcon imgOk,imgCancel;

	Receipt()
		{
		setLayout(null);

		//Labels
		lblRNo = new JLabel("Receipt Number : ");
		lblRNo.setBounds(20,10,120,30);

		txtRNo = new JTextField(20);
		txtRNo.setBounds(140,10,120,25);
		txtRNo.setEditable(false);

		lblRDate = new JLabel("Receipt Date : ");
		lblRDate.setBounds(280,10,120,30);

		txtRDate = new JTextField(20);
		txtRDate.setBounds(390,10,130,25);


		java.util.Calendar rightNow = java.util.Calendar.getInstance();
		int day = rightNow.get(java.util.Calendar.DAY_OF_MONTH);
		int month = rightNow.get(java.util.Calendar.MONTH);
		month++;
		int year = rightNow.get(java.util.Calendar.YEAR);
		txtRDate.setText(day +"/"+month+"/" +year );
		txtRDate.setEditable(false);

		lblCNo = new JLabel("Customer No. : ");
		lblCNo.setBounds(20,50,120,30);

		cmbCNo = new JComboBox();
		cmbCNo.setBounds(140,50,120,25);

		lblCName = new JLabel("Cust Name : ");
		lblCName.setBounds(280,50,120,30);

		txtCName = new JTextField(50);
		txtCName.setBounds(390,50,130,25);
		txtCName.setEditable(false);

		lblPName = new JLabel("Package Name : ");
		lblPName.setBounds(20,90,120,30);

		cmbPName = new JComboBox();
		cmbPName.setBounds(140,90,120,25);
		cmbPName.setEditable(false);

		lblPType = new JLabel("Package Type : ");
		lblPType.setBounds(280,90,120,30);

		txtPType = new JTextField(50);
		txtPType.setBounds(390,90,130,25);
		txtPType.setEditable(false);

		lblPDate = new JLabel("Package Date : ");
		lblPDate.setBounds(20,130,120,30);

		txtPDate = new JTextField(50);
		txtPDate.setBounds(140,130,120,25);
		txtPDate.setEditable(false);

		lblAmt = new JLabel("Amount : Rs. ");
		lblAmt.setBounds(280,130,120,30);

		txtAmt = new JTextField(20);
		txtAmt.setBounds(390,130,130,25);

		lblMode = new JLabel("Payment Mode : ");
		lblMode.setBounds(20,170,120,30);

		cmbMode = new JComboBox();
		cmbMode.addItem("Cash");
		cmbMode.addItem("Cheque");
		cmbMode.addItem("D.D");
		cmbMode.setBounds(140,170,120,25);

		lblTerm = new JLabel("Payment Term : ");
		lblTerm.setBounds(280,170,120,30);

		cmbTerms = new JComboBox();
		cmbTerms.addItem("Full");
		cmbTerms.addItem("Part");
		cmbTerms.setBounds(390,170,130,25);

		lblDetails = new JLabel("Payment Details : ");
		lblDetails.setBounds(20,210,120,30);

		txtDetails = new JTextField(300);
		txtDetails.setBounds(140,210,375,25);

		lblSign = new JLabel("Signed By : ");
		lblSign.setBounds(20,250,120,30);

		txtSign = new JTextField(100);
		txtSign.setBounds(140,250,120,25);

		//Buttons
		//imgOk = new ImageIcon("D:\\Tours And Travels\\Tours And Travels\\Images\\ButtonGifOk.gif");
	//	imgCancel = new ImageIcon("D:\\Tours And Travels\\Tours And Travels\\Images\\ButtonGifCancel.gif");
		butOk = new JButton("Ok");
		butOk.setBounds(300,250,100,40);
		butCancel = new JButton("Cancel");
		butCancel.setBounds(420,250,100,40);

		//add
		add(lblRNo);
		add(txtRNo);
		add(lblRDate);
		add(txtRDate);
		add(lblCNo);
		add(cmbCNo);
		add(lblAmt);
		add(txtAmt);
		add(lblCName);
		add(txtCName);
		add(lblPName);
		add(cmbPName);
		add(lblPType);
		add(txtPType);
		add(lblPDate);
		add(txtPDate);
		add(lblMode);
		add(cmbMode);
		add(lblTerm);
		add(cmbTerms);
		add(lblDetails);
		add(txtDetails);
		add(lblSign);
		add(txtSign);
		add(butOk);
		add(butCancel);

		butOk.addActionListener(new AHReceipt());
		butCancel.addActionListener(new AHReceipt());
		cmbCNo.addActionListener(new AHReceipt());
		cmbPName.addActionListener(new AHReceipt());

	}//constructor

	//This method displays a New Receipt number
	public void DisplayNo()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement stmt =conn.createStatement();
			String cmdRNo = "Select count(*) as ReceiptNo from Receipt";
			ResultSet rsReceiptNo = stmt.executeQuery(cmdRNo);
			int rno = 0 ;
			String temp="";
			while(rsReceiptNo.next())
			{
					rno = rsReceiptNo.getInt(1);
			}//End of while
			rno ++ ;
			temp = temp + rno ;
			txtRNo.setText(temp);
			stmt.close();
			conn.close();
	}//try

	 catch(Exception e)
	 {
				JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
	 }//End of catch block


	}//End of DisplayNo()
	public void connectCmbCNo()
	{
		String custCode;
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
		String cmdCust = "Select distinct CustNo from Booking";
		Statement stmt = conn.createStatement();
		ResultSet rsCust = stmt.executeQuery(cmdCust);
		while(rsCust.next())
		{
			custCode = rsCust.getString(1);
			cmbCNo.addItem(custCode);
		}//while
		stmt.close();
		conn.close();
		}//try
		catch(Exception e)
		{
			System.out.println(e);
		}//catch

	}//connectCmbCNo

	public static void main(String []args)
	{
		Receipt receiptobj = new Receipt();
		receiptobj.connectCmbCNo();
		JFrame frmreceipt = new JFrame("Receipt Details");
		frmreceipt.setContentPane(receiptobj);
		frmreceipt.setSize(540,320);
		//frmreceipt.setLocation(80,110);
		frmreceipt.setResizable(false);
		frmreceipt.setVisible(true);
		receiptobj.DisplayNo();

		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent wndEvt)
			{
				System.exit(0);
			}
		};

		frmreceipt.addWindowListener(listener);
	}//main

	class AHReceipt implements ActionListener
	{
		public void actionPerformed(ActionEvent actEvt)
		{
			String custFName , custLName;
			int cntNoRec = 0;
			int BAmtPaid = 0, BBal = 0;
			if(actEvt.getSource()==cmbCNo)
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

					String cmdNameDetails = "Select CustFirstName ,	CustLastName from Customer where CustNo = ?";
					PreparedStatement stmtNameDetails =	conn.prepareStatement(cmdNameDetails);
					stmtNameDetails.setString(1,(String)cmbCNo.getSelectedItem());
					ResultSet rsCustName = stmtNameDetails.executeQuery();

					while(rsCustName.next())
					{
						custFName = rsCustName.getString(1);
						custLName = rsCustName.getString(2);
						txtCName.setText(custFName + " " + custLName);
					}//while

					stmtNameDetails.close();

					String cmdPackDetails = "Select PackName from Booking where CustNo = ?";
					PreparedStatement stmtPackDetails =	conn.prepareStatement(cmdPackDetails);
					stmtPackDetails.setString(1,(String)cmbCNo.getSelectedItem());
					ResultSet rsPack = stmtPackDetails.executeQuery();

					cmbPName.removeAllItems();
					while(rsPack.next())
					{
						cmbPName.addItem(rsPack.getString(1));
					}

					stmtPackDetails.close();
					conn.close();
				}//try
				catch(Exception e)
				{
					System.out.println(e);
				}//catch
			}//cmbCNo
			else
			if(actEvt.getSource()==cmbPName)
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

					String cmdPackDts = "Select PackType , PackFromDate from Booking where CustNo = ? and PackName = ?";
					PreparedStatement stmtPackDts =	conn.prepareStatement(cmdPackDts);
					stmtPackDts.setString(1,(String)cmbCNo.getSelectedItem());
					stmtPackDts.setString(2,(String)cmbPName.getSelectedItem());
					ResultSet rsPackDts = stmtPackDts.executeQuery();

					while(rsPackDts.next())
					{
						txtPType.setText(rsPackDts.getString(1));
						txtPDate.setText(rsPackDts.getString(2));
					}

					stmtPackDts.close();
					conn.close();

				}//try
				catch(Exception e)
				{
					System.out.println(e);
				}

			}//cmbPName
			else
			if(actEvt.getSource()==butOk)
			{
				String temp;
				int i,len;
				char ch;
				temp = txtAmt.getText();
				if(temp.equals (""))
				{
					JOptionPane.showMessageDialog(null,"Enter Amount Paid","Incomplete Information",JOptionPane.ERROR_MESSAGE);
					txtAmt.requestFocus();
					return;
				}

				temp = txtAmt.getText();
				if(!(temp.equals("")))
				{
					len = temp.length();
					if(temp.charAt(len-1) == '.')
					{
						JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						txtAmt.requestFocus();
					}
					for(i =0;i<len;i++)
					{
						ch = temp.charAt(i);
						if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
						{
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Enter Numerical Value For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							txtAmt.setText("");
							txtAmt.requestFocus();
							return;
						}
					}

				}

				try
						{
							int AmtPD = 0;
							int Bal = 0;
							int AmtP =0;
							int AmtRN = Integer.parseInt(txtAmt.getText());
							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

							String cmdAmt = "Select TotalAmtDisc ,AmtPaid, Balance From Booking where CustNo = ? and PackName = ? and PackType = ? and PackFromDate = ?";
							PreparedStatement Astmt = conn.prepareStatement(cmdAmt);
							Astmt.setString(1,(String)cmbCNo.getSelectedItem());
							Astmt.setString(2,(String)cmbPName.getSelectedItem());
							Astmt.setString(3,(String)txtPType.getText());
							Astmt.setString(4,(String)txtPDate.getText());
							ResultSet rsAmt = Astmt.executeQuery();

							while(rsAmt.next())
							{
								AmtPD = Integer.parseInt(rsAmt.getString(1));
								AmtP = Integer.parseInt(rsAmt.getString(2));
								Bal = Integer.parseInt(rsAmt.getString(3));
							}

							if(AmtRN < 0)
							{
								JOptionPane.showMessageDialog(null,"Amount Paid should be > 0","Incorrect Value",JOptionPane.ERROR_MESSAGE);
								txtAmt.requestFocus();
								return;
							}

							if(AmtRN > Bal)
							{
								JOptionPane.showMessageDialog(null,"Amount Paid should be <= Rs. " + Bal,"Incorrect Value",JOptionPane.ERROR_MESSAGE);
								txtAmt.requestFocus();
								return;
							}


							Astmt.close();
							conn.close();



						}//try
						catch(Exception e2)
						{
							System.out.println(e2);
						}//catch


				temp = txtSign.getText();
				if(temp.equals (""))
				{
					JOptionPane.showMessageDialog(null,"Enter Signature","Incomplete Information",JOptionPane.ERROR_MESSAGE);
					txtSign.requestFocus();
					return;
				}
		//Save the record to the table

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

			String cmdCnt = "Select count(*) as Rcnt from Receipt where CustNo = ? and PackName = ? and PackType = ? and PackDate = ?";
			PreparedStatement bstmt = conn.prepareStatement(cmdCnt);
			bstmt.setString(1,(String)cmbCNo.getSelectedItem());
			bstmt.setString(2,(String)cmbPName.getSelectedItem());
			bstmt.setString(3,(String)txtPType.getText());
			bstmt.setString(4,(String)txtPDate.getText());
			ResultSet rsCnt = bstmt.executeQuery();

			while(rsCnt.next())
			{
				cntNoRec = rsCnt.getInt(1);
			}

			//if receipt not issued 1st time
			if(cntNoRec != 0)
			{
				String cmdBooking = "Select AmtPaid, Balance From Booking where CustNo = ? and PackName = ? and PackType = ? and PackFromDate = ?";
				PreparedStatement b1stmt = conn.prepareStatement(cmdBooking);
				b1stmt.setString(1,(String)cmbCNo.getSelectedItem());
				b1stmt.setString(2,(String)cmbPName.getSelectedItem());
				b1stmt.setString(3,(String)txtPType.getText());
				b1stmt.setString(4,(String)txtPDate.getText());
				ResultSet rsBook = b1stmt.executeQuery();

				while(rsBook.next())
				{
					BAmtPaid = Integer.parseInt(rsBook.getString(1));
					BBal = Integer.parseInt(rsBook.getString(2));
				}

				int RAmt = Integer.parseInt(txtAmt.getText());

				BBal = BBal - RAmt;
				BAmtPaid = BAmtPaid + RAmt;

				String updBooking = "Update Booking set AmtPaid = " + BAmtPaid +
									" , Balance = " + BBal +
									" where CustNo = '" + cmbCNo.getSelectedItem() + "'" +
									" and PackName = '" + cmbPName.getSelectedItem() + "'" +
									" and PackType = '" + txtPType.getText() + "'" +
									" and PackFromDate = #" + txtPDate.getText() + "#";
				System.out.println("Update : " + updBooking);
				Statement updStmt = conn.createStatement();
				int rsupd = updStmt.executeUpdate(updBooking);
				b1stmt.close();

			}

			Statement stmt =conn.createStatement();
			String cmdInsert = "Insert into Receipt(RNo,Rdate,CustNo,Amt,PaymentMode,PaymentDetails,SignedBy,PaymentTerms,PackName,PackType,PackDate,Issued) values(";
			String cmdValues  = cmdInsert +
 								txtRNo.getText() + ",'"+
 								txtRDate.getText() +"','"+
								cmbCNo.getSelectedItem() + "',"+
								txtAmt.getText() +",'"+
								cmbMode.getSelectedItem() + "','"+
								txtDetails.getText() +"','"+
								txtSign.getText() +"','"+
								cmbTerms.getSelectedItem() + "','" +
								cmbPName.getSelectedItem() + "','" +
								txtPType.getText() + "','" +
								txtPDate.getText() + "'," +
								"'NO')"  ;
								System.out.println(cmdValues);

			int rsReceipt = stmt.executeUpdate(cmdValues);
			JOptionPane.showMessageDialog(null,"Record has been saved","Saved",JOptionPane.INFORMATION_MESSAGE);
			stmt.close();
			conn.close();
			DisplayNo();
		 }//End of try block


		 catch(Exception e)
		 {
			 JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
		 }//End of catch block

}//butOk
			else
			if(actEvt.getSource()==butCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//butCancel
		}//actionPerformed
	}//AHReceipt
}//Receipt

