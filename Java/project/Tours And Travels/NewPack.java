import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.util.*;
import javax.swing.text.*;
import java.io.*;
import java.applet.*;
import javax.accessibility.*;
import java.sql.*;
import java.net.*;
import javax.swing.event.*;



public class NewPack extends JPanel
{
	JLabel lblPackName,lblPackType,lblSrtPlace,lblNoPeople,lblNoDays,lblcost;
	JTextField txtPackName,txtPackType,txtNoPeople,txtNoDays;
	JComboBox cmbPackType,cmbSrtPlace;
	JButton butHDet,butTransDet;
	Plgrd plobj;
	Datedtl dtobj;
	static int TotalHotelRate,TotalTransRate1,TotalTransRate2;
	static String result="";

	JLabel lblAdult,lblAdultL,lblChild,lblChildL , lblHotel, lblTransport,lblFood,lblTotal ,lblTax,lblGTotal,lblPer,lblPerL;
	JTextField txtAHotel,txtAHotelL,txtATransport,txtATransportL,txtAFood,txtAFoodL,txtATotal,txtATotalL,txtAGTotal,txtAGTotalL;
	JTextField txtmarkup,txtCHotel,txtCHotelL,txtCTransport,txtCTransportL,txtCFood,txtCFoodL,txtCTotal,txtCTotalL,txtCGTotal,txtCGTotalL,txtTax,txtTaxL;
	JLabel lblimg,lblBudget,lblLuxury;
	ImageIcon imgcost;
	JButton buttonAdd,butAddDate,buttonDel,buttonEdit;
	JLabel lblmarkup,lblprofit;
	JTextField txtProfitAB,txtProfitAL,txtProfitCB,txtProfitCL;


	public static int HTotal, valueHRate,HTotalL, valueHRateL;
	public static int TABTotal,valueTRateAB;
	public static int TALTotal,valueTRateAL;
	public static int TCBTotal,valueTRateCB;
	public static int TCLTotal,valueTRateCL;
	public static float GTotalAB,GTotalAL,GTotalCB,GTotalCL,profitBA,profitLA,profitBC,profitLC;



	public static int CalcTotalAB,CalcTotalAL,CalcTotalCB,CalcTotalCL;

	JTabbedPane tabPackage;


	JButton butTCalc,butGTCalc,butOk,butCan;
	//JButton butOk,butCan;
	ImageIcon imgCancel,imgCan;

	JPanel pnlPacDetails = new JPanel();
	JPanel pnlPlaceDetails = new JPanel();
	JPanel pnlCostDetails = new JPanel();



	public NewPack()
	{
		setLayout(new BorderLayout());
		tabPackage = new JTabbedPane();



		dtobj = new Datedtl();
	//adding labels


		lblmarkup = new JLabel("Markup (%)");
		lblmarkup.setBounds(320,50,120,30);

		lblPackName=new JLabel("Package Name : ");
		lblPackName.setBounds(20,10,120,30);

		lblPackType=new JLabel("Package Type : ");
		lblPackType.setBounds(320,10,120,30);


		lblSrtPlace=new JLabel("Starting Place : ");
		lblSrtPlace.setBounds(20,50,120,30);

		lblNoPeople=new JLabel("Total Seats : ");
		lblNoPeople.setBounds(20,90,120,30);

		lblNoDays=new JLabel("Number Of Days : ");
		lblNoDays.setBounds(320,10,120,30);

//adding text boxes

		txtPackName=new JTextField(50);
		txtPackName.setBounds(140,10,140,25);


		txtNoPeople=new JTextField(50);
		txtNoPeople.setBounds(140,90,140,25);

		txtNoDays=new JTextField(50);
		txtNoDays.setBounds(440,10,140,25);

		txtmarkup=new JTextField(50);
		txtmarkup.setBounds(440,50,140,25);

//adding combobox to panel1

		cmbSrtPlace = new JComboBox();
		cmbSrtPlace.setBounds(140,50,140,25);
		cmbSrtPlace.setEditable(true);
		//cmbSrtPlace.addItem("");
		cmbSrtPlace.setSelectedItem("");

		cmbPackType = new JComboBox();
		cmbPackType.setBounds(440,10,140,25);
		cmbPackType.addItem("Budget");
		cmbPackType.addItem("Luxury");

//adding buttons

		/*imgCan = new ImageIcon("D:\\myjava\\Cancel.jpg");
		butCan = new JButton("",imgCan);
		butCan.setBounds(300,260,85,35);*/

		butAddDate = new JButton("Add Row");
		butAddDate.setBounds(90,290,100,30);

		ImageIcon imgpack;
		JLabel lblimgpack;

		lblimgpack=new JLabel("",new ImageIcon("c:\\rip\\images\\j1.jpg"),JLabel.CENTER);
		lblimgpack.setBounds(310,110,270,260);



		Border border = new EmptyBorder(1,1,1,1);
		border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);

		dtobj.setBorder(border);
		dtobj.setBounds(20,150,260,120);

		pnlPacDetails.setLayout(null);

		pnlPacDetails.add(lblPackName);
		pnlPacDetails.add(lblSrtPlace);
		pnlPacDetails.add(lblNoPeople);
		pnlPacDetails.add(lblNoDays);
		pnlPacDetails.add(lblmarkup);

		pnlPacDetails.add(txtPackName);
		pnlPacDetails.add(cmbSrtPlace);
		pnlPacDetails.add(txtNoDays);
		pnlPacDetails.add(txtNoPeople);
		pnlPacDetails.add(txtmarkup);
		pnlPacDetails.add(lblimgpack);
		pnlPacDetails.add(butAddDate);


		pnlPacDetails.add(dtobj);
////////////////////////////////////////////////////////////////////
	plobj= new Plgrd();
	plobj.setBorder(border);
	plobj.setBounds(10,20,590,230);

	buttonAdd = new JButton("Add Row");
	buttonAdd.setBounds(130,280,100,30);

	buttonEdit = new JButton("Edit Row");
	buttonEdit.setBounds(250,280,100,30);

	buttonDel = new JButton("Delete Row");
	buttonDel.setBounds(370,280,100,30);

//add components to panel

	pnlPlaceDetails.setLayout(null);
	pnlPlaceDetails.add(plobj);
	pnlPlaceDetails.add(buttonAdd);
	pnlPlaceDetails.add(buttonDel);
	pnlPlaceDetails.add(buttonEdit);
///////////////////////////////////////////////////////////////////


	lblimg=new JLabel("",new ImageIcon("c:\\myjava\\vinca.jpg"),JLabel.CENTER);
	//imgcost = new ImageIcon("c:\\Rip\\Images\\j1.jpg");
	lblimg.setBounds(430,50,170,180);


	butOk = new JButton("OK");
	butOk.setBounds(270,350,80,25);



	butCan = new JButton("Cancel");
	butCan.setBounds(370,350,80,25);


	butTCalc = new JButton("+");
	butTCalc.setBounds(110,190,45,25);

	butGTCalc = new JButton("+");
	butGTCalc.setBounds(110,270,45,25);


// ****************************************************************************************
	pnlCostDetails.setLayout(null);

	lblBudget = new JLabel("Budget");
	lblBudget.setBounds(230,3,100,30);

	lblLuxury = new JLabel("Luxury");
	lblLuxury.setBounds(470,3,100,30);

	lblAdult = new JLabel("Adult");
	lblAdult.setBounds(190,30,100,30);
	lblAdultL = new JLabel("Adult");
	lblAdultL.setBounds(420,30,100,30);


	lblChild = new JLabel("Child");
	lblChild.setBounds(290,30,100,30);
	lblChildL = new JLabel("Child");
	lblChildL.setBounds(520,30,100,30);


	lblHotel = new JLabel("Hotel");
	lblHotel.setBounds(20,70,100,30);

	lblTransport = new JLabel("Transport");
	lblTransport.setBounds(20,110,100,30);

	lblFood = new JLabel("Food");
	lblFood.setBounds(20,150,120,30);

	lblTotal = new JLabel("Total");
	lblTotal.setBounds(20,190,100,30);

	lblTax = new JLabel("Tax");
	lblTax.setBounds(20,230,100,30);

	lblGTotal = new JLabel("Grand Total");
	lblGTotal.setBounds(20,270,100,30);

	lblprofit = new JLabel("Grand Total(Profit)");
	lblprofit.setBounds(20,310,120,30);



	lblPer = new JLabel("%");
	lblPer.setBounds(280,230,30,30);
	lblPerL = new JLabel("%");
	lblPerL.setBounds(490,230,30,30);


	txtAHotel = new JTextField(10);
	txtAHotel.setBounds(170,70,70,25);
	txtAHotel.setEditable(false);
	txtAHotelL = new JTextField(10);
	txtAHotelL.setBounds(410,70,70,25);
	txtAHotelL.setEditable(false);

	txtATransport = new JTextField(10);
	txtATransport.setBounds(170,110,70,25);
	txtATransport.setEditable(false);
	txtATransportL = new JTextField(10);
	txtATransportL.setBounds(410,110,70,25);
	txtATransportL.setEditable(false);

	txtAFood = new JTextField(10);
	txtAFood.setBounds(170,150,70,25);
	txtAFoodL = new JTextField(10);
	txtAFoodL.setBounds(410,150,70,25);

	txtATotal = new JTextField(10);
	txtATotal.setBounds(170,190,70,25);
	txtATotal.setEditable(false);
	txtATotalL = new JTextField(10);
	txtATotalL.setBounds(410,190,70,25);
	txtATotalL.setEditable(false);

