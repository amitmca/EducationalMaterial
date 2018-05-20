import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.util.*;
import java.text.*;
import javax.swing.text.*;
import java.io.*;
import java.applet.*;
import javax.accessibility.*;
import java.sql.*;
import java.net.*;
import javax.swing.event.*;
import java.lang.Object.*;





public class Pack extends JPanel
{
	JLabel lblPackName,lblPackType,lblSrtPlace,lblNoPeople,lblNoDays,lblcost;
	JTextField txtPackName,txtPackType,txtNoPeople,txtNoDays;
	JComboBox cmbPackType,cmbSrtPlace;
	JButton butHDet,butTransDet;
	Plgrd plobj;
	Datedtl dtobj;
	static int TotalHotelRate,TotalTransRate1,TotalTransRate2;

	JLabel lblAdult , lblChild ,lblHotel, lblTransport,lblFood,lblTotal ,lblTax,lblGTotal,lblPer;
	JTextField txtAHotel,txtATransport,txtAFood,txtATotal,txtAGTotal;
	JTextField txtCHotel,txtCTransport,txtCFood,txtCTotal,txtCGTotal,txtTax;
	JLabel lblimg;
	ImageIcon imgcost;
	JButton buttonAdd,butAddDate,buttonDel,buttonEdit;

	JTabbedPane tabPackage;


	JButton butTCalc,butGTCalc,butOk,butCan;
	//JButton butOk,butCan;
	ImageIcon imgCancel,imgCan;

	JPanel pnlPacDetails = new JPanel();
	JPanel pnlPlaceDetails = new JPanel();
	JPanel pnlCostDetails = new JPanel();



