
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.Toolkit.*;
import javax.swing.event.*;

public class Customer extends JPanel implements DocumentListener
{
	JButton butOk , butPCancel,butPic,butMemAdd;
	JTextField txtCFName,txtCLName,txtAddr,txtPh1,txtPh2,txtEmail,txtFax,txtAge;
	TextArea txtHealthArea;
	JComboBox cmbOcc;
	boolean isUpdate = false;
	String CustCode;
	String fileName = "";
	JLabel lblPicPath;
	ImageIcon imgPhoto;
	String fileTemp="";

	public Customer()
	{
		setLayout(null);

		JLabel lblCFName,lblCLName,lblAddr,lblPh1,lblPh2,lblEmail,lblFax , lblPic,lblOcc,lblAge,lblHealth;
		ImageIcon imgCancel;
		ImageIcon imgOk,imgPack;




		lblCFName  = new JLabel("First Name : ");
		lblCFName.setBounds(20,10,100,30);

		lblCLName  = new JLabel("Last Name : ");
		lblCLName.setBounds(270,10,100,30);

		lblAddr  = new JLabel("Address : ");
		lblAddr.setBounds(20,50,100,30);

		lblPh1  = new JLabel("Phone No1 : ");
		lblPh1.setBounds(20,90,100,30);

		lblPh2  = new JLabel("Phone No2 : ");
		lblPh2.setBounds(270,90,100,30);

		lblEmail  = new JLabel("Email : ");
		lblEmail.setBounds(20,130,100,30);

		lblFax  = new JLabel("Fax Number : ");
		lblFax.setBounds(270,130,100,30);

		lblOcc  = new JLabel("Occupation : ");
		lblOcc.setBounds(20,170,100,30);


		lblAge  = new JLabel("Age : ");
		lblAge.setBounds(270,170,100,30);

		lblHealth  = new JLabel("Health Details : ");
		lblHealth.setBounds(20,210,100,30);

		lblPic  = new JLabel("Picture : ");
		lblPic.setBounds(270,210,100,30);

//TextBoxes
		txtCFName = new JTextField(50);
		txtCFName.setBounds(110,10,130,25);

		txtCLName = new JTextField(50);
		txtCLName.setBounds(360,10,130,25);

		txtAddr = new JTextField(300);
		txtAddr.setBounds(110,50,380,25);

		txtPh1 = new JTextField(15);
		txtPh1.setBounds(110,90,130,25);

		txtPh2 = new JTextField(15);
		txtPh2.setBounds(360,90,130,25);

		txtEmail = new JTextField(100);
		txtEmail.setBounds(110,130,130,25);

		txtFax = new JTextField(20);
		txtFax.setBounds(360,130,130,25);

		txtAge = new IntTextField(0,3);
		txtAge.setBounds(360,170,130,25);
		txtAge.getDocument().addDocumentListener(this);


		butPic = new JButton("...");
		butPic.setBounds(320,210,30,25);

		fileName = "";
		imgPhoto = new ImageIcon(fileName);

		lblPicPath = new JLabel("",imgPhoto,JLabel.CENTER);
		lblPicPath.setBounds(360,210,130,140);

		txtHealthArea = new TextArea("Normal",7,400,1);
		txtHealthArea.setBounds(110,210,130,50);


//ComboBox
		cmbOcc = new JComboBox();
		cmbOcc.setBounds(110,170,130,25);
		cmbOcc.addItem("Student");
		cmbOcc.addItem("Service");
		cmbOcc.addItem("Lawyer");
		cmbOcc.addItem("Doctor");
		cmbOcc.addItem("Teacher");
		cmbOcc.addItem("Business");
		cmbOcc.addItem("Software Professional");
		cmbOcc.addItem("Engineer");
		cmbOcc.addItem("Hotel Industry");


	//	imgOk = new ImageIcon("C:\\Rip\\ButtonGifOk.gif");
		butOk = new JButton("Ok");
		butOk.setBounds(20,320,100,40);


		//imgCancel = new ImageIcon("C:\\Rip\\ButtonGifCancel.gif");
		butPCancel = new JButton("Cancel");
		butPCancel.setBounds(150,320,100,40);



//add to the  Panel
		add(lblCFName);
		add(lblCLName);
		add(txtCFName);
		add(txtCLName);
		add(lblAddr);
		add(txtAddr);
		add(lblPh1);
		add(txtPh1);

		add(lblPh2);
		add(txtPh2);

		add(lblEmail);
		add(txtEmail);

		add(lblFax);
		add(txtFax);

		add(lblOcc);
		add(cmbOcc);

		add(lblAge);
		add(txtAge);

		add(lblHealth);
		add(txtHealthArea);

		add(lblPic);
		add(lblPicPath);
		add(butPic);


		add(butOk);
		add(butPCancel);




		butPCancel.addActionListener(new AHCust());
		butOk.addActionListener(new AHCust());
		butPic.addActionListener(new AHCust());


	}//Constructor

// This method connects to the Customer table based on the Customer code selected
// by the user in the UpdateCustomer form

public void getCustDetails(String custcode,boolean isClicked)
{
		isUpdate = isClicked;
		CustCode = custcode;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			//Request for the connection
			Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

			//Prepare the query
			String cmdCustDetails = "Select * from customer where custno=?";
			PreparedStatement updCustStmt = con.prepareStatement(cmdCustDetails);

			//Bind the variable to the required string
			updCustStmt.setString(1,(String)custcode);
			ResultSet rsCustDetails = updCustStmt.executeQuery();

			//Loop thru' the resultset
			while(rsCustDetails.next())
			{
//Bind the controls on screen to the database values
				txtCFName.setText(rsCustDetails.getString(2));
				txtCLName.setText(rsCustDetails.getString(3));
				txtAddr.setText(rsCustDetails.getString(5));
				txtPh1.setText(rsCustDetails.getString(8));
				txtPh2.setText(rsCustDetails.getString(9));
				txtEmail.setText(rsCustDetails.getString(10));
				txtFax.setText(rsCustDetails.getString(11));
				txtAge.setText(rsCustDetails.getString(7));
				txtHealthArea.setText(rsCustDetails.getString(12));
			}


			updCustStmt.close();
			con.close();

		}//End of try block

