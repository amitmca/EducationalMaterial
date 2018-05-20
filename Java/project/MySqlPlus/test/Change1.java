import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Change1 extends JInternalFrame implements ItemListener,ActionListener
    {
    JLabel l1;
    JLabel l2;
    JComboBox dbcombo;
    JComboBox tablecombo;
    JLabel l3;
    JComboBox dtcombo;
    JLabel dttype;
    JLabel l5;
    JTextArea textarea_1;
    JScrollPane sp_textarea_1;
    JButton btnalt;
    JButton btncel;
    JLabel lsize;
    JTextField size;
    JComboBox colcombo;
    public static String db="",tables="",table="",col_name="",datatype="",colname1="",colname=""; 	
    public static int col=0;
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;

    public Change1()
	{
	super("Change a Column Data Type");
	setLocation(275,120);
	ImageIcon i=new ImageIcon("images/b_props.PNG");
 	setFrameIcon(i);
        Change1Layout customLayout = new Change1Layout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        l1 = new JLabel("Select Database Name :");
	l1.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l1);

        l2 = new JLabel("Select Table Name :");
	l2.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l2);

        dbcombo = new JComboBox();
	dbcombo.setFont(new Font("verdana",Font.BOLD,12));
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        tablecombo = new JComboBox();
	tablecombo.setFont(new Font("verdana",Font.BOLD,12));
	tablecombo.addItemListener(this);
        getContentPane().add(tablecombo);


        l3 = new JLabel("Columns             :");
	l3.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l3);

        dtcombo = new JComboBox();
	dtcombo.setFont(new Font("verdana",Font.BOLD,12));
        dtcombo.addItem("INT");
        dtcombo.addItem("INTEGER");
        dtcombo.addItem("TINYINT");
        dtcombo.addItem("SMALLINT");
        dtcombo.addItem("BIGINT");
        dtcombo.addItem("CHAR");
        dtcombo.addItem("VARCHAR");
        dtcombo.addItem("TEXT");
	dtcombo.addItem("BOOL");
	dtcombo.addItem("DATE");
	dtcombo.addItem("TIME");
	dtcombo.addItem("DATETIME");
	dtcombo.addItem("FLOAT");
	dtcombo.addItem("DOUBLE");
	dtcombo.addItem("REAL");
	dtcombo.addItem("CURRENCY");
	dtcombo.addItem("BINARY");
	dtcombo.addItem("BLOB");
	dtcombo.addItem("BLOB-INT");
        dtcombo.addItem("BLOB-TINYINT");
        dtcombo.addItem("BLOB-SMALLINT");
        dtcombo.addItem("BLOB-BIGINT");
        dtcombo.addItem("BLOB-CHAR");
        dtcombo.addItem("BLOB-VARCHAR");
        dtcombo.addItem("BLOB-TEXT");
	dtcombo.addItem("BLOB-BOOL");
	dtcombo.addItem("BLOB-DATE");
	dtcombo.addItem("BLOB-DATETIME");
	dtcombo.addItem("BLOB-FLOAT");
	dtcombo.addItemListener(this);
        getContentPane().add(dtcombo);

        dttype = new JLabel("New Data Type  :");
	dttype.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(dttype);

        l5 = new JLabel("Query");
	l5.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l5);

        textarea_1 = new JTextArea("");
	textarea_1.setFont(new Font("verdana",Font.BOLD,12));
        sp_textarea_1 = new JScrollPane(textarea_1);
        getContentPane().add(sp_textarea_1);
       
        btnalt = new JButton("Alter",new ImageIcon(ClassLoader.getSystemResource("images\\homesearch.PNG")));
	btnalt.setFont(new Font("verdana",Font.BOLD,12));
	btnalt.addActionListener(this);
        getContentPane().add(btnalt);
      
        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana",Font.BOLD,12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

        lsize = new JLabel(" Size     :");
	lsize.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(lsize);

        size = new JTextField("");
	size.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(size);

	colcombo = new JComboBox();
	colcombo.addItemListener(this);
	colcombo.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(colcombo);

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
		db=(String)dbcombo.getSelectedItem();
		Connection con = null;
		try 
    		   {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					 con=DriverManager.getConnection(url+db,"root","");

			DatabaseMetaData meta = con.getMetaData();
			
			tables="";

     			ResultSet res = meta.getTables(null, null, null, new String[] {"TABLE"});
			
			tablecombo.removeAllItems();

			while (res.next()) 
		  	{
	         	tables=res.getString("TABLE_NAME");
		  	tablecombo.addItem(tables);
			repaint();
		  	}
		     
		     
		    }
	       
 	   	catch (java.lang.ClassNotFoundException e)
    		    {
  	 	    String str=e.getMessage(); 			
		    JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);
   		    }
 		catch (SQLException e) 
     		    {
		    String str=e.getMessage(); 			
		    JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);
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
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					 Connection con=DriverManager.getConnection(url+db,"root","");

		  Statement stmt=con.createStatement();

		  String sql="select * from "+db+"."+table; 

		  ResultSet rs=stmt.executeQuery(sql);

		  ResultSetMetaData md=rs.getMetaData();

		  col = md.getColumnCount();

		  colcombo.removeAllItems();	
		
		  for(int i=1;i<=col;i++)
			{
			col_name = md.getColumnName(i);
			colcombo.addItem(col_name);
			} 
		 	
		  
		  }
		catch(Exception e)
		  {
		  String str=e.getMessage(); 			
		    JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE); 			
   		  }
		}
		}
	if(ie.getSource()==dtcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
		  {
		  datatype=(String)ie.getItem();	
		  repaint();	
		  }
		}
	if(ie.getSource()==colcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			colname1=(String)colcombo.getSelectedItem();
			repaint();
			}
		}
	}
