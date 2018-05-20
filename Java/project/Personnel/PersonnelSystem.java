/*   ---------------------------------------------------------------------------
    |System Name 	: Personnel Application System		    					|
	|Description	: A simple maintenance application  system. It includes		|
	|				  inquiry, update, delete, and insert functionalities   	|	
	|				  of personnel(friends, loved ones, ex-girlfriends, enemies,|
	|				  celebrities, etc.)										|
    ----------------------------------------------------------------------------|
    |Author			: Dhel Cruz													|
    |Program Version: 1.0														|
    |JDK Version	: 1.4														|
    |Last Update	: June 08, 2003												|
    |Database		: MS Access 2000											|
    |DB Name		: personnel.mdb												|
    |Tables 	  	: login, persons											|
    |Primary Key	: person_id													|
     ---------------------------------------------------------------------------
*/
//------------------------------------------------------------------------------>>>
////////////////////////////////////////////////////////////////////////////////
//------------------------------------------------------------------------------>>>

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.Date;
import java.text.NumberFormat;

public class PersonnelSystem extends JFrame{

	// Define constant variables	
	final static String driver  	 = "sun.jdbc.odbc.JdbcOdbcDriver";
	final static String url     	 = "jdbc:odbc:Personnel";
	final static String login   	 = "LOG-IN";
	final static String tab_login 	 = "Log-in";
	final static String tab1     	 = "INQUIRE Personnel Details";
	final static String tab2   	     = "UPDATE/DELETE Personnel Details";
	final static String tab3   	     = "INSERT Personnel Details";
	final static String insert  	 = "SAVE RECORD";
	final static String update 		 = "UPDATE RECORD";
	final static String delete  	 = "DELETE RECORD";
	final static String inquire 	 = "INQUIRE RECORD";
	final static String clear   	 = "     CLEAR    ";
	final static String relogin 	 = "Log-in failed! Please relog-in!";
	final static String norecfound 	 = "No Record Found!";
	final static String recinserted	 = "Record Inserted!";
	final static String recupdated 	 = "Record Updated!";
	final static String recdeleted 	 = "Record Deleted!";
	final static String numericerror = "Age should be numeric!";
	final static String information  = "INFORMATION";
	final static String error      	 = "ERROR";		
	final static String genexception = "GENERAL EXCEPTION";		
	final static String sqlexception = "SQL EXCEPTION";		
	final static String confdelete   = "CONFIRM DELETE";
	final static String slash   	 = "/";
	final static String table1  	 = "login";
	final static String table2  	 = "persons";

	// Define variables	for general use
	String sql       = "";   // Used to store sql statements
	String birthdate = "";   // Used to store birthdate format from comboboxes of
							 //    of year, month and day
	int pane_number  = 0;    // Used to indicate what screen needs to be processed
							 //    like resetting input fields and comboboxes     
	boolean abort    = false;// Used to indicate if error found to avoid further
							 //    processing/validations  
	
	// Define container, panels and tabbedpane
    Container cntr    = getContentPane();	
    JTabbedPane tpane = new JTabbedPane();
	JPanel 	datepanel1, datepanel2, datepanel3,
			cbpanel1  , cbpanel2 ,  cbpanel3,
			agepanel1 , agepanel2,  agepanel3, 
			panel1    , panel2   ,  panel3;


	// Define arrays for combo boxes
   	String gender[] 	   ={"Male","Female"};	 
	String maritalstatus[] ={"Single","Married","Separated","Annulled","Divorced"};	 	
   	
   	// Setup constraints and type of layout
   	GridBagConstraints constraints  = new GridBagConstraints();
   	GridBagConstraints constraints1 = new GridBagConstraints();
   	GridBagConstraints constraints2 = new GridBagConstraints();
   	GridBagConstraints constraints3 = new GridBagConstraints();
	GridBagLayout layout  = new GridBagLayout ();		
	
	// Define fonts to be used
	Font labelFont  = new Font("Arial",Font.PLAIN,12);
	Font buttonFont = new Font("Arial",Font.BOLD,13);
		
	// Define labels
	JLabel lbUser      		= new JLabel("Enter User ID: " ); 
	JLabel lbPassword  		= new JLabel("Enter Password: "); 
	JLabel lbSelectName   	= new JLabel("Search Name: "   );
	JLabel lbFirstName 	  	= new JLabel("First Name: "    );
	JLabel lbLastName 	  	= new JLabel("Last Name: "     );
	JLabel lbMiddleName  	= new JLabel("Middle Name: "   );
	JLabel lbNickName 	  	= new JLabel("Nickname: "      );
	JLabel lbGender 	  	= new JLabel("Gender: "        );
	JLabel lbMaritalStatus 	= new JLabel("Marital Status: ");
	JLabel lbAge    	  	= new JLabel("Age: "           );
	JLabel lbBirthdate 	  	= new JLabel("Birthdate: "     );
	JLabel lbAddress 	  	= new JLabel("Address: "       );
	JLabel lbResPhoneNumber = new JLabel("Res. Phone No.: ");
	JLabel lbCompanyName 	= new JLabel("Company Name: "  );
	JLabel lbOffPhoneNumber = new JLabel("Off. Phone No.: ");
	JLabel lbCellNumber 	= new JLabel("Cellphone No.: " );
	JLabel lbEmailAddress 	= new JLabel("Email Address: " );
		
	// Define combo boxes in third screen (insert pane)	
	JComboBox      cbGender1         = new JComboBox(gender);
	JComboBox      cbMaritalStatus1  = new JComboBox(maritalstatus);
	JComboBox      cbYear1           = new JComboBox();
	JComboBox      cbMonth1          = new JComboBox();
	JComboBox      cbDay1            = new JComboBox();
	JComboBox      cbName1		     = new JComboBox();
	JComboBox      cbPersonId1		 = new JComboBox();

	// Define combo boxes in second (update/delete pane)	
	JComboBox      cbGender2         = new JComboBox(gender);
	JComboBox      cbMaritalStatus2  = new JComboBox(maritalstatus);
	JComboBox      cbYear2           = new JComboBox();
	JComboBox      cbMonth2          = new JComboBox();
	JComboBox      cbDay2            = new JComboBox();
	JComboBox      cbName2		     = new JComboBox();
	JComboBox      cbPersonId2		 = new JComboBox();
	
	// Define combo boxes in third screen (insert pane)	
	JComboBox      cbGender3         = new JComboBox(gender);
	JComboBox      cbMaritalStatus3  = new JComboBox(maritalstatus);
	JComboBox      cbYear3           = new JComboBox();
	JComboBox      cbMonth3          = new JComboBox();
	JComboBox      cbDay3            = new JComboBox();

	// Define buttons,  text fields and password field
	JButton        btLogin        	 = new JButton   (login  );
	JButton        btInsert          = new JButton   (insert );
	JButton        btUpdate       	 = new JButton   (update );
	JButton        btDelete        	 = new JButton   (delete );
	JButton        btInquire       	 = new JButton   (inquire);
	JButton        btClear        	 = new JButton   (clear  );
	JPasswordField jpPassword 		 = new JPasswordField(10 );
	JTextField     tfUser     	  	 = new JTextField("",10  );

	// Inquiry fields on first screen (inquiry pane)	
	JTextField     tfFirstName1 	 = new JTextField("",30);
	JTextField     tfLastName1 	  	 = new JTextField("",30);
	JTextField     tfMiddleName1	 = new JTextField("",30);
	JTextField     tfNickName1 	  	 = new JTextField("",15);
	JTextField 	   tfAge1    	  	 = new JTextField("",3 );
	JTextField 	   tfAddress1	 	 = new JTextField("",30);
	JTextField 	   tfResPhoneNumber1 = new JTextField("",15);
	JTextField 	   tfOffPhoneNumber1 = new JTextField("",15);
	JTextField 	   tfCompanyName1 	 = new JTextField("",30);
	JTextField 	   tfEmailAddress1 	 = new JTextField("",30);
	JTextField 	   tfCellNumber1 	 = new JTextField("",15);
	JTextField 	   tfYear1		     = new JTextField("",4 );
	JTextField 	   tfMonth1 		 = new JTextField("",2 );
	JTextField     tfDay1 			 = new JTextField("",2 );
	