	txtAGTotal = new JTextField(10);
	txtAGTotal.setBounds(170,270,70,25);
	txtAGTotal.setEditable(false);
	txtAGTotalL = new JTextField(10);
	txtAGTotalL.setBounds(410,270,70,25);
	txtAGTotalL.setEditable(false);

	txtProfitAB = new JTextField(10);
	txtProfitAB.setBounds(170,310,70,25);
	txtProfitAB.setEditable(false);
	txtProfitAL = new JTextField(10);
	txtProfitAL.setBounds(410,310,70,25);
	txtProfitAL.setEditable(false);

	txtProfitCB = new JTextField(10);
	txtProfitCB.setBounds(270,310,70,25);
	txtProfitCB.setEditable(false);
	txtProfitCL = new JTextField(10);
	txtProfitCL.setBounds(510,310,70,25);
	txtProfitCL.setEditable(false);




	txtTax = new JTextField(10);
	txtTax.setBounds(170,230,70,25);
	txtTaxL = new JTextField(10);
	txtTaxL.setBounds(410,230,70,25);




	txtCHotel = new JTextField(10);
	txtCHotel.setBounds(270,70,70,25);
	txtCHotel.setEditable(false);
	txtCHotelL = new JTextField(10);
	txtCHotelL.setBounds(510,70,70,25);
	txtCHotelL.setEditable(false);

	txtCTransport = new JTextField(10);
	txtCTransport.setBounds(270,110,70,25);
	txtCTransport.setEditable(false);
	txtCTransportL = new JTextField(10);
	txtCTransportL.setBounds(510,110,70,25);
	txtCTransportL.setEditable(false);

	txtCFood = new JTextField(10);
	txtCFood.setBounds(270,150,70,25);
	txtCFoodL = new JTextField(10);
	txtCFoodL.setBounds(510,150,70,25);

	txtCTotal = new JTextField(10);
	txtCTotal.setBounds(270,190,70,25);
	txtCTotal.setEditable(false);
	txtCTotalL = new JTextField(10);
	txtCTotalL.setBounds(510,190,70,25);
	txtCTotalL.setEditable(false);

	txtCGTotal = new JTextField(10);
	txtCGTotal.setBounds(270,270,70,25);
	txtCGTotal.setEditable(false);
	txtCGTotalL = new JTextField(10);
	txtCGTotalL.setBounds(510,270,70,25);
	txtCGTotalL.setEditable(false);





	pnlCostDetails.add(lblBudget);
	pnlCostDetails.add(lblLuxury);
	pnlCostDetails.add(lblAdult);
	pnlCostDetails.add(lblAdultL);
	pnlCostDetails.add(lblChild);
	pnlCostDetails.add(lblChildL);
	pnlCostDetails.add(lblHotel);
	pnlCostDetails.add(lblTransport);
	pnlCostDetails.add(lblFood);
	pnlCostDetails.add(lblTotal);
	pnlCostDetails.add(lblTax);
	pnlCostDetails.add(lblGTotal);
	pnlCostDetails.add(lblprofit);

	pnlCostDetails.add(lblPer);
	pnlCostDetails.add(lblPerL);


	pnlCostDetails.add(txtAHotel);
	pnlCostDetails.add(txtATransport);
	pnlCostDetails.add(txtAFood);
	pnlCostDetails.add(txtATotal);
	pnlCostDetails.add(txtTax);
	pnlCostDetails.add(txtAGTotal);

	pnlCostDetails.add(txtAHotelL);
	pnlCostDetails.add(txtATransportL);
	pnlCostDetails.add(txtAFoodL);
	pnlCostDetails.add(txtATotalL);
	pnlCostDetails.add(txtTaxL);
	pnlCostDetails.add(txtAGTotalL);


	pnlCostDetails.add(txtCHotel);
	pnlCostDetails.add(txtCTransport);
	pnlCostDetails.add(txtCFood);
	pnlCostDetails.add(txtCTotal);
	pnlCostDetails.add(txtCGTotal);
	pnlCostDetails.add(butGTCalc);

	pnlCostDetails.add(txtCHotelL);
	pnlCostDetails.add(txtCTransportL);
	pnlCostDetails.add(txtCFoodL);
	pnlCostDetails.add(txtCTotalL);
	pnlCostDetails.add(txtCGTotalL);

	pnlCostDetails.add(txtProfitAB);
	pnlCostDetails.add(txtProfitAL);
	pnlCostDetails.add(txtProfitCB);
	pnlCostDetails.add(txtProfitCL);



	pnlCostDetails.add(butTCalc);


	pnlCostDetails.add(lblimg);
	pnlCostDetails.add(butOk);
	pnlCostDetails.add(butCan);

	tabPackage.addTab("Package Details",pnlPacDetails);
	tabPackage.addTab("Place Details",pnlPlaceDetails);
	tabPackage.addTab("Cost Details",pnlCostDetails);


	add(tabPackage);

	tabPackage.getModel().addChangeListener(new CLPack());




	butCan.addActionListener(new ALPack());
	butOk.addActionListener(new ALPack());
	buttonAdd.addActionListener(new ALPack());
	buttonEdit.addActionListener(new ALPack());
	buttonDel.addActionListener(new ALPack());
	butAddDate.addActionListener(new ALPack());
	butTCalc.addActionListener(new ALPack());
	butGTCalc.addActionListener(new ALPack());
	}

	public void connectCombo()
	{
		String placeName;
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
		Statement stmt = conn.createStatement();
		String cmdPlace = "Select PName from Places";
		ResultSet rsPlace = stmt.executeQuery(cmdPlace);
		while(rsPlace.next())
				   {
					placeName = rsPlace.getString(1);
					cmbSrtPlace.addItem(placeName);
					plobj.cmbToPlace.addItem(placeName);
		}//while
		stmt.close();
					conn.close();
	}//ent of try
	catch(Exception e)
			{
				System.out.println(e);
		}//catch

	}



	public static void main(String args[])
	{
		NewPack packtab = new NewPack();

		JFrame packfrm = new JFrame("Package Details");
		packfrm.setContentPane(packtab);
		packfrm.setSize(625,430);
		packfrm.setLocation(10,75);
		packfrm.setResizable(false);
		packfrm.setVisible(true);
		packtab.connectCombo();

		packfrm.addWindowListener(new WindowAdapter()
				{
					public void windowClosing(WindowEvent winevt)
					{
						System.exit(0);
					}
			});
	}//main


public class Datedtl extends JPanel
{
	String[] colnms={"Package Type","From Date"};
			Object[][] rowData={
								{"",""},
								};

			DefaultTableModel defTabModel = new DefaultTableModel(rowData,colnms);
			JTable tbldt = new JTable(defTabModel);

			JComboBox cmbPackType = new JComboBox();

			DateComboBox dcb1 = new DateComboBox();



			TableColumnModel colModel = tbldt.getColumnModel();
			TableColumn tblPackType = colModel.getColumn(0);
			TableColumn tblFromDate = colModel.getColumn(1);


		  	public Datedtl()
			{
				setLayout(new BorderLayout());
				tbldt.setLayout(null);

				cmbPackType.addItem("Budget");
				cmbPackType.addItem("Luxury");


				tblPackType.setCellEditor(new DefaultCellEditor(cmbPackType));
				tblFromDate.setCellEditor(new DefaultCellEditor(dcb1));


				add(tbldt.getTableHeader(),BorderLayout.NORTH);
				tbldt.setRowHeight(20);
				add(tbldt);

				add(new JScrollPane(tbldt));

	}
}//Datedtl


public class Plgrd extends JPanel
{

	String[] colnm={"From Place","To Place","Activities","HRate(B)","HRate(L)","Trans Adult(B)","Tran Child(B)","Tran Adult(L)","Tran Child(L)"};

	Object[][] row={
						{"","","","","","","","",""}

						};

	DefaultTableModel defTabModel = new DefaultTableModel(row,colnm);
	JTable pldt = new JTable(defTabModel);


	JComboBox cmbToPlace = new JComboBox();
	JComboBox cmbActivities = new JComboBox();


	TableColumnModel colModel = pldt.getColumnModel();
	TableColumn tblPlaceCol = colModel.getColumn(1);
	TableColumn tblActCol = colModel.getColumn(2);


		public Plgrd()
		{
		 	setLayout(new BorderLayout());

			cmbActivities.addItem("Select");



			tblPlaceCol.setCellEditor(new DefaultCellEditor(cmbToPlace));
			tblActCol.setCellEditor(new DefaultCellEditor(cmbActivities));


			//cmbToPlace.addItem("");


			pldt.setRowHeight(20);

			add(pldt);
			add(new JScrollPane(pldt));


			cmbToPlace.addActionListener(new ALPack());
			cmbActivities.addActionListener(new ALPack());


		}//Plgrd





}//PLgrd


