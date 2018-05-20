import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DropColumn extends JInternalFrame implements ItemListener,ActionListener
{
    JLabel l1;
    JLabel l2;
    JComboBox dbcombo;
    JComboBox tablecombo;
    JLabel l3;
    JLabel l5;
    JTextArea textarea_1;
    JScrollPane sp_textarea_1;
    JButton btnalt;
    JButton btncel;
    JComboBox colcombo;
    public static String db="",tables="",table="",colname="",col_name=""; 	
    public static int col=0;	
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;

    public DropColumn()
	{
	super("Drop a Column");
	setLocation(275,120);
	ImageIcon i=new ImageIcon("images/deleterow.PNG");
 	setFrameIcon(i);
        DropColumnLayout customLayout = new DropColumnLayout();

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

        l3 = new JLabel("Columns");
	l3.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l3);
	
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

        colcombo = new JComboBox();
	colcombo.setFont(new Font("verdana",Font.BOLD,12));
	colcombo.addItemListener(this);
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
	if(ae.getSource()==btnalt)
		{
		try
		  {
  		  String q="alter table "+db+"."+table+" drop column "+colname;
			
		  textarea_1.setText(q);	

		  Class.forName("com.mysql.jdbc.Driver");

  	  	  String url="jdbc:mysql://localhost:3306/";

                   Connection con = DriverManager.getConnection(url+db,u,p);

	          Statement stmt=con.createStatement();

		  stmt.executeUpdate(q);

		  String str=table+" Table Altered Successfully";

		  JOptionPane.showMessageDialog(null,str,"Alter Complete",JOptionPane.INFORMATION_MESSAGE); 		
			  
		  textarea_1.setText("");  	
		  repaint();	
		  }	
		catch(Exception e)
		 {
		 JOptionPane.showMessageDialog(null,"Please check the query","ERROR",JOptionPane.ERROR_MESSAGE); 					
		 textarea_1.setText("");  	
		 repaint();
   		 }
		}
	}

}

class DropColumnLayout implements LayoutManager {

    public DropColumnLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 454 + insets.left + insets.right;
        dim.height = 223 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+80,88,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+128,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+128,344,32);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+184,112,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+184,120,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+80,136,24);}
    }
}