	public Pack()
	{
		setLayout(new BorderLayout());
		tabPackage = new JTabbedPane();



		dtobj = new Datedtl();
	//adding labels
		lblPackName=new JLabel("Package Name : ");
		lblPackName.setBounds(20,10,120,30);

		lblPackType=new JLabel("Package Type : ");
		lblPackType.setBounds(320,10,120,30);


		lblSrtPlace=new JLabel("Starting Place : ");
		lblSrtPlace.setBounds(20,50,120,30);

		lblNoPeople=new JLabel("Total Seats : ");
		lblNoPeople.setBounds(20,90,120,30);

		lblNoDays=new JLabel("Number Of Days : ");
		lblNoDays.setBounds(320,50,120,30);

//adding text boxes

		txtPackName=new JTextField(50);
		txtPackName.setBounds(140,10,140,25);

//		txtSrtPlace=new JTextField(50);
//		txtSrtPlace.setBounds(140,50,130,25);

		txtNoPeople=new JTextField(50);
		txtNoPeople.setBounds(140,90,140,25);

		txtNoDays=new JTextField(50);
		txtNoDays.setBounds(440,50,140,25);

//adding combobox to panel1

		cmbSrtPlace = new JComboBox();
		cmbSrtPlace.setBounds(140,50,140,25);
		cmbSrtPlace.addItem("");
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
		butAddDate.setBounds(80,260,100,30);

		ImageIcon imgpack;
		JLabel lblimgpack;

		lblimgpack=new JLabel("",new ImageIcon("c:\\Rip\\Paradise.jpg"),JLabel.CENTER);
		imgpack = new ImageIcon("c:\\myjava\\vinca.jpg");
		lblimgpack.setBounds(300,90,270,180);



		Border border = new EmptyBorder(1,1,1,1);
		border = new BevelBorder(EtchedBorder.LOWERED,Color.gray,Color.gray);

		dtobj.setBorder(border);
		dtobj.setBounds(20,130,260,120);

		pnlPacDetails.setLayout(null);

		pnlPacDetails.add(lblPackName);
		pnlPacDetails.add(lblPackType);
		pnlPacDetails.add(lblSrtPlace);
		pnlPacDetails.add(lblNoPeople);
		pnlPacDetails.add(lblNoDays);

		pnlPacDetails.add(txtPackName);
		pnlPacDetails.add(cmbSrtPlace);
		pnlPacDetails.add(txtNoDays);
		pnlPacDetails.add(txtNoPeople);
		pnlPacDetails.add(cmbPackType);
		pnlPacDetails.add(lblimgpack);
		pnlPacDetails.add(butAddDate);

		pnlPacDetails.add(dtobj);
////////////////////////////////////////////////////////////////////
	plobj= new Plgrd();
	plobj.setBorder(border);
	plobj.setBounds(10,20,590,230);

	buttonAdd = new JButton("Add Row");
	buttonAdd.setBounds(130,260,100,30);

	buttonEdit = new JButton("Edit Row");
	buttonEdit.setBounds(250,260,100,30);

	buttonDel = new JButton("Delete Row");
	buttonDel.setBounds(370,260,100,30);

//add components to panel

	pnlPlaceDetails.setLayout(null);
	pnlPlaceDetails.add(plobj);
	pnlPlaceDetails.add(buttonAdd);
	pnlPlaceDetails.add(buttonDel);
	pnlPlaceDetails.add(buttonEdit);
///////////////////////////////////////////////////////////////////


	lblimg=new JLabel("",new ImageIcon("c:\\myjava\\vinca.jpg"),JLabel.CENTER);
	imgcost = new ImageIcon("c:\\myjava\\vinca.jpg");
	lblimg.setBounds(430,50,170,180);

	butOk = new JButton("OK");
	butOk.setBounds(430,250,80,25);

	butCan = new JButton("Cancel");
	butCan.setBounds(525,250,80,25);


	butTCalc = new JButton("+");
	butTCalc.setBounds(110,170,45,25);
	butGTCalc = new JButton("+");
	butGTCalc.setBounds(110,250,45,25);
	butHDet = new JButton("...");
	butHDet.setBounds(360,50,45,25);

	butTransDet = new JButton(". . .");
	butTransDet.setBounds(360,90,45,25);


	pnlCostDetails.setLayout(null);
	lblAdult = new JLabel("Adult");
	lblAdult.setBounds(190,10,100,30);
	lblChild = new JLabel("Child");
	lblChild.setBounds(290,10,100,30);
	lblHotel = new JLabel("Hotel");
	lblHotel.setBounds(20,50,100,30);
	lblTransport = new JLabel("Transport");
	lblTransport.setBounds(20,90,100,30);
	lblFood = new JLabel("Food");
	lblFood.setBounds(20,130,100,30);
	lblTotal = new JLabel("Total");
	lblTotal.setBounds(20,170,100,30);
	lblTax = new JLabel("Tax");
	lblTax.setBounds(20,210,100,30);
	lblGTotal = new JLabel("Grand Total");
	lblGTotal.setBounds(20,250,100,30);

	lblPer = new JLabel("%");
	lblPer.setBounds(280,210,30,30);

	txtAHotel = new JTextField(10);
	txtAHotel.setBounds(170,50,80,25);
	txtAHotel.setEditable(false);
	txtATransport = new JTextField(10);
	txtATransport.setBounds(170,90,80,25);
	txtATransport.setEditable(false);
	txtAFood = new JTextField(10);
	txtAFood.setBounds(170,130,80,25);
	txtATotal = new JTextField(10);
	txtATotal.setBounds(170,170,80,25);
	txtATotal.setEditable(false);
	txtAGTotal = new JTextField(10);
	txtAGTotal.setBounds(170,250,80,25);
	txtAGTotal.setEditable(false);
	txtTax = new JTextField(10);
	txtTax.setBounds(170,210,80,25);


	txtCHotel = new JTextField(10);
	txtCHotel.setBounds(270,50,80,25);
	txtCHotel.setEditable(false);
	txtCTransport = new JTextField(10);
	txtCTransport.setBounds(270,90,80,25);
	txtCTransport.setEditable(false);
	txtCFood = new JTextField(10);
	txtCFood.setBounds(270,130,80,25);
	txtCTotal = new JTextField(10);
	txtCTotal.setBounds(270,170,80,25);
	txtCTotal.setEditable(false);
	txtCGTotal = new JTextField(10);
	txtCGTotal.setBounds(270,250,80,25);
	txtCGTotal.setEditable(false);



	//pnlCostDetails.add(lblcost);
	pnlCostDetails.add(lblAdult);
	pnlCostDetails.add(lblChild);
	pnlCostDetails.add(lblHotel);
	pnlCostDetails.add(lblTransport);
	pnlCostDetails.add(lblFood);
	pnlCostDetails.add(lblTotal);
	pnlCostDetails.add(lblTax);
	pnlCostDetails.add(lblGTotal);
	pnlCostDetails.add(lblPer);

	pnlCostDetails.add(txtAHotel);
	pnlCostDetails.add(txtATransport);
	pnlCostDetails.add(txtAFood);
	pnlCostDetails.add(txtATotal);
	pnlCostDetails.add(txtTax);
	pnlCostDetails.add(txtAGTotal);

	pnlCostDetails.add(txtCHotel);
	pnlCostDetails.add(txtCTransport);
	pnlCostDetails.add(txtCFood);
	pnlCostDetails.add(txtCTotal);
	pnlCostDetails.add(txtCGTotal);
	pnlCostDetails.add(butTCalc);
	pnlCostDetails.add(butGTCalc);
	pnlCostDetails.add(butHDet);
	pnlCostDetails.add(butTransDet);
	pnlCostDetails.add(lblimg);
	pnlCostDetails.add(butOk);
	pnlCostDetails.add(butCan);

	tabPackage.addTab("Package Details",pnlPacDetails);
	tabPackage.addTab("Place Details",pnlPlaceDetails);
	tabPackage.addTab("Cost Details",pnlCostDetails);



	add(tabPackage);

	tabPackage.getModel().addChangeListener(new CLPack());


	/*tabPackage.getModel().addChangeListener(
	 	   new ChangeListener() {
	 	      public void stateChanged(ChangeEvent e) {
	 		  SingleSelectionModel model = (SingleSelectionModel) e.getSource();
	 		  if(model.getSelectedIndex() == tabPackage.getTabCount()-1) {
	 		      System.out.println("cvc");
	 		  }
	 	      }
	 	   }
 	);*/




	butCan.addActionListener(new ALPack());
	butOk.addActionListener(new ALPack());
	buttonAdd.addActionListener(new ALPack());
	buttonEdit.addActionListener(new ALPack());
	buttonDel.addActionListener(new ALPack());
	butAddDate.addActionListener(new ALPack());
	butTCalc.addActionListener(new ALPack());
	butGTCalc.addActionListener(new ALPack());
	}

public void addListener()
		{
			butHDet.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{

						HDetails hobj = new HDetails();
						hobj.setBounds(500,50,45,50);
						final JFrame frmhot = new JFrame("Hotel Rates");
						frmhot.setContentPane(hobj);
						frmhot.setSize(195,185);
						frmhot.setLocation(430,170);
						frmhot.setVisible(true);
						frmhot.setResizable(false);
						butHDet.setEnabled(false);


						int rowcnt1 = plobj.pldt.getRowCount();
						if(rowcnt1==0) return;


							int colnum = hobj.defTabModel.getColumnCount();
							Object [] data = new Object[colnum];
							for(int ri=0;ri<rowcnt1;ri++)
							{
							for(int col = 0;col<colnum;col++)
							{
								data[col] = "";
							}
							hobj.defTabModel.addRow(data);


							String hName1 =(String)plobj.pldt.getValueAt(ri,1);


							if(!(hName1.equals("None")))
							{

							hobj.defTabModel.setValueAt(hName1,ri,0);


											try
											{
											Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
											Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
											Statement stmt1 = conn.createStatement();
											//Statement stmt2 = conn.createStatement();

											String strsqlh1="select ACRate from Hotel where HName = '" + hName1 + "'";
											String strsqlh2="select NonACRate from Hotel where HName = '" + hName1 + "'";



										String strType = (String)cmbPackType.getSelectedItem();

										if(strType.equals("Luxury"))
										{
											ResultSet rsTransport1 = stmt1.executeQuery(strsqlh1);
											//rsTransport1.next();

											while(rsTransport1.next())
											{
													int res = rsTransport1.getInt(1);
												String dispRate = "";
												hobj.defTabModel.setValueAt(dispRate.valueOf(res),ri,1);

											}//while
									    }




									if(strType.equals("Budget"))
									{
										ResultSet rsTransport1 = stmt1.executeQuery(strsqlh2);


										while(rsTransport1.next())
										{
											 int res = rsTransport1.getInt(1);
											 String dispRate = "";

											 hobj.defTabModel.setValueAt(dispRate.valueOf(res),ri,1);


										}//while

								    }

											stmt1.close();
										//	stmt2.close();
											conn.close();

											}//ent of try
											catch(Exception e)
											{
											System.out.println(e);
											}//catch
							}//if


										}//for

							int rowcnt2 = hobj.tblhot.getRowCount();
							try
							{
							for(int ch=0;ch<rowcnt2;ch++)
							{
								String chk = (String)hobj.tblhot.getValueAt(ch,0);
								if(chk.equals(""))
								{
									hobj.defTabModel.removeRow(ch);
									//hobj.defTabModel.setValueAt("ff",ch,0);
							    }

							}
						   }//try
						   catch(Exception e)
						   {

						   }




						    //}//for

						frmhot.addWindowListener(new WindowAdapter()
						{
							public void windowClosing(WindowEvent winevt)
							{
								frmhot.setVisible(false);
								butHDet.setEnabled(true);
							}
			        });




				}
			});
		}//addListener