		catch(Exception e)
		{
			 System.out.println(e);
		}//End of catch block


}// End of getCustDetails


public void insertUpdate(DocumentEvent e)
{
//	setAge();
}
public void removeUpdate(DocumentEvent e)
{
//	return;
}
public void changedUpdate(DocumentEvent e)
{
//	return;
}
	public static void main(String []args)
	{
		Customer custobj = new Customer();
		JFrame frmCust = new JFrame("Customer Information");
		frmCust.setContentPane(custobj);
		frmCust.setSize(525,400);
		frmCust.setResizable(false);
		// To center the frame

		Dimension dim = frmCust.getToolkit().getScreenSize();
				frmCust.setLocation(dim.width/2 - frmCust.getWidth()/2 ,
				    dim.height/2 - frmCust.getHeight()/2 );
		frmCust.setVisible(true);

		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent wndEvt)
			{
				//frmCust.setVisible(false);
				Tours.frmLog.setVisible(false);
				//Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
			}
		};

		frmCust.addWindowListener(listener);

	}//main


class AHCust implements ActionListener
{
	public void actionPerformed(ActionEvent actEvt)
	{
		String temp;
		char ch;
		int len,i;
		if(actEvt.getSource() ==  butOk)
				{

					temp = txtCFName.getText();
					if(temp.equals (""))
					{
						JOptionPane.showMessageDialog(null,"Enter First Name","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtCFName.requestFocus();
						return;
					}
					temp = txtCLName.getText();
					if(temp.equals (""))
					{
						JOptionPane.showMessageDialog(null,"Enter Last Name","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtCLName.requestFocus();
						return;
					}
					String firstname, lastname;
							  firstname = txtCFName.getText();
							  lastname  = txtCLName.getText();

							  if (firstname.length() <= 3)
								firstname = firstname.substring(0);
							  else firstname = firstname.substring(0,3);

							  if (lastname.length() <= 3)
								lastname = lastname.substring(0);
							  else lastname = lastname.substring(0,3);

					temp = txtAddr.getText();
					if(temp.equals (""))
					{
						JOptionPane.showMessageDialog(null,"Enter Address","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtAddr.requestFocus();
						return;
					}

					temp = txtPh1.getText();
					if(temp.equals (""))
					{
						txtPh1.setText("-");
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
							txtPh1.setText("");
							txtPh1.requestFocus();
							return;
						}
					}

					}

					temp = txtPh2.getText();
					if(temp.equals (""))
					{
						txtPh2.setText("-");
						//return;
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
								txtPh2.setText("");
								txtPh2.requestFocus();
								return;
							}
						}
					}


					temp = txtEmail.getText();
					if(temp.equals (""))
					{
						txtEmail.setText("-");
						//return;
					}
					else // check if it is a valid email-id
					{
						//for(int cnt=0;cnt<temp.length();cnt++)
						//{
							int ind = temp.indexOf("@");
							if (ind != -1) { }
							else
							{
								JOptionPane.showMessageDialog(null,"Invalid Email Id","Error",JOptionPane.ERROR_MESSAGE);
								txtEmail.setText("");
								txtEmail.requestFocus();
								return;
							}
						//}
					}

					temp = txtFax.getText();
					if(temp.equals (""))
					{
						txtFax.setText("-");
						//return;
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
								txtFax.setText("");
								txtFax.requestFocus();
								return;
							}
						}

					}


					//temp = txtAge.getText();
					if(temp.equals (""))
					{
						JOptionPane.showMessageDialog(null,"Enter Age","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtAge.requestFocus();
						return;
					}

					int temp1;
					temp = txtAge.getText();
					if (!txtAge.isValid())
						{
							JOptionPane.showMessageDialog(null,"Enter Numerical Value For Age","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							txtAge.setText("");
							txtAge.requestFocus();
							return;

						}
					if(Integer.parseInt(txtAge.getText()) < 18)
					{
							JOptionPane.showMessageDialog(null,"Enter Age > 17","Incorrect Value",JOptionPane.ERROR_MESSAGE);
							txtAge.setText("");
							txtAge.requestFocus();
							return;
					}

					if (fileTemp.equals("")) fileTemp="-";
	//Connect to the Customer table in the Tours Database and save this new entry.
//Execute this code if the Customer screen is called via the Update event
  		try
  		{
			System.out.println("\n\nvalue of boolean" + isUpdate);
			int countCust = 0;
			String custcode="";
			String finalstr;
			ResultSet rsCustDetails;


			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			//Request for the connection
			Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement updCustStmt = con.createStatement();

			if (!isUpdate) // we have to insert a new row
			{
			  System.out.println("In insert code \n\n");

			//Prepare the query
			  String custquery = "Select count(*) as countCust from customer";

			//Execute the Query
			rsCustDetails = updCustStmt.executeQuery(custquery);

			//Loop thru' the resultset
			  while(rsCustDetails.next())
			{
				countCust = rsCustDetails.getInt(1);
            }//End of while stmt

			// Create a new Customer Code
              countCust = countCust + 1;
	          custcode =  firstname + lastname +countCust ;
              System.out.println(custcode);
              custquery = "";

              custquery =  " '" + custcode + "' , '" +
					    txtCFName.getText() + "' , '" +
					    txtCLName.getText() + "' , '" +
					    txtAddr.getText()   + "' ,'" +
					    txtPh1.getText()    + "' ,'" +
					    txtPh2.getText() 	+ "' ,'" +
					    txtEmail.getText()	+ "' ,'" +
					    txtFax.getText() + "' ," +
						txtAge.getText()+ " ,'" +
						txtHealthArea.getText() + "' ,'" +
						cmbOcc.getSelectedItem()+ "' ,'" +
						fileTemp + "'";



				finalstr = "Insert into Customer(custno,custfirstname,custlastname," +
				 			"custaddress,phno1,phno2,email,fax,age," +
				 			"healthconstraints,Occupation,Photo) values (" + custquery + ")";



        int rsCustDetails12 = updCustStmt.executeUpdate(finalstr);

		JOptionPane.showMessageDialog(null,"Record Saved.","SAVED",JOptionPane.INFORMATION_MESSAGE);
		txtCFName.setText("");
		txtCLName.setText("");
		txtAddr.setText("");
		txtPh1.setText("");
		txtPh2.setText("");
		txtEmail.setText("");
		txtFax.setText("");
		txtAge.setText("");
		txtHealthArea.setText("");
		cmbOcc.setSelectedIndex(0);


}//End of !isUpdate
		if (isUpdate) // we have to update an existing row
		{
			System.out.println("In update code \n\n");
			String updquery = "UPDATE customer SET ";
			String setvariables = "custfirstname = '"+ txtCFName.getText()+"', " +
					    "custlastname='" + txtCLName.getText() +"'," +
					    "custAddress='" + txtAddr.getText()+"',"+
					    "phno1='" +txtPh1.getText()+"',"+
					    "phno2='" +txtPh2.getText()+"',"+
					    "email='" +txtEmail.getText()+"',"+
					    "fax='" +txtFax.getText()+"',"+
						"age=" +txtAge.getText()+","+
						"healthconstraints='" +txtHealthArea.getText()+"',"+
						"Occupation='" +cmbOcc.getSelectedItem()+ "' ," +
						"Photo='" +fileTemp + "'";


			finalstr = updquery + setvariables + " where custno='" + CustCode +"'";
			System.out.println(finalstr);

//Execute the Query
			    Statement insertCustStmt1 = con.createStatement();

                      int rs = insertCustStmt1.executeUpdate(finalstr);
				System.out.println("updated!");
                      insertCustStmt1.close();
}//End if isUpdate
			    con.close();

		}//End of try block

		catch(Exception e)
		{
			System.out.println(e);

			JOptionPane.showMessageDialog(null,"Errors encounterd while writing to database","Incorrect Data",JOptionPane.ERROR_MESSAGE);
		}//End of catch block


	 }//butOk
		else
		if(actEvt.getSource() ==  butPCancel)
				{
					Tours.frmLog.setVisible(false);
					Tours.frmTours.setVisible(true);
					Tours.frmTours.setEnabled(true);
				}//butPCancel
		else
  		if(actEvt.getSource() ==  butPic)
	{
		JFileChooser PicChooser = new JFileChooser();
   		ExampleFileFilter filter = new ExampleFileFilter();
    	filter.addExtension("jpeg");
    	filter.addExtension("gif");
   		filter.setDescription("JPEG & GIF Images");
		PicChooser.setFileFilter(null);
	        int returnVal = PicChooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
            //String filename ="";
	    fileName =  PicChooser.getSelectedFile().getPath();
	   System.out.println(fileName);
	  if (!(fileName.endsWith(".JPEG") || fileName.endsWith(".jpeg") || fileName.endsWith(".gif")))
			{
				JOptionPane.showMessageDialog(null,"Invalid File format","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
	else
	{	char chTemp;

		for(int cnt = 0; cnt<fileName.length();cnt++)
		{
			chTemp = fileName.charAt(cnt);
			if (chTemp == '\\')
			{
				fileTemp = fileTemp + "\\";
				fileTemp = fileTemp + "\\";


			}
			else fileTemp = fileTemp + chTemp;
		}
	 }// end of else
		imgPhoto = new ImageIcon(fileTemp);
		System.out.println(fileTemp);
		lblPicPath.setIcon(imgPhoto);
	//}
    //}

	}//ButPic

}//actionPerformed

}}}//AHCust

