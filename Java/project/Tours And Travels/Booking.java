
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.Toolkit.*;
import javax.swing.event.*;
import javax.swing.table.TableColumn.*;
import java.util.*;
import java.io.*;
import java.applet.*;
import javax.accessibility.*;
import java.net.*;
import javax.swing.event.*;



public class Booking extends JPanel
{
	JButton butOk , butPCancel,butMemAdd,butMemDel,butPack;
	JTextField txtCFName,txtCLName;
	JComboBox cmbRef,cmbSeat,cmbCust;
    JLabel lblPName,lblPType,lblPDate,lblAct;
	JComboBox cmbPName , cmbPType ,cmbPDate ;
	JTextField txtTrans,txtAct;
	JList lstPack;
	DateComboBox dtFrom , dtTo;
	boolean isUpdate = false;
	String CustCode,lastname,firstname;
	ImageIcon imgCancel;
	JPanel pnlCostInfo;
	JScrollPane sp;
	Members memobj;
	PackTable PackObj;
	DefaultListModel lItems;
	boolean click = false;
    public JButton buttonOk ;

	JTextField txtPName;
	JTextField txtState,txtMonthFrom,txtMonthTo,txtTemp,txtRain;
	TextArea txtClimate , txtTSpots;
	JComboBox cmbPlace;
	JFrame frmPlace ;
	int cntPlace = 0;
	public String arrPlace[] = new String[15];

	JTabbedPane tabCust;
	JLabel lblCCode , lblCName;
	JTextField txtCName;

	JLabel lblNum , lblPerson , lblTotal , lblAdult,lblChild ,lblTotalWDisc ,lblAmtPaid,lblBal,lblDiscount,lblImage,lblGrand,lbleq1,lbleq2,lblm1,lblm2;
	JTextField txtNumA,txtNumC,txtPersonA,txtPersonC,txtTotalA,txtTotalC,txtTotal,txtGrand,txtAmtPaid,txtBal,txtDiscount;
	JButton buteq1 , buteq2;

