import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class Transport extends JPanel
{
	JLabel lblMode,lblSource,lblDest,lblDepart,lblArrive,lblDays,lblDist,lblName;
	JRadioButton radRail , radRoad , radAir;
	JComboBox cmbSource , cmbDest;
	JTextField txtDays , txtDist, txtName,txtDepart , txtArrive ,txtId;
	JButton butOk , butCancel;
	ImageIcon imgOk , imgCancel;
	Expend pnlExpend;
	Days pnlDays;

	public Transport()
	{
		setLayout(null);

		pnlExpend = new Expend();
		pnlDays = new Days();

		Border expBorder = BorderFactory.createEtchedBorder();
		Border expTitle = BorderFactory.createTitledBorder(expBorder,"Expenditure :");

		pnlExpend.setBorder(expTitle);
		pnlExpend.setBounds(20,210,340,130);

		pnlDays.setBorder(expBorder);
		pnlDays.setBounds(380,170,120,230);

//labels
		lblMode = new JLabel("Mode : ");
		lblMode.setBounds(20,10,80,30);

		lblName = new JLabel("Id & Name : ");
		lblName.setBounds(20,50,80,30);

		lblSource = new JLabel("Start : ");
		lblSource.setBounds(20,90,100,30);

		lblDest = new JLabel("Destination : ");
		lblDest.setBounds(260,90,120,30);

		lblDepart = new	JLabel("Departure Time : ");
		lblDepart.setBounds(20,130,100,30);

		lblArrive = new JLabel("Arrival Time : ");
		lblArrive.setBounds(260,130,120,30);

		lblDays = new JLabel("Travel Days : ");
		lblDays.setBounds(260,170,120,30);

		lblDist = new JLabel("Distance (Kms) : ");
		lblDist.setBounds(20,170,120,30);

//RadioButtons
		ButtonGroup grpMode = new ButtonGroup();
		radRail = new JRadioButton("Railway",true);
		radRail.setBounds (130,10,80,30);

		radAir = new JRadioButton("Airway");
		radAir.setBounds (260,10,80,30);

		radRoad = new JRadioButton("Road");
		radRoad.setBounds (380,10,60,30);

		grpMode.add(radRail);
		grpMode.add(radAir);
		grpMode.add(radRoad);

//ComboBoxes
		cmbSource = new JComboBox();
		cmbSource.setBounds(130,90,120,25);

		cmbDest = new JComboBox();
		cmbDest.setBounds(380,90,120,25);

		txtDepart = new JTextField();
		txtDepart.setBounds(130,130,120,25);

		txtArrive = new JTextField();
		txtArrive.setBounds(380,130,120,25);

//TextBoxes
		txtName = new JTextField(300);
		txtName.setBounds(260,50,240,25);

		txtId = new JTextField(50);
		txtId.setBounds(130,50,120,25);

		txtDist = new JTextField(50);
		txtDist.setBounds(130,170,120,25);

//Buttons
	//	imgOk = new ImageIcon("E:\\Tours And Travels\\image\\save1.gif");
		butOk  = new JButton("Ok");
		butOk.setBounds(100,360,100,40);

		//imgCancel = new ImageIcon("d:\\Tours And Travels\\Tours And Travels\\Images\\ButtonGifCancel.gif");
		butCancel = new JButton("Cancel");
		butCancel.setBounds(220,360,100,40);

//add
	add(lblMode);
	add(radRail);
	add(radAir);
	add(radRoad);
	add(lblName);
	add(txtId);
	add(txtName);
	add(lblSource);
	add(lblDest);
	add(cmbSource);
	add(cmbDest);
	add(lblDepart);
	add(lblArrive);
	add(txtDepart);
	add(txtArrive);
	add(lblDist);
	add(txtDist);
	add(lblDays);
	add(butOk);
	add(butCancel);

	add(pnlExpend);
	add(pnlDays);

	butOk.addActionListener(new AHTrans());
	butCancel.addActionListener(new AHTrans());
	radRail.addActionListener(new AHTrans());
	radRoad.addActionListener(new AHTrans());
	radAir.addActionListener(new AHTrans());
}//constructor

public void clearFields()
{
	txtId.setText("");
	txtName.setText("");
	txtDist.setText("");
	txtDepart.setText("");
	txtArrive.setText("");
	cmbSource.setSelectedItem("Pune");
	cmbDest.setSelectedItem("Mumbai");
	pnlExpend.txtLuxChild.setText("");
	pnlExpend.txtLuxAdult.setText("");
	pnlExpend.txtBudAdult.setText("");
	pnlExpend.txtBudChild.setText("");
	pnlDays.chkMon.setSelected(false);
	pnlDays.chkTue.setSelected(false);
	pnlDays.chkWed.setSelected(false);
	pnlDays.chkThur.setSelected(false);
	pnlDays.chkFri.setSelected(false);
	pnlDays.chkSat.setSelected(false);
	pnlDays.chkSun.setSelected(false);
	txtId.requestFocus();
}
public void connectCmbPlaces()
{
	String strPlace;
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
	String cmdPlace = "Select Pname from Places";
	Statement stmt = conn.createStatement();
	ResultSet rsPlace = stmt.executeQuery(cmdPlace);
	while(rsPlace.next())
	{
		strPlace = rsPlace.getString(1);
		cmbSource.addItem(strPlace);
		cmbDest.addItem(strPlace);
		}//while
	stmt.close();
	conn.close();
	}//try
	catch(Exception e)
	{
		System.out.println(e);
	}//catch
}//connectCmbPlaces