class ALPack implements ActionListener
{
	public void actionPerformed(ActionEvent actEvt)
	{
		String temp="";
		int itemp=0;
		char ch;
		int len=0,i;

		if(actEvt.getSource() == plobj.cmbToPlace)
		{
			int rown = plobj.pldt.getSelectedRow();
			if(rown == -1) return;
			String plStr = (String)plobj.cmbToPlace.getSelectedItem();
			//plobj.connectHotel(plStr);

			String place ="";
			place = (String)cmbSrtPlace.getSelectedItem();
			if(place.equals(""))
			{
					JOptionPane.showMessageDialog(null,"Select Starting Place","Selection Error",JOptionPane.ERROR_MESSAGE);
					plobj.pldt.setValueAt("",0,0);
					return;
			}
			if (place.equals(plobj.cmbToPlace.getSelectedItem()) && (plobj.pldt.getRowCount()==1))
			{
					JOptionPane.showMessageDialog(null,"Source & Destination place are the same","Selection Error",JOptionPane.ERROR_MESSAGE);
					plobj.cmbToPlace.setSelectedItem("");
					plobj.pldt.setValueAt("None",0,1);
					plobj.pldt.setValueAt("",0,2);
					return;
			}

		}
		else




if (actEvt.getSource() == butOk)
{
//*****************************************************************************************


			/*temp = txtTax.getText();
			if(temp.equals (""))
			{
				JOptionPane.showMessageDialog(null,"Enter Tax charges for budget tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				txtTax.requestFocus();
				return;
			}


			temp = txtTax.getText();
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
					JOptionPane.showMessageDialog(null,"Enter Numerical Value For Tax Charges of budget tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					txtTax.setText("");
					txtTax.requestFocus();
					return;
				}
			}

			}

			itemp = Integer.parseInt(temp);

			if(itemp<=0)
			{
			JOptionPane.showMessageDialog(null,"Tax charges for budget tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
			txtTax.requestFocus();
			return;
			}




			temp = txtTaxL.getText();
						if(temp.equals (""))
						{
							JOptionPane.showMessageDialog(null,"Enter Tax charges for luxury tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
							txtTaxL.requestFocus();
							return;
						}


						temp = txtTaxL.getText();
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
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Tax Charges of luxury tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtTaxL.setText("");
								txtTaxL.requestFocus();
								return;
							}
						}

						}

						if(itemp<=0)
						{
						JOptionPane.showMessageDialog(null,"Tax charges for luxury tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtTaxL.requestFocus();
						return;
						}*/




//***********************************************************************************

		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement stmt = conn.createStatement();
			Statement stmtPack = conn.createStatement();
			Statement stmtPack1 = conn.createStatement();
			Statement stmtDel = conn.createStatement();
			Statement stmtPackDate = conn.createStatement();
			Statement stmtPackDateL = conn.createStatement();

			String cmdTemp = "Select * from TempPack";
			String cmdPack="",cmdValues="",Final="",cmdPack1="",cmdValues1="",Final1="";
			String cmdData="",cmdDataValues="";
			int resPack,resPack1;

			ResultSet restemp = stmt.executeQuery(cmdTemp);
			int brate=0,bcostA=0,bcostC=0, lrate=0,lcostA=0,lcostC=0;


			int cnt;

			for(cnt = 0;cnt<1;cnt++)
			{


				cmdPack = "Insert into Package (PackName,PackType,StartingPlace,NoOfPeople,NoOfDays,ExpenditureAdult,ExpenditureChild,FoodCostChild,FoodCostAdult,Tax,TotalHotelCost,TotalTransportCostAdult,TotalTransportCostChild) values('";
				String strPackTypeB = "Budget";


				while(restemp.next())
				{
							brate = restemp.getInt(13);
							bcostA = restemp.getInt(7);
							bcostC = restemp.getInt(9);
							lrate = restemp.getInt(14);
							lcostA = restemp.getInt(8);
							lcostC =restemp.getInt(10);
				}
							stmt.close();

				cmdValues = txtPackName.getText() + "','" +
							strPackTypeB +"','"+
							cmbSrtPlace.getSelectedItem() + "'," +
							txtNoPeople.getText() + ","  +
							txtNoDays.getText()+ ",'" +
							//txtAGTotal.getText()+"','"+
							txtProfitAB.getText()+"','"+
							//txtCGTotal.getText()+"','"+
							txtProfitCB.getText()+"','"+
							txtCFood.getText()+"','"+
							txtAFood.getText()+"','"+
							txtTax.getText()+"',"+
							brate+ "," +
							bcostA+ "," +
							bcostC+ ")";


				Final= cmdPack + cmdValues;
				resPack = stmtPack.executeUpdate(Final);
				int rowcnt = dtobj.defTabModel.getRowCount();


				for(int rcnt = 0; rcnt<=rowcnt-1;rcnt++)
				{

				//Check if entry is of type = BUDGET
				  if (dtobj.defTabModel.getValueAt(rcnt,0)=="Budget")
				  {
					  //Insert Data into Pack-Date Budget
					 String sqlDt = "Insert into PackageDate (PackName,PackType,FromDate,SeatsLeft) values('"+
					  				txtPackName.getText() + "','" +
					  				"Budget','"+
					  				dtobj.defTabModel.getValueAt(rcnt,1)+"',"+
								    txtNoPeople.getText()+")";
						Statement stmtDt = conn.createStatement();
						int resDt = stmtDt.executeUpdate(sqlDt);

						stmtDt.close();
				  }

					if (dtobj.defTabModel.getValueAt(rcnt,0)=="Luxury")
					 {
					  //Insert Data into Pack-Date Luxury
						String sqlDt1 = "Insert into PackageDate (PackName,PackType,FromDate,SeatsLeft) values('"+
						txtPackName.getText() + "','" +
						"Luxury','"+
						dtobj.defTabModel.getValueAt(rcnt,1)+"',"+
						txtNoPeople.getText()+")";
					Statement stmtDt1 = conn.createStatement();
					int resDt1 = stmtDt1.executeUpdate(sqlDt1);

					stmtDt1.close();
				  	}


			    }//for :rowcount


				stmtPack.close();
			}//End of for 1st loop

// Insert 2  :Luxury Details

				for (cnt =0 ; cnt<1;cnt++)
				{
				cmdPack1 = "Insert into Package (PackName,PackType,StartingPlace,NoOfPeople,NoOfDays,ExpenditureAdult,ExpenditureChild,FoodCostChild,FoodCostAdult,Tax,TotalHotelCost,TotalTransportCostAdult,TotalTransportCostChild) values('";
				String strPackTypeL = "Luxury";


				cmdValues1 = txtPackName.getText() + "','" +
											strPackTypeL + "','"+
											cmbSrtPlace.getSelectedItem() + "'," +
											txtNoPeople.getText() + ","  +
											txtNoDays.getText()+ ",'" +
											//txtAGTotalL.getText()+"','"+
											txtProfitAL.getText()+"','"+
											//txtCGTotalL.getText()+"','"+
											txtProfitCL.getText()+"','"+
											txtCFoodL.getText()+"','"+
											txtAFoodL.getText()+"','"+
											txtTaxL.getText()+"',"+
											lrate+ "," +
											lcostA+ "," +
											lcostC+ ")";




								Final1= cmdPack1 + cmdValues1;
								resPack1 = stmtPack1.executeUpdate(Final1);
								stmtPack1.close();

			}//End of 2nd for loop


			//Insert into Package Place

			String sqlPl = "Select * from PackagePlaceTemp";

			Statement stmtPackPlace = conn.createStatement();
			ResultSet rsPl = stmtPackPlace.executeQuery(sqlPl);

			while(rsPl.next())
			{
			String sqlpl = "Insert into PackagePlace(PackName,PackType,HName,DaysInHotel,TName,TMode,PlaceName,TId) values('"+
									rsPl.getString(1) + "','" +
									rsPl.getString(2)  + "','"+
									rsPl.getString(3) +"'," +
									rsPl.getInt(4) +",'" +
									rsPl.getString(5) +"','" +
									rsPl.getString(6) +"','" +
									rsPl.getString(7) +"','" +
									rsPl.getString(8) +"')";
						Statement stmtpl = conn.createStatement();
						int resDt1 = stmtpl.executeUpdate(sqlpl);

						stmtpl.close();

						String strDel = "Delete * from TempPack";
						int resDel = stmtDel.executeUpdate(strDel);
						stmtDel.close();

						String strPl = "Delete * from PackagePlaceTemp";
						Statement stmtPl = conn.createStatement();
						int resPl = stmtPl.executeUpdate(strPl);
						stmtPl.close();


			}



						stmtPackPlace.close();

			//Budget




			conn.close();
			}//try
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
			}//catch

			JOptionPane.showMessageDialog(null,"Record has been Saved.","Save",JOptionPane.INFORMATION_MESSAGE);
}

//**********************************************



if (actEvt.getSource() == butCan)
{
	try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);

				Statement stmtDel = conn.createStatement();

				String strDel = "Delete * from TempPack";
				int resDel = stmtDel.executeUpdate(strDel);

				stmtDel.close();

				//Remove entries from Package Place

				Statement stmtPlace = conn.createStatement();
				String strPlace = "Delete * from PackagePlaceTemp";
				int resPlace = stmtPlace.executeUpdate(strPlace);

				stmtDel.close();
				conn.close();
				}//try
				catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
			    }//catch

			    Tours.frmLog.setVisible(false);
				Tours.frmTours.setVisible(true);
				Tours.frmTours.setEnabled(true);
}