public void addListener1()
	{
		butTransDet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
					TransDetails transobj = new TransDetails();
					final JFrame frmtrans = new JFrame("Transport Rates");
					frmtrans.setContentPane(transobj);
					frmtrans.setSize(195,185);
					frmtrans.setResizable(false);
					frmtrans.setLocation(430,170);
					butTransDet.setEnabled(false);
					frmtrans.setVisible(true);




					int rowcnt2 = plobj.pldt.getRowCount();
					if(rowcnt2==0) return;


						int colnum1 = transobj.defTabModel.getColumnCount();
						Object [] data = new Object[colnum1];
						for(int rj=0;rj<rowcnt2;rj++)
						{
						for(int col = 0;col<colnum1;col++)
						{
							data[col] = "";
						}

						transobj.defTabModel.addRow(data);

						String tName1 =(String)plobj.pldt.getValueAt(rj,4);
						transobj.defTabModel.setValueAt(tName1,rj,0);


							try
							{
							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
							Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
							Statement stmt1 = conn.createStatement();
							Statement stmt2 = conn.createStatement();

							String strsqlt1="select LuxuryCostAdult from Transport where TName = '" + tName1 + "'";
							String strsqlt2="select BudgetCostAdult from Transport where TName = '" + tName1 + "'";

							String strsqlt3="select LuxuryCostChild from Transport where TName = '" + tName1 + "'";
							String strsqlt4="select BudgetCostChild from Transport where TName = '" + tName1 + "'";



						String strType = (String)cmbPackType.getSelectedItem();

						if(strType.equals("Luxury"))
						{
							ResultSet rsTransport1 = stmt1.executeQuery(strsqlt1);
							//rsTransport1.next();

							while(rsTransport1.next())
							{
									int res = rsTransport1.getInt(1);
								String dispRate = "";
								transobj.defTabModel.setValueAt(dispRate.valueOf(res),rj,1);

							}//while



							ResultSet rsTransport2 = stmt1.executeQuery(strsqlt3);
							//rsTransport1.next();

							while(rsTransport2.next())
							{
								int res1 = rsTransport2.getInt(1);
								String dispRate1 = "";
								transobj.defTabModel.setValueAt(dispRate1.valueOf(res1),rj,2);

							}//while


						}




					if(strType.equals("Budget"))
					{
						ResultSet rsTransport1 = stmt1.executeQuery(strsqlt2);


						while(rsTransport1.next())
						{
							 int res = rsTransport1.getInt(1);
							 String dispRate = "";

							 transobj.defTabModel.setValueAt(dispRate.valueOf(res),rj,1);


						}//while



						ResultSet rsTransport2 = stmt1.executeQuery(strsqlt4);
						//rsTransport1.next();

						while(rsTransport2.next())
						{
								int res1 = rsTransport2.getInt(1);
							String dispRate1 = "";
							transobj.defTabModel.setValueAt(dispRate1.valueOf(res1),rj,2);

							}//while


					}

							stmt1.close();
						//	stmt2.close();
							conn.close();

							}//ent of try
							catch(Exception e)
							{
							System.out.println(e);
							}//catch



						}//for






									//}//for

					frmtrans.addWindowListener(new WindowAdapter()
					{
						public void windowClosing(WindowEvent winevt)
							{
								frmtrans.setVisible(false);
								butTransDet.setEnabled(true);
							}
			        });


			}
		});
	}//addListener1


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
					plobj.cmbPlace.addItem(placeName);
		}//while
		stmt.close();
					conn.close();
	}//ent of try
	catch(Exception e)
			{
				System.out.println(e);
		}//catch

	}

	public void CalcHotelRate(int row)
	{
			String strType = (String)cmbPackType.getSelectedItem();
			String cmdHotel = "";

			if(strType.equals("Budget"))
			{
				cmdHotel = "Select NonAcRate from Hotel where Hname = ? and HCity = ? and Grade = 'Duluxe'";
			}

			if(strType.equals("Luxury"))
			{
				cmdHotel = "Select AcRate from Hotel where Hname = ? and HCity = ? and Grade = 'Star'";
			}

			String placeName = (String)plobj.pldt.getValueAt(row,0);
			String hotelName = (String)plobj.pldt.getValueAt(row,1);
			String days = (String)plobj.pldt.getValueAt(row,2);
			int numDays = Integer.parseInt(days);
			//System.out.println("Number Of Days = " + numDays);

			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				PreparedStatement stmt = conn.prepareStatement(cmdHotel);
				stmt.setString(1,hotelName);
				stmt.setString(2,placeName);


				ResultSet rsHotel = stmt.executeQuery();
				while(rsHotel.next())
				{
					 TotalHotelRate = TotalHotelRate + (rsHotel.getInt(1) * numDays);
					 //System.out.println("Total Rate for row = "+ row + " = " +TotalHotelRate);

				}//while

				stmt.close();
				conn.close();
				}//ent of try
				catch(Exception e)
				{
				System.out.println(e);
				}//catch

	}//CalcHotelRate(i);



	public void CalcTransRate(int rowt)
	{
		String destPlaceName = (String)plobj.pldt.getValueAt(rowt,0);


		String transName = (String)plobj.pldt.getValueAt(rowt,4);


		String transMode = (String)plobj.pldt.getValueAt(rowt,3);


			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
				Statement stmt1 = conn.createStatement();
				Statement stmt2 = conn.createStatement();


				String strsql="select LuxuryCostAdult from Transport where TMode = '" + transMode + "' and TName= '"+transName + "'and DestPlace='"+destPlaceName+"'";
				String strsql2="select LuxuryCostChild from Transport where TMode = '" + transMode + "' and TName= '"+transName + "'and DestPlace='"+destPlaceName+"'";

				String strsql3="select BudgetCostAdult from Transport where TMode = '" + transMode + "' and TName= '"+transName + "'and DestPlace='"+destPlaceName+"'";
				String strsql4="select BudgetCostChild from Transport where TMode = '" + transMode + "' and TName= '"+transName + "'and DestPlace='"+destPlaceName+"'";




			String strType = (String)cmbPackType.getSelectedItem();

			if(strType.equals("Luxury"))
			{
				ResultSet rsTransport1 = stmt1.executeQuery(strsql);
				//rsTransport1.next();

				while(rsTransport1.next())
				{
					 TotalTransRate1 = TotalTransRate1 + rsTransport1.getInt(1);

				}//while




				ResultSet rsTransport2 = stmt2.executeQuery(strsql2);

				//rsTransport1.next();
				while(rsTransport2.next())
				{
					 TotalTransRate2 = TotalTransRate2 + rsTransport2.getInt(1);

				}//while

		}


		if(strType.equals("Budget"))
		{
			ResultSet rsTransport1 = stmt1.executeQuery(strsql3);
			//rsTransport1.next();

			while(rsTransport1.next())
			{
				 TotalTransRate1 = TotalTransRate1 + rsTransport1.getInt(1);

			}//while





			ResultSet rsTransport2 = stmt2.executeQuery(strsql4);

			//rsTransport1.next();
			while(rsTransport2.next())
			{
				 TotalTransRate2 = TotalTransRate2 + rsTransport2.getInt(1);

			}//while

		}


				stmt1.close();
				stmt2.close();
				conn.close();

				}//ent of try
				catch(Exception e)
				{
				System.out.println(e);
				}//catch



			}


	public static void main(String args[])
	{
		Pack packtab = new Pack();

		JFrame packfrm = new JFrame("Package Details");
		packfrm.setContentPane(packtab);
		packtab.addListener();
		packtab.addListener1();
		packfrm.setSize(625,355);
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
	String[] colnms={"Seats Left","From Date","To Date"};
			Object[][] rowData={
								{"","",""},
								};

			DefaultTableModel defTabModel = new DefaultTableModel(rowData,colnms);
			JTable tbldt = new JTable(defTabModel);

			DateComboBox dcb1 = new DateComboBox();

			DateComboBox dcb2 = new DateComboBox();

			TableColumnModel colModel = tbldt.getColumnModel();
			TableColumn tblFromDate = colModel.getColumn(1);
    		TableColumn tblToDate = colModel.getColumn(2);

		  	public Datedtl()
			{
				setLayout(new BorderLayout());
				tbldt.setLayout(null);
				tblFromDate.setCellEditor(new DefaultCellEditor(dcb1));
				tblToDate.setCellEditor(new DefaultCellEditor(dcb2));

				add(tbldt.getTableHeader(),BorderLayout.NORTH);
				tbldt.setRowHeight(20);
				add(tbldt);

				add(new JScrollPane(tbldt));

	}
}//Datedtl


