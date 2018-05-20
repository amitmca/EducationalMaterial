import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SelectFTable extends JInternalFrame implements ItemListener,ActionListener
    {
    JLabel la;
    JLabel l1;
    JLabel label_2;
    JComboBox dbcombo;
    JComboBox tablecombo;
    JButton btnfirst;
    JButton btnnext;
    JButton btnprev;
    JButton btnlast;
    JPanel panel;
	 
    
    JButton btnexit;
    ImageIcon i=new ImageIcon("images/s_error.png");
    public static String db="";		
    public static String tables="",table="",sorttype="",type="",type1="";
    public static JTextField t[];
    public static String col_name="";
    public static int col=0;
    	 

    public SelectFTable() 
	{
	super("Show Table Data");
	ImageIcon i2=new ImageIcon("images/bd_ftext.PNG");
	setFrameIcon(i2);
	setLocation(200,30);
        SelectFTableLayout customLayout = new SelectFTableLayout();

        getContentPane().setFont(new Font("verdana", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        la = new JLabel("Select Database Name :");
	la.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(la);
	
        l1 = new JLabel("Select Table Name :");
	l1.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(l1);
	
        label_2 = new JLabel("");
	getContentPane().add(label_2);

	dbcombo = new JComboBox();
	dbcombo.setBackground(Color.white);
	dbcombo.setForeground(Color.red);
	dbcombo.setFont(new Font("verdana", Font.BOLD, 12));	
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        tablecombo = new JComboBox();
	tablecombo.setBackground(Color.white);
	tablecombo.setFont(new Font("verdana", Font.BOLD, 12));
	tablecombo.setForeground(Color.red);
	tablecombo.addItemListener(this);
        getContentPane().add(tablecombo);

        btnfirst = new JButton("First");
	btnfirst.setFont(new Font("verdana", Font.BOLD, 12));
	btnfirst.addActionListener(this);
        getContentPane().add(btnfirst);

        btnnext = new JButton("Next",new ImageIcon(ClassLoader.getSystemResource("images\\rightarrow.png")));
	btnnext.setFont(new Font("verdana", Font.BOLD, 12));
	btnnext.addActionListener(this);
        getContentPane().add(btnnext);

        btnprev = new JButton("Prev",new ImageIcon(ClassLoader.getSystemResource("images\\leftarrow.png")));
	btnprev.setFont(new Font("verdana", Font.BOLD, 12));
	btnprev.addActionListener(this);
        getContentPane().add(btnprev);

        btnlast = new JButton("Last");
	btnlast.setFont(new Font("verdana", Font.BOLD, 12));
	btnlast.addActionListener(this);
        getContentPane().add(btnlast);

        panel = new JPanel();
	panel.setFont(new Font("verdana", Font.BOLD, 12));
	Color c1=new Color(220,249,255);
	panel.setBackground(c1);
        getContentPane().add(panel);

        btnexit = new JButton(new ImageIcon(ClassLoader.getSystemResource("images\\s_error.png")));
	btnexit.addActionListener(this);
        getContentPane().add(btnexit);


  	Color c=new Color(220,231,170);
	getContentPane().setBackground(c);
        setSize(getPreferredSize());
      }

 
public void itemStateChanged(ItemEvent ie)
	{
	
	if(ie.getSource()==dbcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
		db=(String)ie.getItem();
		
		Connection con = null;
		try 
    		   {
		   Class.forName("com.mysql.jdbc.Driver");

		   String url="jdbc:mysql://localhost:3306/"+db;
			
                   con = DriverManager.getConnection(url,"root","amit12");

		   DatabaseMetaData meta = con.getMetaData();
			
		   tables="";

     		   ResultSet res = meta.getTables(null, null, null, new String[] {"TABLE"});

		   tablecombo.removeAllItems();

		   while (res.next()) 
		  	{
	         	tables=res.getString("TABLE_NAME");
		  	tablecombo.addItem(tables);
		  	}
			
		    }
	       
 	   	catch (java.lang.ClassNotFoundException e)
    		    {
  	 	    System.err.println("ClassNotFoundException: "+e.getMessage());
		    	
    		    }
 		catch (SQLException e) 
     		    {
		    System.err.println("SQLException: "+e.getMessage());
		    }
		}	
	       }	
	if(ie.getSource()==tablecombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
		table=(String)ie.getItem();	
		try
  		  {
		  Class.forName("com.mysql.jdbc.Driver");

	  	  String url="jdbc:mysql://localhost:3306/";
			
                  Connection con = DriverManager.getConnection(url+db,"root","amit12");

		  Statement stmt=con.createStatement();

		  String sql="select * from "+table;

		  ResultSet rs=stmt.executeQuery(sql);

	          ResultSetMetaData md = rs.getMetaData();

		  col = md.getColumnCount();

		  int x=175,y=125; 

		  t=new JTextField[col];

		  for(int i=0;i<col;i++)
			{
			t[i]=new JTextField();
			t[i].setBounds(x,y,200,25);
			t[i].setFont(new Font("verdana",Font.BOLD,12));	
			t[i].setHorizontalAlignment(JTextField.CENTER);
			getContentPane().add(t[i]);
			t[i].setForeground(Color.blue);
			Color c=new Color(183,194,242);
			t[i].setBackground(c);	
			repaint();
			y=y+35;
			}
		  }
		catch(Exception e)
		  {
		  System.out.println(e.getMessage()); 			
   		  }
		}
		}
		
	}
public static void order()
	{	
	Statement stmt;
	ResultSet rs,rs1;
	Connection conn;
	try
		{
		
		Class.forName("com.mysql.jdbc.Driver");

		String url="jdbc:mysql://localhost:3306/"+db;
			
               	conn = DriverManager.getConnection(url,"root","amit12");

		stmt=conn.createStatement();

		String sql="select * from "+db+"."+table; 

		rs=stmt.executeQuery(sql);

		ResultSetMetaData md=rs.getMetaData();
		
		for(int i=1;i<2;i++)
			{
			col_name = md.getColumnName(i);
			}
		int len=col_name.length();
		System.out.println(len);
		}
		catch(ClassNotFoundException e)
		{
		System.out.println(e);
		}
		catch(SQLException e1)
		{
		System.out.println(e1);
		}
	}

public static void First()
	{
	order();
	Statement stmt;
	ResultSet rs,rs1;
	Connection conn;
	try
		{
		
		Class.forName("com.mysql.jdbc.Driver");

		String url="jdbc:mysql://localhost:3306/"+db;
			
               	conn = DriverManager.getConnection(url,"root","amit12");

		stmt=conn.createStatement();

		String sql="select * from "+db+"."+table+" order by "+col_name+" desc"; 

		rs=stmt.executeQuery(sql);

		String r="";

		while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=rs.getString(i);
			  t[i-1].setText(r);
			
			  }  
			 
			} 
		}
		catch(ClassNotFoundException e)
		{
		System.out.println(e);
		}
		catch(SQLException e1)
		{
		}
	}