if (actEvt.getSource() ==butTCalc)
{

	temp = txtAFood.getText();
						if(temp.equals (""))
						{
							JOptionPane.showMessageDialog(null,"Enter Food charges for Adult","Incomplete Information",JOptionPane.ERROR_MESSAGE);
							txtAFood.requestFocus();
							return;
						}

						temp = txtAFood.getText();
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
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Food charges of Adult of budget tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtAFood.setText("");
								txtAFood.requestFocus();
								return;
							}
						}

						}
						itemp = Integer.parseInt(temp);

						if(itemp<=0)
						{
						JOptionPane.showMessageDialog(null,"Food cost of Adult for budget tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtAFood.requestFocus();
						return;
						}




							temp = txtAFoodL.getText();
							if(temp.equals (""))
							{
								JOptionPane.showMessageDialog(null,"Enter Food charges for Adult for budget tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
								txtAFoodL.requestFocus();
								return;
							}


							temp = txtAFoodL.getText();
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
									JOptionPane.showMessageDialog(null,"Enter Numerical Value For Food charges of Adult of luxury tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
									txtAFoodL.setText("");
									txtAFoodL.requestFocus();
									return;
								}
							}

							}
							itemp = Integer.parseInt(temp);

							if(itemp<=0)
							{
							JOptionPane.showMessageDialog(null,"Food cost of Adult for luxury tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
							txtAFoodL.requestFocus();
							return;
							}



									temp = txtCFood.getText();
									if(temp.equals (""))
									{
										JOptionPane.showMessageDialog(null,"Enter Food charges for Child for budget tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
										txtCFood.requestFocus();
										return;
									}


									temp = txtCFood.getText();
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
											JOptionPane.showMessageDialog(null,"Enter Numerical Value For Food charges of Child of budget tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
											txtCFood.setText("");
											txtCFood.requestFocus();
											return;
										}
									}

									}

									itemp = Integer.parseInt(temp);

									if(itemp<=0)
									{
									JOptionPane.showMessageDialog(null,"Food cost of Child for budget tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
									txtCFood.requestFocus();
									return;
									}



					temp = txtCFoodL.getText();
						if(temp.equals (""))
						{
							JOptionPane.showMessageDialog(null,"Enter Food charges for Child for luxury tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
							txtCFoodL.requestFocus();
							return;
						}


						temp = txtCFoodL.getText();
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
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Food charges of Child of luxury tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtCFoodL.setText("");
								txtCFoodL.requestFocus();
								return;
							}
						}

						}

						itemp = Integer.parseInt(temp);

						if(itemp<=0)
						{
						JOptionPane.showMessageDialog(null,"Food cost of Child for luxury tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtCFoodL.requestFocus();
						return;
					}



	String HATotalB = txtAHotel.getText();
	String HATotalL = txtAHotelL.getText();
	String HCTotalB = txtCHotel.getText();
	String HCTotalL = txtCHotelL.getText();

	String TATotalB = txtATransport.getText();
	String TATotalL = txtATransportL.getText();
	String TCTotalB = txtCTransport.getText();
	String TCTotalL = txtCTransportL.getText();

	String FATotalB =  txtAFood.getText();
	String FATotalL =  txtAFoodL.getText();
	String FCTotalB =  txtCFood.getText();
	String FCTotalL =  txtCFoodL.getText();


	int ATotalB = Integer.parseInt(HATotalB);
	int ATotalL = Integer.parseInt(HATotalL);
	int CTotalB = Integer.parseInt(HCTotalB);
	int CTotalL = Integer.parseInt(HCTotalL);

	int ATotalTB = Integer.parseInt(TATotalB);
	int ATotalTL = Integer.parseInt(TATotalL);
	int CTotalTB = Integer.parseInt(TCTotalB);
	int CTotalTL = Integer.parseInt(TCTotalL);

	int ATotalFB = Integer.parseInt(FATotalB);
	int ATotalFL = Integer.parseInt(FATotalL);
	int CTotalFB = Integer.parseInt(FCTotalB);
	int CTotalFL = Integer.parseInt(FCTotalL);

	//add all

	 CalcTotalAB = ATotalB + ATotalTB + ATotalFB;
	 CalcTotalAL = ATotalL + ATotalTL + ATotalFL;
	 CalcTotalCB = CTotalB + CTotalTB + CTotalFB;
	 CalcTotalCL = CTotalL + CTotalTL + CTotalFL;

	String dispCalcTotalAB="",dispCalcTotalAL="",dispCalcTotalCB="",dispCalcTotalCL="";

	txtATotal.setText(dispCalcTotalAB.valueOf(CalcTotalAB));
	txtATotalL.setText(dispCalcTotalAL.valueOf(CalcTotalAL));
	txtCTotal.setText(dispCalcTotalCB.valueOf(CalcTotalCB));
	txtCTotalL.setText(dispCalcTotalCL.valueOf(CalcTotalCL));


}




if (actEvt.getSource() == butGTCalc)
{


	temp = txtTax.getText();
				if(temp.equals (""))
				{
					JOptionPane.showMessageDialog(null,"Enter Tax charges for budget tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
					txtTax.requestFocus();
					return;
				}


				temp = txtTax.getText();
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
						JOptionPane.showMessageDialog(null,"Enter Numerical Value For Tax Charges of budget tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						txtTax.setText("");
						txtTax.requestFocus();
						return;
					}
				}

				}

				itemp = Integer.parseInt(temp);

				if(itemp<=0)
				{
				JOptionPane.showMessageDialog(null,"Tax charges for budget tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				txtTax.requestFocus();
				return;
				}




				temp = txtTaxL.getText();
							if(temp.equals (""))
							{
								JOptionPane.showMessageDialog(null,"Enter Tax charges for luxury tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
								txtTaxL.requestFocus();
								return;
							}


							temp = txtTaxL.getText();
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
									JOptionPane.showMessageDialog(null,"Enter Numerical Value For Tax Charges of luxury tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
									txtTaxL.setText("");
									txtTaxL.requestFocus();
									return;
								}
							}

							}

							if(itemp<=0)
							{
							JOptionPane.showMessageDialog(null,"Tax charges for luxury tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
							txtTaxL.requestFocus();
							return;
							}





	String taxB = txtTax.getText();

	String taxL = txtTaxL.getText();
	float bTax = Float.parseFloat(taxB);

	float lTax = Float.parseFloat(taxL);

	 GTotalAB = CalcTotalAB + (bTax/100*CalcTotalAB);
	 GTotalAL = CalcTotalAL + (lTax/100*(CalcTotalAL));


	 GTotalCB = CalcTotalCB + (bTax/100*CalcTotalCB);
	 GTotalCL = CalcTotalCL + (lTax/100*CalcTotalCL);

	String dispGTotalAB ="",dispGTotalAL="",dispGTotalCB="",dispGTotalCL="";
	txtAGTotal.setText(dispGTotalAB.valueOf(GTotalAB));
	txtCGTotal.setText(dispGTotalCB.valueOf(GTotalCB));
	txtAGTotalL.setText(dispGTotalAL.valueOf(GTotalAL));
	txtCGTotalL.setText(dispGTotalCL.valueOf(GTotalCL));


	String mrk = txtmarkup.getText();
	float mrkup = Float.parseFloat(mrk);
	profitBA = GTotalAB + (mrkup/100*GTotalAB);
	String disAB = "";
	txtProfitAB.setText(disAB.valueOf(profitBA));



	profitBC = GTotalCB + (mrkup/100*GTotalCB);
	String disCB = "";
	txtProfitCB.setText(disCB.valueOf(profitBC));

	profitLA = GTotalAL + (mrkup/100*GTotalAL);
	String disAL = "";
	txtProfitAL.setText(disAL.valueOf(profitLA));

	profitLC = GTotalCL + (mrkup/100*GTotalCL);
	String disCL = "";
	txtProfitCL.setText(disCL.valueOf(profitLC));


	GTotalAB=0;
	GTotalAL=0;
	GTotalCB =0;
	GTotalCL=0;
	profitBA=0;
	profitLA=0;
	profitBC=0;
	profitLC=0;



}

if (actEvt.getSource() == buttonAdd)
{

	int rowcnt = plobj.defTabModel.getRowCount();
	String rowVal;

	try
	{
	if(rowcnt >= 1)
	{
		String errStr = "";
		for(int c=0;c<5;c++)
		{

			rowVal = (String)plobj.defTabModel.getValueAt(rowcnt-1,c);


			if(rowVal.equals("") && (c!=4))
			{
				errStr = errStr + plobj.defTabModel.getColumnName(c) + ", ";
			}
			else
			if(rowVal.equals("") && (c==4))
			{
				errStr = errStr + plobj.defTabModel.getColumnName(c);
			}
			else
			if(rowVal.equals("None") && (c==1))
			{
				plobj.defTabModel.setValueAt("0",rowcnt-1,2);
			}

			else
			if(rowVal.equals("0") && (c==2))
			{
				String hName =(String)plobj.defTabModel.getValueAt(rowcnt-1,1);
				if(!(hName.equals("None")))
				{
					plobj.defTabModel.setValueAt("None",rowcnt-1,1);
				}
		    }



		}
		if(!errStr.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Enter Value For "+ errStr ,"Incomplete Information",JOptionPane.ERROR_MESSAGE);
			return;
		}

	}
}//try
catch(Exception e)
{
		System.out.println(e);
}//catch



	int colnum = plobj.defTabModel.getColumnCount();
	Object [] data = new Object[colnum];
	for(int col = 0;col<colnum;col++)
	{
		data[col] = "";
	}

	plobj.defTabModel.addRow(data);
	String toPlace = (String)plobj.pldt.getValueAt(rowcnt-1,1);
	plobj.pldt.setValueAt(toPlace,rowcnt,0);

}//buttonAdd

else

if(actEvt.getSource() == butAddDate)
{

	int rowcnt1 = dtobj.defTabModel.getRowCount();
	String rowVal1;
	String errStr1 = "";
	try
	{
		for(int c1=0;c1<2;c1++)
			{
				rowVal1 = (String)dtobj.defTabModel.getValueAt(rowcnt1-1,c1);
				if(rowVal1.equals("") && (c1!=2))
				{
					errStr1 = errStr1 + dtobj.defTabModel.getColumnName(c1) + ", ";
				}
				else
				if(rowVal1.equals("") && (c1==2))
				{
					errStr1 = errStr1 + dtobj.defTabModel.getColumnName(c1);
				}
			}
		if(!errStr1.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Value For "+ errStr1 ,"Incomplete Information",JOptionPane.ERROR_MESSAGE);
				return;
			}
	}//try
catch(Exception e)
{
	System.out.println(e);
}//catch



		int colnum = dtobj.defTabModel.getColumnCount();
			Object [] data = new Object[colnum];
			for(int col = 0;col<colnum;col++)
			{
				data[col] = "";
			}
			dtobj.defTabModel.addRow(data);

}//burAddDate


