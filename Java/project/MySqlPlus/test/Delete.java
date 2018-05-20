import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Delete extends JInternalFrame implements ItemListener,ActionListener
    {
    JLabel la;
    JLabel l1;
    JComboBox dbcombo;
    JComboBox tablecombo;
    JButton btndelete;
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
    Note1 n,n1;
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;

    public Delete() 
        {
	super("Delete A Row From Table");
	ImageIcon i2=new ImageIcon("images/b_tblexport.PNG");
	setFrameIcon(i2);
	setLocation(200,75);	
        DeleteLayout customLayout = new DeleteLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
	
        n=new Note1();
        n.setVisible(true);
	MysqlPlus.desktop.add(n);	

	n1=new Note1();
        n1.setVisible(true);
	MysqlPlus1.desktop.add(n1);		

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

        btndelete = new JButton("Delete",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
	btndelete.setFont(new Font("verdana", Font.BOLD, 12));
	btndelete.addActionListener(this);
        getContentPane().add(btndelete);

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
	txtcon.setToolTipText("Condition For Delete");
        getContentPane().add(txtcon);

        query = new JTextArea("");
	query.setFont(new Font("verdana", Font.BOLD, 12));
	query.setToolTipText("Final Query");	
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
		   Class.forName("com.mysql.jdbc.Driver");

		   String url="jdbc:mysql://localhost:3306/"+db;
			
                   con = DriverManager.getConnection(url,u,p);

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
		  String str=e.getMessage(); 			
                  JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);		
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
		n.setVisible(false);
		this.setVisible(false);
		n1.setVisible(false);

		}
	    if(ae.getSource()==btnclr)
		{
		data.setText("");
		txtcon.setText("");
		query.setText("");
		}
	    if(ae.getSource()==btnshow)
		{
		txtcon.setText("");
		Connection con = null;
		try 
    		   {
		   Class.forName("com.mysql.jdbc.Driver");

		   String url="jdbc:mysql://localhost:3306/"+db;

                   con = DriverManager.getConnection(url,u,p);

		   Statement st=con.createStatement();
		
		   String sql="select * from "+db+"."+table; 

		   ResultSet rs=st.executeQuery(sql);
		   
	           ResultSetMetaData md = rs.getMetaData();

		   col = md.getColumnCount();

		   String str[]=new String[50];
		   int k=0;
		   String r1="";
 
		   for (int j = 1; j <= col; j++)
                         {
			 String col_name = md.getColumnName(j);
			 r1=r1+col_name+"\t";
			 }
		   r1=r1+"\n";	
	 	   data.setFont(new Font("verdana", Font.BOLD, 14));
		   data.append("\n==========================================================\n");		 
		   data.setText(r1);	
		   data.append("============================================================\n");
		   String r="";	
		   while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=r + rs.getString(i)+"\t";
		       	  }  
			 r=r+"\n";
			 data.append(r);
			} 
   		   data.append("===========================================================================\n");		
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
	    
	if(ae.getSource()==btndelete)
		{
		if(txtcon.getText().equals(""))
			{
			JOptionPane.showMessageDialog(null,"Please enter Condition for Delete","Error",JOptionPane.ERROR_MESSAGE);
			}
		else
			{
			Connection con = null;
			try 
    		   	  {
		   	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection  conn=DriverManager.getConnection(url+db,"root","");

		   	  Statement st=con.createStatement();

			  String sql="delete from "+db+"."+table+" where "+colname+" "+txtcon.getText(); 

			  query.setText(sql);

			  st.executeUpdate(sql);

			  JOptionPane.showMessageDialog(null,"1 Row Deleted","Delete Success",JOptionPane.INFORMATION_MESSAGE);
			
			  txtcon.setText("");
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
	
		}
	}

class DeleteLayout implements LayoutManager {

    public DeleteLayout() {
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