public static void main(String []args)
{
	JFrame frmTrans = new JFrame("Transport Details");

	Transport transobj = new Transport();
	transobj.connectCmbPlaces();
	Border border = new EmptyBorder(1,1,1,1);
	border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);

	transobj.setBorder(border);

	frmTrans.setContentPane(transobj);
	frmTrans.setSize(525,450);
	frmTrans.setResizable(false);
	frmTrans.setVisible(true);
	//frmTrans.setLocationRelativeTo(null);


	WindowListener listener = new WindowAdapter()
	{
		public void windowClosing(WindowEvent wndEvt)
		{
			System.exit(0);
		}
	};

	frmTrans.addWindowListener(listener);
}//main

class AHTrans implements ActionListener
{
	public void actionPerformed(ActionEvent actEvt)
	{
		String tempAir;
		if(actEvt.getSource() == radRail)
		{
			pnlExpend.lblLuxCost.setText("2TAC Cost : Rs. ");
			pnlExpend.lblBudCost.setText("II Sleeper Cost : Rs. ");
			pnlExpend.txtLuxChild.setEditable(true);
			pnlExpend.txtBudChild.setEditable(true);
		}//radRail
		else
		if(actEvt.getSource() == radAir)
		{
					pnlExpend.lblLuxCost.setText("Business Cost : Rs. ");
					pnlExpend.lblBudCost.setText("Economy Cost : Rs. ");
					pnlExpend.txtLuxChild.setEditable(false);
					pnlExpend.txtBudChild.setEditable(false);
		}//radAir
		else
		if(actEvt.getSource() == radRoad)
		{
					pnlExpend.lblLuxCost.setText("Luxury Cost : Rs. ");
					pnlExpend.lblBudCost.setText("Budget Cost : Rs. ");
					pnlExpend.txtLuxChild.setEditable(true);
					pnlExpend.txtBudChild.setEditable(true);
		}//radRoad
		else
		if(actEvt.getSource() == butOk)
		{
			String temp,strDays;
			StringBuffer strBuf = new StringBuffer(70);
			int i,len;
			char ch;
			strDays = "";

			temp = txtName.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Name","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				txtName.requestFocus();
				return;
			}

			temp = txtDepart.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Name","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				txtDepart.requestFocus();
				return;
			}
/*
			try
			{

			DateFormat fmt = DateFormat.getTimeInstance(DateFormat.MEDIUM);//dd/mm/yy
			java.util.Time input = fmt.parse(temp);
			}
			catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"Enter Correct Date Format","Incorrect Format",JOptionPane.ERROR_MESSAGE);
			return;
			}//End of catch Block*/


