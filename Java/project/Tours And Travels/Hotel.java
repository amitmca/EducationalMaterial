import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;


public class Hotel extends JPanel
{
		JLabel lblHName,lblHAddr,lblHCity,lblHState,lblPh1,lblPh2,lblEmail,lblFax;
		JTextField txtHName,txtHAddr,txtHState,txtPh1,txtPh2,txtEmail,txtFax;
		JComboBox cmbHCity ;
		JButton butOk , butCancel;
		ImageIcon imgOk,imgCancel;
		Grade pnlGrade;
		Rate pnlRate;

	public Hotel()
	{
		setLayout(null);
		pnlGrade = new Grade();
		pnlRate = new Rate();

		Border border = BorderFactory.createEtchedBorder();
		Border gradeTitle = BorderFactory.createTitledBorder(border,"Grade :");
		Border rateTitle = BorderFactory.createTitledBorder(border,"Rate :");

		pnlGrade.setBorder(gradeTitle);
		pnlGrade.setBounds(20,210,220,50);

		pnlRate.setBorder(rateTitle);
		pnlRate.setBounds(270,210,220,100);


		lblHName = new JLabel("Name : ");
		lblHName.setBounds(20, 10 , 100,30);

		lblHAddr = new JLabel("Address : ");
		lblHAddr.setBounds(20, 50, 150,30);

		lblHCity = new JLabel("City : ");
		lblHCity.setBounds(20,90,100,30);

		lblHState = new JLabel("State : ");
		lblHState.setBounds(270,90 , 100,30);

		lblPh1 = new JLabel("Phone No1 : ");
		lblPh1.setBounds(20,130 , 100,30);

		lblPh2 = new JLabel("Phone No2 : ");
		lblPh2.setBounds(270,130 , 100,30);

		lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(20,170 , 100,30);

		lblFax = new JLabel("Fax : ");
		lblFax.setBounds(270,170 , 100,30);

		txtHName = new JTextField(100);
		txtHName.setBounds(120,10,370,25 );

		txtHAddr = new JTextField(300);
		txtHAddr.setBounds(120,50,370,25);

		txtPh1 = new JTextField(50);
		txtPh1.setBounds(120,130,120,25);

		txtPh2 = new JTextField(50);
		txtPh2.setBounds(370,130,120,25);

		txtEmail = new JTextField(50);
		txtEmail.setBounds(120,170,120,25);

		txtFax = new JTextField(50);
		txtFax.setBounds(370,170,120,25);

		cmbHCity = new JComboBox();
		cmbHCity.setBounds(120,90,120,25 );

		txtHState = new JTextField();
		txtHState.setEditable(false);
		txtHState.setBounds(370,90,120,25);

	//	imgOk = new ImageIcon("C:\\Rip\\Images\\ButtonGifOk.gif");
		butOk  = new JButton("Ok");
		butOk.setBounds(20,270,100,40);

		//imgCancel = new ImageIcon("C:\\Rip\\Images\\ButtonGifCancel.gif");
		butCancel = new JButton("Cancel");
		butCancel.setBounds(140,270,100,40);

		add(txtHName);
		add(txtHAddr);
		add(txtPh1);
		add(txtPh2);
		add(txtEmail);
		add(txtFax);


		add(lblHName);
		add(lblHAddr);
		add(lblHCity);
		add(lblHState);
		add(lblPh1);
		add(lblPh2);
		add(lblEmail);
		add(lblFax);

		add(cmbHCity);
		add(txtHState);

		add(butOk);
		add(butCancel);

		add(pnlGrade);
		add(pnlRate);

		butOk.addActionListener(new AHHotel ());
		butCancel.addActionListener(new AHHotel ());
		cmbHCity.addActionListener(new AHHotel());

	}//constructor

	public void connectcmbHCity()
	{
		String placeName;
		try
		{
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
		   Statement stmt = conn.createStatement();
		   String cmdPlace = "Select PName from Places";
		   ResultSet rsPlace = stmt.executeQuery(cmdPlace);
		   while(rsPlace.next())
		   {
			placeName = rsPlace.getString(1);
			cmbHCity.addItem(placeName);
		   }//while
 		}//try
		catch(Exception e)
		{
			System.out.println(e);
		}//catch
	}//connectcmbPlace

