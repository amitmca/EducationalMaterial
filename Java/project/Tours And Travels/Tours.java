// This screen contains the main menu bar providing access
// to the other screens in the application.

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Runtime.*;
import java.io.*;

public class Tours extends JFrame
{

	public static Tours frmTours ;
	public static JFrame frmLog;
	public static Logframe login;
	public static RepPlaceName repPlaceobj;
	public JFrame frmAbout;
	public JPanel pnlAbt;
	public JButton  butok;
	JMenuBar mainMenu;
	JMenuItem exitMenu,custMenu,placeMenu,hotelMenu,transportMenu,toursMenu,aboutMenu;
	JMenuItem upCustMenu,upHotelMenu,upTransportMenu,upPlaceMenu,upPackMenu,upBookMenu;
	JMenuItem custinfo,meminfo,recMenu,packMenu,packdtsMenu,quitMenu,bookingMenu;
	JMenu sessionMenu,repPlace,newMenu,updateMenu,repMenu,helpMenu,custListMenu,repPackMenu,cancelMenu;
	JMenuItem repCustPack ,repPlaceList,repPlaceState, repCustBal , repHealth ,repPackList,repPackBud ,repReceipt,repHotel,repTrans ;
	ImageIcon imgLogout;

	public Tours()
	{

				mainMenu = new JMenuBar();

				sessionMenu	 = new JMenu("Session ");
				sessionMenu.setMnemonic('S');


				newMenu 	 = new JMenu("New");
				newMenu.setMnemonic('N');

				cancelMenu = new JMenu("Cancel");
				cancelMenu.setMnemonic('C');

				updateMenu 	 = new JMenu("Update");
				updateMenu.setMnemonic('U');

				repMenu	 = new JMenu("Reports");
				repMenu.setMnemonic('R');


				helpMenu = new JMenu("Help");
				helpMenu.setMnemonic('H');


				//session details
				//chpassMenu = new JMenuItem("Change Password");
			//	chpassMenu.setMnemonic('C');
			//	chpassMenu.setToolTipText("New Password");

			//	logoutMenu = new JMenuItem("Logout");
			//	logoutMenu.setMnemonic('L');
			//	logoutMenu.setToolTipText("Logout ");

				exitMenu = new JMenuItem("Exit");
				exitMenu.setMnemonic('E');
				exitMenu.setToolTipText("Exit Application");

				//new Menu Items
				custMenu = new JMenuItem("Customer");
				custMenu.setMnemonic('C');
				custMenu.setToolTipText("Customer Details");

				hotelMenu = new JMenuItem("Hotel");
				hotelMenu.setMnemonic('H');
				hotelMenu.setToolTipText("Hotel Details");

				placeMenu = new JMenuItem("Place");
				placeMenu.setMnemonic('P');
				placeMenu.setToolTipText("Place Details");


				transportMenu = new JMenuItem("Transport");
				transportMenu.setMnemonic('T');
				transportMenu.setToolTipText("Transport Details");

				packMenu = new JMenuItem("Package");
				packMenu.setMnemonic('P');
				packMenu.setToolTipText("Package Details");

				bookingMenu = new JMenuItem("Booking");
				bookingMenu.setMnemonic('B');
				bookingMenu.setToolTipText("Booking Details");

				recMenu = new JMenuItem("Receipt");
				recMenu.setMnemonic('R');
				recMenu.setToolTipText("Receipt Details");

				//update menuitems

				upCustMenu = new JMenuItem("Customer");
				upCustMenu.setMnemonic('C');
				upCustMenu.setToolTipText(" Update Customer");

				upHotelMenu = new JMenuItem("Hotel Details");
				upTransportMenu = new JMenuItem("Transport Details");
				upPackMenu = new JMenuItem("Package Details");

				upBookMenu = new JMenuItem("Cancel Booking");
				upBookMenu.setMnemonic('B');
				upBookMenu.setToolTipText("Cancel Booking ");

				meminfo = new JMenuItem("Members");
				meminfo.setMnemonic('M');
				meminfo.setToolTipText("Member Deatails ");

				//repotr menuitems
				custListMenu = new JMenu("Customer");
				custListMenu.setMnemonic('C');
				custListMenu.setToolTipText("Customer Reports");

				//custlist reports
				custinfo = new JMenuItem("Listing");
				custinfo.setMnemonic('C');
				custinfo.setToolTipText("Customer Details");

				repCustPack = new JMenuItem("Customer - Package");
				repCustPack.setMnemonic('P');
				repCustPack.setToolTipText("Customer Package Details");

				repCustBal = new JMenuItem("Customer - Balance");
				repCustBal.setMnemonic('B');
				repCustBal.setToolTipText("Customer Balance Details");

				/*repHealth = new JMenuItem("Customer Health");
				repHealth.setMnemonic('H');
				repHealth.setToolTipText("Customer Health Details");*/


				//Package Listing
				repPackMenu = new JMenu("Package");
				repPackMenu.setMnemonic('P');
				repPackMenu.setToolTipText("Package Details");

				repPlace= new JMenu("Place");
				repPlace.setMnemonic('P');
				repPlace.setToolTipText("Place Details");

				repHotel= new JMenuItem("Hotel Listing");
				repHotel.setMnemonic('H');
				repHotel.setToolTipText("Hotel Details");

				repTrans= new JMenuItem("Transport Listing");
				repTrans.setMnemonic('T');
				repTrans.setToolTipText("Transport Details");

				repReceipt= new JMenuItem("Receipt Listing");
				repReceipt.setMnemonic('R');
				repReceipt.setToolTipText("Receipt Details");


				repPackList= new JMenuItem("Listing");
				repPackList.setMnemonic('L');
				repPackList.setToolTipText("Package Details");


				repPackBud = new JMenuItem("Budget Listing");
				repPackBud.setMnemonic('B');
				repPackBud.setToolTipText("Budget Details");

				//Place MenuItems
				repPlaceList =new JMenuItem("Place Details");
				repPlaceList.setMnemonic('P');

				repPlaceState =new JMenuItem("StateWise Place Listing");
				repPlaceState.setMnemonic('S');

				//help menuitems
				toursMenu =new JMenuItem("Tours & Travels");
				toursMenu .setMnemonic('T');


				aboutMenu =new JMenuItem("About");
				aboutMenu .setMnemonic('A');


				mainMenu.add(sessionMenu);
				mainMenu.add(newMenu);
				//mainMenu.add(updateMenu);
				mainMenu.add(cancelMenu);
				mainMenu.add(repMenu);
				mainMenu.add(helpMenu);

				//packMenu.add(placeMenu);
				//packMenu.add(hotelMenu);
				//packMenu.add(transportMenu);

				cancelMenu.add(upBookMenu);

				updateMenu.add(upCustMenu);
				updateMenu.addSeparator();
				updateMenu.add(upHotelMenu);
				updateMenu.add(upTransportMenu);
				updateMenu.add(upPackMenu);

        	    //sessionMenu.add(chpassMenu);
				//sessionMenu.addSeparator();
			//	sessionMenu.add(logoutMenu);
				sessionMenu.add(exitMenu);

				newMenu.add(custMenu);
				newMenu.add(hotelMenu);
				newMenu.add(transportMenu);
				newMenu.add(placeMenu);
				newMenu.add(packMenu);
				newMenu.add(recMenu);
				newMenu.add(bookingMenu);



				upHotelMenu.setEnabled(false);
				upTransportMenu.setEnabled(false);
				upPackMenu.setEnabled(false);

				repMenu.add(custListMenu);
//				repMenu.add(repPackMenu);
//				repMenu.add(repReceipt);
				repMenu.add(repPlace);
//				repMenu.add(repHotel);
		//		repMenu.add(repTrans);
				//repMenu.add(meminfo);

				//helpMenu.add(toursMenu);
				helpMenu.addSeparator();
				helpMenu.add(aboutMenu);

				custListMenu.add(custinfo);

				//custListMenu.add(repCustPack);
				//custListMenu.add(repCustBal);
				/*custListMenu.add(repHealth);*/

				repPackMenu .add(repPackList);
				repPackMenu .add(repPackBud);

				repPlace.add(repPlaceList);
				repPlace.add(repPlaceState);

				setJMenuBar(mainMenu);

				mainMenu.setBounds(5,0,650,30);

				//add ActionListeners
//				chpassMenu.addActionListener(new ActList());
				bookingMenu.addActionListener(new ActList());
				//logoutMenu.addActionListener(new ActList());
				custMenu.addActionListener(new ActList());
				hotelMenu.addActionListener(new ActList());
				transportMenu.addActionListener(new ActList());
				placeMenu.addActionListener(new ActList());
				packMenu.addActionListener(new ActList());
				recMenu.addActionListener(new ActList());
				upCustMenu.addActionListener(new ActList());
				upBookMenu.addActionListener(new ActList());
				custinfo.addActionListener(new ActList());
				repCustPack.addActionListener(new ActList());
				repCustBal.addActionListener(new ActList());
				repReceipt.addActionListener(new ActList());
				repHotel.addActionListener(new ActList());
				repTrans.addActionListener(new ActList());
				repPlaceList.addActionListener(new ActList());
				repPlaceState.addActionListener(new ActList());
				repPackList.addActionListener(new ActList());
				repPackBud.addActionListener(new ActList());
				meminfo.addActionListener(new ActList());
				toursMenu.addActionListener(new ActList());
				aboutMenu.addActionListener(new ActList());
				exitMenu.addActionListener(new ActList());

	}//Tours Constructor