public class Plgrd extends JPanel
{
	//JComboBox plcmb = new JComboBox();
	String[] colnm={"Place","Hotel","Days in Hotel","Transport Mode","Transport Name"};

	Object[][] row={
						{"","","","",""}

						};

	DefaultTableModel defTabModel = new DefaultTableModel(row,colnm);
	JTable pldt = new JTable(defTabModel);


	JComboBox cmbPlace = new JComboBox();
	JComboBox cmbHotel = new JComboBox();
	JComboBox cmbMode = new JComboBox();
	JComboBox cmbTName = new JComboBox();


	TableColumnModel colModel = pldt.getColumnModel();
	TableColumn tblPlaceCol = colModel.getColumn(0);
	TableColumn tblHotelCol = colModel.getColumn(1);
	TableColumn tblModeCol = colModel.getColumn(3);
	TableColumn tblTNameCol = colModel.getColumn(4);


		public Plgrd()
		{
		 	setLayout(new BorderLayout());
		 	//pldt.setLayout(new BorderLayout());

	//		TableColumnModel colModel = pldt.getColumnModel();
	//		TableColumn tblPlaceCol = colModel.getColumn(0);
			tblPlaceCol.setCellEditor(new DefaultCellEditor(cmbPlace));
			tblHotelCol.setCellEditor(new DefaultCellEditor(cmbHotel));
			tblModeCol.setCellEditor(new DefaultCellEditor(cmbMode));
			tblTNameCol.setCellEditor(new DefaultCellEditor(cmbTName));


			cmbPlace.addItem("");

			cmbMode.addItem("Railway");
			cmbMode.addItem("Airway");
			cmbMode.addItem("Roadway");

			pldt.setRowHeight(20);

			add(pldt);
			add(new JScrollPane(pldt));

			cmbPlace.addActionListener(new ALPack());
			cmbMode.addActionListener(new ALPack());
			cmbHotel.addActionListener(new ALPack());
			cmbTName.addActionListener(new ALPack());
			cmbHotel.addItemListener(new IHPackage());
			cmbPlace.addItemListener(new IHPackage());

		}//Plgrd