	int cntA=0,cntC=0,h=0 , expA=0,expC=0,totalA=0,totalC=0;
	int TotalWD = 0,GrandT =0;
	float GrandF=0,bal= 0;
	int amtPaid = 0;
	public Booking()
	{
		setLayout(new BorderLayout());
		//setLayout(null);
		tabCust = new JTabbedPane();
		JPanel pnlPackInfo = new JPanel();

		JPanel pnlPackSearch = new JPanel();
   	 	JLabel lblDateFrom,lblDateTo, lblPackList, lblActivity;

		pnlCostInfo = new JPanel();

		JLabel lblCFName,lblCLName,lblTrans,lblSeat;
		JScrollPane tableAggregate;

//Instantiate the table
		 memobj = new Members();


		lblDateFrom = new JLabel("Start Date From : ");
		lblDateFrom.setBounds(20,10,120,30);

		lblDateTo= new JLabel("Start Date To : ");
		lblDateTo.setBounds(20,50,120,30);

		dtFrom = new DateComboBox();
		dtFrom.setBounds(140,10,120,25);

		dtTo = new DateComboBox();
		dtTo.setBounds(140,50,120,25);

		lblAct = new JLabel("Activities : ");
		lblAct.setBounds(20,90,120,30);

		lblCFName  = new JLabel("First Name : ");
		lblCFName.setBounds(20,10,100,30);

		lblCLName  = new JLabel("Last Name : ");
		lblCLName.setBounds(270,10,100,30);

//TextBoxes

		txtAct = new JTextField(50);
		txtAct.setBounds(140,90,120,25);

		txtCFName = new JTextField(50);
		txtCFName.setBounds(110,10,130,25);

		txtCLName = new JTextField(50);
		txtCLName.setBounds(360,10,130,25);

		cmbRef = new JComboBox();
		cmbRef.setBounds(360,210,130,25);
        cmbRef.addItem("None");


		ImageIcon imgOk,imgPack;
		lblPName = new JLabel("Package Name : ");
		lblPName.setBounds(20,10,120,30);

		lblPType = new JLabel("Package Type : ");
		lblPType.setBounds(20,50,120,30);

		lblSeat = new JLabel("Seat Status : ");
		lblSeat.setBounds(280,50,120,30);

		lblPDate = new JLabel("Package Date : ");
		lblPDate.setBounds(280,10,120,30);

		lblTrans = new JLabel("Transport Details : ");
		lblTrans.setBounds(20,90,120,30);

		lblCCode = new JLabel("Customer Code : ");
		lblCCode.setBounds(20,130,120,30);

		cmbCust = new JComboBox();
		cmbCust.setBounds(130,130,130,25);
		cmbCust.setEditable(true);

		lblCName = new JLabel("Name : ");
		lblCName.setBounds(280,130,100,30);

		txtCName = new JTextField(100);
		txtCName.setBounds(340,130,155,25);
		txtCName.setEditable(false);

		lblNum = new JLabel("Number");
		lblNum.setBounds(100,10,60,30);

		txtNumA = new JTextField(50);
		txtNumA.setBounds(100,50,60,25);
		txtNumA.setEditable(false);

		txtNumC = new JTextField(50);
		txtNumC.setBounds(100,90,60,25);
		txtNumC.setEditable(false);

		lblAdult = new JLabel("Adult");
		lblAdult.setBounds(20,50,100,30);

		lblChild = new JLabel("Child");
		lblChild.setBounds(20,90,100,30);

		lblPerson = new JLabel("Expenditure/Person");
		lblPerson.setBounds(190,10,120,30);

		txtPersonA = new JTextField(50);
		txtPersonA.setBounds(200,50,90,25);
		txtPersonA.setEditable(false);

		txtPersonC = new JTextField(50);
		txtPersonC.setBounds(200,90,90,25);
		txtPersonC.setEditable(false);

		lbleq1 = new JLabel(" = ");
		lbleq1.setBounds(320,50,30,30);

		lbleq2 = new JLabel(" = ");
		lbleq2.setBounds(320,90,30,30);

		lblm1 = new JLabel(" X ");
		lblm1.setBounds(170,50,30,30);

		lblm2 = new JLabel(" X ");
		lblm2.setBounds(170,90,30,30);


		buteq1 = new JButton("=");
		buteq1.setBounds(300,210,50,30);

		buteq2 = new JButton("=");
		buteq2.setBounds(300,290,50,30);

		lblTotal = new JLabel("Total");
		lblTotal.setBounds(380,10,100,30);

		txtTotalA = new JTextField(50);
		txtTotalA.setBounds(360,50,90,25);
		txtTotalA.setEditable(false);

		txtTotalC = new JTextField(50);
		txtTotalC.setBounds(360,90,90,25);
		txtTotalC.setEditable(false);

		lblTotalWDisc = new JLabel("Total(Without Disc.)");
		lblTotalWDisc.setBounds(190,130,120,30);

		txtTotal = new JTextField(50);
		txtTotal.setBounds(360,130,90,25);
		txtTotal.setEditable(false);

		lblDiscount = new JLabel("Discount : ");
		lblDiscount.setBounds(190,170,120,30);

		txtDiscount = new JTextField(50);
		txtDiscount.setBounds(360,170,90,25);

		lblGrand = new JLabel("Total(With Disc.)");
		lblGrand.setBounds(190,210,120,30);

		txtGrand = new JTextField(50);
		txtGrand.setBounds(360,210,90,25);
		txtGrand.setEditable(false);

		lblAmtPaid = new JLabel("Amount Paid : Rs. ");
		lblAmtPaid.setBounds(190,250,120,30);

		txtAmtPaid = new JTextField(50);
		txtAmtPaid.setBounds(360,250,90,25);

		lblBal = new JLabel("Balance : Rs. ");
		lblBal.setBounds(190,290,120,30);

		txtBal = new JTextField(50);
		txtBal.setBounds(360,290,90,25);
		txtBal.setEditable(false);

//JTextField txtNumA,txtNumC,txtPersonA,txtPersonC,txtTotalA,txtTotalC,txtTotal,txtGrand,txtAmtPaid,txtBal,txtDiscount;
		cmbPName = new JComboBox();
		cmbPName.setBounds(130,10,130,25);

		cmbPType = new JComboBox();
		cmbPType.addItem("Luxury");
		cmbPType.addItem("Budget");
		cmbPType.setBounds(130,50,130,25);

		cmbPDate = new JComboBox();
		cmbPDate.setBounds(370,10,130,25);

		cmbSeat = new JComboBox();
		cmbSeat.setBounds(370,50,130,25);
		cmbSeat.addItem("Unreserved");
		cmbSeat.addItem("Reserved");

		txtTrans = new JTextField(200);
		txtTrans.setBounds(130,90,375,25);


	//	imgOk = new ImageIcon("C:\\Rip\\ButtonGifOk.gif");
		butOk = new JButton("Ok");
		butOk.setBounds(20,230,100,40);


		/*imgPack = new ImageIcon("C:\\Rip\\Paradise.jpg");
		lblImage = new JLabel("",imgPack,JLabel.CENTER);
		lblImage.setBounds(230,130,270,140);*/

//		imgCancel = new ImageIcon("C:\\Rip\\ButtonGifCancel.gif");
		butPCancel = new JButton("Cancel");
		butPCancel.setBounds(20,280,100,40);

		butMemAdd  = new JButton("Add Member");
		butMemAdd.setBounds(130,315,120,25);

		butMemDel= new JButton("Delete Member");
		butMemDel.setBounds(280,315,120,25);

		butPack = new JButton("Packages");
		butPack.setBounds(280,50,95,30);

		//ListBox
		lItems = new DefaultListModel();
		lstPack = new JList(lItems);
		sp = new JScrollPane(lstPack);
		sp.setBounds(390,10,110,105);
		//lItems.add(0,"shk");

		//JTable
		Border border = new EmptyBorder(1,1,1,1);
		border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);

		PackObj = new PackTable();
		PackObj.setBorder(border);
		PackObj.setBounds(20,130,470,180);

		//add to Search tab
		pnlPackSearch.setLayout(null);
		pnlCostInfo.setLayout(null);
		pnlPackInfo.setLayout(null);

		pnlPackSearch.add(lblDateFrom);
		pnlPackSearch.add(dtFrom);
		pnlPackSearch.add(lblDateTo);
		pnlPackSearch.add(dtTo);
		pnlPackSearch.add(lblAct);
		pnlPackSearch.add(txtAct);
		pnlPackSearch.add(butPack);
		pnlPackSearch.add(sp);
		pnlPackSearch.add(PackObj);

		pnlPackInfo.setLayout(null);
		pnlPackInfo.add(lblPName);
		pnlPackInfo.add(cmbPName);
		pnlPackInfo.add(lblPType);
		pnlPackInfo.add(cmbPType);
		pnlPackInfo.add(lblPDate);
		pnlPackInfo.add(cmbPDate);
		pnlPackInfo.add(lblSeat);
		pnlPackInfo.add(cmbSeat);
		pnlPackInfo.add(lblTrans);
		pnlPackInfo.add(txtTrans);
		pnlPackInfo.add(lblCCode);
		pnlPackInfo.add(cmbCust);
		pnlPackInfo.add(lblCName);
		pnlPackInfo.add(txtCName);


