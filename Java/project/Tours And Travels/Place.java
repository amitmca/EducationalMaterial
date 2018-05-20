import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.sql.*;

public class Place extends JPanel
{
	JLabel lblPName,lblState,lblClimate,lblSFrom,lblSTo,lblTSpots,lblImage,lblTemp,lblRain;
	JTextField txtPName, txtTSpots;
	JComboBox cmbState,cmbMonthFrom,cmbMonthTo,cmbTemp,cmbRain;
	JButton buttonOk , buttonCancel;
	ImageIcon imgOk,imgCancel,imgPlace;

	public Place()
	{
		setLayout(null);
		lblPName = new JLabel("Place Name : ");
		lblPName.setBounds(20,10,100,30);

		lblState = new JLabel("State : ");
		lblState.setBounds(290,10,100,30);

		lblSFrom = new JLabel("Season From : ");
		lblSFrom.setBounds(20,50,100,30);

		lblSTo = new JLabel("Season To : ");
		lblSTo.setBounds(290,50,100,30);

		lblTemp = new JLabel("Temperature : ");
		lblTemp.setBounds(20,90,100,30);

		lblRain = new JLabel("Rainfall : ");
		lblRain.setBounds(290,90,100,30);

		lblTSpots = new JLabel("Tourist Spots : ");
		lblTSpots.setBounds(20,130,100,30);


		txtPName = new JTextField (50);
		txtPName.setBounds(140,10,130,25);

		txtTSpots = new JTextField (300);
		txtTSpots.setBounds(140,130,385,25);

		cmbState = new JComboBox();
		cmbState.setBounds(400,10,130,25);
		cmbState.addItem("Andhra Pradesh");
		cmbState.addItem("Arunachal Pradesh");
		cmbState.addItem("Assam");
		cmbState.addItem("Bihar");
		cmbState.addItem("Chattisgarh");
		cmbState.addItem("Goa");
		cmbState.addItem("Gujrat");
		cmbState.addItem("Haryana");
		cmbState.addItem("Himachal Pradesh");
		cmbState.addItem("Jammu & Kashmir");
		cmbState.addItem("Jharkhand");
		cmbState.addItem("Karnataka");
		cmbState.addItem("Kerala");
		cmbState.addItem("Madhya Pradesh");
		cmbState.addItem("Maharashtra");
		cmbState.addItem("Manipur");
		cmbState.addItem("Meghalaya");
		cmbState.addItem("Mizoram");
		cmbState.addItem("Nagaland");
		cmbState.addItem("Orissa");
		cmbState.addItem("Punjab");
		cmbState.addItem("Uttaranchal");
		cmbState.addItem("Uttar Pradesh");
		cmbState.addItem("Rajasthan");
		cmbState.addItem("Sikkim");
		cmbState.addItem("Tamil Nadu");
		cmbState.addItem("Tripura");
		cmbState.addItem("West Bengal");
		cmbState.addItem("Andaman & Nicobar Islands");
		cmbState.addItem("Chandigarh");
		cmbState.addItem("Dehli");
		cmbState.addItem("Diu Daman");
		cmbState.addItem("Pondicherry");

		cmbMonthFrom = new JComboBox();
		cmbMonthFrom.setBounds(140,50,130,25);
		cmbMonthFrom.addItem("January");
		cmbMonthFrom.addItem("February");
		cmbMonthFrom.addItem("March");
		cmbMonthFrom.addItem("April");
		cmbMonthFrom.addItem("May");
		cmbMonthFrom.addItem("June");
		cmbMonthFrom.addItem("July");
		cmbMonthFrom.addItem("August");
		cmbMonthFrom.addItem("September");
		cmbMonthFrom.addItem("October");
		cmbMonthFrom.addItem("November");
		cmbMonthFrom.addItem("December");

		cmbMonthTo = new JComboBox();
		cmbMonthTo.setBounds(400,50,130,25);
		cmbMonthTo.addItem("January");
		cmbMonthTo.addItem("February");
		cmbMonthTo.addItem("March");
		cmbMonthTo.addItem("April");
		cmbMonthTo.addItem("May");
		cmbMonthTo.addItem("June");
		cmbMonthTo.addItem("July");
		cmbMonthTo.addItem("August");
		cmbMonthTo.addItem("September");
		cmbMonthTo.addItem("October");
		cmbMonthTo.addItem("November");
		cmbMonthTo.addItem("December");

		cmbTemp = new JComboBox();
		cmbTemp.setBounds(140,90,130,25);
		cmbTemp.addItem("Very Cold");
		cmbTemp.addItem("Moderately Cold");
		cmbTemp.addItem("Warm");
		cmbTemp.addItem("Humid");
		cmbTemp.addItem("Very Hot");
		cmbTemp.addItem("Extreme");

		cmbRain = new JComboBox();
		cmbRain.setBounds(400,90,130,25);
		cmbRain.addItem("Less");
		cmbRain.addItem("Moderate");
		cmbRain.addItem("Heavy");

		//imgOk = new ImageIcon("C:\\Rip\\Ok.jpg");
		buttonOk = new JButton("Ok");
		buttonOk.setBounds(460,230,70,30);

		//imgCancel = new ImageIcon("C:\\Rip\\Cancel.jpg");
		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(460 ,270,80,30);//70

		//imgPlace = new ImageIcon("C:\\Rip\\Paradise.jpg");
		lblImage = new JLabel("",imgPlace,JLabel.CENTER);
		lblImage.setBounds(20,170,420,130);

		//Add labels to panel
		add(lblPName);
		add(txtPName);
		add(lblState);
		add(cmbState);
		add(lblTemp);
		add(lblRain);
		add(cmbTemp);
		add(cmbRain);
		add(lblSFrom);
		add(cmbMonthFrom);
		add(lblSTo);
		add(cmbMonthTo);
		add(lblTSpots);
		add(txtTSpots);
		add(buttonOk);
		add(buttonCancel);
		add(lblImage);

		buttonOk.addActionListener(new AHPlace());
		buttonCancel.addActionListener(new AHPlace());

	}//Constructor