public void actionPerformed(ActionEvent ae)
	{	
	String s=size.getText();
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnalt)
		{
		
			if(datatype.equals("DATE") || datatype.equals("TIME") || datatype.equals("DATETIME"))
			 {
			   try
			   {	
			   String q="alter table "+db+"."+table+" change "+colname1+" "+colname1+" "+datatype;
		
			   textarea_1.setText(q);	

			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url+db,"root","");

		           Statement stmt=con.createStatement();

			   stmt.executeUpdate(q);

			   String str=table+" Table Altered Successfully";

			   JOptionPane.showMessageDialog(null,str,"Alter Complete",JOptionPane.INFORMATION_MESSAGE); 		

		           size.setText("");
			   textarea_1.setText("");  	
			   repaint(); 
			   }	
			 catch(Exception e)
		  	   {
		  	   JOptionPane.showMessageDialog(null,"Duplicate Columns are not allowded","ERROR",JOptionPane.ERROR_MESSAGE); 					
			
		           size.setText("");
			   textarea_1.setText("");  
			   repaint();	
			   }	
		         }
		 	else
			  {	
			try
			  {
  			  String q="alter table "+db+"."+table+" change "+colname1+" "+colname1+" "+datatype+"("+s+")";

			  textarea_1.setText(q);	

			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url+db,"root","");

		          Statement stmt=con.createStatement();

			  stmt.executeUpdate(q);

			  String str=table+" Table Altered Successfully";

			  JOptionPane.showMessageDialog(null,str,"Alter Complete",JOptionPane.INFORMATION_MESSAGE); 		
			  
		          size.setText("");
			  textarea_1.setText("");  	
			  repaint();	
			  }	
			catch(Exception e)
		  	  {
		  	  JOptionPane.showMessageDialog(null,"Duplicate Columns are not allowded","ERROR",JOptionPane.ERROR_MESSAGE); 					
			  
		          size.setText("");
			  textarea_1.setText("");  	
			  repaint();
   		  	  }
			  }
			
		}
	}
    
}

class Change1Layout implements LayoutManager {

    public Change1Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 454 + insets.left + insets.right;
        dim.height = 319 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,176,16);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+8,184,16);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+32,160,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+32,152,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+80,128,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+120,136,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+120,128,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+216,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+216,344,32);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+272,112,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+272,120,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+160,72,16);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+160,48,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+80,136,24);}
    }
}