/*if(actEvt.getSource() == butOk)
{

	addRecs();

	int rowc = dtobj.tbldt.getRowCount();
					for (int j = 0;j<(rowc);j++)
					{
						addDateRecs(j);
					}//for





}//butOk*/


else
if(actEvt.getSource() == buttonDel)
{
	plobj.pldt.setRowSelectionAllowed(true);
	int rowsel = plobj.pldt.getSelectedRow();
	plobj.defTabModel.removeRow(rowsel);
	int rowcount = plobj.pldt.getRowCount();
	if(rowcount==0)
	{
		int colnum1 = plobj.defTabModel.getColumnCount();
		Object [] data = new Object[colnum1];
		for(int col = 0;col<colnum1;col++)
		{
			data[col] = "";
		}

	plobj.defTabModel.addRow(data);
}

}//butttonDel
//*******************************************************

if(actEvt.getSource() == buttonEdit)
{
	plobj.pldt.setRowSelectionAllowed(true);
	int rowsel1 = plobj.pldt.getSelectedRow();
	plobj.defTabModel.removeRow(rowsel1);
	int colnum2 = plobj.defTabModel.getColumnCount();
			Object [] data = new Object[colnum2];
			for(int col = 0;col<colnum2;col++)
			{
				data[col] = "";
			}

	plobj.defTabModel.insertRow(rowsel1,data);

	int rowc = plobj.pldt.getRowCount();

	if(rowc==1)
	{
		String source = (String)cmbSrtPlace.getSelectedItem();
		plobj.defTabModel.setValueAt(source,0,0);
	}
	if(rowc>1)
	{
	String source = (String)plobj.pldt.getValueAt((rowsel1-1),1);
	plobj.defTabModel.setValueAt(source,rowsel1,0);
	}

}//buttonEdit


if(actEvt.getSource() == plobj.cmbActivities)
{


	String act = (String)plobj.cmbActivities.getSelectedItem();
		if(act.equals("Select"))
	{


		dialog dlg = new dialog();


	}

}





}//actionPerformed
}//AHCust


public class CLPack implements ChangeListener
{
	public void stateChanged(ChangeEvent e)
	{
		String temp;
		int itemp=0;
		char ch;
		int len=0,i;


		SingleSelectionModel model = (SingleSelectionModel) e.getSource();
 		if(model.getSelectedIndex() == tabPackage.getTabCount()-1)
 		{
			//Validations of table data

			int rowcnt = plobj.defTabModel.getRowCount();
				String rowVal;

				try
				{
				if(rowcnt >= 1)
				{
					String errStr = "";
					for(int c=0;c<5;c++)
					{

						rowVal = (String)plobj.defTabModel.getValueAt(rowcnt-1,c);


						if(rowVal.equals("") && (c!=4))
						{
							errStr = errStr + plobj.defTabModel.getColumnName(c) + ", ";
						}
						else
						if(rowVal.equals("") && (c==4))
						{
							errStr = errStr + plobj.defTabModel.getColumnName(c);
						}
						else
						if(rowVal.equals("None") && (c==1))
						{
							plobj.defTabModel.setValueAt("0",rowcnt-1,2);
						}

						else
						if(rowVal.equals("0") && (c==2))
						{
							String hName =(String)plobj.defTabModel.getValueAt(rowcnt-1,1);
							if(!(hName.equals("None")))
							{
								plobj.defTabModel.setValueAt("None",rowcnt-1,1);
							}
					    }



					}
					if(!errStr.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Enter Value For "+ errStr ,"Incomplete Information",JOptionPane.ERROR_MESSAGE);
						return;
					}

				}
			}//try
			catch(Exception e1)
			{
					System.out.println(e1);
			}//catch




			int rownum = plobj.pldt.getRowCount();
			CalcHRateB(rownum);
			CalcHRateL(rownum);
			ClacTRateAdultB(rownum);
			ClacTRateAdultL(rownum);
			ClacTRateChildB(rownum);
			ClacTRateChildL(rownum);

		}



		if(model.getSelectedIndex() == tabPackage.getTabCount()-2)
		 		{

						temp = txtPackName.getText();
									if(temp.equals (""))
									{
										JOptionPane.showMessageDialog(null,"Enter Package Name","Incomplete Information",JOptionPane.ERROR_MESSAGE);
										pnlPacDetails.setVisible(true);
										txtPackName.requestFocus();
										return;
									}

						temp = txtNoPeople.getText();

						if(temp.equals (""))
						{
						JOptionPane.showMessageDialog(null,"Enter Total Number of Seats booked","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtNoPeople.requestFocus();
						pnlPacDetails.setVisible(true);
						return;
						}


						temp = txtNoPeople.getText();
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
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Total No. of seats","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtNoPeople.setText("");
								txtNoPeople.requestFocus();
								pnlPacDetails.setVisible(true);
								return;
							}
						}

						}



						itemp = Integer.parseInt(temp);

						if(itemp<=0)
						{
							JOptionPane.showMessageDialog(null,"Total Number of Seats not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
							txtNoPeople.requestFocus();
							pnlPacDetails.setVisible(true);
							return;
						}




						temp = txtNoDays.getText();

						if(temp.equals (""))
						{
							JOptionPane.showMessageDialog(null,"Enter Number of days of the tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
							txtNoDays.requestFocus();
							pnlPacDetails.setVisible(true);
							return;
						}

						temp = txtNoDays.getText();
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
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Number of Days","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtNoDays.setText("");
								txtNoDays.requestFocus();
								pnlPacDetails.setVisible(true);
								return;
							}
						}

					   }

					   itemp = Integer.parseInt(temp);

						if(itemp<=0)
						{
						JOptionPane.showMessageDialog(null,"Total Number of Days not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtNoDays.requestFocus();
						pnlPacDetails.setVisible(true);
						return;
						}



						temp = txtmarkup.getText();

									if(temp.equals (""))
									{
										JOptionPane.showMessageDialog(null,"Enter MarkUp value","Incomplete Information",JOptionPane.ERROR_MESSAGE);
										txtmarkup.requestFocus();
										pnlPacDetails.setVisible(true);
										return;
									}

									temp = txtmarkup.getText();
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
											JOptionPane.showMessageDialog(null,"Enter Numerical Value For MarkUp","Incorrect Format",JOptionPane.ERROR_MESSAGE);
											txtmarkup.setText("");
											txtmarkup.requestFocus();
											pnlPacDetails.setVisible(true);
											return;
										}
									}

								   }


								itemp = Integer.parseInt(temp);

								if(itemp<=0)
								{
								JOptionPane.showMessageDialog(null,"Total MarkUp Vlaue not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
								txtmarkup.requestFocus();
								pnlPacDetails.setVisible(true);
								return;
								}

								if(itemp>=100)
								{
								JOptionPane.showMessageDialog(null,"Total MarkUp Vlaue not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
								txtmarkup.requestFocus();
								pnlPacDetails.setVisible(true);
								return;
								}






						String startPlace =(String)cmbSrtPlace.getSelectedItem();
						plobj.pldt.setValueAt(startPlace,0,0);



		        }
	}
}





public void ClacTRateAdultB(int rowTAB)
{

String valueRateTAB="";
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
	Statement stmtAB = conn.createStatement();


		// Transport Rate of Adult for budget tour
			for(int i=0;i<=rowTAB-1;i++)
			{



				valueRateTAB =(String)plobj.pldt.getValueAt(i,5);


				valueTRateAB = Integer.parseInt(valueRateTAB);


				TABTotal = TABTotal + valueTRateAB;

			}
			String dispTAB="";

             txtATransport.setText(dispTAB.valueOf(TABTotal));

TABTotal=0;
stmtAB.close();
conn.close();


}//try
catch(Exception e)
{
	JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
}//catch



}

public void ClacTRateAdultL(int rowTAL)
{
	String valueRateTAL="";
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
		Statement stmtAL = conn.createStatement();



			// Transport Rate of Adult for Luxury tour
				for(int i=0;i<=rowTAL-1;i++)
				{



					valueRateTAL =(String)plobj.pldt.getValueAt(i,7);


					valueTRateAL = Integer.parseInt(valueRateTAL);


					TALTotal = TALTotal + valueTRateAL;

				}
				String dispTAL="";

	             txtATransportL.setText(dispTAL.valueOf(TALTotal));

	TALTotal=0;
	stmtAL.close();
	conn.close();

	}//try
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
	}//catch


}

public void ClacTRateChildB(int rowTCB)
{
	String valueRateTCB="";
	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement stmtCB = conn.createStatement();



				// Transport Rate of Child for budget tour
					for(int i=0;i<=rowTCB-1;i++)
					{



						valueRateTCB =(String)plobj.pldt.getValueAt(i,6);


						valueTRateCB = Integer.parseInt(valueRateTCB);


						TCBTotal = TCBTotal + valueTRateCB;

					}
					String dispTCB="";

		             txtCTransport.setText(dispTCB.valueOf(TCBTotal));

		TCBTotal=0;
		stmtCB.close();
		conn.close();

		}//try
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
		}//catch



}