	public void clearFields()
	{
		txtPName.setText("");
		cmbState.setSelectedIndex(0);
		cmbMonthFrom.setSelectedIndex(0);
		cmbMonthTo.setSelectedIndex(0);
		cmbTemp.setSelectedIndex(0);
		cmbRain.setSelectedIndex(0);
		txtTSpots.setText("");
		txtPName.requestFocus();

	}//clearFields

	public static void main(String []args)
	{
		Place placeobj = new Place();
		Border border = new EmptyBorder(1,1,1,1);
		border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);
		//set the label on to the Frame
		JFrame frmPlace = new JFrame("Place Information");
		frmPlace.setContentPane(placeobj);
		frmPlace.setSize(560,350);
		frmPlace.setLocation(85,100);
		frmPlace.setResizable(false);
		placeobj.setBorder(border);
		frmPlace.setVisible(true);

		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent wndEvt)
			{
				System.exit(0);
			}
		};

		frmPlace.addWindowListener(listener);

	}//main

	class AHPlace implements ActionListener
	{
		public void actionPerformed(ActionEvent actEvt)
		{
			if(actEvt.getSource() == buttonOk)
			{
				String temp;
				temp = txtPName.getText();
				if(temp.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Enter Place Name","Incomplete Information",JOptionPane.ERROR_MESSAGE);
					txtPName.requestFocus();
					return;
				}

				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
					Statement stmt = conn.createStatement();
					String cmdinsert = "Insert into Places (Pname , State , TempInfo, RainInfo ,SeasonFrom , SeasonTo ,TouristSpots) values('";
					String cmdValues = cmdinsert + txtPName.getText() + "','" +
									   cmbState.getSelectedItem() + "','" +
									   cmbTemp.getSelectedItem() + "','"  +
									   cmbRain.getSelectedItem() + "','"  +
									   cmbMonthFrom.getSelectedItem() + "','" +
									   cmbMonthTo.getSelectedItem() + "','" +
									   txtTSpots.getText() + "')" ;

					int rsPlaces = stmt.executeUpdate(cmdValues);
					JOptionPane.showMessageDialog(null,"Record has been saved.","Saved",JOptionPane.INFORMATION_MESSAGE);
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
					//JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
					System.out.println(e);
				}//catch

			}//buttonOk
			else
			if(actEvt.getSource() == buttonCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//buttonCancel
		}//acionPerformed
	}//AHPlace
}//PlaceFrm