		public void connectHotel(String strPlace)
		{
			String hotelName;
					try{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
					String cmdHotel = "Select HName from Hotel where HCity=?";
					PreparedStatement stmt = conn.prepareStatement(cmdHotel);
					stmt.setString(1,strPlace);

					//plobj.cmbHotel.removeAllItems();
					//plobj.cmbHotel.addItem("None");

					ResultSet rsHotel = stmt.executeQuery();
					while(rsHotel.next())
			   	    {
						hotelName = rsHotel.getString(1);
						cmbHotel.addItem(hotelName);
					}//while

					stmt.close();
					conn.close();
				}//ent of try
				catch(Exception e)
						{
							System.out.println(e);
		}//catch
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
					String destPlace = (String)plobj.pldt.getValueAt((row2),0);
					stmtTrans.setString(1,(String)destPlace);
					stmtTrans.setString(2,(String)strMode);

					if (row2 == 0)
					{
						stmtTrans.setString(3,(String)cmbSrtPlace.getSelectedItem());
					}
					else
					{
						sourcePlace = (String)plobj.pldt.getValueAt((row2-1),0);
						stmtTrans.setString(3,(String)sourcePlace);
					}

					ResultSet rsTransport = stmtTrans.executeQuery();
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



}//PLgrd

class HDetails extends JPanel
{