	// Input fields on second screen (update/delete pane)
	JTextField     tfFirstName2 	 = new JTextField("",30);
	JTextField     tfLastName2 	  	 = new JTextField("",30);
	JTextField     tfMiddleName2	 = new JTextField("",30);
	JTextField     tfNickName2 	  	 = new JTextField("",15);
	JTextField 	   tfAge2    	  	 = new JTextField("",3 );
	JTextField 	   tfAddress2	 	 = new JTextField("",30);
	JTextField 	   tfResPhoneNumber2 = new JTextField("",15);
	JTextField 	   tfOffPhoneNumber2 = new JTextField("",15);
	JTextField 	   tfCompanyName2 	 = new JTextField("",30);
	JTextField 	   tfEmailAddress2 	 = new JTextField("",30);
	JTextField 	   tfCellNumber2 	 = new JTextField("",15);
	JTextField 	   tfYear2		     = new JTextField("",4 );
	JTextField 	   tfMonth2 		 = new JTextField("",2 );
	JTextField     tfDay2 			 = new JTextField("",2 );

	// Input fields on third screen (insert pane)	
	JTextField     tfFirstName3 	 = new JTextField("",30);
	JTextField     tfLastName3 	  	 = new JTextField("",30);
	JTextField     tfMiddleName3	 = new JTextField("",30);
	JTextField     tfNickName3 	  	 = new JTextField("",15);
	JTextField 	   tfAge3    	  	 = new JTextField("",3 );
	JTextField 	   tfAddress3	 	 = new JTextField("",30);
	JTextField 	   tfResPhoneNumber3 = new JTextField("",15);
	JTextField 	   tfOffPhoneNumber3 = new JTextField("",15);
	JTextField 	   tfCompanyName3 	 = new JTextField("",25);
	JTextField 	   tfEmailAddress3 	 = new JTextField("",30);
	JTextField 	   tfCellNumber3 	 = new JTextField("",15);
	JTextField 	   tfYear3		     = new JTextField("",4 );
	JTextField 	   tfMonth3 		 = new JTextField("",2 );
	JTextField     tfDay3 			 = new JTextField("",2 );

	// class to convert gender into char value for DB storing
	ConvertValue conval = new ConvertValue();
	// class to compute age based on birthyear
	ComputeValue comval = new ComputeValue();

//------------------------------------------------------------------------------>>>
////////////////////////////////////////////////////////////////////////////////
//--------------------Start setupLoginPanel()----------------------------------->>>

	// Setup the login screen 
	public void setupLoginPanel(){

		// set application title
    	setTitle("Personnel Maintenance System");

		// center screen
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width
						- getWidth())/2,
		    		(Toolkit.getDefaultToolkit().getScreenSize().height
		    			- getHeight())/2);
   	
    	panel1 = new JPanel();

		// set screen border
		panel1.setBorder(BorderFactory.createTitledBorder(
						 BorderFactory.createEtchedBorder(),""));

		// add tabbedpane to panel
		tpane.addTab(tab_login, panel1);
		
		// add panel to container
		cntr.add(tpane);
		
		// setup layout as GridBagLayout		
		constraints.insets = new Insets(2,2,2,2);
		panel1.setLayout(layout);
		
		// setup User ID label in display area
		lbUser.setFont(labelFont);
		constraints.ipadx  = 2;
		constraints.ipady  = 2;
		constraints.gridx  = 0;
		constraints.gridy  = 0;
		constraints.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbUser, constraints);
		panel1.add(lbUser);
		
		// setup User ID input field in display area
		tfUser.setFont(labelFont);
		constraints.ipadx  = 2;
		constraints.ipady  = 2;
		constraints.gridx  = 1;
		constraints.gridy  = 0;
		constraints.fill   = GridBagConstraints.HORIZONTAL;
		layout.setConstraints(tfUser, constraints);
		panel1.add(tfUser);
		
		// setup Password label in display area
		lbPassword.setFont(labelFont);
		constraints.ipadx  = 2;
		constraints.ipady  = 2;
		constraints.gridx  = 0;
		constraints.gridy  = 1;
		constraints.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbPassword, constraints);
		panel1.add(lbPassword);

		// setup Password input field in display area
		jpPassword.setEchoChar('*');
		constraints.ipadx  = 2;
		constraints.ipady  = 2;
		constraints.gridx  = 1;
		constraints.gridy  = 1;
		layout.setConstraints(jpPassword, constraints);
		panel1.add(jpPassword);

		// setup Login button in display area
		btLogin.setFont(buttonFont);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridy  = 3;
		constraints.gridx  = 1;
		layout.setConstraints(btLogin, constraints);
		panel1.add(btLogin);
		
		// setup login button listener
		btLogin.addActionListener(new ButtonHandler());

		// allow ALT L to press login button
		btLogin.setMnemonic('l');

	}
	
//--------------------End setupLoginPanel()------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start login()--------------------------------------------->>>
	
	// Validate user input from the login screen based on information from login
	//   table (note: manually create/update your login from table LOGIN).
	public void login(){
		
		String user = tfUser.getText();
		user = user.trim();
		
		String password = jpPassword.getText();

		sql = "SELECT * FROM login WHERE user='"+
			   user+"'  AND password='"+password+"'";		
				
		try{
			
			// load MS Access driver
			Class.forName(driver);
		}catch(java.lang.ClassNotFoundException ex){
			
			JOptionPane.showMessageDialog(null,ex.getMessage(), error ,
				JOptionPane.PLAIN_MESSAGE);
		}
		
		try{
			// setup connection to DBMS
			Connection conn = DriverManager.getConnection(url);
			
			// create statement	
			Statement stmt   = conn.createStatement();

			// execute sql statement
			stmt.execute(sql);
			ResultSet rs = stmt.getResultSet();
			
			boolean recordfound = rs.next();

			if (recordfound){

				tpane.removeTabAt(0);	
				initComboBoxes();
				showPane1();
				showPane2();
				showPane3();
			}
			else{

				// username/password invalid
				JOptionPane.showMessageDialog(null,relogin, error,
					JOptionPane.INFORMATION_MESSAGE);
			
				//clear login and password fields
				tfUser.setText    ("");	
				jpPassword.setText("");
					
			}
			conn.close();
			
		}catch(Exception ex){

			JOptionPane.showMessageDialog(null,ex.getMessage(), genexception,
				JOptionPane.INFORMATION_MESSAGE);
		}		
	}	