	//method to call another screen due to the click event in the Menu

	void displayScreen(JPanel pnlScreen,String title)
	{


		frmLog = new JFrame(title);
		frmLog.setContentPane(pnlScreen);

		if (title == "Customer Information")
			frmLog.setSize(525,400);

		else if (title == "Package Information")
			frmLog.setSize(625,430);

		else if (title == "Hotel Information")
			frmLog.setSize(515,350);

		else if ((title == "Transport Details") ||(title == "Booking Details"))
			frmLog.setSize(525,450);

		else if (title == "Place Details")
			frmLog.setSize(580,360);

		else if (title == "Search Information")
			frmLog.setSize(500,350);

		else if (title == "Receipt Details")
			frmLog.setSize(540,320);

		else if(title == "Booking Details")
			frmLog.setSize(525,400);

		else if (title == "Package wise Customer Listing"  )
			frmLog.setSize(340,200);


		else if (title == "Receipt Reports")
			frmLog.setSize(310,280);

		else if (title == "Hotel Reports")
			frmLog.setSize(310,170);

		else if (title == "Transport Reports")
			frmLog.setSize(300,210);

		else if (title == "Package Listing")
			frmLog.setSize(290,200);

		else if (title == "Package Listing and Budget")
			frmLog.setSize(290,240);

		else if (title == "Balance wise Customer Listing")
			frmLog.setSize(340,200);

		else if (title == "Place Report")
			frmLog.setSize(280,120);

		else if (title == "StateWise Place Report")
			frmLog.setSize(280,120);

		else if (title == "Cancel Booking")
			frmLog.setSize(525,320);

		else if (title == "Change Password")
			frmLog.setSize(370,200);

		else if (title == "Login")
			frmLog.setSize(350,150);

		else
		    frmLog.setSize(270,200);



		frmLog.setResizable(false);
		frmLog.setVisible(true);

		// To center the frame
		Dimension dim = frmLog.getToolkit().getScreenSize();
				frmLog.setLocation(dim.width/2 - frmLog.getWidth()/2 ,
				dim.height/2 - frmLog.getHeight()/2 );

		frmTours.setEnabled(false);


	}

//methid to disable the child window

void setWindowInvisible()
{
	 frmLog.setVisible(false);
	 frmTours.setEnabled(true);
}
public static void main(String []args)


