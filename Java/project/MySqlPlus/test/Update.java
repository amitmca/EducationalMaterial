import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Update extends JInternalFrame implements ItemListener,ActionListener
    {
    JLabel la;
    JLabel l1;
    JComboBox dbcombo;
    JComboBox tablecombo;
    JButton btnupdate;
    JButton btnclr;
    JButton btncel;
    JPanel panel;
    JLabel label_1;
    JComboBox colcombo;
    JTextField txtcon;
    JTextArea query;
    JScrollPane sp_query;
    public static String db="";		
    public static String tables="",table="",sorttype="",type="",type1="";
    public static JTextField t[];
    public static String col_name="",colname="";
    public static int col=0; 
    JButton btnshow;
    JTextArea data;
    JScrollPane sp_data;

    public Update() 
        {
	super("Update Table");
	ImageIcon i2=new ImageIcon("images/database_sql_editor.PNG");
	setFrameIcon(i2);
	setLocation(200,30);	
        UpdateLayout customLayout = new UpdateLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        la = new JLabel("Select Database Name :");
	la.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(la);

        l1 = new JLabel("Select Table Name :");
	l1.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(l1);
        
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
	tablecombo.addActionListener(this);
        getContentPane().add(tablecombo);

        btnupdate = new JButton("Update",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
	btnupdate.setFont(new Font("verdana", Font.BOLD, 12));
	btnupdate.addActionListener(this);
        getContentPane().add(btnupdate);

        btnclr = new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("images\\def.PNG")));
	btnclr.setFont(new Font("verdana", Font.BOLD, 12));
	btnclr.addActionListener(this);
        getContentPane().add(btnclr);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana", Font.BOLD, 12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

        panel=new JPanel();
	panel.setFont(new Font("verdana", Font.BOLD, 12));
	Color c1=new Color(220,249,255);
	panel.setBackground(c1);
        getContentPane().add(panel);	
		
	Color c=new Color(220,231,170);
	getContentPane().setBackground(c);

        label_1 = new JLabel("Where :");
	label_1.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(label_1);

        colcombo = new JComboBox();
	colcombo.setBackground(Color.white);
	colcombo.setForeground(Color.red);
	colcombo.setFont(new Font("verdana", Font.BOLD, 12));	
	colcombo.addItemListener(this);
        getContentPane().add(colcombo);

        txtcon = new JTextField("");
	txtcon.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(txtcon);

        query = new JTextArea("");
	query.setFont(new Font("verdana", Font.BOLD, 12));	
        sp_query = new JScrollPane(query);
        getContentPane().add(sp_query);

	btnshow = new JButton("Show Data",new ImageIcon(ClassLoader.getSystemResource("images\\grt_value_struct.PNG")));
	btnshow.setForeground(Color.blue);
	btnshow.setFont(new Font("verdana", Font.BOLD, 12));
	btnshow.addActionListener(this);
        getContentPane().add(btnshow);
          
        data = new JTextArea("");
	data.setFont(new Font("verdana", Font.BOLD, 12));
	//Color c2=new Color(220,231,170);
	data.setBackground(Color.yellow);
	data.setEditable(false);
	data.setForeground(Color.red);
        sp_data = new JScrollPane(data);
        getContentPane().add(sp_data);

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
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
				 con=DriverManager.getConnection(url,"root","");

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
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url+db,"root","");

		  Statement stmt=con.createStatement();

		  String sql="select * from "+table;

		  ResultSet rs=stmt.executeQuery(sql);
		  
		  

	          ResultSetMetaData md = rs.getMetaData();

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
		  System.out.println(e.getMessage()); 			
   		  }
		}
		}
	if(ie.getSource()==colcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			colname=(String)colcombo.getSelectedItem();
			repaint();
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
		data.setText("");
		txtcon.setText("");
		}
	    if(ae.getSource()==btnshow)
		{
		Connection con = null;
		try 
    		   {
		 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					con=DriverManager.getConnection(url+db,"root","");

		   Statement st=con.createStatement();
		
		   String sql="select * from "+db+"."+table; 

		   ResultSet rs=st.executeQuery(sql);
		   
	           ResultSetMetaData md = rs.getMetaData();

		   col = md.getColumnCount();

		   String r="";	
		 
		   while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=r + rs.getString(i)+"\t";
		       	  }  
			 r=r+"\n";
			
			 data.setText(r);
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
	
		
	}

class UpdateLayout implements LayoutManager {

    public UpdateLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 522 + insets.left + insets.right;
        dim.height = 490 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+8,160,16);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+8,160,16);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+32,160,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+32,160,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+448,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+448,120,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+448,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+96,512,224);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+336,96,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+336,128,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+336,152,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+368,440,64);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+64,136,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+96,512,224);}
    }
}