//--------------------End login()----------------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start showPane1()----------------------------------------->>>	

	// Setup screen 1(inquiry pane) including labels, input fields, comboboxes.
	//     Table PERSONS is read to list inquiry parameters.
	void showPane1(){
		
		panel1     = new JPanel();	
		datepanel1 = new JPanel();
		cbpanel1   = new JPanel();
		agepanel1  = new JPanel();

		// set screen border
		panel1.setBorder(BorderFactory.createTitledBorder(
						 BorderFactory.createEtchedBorder(),""));
		
		// add tabbedpane to panel
		tpane.addTab(tab1, panel1);

		// setup layout as GridBagLayout		
		constraints1.insets = new Insets(2,2,2,2);
		panel1.setLayout    (layout);
		datepanel1.setLayout(layout);		
		cbpanel1.setLayout  (layout);		
		agepanel1.setLayout (layout);		

		// setup Name combobox label
		lbSelectName.setFont(labelFont);
		constraints1.gridx  = 0;
		constraints1.gridy  = 0;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbSelectName, constraints1);
		panel1.add(lbSelectName);
		
		// setup Name combobox as search key
		cbName1.setFont(labelFont);
		constraints1.ipady     = 10;
		constraints1.gridx     = 1;
		constraints1.gridy     = 0;
		constraints1.gridwidth = 3;
		constraints1.anchor    = GridBagConstraints.WEST;
		constraints1.fill 	   = GridBagConstraints.HORIZONTAL;
		layout.setConstraints(cbName1, constraints1);
		panel1.add         (cbName1);

		// setup search combobox (Name and corresponding key)
		cbName1.addItem    ("Choose one:");		
		cbPersonId1.addItem("0");		
		
		// setup First Name label in display area
		lbFirstName.setFont(labelFont);
		constraints1.gridx     = 0;
		constraints1.gridy     = 1;
		constraints1.anchor    = GridBagConstraints.WEST;
		constraints1.fill      = GridBagConstraints.NONE;
		constraints1.gridwidth = 1; 
		layout.setConstraints(lbFirstName, constraints1);
		panel1.add(lbFirstName);
		
		// setup First Name input field in display area
		tfFirstName1.setFont(labelFont);
		tfFirstName1.setEditable(false);
		constraints1.gridx  = 1;
		constraints1.gridy  = 1;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfFirstName1, constraints1);
		panel1.add(tfFirstName1);

		// setup Last Name label in display area
		lbLastName.setFont(labelFont);
		constraints1.gridx  = 2;
		constraints1.gridy  = 1;
		constraints1.anchor = GridBagConstraints.WEST;
		constraints1.fill = GridBagConstraints.NONE;
		layout.setConstraints(lbLastName, constraints1);
		panel1.add(lbLastName);
		
		// setup Last Name input field in display area
		tfLastName1.setFont(labelFont);
		tfLastName1.setEditable(false);
		constraints1.gridx  = 3;
		constraints1.gridy  = 1;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfLastName1, constraints1);
		panel1.add(tfLastName1);
		
		// setup Middle Name label in display area
		lbMiddleName.setFont(labelFont);
		constraints1.gridx  = 0;
		constraints1.gridy  = 2;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbMiddleName, constraints1);
		panel1.add(lbMiddleName);
	
		// setup Middle Name input field in display area
		tfMiddleName1.setFont(labelFont);
		tfMiddleName1.setEditable(false);
		constraints1.gridx  = 1;
		constraints1.gridy  = 2;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfMiddleName1, constraints1);
		panel1.add(tfMiddleName1);	
	
		// setup Nickname label in display area
		lbNickName.setFont(labelFont);
		constraints1.gridx  = 2;
		constraints1.gridy  = 2;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbNickName, constraints1);
		panel1.add(lbNickName);
		
		// setup Nickname input field in display area
		tfNickName1.setFont(labelFont);
		tfNickName1.setEditable(false);
		constraints1.gridx  = 3;
		constraints1.gridy  = 2;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfNickName1, constraints1);
		panel1.add(tfNickName1);
	
		// setup Gender label in display area
		lbGender.setFont(labelFont);
		constraints1.gridx  = 0;
		constraints1.gridy  = 3;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbGender, constraints1);
		panel1.add(lbGender);	
		
		// setup Gender input field in display area
		cbGender1.setFont(labelFont);
		cbGender1.setEnabled(false);
		constraints1.ipady  = 8;
		constraints1.gridx  = 1;
		constraints1.gridy  = 3;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(cbGender1, constraints1);
		panel1.add(cbGender1);	
		
		// setup Marital Status label in display area
		lbMaritalStatus.setFont(labelFont);
		constraints1.gridx  = 2;
		constraints1.gridy  = 3;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbMaritalStatus, constraints1);
		panel1.add(lbMaritalStatus);	
		
		// setup Marital Status input field in display area
		cbMaritalStatus1.setFont(labelFont);
		cbMaritalStatus1.setEnabled(false);
		constraints1.ipady     = 8;
		constraints1.gridx     = 3; 
		constraints1.gridy     = 3;
		constraints1.gridwidth = GridBagConstraints.REMAINDER;
		constraints1.anchor    = GridBagConstraints.WEST;
		layout.setConstraints(cbMaritalStatus1, constraints1);
		panel1.add(cbMaritalStatus1);	

		// setup Birthdate label in display area using another pane (datepanel2)
		lbBirthdate.setFont(labelFont);
		constraints1.gridx  = 0;
		constraints1.gridy  = 4;
		constraints1.anchor = GridBagConstraints.WEST;
		datepanel1.add(lbBirthdate);	
		panel1.add(datepanel1, constraints1);
	
		// indicate inquiry pane
		pane_number = 1;

		// put values in inquiry comboboxes
		initComboBoxes();
	
		// put separate panel(cbpanel) for these fields to align accordingly
		cbYear1.setFont(labelFont);
		cbMonth1.setFont(labelFont);
		cbDay1.setFont(labelFont);
		cbYear1.setEnabled(false);
		cbMonth1.setEnabled(false);
		cbDay1.setEnabled(false);
		constraints1.gridx  = 1;
		constraints1.gridy  = 4;
		constraints1.anchor = GridBagConstraints.WEST;
		cbpanel1.add(cbYear1);
		cbpanel1.add(cbMonth1);
		cbpanel1.add(cbDay1);
		panel1.add(cbpanel1, constraints1);
		
		// setup Age label in display area
		lbAge.setFont(labelFont);
		constraints1.gridx  = 3;
		constraints1.gridy  = 4;
		constraints1.anchor = GridBagConstraints.WEST;
		agepanel1.add(lbAge);

		// setup Age input field in display area
		tfAge1.setFont(labelFont);
		tfAge1.setEditable(false);
		agepanel1.add(tfAge1);
		panel1.add(agepanel1, constraints1);
	
		// setup Address label in display area
		lbAddress.setFont(labelFont);
 		constraints1.gridx  = 0;
		constraints1.gridy  = 5;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbAddress, constraints1);
		panel1.add(lbAddress);			
		
		// setup Address input field in display area
		tfAddress1.setFont(labelFont);
		tfAddress1.setEditable(false);
		constraints1.gridx  = 1;
		constraints1.gridy  = 5;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfAddress1, constraints1);
		panel1.add(tfAddress1);			
		
		// setup Residence Phone Number label in display area
		lbResPhoneNumber.setFont(labelFont);
		constraints1.gridx  = 2;
		constraints1.gridy  = 5;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbResPhoneNumber, constraints1);
		panel1.add(lbResPhoneNumber);		
		
		// setup Residence Phone Number input field in display area
		tfResPhoneNumber1.setFont(labelFont);
		tfResPhoneNumber1.setEditable(false);
		constraints1.gridx  = 3;
		constraints1.gridy  = 5;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfResPhoneNumber1, constraints1);
		panel1.add(tfResPhoneNumber1);			
				
		// setup Company Name label in display area
		lbCompanyName.setFont(labelFont);
		constraints1.gridx  = 0;
		constraints1.gridy  = 6;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbCompanyName, constraints1);
		panel1.add(lbCompanyName);			

		// setup Company Name input field in display area
		tfCompanyName1.setFont(labelFont);
		tfCompanyName1.setEditable(false);
		constraints1.gridx  = 1;
		constraints1.gridy  = 6;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfCompanyName1, constraints1);
		panel1.add(tfCompanyName1);			

		// setup Office Phone Number label in display area
		lbOffPhoneNumber.setFont(labelFont);
		constraints1.gridx  = 2;
		constraints1.gridy  = 6;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbOffPhoneNumber, constraints1);
		panel1.add(lbOffPhoneNumber);					
		
		// setup Office Phone Number input field in display area
		tfOffPhoneNumber1.setFont(labelFont);
		tfOffPhoneNumber1.setEditable(false);
		constraints1.gridx  = 3;
		constraints1.gridy  = 6;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfOffPhoneNumber1, constraints1);
		panel1.add(tfOffPhoneNumber1);
		
		// setup Email Address label in display area
		lbEmailAddress.setFont(labelFont);
		constraints1.gridx  = 0;
		constraints1.gridy  = 7;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbEmailAddress, constraints1);
		panel1.add(lbEmailAddress);					
		
		// setup Email Address input field in display area
		tfEmailAddress1.setFont(labelFont);
		tfEmailAddress1.setEditable(false);
		constraints1.gridx  = 1;
		constraints1.gridy  = 7;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfEmailAddress1, constraints1);
		panel1.add(tfEmailAddress1);					
		
		// setup Cell Number label in display area
		lbCellNumber.setFont(labelFont);
		constraints1.gridx  = 2;
		constraints1.gridy  = 7;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbCellNumber, constraints1);
		panel1.add(lbCellNumber);					
		
		// setup Cell Number input field in display area
		tfCellNumber1.setFont(labelFont);
		tfCellNumber1.setEditable(false);
		constraints1.gridx  = 3;
		constraints1.gridy  = 7;
		constraints1.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfCellNumber1, constraints1);
		panel1.add(tfCellNumber1);					
		
		// read table get the list of names in CB search key
    	accessDBInit();

		// define listener after adding items to CB to avoid triggering it
		cbName1.addItemListener(new ComboBoxHandler());		
	}	