public void ClacTRateChildL(int rowTCL)
{
	String valueRateTCL="";
	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			Statement stmtCL = conn.createStatement();



				// Transport Rate of Child for luxury tour
					for(int i=0;i<=rowTCL-1;i++)
					{



						valueRateTCL =(String)plobj.pldt.getValueAt(i,8);


						valueTRateCL = Integer.parseInt(valueRateTCL);


						TCLTotal = TCLTotal + valueTRateCL;

					}
					String dispTCL="";

		             txtCTransportL.setText(dispTCL.valueOf(TCLTotal));


	TCLTotal=0;
		stmtCL.close();
		conn.close();

		}//try
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
		}//catch


}





public void CalcHRateB(int row)
{
	String valueRate="";
	int days = 0;
	String cmdDays="";
						try
						{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
						Statement stmt = conn.createStatement();
						ResultSet ret1;


							// Hotel Rate of budget tour
								for(int i=0;i<=row-1;i++)
	 							{

									cmdDays = "select BDays from tempPack where Rowno =" + i;


										ret1 = stmt.executeQuery(cmdDays);
										while(ret1.next())
										{
											days = ret1.getInt(1);

										}



									valueRate =(String)plobj.pldt.getValueAt(i,3);
									valueHRate = Integer.parseInt(valueRate);

									HTotal = HTotal + valueHRate * days;

								}
								String dispH="";

					txtAHotel.setText(dispH.valueOf(HTotal));
					txtCHotel.setText(dispH.valueOf(HTotal));

					HTotal=0;
					stmt.close();
					conn.close();

					}//try
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
					}//catch


}



public void CalcHRateL(int rowL)
{
	String valueRateL="";
	int daysL = 0;
	String cmdDaysL="";
						try
						{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection connL = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
						Statement stmtL = connL.createStatement();
						ResultSet ret1L;


							// Hotel Rate of budget tour
								for(int j=0;j<=rowL-1;j++)
	 							{

									cmdDaysL = "select LDays from tempPack where Rowno =" + j;


										ret1L = stmtL.executeQuery(cmdDaysL);
										while(ret1L.next())
										{
											daysL = ret1L.getInt(1);
											}



									valueRateL =(String)plobj.pldt.getValueAt(j,4);


									valueHRateL = Integer.parseInt(valueRateL);


									HTotalL = HTotalL + valueHRateL * daysL;

								}
								String dispHL="";

					txtAHotelL.setText(dispHL.valueOf(HTotalL));
					txtCHotelL.setText(dispHL.valueOf(HTotalL));


					HTotalL=0;
					stmtL.close();
					connL.close();

					}//try
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
					}//catch


}





public void addRecs()
{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			String cmdInsert = "Insert into Package (PackName,PackType,StartingPlace,NoOfPeople,NoOfDays) values('";
			String cmdValues = cmdInsert + txtPackName.getText() + "','" +
							   cmbPackType.getSelectedItem() + "','" +
							   cmbSrtPlace.getSelectedItem() + "'," +
							   txtNoPeople.getText() + ","  +
							   txtNoDays.getText()+")";

			Statement stmt = conn.createStatement();
			int ret1 = stmt.executeUpdate(cmdValues);
			JOptionPane.showMessageDialog(null,"Record has been Saved.","Save",JOptionPane.ERROR_MESSAGE);
			stmt.close();
			conn.close();
			}//try
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
			}//catch
}


public void addDateRecs(int rowdt)
{
	String seats = (String)dtobj.tbldt.getValueAt(rowdt,0);

	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
		String cmdInsert = "Insert into PackageDate(PackName,SeatsLeft,FromDate) values('";
		String cmdValues = cmdInsert + txtPackName.getText() + "',"+
							 dtobj.tbldt.getValueAt(rowdt,0) + ",'"+
							 dtobj.tbldt.getValueAt(rowdt,1) + "')";


		Statement stmt = conn.createStatement();
		int ret1 = stmt.executeUpdate(cmdValues);
		JOptionPane.showMessageDialog(null,"Record has been Saved.","Save",JOptionPane.ERROR_MESSAGE);
		stmt.close();
		conn.close();
		}//try
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
	}//catch

}



public class dialog extends JPanel
{

	private JDialog dia = new JDialog((Frame)null," Details",true);
	JButton btOk;
	Trans tra;
	hot hdtl;
	SiteSeeing site;

	public dialog()
	{
	Container cont1 = dia.getContentPane();

	cont1.setLayout(null);


	Border border = BorderFactory.createEtchedBorder();
	Border hotelTitle = BorderFactory.createTitledBorder(border,"Hotel Details :");
	Border tranTitle = BorderFactory.createTitledBorder(border,"Transport Details :");
	Border siteTitle = BorderFactory.createTitledBorder(border,"SiteSeeing Details :");

	 tra = new Trans();
	 hdtl = new hot();
	 site = new SiteSeeing();


	tra.setBorder(tranTitle);
	tra.setBounds(10,0,450,210);


	hdtl.setBorder(hotelTitle);
	hdtl.setBounds(10,220,450,170);

	site.setBorder(siteTitle);
	site.setBounds(10,400,310,130);

		btOk = new JButton("OK");
		btOk.setBounds(330,495,100,25);
		btOk.addActionListener(new ActionDia());





	cont1.add(hdtl);
	cont1.add(tra);
	cont1.add(site);
	cont1.add(btOk);




	tra.txtCostAdult.setText("0");
	tra.txtCostAdultL.setText("0");
	tra.txtCostChild.setText("0");
	tra.txtCostChildL.setText("0");

	hdtl.txtHRate.setText("0");
	hdtl.txtHRateL.setText("0");
	hdtl.txtNoOfDays.setText("0");
	hdtl.txtNoOfDaysL.setText("0");

	site.txtPlaceSeen.setText("None");

	dia.setBounds(150,0,470,570);
	dia.show();


}


class ActionDia implements ActionListener
	{

		public void actionPerformed(ActionEvent actEvt2)
		{
			String temp;
			int itemp;
			int len,i;
			char ch;

			if(actEvt2.getSource() == btOk)
			{
				temp = hdtl.txtNoOfDays.getText();

				if(temp.equals (""))
				{
					JOptionPane.showMessageDialog(null,"Enter Total Number of Days in Hotel for budget tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
					hdtl.txtNoOfDays.requestFocus();
					return;
				}

				temp = hdtl.txtNoOfDays.getText();
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
						JOptionPane.showMessageDialog(null,"Enter Numerical Value for no. of Days in hotel for budget tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						hdtl.txtNoOfDays.setText("");
						hdtl.txtNoOfDays.requestFocus();
						return;
					}
				}

				}

				/*itemp = Integer.parseInt(temp);
				if(itemp<=0)
				{
					JOptionPane.showMessageDialog(null,"Total Number of Days in Hotel for budget tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
					hdtl.txtNoOfDays.requestFocus();
					return;
				}*/



		temp = hdtl.txtNoOfDaysL.getText();
						if(temp.equals (""))
						{
							JOptionPane.showMessageDialog(null,"Enter Total Number of Days in Hotel for luxury tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
							hdtl.txtNoOfDaysL.requestFocus();
							return;
						}

						temp = hdtl.txtNoOfDaysL.getText();
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
								JOptionPane.showMessageDialog(null,"Enter Numerical Value for no. of Days in hotel for luxury tour","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								hdtl.txtNoOfDaysL.setText("");
								hdtl.txtNoOfDaysL.requestFocus();
								return;
							}
						}

						}


								/*itemp = Integer.parseInt(temp);
								if(itemp<=0)
								{
									JOptionPane.showMessageDialog(null,"Total Number of Days in Hotel for luxury tour not Correct","Incomplete Information",JOptionPane.ERROR_MESSAGE);
									hdtl.txtNoOfDaysL.requestFocus();
									return;
								}*/



				try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection connTemp = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				Statement tempStmt = connTemp.createStatement();

				String query="";

				int rows = plobj.pldt.getRowCount()-1;
				String toPlace = (String)plobj.pldt.getValueAt(rows,1);

				query =        rows+",'"+
							   toPlace+"','"+
							   tra.cmbTMode.getSelectedItem()+"','"+
							   tra.cmbTModeL.getSelectedItem()+"','"+
							   tra.cmbTName.getSelectedItem()+"','"+
							   tra.cmbTNameL.getSelectedItem()+"',"+
							   tra.txtCostAdult.getText()+","+
							   tra.txtCostAdultL.getText()+","+
							   tra.txtCostChild.getText()+","+
							   tra.txtCostChildL.getText()+",'"+
							   hdtl.cmbHName.getSelectedItem()+"','"+
							   hdtl.cmbHNameL.getSelectedItem()+"',"+
							   hdtl.txtHRate.getText()+","+
							   hdtl.txtHRateL.getText()+","+
							   hdtl.txtNoOfDays.getText()+","+
							   hdtl.txtNoOfDaysL.getText()+",'"+
							   site.txtPlaceSeen.getText()+"'";



							  String tempstr ="Insert into TempPack(Rowno,ToPlace,BMode,LMode,BName,LName,BCostAdult,LCostAdult,BCostChild,LCostChild,BHName,LHName,BRate,LRate,BDays,Ldays,TSpots)"+
										   " values (" + query + ")";


				    		int rsTemp = tempStmt.executeUpdate(tempstr);



					//Insert into package place


