
// 			This screen accepts the Customer Code and Dispalys information         //
//			like Customer FirstName,SecondName,Address and Packages 			   //

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Dimension.*;
import java.awt.TextArea;
import javax.swing.border.*;
import java.sql.*;

public class UpdateCust extends JPanel
{
	JLabel lblCustCode ,  lblCustFName , lblCustLName , lblAddress ,lblPackages,lblPhoto;
	JTextField txtCustFName, txtCustLName;
	TextArea  txtAddress,txtPackages;
	JComboBox cmbCustCode;
	JButton buttonOk , buttonCancel;
	ImageIcon imgPhoto;
	String photoPath;

	public UpdateCust() // Constructor begins
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

		buttonOk = new JButton("Update");
		buttonOk.setBounds(150,275,80,30);

		buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(250 ,275,80,30);

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
						String cmdCust = "Select custno from customer";
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

					//finally
					//{
					//	stmt.close();
					//	con.close();
				    //}//End of Finally block

	}

	public static void main(String []args)
	{

	    UpdateCust	updcustobj = new UpdateCust();
	    updcustobj.setDbConnection();
		Border border = new EmptyBorder(1,1,1,1);
		border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);
		//set the label on to the Frame
		JFrame frm = new JFrame("Search Information");
		frm.setResizable(false);
		frm.setContentPane(updcustobj);
		Dimension dim = frm.getToolkit().getScreenSize();
		frm.setLocation(dim.width/2 - frm.getWidth()/2 ,
				    dim.height/2 - frm.getHeight()/2 );

		frm.setSize(500,350);
		updcustobj.setBorder(border);
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
					String cmdCustDetails = "Select custfirstname,custlastname,custaddress,packname,Photo from customer where custno=?";
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

						custPackages =  rsCustDetails.getString(4);
						txtPackages.setText(custPackages);

						photoPath =  rsCustDetails.getString(5);
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

//Set the Current form to Invisible mode

//Call the Customer form
				Customer custobj = new Customer();
				boolean isClicked = true;
				JFrame frmCust = new JFrame("Customer Information");
				frmCust.setContentPane(custobj);
				frmCust.setSize(525,360);
				frmCust.setResizable(false);
				frmCust.setVisible(true);
				custobj.getCustDetails((String)cmbCustCode.getSelectedItem(),isClicked);
			}//End of buttonOk Event

			if(actEvt.getSource() == buttonCancel)
			{
				Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}//End of ButtonCancel

		}
	}//AHupdCust

}//Update CustomerFrm