	// This method clears the Data after the record has been saved
	void clearData()
	{
	   txtHName.setText("") ;
	   txtHAddr.setText("") ;
	   cmbHCity.setSelectedItem("Pune") ;
	   txtEmail.setText("") ;
	   txtPh1.setText("");
	   txtPh2.setText("") ;
	   txtFax.setText("") ;
	   pnlGrade.radStar.setSelected(true);
	   pnlRate.txtAc.setText("") ;
	   pnlRate.txtNAc.setText("") ;
	   txtHName.requestFocus();

	}//End of clearData method
	public static void main(String []args)
	{
		JFrame frmHotel = new JFrame("Hotel Details");

		Hotel hotelobj = new Hotel();

		hotelobj.connectcmbHCity();
		Border border = new EmptyBorder(1,1,1,1);
		border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);
		hotelobj.setBorder(border);

		frmHotel.setContentPane(hotelobj);
		frmHotel.setSize(515,350);
		frmHotel.setResizable(false);
		frmHotel.setVisible(true);

		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent wndEvt)
			{
				System.exit(0);
			}
		};

		frmHotel.addWindowListener(listener);
	}//main

class AHHotel implements ActionListener
{
	public void actionPerformed(ActionEvent actEvt)
	{

		String placeState;
		if(actEvt.getSource() == cmbHCity)
		{
		 	try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn =  DriverManager.getConnection("jdbc:odbc:Tours",null,null);

				String cmdState = "Select State from Places where Pname = ?";

				PreparedStatement stmtState = conn.prepareStatement(cmdState);
				stmtState.setString(1,(String)cmbHCity.getSelectedItem());

				ResultSet rsState = stmtState.executeQuery();

				while(rsState.next())
				{
					placeState = rsState.getString(1);
					txtHState.setText(placeState);
				}//while
				stmtState.close();
				conn.close();

			}//try
			catch(Exception e)
  			{
				System.out.println(e);
			}//catch
		}//cmbHCity
		else
		if(actEvt.getSource() == butOk)
		{
			String temp;
			char ch;
			int i,len;
			temp = txtHName.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Hotel Name","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				txtHName.requestFocus();
				return;
			}