					{
						// for Budget
						int r = plobj.pldt.getSelectedRow();
							String sqlpl = "Insert into PackagePlaceTemp(PackName,PackType,HName,DaysInHotel,TName,TMode,PlaceName,TId) values('"+
													txtPackName.getText() + "','" +
													"Budget','"+
													 hdtl.cmbHName.getSelectedItem() +"','" +
													hdtl.txtNoOfDays.getText() +"','" +
													tra.cmbTName.getSelectedItem() +"','" +
													tra.cmbTMode.getSelectedItem() +"','" +
													plobj.pldt.getValueAt(r,1) +"','1')" ;
												Statement stmtpl = connTemp.createStatement();
												int resDt1 = stmtpl.executeUpdate(sqlpl);

						stmtpl.close();

						//for luxury

						int r1 = plobj.pldt.getSelectedRow();
						String sqlpl1 = "Insert into PackagePlaceTemp(PackName,PackType,HName,DaysInHotel,TName,TMode,PlaceName,TId) values('"+
												txtPackName.getText() + "','" +
												"Luxury','"+
												 hdtl.cmbHNameL.getSelectedItem() +"','" +
												hdtl.txtNoOfDaysL.getText() +"','" +
												tra.cmbTNameL.getSelectedItem() +"','" +
												tra.cmbTModeL.getSelectedItem() +"','" +
												plobj.pldt.getValueAt(r1,1) +"','1')" ;
											Statement stmtpl1 = connTemp.createStatement();
											int resDt2= stmtpl1.executeUpdate(sqlpl1);

					stmtpl1.close();

					}

				connTemp.close();
				tempStmt.close();

				}//ent of try
				catch(Exception e)
				{
				System.out.println(e);
				}//catch


				dia.setVisible(false);

				int rowcur = plobj.pldt.getSelectedRow();

			///////displaying rates in the table/////////

			//transport rates
				String TRateAdultB = tra.txtCostAdult.getText();
				plobj.pldt.setValueAt(TRateAdultB,rowcur,5);
				String TRateChildB = tra.txtCostChild.getText();
				plobj.pldt.setValueAt(TRateChildB,rowcur,6);



				String TRateAdultL = tra.txtCostAdultL.getText();
				plobj.pldt.setValueAt(TRateAdultL,rowcur,7);
				String TRateChildL = tra.txtCostChildL.getText();
				plobj.pldt.setValueAt(TRateChildL,rowcur,8);


			//hotel rates
				String HRateB = hdtl.txtHRate.getText();
				plobj.pldt.setValueAt(HRateB,rowcur,3);
				String HRateL = hdtl.txtHRateL.getText();
				plobj.pldt.setValueAt(HRateL,rowcur,4);

			}//end of event

	}//end of function

}//end of listener













public class Trans extends JPanel
{
	JButton butOK = new JButton("OK");
	JLabel tMode,tName,costAdult,costChild,lblBudget,lblLuxury;
	JTextField txtCostAdult,txtCostChild,txtCostAdultL,txtCostChildL;
	JComboBox cmbTMode,cmbTName,cmbTModeL,cmbTNameL;

	public Trans()
	{
		setLayout(null);




		lblBudget=new JLabel("Budget   Tour");
		lblBudget.setBounds(130,20,80,25);

		lblLuxury=new JLabel("Luxury   Tour");
		lblLuxury.setBounds(320,20,80,25);


		tMode = new JLabel("     Mode");
		tMode.setBounds(10,60,80,25);


		tName = new JLabel("     Name");
		tName.setBounds(10,100,80,25);

		costAdult = new JLabel("Cost per Adult");
		costAdult.setBounds(10,140,80,25);


		costChild = new JLabel("Cost per Child");
		costChild.setBounds(10,180,80,25);


		cmbTMode = new JComboBox();
		cmbTMode.setBounds(120,60,100,25);

		cmbTMode.addItem("None");
		cmbTMode.addItem("Airway");
		cmbTMode.addItem("Railway");
		cmbTMode.addItem("Roadway");
		cmbTMode.addActionListener(new ActionList());

		cmbTModeL = new JComboBox();
		cmbTModeL.setBounds(320,60,100,25);
		cmbTModeL.addItem("None");
		cmbTModeL.addItem("Airway");
		cmbTModeL.addItem("Railway");
		cmbTModeL.addItem("Roadway");
		cmbTModeL.addActionListener(new ActionList());



		cmbTName = new JComboBox();
		cmbTName.setBounds(120,100,100,25);
		cmbTName.addActionListener(new ActionList());


		cmbTNameL = new JComboBox();
		cmbTNameL.setBounds(320,100,100,25);
		cmbTNameL.addActionListener(new ActionList());


		txtCostAdult = new JTextField(25);
		txtCostAdult.setBounds(120,140,100,25);
		txtCostAdult.setEditable(false);


		txtCostAdultL = new JTextField(25);
		txtCostAdultL.setBounds(320,140,100,25);
		txtCostAdultL.setEditable(false);

		txtCostChild = new JTextField(25);
		txtCostChild.setBounds(120,180,100,25);
		txtCostChild.setEditable(false);

		txtCostChildL = new JTextField(25);
		txtCostChildL.setBounds(320,180,100,25);
		txtCostChildL.setEditable(false);



		add(butOK);
		add(lblBudget);
		add(lblLuxury);
		add(tMode);
		add(tName);
		add(costAdult);
		add(costChild);
		add(cmbTMode);
		add(cmbTName);
		add(txtCostAdult);
		add(txtCostChild);


		add(cmbTModeL);
		add(cmbTNameL);
		add(txtCostAdultL);
		add(txtCostChildL);

		cmbTNameL.addItem("None");
		cmbTName.addItem("None");
	}





				class ActionList implements ActionListener
				{
					public void actionPerformed(ActionEvent actEvt1)
					{

						if(actEvt1.getSource() == cmbTMode)
						{

							int selrow = plobj.pldt.getSelectedRow();
							String selMode = (String)plobj.cmbActivities.getSelectedItem();
							plobj.pldt.setValueAt(selMode,selrow,2);

							int row3 = plobj.pldt.getSelectedRow();
							if(row3 == -1) return;
							cmbTName.removeAllItems();
							String strModeP1 =(String)cmbTMode.getSelectedItem();

							if(strModeP1=="None")
							{
							 cmbTName.addItem("None");
							}
							else
							connectTransport(strModeP1,row3)	;

						}



						if(actEvt1.getSource() == cmbTModeL)
						{

							int selrowL = plobj.pldt.getSelectedRow();
							String selModeL = (String)plobj.cmbActivities.getSelectedItem();
							plobj.pldt.setValueAt(selModeL,selrowL,2);

							int row3L = plobj.pldt.getSelectedRow();
							if(row3L == -1) return;
							cmbTNameL.removeAllItems();
							String strModeP1L =(String)cmbTModeL.getSelectedItem();
							if(strModeP1L=="None")
							{
								cmbTNameL.addItem("None");
							}
							else
							connectTransportL(strModeP1L,row3L)	;

						}


						if(actEvt1.getSource() == cmbTName)
						{
								int row4 = plobj.pldt.getSelectedRow();
								if(row4 == -1) return;

								String transName = (String)cmbTName.getSelectedItem();



								String transMode = (String)cmbTMode.getSelectedItem();


								CalcTransRateB(row4,transName,transMode);



						}

						if(actEvt1.getSource() == cmbTNameL)
						{
								int row4L = plobj.pldt.getSelectedRow();
								if(row4L == -1) return;

								String transNameL = (String)cmbTNameL.getSelectedItem();



								String transModeL = (String)cmbTModeL.getSelectedItem();


								CalcTransRateL(row4L,transNameL,transModeL);



						}




				    }
				}


					public void connectTransport(String strMode,int row2)
										{
											String transName;
											try{
											Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
											Connection conn1 = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
											String cmdTransport = "Select TName from Transport where DestPlace=? and TMode=? and SourcePlace=?";
											PreparedStatement stmtTrans = conn1.prepareStatement(cmdTransport);


											if (row2 == -1) return;

											String sourcePlace;
											String destPlace = (String)plobj.pldt.getValueAt((row2),1);
											stmtTrans.setString(1,(String)destPlace);
											stmtTrans.setString(2,(String)strMode);



											sourcePlace = (String)plobj.pldt.getValueAt((row2),0);
											stmtTrans.setString(3,(String)sourcePlace);


											ResultSet rsTransport = stmtTrans.executeQuery();
											cmbTName.removeAllItems();



											while(rsTransport.next())
										   {
											transName = rsTransport.getString(1);


											cmbTName.addItem(transName);




											}//while
											stmtTrans.close();
											conn1.close();
										}//ent of try
										catch(Exception e)
												{
													System.out.println(e);
												}//catch
										}//connectTransprot




					public void connectTransportL(String strModeL,int row2L)
					{
						String transNameL;
						try{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection conn1L = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
						String cmdTransportL = "Select TName from Transport where DestPlace=? and TMode=? and SourcePlace=?";
						PreparedStatement stmtTransL = conn1L.prepareStatement(cmdTransportL);


						if (row2L == -1) return;

						String sourcePlaceL;
						String destPlaceL = (String)plobj.pldt.getValueAt((row2L),1);
						stmtTransL.setString(1,(String)destPlaceL);
						stmtTransL.setString(2,(String)strModeL);



						sourcePlaceL = (String)plobj.pldt.getValueAt((row2L),0);
						stmtTransL.setString(3,(String)sourcePlaceL);



						ResultSet rsTransportL = stmtTransL.executeQuery();

						cmbTNameL.removeAllItems();


						while(rsTransportL.next())
					   {
						transNameL = rsTransportL.getString(1);


						cmbTNameL.addItem(transNameL);




						}//while
						stmtTransL.close();
						conn1L.close();
					}//ent of try
					catch(Exception e)
							{
								System.out.println(e);
							}//catch
					}//connectTransprotL