public static void Last()
	{
	order();
	Statement stmt;
	ResultSet rs,rs1;
	Connection conn;
	try
		{
		
		Class.forName("com.mysql.jdbc.Driver");

		String url="jdbc:mysql://localhost:3306/"+db;
			
               	conn = DriverManager.getConnection(url,"root","amit12");

		stmt=conn.createStatement();

		String sql="select * from "+db+"."+table+" order by "+col_name+" asc"; 

		rs=stmt.executeQuery(sql);

		String r="";

		while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=rs.getString(i);
			  t[i-1].setText(r);
			
			  }  
			 
			} 
		}
		catch(ClassNotFoundException e)
		{
		System.out.println(e);
		}
		catch(SQLException e1)
		{
		}
	}

public static void Next()
	{
	order();
	Statement stmt;
	ResultSet rs,rs1;
	Connection conn;
	if(t[0].getText().trim().equals("")==false)
	   {
	   try
		{
		
		Class.forName("com.mysql.jdbc.Driver");

		String url="jdbc:mysql://localhost:3306/"+db;
			
               	conn = DriverManager.getConnection(url,"root","amit12");

		stmt=conn.createStatement();

		String sql="select * from "+db+"."+table+" order by "+col_name+" asc"; 

		rs=stmt.executeQuery(sql);

		String r="";

		while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=rs.getString(i);
			  t[i-1].setText(r);
			
			  }  
			 
			} 
		}
		catch(ClassNotFoundException e)
		{
		System.out.println(e);
		}
		catch(SQLException e1)
		{
		}
	    }	
	else
	    {
	    //First();
	    JOptionPane.showMessageDialog(null,"No More Rows Available","No More Rows Available",JOptionPane.PLAIN_MESSAGE);
	    }
	}

public static void Prev()
	{
	order();
	Statement stmt;
	ResultSet rs,rs1;
	Connection conn;
	if(t[0].getText().trim().equals("")==false)
	   {
	   try
		{
		
		Class.forName("com.mysql.jdbc.Driver");

		String url="jdbc:mysql://localhost:3306/"+db;
			
               	conn = DriverManager.getConnection(url,"root","amit12");

		stmt=conn.createStatement();

		String sql="select * from "+db+"."+table+" order by "+col_name+" asc"; 

		rs=stmt.executeQuery(sql);

		String r="";

		while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=rs.getString(i);
			  t[i-1].setText(r);
			
			  }  
			 
			} 
		}
		catch(ClassNotFoundException e)
		{
		System.out.println(e);
		}
		catch(SQLException e1)
		{
		}
	    }	
	else
	    {
	    //First();
	    JOptionPane.showMessageDialog(null,"No More Rows Available","No More Rows Available",JOptionPane.PLAIN_MESSAGE);
	    }
	}

public void actionPerformed(ActionEvent ae)
	{	
	if(ae.getSource()==btnexit)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnfirst)
		{
		repaint();
		First();
		}
	if(ae.getSource()==btnlast)
		{
		repaint();
		Last();
		}
	if(ae.getSource()==btnnext)
		{
		repaint();
		Next();
		}
	if(ae.getSource()==btnprev)
		{
		repaint();
		Prev();
		}
	}
}
class SelectFTableLayout implements LayoutManager {

    public SelectFTableLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 522 + insets.left + insets.right;
        dim.height = 542 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+24,160,16);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+24,160,16);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+24,72,16);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+48,160,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+48,160,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+504,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+504,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+504,104,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+440,insets.top+504,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+104,496,384);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+480,insets.top+0,40,24);}
    }
}