			temp = txtHAddr.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Hotel Address","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				txtHAddr.requestFocus();
				return;
			}

			temp = txtPh1.getText();
			if(temp.equals (""))
			{
				txtPh1.setText("-");
				//return;
			}

			temp = txtPh2.getText();
			if(temp.equals (""))
			{
				txtPh2.setText("-");
				//return;
			}

			temp = txtEmail.getText();
			if(temp.equals (""))
			{
				txtEmail.setText("-");
				//return;
			}

			temp = txtFax.getText();
			if(temp.equals (""))
			{
				txtFax.setText("-");
				//return;
			}


			temp = txtPh1.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch == ' ' || ch == '-' || ch == '(' || ch == ')' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Phone1","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						txtPh1.requestFocus();
						return;
					}
				}

			}

			temp = txtPh2.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch == ' ' || ch == '-' || ch == '(' || ch == ')' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Phone2","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						txtPh2.requestFocus();
						return;
					}
				}
			}

			temp = txtFax.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch == ' ' || ch == '-' || ch == '(' || ch == ')' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Fax","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						txtFax.requestFocus();
						return;
					}
				}

			}

			temp = pnlRate.txtAc.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Ac Rate","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				pnlRate.txtAc.requestFocus();
				return;
			}

			temp = pnlRate.txtAc.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				if(temp.charAt(len-1) == '.')
				{
					JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					pnlRate.txtAc.requestFocus();
				}
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Ac Rate","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						pnlRate.txtAc.setText("");
						pnlRate.txtAc.requestFocus();
						return;
					}
				}

			}


			temp = pnlRate.txtNAc.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter NAc Rate","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				pnlRate.txtNAc.setText("");
				pnlRate.txtNAc.requestFocus();
				return;
			}

			temp = pnlRate.txtNAc.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				if(temp.charAt(len-1) == '.')
				{
					JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					pnlRate.txtNAc.requestFocus();
				}
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Rates","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						pnlRate.txtNAc.requestFocus();
						return;
					}
				}

			}
			//Validate the cost of AC and Non-Ac Rooms
			String acRate,nonAcRate;
			acRate = pnlRate.txtAc.getText();
			nonAcRate = pnlRate.txtNAc.getText();
			int ret = acRate.compareTo(nonAcRate);
			 if (Integer.parseInt(nonAcRate)>Integer.parseInt(acRate) )
			 {
				 JOptionPane.showMessageDialog(null,"AC Rate should be Greater than Non-Ac Rate","Error",JOptionPane.ERROR_MESSAGE);
				 return;
			 }
			//Save Code
			String chkGrade="";
			if (pnlGrade.radStar.isSelected())
			{
				chkGrade = "Star";
			}
			else
			{
				chkGrade = "Deluxe";
			}

			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			String cmdInsert = "Insert into Hotel (HName ,HAddress,HCity ,HEmail, HPhNo1 , HPhNo2 , HFax , Grade , AcRate , NonAcRate) values('";
			String cmdValues = cmdInsert + txtHName.getText() + "','" +
							   txtHAddr.getText() + "','" +
							   cmbHCity.getSelectedItem() + "','" +
							   txtEmail.getText() + "','"  +
							   txtPh1.getText() + "','"  +
							   txtPh2.getText() + "','"  +
							   txtFax.getText() + "','"  +
							   chkGrade + "'," +
							   pnlRate.txtAc.getText() + "," +
							   pnlRate.txtNAc.getText()+ ")" ;

			Statement stmt = conn.createStatement();
			System.out.println(cmdValues);
			int ret1 = stmt.executeUpdate(cmdValues);
			JOptionPane.showMessageDialog(null,"Record has been Saved.","Save",JOptionPane.ERROR_MESSAGE);
			stmt.close();
			conn.close();
			//Clear the Controls on the screen
			clearData();
			}//try
			catch(java.sql.SQLException e1)
			{
				JOptionPane.showMessageDialog(null,"Entry Already Present.","Duplicate Value",JOptionPane.ERROR_MESSAGE);
				clearData();
			}

			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
			}//catch


		}//butOk
		else
		if(actEvt.getSource() == butCancel)
		{
			Tours.frmLog.setVisible(false);
			Tours.frmTours.setVisible(true);
			Tours.frmTours.setEnabled(true);
		}//butCancel
	}//actionPerformed
}//AHHotel



 public class Grade extends JPanel
{
	JRadioButton radStar , radDuluxe;
	public Grade()
	{

		setLayout(null);

		ButtonGroup grpGrade = new ButtonGroup();

		radStar = new JRadioButton("Star",true);
		radStar.setBounds(20 , 15 , 80 , 25);

		radDuluxe = new JRadioButton("Deluxe");
		radDuluxe.setBounds(120 , 15 , 80 , 25);

		grpGrade.add(radStar);
		grpGrade.add(radDuluxe);

		add(radStar);
		add(radDuluxe);
	}
}//Grade

public class Rate extends JPanel
{
	JLabel lblAc , lblNAc;
	JTextField txtAc , txtNAc;

	public Rate()
	{
		setLayout(null);

		lblAc = new JLabel("AC          :    Rs.");
		lblAc.setBounds(20,20,90,30);

		lblNAc = new JLabel("Non AC :    Rs.");
		lblNAc.setBounds(20,60,90,30);

		txtAc = new JTextField(50);
		txtAc.setBounds(110,20,100,25);

		txtNAc = new JTextField(50);
		txtNAc.setBounds(110,60,100,25);

		add(lblAc);
		add(lblNAc);
		add(txtAc);
		add(txtNAc);

	}
}//Rate

}//Hotel