//--------------------End showPane1()------------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start showPane2()----------------------------------------->>>

	// Setup screen 2(update and delete pane) including labels, input fields,
	//     comboboxes, and buttons. Table PERSONS is read to list inquiry parameters.
	void showPane2(){
					
		panel2     = new JPanel();	
		datepanel2 = new JPanel();
		cbpanel2   = new JPanel();
		agepanel2  = new JPanel();
	
		labelFont  = new Font("Arial",Font.PLAIN,12);
		buttonFont = new Font("Arial",Font.BOLD,12);


		// set screen border
		panel2.setBorder(BorderFactory.createTitledBorder(
			             BorderFactory.createEtchedBorder(),""));

		// add tabbedpane to panel
		tpane.addTab(tab2, panel2);

		// setup layout as GridBagLayout		
		constraints2.insets = new Insets(2,2,2,2);
		panel2.setLayout    (layout);
		datepanel2.setLayout(layout);		
		cbpanel2.setLayout  (layout);		
		agepanel2.setLayout (layout);		

		// setup Name combobox label
		lbSelectName = new JLabel("Search Name: ");	
		lbSelectName.setFont(labelFont);
		constraints2.gridx  = 0;
		constraints2.gridy  = 0;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbSelectName, constraints2);
		panel2.add(lbSelectName);
		
		// setup Name combobox as search key
		cbName2 = new JComboBox();
		cbName2.setFont(labelFont);
		constraints2.ipady     = 10;
		constraints2.gridx     = 1;
		constraints2.gridy     = 0;
		constraints2.gridwidth = 3;
		constraints2.anchor    = GridBagConstraints.WEST;
		constraints2.fill 	   = GridBagConstraints.HORIZONTAL;
		layout.setConstraints(cbName2, constraints2);
		panel2.add(cbName2);

		// setup search combobox (Name and corresponding key)
		cbName2.addItem("Choose one:");		
		cbPersonId2.addItem("0");		
		
		// setup First Name label in display area
		lbFirstName = new JLabel("First Name: ");
		lbFirstName.setFont(labelFont);
		constraints2.gridx     = 0;
		constraints2.gridy     = 1;
		constraints2.anchor    = GridBagConstraints.WEST;
		constraints2.fill      = GridBagConstraints.NONE;
		constraints2.gridwidth = 1; //
		layout.setConstraints(lbFirstName, constraints2);
		panel2.add(lbFirstName);
		
		// setup First Name input field in display area
		tfFirstName2.setFont(labelFont);
		constraints2.gridx  = 1;
		constraints2.gridy  = 1;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfFirstName2, constraints2);
		panel2.add(tfFirstName2);
		
		// setup Last Name label in display area
		lbLastName = new JLabel("Last Name: ");
		lbLastName.setFont(labelFont);
		constraints2.gridx  = 2;
		constraints2.gridy  = 1;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbLastName, constraints2);
		panel2.add(lbLastName);
		
		// setup Last Name input field in display area
		tfLastName2.setFont(labelFont);
		constraints2.gridx  = 3;
		constraints2.gridy  = 1;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfLastName2, constraints2);
		panel2.add(tfLastName2);
		
		// setup Middle Name label in display area
		lbMiddleName = new JLabel("Middle Name: ");
		lbMiddleName.setFont(labelFont);
		constraints2.gridx  = 0;
		constraints2.gridy  = 2;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbMiddleName, constraints2);
		panel2.add(lbMiddleName);
	
		// setup Middle Name input field in display area
		tfMiddleName2.setFont(labelFont);
		constraints2.gridx  = 1;
		constraints2.gridy  = 2;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfMiddleName2, constraints2);
		panel2.add(tfMiddleName2);	
	
		// setup Nickname label in display area
		lbNickName = new JLabel("Nickname: ");
		lbNickName.setFont(labelFont);
		constraints2.gridx  = 2;
		constraints2.gridy  = 2;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbNickName, constraints2);
		panel2.add(lbNickName);
		
		// setup Nickname input field in display area
		tfNickName2.setFont(labelFont);
		constraints2.gridx  = 3;
		constraints2.gridy  = 2;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfNickName2, constraints2);
		panel2.add(tfNickName2);
	
		// setup Gender label in display area
		lbGender = new JLabel("Gender: ");
		lbGender.setFont(labelFont);
		constraints2.gridx  = 0;
		constraints2.gridy  = 3;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbGender, constraints2);
		panel2.add(lbGender);	
		
		// setup Gender input field in display area
		cbGender2.setFont(labelFont);
		constraints2.ipady  = 8;
		constraints2.gridx  = 1;
		constraints2.gridy  = 3;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(cbGender2, constraints2);
		panel2.add(cbGender2);	
		
		// setup Marital Status label in display area
		lbMaritalStatus = new JLabel("Marital Status: ");
		lbMaritalStatus.setFont(labelFont);
		constraints2.gridx  = 2;
		constraints2.gridy  = 3;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbMaritalStatus, constraints2);
		panel2.add(lbMaritalStatus);	
		
		// setup Marital Status input field in display area
		cbMaritalStatus2.setFont(labelFont);
		constraints2.ipady     = 8;
		constraints2.gridx     = 3; 
		constraints2.gridy     = 3;
		constraints2.gridwidth = GridBagConstraints.REMAINDER;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(cbMaritalStatus2, constraints2);
		panel2.add(cbMaritalStatus2);	

		// setup Birthdate label in display area using another pane (datepanel2)
		lbBirthdate = new JLabel("Birthdate:");
		lbBirthdate.setFont(labelFont);
		constraints2.gridx  = 0;
		constraints2.gridy  = 4;
		constraints2.anchor = GridBagConstraints.WEST;
		datepanel2.add(lbBirthdate);	
		panel2.add(datepanel2, constraints2);
	
		// indicate update/delete pane
		pane_number = 2;
		// put values in update/delete combo boxes
		initComboBoxes();
	
		// put separate panel(cbpanel) for these fields to align accordingly
		cbYear2.setFont(labelFont);
		cbMonth2.setFont(labelFont);
		cbDay2.setFont(labelFont);
		constraints2.gridx  = 1;
		constraints2.gridy  = 4;
		constraints2.anchor = GridBagConstraints.WEST;
		cbpanel2.add(cbYear2);
		cbpanel2.add(cbMonth2);
		cbpanel2.add(cbDay2);
		panel2.add(cbpanel2, constraints2);

		// setup Age label in display area		
		lbAge = new JLabel ("Age:");
		lbAge.setFont(labelFont);
		constraints2.gridx  = 3;
		constraints2.gridy  = 4;
		constraints2.anchor = GridBagConstraints.WEST;
		agepanel2.add(lbAge);
		
		// setup Age input field in display area		
		tfAge2.setFont(labelFont);
		agepanel2.add(tfAge2);
		panel2.add(agepanel2, constraints2);
	
		// setup Address label in display area
		lbAddress = new JLabel("Address:");
		lbAddress.setFont(labelFont);
 		constraints2.gridx  = 0;
		constraints2.gridy  = 5;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbAddress, constraints2);
		panel2.add(lbAddress);			
		
		// setup Address input field in display area
		tfAddress2.setFont(labelFont);
		constraints2.gridx  = 1;
		constraints2.gridy  = 5;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfAddress2, constraints2);
		panel2.add(tfAddress2);			
		
		// setup Residence Phone Number label in display area
		lbResPhoneNumber = new JLabel("Res. Phone No.:");
		lbResPhoneNumber.setFont(labelFont);
		constraints2.gridx  = 2;
		constraints2.gridy  = 5;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbResPhoneNumber, constraints2);
		panel2.add(lbResPhoneNumber);		
		
		// setup Residence Phone Number input field in display area
		tfResPhoneNumber2.setFont(labelFont);
		constraints2.gridx  = 3;
		constraints2.gridy  = 5;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfResPhoneNumber2, constraints2);
		panel2.add(tfResPhoneNumber2);			
				
		// setup Company Name label in display area
		lbCompanyName = new JLabel("Company Name:");
		lbCompanyName.setFont(labelFont);
		constraints2.gridx  = 0;
		constraints2.gridy  = 6;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbCompanyName, constraints2);
		panel2.add(lbCompanyName);			

		// setup Company Name input field in display area
		tfCompanyName2.setFont(labelFont);
		constraints2.gridx  = 1;
		constraints2.gridy  = 6;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfCompanyName2, constraints2);
		panel2.add(tfCompanyName2);			

		// setup Office Phone Number label in display area
		lbOffPhoneNumber = new JLabel("Off. Phone No.:");
		lbOffPhoneNumber.setFont(labelFont);
		constraints2.gridx  = 2;
		constraints2.gridy  = 6;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbOffPhoneNumber, constraints2);
		panel2.add(lbOffPhoneNumber);					
		
		// setup Office Phone Number input field in display area
		tfOffPhoneNumber2.setFont(labelFont);
		constraints2.gridx  = 3;
		constraints2.gridy  = 6;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfOffPhoneNumber2, constraints2);
		panel2.add(tfOffPhoneNumber2);					
		
		// setup Email Address label in display area
		lbEmailAddress = new JLabel("Email Address:");
		lbEmailAddress.setFont(labelFont);
		constraints2.gridx  = 0;
		constraints2.gridy  = 7;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbEmailAddress, constraints2);
		panel2.add(lbEmailAddress);					
		
		// setup Email Address input field in display area
		tfEmailAddress2.setFont(labelFont);
		constraints2.gridx  = 1;
		constraints2.gridy  = 7;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfEmailAddress2, constraints2);
		panel2.add(tfEmailAddress2);					
		
		// setup Cell Number label in display area
		lbCellNumber = new JLabel("Cellphone No.:");
		lbCellNumber.setFont(labelFont);
		constraints2.gridx  = 2;
		constraints2.gridy  = 7;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbCellNumber, constraints2);
		panel2.add(lbCellNumber);					
		
		// setup Cell Number input field in display area
		tfCellNumber2.setFont(labelFont);
		constraints2.gridx  = 3;
		constraints2.gridy  = 7;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfCellNumber2, constraints2);
		panel2.add(tfCellNumber2);					
		
		// setup UPDATE button in display area
		btUpdate.setFont(buttonFont);
		constraints2.gridx  = 3;
		constraints2.gridy  = 8;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(btUpdate, constraints2);
		panel2.add(btUpdate);					

		// setup DELETE button in display area
		btDelete.setFont(buttonFont);
		constraints2.gridx  = 1;
		constraints2.gridy  = 8;
		constraints2.anchor = GridBagConstraints.WEST;
		layout.setConstraints(btDelete, constraints2);
		panel2.add(btDelete);					

		btUpdate.addActionListener(new ButtonHandler());		
		btDelete.addActionListener(new ButtonHandler());		
		cbYear2.addItemListener   (new ComboBoxHandler());		

		// allow ALT U to press update button
		btUpdate.setMnemonic('u');
		// allow ALT D to press delete button
		btDelete.setMnemonic('d');

		// read table get the list of names in combo box search key
    	accessDBInit();
		// define listener after adding items to CB to avoid triggering it
		cbName2.addItemListener(new ComboBoxHandler());		
	}	