	String[] colnms={"Name","Rate"};
				Object[][] rowData={
									};

				DefaultTableModel defTabModel = new DefaultTableModel(rowData,colnms);
				JTable tblhot = new JTable(defTabModel);

			  	public HDetails()
				{
					setLayout(new BorderLayout());
					tblhot.setLayout(new BorderLayout());
					//tbldt.setBounds(5,10,255,80);

					add(tblhot.getTableHeader(),BorderLayout.NORTH);
					tblhot.setRowHeight(20);
					tblhot.setRowSelectionAllowed(false);
					add(tblhot);

					add(new JScrollPane(tblhot));

		}
	}




class TransDetails extends JPanel
{
			//JDeskTopPane desk = new JDeskTopPane();
        String[] colnms={"Name","Adult","Child"};
					Object[][] rowData={

										};

					DefaultTableModel defTabModel = new DefaultTableModel(rowData,colnms);
					JTable tbltrans = new JTable(defTabModel);

				  	public TransDetails()
					{
						setLayout(new BorderLayout());
						tbltrans.setLayout(new BorderLayout());
						//tbldt.setBounds(5,10,255,80);

						add(tbltrans.getTableHeader(),BorderLayout.NORTH);
						tbltrans.setRowHeight(20);
						tbltrans.setColumnSelectionAllowed(false);
						add(tbltrans);

						add(new JScrollPane(tbltrans));

					}
}


class ALPack implements ActionListener
{
	public void actionPerformed(ActionEvent actEvt)
	{
		String temp;
		char ch;
		int len,i;

		if(actEvt.getSource() == plobj.cmbPlace)
		{
			int rown = plobj.pldt.getSelectedRow();
			if(rown == -1) return;
			plobj.cmbHotel.removeAllItems();
			plobj.cmbHotel.addItem("None");
			String plStr = (String)plobj.cmbPlace.getSelectedItem();
			plobj.connectHotel(plStr);

			String place ="";
			place = (String)cmbSrtPlace.getSelectedItem();
			if(place.equals(""))
			{
					JOptionPane.showMessageDialog(null,"Select Starting Place","Selection Error",JOptionPane.ERROR_MESSAGE);
					plobj.pldt.setValueAt("",0,0);
					return;
			}
			if (place.equals(plobj.cmbPlace.getSelectedItem()) && (plobj.pldt.getRowCount()==1))
			{
					JOptionPane.showMessageDialog(null,"Source & Destination place are the same","Selection Error",JOptionPane.ERROR_MESSAGE);
					plobj.cmbPlace.setSelectedItem("");
					plobj.pldt.setValueAt("None",0,1);
					plobj.pldt.setValueAt("",0,2);
					return;
			}

		}
		else
		if(actEvt.getSource() == plobj.cmbHotel)
		{

		}
		else

		if(actEvt.getSource() == plobj.cmbTName)
		{

			int row3 = plobj.pldt.getSelectedRow();
			if(row3 == -1) return;
			plobj.cmbTName.removeAllItems();
			String strModeP1 = (String)plobj.pldt.getValueAt(row3,3);
			plobj.connectTransport(strModeP1,row3)	;
		}
		else

		if(actEvt.getSource() ==  butOk)
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
							return;
						}
					}

					}



					temp = txtNoDays.getText();
					if(temp.equals (""))
					{
						JOptionPane.showMessageDialog(null,"Enter Number of days of the tour","Incomplete Information",JOptionPane.ERROR_MESSAGE);
						txtNoDays.requestFocus();
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
							txtNoPeople.setText("");
							txtNoPeople.requestFocus();
							return;
						}
					}

				   }


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
								JOptionPane.showMessageDialog(null,"Enter Numerical Value For Food charges. of seats","Incorrect Format",JOptionPane.ERROR_MESSAGE);
								txtAFood.setText("");
								txtAFood.requestFocus();
								return;
							}
						}

						}


					temp = txtTax.getText();
					if(temp.equals (""))
					{
						JOptionPane.showMessageDialog(null,"Enter Tax charges","Incomplete Information",JOptionPane.ERROR_MESSAGE);
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
							JOptionPane.showMessageDialog(null,"Enter Numerical Value For Tax Charges","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							txtTax.setText("");
							txtTax.requestFocus();
							return;
						}
					}

					}



			temp = txtCFood.getText();
			if(temp.equals (""))
			{
				JOptionPane.showMessageDialog(null,"Enter Food charges for Child","Incomplete Information",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null,"Enter Numerical Value For Food charges","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					txtCFood.setText("");
					txtCFood.requestFocus();
					return;
				}
			}

					}


}//butOk

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
			//System.out.println(rowVal);

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

}//buttonAdd