		pnlCostInfo.add(butOk);
		pnlCostInfo.add(butPCancel);
		//pnlCostInfo.add(lblImage);

// add to the Member Panel
		//memobj.setBorder(border);
		memobj.setBounds(20,170,480,140);
		pnlCostInfo.setLayout(null);
		pnlPackInfo.add(memobj);
		pnlPackInfo.add(butMemAdd);
		pnlPackInfo.add(butMemDel);
		pnlCostInfo.add(lblAmtPaid);
		pnlCostInfo.add(txtAmtPaid);
		pnlCostInfo.add(lblBal);
		pnlCostInfo.add(txtBal);
		pnlCostInfo.add(lblNum);
		pnlCostInfo.add(lblPerson);
		pnlCostInfo.add(lblTotal);
		pnlCostInfo.add(lblGrand);
		pnlCostInfo.add(lblTotalWDisc);
		pnlCostInfo.add(lblAdult);
		pnlCostInfo.add(lblChild);
		pnlCostInfo.add(txtNumA);
		pnlCostInfo.add(txtNumC);
		pnlCostInfo.add(txtPersonA);
		pnlCostInfo.add(txtPersonC);
		pnlCostInfo.add(txtTotalA);
		pnlCostInfo.add(txtTotalC);
		pnlCostInfo.add(txtGrand);
		pnlCostInfo.add(txtTotal);
		pnlCostInfo.add(lblDiscount);
		pnlCostInfo.add(txtDiscount);
		pnlCostInfo.add(lbleq1);
		pnlCostInfo.add(lbleq2);
		pnlCostInfo.add(lblm1);
		pnlCostInfo.add(lblm2);
		pnlCostInfo.add(buteq1);
		pnlCostInfo.add(buteq2);

//add panels to tab
		tabCust.addTab("Search Package",pnlPackSearch);
		tabCust.addTab("Package Information",pnlPackInfo);
		tabCust.addTab("Cost Details",pnlCostInfo);


		add(tabCust);
		butPCancel.addActionListener(new AHCust());
		butOk.addActionListener(new AHCust());
		butPack.addActionListener(new AHCust());
		butMemAdd.addActionListener(new AHCust());
		butMemDel.addActionListener(new AHCust());
		buteq1.addActionListener(new AHCust());
		buteq2.addActionListener(new AHCust());
		cmbCust.addActionListener(new AHCust());
		lstPack.addListSelectionListener(new LSHPack());
		cmbPName.addItemListener(new IHPackage());
		PackObj.cmbPlaces.addActionListener(new AHCust());

		tabCust.getModel().addChangeListener(new CLCust());



	}//Constructor

// This method connects to the Customer table based on the Customer code selected
// by the user in the UpdateCustomer form

class PackTable extends JPanel
{
	       String[] colnms={"Name","Places","Luxury(A)","Budget(A)","Luxury(C)","Budget(C)"};
			Object[][] rowData={
						};
					DefaultTableModel defTabModel = new DefaultTableModel(rowData,colnms);
					JTable tblPack = new JTable(defTabModel);

					JComboBox cmbPlaces = new JComboBox();
					TableColumnModel colModel = tblPack.getColumnModel();
					TableColumn colPlace = colModel.getColumn(1);


				  	public PackTable()
					{
						setLayout(new BorderLayout());
						tblPack.setRowHeight(20);
						colPlace.setPreferredWidth(150); //Place column is bigger
						colPlace.setCellEditor(new DefaultCellEditor(cmbPlaces));
						tblPack.setColumnSelectionAllowed(false);
						cmbPlaces.setVisible(false);
						add(tblPack);
						add(new JScrollPane(tblPack));

					}
}

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
				txtAmtPaid.setText(rsCustDetails.getString(15));
				txtBal.setText(rsCustDetails.getString(18));
				txtDiscount.setText(rsCustDetails.getString(16));
			}
			//Get the Member Information from the Members Table
  			        String cmdMemDetails="";
				cmdMemDetails="Select * from Members where custno=?";

				//Prepare the Statment
				updCustStmt = con.prepareStatement(cmdMemDetails);
				updCustStmt.setString(1,(String)custcode);

				//Execute the Query
				ResultSet rsMemDetails = updCustStmt.executeQuery();
				String memFName="",memLName,tDetails,hCnstr;
				int age=0;

				//Access the Resultset
				while (rsMemDetails.next())
				{
                                        memFName = rsMemDetails.getString(2);
					memLName = rsMemDetails.getString(3);
					age	 = rsMemDetails.getInt(5);
					tDetails = rsMemDetails.getString(4);
					hCnstr	 = rsMemDetails.getString(6);

		//Display the data in the Table

                                int noOfCols  = memobj.tbldt.getColumnCount();
				System.out.println(noOfCols + "\n\n");
                                Object[] data = new Object[noOfCols];

                                for(int col = 0; col< noOfCols; col++)
                                        data[col] = rsMemDetails.getString(col + 2) ;
                                memobj.defaulttablemodel.addRow(data);
                        }//End of While

			updCustStmt.close();
			con.close();

    }//End of try block
    catch(Exception e)
    {
            System.out.println(e);
    }//End of catch block


 }// End of getCustDetails

public void connectcmb()
{

	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
		Statement stmt = conn.createStatement();
		String cmdPack = "Select Distinct packname from PackageDate";
		ResultSet rsPack = stmt.executeQuery(cmdPack);
		while(rsPack.next())
		{
		  cmbPName.addItem(rsPack.getString(1));
		}//while
		stmt.close();
		conn.close();
	}//try
	catch(Exception e)
	{
		System.out.println(e);
	}//catch
}//connectcmbRefDb

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