			temp = txtArrive.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Name","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				txtArrive.requestFocus();
				return;
				}

				/*try
				{

				DateFormat fmt = DateFormat.getDateInstance(DateFormat.SHORT);//dd/mm/yy
				java.util.Date input = fmt.parse(temp);
				}
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"Enter Correct Date Format","Incorrect Format",JOptionPane.ERROR_MESSAGE);
				return;
			}//End of catch Block*/


			temp = txtDist.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Distance","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				txtDist.requestFocus();
				return;
			}

			temp = txtDist.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				if(temp.charAt(len-1) == '.')
				{
					JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					txtDist.requestFocus();
				}
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Distance","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						txtDist.setText("");
						txtDist.requestFocus();
						return;
					}
				}

			}

			temp = pnlExpend.txtLuxAdult.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Luxury Rate for Adult","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				pnlExpend.txtLuxAdult.requestFocus();
				return;
			}

			temp = pnlExpend.txtLuxAdult.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				if(temp.charAt(len-1) == '.')
				{
					JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					pnlExpend.txtLuxAdult.requestFocus();
				}
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Luxury Rate(Adult)","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						pnlExpend.txtLuxAdult.setText("");
						pnlExpend.txtLuxAdult.requestFocus();
						return;
					}
				}

			}

			temp = pnlExpend.txtLuxChild.getText();

			if(temp.equals("") && (radAir.isSelected() == false))
			{
				JOptionPane.showMessageDialog(null,"Enter Luxury Rate for Child","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				pnlExpend.txtLuxChild.requestFocus();
				return;
			}

			temp = pnlExpend.txtLuxChild.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				if(temp.charAt(len-1) == '.')
				{
					JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					pnlExpend.txtLuxChild.requestFocus();
				}
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Luxury Rate(Child)","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						pnlExpend.txtLuxChild.setText("");
						pnlExpend.txtLuxChild.requestFocus();
						return;
					}
				}

			}



			temp = pnlExpend.txtBudAdult.getText();
			if(temp.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Budget Rate for Adult","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				pnlExpend.txtBudAdult.requestFocus();
				return;
			}

			temp = pnlExpend.txtBudAdult.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				if(temp.charAt(len-1) == '.')
				{
					JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					pnlExpend.txtBudAdult.requestFocus();
				}
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Budget Rate(Adult)","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						pnlExpend.txtBudAdult.setText("");
						pnlExpend.txtBudAdult.requestFocus();
						return;
					}
				}

			}


			temp = pnlExpend.txtBudChild.getText();
			if(temp.equals("") && (radAir.isSelected() == false))
			{
				JOptionPane.showMessageDialog(null,"Enter Budget Rate for Child","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				pnlExpend.txtBudChild.requestFocus();
				return;
			}

			temp = pnlExpend.txtBudChild.getText();
			if(!(temp.equals("")))
			{
				len = temp.length();
				if(temp.charAt(len-1) == '.')
				{
					JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					pnlExpend.txtBudChild.requestFocus();
				}
				for(i =0;i<len;i++)
				{
					ch = temp.charAt(i);
					if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Budget Rate(Child)","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						pnlExpend.txtBudChild.setText("");
						pnlExpend.txtBudChild.requestFocus();
						return;
					}
				}

			}

			//Create strDays String

			if(pnlDays.chkMon.isSelected())
			{
				strDays = strBuf.append(pnlDays.chkMon.getText()).append(" ").toString();
				//txtName.setText(strDays);
				//return;
			}

			if(pnlDays.chkTue.isSelected())
			{
				strDays = strBuf.append(pnlDays.chkTue.getText()).append(" ").toString();
				//txtName.setText(strDays);
				//return;
			}

			if(pnlDays.chkWed.isSelected())
			{
				strDays = strBuf.append(pnlDays.chkWed.getText()).append(" ").toString();
				//txtName.setText(strDays);
				//return;
			}

			if(pnlDays.chkThur.isSelected())
			{
				strDays = strBuf.append(pnlDays.chkThur.getText()).append(" ").toString();
				//txtName.setText(strDays);
				//return;
			}

			if(pnlDays.chkFri.isSelected())
			{
				strDays = strBuf.append(pnlDays.chkFri.getText()).append(" ").toString();
				//txtName.setText(strDays);
				//return;
			}

			if(pnlDays.chkSat.isSelected())
			{
				strDays = strBuf.append(pnlDays.chkSat.getText()).append(" ").toString();
				//txtName.setText(strDays);
				//return;
			}

			if(pnlDays.chkSun.isSelected())
			{
				strDays = strBuf.append(pnlDays.chkSun.getText()).append(" ").toString();
				//txtName.setText(strDays);
				//return;
			}


			if(strDays.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select at least one Travelling Day","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				return;
			}

			//Save
			String modeType ="";
			if(radRail.isSelected())
				modeType = "Railway";
			else
			if(radRoad.isSelected())
				modeType = "Roadway";
			else
			if(radAir.isSelected())
			{
				modeType = "Airway";
				pnlExpend.txtLuxChild.setText(pnlExpend.txtLuxAdult.getText());
				pnlExpend.txtBudChild.setText(pnlExpend.txtBudAdult.getText());
			}
			String cmdValues = "";

			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				String cmdInsert = "Insert into Transport(TMode ,TId ,TName,SourcePlace,DestPlace,DepartTime,ArrivalTime,Distance,LuxuryCostAdult ,BudgetCostAdult, TravelDays,LuxuryCostChild,BudgetCostChild) values('";
				cmdValues = cmdInsert + modeType + "','" +
								   txtId.getText() + "','" +
								   txtName.getText() + "','" +
								   cmbSource.getSelectedItem() + "','" +
								   cmbDest.getSelectedItem() + "','" +
								   txtDepart.getText() + "','" +
								   txtArrive.getText() + "'," +
								   txtDist.getText() + "," +
								   pnlExpend.txtLuxAdult.getText() + "," +
								   pnlExpend.txtBudAdult.getText() + ",'" +
								   strDays + "'," +
								   pnlExpend.txtLuxChild.getText() + "," +
								   pnlExpend.txtBudChild.getText() + ")";

				System.out.println(cmdInsert);
				System.out.println(cmdValues);
				Statement stmt = conn.createStatement();
				int rsTrans = stmt.executeUpdate(cmdValues);
				JOptionPane.showMessageDialog(null,"Record Saved","Save",JOptionPane.ERROR_MESSAGE);
				clearFields();
				stmt.close();
				conn.close();

			}//try
			catch(java.sql.SQLException e1)
			{
				JOptionPane.showMessageDialog(null,"Entry Already Present.","Duplicate Value",JOptionPane.ERROR_MESSAGE);
				clearFields();
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
}//AHTrans


