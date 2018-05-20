import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.lang.*;

public class MysqlPlus1 extends JFrame implements ActionListener

{

	//Main Place on Form where All Child Forms will Shown.

	ImageIcon i;
	TipOfDay tip;
	QueryBrowser qb;
	
	Login l;
	String u=l.u;
	String p=l.pass;

	private java.util.Date currDate = new java.util.Date ();					//Creating Object.
	private SimpleDateFormat sdf = new SimpleDateFormat ("dd MMMM yyyy", Locale.getDefault());	//Changing Format.
	private String d = sdf.format (currDate);

	public static JDesktopPane desktop = new JDesktopPane ();
 		
	//For Program's MenuBar.

	private JMenuBar bar;

	private JMenu mnuDatabase, mnuTable, mnuEdit, mnuQuery , mnuTools , mnuUsers , mnuHelp , mnuPLSQL;

	private JMenuItem newdb,dropdb,showdb,end;	//Database Menu Options.

	private JMenuItem start,stop,objbro,flush,engine;		//Tools Menu Options

	private JMenuItem create,drop,insert,show,showdata,alter,rename,update,delete,describe;		//Table Menu Options

	private JMenuItem cut,copy,paste;		//Edit Menu Options

	private JMenuItem about,keyHelp,myhelp,tips,lic;//Help Menu Options

	public  JMenuItem newquery,loadquery,savequery;//Query Menu Options

	public  JMenuItem view,index,function,trigger,procedure;

	private JPopupMenu popMenu = new JPopupMenu ();
	
	//For Program's ToolBar.

	private	JToolBar toolBar;

	//For ToolBar's Button.

	private	JButton btndb,btnexit,btndrop,btnshow; //Buttons for Database menu

	private JButton btnstart,btnstop;	       //Buttons for Tools Menu	

	private JButton btncreate,btndropt,btninsert;	       //Buttons for Table Menu 

	private JPanel statusBar = new JPanel ();
	
