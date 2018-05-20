import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Insert extends JInternalFrame implements ItemListener,ActionListener
  {
    JLabel la;
    JLabel l1,l2;
    JComboBox dbcombo;
    JComboBox tablecombo;
    JButton btnins;
    JButton btnclr;
    JButton btncel;
    JButton btnexit;
    ImageIcon i=new ImageIcon("images/s_error.png");
    public static String db="";		
    public static String tables="",table="",sorttype="",type="",type1="";
    public static JTextField t[];
    public static JLabel l[];
    public static String col_name="";
    public static int col=0;    
    public static Login lr;
    public static String u=lr.u;
    public static String p=lr.pass;

    public Insert() 
        {
        super("Insert Data Into Table");
	ImageIcon i2=new ImageIcon("images/insert.PNG");
	setFrameIcon(i2);
	setLocation(200,30);
        InsertLayout customLayout = new InsertLayout();

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
        getContentPane().add(tablecombo);

        btnins = new JButton("Insert",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
	btnins.setFont(new Font("verdana", Font.BOLD, 12));
	btnins.addActionListener(this);
        getContentPane().add(btnins);

        btnclr = new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("images\\def.PNG")));
	btnclr.setFont(new Font("verdana", Font.BOLD, 12));
	btnclr.addActionListener(this);
        getContentPane().add(btnclr);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana", Font.BOLD, 12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

	l2=new JLabel(new ImageIcon("images/arrow2.gif"));	
	Color c=new Color(220,231,170);
	getContentPane().setBackground(c);
        
    }
public void itemStateChanged(ItemEvent ie)
	{
	for(int m=0;m<col;m++)
		{
		getContentPane().remove(t[m]);
		getContentPane().remove(l[m]);
		}
	if(ie.getSource()==dbcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
		db=(String)ie.getItem();
		
		Connection con = null;
		try 
    		   {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql"+db;
				
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
				
					String url="jdbc:odbc:mysql"+db;
				
					Connection con=DriverManager.getConnection(url,"root","");
		  Statement stmt=con.createStatement();

		  String sql="select * from "+table;

		  ResultSet rs=stmt.executeQuery(sql);

	          ResultSetMetaData md = rs.getMetaData();

		  col = md.getColumnCount();

		  int x1=100,y1=100; 

		  l=new JLabel[col];

		  String str[]=new String[50];
		  int k=0;
		
		  for (int j = 1; j <= col; j++)
                         {
			 String col_name = md.getColumnName(j);
			 str[k++]=col_name;	
			 }
		 String temp="";	
   		 l2.setBounds(225,65,50,50);
 	         getContentPane().add(l2);

   		 for(int i=0;i<col;i++)
  			 {
			 temp=str[i];
			 l[i]=new JLabel(temp,new ImageIcon("images/blink.gif"),JLabel.LEFT);
			 l[i].setBounds(x1,y1,300,70);
			 l[i].setFont(new Font("verdana",Font.BOLD,10));	
			 l[i].setForeground(Color.blue);
			 getContentPane().add(l[i]);
			 repaint();
			 y1=y1+35;
			 }

		  int x=175,y=125; 

		  t=new JTextField[col];
		  
		  for(int i=0;i<col;i++)
			{
			t[i]=new JTextField();
			t[i].setBounds(x,y,200,25);
			t[i].setFont(new Font("verdana",Font.BOLD,12));	
			t[i].setHorizontalAlignment(JTextField.CENTER);
			t[i].setForeground(Color.blue);
			Color c=new Color(220,196,170);
			t[i].setBackground(c);
			getContentPane().add(t[i]);
			repaint();
			y=y+35;
			}
		  }
		catch(Exception e)
		  {
		  String str2=e.getMessage();
		  JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 				
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
		for(int i1=0;i1<col;i1++)
		   {
		   t[i1].setText("");
		   }
		}
	if(ae.getSource()==btnins)
		{
		
		String query="insert into "+db+"."+table+" values(";
		String f1="'";
		String f2="'";
			
  		String sql[]=new String[col];
		String sql1[]=new String[col];

		String final1="";
		int k=0;
		for(int j=0;j<col;j++)
			{
			sql[j]=t[j].getText().trim();
			sql1[k]=f1+sql[j]+f2+",";
			k++;
			}
		for(int c=0;c<k;c++)
			{
			final1=final1+sql1[c];
			}			
		
		StringBuffer q=new StringBuffer(final1);
		int len=q.length();
		q.delete(len-1,len);	
		query=query+q+")";
		
		
			
		try
  		     {
		    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql"+db;
				
					Connection con=DriverManager.getConnection(url,"root","");
		     Statement stmt=con.createStatement();

 		     stmt.executeUpdate(query);
		
		     JOptionPane.showMessageDialog(null,"1 Row Inserted","Inserted",JOptionPane.INFORMATION_MESSAGE);	
		     }
		catch(Exception e)
		     {
		     String str=e.getMessage();
		     JOptionPane.showMessageDialog(null,str,"ERROR",JOptionPane.ERROR_MESSAGE);				
   		     }
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
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+48,160,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+48,160,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+504,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+504,120,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+504,112,24);}
    }
}