//--------------------End showPane2()------------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start showPane3()----------------------------------------->>>

	// Setup screen 2(insert pane) including labels, input fields, comboboxes,
	//     and buttons. 

	void showPane3(){
		
		initComboBoxes();  	
		panel3 	  = new JPanel();	
		
		// add panels to align date label,combo box and age
		datepanel3 = new JPanel();
		cbpanel3   = new JPanel();
		agepanel3  = new JPanel();

		// set screen border
		panel3.setBorder(BorderFactory.createTitledBorder(
			             BorderFactory.createEtchedBorder(),""));		

		// add tabbedpane to panel
		tpane.addTab(tab3, panel3);
				
		// setup layout as GridBagLayout		
		constraints3.insets = new Insets(2,2,2,2);
		panel3.setLayout    (layout);
		datepanel3.setLayout(layout);		
		cbpanel3.setLayout  (layout);		
		agepanel3.setLayout (layout);		

		// setup First Name label in display area
		JLabel lbFirstName = new JLabel("First Name:");
		lbFirstName.setFont(labelFont);
		constraints3.gridx  = 0;
		constraints3.gridy  = 0;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbFirstName, constraints3);
		panel3.add(lbFirstName);

		// setup First Name input field in display area
		tfFirstName3.setFont(labelFont);
		constraints3.ipady  = 8; // adjust heigth of input field
		constraints3.gridx  = 1;
		constraints3.gridy  = 0;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfFirstName3, constraints3);
		panel3.add(tfFirstName3);

		// setup Last Name label in display area
		lbLastName = new JLabel("Last Name: ");
		lbLastName.setFont(labelFont);
		constraints3.gridx  = 2;
		constraints3.gridy  = 0;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbLastName, constraints3);
		panel3.add(lbLastName);
		
		// setup Last Name input field in display area
		tfLastName3.setFont(labelFont);
		constraints3.gridx  = 3;
		constraints3.gridy  = 0;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfLastName3, constraints3);
		panel3.add(tfLastName3);
		
		// setup Middle Name label in display area
		lbMiddleName = new JLabel("Middle Name: ");
		lbMiddleName.setFont(labelFont);
		constraints3.gridx  = 0;
		constraints3.gridy  = 1;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbMiddleName, constraints3);
		panel3.add(lbMiddleName);
	
		// setup Middle Name input field in display area
		tfMiddleName3.setFont(labelFont);
		constraints3.gridx  = 1;
		constraints3.gridy  = 1;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfMiddleName3, constraints3);
		panel3.add(tfMiddleName3);	
	
		// setup Nickname label in display area
		lbNickName = new JLabel("Nickname: ");
		lbNickName.setFont(labelFont);
		constraints3.gridx  = 2;
		constraints3.gridy  = 1;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbNickName, constraints3);
		panel3.add(lbNickName);
		
		// setup Nickname input field in display area
		tfNickName3.setFont(labelFont);
		constraints3.gridx  = 3;
		constraints3.gridy  = 1;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfNickName3, constraints3);
		panel3.add(tfNickName3);
	
		// setup Gender label in display area
		lbGender = new JLabel("Gender: ");
		lbGender.setFont(labelFont);
		constraints3.gridx  = 0;
		constraints3.gridy  = 2;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbGender, constraints3);
		panel3.add(lbGender);	
		
		// setup Gender input field in display area
		cbGender3.setFont(labelFont);
		constraints3.ipady  = 8;
		constraints3.gridx  = 1;
		constraints3.gridy  = 2;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(cbGender3, constraints3);
		panel3.add(cbGender3);	
	
		// setup Marital Status label in display area
		lbMaritalStatus = new JLabel("Marital Status: ");
		lbMaritalStatus.setFont(labelFont);
		constraints3.gridx  = 2;
		constraints3.gridy  = 2;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbMaritalStatus, constraints3);
		panel3.add(lbMaritalStatus);	
		
		// setup Marital Status input field in display area
		cbMaritalStatus3.setFont(labelFont);
		constraints3.ipady  = 8;
		constraints3.gridx  = 3; 
		constraints3.gridy  = 2;
		constraints3.gridwidth = GridBagConstraints.REMAINDER;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(cbMaritalStatus3, constraints3);
		panel3.add(cbMaritalStatus3);	

		// setup Date label in display area using another pane (datepanel)
		lbBirthdate = new JLabel("Birthdate: ");
		lbBirthdate.setFont(labelFont);
		constraints3.gridx  = 0;
		constraints3.gridy  = 3;
		constraints3.anchor = GridBagConstraints.WEST;
		datepanel3.add(lbBirthdate);	
		panel3.add(datepanel3, constraints3);
		
		// put separate panel(cbpanel) for these fields to align accordingly
		cbYear3.setFont(labelFont);
		cbMonth3.setFont(labelFont);
		cbDay3.setFont(labelFont);
		constraints3.ipady  = 8;
		constraints3.gridx  = 1;
		constraints3.gridy  = 3;
		constraints3.anchor = GridBagConstraints.WEST;
		cbpanel3.add(cbYear3);
		cbpanel3.add(cbMonth3);
		cbpanel3.add(cbDay3);
		panel3.add(cbpanel3, constraints3);
		
		// setup Age label in display area
		lbAge = new JLabel ("Age:");
		lbAge.setFont(labelFont);
		constraints3.gridx  = 3;
		constraints3.gridy  = 3;
		constraints3.anchor = GridBagConstraints.WEST;
		agepanel3.add(lbAge);

		// setup Age input field in display area
		agepanel3.add(tfAge3);
		tfAge3.setFont(labelFont);
		panel3.add(agepanel3, constraints3);

		// setup Address label in display area
		lbAddress = new JLabel ("Address:");
		lbAddress.setFont(labelFont);
		constraints3.gridx  = 0;
		constraints3.gridy  = 4;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbAddress, constraints3);
		panel3.add(lbAddress);			
		
		// setup Address input field in display area
		tfAddress3.setFont(labelFont);
		constraints3.gridx  = 1;
		constraints3.gridy  = 4;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfAddress3, constraints3);
		panel3.add(tfAddress3);			
		
		// setup Residence Phone Number label in display area
		lbResPhoneNumber = new JLabel ("Res. Phone No.:");
		lbResPhoneNumber.setFont(labelFont);
		constraints3.gridx  = 2;
		constraints3.gridy  = 4;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbResPhoneNumber, constraints3);
		panel3.add(lbResPhoneNumber);		
		
		// setup Residence Phone Number input field in display area
		tfResPhoneNumber3.setFont(labelFont);
		constraints3.gridx  = 3;
		constraints3.gridy  = 4;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfResPhoneNumber3, constraints3);
		panel3.add(tfResPhoneNumber3);			
				
		// setup Company Name label in display area
		lbCompanyName = new JLabel ("Company Name:");
		lbCompanyName.setFont(labelFont);
		constraints3.gridx  = 0;
		constraints3.gridy  = 5;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbCompanyName, constraints3);
		panel3.add(lbCompanyName);			

		// setup Company Name input field in display area
		tfCompanyName3.setFont(labelFont);
		constraints3.gridx  = 1;
		constraints3.gridy  = 5;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfCompanyName3, constraints3);
		panel3.add(tfCompanyName3);			

		// setup Office Phone Number label in display area
		lbOffPhoneNumber = new JLabel ("Off. Phone No.:");
		lbOffPhoneNumber.setFont(labelFont);
		constraints3.gridx  = 2;
		constraints3.gridy  = 5;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbOffPhoneNumber, constraints3);
		panel3.add(lbOffPhoneNumber);					
		
		// setup Office Phone Number input field in display area
		tfOffPhoneNumber3.setFont(labelFont);
		constraints3.gridx  = 3;
		constraints3.gridy  = 5;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfOffPhoneNumber3, constraints3);
		panel3.add(tfOffPhoneNumber3);
		
		// setup Email Address label in display area
		lbEmailAddress = new JLabel ("Email Address:");
		lbEmailAddress.setFont(labelFont);
		constraints3.gridx  = 0;
		constraints3.gridy  = 6;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbEmailAddress, constraints3);
		panel3.add(lbEmailAddress);					
		
		// setup Email Address input field in display area
		tfEmailAddress3.setFont(labelFont);
		constraints3.gridx  = 1;
		constraints3.gridy  = 6;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfEmailAddress3, constraints3);
		panel3.add(tfEmailAddress3);					
		
		// setup Cell Number label in display area
		lbCellNumber = new JLabel ("Cellphone No.:");
		lbCellNumber.setFont(labelFont);
		constraints3.gridx  = 2;
		constraints3.gridy  = 6;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(lbCellNumber, constraints3);
		panel3.add(lbCellNumber);					
		
		// setup Cell Number input field in display area
		tfCellNumber3.setFont(labelFont);
		constraints3.gridx  = 3;
		constraints3.gridy  = 6;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(tfCellNumber3, constraints3);
		panel3.add(tfCellNumber3);					
		
		// setup INSERT button in display area
		btInsert.setFont(buttonFont);
		constraints3.gridx  = 3;
		constraints3.gridy  = 7;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(btInsert, constraints3);
		panel3.add(btInsert);					

		// setup CLEAR button in display area
		btClear.setFont(buttonFont);
		constraints3.gridx  = 1;
		constraints3.gridy  = 7;
		constraints3.anchor = GridBagConstraints.WEST;
		layout.setConstraints(btClear, constraints3);
		panel3.add(btClear);					
	
		pane_number = 3;	
	   	initComboBoxes();
	   	btInsert.addActionListener(new ButtonHandler  ());		
	   	btClear.addActionListener (new ButtonHandler  ());		

		// allow ALT S to press insert button
		btInsert.setMnemonic('s');
		// allow ALT C to press clear button
		btClear.setMnemonic ('c');

		// add listener to CB Year to compute for age
		cbYear3.addItemListener   (new ComboBoxHandler());		
	}	