	public static JLabel lbusr,lbdb;	

	
	public MysqlPlus1 ()
	{
		super ("MysqlPlus");

		//Setting the Main Window of Program.

		setIconImage (getToolkit().getImage ("images/launcher.PNG"));	//Setting the Program's Icon.
		setSize (750, 600);						//Setting Main Window Size.
				
		i=new ImageIcon("images/h.gif");
		tip=new TipOfDay();
		tip.setLocation(100,100);
		tip.setVisible(true);
		desktop.add(tip);
			
		ImageIcon icon = new ImageIcon(getClass().getResource("images/1152696940.jpg")); 
	        JLabel label = new JLabel(icon);
        	label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); 
	        desktop.add(label, new Integer(Integer.MIN_VALUE)); 

			
		//Setting the Location of Program on User's Computer Screen By Getting the Screen's Height & Width.
		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width  - getWidth()) / 2,(Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
		

		//Closing Code of Main Window.

		addWindowListener (new WindowAdapter () {		//Attaching the WindowListener to Program.
			public void windowClosing (WindowEvent we) {	//Overriding the windowClosing Function.
				System.exit(0);				//Call the Function to Perform the Closing Action.
			}
		}
		);
		bar = new JMenuBar ();		//Creating the MenuBar Object.
//		Color s=new Color(220,196,170);
		bar.setBackground(Color.white);
		
		setJMenuBar (bar);		//Setting Main Window MenuBar.
		
		//Creating the Menus of Program & Assigning the Key too to Open them.

		mnuDatabase = new JMenu ("Database");
		mnuDatabase.setForeground((Color.blue));
		mnuDatabase.setFont(new Font("verdana",Font.BOLD,12));
		mnuDatabase.setMnemonic ((int)'D');

		mnuTable = new JMenu ("Table");
		mnuTable.setForeground((Color.blue));
		mnuTable.setFont(new Font("verdana",Font.BOLD,12));
		mnuTable.setMnemonic ((int)'T');

		mnuEdit = new JMenu ("Edit");
		mnuEdit.setForeground((Color.blue));
		mnuEdit.setFont(new Font("verdana",Font.BOLD,12));
		mnuEdit.setMnemonic ((int)'E');

		mnuQuery = new JMenu("Query");
		mnuQuery.setForeground((Color.blue));
		mnuQuery.setFont(new Font("verdana",Font.BOLD,12));
		mnuQuery.setMnemonic ((int)'Q');

		mnuPLSQL = new JMenu ("PL/SQL");
		mnuPLSQL.setForeground((Color.blue));
		mnuPLSQL.setFont(new Font("verdana",Font.BOLD,12));
		mnuPLSQL.setMnemonic ((int)'P');

		mnuTools = new JMenu ("Tools");
		mnuTools.setForeground((Color.blue));
		mnuTools.setFont(new Font("verdana",Font.BOLD,12));
		mnuTools.setMnemonic ((int)'L');

		mnuHelp = new JMenu ("Help");
		mnuHelp.setForeground((Color.blue));
		mnuHelp.setFont(new Font("verdana",Font.BOLD,12));
		mnuHelp.setMnemonic ((int)'H');
		

		
		//Creating All the MenuItems of Program.

		//MenuItems for Database Menu.

		newdb = new JMenuItem ("Create New Database",new ImageIcon(ClassLoader.getSystemResource("images\\database.PNG")));
		newdb.setFont(new Font("verdana",Font.BOLD,12));
		newdb.setForeground(Color.magenta);
		newdb.setBackground(Color.white);
		newdb.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
		newdb.setMnemonic ((int)'N');
		newdb.addActionListener (this);


		dropdb = new JMenuItem (" Drop Database",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
		dropdb.setFont(new Font("verdana",Font.BOLD,12));
		dropdb.setForeground(Color.magenta);
		dropdb.setBackground(Color.white);
		dropdb.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
		dropdb.setMnemonic ((int)'R');
		dropdb.addActionListener (this);

		showdb = new JMenuItem (" Show All Databases",new ImageIcon(ClassLoader.getSystemResource("images\\databases.PNG")));
		showdb.setFont(new Font("verdana",Font.BOLD,12));
		showdb.setForeground(Color.magenta);
		showdb.setBackground(Color.white);
		showdb.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK));
		showdb.setMnemonic ((int)'U');
		showdb.addActionListener (this);

		end = new JMenuItem (" Quit",new ImageIcon(ClassLoader.getSystemResource("images\\quit.PNG")));
		end.setFont(new Font("verdana",Font.BOLD,12));
		end.setForeground(Color.magenta);
		end.setBackground(Color.white);
		end.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
		end.setMnemonic ((int)'Q');
		end.addActionListener (this);

		
		//MenuItems for Table Menu.

		create = new JMenuItem ("Create New Table",new ImageIcon(ClassLoader.getSystemResource("images\\table.PNG")));
		create.setFont(new Font("verdana",Font.BOLD,12));
		create.setForeground(Color.magenta);
		create.setBackground(Color.white);
		create.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
		create.setMnemonic ((int)'T');
		create.addActionListener (this);

		insert = new JMenuItem ("Insert Into Table",new ImageIcon(ClassLoader.getSystemResource("images\\insert.PNG")));
		insert.setFont(new Font("verdana",Font.BOLD,12));
		insert.setForeground(Color.magenta);
		insert.setBackground(Color.white);
		insert.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
		insert.setMnemonic ((int)'I');
		insert.addActionListener (this);

		delete = new JMenuItem ("Delete From Table",new ImageIcon(ClassLoader.getSystemResource("images\\b_tblexport.PNG")));
		delete.setFont(new Font("verdana",Font.BOLD,12));
		delete.setForeground(Color.magenta);
		delete.setBackground(Color.white);
		delete.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
		delete.setMnemonic ((int)'B');
		delete.addActionListener (this);

		update = new JMenuItem ("Update Table",new ImageIcon(ClassLoader.getSystemResource("images\\database_sql_editor.PNG")));
		update.setFont(new Font("verdana",Font.BOLD,12));
		update.setForeground(Color.magenta);
		update.setBackground(Color.white);
		update.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
		update.setMnemonic ((int)'P');
		update.addActionListener (this);

		drop = new JMenuItem ("Drop Table",new ImageIcon(ClassLoader.getSystemResource("images\\droptable.PNG")));
		drop.setFont(new Font("verdana",Font.BOLD,12));
		drop.setForeground(Color.magenta);
		drop.setBackground(Color.white);
		drop.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK));
		drop.setMnemonic ((int)'D');
		drop.addActionListener (this);	

		show = new JMenuItem ("Show Tables",new ImageIcon(ClassLoader.getSystemResource("images\\tables.PNG")));
		show.setFont(new Font("verdana",Font.BOLD,12));
		show.setForeground(Color.magenta);
		show.setBackground(Color.white);
		show.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_G, Event.CTRL_MASK));
		show.setMnemonic ((int)'G');
		show.addActionListener (this);	

		showdata = new JMenuItem ("Show Table Data",new ImageIcon(ClassLoader.getSystemResource("images\\bd_ftext.PNG")));
		showdata.setFont(new Font("verdana",Font.BOLD,12));
		showdata.setForeground(Color.magenta);
		showdata.setBackground(Color.white);
		showdata.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK));
		showdata.setMnemonic ((int)'F');
		showdata.addActionListener (this);

		alter = new JMenuItem ("Alter Table",new ImageIcon(ClassLoader.getSystemResource("images\\edit.PNG")));
		alter.setFont(new Font("verdana",Font.BOLD,12));
		alter.setForeground(Color.magenta);
		alter.setBackground(Color.white);
		alter.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
		alter.setMnemonic ((int)'A');
		alter.addActionListener (this);

		rename = new JMenuItem ("Rename Table",new ImageIcon(ClassLoader.getSystemResource("images\\b_browse.PNG")));
		rename.setFont(new Font("verdana",Font.BOLD,12));
		rename.setForeground(Color.magenta);
		rename.setBackground(Color.white);
		rename.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_M, Event.CTRL_MASK));
		rename.setMnemonic ((int)'M');
		rename.addActionListener (this);

		describe = new JMenuItem ("Describe Table",new ImageIcon(ClassLoader.getSystemResource("images\\logview.PNG")));
		describe.setFont(new Font("verdana",Font.BOLD,12));
		describe.setForeground(Color.magenta);
		describe.setBackground(Color.white);
		describe.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_O, Event.CTRL_MASK));
		describe.setMnemonic ((int)'O');
		describe.addActionListener (this);

		//MenuItems for Edit Menu.

		cut = new JMenuItem (new javax.swing.text.DefaultEditorKit.CutAction());
		cut.setFont(new Font("verdana",Font.BOLD,12));
		cut.setText("Cut");
		cut.setForeground(Color.magenta);
		cut.setBackground(Color.white);
		cut.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
		cut.setMnemonic ((int)'X');
		cut.addActionListener (this);


		copy = new JMenuItem (new javax.swing.text.DefaultEditorKit.CopyAction());
		copy.setFont(new Font("verdana",Font.BOLD,12));
		copy.setText("Copy");
		copy.setForeground(Color.magenta);
		copy.setBackground(Color.white);
		copy.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
		copy.setMnemonic ((int)'C');
		copy.addActionListener (this);

		paste= new JMenuItem (new javax.swing.text.DefaultEditorKit.PasteAction());
		paste.setFont(new Font("verdana",Font.BOLD,12));
		paste.setText("Paste");
		paste.setForeground(Color.magenta);
		paste.setBackground(Color.white);
		paste.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
		paste.setMnemonic ((int)'V');
		paste.addActionListener (this);	

		
		//MenuItems for Query Menu
		
		newquery= new JMenuItem (" New Query Window",new ImageIcon(ClassLoader.getSystemResource("images\\new.png")));
		newquery.setFont(new Font("verdana",Font.BOLD,12));
		newquery.setForeground(Color.magenta);
		newquery.setBackground(Color.white);
		newquery.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_W, Event.CTRL_MASK));
		newquery.setMnemonic ((int)'W');
		newquery.addActionListener (this);

		loadquery= new JMenuItem ("Load Saved Query",new ImageIcon(ClassLoader.getSystemResource("images\\fileopen.png")));
		loadquery.setFont(new Font("verdana",Font.BOLD,12));
		loadquery.setForeground(Color.magenta);
		loadquery.setBackground(Color.white);
		loadquery.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
		loadquery.setMnemonic ((int)'L');
		loadquery.addActionListener (this);

		savequery= new JMenuItem ("Save Query",new ImageIcon(ClassLoader.getSystemResource("images\\filesave.png")));
		savequery.setFont(new Font("verdana",Font.BOLD,12));
		savequery.setForeground(Color.magenta);
		savequery.setBackground(Color.white);
		savequery.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		savequery.setMnemonic ((int)'S');
		savequery.addActionListener (this);

		//MenuItems For PLSQL menu

		index= new JMenuItem ("Index",new ImageIcon(ClassLoader.getSystemResource("images\\bullet1s.gif")));
		index.setFont(new Font("verdana",Font.BOLD,12));
		index.setForeground(Color.magenta);
		index.setBackground(Color.white);
		index.addActionListener (this);	

		view= new JMenuItem ("Views",new ImageIcon(ClassLoader.getSystemResource("images\\bullet2.gif")));
		view.setFont(new Font("verdana",Font.BOLD,12));
		view.setForeground(Color.magenta);
		view.setBackground(Color.white);
		view.addActionListener (this);	

		function= new JMenuItem ("Functions",new ImageIcon(ClassLoader.getSystemResource("images\\bullet_orange.gif")));
		function.setFont(new Font("verdana",Font.BOLD,12));
		function.setForeground(Color.magenta);
		function.setBackground(Color.white);
		function.addActionListener (this);

		trigger= new JMenuItem ("Triggers",new ImageIcon(ClassLoader.getSystemResource("images\\bullet3.gif")));
		trigger.setFont(new Font("verdana",Font.BOLD,12));
		trigger.setForeground(Color.magenta);
		trigger.setBackground(Color.white);
		trigger.addActionListener (this);

		procedure= new JMenuItem ("Procedures",new ImageIcon(ClassLoader.getSystemResource("images\\bullet4.gif")));
		procedure.setFont(new Font("verdana",Font.BOLD,12));
		procedure.setForeground(Color.magenta);
		procedure.setBackground(Color.white);
		procedure.addActionListener (this);	
		
		//MenuItems for Tools Menu.

		start = new JMenuItem ("Start Services",new ImageIcon(ClassLoader.getSystemResource("images\\start.jpg")));
		start.setFont(new Font("verdana",Font.BOLD,12));
		start.setForeground(Color.magenta);
		start.setBackground(Color.white);
		start.addActionListener (this);

		stop = new JMenuItem ("Stop Services",new ImageIcon(ClassLoader.getSystemResource("images\\stop.jpg")));
		stop.setFont(new Font("verdana",Font.BOLD,12));
		stop.setForeground(Color.magenta);
		stop.setBackground(Color.white);
		stop.addActionListener (this);

		objbro = new JMenuItem ("Object Browser",new ImageIcon(ClassLoader.getSystemResource("images\\display_field.PNG")));
		objbro.setFont(new Font("verdana",Font.BOLD,12));
		objbro.setForeground(Color.magenta);
		objbro.setBackground(Color.white);
		objbro.addActionListener (this);

		flush = new JMenuItem ("Flush Query Cache",new ImageIcon(ClassLoader.getSystemResource("images\\refresh.PNG")));
		flush.setFont(new Font("verdana",Font.BOLD,12));
		flush.setForeground(Color.magenta);
		flush.setBackground(Color.white);
		flush.addActionListener (this);

		engine = new JMenuItem ("Mysql Engines",new ImageIcon(ClassLoader.getSystemResource("images\\database_tools.PNG")));
		engine.setFont(new Font("verdana",Font.BOLD,12));
		engine.setForeground(Color.magenta);
		engine.setBackground(Color.white);
		engine.addActionListener (this);

		//MenuItems for Help Menu.

		about = new JMenuItem ("About MysqlPlus",new ImageIcon(ClassLoader.getSystemResource("images\\launcher1.PNG")));
		about.setFont(new Font("verdana",Font.BOLD,12));
		about.setForeground(Color.magenta);
		about.setBackground(Color.white);
		about.addActionListener (this);

		keyHelp = new JMenuItem ("Shortcut Keys",new ImageIcon(ClassLoader.getSystemResource("images\\password1.PNG")));
		keyHelp.setFont(new Font("verdana",Font.BOLD,12));
		keyHelp.setForeground(Color.magenta);
		keyHelp.setBackground(Color.white);
		keyHelp.addActionListener (this);

		myhelp = new JMenuItem ("Mysql Help",new ImageIcon(ClassLoader.getSystemResource("images\\pdf.gif")));
		myhelp.setFont(new Font("verdana",Font.BOLD,12));
		myhelp.setForeground(Color.magenta);
		myhelp.setBackground(Color.white);
		myhelp.addActionListener (this);

		tips = new JMenuItem ("Show Tips Dialog",new ImageIcon(ClassLoader.getSystemResource("images\\tips1.png")));
		tips.setFont(new Font("verdana",Font.BOLD,12));
		tips.setForeground(Color.magenta);
		tips.setBackground(Color.white);
		tips.addActionListener (this);

		lic = new JMenuItem ("License",new ImageIcon(ClassLoader.getSystemResource("images\\alert.gif")));
		lic.setFont(new Font("verdana",Font.BOLD,12));
		lic.setForeground(Color.magenta);
		lic.setBackground(Color.white);
		lic.addActionListener (this);



	//File Menu Items.
	mnuDatabase.add (newdb);
	mnuDatabase.add (dropdb);
	mnuDatabase.add (showdb);
	mnuDatabase.add (end);

	//Table Menu Items
	mnuTable.add(create);
	mnuTable.add(insert);
	mnuTable.add(delete);
	mnuTable.add(update);
	mnuTable.add(drop);
	mnuTable.add(show);
	mnuTable.add(showdata);
	mnuTable.add(alter);
	mnuTable.add(rename);
	mnuTable.add(describe);
	
	//Edit Menu Items
	mnuEdit.add(cut);
	mnuEdit.add(copy);
	mnuEdit.add(paste);
	
	//Query Menu Items
	
	mnuQuery.add(newquery);
	mnuQuery.add(loadquery);
	mnuQuery.add(savequery);

	//PLSQL Menu Items
	
	mnuPLSQL.add(index);
	mnuPLSQL.add(view);
	mnuPLSQL.add(function);
	mnuPLSQL.add(trigger);
	mnuPLSQL.add(procedure);
	
	//Tools Menu Items
	mnuTools.add(start);
	mnuTools.add(stop);
	mnuTools.add(objbro);
	mnuTools.add(flush);
	mnuTools.add(engine);

	//Help Menu Items
	mnuHelp.add(about);
	mnuHelp.add(keyHelp);
	mnuHelp.add(myhelp);
	mnuHelp.add(tips);
	mnuHelp.add(lic);

	//Adding All Menus to MenuBar.

	bar.add (mnuDatabase);
	bar.add (mnuTable);
	bar.add (mnuEdit);
	bar.add (mnuQuery);
	bar.add (mnuPLSQL);
	bar.add (mnuTools);
	bar.add (mnuHelp);
	
	//Following Procedure display the PopupMenu of Program Whenever User Right Click on Program By Mouse.

	addMouseListener (new MouseAdapter () {
		public void mousePressed (MouseEvent me) { checkMouseTrigger (me); }
		public void mouseReleased (MouseEvent me) { checkMouseTrigger (me); }
		private void checkMouseTrigger (MouseEvent me) {
			if (me.isPopupTrigger ())
				popMenu.show (me.getComponent (), me.getX (), me.getY ());
		}
	}
	);
	
	//Tool Bar Buttons for Database menu
	
	btndb = new JButton (new ImageIcon ("images/database.PNG"));
	btndb.setToolTipText ("Create New Database");
	btndb.addActionListener (this);

	btndrop = new JButton (new ImageIcon ("images/cancel.PNG"));
	btndrop.setToolTipText ("Drop Database");
	btndrop.addActionListener (this);

	btnshow = new JButton (new ImageIcon ("images/databases.PNG"));
	btnshow.setToolTipText ("Show All Databases");
	btnshow.addActionListener (this);
	
	btnexit = new JButton (new ImageIcon ("images/quit.PNG"));
	btnexit.setToolTipText ("Close the Application");
	btnexit.addActionListener (this);

	//Tool Bar Buttons for Table menu

	btncreate = new JButton (new ImageIcon ("images/table.PNG"));
	btncreate.setToolTipText ("Create New Table");
	btncreate.addActionListener (this);

	btninsert = new JButton (new ImageIcon ("images/insert.PNG"));
	btninsert.setToolTipText ("Insert Into Table");
	btninsert.addActionListener (this);

	btndropt = new JButton (new ImageIcon ("images/droptable.PNG"));
	btndropt.setToolTipText ("Drop Table");
	btndropt.addActionListener (this);

	//Tool Bar Buttons for Tools menu

	btnstart = new JButton (new ImageIcon ("images/start.jpg"));
	btnstart.setToolTipText ("Start Mysql Services");
	btnstart.addActionListener (this);

	btnstop = new JButton (new ImageIcon ("images/stop.jpg"));
	btnstop.setToolTipText ("Stop Mysql Services");
	btnstop.addActionListener (this);

	//Creating the ToolBar of Program.
	//ToolBar for Database Menu

	toolBar = new JToolBar ();
	toolBar.setBackground(Color.white);
	toolBar.add (btndb);
	toolBar.addSeparator ();
	toolBar.add (btndrop);
	toolBar.addSeparator ();
	toolBar.add (btnshow);

	//ToolBar for Table Menu

	toolBar.addSeparator ();
	toolBar.add (btncreate);
	toolBar.addSeparator ();
	toolBar.add (btninsert);
	toolBar.addSeparator ();
	toolBar.add (btndropt);
	

	//ToolBar for Tools Menu

	toolBar.addSeparator ();
	toolBar.add (btnstart);
	toolBar.addSeparator ();
	toolBar.add (btnstop);
	toolBar.addSeparator ();	
	toolBar.add (btnexit); // Quit Tool Bar option


	lbusr = new JLabel ("User :"+u+"  "+d,JLabel.LEFT);
	lbusr.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,14));
	lbusr.setForeground (Color.red);

	//statusBar.setLayout (new BorderLayout());
	Color c=new Color(220,249,255);
	statusBar.setBackground(c);
	statusBar.add (lbusr,BorderLayout.SOUTH);
   
	//Setting the Contents of Programs.

	getContentPane().add (toolBar, BorderLayout.NORTH);
	getContentPane().add (desktop, BorderLayout.CENTER);
	getContentPane().add (statusBar, BorderLayout.SOUTH);


	
	setVisible (true);
	
	}	
	
	public void actionPerformed (ActionEvent ae) 
                 {
		
		Object obj = ae.getSource();

		if (obj == newdb || obj == btndb)
		        {
			CreateDatabase cd=new CreateDatabase();
			desktop.add (cd);
			cd.show ();
			cd.setBounds(300,150,300,175);	
			}

		else if (obj == dropdb || obj == btndrop)
		        {
			DropDatabase dd=new DropDatabase();
			desktop.add (dd);
			dd.show ();
			dd.setBounds(300,150,300,175);	
			}

		else if (obj == showdb || obj == btnshow)
		        {
			ShowDatabases sd=new ShowDatabases();
			desktop.add (sd);
			sd.show ();
			}

		else if(obj == end || obj == btnexit)
			{
			quitApp();
			}

		
		else if (obj == create || obj == btncreate)
			{	
			CreateTable ct = new CreateTable();
			try
			     {
			     Class.forName("com.mysql.jdbc.Driver");

  			     String url="jdbc:mysql://localhost:3306/";
				
			     Connection conn=DriverManager.getConnection(url,u,p);		
			
			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        ct.combodb.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }
			ct.pack();
			ct.setVisible(true);
			desktop.add(ct);
			}

		else if (obj == insert || obj == btninsert)
			{
			Insert it = new Insert();
			try
			     {
			     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        it.dbcombo.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }	
			it.pack();
			it.setVisible(true);
			desktop.add(it);
			}

		else if (obj == update)
			{
			Update ut = new Update();
			try
			     {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");	
			
			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        ut.dbcombo.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }	
			ut.pack();
			ut.setVisible(true);
			desktop.add(ut);
			}

		else if (obj == delete)
			{
			Delete dft = new Delete();
			try
			     {
			     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");	
			
			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        dft.dbcombo.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }	
			dft.pack();
			dft.setVisible(true);
			desktop.add(dft);
			}

		else if (obj == drop || obj == btndropt)
			{
			DropTable dt=new DropTable();
			try
			     {
			     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");		
			
			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        dt.dbcombo.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }	
			dt.pack();
			dt.setVisible(true);
			desktop.add(dt);
			}

		else if(obj==show)
			{
			ShowTables st=new ShowTables();
			try
			     {
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");		
			
			     Statement stmt=conn.createStatement();
	
	  		     String sql="show databases";

   			     stmt.executeQuery(sql);

 			     ResultSet rs=stmt.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        st.dbcombo.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }	
			st.setVisible(true);
			desktop.add(st);
			}

		else if (obj == showdata)
			{
			Select st1 = new Select();
			try
			     {
			     Class.forName("com.mysql.jdbc.Driver");

  			     String url="jdbc:mysql://localhost:3306/";
				
			     Connection conn=DriverManager.getConnection(url,u,p);		
			
			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        st1.dbcombo.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }	
			st1.pack();
			st1.setVisible(true);
			desktop.add(st1);
			}

		else if(obj==alter)
			{
			AlterTable at=new AlterTable();
			at.setVisible(true);
			desktop.add(at);
			}

		else if (obj == rename)
			{
			RenameTable rt=new RenameTable();
			try
			     {
			     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        rt.dbcombo.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }	
			rt.pack();
			rt.setVisible(true);
			desktop.add(rt);
			}

		else if (obj == describe)
			{
			Describe dt1 = new Describe();
			try
			     {
			    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");	
			
			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        dt1.dbcombo.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }	
			dt1.pack();
			dt1.setVisible(true);
			desktop.add(dt1);
			}

		else if(obj==newquery)
			{
			try
			  {
			  qb=new QueryBrowser();
			  qb.setVisible(true);
			  desktop.add(qb);
			  }	
			catch(Exception e) { }
			}

		else if(obj==loadquery)
			{
			if(qb!=null)
			{
			qb.query.setText("");
			
			JFileChooser fc=new JFileChooser();
			int returnval=fc.showOpenDialog(loadquery);
			if(returnval==JFileChooser.APPROVE_OPTION)
				{
				try
				   {
				   File f1=fc.getSelectedFile();
                                   FileInputStream fis = new FileInputStream(f1);
                                   BufferedInputStream bis = new BufferedInputStream(fis); 
				   DataInputStream dis = new DataInputStream(bis);
				   String record=null;
				   while((record=dis.readLine())!=null)
					{
					qb.query.append(record+"\n");
					
					}
				   }
				catch(IOException e)
				   {
				   e.printStackTrace();
				   }
				}
			}
			else
				{
				String str2="Please Open A Query Window First";
				JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
				}
			
			}

		else if(obj==savequery)
			{
			if(qb!=null)
			{
			try
			  {
                          JFileChooser fc1=new JFileChooser();
                          int returnval1=fc1.showSaveDialog(savequery);
                          if(returnval1==JFileChooser.APPROVE_OPTION)
                            {
                            if(fc1.getSelectedFile() != null)
                              {
                              FileWriter fo = new FileWriter(fc1.getSelectedFile().getAbsolutePath()+".txt"); 
                              fo.write(qb.query.getText());	
			         
                              fo.close(); 
			      JOptionPane.showMessageDialog(null,"File Saved","Save",JOptionPane.INFORMATION_MESSAGE); 			
                              }  
                            }
                          }
                        catch(Exception e2)
			  {
			  e2.printStackTrace();
                          }
			}
			else
			 {
			 String str2="Please Open A Query Window First";
			 JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			 }
			
			}
		else if(obj==view)
			{
			Views v=new Views();
			v.setVisible(true);
			desktop.add(v);
			}
		else if(obj==trigger)
			{
			Triggers t=new Triggers();
			t.setVisible(true);
			desktop.add(t);
			}

		else if(obj == start || obj == btnstart)
			{
				
			try
			  {
			  Thread.sleep(1000); 
			 	
		          Runtime.getRuntime().exec("NET START MYSQL");
   		  	  start s=new start();
			  desktop.add(s);
			  s.iterate(); 
			  Toolkit.getDefaultToolkit().beep();	
			  JOptionPane.showMessageDialog(null,"The MySQL service Started Successfully","Start Success",JOptionPane.INFORMATION_MESSAGE);
			  s.setClosed(true);  
			  }
			catch(Exception e)
			  {
			  
			  String str2=e.getMessage();		
			  JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE);
			  
			  }
					
			}

		else if(obj == stop || obj == btnstop)
			{
			try
			  {
			  Thread.sleep(1000); 
		          Runtime.getRuntime().exec("NET STOP MYSQL");
			  start s=new start();
			  desktop.add(s);
			  s.iterate(); 
			  Toolkit.getDefaultToolkit().beep();	
			  JOptionPane.showMessageDialog(null,"The MySQL Service Stopped Successfully","Stop Success",JOptionPane.INFORMATION_MESSAGE);
			  s.setClosed(true);
			  }
			catch(Exception e)
			  {
			  String str2=e.getMessage();		
			  JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE);
			  }
			}
				
		else if(obj==objbro)
			{
			try
			  {
			  JTreeStructure jt=new JTreeStructure();
			  desktop.add(jt);
			  }
			catch(Exception e)
			  {
			  }
			}

		else if(obj==flush)
			{
			try
			  {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");	
			
			  Statement st=conn.createStatement(); 

			  String sql="flush query cache";

			  st.executeUpdate(sql);

			  Thread.sleep(1500);

			  Toolkit.getDefaultToolkit().beep();

			  JOptionPane.showMessageDialog(null,"Flushing Completed ","Flush",JOptionPane.INFORMATION_MESSAGE);

			 }
			 catch(Exception e)
	   		 {
			 String str2=e.getMessage();
			 JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE);
			 } 
			}
		else if (obj == engine)
		        {
			Engines me=new Engines();
			desktop.add (me);
			me.show ();
			}

		

		else if(obj==about)
			{
			About a=new About();
			a.setVisible(true);
			desktop.add(a);
			}

		else if (obj == keyHelp)
			{
			ShortCuts hlpKey = new ShortCuts ("MysqlPlus Keys", "Help/Keys.htm");
			desktop.add (hlpKey);
			hlpKey.show ();
			} 

		else if (obj == myhelp)
			{
			MysqlHelp hlpKey1 = new MysqlHelp ("Mysql Help", "Help/");
			desktop.add (hlpKey1);
			hlpKey1.show ();
			} 

		else if (obj == tips)
			{
			TipOfDay tip=new TipOfDay();
			tip=new TipOfDay();
			tip.setLocation(250,125);
			tip.setVisible(true);
			desktop.add(tip);
			}

		else if(obj==lic)
			{
			License l=new License();
			l.setLocation(250,125);
			l.setVisible(true);
			desktop.add(l);
			} 
		}

		private void quitApp ()
                {
		try
                  {
		  int reply = JOptionPane.showConfirmDialog (this,"Do you really want to exit From MysqlPlus ?","MysqlPlus - Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		  
			//Check the User Selection.
			if (reply == JOptionPane.YES_OPTION)
			 {				//If User's Choice Yes then.
			  	
			  setVisible (false);					//Hide the Frame.
			  		
			  dispose();            					//Free the System Resources.
			  System.exit (0);        				//Close the Application.
			  }
			else if (reply == JOptionPane.NO_OPTION) {			//If User's Choice No then.
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	//Do Nothing Return to Program.
			}
		} 

		catch (Exception e) {}

	       }
		
}