public void setDbConnection()
	{
		String custCode;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement stmt = con.createStatement();
			String cmdCust = "Select custno from Customer";
			ResultSet rsCust = stmt.executeQuery(cmdCust);
			while (rsCust.next())
			{
				custCode = rsCust.getString(1);
				cmbCust.addItem(custCode);
			}
			stmt.close();
			con.close();
		} //try

		catch (Exception e)
		{
			System.out.println(e);
		}// End of catch block
	}//setDbConnection

public static void main(String []args)
	{
		Booking bookobj = new Booking();
		bookobj.connectcmb();
		JFrame frmBook = new JFrame("Booking Details");
		bookobj.setDbConnection();
		frmBook.setContentPane(bookobj);
		frmBook.setSize(525,400);
		frmBook.setResizable(false);

		// To center the frame

		Dimension dim = frmBook.getToolkit().getScreenSize();
				frmBook.setLocation(dim.width/2 - frmBook.getWidth()/2 ,
				    dim.height/2 - frmBook.getHeight()/2 );
		frmBook.setVisible(true);

		WindowListener listener = new WindowAdapter()
		{
			public void windowClosing(WindowEvent wndEvt)
			{
				System.exit(0);
			}
		};

		frmBook.addWindowListener(listener);

	}//main


	public class Members extends JPanel
	{
String[] colnms={"FirstName","LastName","HealthConstraints","Age","TransportDetails"};
				Object[][] rowData={{"","","","",""}};
				DefaultTableModel  defaulttablemodel = new DefaultTableModel();
				JTable tbldt = new JTable(defaulttablemodel);

			  	public Members()
				{
					setLayout(new BorderLayout());
					//tbldt.setLayout(new BorderLayout());
					for(int col =0;col<5;col++) {	defaulttablemodel.addColumn(colnms[col]);}
					add(tbldt.getTableHeader(),BorderLayout.NORTH);
					tbldt.setRowHeight(20);
					add(tbldt);

					add(new JScrollPane(tbldt));

                         }
	}//End of Members Class



// Class Displays Place Information
public class PackPlace extends JPanel
{
	JLabel lblPName ,lblPlace,  lblState , lblClimate , lblSFrom , lblSTo , lblTSpots,lblImage ,lblTemp,lblRain;
	JButton buttonCancel;
	ImageIcon imgOk,imgCancel,imgPlace;


	public PackPlace()
	{
		setLayout(null);

		lblPlace = new JLabel("Choose a Place : ");
		lblPlace.setBounds(20,10,120,30);

		cmbPlace = new JComboBox();
		cmbPlace.setBounds(140,10,120,25);

		lblState = new JLabel("State : ");
		lblState.setBounds(20,50,120,30);

		lblClimate = new JLabel("Climate Details : ");
		lblClimate.setBounds(290,70,100,30);

		lblSFrom = new JLabel("Season From : ");
		lblSFrom.setBounds(20,90,120,30);

		lblSTo = new JLabel("Season To : ");
		lblSTo.setBounds(20,130,120,30);

		lblTemp =new JLabel("Temperature : ");
		lblTemp.setBounds(280,10,120,30);

		lblRain =new JLabel("Rainfall : ");
		lblRain.setBounds(280,50,120,30);

		lblTSpots = new JLabel("Tourist Spots : ");
		lblTSpots.setBounds(280,90,120,30);

		txtTSpots = new TextArea ("",5,500,1);
		txtTSpots.setBounds(380,90,120,65);
		txtTSpots.setEditable(false);

		txtState = new JTextField(50);
		txtState.setBounds(140,50,120,25);
		txtState.setEditable(false);

		txtMonthFrom = new JTextField(50);
		txtMonthFrom.setBounds(140,90,120,25);
		txtMonthFrom.setEditable(false);

		txtMonthTo = new JTextField(50);
		txtMonthTo.setBounds(140,130,120,25);
		txtMonthTo.setEditable(false);

		txtTemp = new JTextField(50);
		txtTemp.setBounds(380,10,120,25);
		txtTemp.setEditable(false);

		txtRain = new JTextField(50);
		txtRain.setBounds(380,50,120,25);
		txtRain.setEditable(false);

	//	imgOk = new ImageIcon("C:\\Rip\\Ok.jpg");
		buttonOk = new JButton("Ok");
		buttonOk.setBounds(430,165,70,30);


		//Add labels to panel
		add(cmbPlace);
		add(lblPlace);
		add(lblState);
		add(txtState);
		add(lblTemp);
		add(lblRain);
		add(txtTemp);
		add(txtRain);
		add(lblSFrom);
		add(txtMonthFrom);
		add(lblSTo);
		add(txtMonthTo);
		add(lblTSpots);
		add(txtTSpots);
		add(buttonOk);
		cmbPlace.addActionListener(new AHCust());
		buttonOk.addActionListener(new AHCust());

}



//This method populates the combo box with the places selected by the user

void setPlaces()
{
	//String pname = "Panaji,Mapusa", strFinal="";
	int cnt;

		cmbPlace.removeAllItems();
		for(cnt = 0;cnt<15;cnt++)
		{
			if(arrPlace[cnt].equals(null));
			else
				cmbPlace.addItem(arrPlace[cnt]);
		}
}// End of setPlaces()

}//PlaceFrm