public class Expend extends JPanel
{
	JTextField txtLuxChild , txtLuxAdult , txtBudChild , txtBudAdult;
	JLabel lblLuxCost , lblBudCost ,lblAdult ,lblChild;
	public Expend()
	{
		setLayout(null);

		lblAdult = new JLabel("Adult");
		lblAdult.setBounds(170,10,80,30);
		lblChild = new JLabel("Child");
		lblChild.setBounds(270,10,80,30);
		lblLuxCost = new JLabel("2TAC Cost :   Rs. ");
		lblLuxCost.setBounds(20,50,120,30);
		lblBudCost = new JLabel("II Sleeper Cost :   Rs. ");
		lblBudCost.setBounds(20,90,120,30);

		txtLuxChild = new JTextField(15);
		txtLuxChild.setBounds(250,50,70,25);
		txtLuxAdult = new JTextField(15);
		txtLuxAdult.setBounds(150,50,70,25);
		txtBudChild = new JTextField(15);
		txtBudChild.setBounds(250,90,70,25);
		txtBudAdult = new JTextField(15);
		txtBudAdult.setBounds(150,90,70,25);

		add(lblAdult);
		add(lblChild);
		add(lblLuxCost);
		add(lblBudCost);
		add(txtLuxAdult);
		add(txtLuxChild);
		add(txtBudAdult);
		add(txtBudChild);

	}//constructor
}//Expend

public class Days extends JPanel
{
	JCheckBox chkMon,chkTue,chkWed,chkThur,chkFri,chkSat,chkSun;
	Days()
	{
		setLayout(null);

		chkMon = new JCheckBox("Monday");
		chkMon.setBounds(20,10,80,25);

		chkTue = new JCheckBox("Tuesday");
		chkTue.setBounds(20,40,80,25);

		chkWed = new JCheckBox("Wednesday");
		chkWed.setBounds(20,70,85,25);

		chkThur = new JCheckBox("Thursday");
		chkThur.setBounds(20,100,85,25);

		chkFri = new JCheckBox("Friday");
		chkFri.setBounds(20,130,80,25);

		chkSat = new JCheckBox("Saturday");
		chkSat.setBounds(20,160,85,25);

		chkSun = new JCheckBox("Sunday");
		chkSun.setBounds(20,190,80,25);

		/*chkDaily = new JCheckBox("Daily");
		chkDaily.setBounds(20,220,80,25);*/

		add(chkMon);
		add(chkTue);
		add(chkWed);
		add(chkThur);
		add(chkFri);
		add(chkSat);
		add(chkSun);
		//add(chkDaily);

	}//constructor
}//Days

}//Transport