else

if(actEvt.getSource() == butAddDate)
{

	int rowcnt1 = dtobj.defTabModel.getRowCount();
	String rowVal1;
	String errStr1 = "";
	try
	{
		for(int c1=0;c1<3;c1++)
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


if(actEvt.getSource() == butOk)
{

	addRecs();

	int rowc = dtobj.tbldt.getRowCount();
	System.out.println(rowc);
					for (int j = 0;j<(rowc);j++)
					{
						addDateRecs(j);
					}//for

int rowPlace = plobj.pldt.getRowCount();
					for (int j = 0;j<(rowPlace);j++)
					{
						addPlaceRecs(j);
					}//for



//Date now = new Date();
String before,after;
before=(String)dtobj.tbldt.getValueAt(0,1);
after=(String)dtobj.tbldt.getValueAt(0,1);
//try
{
DateFormat fmt = DateFormat.getDateInstance(DateFormat.SHORT);
//java.util.Date input = fmt.parse(before.trim());
//java.util.Date input1 = fmt.parse(after.trim());
}
//catch(ParseException e)
{
	System.out.println("error");
}
//if(input.after(input1))
{
	System.out.println("after");
}
}//butOk




if(actEvt.getSource() == butCan)
{


	System.exit(0);

}//butCan

if(actEvt.getSource() == butTCalc)
{

	String strFoodA = txtAFood.getText();

	if(strFoodA.equals(""))
		{
			JOptionPane.showMessageDialog(null,"Enter Food Details for Adult","Error",JOptionPane.ERROR_MESSAGE);
			txtAFood.requestFocus();
			return;
		}
	int foodA = Integer.parseInt(strFoodA);

	String strFoodC = txtCFood.getText();

	if(strFoodC.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Food Details for Child","Error",JOptionPane.ERROR_MESSAGE);
				txtCFood.requestFocus();
				return;
			}

	int foodC = Integer.parseInt(strFoodC);


	int totalA = TotalHotelRate +TotalTransRate1 + foodA;
	int totalC = TotalHotelRate +TotalTransRate2 + foodC;

	String disptotA = "";
	String disptotB = "";
	txtATotal.setText(disptotA.valueOf(totalA));
	txtCTotal.setText(disptotB.valueOf(totalC));
}


if(actEvt.getSource() == butGTCalc)
{
	String strTax = txtTax.getText();

	if(strTax.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Tax Rate ","Error",JOptionPane.ERROR_MESSAGE);
				txtTax.requestFocus();
				return;
			}


	float tax = Float.parseFloat(strTax);

	String strTotalA = txtATotal.getText();
	float totA = Float.parseFloat(strTotalA);

	String strTotalC = txtCTotal.getText();
	float totC = Float.parseFloat(strTotalC);


	float gTotalA = ((tax/100)*totA) + totA;
	float gTotalC = ((tax/100)*totC) + totC;



	String dispGTotA = "";
	String dispGTotC = "";


	txtAGTotal.setText(dispGTotA.valueOf(gTotalA));
	txtCGTotal.setText(dispGTotC.valueOf(gTotalC));

}
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
else
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

}//buttonEdit

}//actionPerformed
}//AHCust