//--------------------End showPane3()------------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start initComboBoxes()------------------------------------>>>

	// Setup comboboxes particularly birth date, gender and marital status.	
	void initComboBoxes(){

		// years listed in year combo box	
   		for(int yr = 1960; yr < 2000; yr++)
			
			switch(pane_number){
			// inquire pane	
			case 1:	cbYear1.addItem(String.valueOf(yr));
					break; 
			// update/delete pane
			case 2:	cbYear2.addItem(String.valueOf(yr));
			// insert pane
					break; 
			case 3:	cbYear3.addItem(String.valueOf(yr));}
	
		// list of months in month combo box
		String[] months = {
	      	"Jan", "Feb", "Mar", "Apr", "May", "Jun",
	      	"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    
    	for(int m = 0; m < 12; m++){
			
			switch(pane_number){
			// inquire pane	
			case 1:	cbMonth1.addItem(String.valueOf(months[m]));
					break; 
			// update/delete pane
			case 2:	cbMonth2.addItem(String.valueOf(months[m]));
					break; 
			// insert pane	
			case 3:	cbMonth3.addItem(String.valueOf(months[m]));}
		}

		// set integer format to 2 digits (00)
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumIntegerDigits(2);

		// list of day in days combo box
    	for(int day = 1; day < 32; day ++){
	      	switch(pane_number){
			// inquire pane
			case 1: cbDay1.addItem(nf.format(day));
					break; 
			// update/delete pane
			case 2:	cbDay2.addItem(nf.format(day));
					break; 
			// insert pane
			case 3:	cbDay3.addItem(nf.format(day));}
		}
	}	
//--------------------End initComboBoxes()-------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start accessDBInit()-------------------------------------->>>
	
	// This will read the table PERSONS to list the names of personnel that are
	//     exisiting from the database.		
	void accessDBInit(){
		try{			  		
			
			sql = "SELECT person_id, first_name, last_name FROM " +
				   table2 +" ORDER BY last_name";		    

			// load MS Access driver
			Class.forName(driver);
			// Setup connection to DBMS			
			Connection conn=DriverManager.getConnection(url);

			// Create statement	
			Statement stmt     = conn.createStatement();
			boolean hasResults = stmt.execute(sql);

			if(hasResults){
				ResultSet result = stmt.getResultSet();
				displayResultsInit(result);
			}
		   	conn.close();
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(),genexception,
				JOptionPane.PLAIN_MESSAGE);			   		
		}
	}
//--------------------End accessDBInit()---------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start displayResultsInit()-------------------------------->>>
	
	// Put the names of personnels read into the ComboBox Name which will be used
	//     as the search parameters for users.
	void displayResultsInit(ResultSet rs) throws SQLException{
		
		while(rs.next()){
			// get values to display in Name combo box:
			// concatenate last and first names	
			String name= rs.getString("last_name") +
						 "," +
						 rs.getString("first_name"); 

			// store person_id(unique identifier)
			//   to display corresponding person details later
			String person_id = rs.getString("person_id");		  

			switch(pane_number){
				case 1: // inquiry screen
				
					// put Names in search combo box
					cbName1.addItem(name);
					cbPersonId1.addItem(person_id);
					break; 
			
				case 2: // update/delete screen
				
					// put Names in search combo box
					cbName2.addItem(name);
					cbPersonId2.addItem(person_id);
			}
		}   					 
  	}			
//--------------------End displayResultsInit()---------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start updateRecord()-------------------------------------->>>

	// Update personnel details.
	void updateRecord(){
		
		// convert combobox date input into String
		String birthdate   = (String)cbYear2.getSelectedItem() + slash +
					   		 (cbMonth2.getSelectedIndex() + 1) + slash +
					  	     (String)cbDay2.getSelectedItem();

		// convert combobox gender into corresponding char value of gender
		String gender = conval.formatGender((String)cbGender2.getSelectedItem());
		int age = 0;
		try{
		// convert age into integer format
		age = Integer.parseInt(tfAge2.getText());      

		}catch(Exception e){

			// error: age input is non-numeric	
			JOptionPane.showMessageDialog(null, numericerror,genexception,
				JOptionPane.INFORMATION_MESSAGE);
			tfAge2.setText("");
			// set cursor to age input field for re-input
			tfAge2.requestFocus();
			abort = true;
			return;
		}
		
		try{
			// load MS Access driver
			Class.forName(driver);
			// Setup connection to DBMS
			Connection conn = DriverManager.getConnection(url);
			// Create statement	
			Statement stmt = conn.createStatement();

			sql = "UPDATE "+
				   table2+
				  " SET "+
				  "first_name = '"      + tfFirstName2.getText()   + "'," +
				  "last_name = '"       + tfLastName2.getText()    + "'," +
				  "middle_name = '"     + tfMiddleName2.getText()  + "'," +
				  "nickname= '"         + tfNickName2.getText()    + "'," +
				  "gender = '"          + gender				   + "'," +
				  "maritalstatus= '"    + (String)cbMaritalStatus2.getSelectedItem()+"',"+
				  "age = "              + age					   + ","  +
				  "birthdate= '"        + birthdate			       + "'," +
				  "address = '"         + tfAddress2.getText()	   + "'," +
				  "res_phone_number = '"+ tfResPhoneNumber2.getText()+"',"+
				  "off_phone_number = '"+ tfOffPhoneNumber2.getText()+"',"+
    			  "cell_number = '"     + tfCellNumber2.getText()  + "'," +
				  "company_name = '"    + tfCompanyName2.getText() + "'," +
				  "email_address = '"   + tfEmailAddress2.getText()+ "' " +
				  "WHERE person_id = "  + cbPersonId2.getSelectedItem().toString(); 

			stmt.executeUpdate(sql);
    		conn.close();		

			JOptionPane.showMessageDialog(null,recupdated, information,
				JOptionPane.INFORMATION_MESSAGE);
		
		}catch(Exception ex){

			JOptionPane.showMessageDialog(null, ex.getMessage() + ex.toString(),genexception,
				JOptionPane.INFORMATION_MESSAGE);
		}		
	}	
