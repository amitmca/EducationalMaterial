import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Insert extends JInternalFrame implements ItemListener,ActionListener
 {
    JLabel ldb;
    JLabel ltables;
    JComboBox dbcombo;
    JComboBox tablecombo;
    JButton btninsert;
    JButton btnclr;
    JButton btncel;
    private ImageIcon i;
    String db="";		
    String tables="",table="";
    public static JTextField t[];
    public static int col=0;	

    public Insert() 
        {
	super("Insert Data Into Table");
	i=new ImageIcon("images/insert.PNG");
	setFrameIcon(i);
	setLocation(200,30);

        InsertLayout customLayout = new InsertLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ldb = new JLabel("Select Database Name :");
	ldb.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ldb);

        ltables = new JLabel("Select Table Name :");
	ltables.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ltables);

        dbcombo = new JComboBox();	
	dbcombo.setFont(new Font("verdana", Font.BOLD, 12));
	dbcombo.setBackground(Color.white);
	dbcombo.setForeground(Color.red);
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        tablecombo = new JComboBox();	
	tablecombo.setFont(new Font("verdana", Font.BOLD, 12));
	tablecombo.setBackground(Color.white);
	tablecombo.setForeground(Color.red);
	tablecombo.addItemListener(this);
        getContentPane().add(tablecombo);

        btninsert = new JButton("Insert",new ImageIcon(ClassLoader.getSystemResource("images\\insert.PNG")));
	btninsert.setFont(new Font("verdana", Font.BOLD, 12));
	btninsert.addActionListener(this);
        getContentPane().add(btninsert);

        btnclr = new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("images\\display_field.PNG")));
	btnclr.setFont(new Font("verdana", Font.BOLD, 12));
	btnclr.addActionListener(this);
        getContentPane().add(btnclr);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana", Font.BOLD, 12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

	Color c=new Color(220,249,255);
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

		  int x=350,y=75; 

		  t=new JTextField[col];

		  for(int i=0;i<col;i++)
			{
			t[i]=new JTextField(25);
			t[i].setBounds(x,y,100,25);
			getContentPane().add(t[i]);
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
public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnclr)
		{
		for(int i=0;i<col;i++)
			{
			t[i].setText("");
			}
		}
	if(ae.getSource()==btninsert)
		{
		String query="insert into "+db+"."+table+" values(";
		String f1=" '\"+";
		String f2=" +\"',";
		String f3="";
		
  		String sql[]=new String[col];
		String final1="";

		for(int j=0;j<col;j++)
			{
			sql[j]=t[j].getText();
			f3=f1+sql[j]+f2;
			int len=f3.length();
			f3.replace(',','k');
			final1=f3+")";
			System.out.println(final1);
			}
			
			
		/*try
  		     {
		     Class.forName("com.mysql.jdbc.Driver");

	  	     String url="jdbc:mysql://localhost:3306/";
			
                     Connection con = DriverManager.getConnection(url+db,"root","amit12");

		     Statement stmt=con.createStatement();

 		     stmt.executeUpdate(final1);

	 	     System.out.println("ok"); 
		     }
		catch(Exception e)
		     {
		     System.out.println(e.getMessage()); 			
   		     }*/
		}
	}
}


class InsertLayout implements LayoutManager {

    public InsertLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 616 + insets.left + insets.right;
        dim.height = 548 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,200,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+8,200,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,200,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+40,200,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+504,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+504,120,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+504,120,24);}
    }
}