public class CLPack implements ChangeListener
{
	public void stateChanged(ChangeEvent e)
	{
		SingleSelectionModel model = (SingleSelectionModel) e.getSource();
 		if(model.getSelectedIndex() == tabPackage.getTabCount()-1)
 		{

			int rownum = plobj.pldt.getRowCount();
			if(rownum==1)
			{
				String plName = (String)plobj.pldt.getValueAt(0,0);
				String hName = (String)plobj.pldt.getValueAt(0,1);
				String days = (String)plobj.pldt.getValueAt(0,2);
				String tMode = (String)plobj.pldt.getValueAt(0,3);
				String tName = (String)plobj.pldt.getValueAt(0,4);

				if(plName.equals("")||hName.equals("")||days.equals("")||tMode.equals("")||tName.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Enter Place Details","Incomplete Data",JOptionPane.ERROR_MESSAGE);

					pnlPlaceDetails.setVisible(true);

					return;
				}
			}
			else
			{
							for (int j = 0;j<(rownum);j++)
							{
								CalcHotelRate(j);
							}//for

							for(int k =0;k<(rownum);k++)
							{
								CalcTransRate(k);
							}
           }
			String disp = "";
			String display = "";
				txtAHotel.setText(disp.valueOf(TotalHotelRate));
				txtCHotel.setText(disp.valueOf(TotalHotelRate));
				txtATransport.setText(display.valueOf(TotalTransRate1));
				txtCTransport.setText(display.valueOf(TotalTransRate2));


		}
	}
}


public class IHPackage implements ItemListener
{
	public void itemStateChanged(ItemEvent evt)
		{

		if (evt.getSource() == plobj.cmbPlace)
		{
			int rown = plobj.pldt.getSelectedRow();
			if(rown == -1) return;
			plobj.cmbHotel.removeAllItems();
			plobj.cmbHotel.addItem("None");
			String plStr = (String)plobj.pldt.getValueAt(rown,0);
			plobj.connectHotel(plStr);


		}//cmbPlace

	}//ItemStateChanged
}//IHPackage


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
			System.out.println(cmdValues);
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


	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
		String cmdInsert = "Insert into PackageDate(PackName,SeatsLeft,FromDate,ToDate) values('";
		String cmdValues = cmdInsert + txtPackName.getText() + "',"+
							 dtobj.tbldt.getValueAt(rowdt,0) + ",'"+
							 dtobj.tbldt.getValueAt(rowdt,1) + "','"+
							 dtobj.tbldt.getValueAt(rowdt,2) + "')";

		Statement stmt = conn.createStatement();
		System.out.println(cmdValues);
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

public void addPlaceRecs(int rowp)
{

	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
			String cmdInsert = "Insert into PackagePlace(PackName,PackType,PlaceName,HName,TMode,TName,DaysInHotel) values('";
			String cmdValues = cmdInsert + txtPackName.getText() + "','"+
								 cmbPackType.getSelectedItem()+"','"+
								 plobj.pldt.getValueAt(rowp,0) + "','"+
								 plobj.pldt.getValueAt(rowp,1) + "','"+
								 plobj.pldt.getValueAt(rowp,3) + "','"+
								 plobj.pldt.getValueAt(rowp,4) + "',"+
								 plobj.pldt.getValueAt(rowp,2) + ")";


			Statement stmt = conn.createStatement();
			System.out.println(cmdValues);
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


}//Pack