//--------------------End updateRecord()---------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start deleteRecord()-------------------------------------->>>

	// Delete personnel records.
	void deleteRecord(){
		try{
			// load MS Access driver
			Class.forName(driver);

			// Setup connection to DBMS
			Connection conn = DriverManager.getConnection(url);
			
			// Create statement	
			Statement stmt = conn.createStatement();

			sql = "DELETE FROM "+ table2+
				  " WHERE person_id = " + cbPersonId2.getSelectedItem().toString(); 

			stmt.executeUpdate(sql);
    		conn.close();		

			JOptionPane.showMessageDialog(null,recdeleted, information,
				JOptionPane.INFORMATION_MESSAGE);
		
		}catch(Exception ex){

			JOptionPane.showMessageDialog(null, ex.getMessage() + ex.toString(),genexception,
				JOptionPane.INFORMATION_MESSAGE);
		}		
	}	
//--------------------End deleteRecord()---------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start insertRecord()-------------------------------------->>>

	// Insert personnel details.
	void insertRecord(){

		// convert combobox date input into String
		String birthdate   = (String)cbYear3.getSelectedItem() + slash +
					   		 (cbMonth3.getSelectedIndex() + 1) + slash +
					  	     (String)cbDay3.getSelectedItem();


		// convert combobox gender into corresponding char value of gender
		String gender = conval.formatGender((String)cbGender3.getSelectedItem());
		int age = 0;
		try{
			// convert age into integer format
			age = Integer.parseInt(tfAge3.getText());      

		}catch(Exception e){

			// error: age input is non-numeric	
			JOptionPane.showMessageDialog(null, numericerror,genexception,
				JOptionPane.INFORMATION_MESSAGE);
			tfAge3.setText("");
			// set cursor to age input field for re-input
			tfAge3.requestFocus();
			abort = true;
			return;
		}		
		
		try{
			// load MS Access driver
			Class.forName(driver);
			// Setup connection to DBMS
			Connection conn = DriverManager.getConnection(url);
			// Create statement	
			Statement stmt = conn.createStatement();

			sql = "INSERT INTO "+
				   table2+
				  " ("+
				  "first_name,"+
				  "last_name,"+
				  "middle_name,"+
				  "nickname,"+
				  "gender,"+
				  "maritalstatus,"+
				  "age,"+
				  "birthdate,"+
				  "address,"+
				  "res_phone_number,"+
				  "off_phone_number,"+
				  "cell_number,"+
				  "company_name,"+
				  "email_address"+	 			  		     
				  ") VALUES ('"+		
				  tfFirstName3.getText()+
				  "','"+
				  tfLastName3.getText()+
				  "','"+
				  tfMiddleName3.getText()+
				  "','"+
				  tfNickName3.getText()+
				  "','"+
				  gender+
				  "','"+
				  (String)cbMaritalStatus3.getSelectedItem()+
				  "',"+
				  age+	
				  ",'"+
				  birthdate+
				  "','"+
				  tfAddress3.getText()+
				  "','"+
				  tfResPhoneNumber3.getText()+
				  "','"+
				  tfOffPhoneNumber3.getText()+
				  "','"+
				  tfCellNumber3.getText()+
				  "','"+
				  tfCompanyName3.getText()+
				  "','"+
				  tfEmailAddress3.getText()+
				  "')";
	
			stmt.executeUpdate(sql);
    		conn.close();		

			JOptionPane.showMessageDialog(null,recinserted, information,
				JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception ex){

			JOptionPane.showMessageDialog(null, ex.getMessage() + ex.toString(),genexception,
				JOptionPane.INFORMATION_MESSAGE);
		}		
	}	
//--------------------End insertRecord()---------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start selectRecord()-------------------------------------->>>
	
	// Read personnel table based on the selected item from the Combobox Name.	
	void selectRecord(long person_id){
		try{
			// select person details based on primary key person_id
			sql = "SELECT * FROM "+table2+" WHERE person_id = "+person_id;

			// load MS Access driver
			Class.forName(driver);
		}catch (ClassNotFoundException x){
			JOptionPane.showMessageDialog(null, x.getMessage(), "ClassNotFoundException",
				JOptionPane.PLAIN_MESSAGE);
		}	
		try{

			// Setup connection to DBMS
			Connection conn = DriverManager.getConnection(url);
			// Create statement	
			Statement stmt  = conn.createStatement();
			// execute sql statement
			boolean hasResults = stmt.execute(sql);

			if(hasResults){

				ResultSet rs = stmt.getResultSet();
				displayPersonDetails(rs);
			}
			else {
			
				// no record found	
				JOptionPane.showMessageDialog(null, norecfound, information,
					JOptionPane.INFORMATION_MESSAGE);
			}		
			conn.close();

		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(),genexception,
				JOptionPane.PLAIN_MESSAGE);			   		
		}		
	}	
//--------------------End selectRecord()---------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start displayPersonDetails()------------------------------>>>

	// Populate details screen with data from personnel database. 
	void displayPersonDetails(ResultSet rs)throws SQLException{
		while (rs.next()){

			int num1    = conval.displayGender(
						      rs.getString("gender"));				

			int	num2    = conval.displayMaritalStatus(
						      rs.getString("maritalstatus"));				

			String date = rs.getString("birthdate");
			
			// display details
			switch(pane_number){
			case 1:	// inquiry screen
				tfFirstName1.setText     (rs.getString("first_name"      ));
				tfLastName1.setText		 (rs.getString("last_name"       ));					
				tfMiddleName1.setText	 (rs.getString("middle_name"     ));
				tfNickName1.setText		 (rs.getString("nickname"        ));
				tfAddress1.setText		 (rs.getString("address"         ));
				tfResPhoneNumber1.setText(rs.getString("res_phone_number"));
				tfOffPhoneNumber1.setText(rs.getString("off_phone_number"));
				tfCellNumber1.setText	 (rs.getString("cell_number"     ));
				tfCompanyName1.setText	 (rs.getString("company_name"    ));
				tfEmailAddress1.setText	 (rs.getString("email_address"   ));

				// display gender	
				cbGender1.setSelectedIndex(num1);
				// display marital status
				cbMaritalStatus1.setSelectedIndex(num2);
				// display age
				tfAge1.setText (rs.getString("age").toString());
				// display year of birth
				cbYear1.setSelectedItem   (conval.displayYear(date));
				// display month of birth
				cbMonth1.setSelectedIndex((conval.displayMonth(date)) -1);
				// display day of birth
				cbDay1.setSelectedItem    (conval.displayDay(date));
				break;

			case 2:	// update/delete screen 
				tfFirstName2.setText     (rs.getString("first_name"      ));
				tfLastName2.setText		 (rs.getString("last_name"       ));					
				tfMiddleName2.setText	 (rs.getString("middle_name"     ));
				tfNickName2.setText		 (rs.getString("nickname"        ));
				tfAddress2.setText		 (rs.getString("address"         ));
				tfResPhoneNumber2.setText(rs.getString("res_phone_number"));
				tfOffPhoneNumber2.setText(rs.getString("off_phone_number"));
				tfCellNumber2.setText	 (rs.getString("cell_number"     ));
				tfCompanyName2.setText	 (rs.getString("company_name"    ));
				tfEmailAddress2.setText	 (rs.getString("email_address"   ));

				// display gender	
				cbGender2.setSelectedIndex(num1);
				// display marital status
				cbMaritalStatus2.setSelectedIndex(num2);
				// display age
				tfAge2.setText (rs.getString("age").toString());
				// display year of birth
				cbYear2.setSelectedItem   (conval.displayYear(date));
				// display month of birth
				cbMonth2.setSelectedIndex((conval.displayMonth(date)) -1);
				// display day of birth
				cbDay2.setSelectedItem    (conval.displayDay(date));
			}
		}	
	}	