////////////////////////////////////////////
class AHCust implements ActionListener
{
	public void actionPerformed(ActionEvent actEvt)
	{

		String temp;
		char ch;
		int len,i;
/*---------------------------------------------------------------------------------------------*/
		if(actEvt.getSource() == cmbCust)
					{
						try
						{

							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

							String cmdCustDetails = "Select CustFirstName,CustLastName from Customer where CustNo = ?";
							PreparedStatement cancelStmt = con.prepareStatement(cmdCustDetails);
							cancelStmt.setString(1,(String)cmbCust.getSelectedItem());
							ResultSet rsCustDetails = cancelStmt.executeQuery();
							while(rsCustDetails.next())
							{
								String custFName =  rsCustDetails.getString(1);
								String custLName =  rsCustDetails.getString(2);
								txtCName.setText(custFName + " " + custLName);

							}//while
					cancelStmt.close();
					con.close();
				}//try

				catch(Exception e)
				{
					System.out.println(e);
				}//catch
			}//cmbCust
/*---------------------------------------------------------------------------------------------*/
			else
		if(actEvt.getSource() ==  PackObj.cmbPlaces)
        {
			PackPlace placeobj = new PackPlace ();
			frmPlace = new JFrame("Place Information");
			frmPlace.setContentPane(placeobj);
			frmPlace.setSize(520,235);
			frmPlace.setLocation(85,100);
			frmPlace.setResizable(false);
			frmPlace.setVisible(true);
			placeobj.setPlaces();
		}
/*---------------------------------------------------------------------------------------------*/
		else
		if(actEvt.getSource() == buteq2)
		{
			String tempAmtPaid = txtAmtPaid.getText();

			if(tempAmtPaid.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Value For Amount Paid","Incomplete Inforamtion",JOptionPane.ERROR_MESSAGE);
				txtAmtPaid.requestFocus();
				return;
			}

			String tempA = txtAmtPaid.getText();
			if(!(tempA.equals("")))
			{
				len = tempA.length();
				for(i =0;i<len;i++)
				{
					ch = tempA.charAt(i);
					if(ch == ' ' || ch == '-' || ch == '(' || ch == ')' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Amount Paid","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						txtAmtPaid.setText("");
						txtAmtPaid.requestFocus();
						return;
					}
				}
			}

			amtPaid = Integer.parseInt(txtAmtPaid.getText());
			if(amtPaid<=0)
			{
				JOptionPane.showMessageDialog(null,"Enter Value greater than 0","Incomplete Inforamtion",JOptionPane.ERROR_MESSAGE);
				txtAmtPaid.requestFocus();
				return;
			}
			bal = GrandF - amtPaid;
			txtBal.setText(Float.toString(bal));

		}//buteq2
/*---------------------------------------------------------------------------------------------*/
		else
		if(actEvt.getSource() == buteq1)
		{
			int disc = 0;
			String tempDisc = txtDiscount.getText();
			if(tempDisc.equals("")) disc = 0;
			String tempD = txtDiscount.getText();
			if(!(tempD .equals("")))
			{
				len = tempD .length();
				for(i =0;i<len;i++)
				{
					ch = tempD .charAt(i);
					if(ch == ' ' || ch == '-' || ch == '(' || ch == ')' || (ch >= '0' && ch <= '9'))
					{
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Discount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						txtDiscount.setText("");
						txtDiscount.requestFocus();
						return;
					}
				}
			}//End of If
			if(tempDisc.equals("")) disc = 0;
			else
		      disc = Integer.parseInt(txtDiscount.getText());

			float discF = disc / (float)100.0;
			GrandF = TotalWD - (discF * TotalWD);
			txtGrand.setText(Float.toString(GrandF));
		}//buteq1
/*---------------------------------------------------------------------------------------------*/
		else
		if(actEvt.getSource() == buttonOk)
            {
			//Display the Package screen
			frmPlace.setVisible(false);
		}
/*---------------------------------------------------------------------------------------------*/
		else
		if(actEvt.getSource() == cmbPlace)
            {
		 try
   		  {
		      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			//Request for the connection
			Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement stmtPlace = con.createStatement();
			String strPlace  = "select * from places where pname='" + cmbPlace.getSelectedItem() +"'";;

			ResultSet rsPlace = stmtPlace.executeQuery(strPlace);
			while(rsPlace.next())
			{
				 txtState.setText(rsPlace.getString("State"));
				 txtTemp.setText(rsPlace.getString("TempInfo"));
				 txtRain.setText(rsPlace.getString("RainInfo"));
				 txtMonthFrom.setText(rsPlace.getString("SeasonFrom"));
				 txtMonthTo.setText(rsPlace.getString("SeasonTo"));
				 txtTSpots.setText(rsPlace.getString("TouristSpots"));


			}
			stmtPlace.close();
			con.close();
		  }
		catch(Exception e)
		{
			System.out.println(e);
      	}//End of catch block


		}
/*---------------------------------------------------------------------------------------------*/
		else
		if(actEvt.getSource() ==  butOk)
            {
					temp = txtAmtPaid.getText();
					if(temp.equals (""))
					{
						JOptionPane.showMessageDialog(null,"Enter Amount Paid","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtAmtPaid.requestFocus();
						return;
					}

					temp = txtAmtPaid.getText();
					if(!(temp.equals("")))
					{
						len = temp.length();
						if(temp.charAt(len-1) == '.')
						{
							JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							txtAmtPaid.requestFocus();
						}
						for(i =0;i<len;i++)
						{
							ch = temp.charAt(i);
							if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
							{
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Amount Paid","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtAmtPaid.setText("");
								txtAmtPaid.requestFocus();
								return;
							}
						}

					}

					temp = txtBal.getText();
					if(temp.equals (""))
					{
						JOptionPane.showMessageDialog(null,"Enter Balance","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtBal.requestFocus();
						return;
					}

					temp = txtBal.getText();
					if(!(temp.equals("")))
					{
						len = temp.length();
						if(temp.charAt(len-1) == '.')
						{
							JOptionPane.showMessageDialog(null,"No digit after decimal For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							txtBal.requestFocus();
						}
						for(i =0;i<len;i++)
						{
							ch = temp.charAt(i);
							if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
							{
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Balance","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtBal.setText("");
								txtBal.requestFocus();
								return;
							}
						}

					}

					temp = txtDiscount.getText();
					if(temp.equals (""))
					{
						txtDiscount.setText("0");
					}

					temp = txtDiscount.getText();
					if(!(temp.equals("")))
					{
						len = temp.length();
						for(i =0;i<len;i++)
						{
							ch = temp.charAt(i);
							if(ch==' ' || ch == '.' || (ch >= '0' && ch <= '9'))
							{
							}
							else
							{
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Discount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtDiscount.setText("");
								txtDiscount.requestFocus();
								return;
							}
						}

					}

//Connect to the Customer table in the Tours Database and save this new entry.

//Execute this code if the Customer screen is called via the Update event
      try
     {
			int countCust = 0;
			String custcode="",strPack="",strSeats="";
			String finalstr;
			ResultSet rsCustDetails;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			//Request for the connection
			Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement updCustStmt = con.createStatement();

			String cmdSeat = "Select SeatsLeft from PackageDate where PackName = ? and PackType = ? and FromDate = ?";
			PreparedStatement stmtSeat = con.prepareStatement(cmdSeat);
			stmtSeat.setString(1,(String)cmbPName.getSelectedItem());
			stmtSeat.setString(2,(String)cmbPType.getSelectedItem());
			stmtSeat.setString(3,(String)cmbPDate.getSelectedItem());

			ResultSet rsSeat = stmtSeat.executeQuery();
			while (rsSeat.next())
			{
				 strSeats = rsSeat.getString(1);

			}
				int	numSeats = Integer.parseInt(strSeats);

				//Total Seats left after booking
				numSeats = numSeats - (cntA + cntC) ;
				stmtSeat.close();

				String updSeats = "UPDATE PackageDate "
													   + "SET SeatsLeft = " + numSeats
													   + " WHERE PackName = '" + cmbPName.getSelectedItem() +"'"
													   + " and PackType = '" + cmbPType.getSelectedItem() + "'"
													   + " and FromDate = #" + cmbPDate.getSelectedItem() + "#";
			Statement upPack = con.createStatement();
			int rsPack = upPack.executeUpdate(updSeats);

			if (!isUpdate) // we have to insert a new row
			{
				String custquery = "";
				custcode = (String)cmbCust.getSelectedItem();

                custquery =  "'" + custcode + "' ," +
									txtAmtPaid.getText() + "," +
									txtBal.getText()+ "," +
									txtDiscount.getText() + ",'" +
									txtTrans.getText() + "' ,'" +
									cmbPName.getSelectedItem()+ "' ,'" +
									cmbPType.getSelectedItem()+ "' ,'" +
									cmbPDate.getSelectedItem()+ "' ,'" +
									cmbSeat.getSelectedItem()+"', "  +
									txtNumA.getText() +"," +
									txtNumC.getText() +"," +
									txtTotal.getText() + "," +
									txtGrand.getText() + "," +
									"'NO' " ;



				finalstr = "Insert into Booking(custno," +
"amtpaid,balance,discount,Transdetails,PackName,PackType,PackFromDate,Seat,AdultNum,ChildNum,TotalAmt,TotalAmtDisc,Cancelled) values (" + custquery + ")";



        int rsCustDetails12 = updCustStmt.executeUpdate(finalstr);

JOptionPane.showMessageDialog(null,"Saved","Record Saved",JOptionPane.INFORMATION_MESSAGE);

	// save the data in the Members table
	int rows=0;
	rows = memobj.tbldt.getRowCount();
	System.out.println(" total no rows =" + rows + "\n");
	int rsMemDetails;
	if (rows == 0){}
	else
	{
	for(int rowCnt = 0 ; rowCnt < rows; rowCnt++)

	// Do for all the rows in the table
	{

		String memQuery="";

		memQuery= "'" + (memobj.defaulttablemodel.getValueAt(rowCnt,0)) + "','"
			  + (memobj.defaulttablemodel.getValueAt(rowCnt,1)) + "','"
			  + (memobj.defaulttablemodel.getValueAt(rowCnt,2)) + "',"
			  + (memobj.defaulttablemodel.getValueAt(rowCnt,3)) + ",'"
			  + (memobj.defaulttablemodel.getValueAt(rowCnt,4)) + "')";

		System.out.println("\n\n"+memQuery+"\n\n");

		finalstr = "";
		finalstr = "Insert into Members(Custno,MemFirstName,MemLastName,HealthConstraints," +
			    "Age,TransportDetails) values('"  +  custcode + "'," + memQuery;

	System.out.println("\n\n\n"+finalstr);

	  rsMemDetails = updCustStmt.executeUpdate(finalstr);

	}//End of while stmt
}
}//End of !isUpdate
             if (isUpdate) // we have to update an existing row
             {
                        System.out.println("In update code \n\n");
			String updquery = "UPDATE customer SET ";
			String setvariables = "amtpaid=" +txtAmtPaid.getText()+","+
						"balance=" +txtBal.getText()+"," +
						"discount=" +txtDiscount.getText() +","+
						"Transdetails='"+txtTrans.getText() + "' ,'" +
						"PackName='"	+cmbPName.getSelectedItem()+ "' ,'" +
						"PackType='"	+cmbPType.getSelectedItem()+ "' ," +
						"PackFromDate='" +cmbPDate.getSelectedItem()+ " ," +

						"Seat='" +cmbSeat.getSelectedItem() + "'" ;


			finalstr = updquery + setvariables + " where custno='" + CustCode +"'";
		//	System.out.println(finalstr);

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
/*---------------------------------------------------------------------------------------------*/
		else
		if(actEvt.getSource() ==  butPCancel)
				{
					Tours.frmLog.setVisible(false);
					Tours.frmTours.setVisible(true);
					Tours.frmTours.setEnabled(true);
				}//butPCancel
/*---------------------------------------------------------------------------------------------*/
	else
		if(actEvt.getSource() ==  butMemAdd)
		{

		// Create a new Row to add a member
		int noOfRows  = memobj.tbldt.getRowCount();
		int noOfCols  = memobj.tbldt.getColumnCount();

		Object[] data = new Object[noOfCols];

		for(int col = 0; col< noOfCols; col++)
			data[col] = "";

	//Validate the fields of the previous row
	String strFName="",strLName="",strHealth="",strAge="",strTrans="";
 	  if (noOfRows>=1)
	  {
            strFName = (String)memobj.tbldt.getValueAt(noOfRows-1,0);
		strLName = (String)memobj.tbldt.getValueAt(noOfRows-1,1);
		strHealth = (String)memobj.tbldt.getValueAt(noOfRows-1,2);
		strAge = (String)memobj.tbldt.getValueAt(noOfRows-1,3);
		strTrans = (String)memobj.tbldt.getValueAt(noOfRows-1,4);

		if (strFName.equals(null) || strLName.equals(null) || strHealth.equals(null) || strAge.equals(null) || strTrans.equals(null) )
		{
			 JOptionPane.showMessageDialog(null,"Enter Member details ","Incomplete Details",JOptionPane.ERROR_MESSAGE);
			 return;
		}

 	  }
				memobj.defaulttablemodel.addRow(data);
		strFName="";
		strLName="";
		strHealth="";
		strAge="";
		strTrans="";
		}//ButMemAdd
/*---------------------------------------------------------------------------------------------*/
		else
			if(actEvt.getSource() ==  butMemDel)
			{

			//delete a  Row
			memobj.tbldt.setRowSelectionAllowed(true);
			int rowsel = memobj.tbldt.getSelectedRow();

			int noOfRowsDel  = memobj.tbldt.getRowCount();
			if (rowsel<0 && noOfRowsDel >0 )
			{
				  JOptionPane.showMessageDialog(null,"Select a row ","Error",JOptionPane.ERROR_MESSAGE);
				  return;
			}
			if (noOfRowsDel !=0 && rowsel>=0)
				memobj.defaulttablemodel.removeRow(rowsel);



		}//ButMemDel
/*---------------------------------------------------------------------------------------------*/
		else
		if(actEvt.getSource() == butPack)
		{
			Connection con = null, conn = null;
			PreparedStatement packStmt = null;
			String strAct = (String)txtAct.getText();

			String strFdt = (String)dtFrom.getSelectedItem();
			String strTdt = (String)dtTo.getSelectedItem();

			int noOfRows  = PackObj.tblPack.getRowCount();

			if (noOfRows != 0)
			{
				for(int cnt=noOfRows-1;cnt >= 0;cnt--)
				{
					PackObj.defTabModel.removeRow(cnt);
				}
			}

			if((strAct.equals("")) && (strFdt == null) && (strTdt == null))
			{

				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
					Statement stmtP = conn.createStatement();
					String sqlP = "Select distinct PackName From Package";
					ResultSet rsP = stmtP.executeQuery(sqlP);

					int index1 = 0;
					lItems.clear();
					while(rsP.next())
					{
						lItems.add(index1++ , rsP.getString("PackName"));
						//System.out.println(rsP.getString(1));
					}

					stmtP.close();
					conn.close();

				}//try
				catch(Exception e)
				{
					System.out.println(e);
				}
			}

			else
			{
			try
			{
				String sqlPack = "";
				String Act = "";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				if(!strAct.equals(""))
				{
					sqlPack = "SELECT DISTINCT PackagePlace.PackName " +
							  "FROM PackagePlace, Places, PackageDate "+
							  "WHERE PackageDate.PackName = PackagePlace.PackName and "+
							  "PlaceName = PName and FromDate Between ? and ? and " +
							  "TouristSpots like ?" ;
				}
				else
				{
					sqlPack = "Select Distinct PackName From PackageDate where FromDate >= ? and FromDate <= ?";

				}

				packStmt = con.prepareStatement(sqlPack);
				packStmt.setString(1,(String)dtFrom.getSelectedItem());
				packStmt.setString(2,(String)dtTo.getSelectedItem());
				if(!strAct.equals(""))
				{

					Act = '%' + (String)txtAct.getText() + '%';
					packStmt.setString(3,(String)Act);
				}

				ResultSet rsPack = packStmt.executeQuery();
				int index = 0;
				lItems.clear();
				while(rsPack.next())
				{
					lItems.add(index++ , rsPack.getString(1));
				}

				sqlPack = "";
				Act = "";
				packStmt.close();
				con.close();
			}//try
			catch(Exception e)
			{
				System.out.println(e);
				//packStmt.close();
				//con.close();
			}//catch
		}//else

		}//butPack
	}//actionPerformed

}//AHCust
public class IHPackage implements ItemListener
{
	public void itemStateChanged(ItemEvent evt)
	{
//Change the Package Dates when the User selects a new Package
		if (evt.getSource() == cmbPName)
		{

		try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

				String cmdPack = "Select  fromdate from PackageDate where packname=?";
				PreparedStatement stmt = conn.prepareStatement(cmdPack);

				stmt.setString(1,(String)cmbPName.getSelectedItem());

				ResultSet rsPack = stmt.executeQuery();

				//Bind the variable to the required string

				//Remove the existing items from the combo box
				cmbPDate.removeAllItems();
				while(rsPack.next())
				{
				 cmbPDate.addItem((String)rsPack.getString(1));
				}//while
				stmt.close();
				conn.close();
			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}//catch

		}// End of cmbPack





	}//ItemStateChanged
}//IHPackage



public class LSHPack implements ListSelectionListener
{

	public void valueChanged(ListSelectionEvent evt)
	{

		if (evt.getValueIsAdjusting() == false)
		{
			// Create a new Row to add a member
			String strPack= "",strALux="",strABud="",strCLux="",strCBud="",strPlaces="";
			strPack = (String)lstPack.getSelectedValue();
			int ALux=0,ABud=0,CLux = 0,CBud=0;
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

				String cmdPack = "Select ExpenditureAdult , ExpenditureChild From Package where PackType = 'Luxury' and PackName = ?";
				PreparedStatement stmt = conn.prepareStatement(cmdPack);
				stmt.setString(1,strPack);
				ResultSet rsPackL = stmt.executeQuery();
				while(rsPackL.next())
				{
					  ALux = rsPackL.getInt(1);
					  CLux = rsPackL.getInt(2);
				}

				cmdPack = "Select ExpenditureAdult , ExpenditureChild From Package where PackType = 'Budget' and PackName = ?";
				stmt = conn.prepareStatement(cmdPack);
				stmt.setString(1,strPack);
				rsPackL = stmt.executeQuery();
				while(rsPackL.next())
				{
					  ABud = rsPackL.getInt(1);
					  CBud = rsPackL.getInt(2);
				}

				cmdPack = "Select Distinct PlaceName from PackagePlace where PackName = ?" ;
				stmt = conn.prepareStatement(cmdPack);
				stmt.setString(1,strPack);
				rsPackL = stmt.executeQuery();

				String strPName="";

				while(rsPackL.next())
				{
					if(strPlaces.equals(""))
					{
						strPlaces = rsPackL.getString(1);

					}
					else
					{
						strPlaces = strPlaces + "," + rsPackL.getString(1);

					}

				}

				stmt.close();

				PreparedStatement stmtPlace = conn.prepareStatement(cmdPack);
				stmtPlace.setString(1,strPack);
				ResultSet rsP = stmtPlace.executeQuery();


				while(rsP.next())
				{
					arrPlace[cntPlace++] = rsP.getString(1);
				}

				stmtPlace.close();
				conn.close();

			}//try
			catch(Exception e)
			{
				System.out.println(e);
			}//catch
       		int noOfCols  = PackObj.tblPack.getColumnCount();
			Object[] data = new Object[noOfCols];
			for(int col = 0; col< noOfCols; col++)
			data[col] = "";
			PackObj.defTabModel.addRow(data);
			int noOfRows  = PackObj.tblPack.getRowCount();

			PackObj.defTabModel.setValueAt((String)strPack,noOfRows-1,0);
			PackObj.defTabModel.setValueAt((String)strPlaces,noOfRows-1,1);
			PackObj.defTabModel.setValueAt(strALux.valueOf(ALux),noOfRows-1,2);
			PackObj.defTabModel.setValueAt(strCLux.valueOf(CLux),noOfRows-1,4);
			PackObj.defTabModel.setValueAt(strABud.valueOf(ABud),noOfRows-1,3);
			PackObj.defTabModel.setValueAt(strCBud.valueOf(CBud),noOfRows-1,5);

			//
		}//lstPack
	}//valueChanged
}//LSHPACK

public class CLCust implements ChangeListener
{
	public void stateChanged(ChangeEvent e)
	{
		SingleSelectionModel model = (SingleSelectionModel) e.getSource();
 		if(model.getSelectedIndex() == tabCust.getTabCount()-1)
 		{
			cntA = 0;
			cntC = 0;
			int noOfRows = memobj.tbldt.getRowCount();
			for(int cnt = 0; cnt<noOfRows; cnt++)
			{
				String strAge = (String)memobj.tbldt.getValueAt(cnt,3);
				h = Integer.parseInt(strAge);

				// Count No. of Children & Adults
				if ((h>=5) && (h<=11)) cntC++;
				else
					cntA++;

			}
				cntA++; // One for the Customer who books the package

			//Initailse the Text boxex inb the cost Tab
			txtNumA.setText(Integer.toString(cntA));
			txtNumC.setText(Integer.toString(cntC));

			//Get the Cost for Adult & child - Per Person
				try
				{

						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

						String cmdPackDetails = "Select ExpenditureChild,ExpenditureAdult from Package where PackName = ? and PackType = ?";
						PreparedStatement packStmt = con.prepareStatement(cmdPackDetails);
						packStmt.setString(1,(String)cmbPName.getSelectedItem());
						packStmt.setString(2,(String)cmbPType.getSelectedItem());
						ResultSet rspackDetails = packStmt.executeQuery();

						while(rspackDetails.next())
						{
							txtPersonA.setText(rspackDetails.getString(2));
							txtPersonC.setText(rspackDetails.getString(1));
						}

						// Get the Total Amt

						expA =  Integer.parseInt(txtPersonA.getText());
						expC =  Integer.parseInt(txtPersonC.getText());

						totalA = expA * cntA;
						totalC = expC * cntC;

						txtTotalA.setText(Integer.toString(totalA));
						txtTotalC.setText(Integer.toString(totalC));

						TotalWD = totalA + totalC;

						txtTotal.setText(Integer.toString(TotalWD));

			 	}//End of try

			    catch(Exception e1)
			    {
						 System.out.println(e1);
				}//catch

			}
 	}
}//CLCust
}//PlaceFrm