	//  static void mainFunc()
	{

		frmTours =  new Tours();
		ImageIcon imgTours1 = new ImageIcon("C:\\rip\\images\\Tours.gif");
		frmTours.setIconImage(imgTours1.getImage());
		frmTours.setTitle("Tours and Travels");
		frmTours.setSize(800,550);

		frmTours.setVisible(true);

		WindowListener listener = new WindowAdapter ()
		{
			public void windowClosing(WindowEvent winevt)
			{
					System.exit(0);
			}
		} ;//End of WindowListener

		frmTours.addWindowListener(listener);


	}//End of Main

class ActList implements ActionListener
		{
			public void actionPerformed ( ActionEvent evt)
			{
				/*if(evt.getSource() == chpassMenu)
				{
					ChangePassword changePwd =  new ChangePassword ();
					displayScreen(changePwd,"Change Password");

				}*/

				/*if(evt.getSource() == logoutMenu)
				{
					frmTours.setVisible(false);
					login =  new Logframe();
					displayScreen(login,"Login");

				}*/

				if(evt.getSource() == custMenu)
				{
					Customer custobj = new Customer();
					displayScreen(custobj,"Customer Information");

				}//custMenu
				else
				if(evt.getSource() == packMenu)
				{
					NewPack packobj = new NewPack();
					packobj.connectCombo();
					displayScreen(packobj,"Package Information");

				}//packMenu
				else
				if(evt.getSource() == hotelMenu)
				{
					Hotel hotelobj = new Hotel();
					hotelobj.connectcmbHCity();
					displayScreen(hotelobj,"Hotel Information");


				}//hotelMenu

				else
				if(evt.getSource() == transportMenu)
				{

					Transport transobj = new Transport();
					transobj.connectCmbPlaces();
					displayScreen(transobj,"Transport Details");


				}//transportMenu

				else
				if(evt.getSource() == placeMenu)
				{
					Place placeobj = new Place();
					displayScreen(placeobj,"Place Details");
				}
				else
				if(evt.getSource() == recMenu)
				{
					Receipt receiptobj = new Receipt();
					receiptobj.connectCmbCNo();
					receiptobj.DisplayNo();
					displayScreen(receiptobj,"Receipt Details");


				}//ReceiptMenu

				else
				if(evt.getSource() == upBookMenu)
				{
					CancelPackage cancelobj = new CancelPackage();
					cancelobj.setDbConnection();
					displayScreen(cancelobj,"Cancel Booking");


				}//ReceiptMenu
				else

				if(evt.getSource() == upCustMenu)
				{
					UpdateCust	updcustobj = new UpdateCust();
	    			updcustobj.setDbConnection();
	    			displayScreen(updcustobj,"Search Information");
				}
				else
				if(evt.getSource() == exitMenu)
				{
						System.exit(0);
				}//quitMenu

				else

				if(evt.getSource() == repCustPack)
				{
				RepCustPack repcustobj = new RepCustPack();
				repcustobj.connectcmbName();
				repcustobj.connectcmbDate();
				displayScreen(repcustobj,"Package wise Customer Listing");
				}
				else
				if(evt.getSource() == repCustBal)
				{
					RepCustBudget repcustbal = new RepCustBudget();
					repcustbal.connectcmbName();
					repcustbal.connectcmbDate();
					displayScreen(repcustbal,"Balance wise Customer Listing");
				}
				else
				if(evt.getSource() == repReceipt)
				{
				RepReceipt repReceiptobj = new RepReceipt();
				repReceiptobj.connectcmbCustNo();
				displayScreen(repReceiptobj,"Receipt Reports");
				}

				else
				if(evt.getSource() == repHotel)
				{
					RepHotel rephotelobj = new RepHotel();
					rephotelobj.connectcmbName();
					displayScreen(rephotelobj,"Hotel Reports");

				}
				else
				if(evt.getSource() == repTrans)
				{
				RepTransport repTransportobj = new RepTransport();
				repTransportobj.connectcmbName();
				displayScreen(repTransportobj,"Transport Reports");
				}
				else
				if(evt.getSource() == repPlaceList)
				{
					repPlaceobj = new RepPlaceName();
					repPlaceobj.connectcmbPlace();
				    displayScreen(repPlaceobj,"Place Report");

				}
				else
				if(evt.getSource() == repPlaceState)
				{
					RepPlace repPlaceobj1 = new RepPlace();
					repPlaceobj1.connectcmbState();
					displayScreen(repPlaceobj1,"StateWise Place Report");
				}
				else
				if(evt.getSource() == repPackList)
				{
				RepPackList repPackList = new RepPackList ();
				repPackList.setDbConnection();
				displayScreen(repPackList,"Package Listing");

				}
				else
				if(evt.getSource() == repPackBud)
				{
				RepPackPlace repPack = new RepPackPlace();
				repPack.setDbConnection();
				displayScreen(repPack,"Package Listing and Budget");
				}
				else
				if(evt.getSource() == bookingMenu)
				{
					Booking bookobj = new Booking();
					bookobj.connectcmb();
					bookobj.setDbConnection();
					displayScreen(bookobj,"Booking Details");
				}
				else
				if(evt.getSource() == custinfo)
				{
					RepCustList custlist = new RepCustList();
					//displayScreen(custlist,"Customer Listing");
					RepCustList.showList();
				}
				else
				if(evt.getSource() == meminfo)
				{
					RepMemList.mainFunc();
				}
				else
				if(evt.getSource() == toursMenu)
				{
					Runtime iexp;
			   		Process pro;
			   		iexp = Runtime.getRuntime();
				    String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","c:\\Rip\\IndexHelp.html"};
				   try
				   {
				   		 pro = iexp.exec(en);
				   		 pro.waitFor();
				   }
				   catch(IOException e)
				   {
						System.out.println(e);
				   } // End of Catch

				  catch(InterruptedException i)
				  {
					 	System.out.println(i);
				  }
				}
				else
				if(evt.getSource() == aboutMenu)
				{
					pnlAbt = new JPanel();
					frmAbout = new JFrame("About Tours And Travel");

					frmAbout.setSize(330,240);
					frmAbout.setResizable(false);
					pnlAbt.setLayout(null);
					frmAbout.setContentPane(pnlAbt);

					// To center the frame
					Dimension dim = frmAbout.getToolkit().getScreenSize();

					frmAbout.setLocation(dim.width/2 - frmAbout.getWidth()/2 ,
									dim.height/2 - frmAbout.getHeight()/2 );

					ImageIcon imgPic = new ImageIcon("c:\\rip\\images\\Tours.gif");
					JLabel lblPic = new JLabel("",imgPic,JLabel.CENTER);
					lblPic.setBounds(20,10,30,30);

					JLabel text = new  JLabel("Tours And Travels 1.0 32 Bit Edition");
					text.setBounds(80,10,200,30);

					JLabel text1 = new  JLabel("Copyright @ Logic Software Solution");
					text1.setBounds(80,50,200,30);

					JLabel text2 = new  JLabel("All Rights Reserved 2007 - 2008");
					text2.setBounds(80,90,200,30);

					JLabel text3 = new  JLabel("Licensed to: T.C. College");
					text3.setBounds(80,130,200,30);

					JLabel text4 = new  JLabel("Unlimited Users");
					text4.setBounds(80,170,150,30);

					butok = new JButton("Ok");
					butok.setBounds(240,170,70,30);

					butok.addActionListener(new ActList());

					pnlAbt.add(lblPic);
					pnlAbt.add(butok);
					pnlAbt.add(text);
					pnlAbt.add(text1);
					pnlAbt.add(text2);
					pnlAbt.add(text3);
					pnlAbt.add(text4);
					frmAbout.setVisible(true);

				}//about

				else
				if(evt.getSource() == butok)
				{
					frmAbout.setVisible(false);
				}

				}//actionPerformed
		}//ActList

}//End of class Tours