//--------------------End displayPersonDetails()-------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start clearDetails()-------------------------------------->>>

	// Reset screen input fields and initialize comboboxes.
	void clearDetails(){
		
		switch(pane_number){
			case 1:
				// clear date, gender and marital status comboboxes	
				clearComboBoxes();

				// clear search combobox
				cbName1.removeAllItems();
				cbPersonId1.removeAllItems();

				// initialize search combobox
				cbName1.addItem("Choose one:");
				cbPersonId1.addItem("0");
				cbName1.setSelectedItem("Choose one:");

				// clear input fields
				tfFirstName1.setText     ("");
				tfLastName1.setText		 ("");
				tfMiddleName1.setText	 ("");
				tfNickName1.setText		 ("");
				tfAge1.setText           ("");
				tfAddress1.setText		 ("");
				tfResPhoneNumber1.setText("");
				tfOffPhoneNumber1.setText("");
				tfCellNumber1.setText	 ("");
				tfCompanyName1.setText	 ("");
				tfEmailAddress1.setText	 ("");
				break;	
			case 2:
				// clear date, gender and marital status comboboxes	
				clearComboBoxes();
				
				// clear search combobox
				cbName2.removeAllItems();
				cbPersonId2.removeAllItems();
				
				// initialize search combobox
				cbName2.addItem("Choose one:");
				cbPersonId2.addItem("0");
				cbName2.setSelectedItem("Choose one:");
				
				// clear input fields
				tfFirstName2.setText     ("");
				tfLastName2.setText		 ("");
				tfMiddleName2.setText	 ("");
				tfNickName2.setText		 ("");
				tfAge2.setText           ("");
				tfAddress2.setText		 ("");
				tfResPhoneNumber2.setText("");
				tfOffPhoneNumber2.setText("");
				tfCellNumber2.setText	 ("");
				tfCompanyName2.setText	 ("");
				tfEmailAddress2.setText	 ("");
				break;
			case 3:
				clearComboBoxes();
				tfFirstName3.setText     ("");						
				tfLastName3.setText		 ("");
				tfMiddleName3.setText	 ("");
				tfNickName3.setText		 ("");
				tfAge3.setText           ("");
				tfAddress3.setText		 ("");
				tfResPhoneNumber3.setText("");
				tfOffPhoneNumber3.setText("");
				tfCellNumber3.setText	 ("");
				tfCompanyName3.setText	 ("");
				tfEmailAddress3.setText	 ("");
				;}
	}	

//--------------------End clearDetails()---------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start clearComboBoxes()----------------------------------->>>

	//  Initialize the comboboxes (birthdate, gender and marital status).	
	void clearComboBoxes(){

		switch(pane_number){
			case 1:  // clear comboboxes of inquiry screen
				cbYear1.setSelectedIndex		 (0);
				cbMonth1.setSelectedIndex		 (0);
				cbDay1.setSelectedIndex		     (0);
				cbGender1.setSelectedIndex       (0);
				cbMaritalStatus1.setSelectedIndex(0);
				break;	
			case 2:  // clear comboboxes of update/delete screen
				cbYear2.setSelectedIndex		 (0);
				cbMonth2.setSelectedIndex		 (0);
				cbDay2.setSelectedIndex		     (0);
				cbGender2.setSelectedIndex		 (0);
				cbMaritalStatus2.setSelectedIndex(0);
				break;
			case 3:  // clear comboboxes of insert screen
				cbYear3.setSelectedIndex		 (0);
				cbMonth3.setSelectedIndex		 (0);
				cbDay3.setSelectedIndex		     (0);
				cbGender3.setSelectedIndex		 (0);
				cbMaritalStatus3.setSelectedIndex(0);
				;}
	}	
//--------------------End clearComboBoxes()------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start ButtonHandler--------------------------------------->>>

	// Action listener for the buttons on each screen 
	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			// get the label of the button
			String action = e.getActionCommand();

			if (action!=null){
				if(action==login){
					// call method accessDB()
					login();
					// if login error, set cursor to user name input field
					tfUser.requestFocus();					
				}
				else if (action==insert){	

					insertRecord();
					// refresh list of names in combo box search key
					//   of inquiry screen
					
					if (abort){
						 // error found in insert
						 abort = false;
						 return;
					}
					else{
						pane_number = 1;
	   					clearDetails();
    					accessDBInit();
    			
						// refresh list of names in combo box search key of
						//   update/delete screen
						pane_number = 2;
	   					clearDetails();
	    				accessDBInit();
    					tfFirstName3.requestFocus();
    				}
				}
				else if (action==update){	
					updateRecord();

					if (abort){
						// error found in update
        				abort = false;
						return;
					}
					else{
						// refresh inquiry screen				
						pane_number = 1;
		   				clearDetails();
	   					accessDBInit();
    					tfFirstName2.requestFocus();
    				}
				}
				else if (action==delete){	
	
					// ask user to confirm delete	
					int reply =	JOptionPane.showConfirmDialog(null,
									"Are you sure you want to delete?",
									confdelete, JOptionPane.YES_NO_OPTION);

					if (reply == JOptionPane.YES_OPTION){	
						
						// delete confirmed
						deleteRecord();
	
						// refresh all screens
						pane_number = 1;
	   					clearDetails();
	   					// setup inquiry search key CB
	   					accessDBInit();

						pane_number = 2;
						clearDetails();
	   					// setup update/delete search key CB
    					accessDBInit();
    				}	
    					
				}
				else{
					// clear button - refresh insert pane
					pane_number = 3;
	   				clearDetails();
					clearComboBoxes();
				}
			}	
		}
	}
//--------------------End ButtonHandler----------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start ComboBoxHandler------------------------------------->>>

	// Item listener for the Comboboxes on each screen 
	class ComboBoxHandler implements ItemListener{
		public void itemStateChanged(ItemEvent e){
	
			if (e.getItemSelectable().equals(cbName1)){
				// combobox from inquiry pane (search name)

				if (cbName1.getSelectedIndex() != 0){ // index 0 = "Choose one:"

					// get index clicked				
					int num = (cbName1.getSelectedIndex());
					// get corresponding primary key for sql purposes
					cbPersonId1.setSelectedIndex(num);
    				// convert person_id text into integer(format in DB)
					long person_id = Integer.parseInt(
						             cbPersonId1.getSelectedItem().toString());
					pane_number =  1;
					// call method to execute sql and display details on screen
					selectRecord(person_id);
				}				
			}
			else if (e.getItemSelectable().equals(cbName2)){
				
				// combobox from update/delete pane (search name)				

			 	if (cbName2.getSelectedIndex() != 0){ // index 0 = "Choose one:"

					// get index clicked				
					int num = (cbName2.getSelectedIndex());
					// get corresponding primary key for sql purposes
					cbPersonId2.setSelectedIndex(num);
					// convert person_id text into integer(format in DB)
					long person_id = Integer.parseInt(
						             cbPersonId2.getSelectedItem().toString());
					pane_number =  2;
					// call method to execute sql and display details on screen
					selectRecord(person_id);
				}	
			}
			else if (e.getItemSelectable().equals(cbYear2)){ // birth year selected 
				// update/delete screen
				// compute age according to year of birth
				String year  = cbYear2.getSelectedItem().toString();
				tfAge2.setText(comval.computeAge(year));
			}
			else if (e.getItemSelectable().equals(cbYear3)){// birth year selected
				// insert screen
				// compute age according to year of birth
				String year  = cbYear3.getSelectedItem().toString();
				tfAge3.setText(comval.computeAge(year));
			}
		}
	}	

//--------------------End ComboBoxHandler--------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////	
//--------------------Start main------------------------------------------------>>>
   
	public static void main(String args[]){
		System.out.println("loading.......please wait.");	
		PersonnelSystem app = new PersonnelSystem();
    	app.setSize(900,385);
		app.setupLoginPanel();
    	app.setVisible(true);
		app.tfUser.requestFocus();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//--------------------End main-------------------------------------------------->>>
////////////////////////////////////////////////////////////////////////////////
//-----Quote:"Bugs are indication that we programmers are mere mortals!"---:)--->>>