	public void CalcTransRateL(int row5L,String tNameL,String tModeL)
	{
		String destPlaceNameL = (String)plobj.pldt.getValueAt(row5L,1);



			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn1L = DriverManager.getConnection("jdbc:odbc:Tours",null,null);


				String strsql="select LuxuryCostAdult from Transport where TMode = '" + tModeL + "' and TName= '"+tNameL + "'and DestPlace='"+destPlaceNameL+"'";
				String strsql2="select LuxuryCostChild from Transport where TMode = '" + tModeL + "' and TName= '"+tNameL + "'and DestPlace='"+destPlaceNameL+"'";



				PreparedStatement stmtCalcTransLA = conn1L.prepareStatement(strsql);
				PreparedStatement stmtCalcTransLC = conn1L.prepareStatement(strsql2);



				ResultSet rsLA = stmtCalcTransLA.executeQuery();
				ResultSet rsLC = stmtCalcTransLC.executeQuery();




				while(rsLA.next())
				{
					txtCostAdultL.setText(rsLA.getString(1));

				}

				while(rsLC.next())
				{

					txtCostChildL.setText(rsLC.getString(1));
					}




				stmtCalcTransLA.close();
				stmtCalcTransLC.close();
				conn1L.close();

				}//ent of try
				catch(Exception e)
				{
				System.out.println(e);
				}//catch



			}



public void CalcTransRateB(int row5,String tName,String tMode)
	{
		String destPlaceName = (String)plobj.pldt.getValueAt(row5,1);


			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn1 = DriverManager.getConnection("jdbc:odbc:Tours",null,null);



				String strsql3="select BudgetCostAdult from Transport where TMode = '" + tMode + "' and TName= '"+tName + "'and DestPlace='"+destPlaceName+"'";
				String strsql4="select BudgetCostChild from Transport where TMode = '" + tMode + "' and TName= '"+tName + "'and DestPlace='"+destPlaceName+"'";


				PreparedStatement stmtCalcTransA = conn1.prepareStatement(strsql3);
				PreparedStatement stmtCalcTransC = conn1.prepareStatement(strsql4);




				ResultSet rsBA = stmtCalcTransA.executeQuery();
				ResultSet rsBC = stmtCalcTransC.executeQuery();

				while(rsBA.next())
				{
					txtCostAdult.setText(rsBA.getString(1));

				}

				while(rsBC.next())
				{

					txtCostChild.setText(rsBC.getString(1));
					}




				stmtCalcTransA.close();
				stmtCalcTransC.close();
				conn1.close();

				}//ent of try
				catch(Exception e)
				{
				System.out.println(e);
				}//catch



			}








}//end of trans




public class hot extends JPanel
{

	JLabel lblHName,lblHRate,lblNoOfDays,lblBudget,lblLuxury;
	JTextField txtHRate,txtNoOfDays,txtHRateL,txtNoOfDaysL;
	JComboBox cmbHName,cmbHNameL;

	public hot()
	{
		setLayout(null);



		lblBudget=new JLabel("Budget   Tour");
		lblBudget.setBounds(130,20,80,25);

		lblLuxury=new JLabel("Luxury   Tour");
		lblLuxury.setBounds(320,20,80,25);


		lblHName = new JLabel("Hotel    Name");
		lblHName.setBounds(10,60,80,25);


		lblHRate = new JLabel("     Rate");
		lblHRate.setBounds(10,100,80,25);

		lblNoOfDays = new JLabel("Number of Days");
		lblNoOfDays.setBounds(10,140,100,25);

		cmbHName = new JComboBox();
		cmbHName.setBounds(120,60,100,25);
		cmbHName.addActionListener(new ActionListHotel());


		cmbHNameL = new JComboBox();
		cmbHNameL.setBounds(310,60,100,25);
		cmbHNameL.addActionListener(new ActionListHotel());


		txtHRate = new JTextField(25);
		txtHRate.setBounds(120,100,100,25);
		txtHRate.setEditable(false);


		txtHRateL = new JTextField(25);
		txtHRateL.setBounds(310,100,100,25);
		txtHRateL.setEditable(false);

		txtNoOfDays = new JTextField(25);
		txtNoOfDays.setBounds(120,140,100,25);

		txtNoOfDaysL = new JTextField(25);
		txtNoOfDaysL.setBounds(310,140,100,25);


		add(lblBudget);
		add(lblLuxury);
		add(lblHName);
		add(lblHRate);
		add(lblNoOfDays);
		add(cmbHName);
		add(txtHRate);
		add(txtNoOfDays);
		add(cmbHNameL);
		add(txtHRateL);
		add(txtNoOfDaysL);




				int rowselect = plobj.pldt.getSelectedRow();

				if (rowselect==-1)
				return;


				String place = (String)plobj.pldt.getValueAt(rowselect,1);
				ConnectHot(place);
				ConnectHotL(place);


}



public void ConnectHot(String place1)
{

	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connH = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			String cmdGetValues = "Select HName from Hotel where HCity='" + place1+"'" ;
			Statement stmt = connH.createStatement();

			ResultSet res1 = stmt.executeQuery(cmdGetValues);

			cmbHName.removeAllItems();
			cmbHName.addItem("None");
			while(res1.next())
			{

			cmbHName.addItem(res1.getString(1));

		    }

			stmt.close();
			connH.close();
			}//try
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
		}//catch

}




public void ConnectHotL(String place1)
{

	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connH = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			String cmdGetValues = "Select HName from Hotel where HCity='" + place1+"'" ;

			Statement stmt = connH.createStatement();

			ResultSet res1 = stmt.executeQuery(cmdGetValues);

			cmbHNameL.removeAllItems();
			cmbHNameL.addItem("None");
			while(res1.next())
			{

			cmbHNameL.addItem(res1.getString(1));

		    }

			stmt.close();
			connH.close();
			}//try
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e,"Database Error",JOptionPane.ERROR_MESSAGE);
		}//catch






}





class ActionListHotel implements ActionListener
				{
					public void actionPerformed(ActionEvent actEvtHot)
					{

						if(actEvtHot.getSource() == cmbHName)
						{



							int rowHB = plobj.pldt.getSelectedRow();
							if(rowHB == -1) return;


							String hname=(String)cmbHName.getSelectedItem();

							CalcHotRateB(rowHB,hname);

						}


						if(actEvtHot.getSource() == cmbHNameL)
						{



							int rowHL = plobj.pldt.getSelectedRow();
							if(rowHL == -1) return;


							String hnameL=(String)cmbHNameL.getSelectedItem();

							CalcHotRateL(rowHL,hnameL);

						}


					}
				}


				public void CalcHotRateB(int rowBH,String HNameB)
				{


					try{
									Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
									Connection connHB = DriverManager.getConnection("jdbc:odbc:Tours",null,null);



									String strsqlHB="select NonAcRate from Hotel where HName = '" + HNameB +"'";
	//


									PreparedStatement stmtCalcHotB = connHB.prepareStatement(strsqlHB);





									ResultSet rsHB = stmtCalcHotB.executeQuery();


									while(rsHB.next())
									{
										txtHRate.setText(rsHB.getString(1));

									}




									stmtCalcHotB.close();

									connHB.close();

									}//ent of try
									catch(Exception e)
									{
									System.out.println(e);
									}//catch




				}





				public void CalcHotRateL(int rowLH,String HNameL)
				{


					try
					{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection connHL = DriverManager.getConnection("jdbc:odbc:Tours",null,null);



					String strsqlHL="select AcRate from Hotel where HName = '" + HNameL +"'";



					PreparedStatement stmtCalcHotL = connHL.prepareStatement(strsqlHL);





					ResultSet rsHL = stmtCalcHotL.executeQuery();


					while(rsHL.next())
					{
						txtHRateL.setText(rsHL.getString(1));

					}




					stmtCalcHotL.close();

					connHL.close();

					}//ent of try
					catch(Exception e)
					{
					System.out.println(e);
					}//catch




				}





}//end of hot


public class SiteSeeing extends JPanel
{
	TextArea txtPlaceSeen;
	JLabel lblPlacesVisited;
	JButton butView;

	SiteSeeing()
	{
		setLayout(null);
		lblPlacesVisited =new JLabel("Places Visited");
		lblPlacesVisited.setBounds(10,30,100,25);

		txtPlaceSeen =new TextArea();
		txtPlaceSeen.setBounds(10,60,210,60);

		butView = new JButton("View");
		butView.setBounds(230,95,70,25);
		butView.addActionListener(new ActListSite());

		add(txtPlaceSeen);
		add(lblPlacesVisited);
		add(butView);

	}


	public class ActListSite implements ActionListener
	{

		public void actionPerformed(ActionEvent actEvtSite)
							{

								if(actEvtSite.getSource() == butView)
								{
									int rowselected = plobj.pldt.getSelectedRow();
									String pName = (String)plobj.pldt.getValueAt(rowselected,1);
									ConnectPlacesVisited(pName);
								}



						}

	}



	public void ConnectPlacesVisited(String pnm)
	{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection connS = DriverManager.getConnection("jdbc:odbc:Tours",null,null);



		String strsqlS="select TouristSpots from Places where Pname = '" + pnm +"'";



		PreparedStatement stmtS = connS.prepareStatement(strsqlS);





		ResultSet rsS = stmtS.executeQuery();


		String places = "";
		while(rsS.next())
		{

			places=places + rsS.getString(1)+"  ";
			txtPlaceSeen.setText(places);


		}




		stmtS.close();

		connS.close();

		}//ent of try
		catch(Exception e)
		{
		System.out.println(e);
		}//catch




	}


}//end of siteSeeing











}//dialog





	}//Pack