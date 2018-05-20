import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AlterTable extends JInternalFrame implements ActionListener,ItemListener
 {
    ButtonGroup cbg;
    JRadioButton radd;
    JRadioButton rdrop;
    JRadioButton rchange;
    JRadioButton rchange1;
    JButton btnpro;
    JButton btncel;
    Color c=new Color(220,231,170);	
    public static String type="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;

    public AlterTable() 
	{
	super("Alter Table");
	setLocation(350,100);
	ImageIcon i=new ImageIcon("images/edit.PNG");
 	setFrameIcon(i);
        AlterTableLayout customLayout = new AlterTableLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        cbg = new ButtonGroup();
        radd = new JRadioButton("Add a New Column", false);
	radd.setFont(new Font("verdana",Font.BOLD,12));	
	radd.setBackground(c);
	radd.addItemListener(this);
        cbg.add(radd);
        getContentPane().add(radd);

        rdrop = new JRadioButton("Drop a Column", false);
	rdrop.setFont(new Font("verdana",Font.BOLD,12));	
	rdrop.setBackground(c);
	rdrop.addItemListener(this);
        cbg.add(rdrop);
        getContentPane().add(rdrop);

        rchange = new JRadioButton("Change Column Name", false);
	rchange.setFont(new Font("verdana",Font.BOLD,12));	
	rchange.setBackground(c);
	rchange.addItemListener(this);
        cbg.add(rchange);
        getContentPane().add(rchange);

        rchange1 = new JRadioButton("Change Column Type", false);
	rchange1.setFont(new Font("verdana",Font.BOLD,12));	
	rchange1.setBackground(c);
	rchange1.addItemListener(this);
        cbg.add(rchange1);
        getContentPane().add(rchange1);

        btnpro = new JButton("Proceed",new ImageIcon(ClassLoader.getSystemResource("images\\blink.gif")));
	btnpro.setFont(new Font("verdana",Font.BOLD,12));	
	Color c1=new Color(140,196,170);	
	btnpro.setBackground(c1);
	btnpro.addActionListener(this);
        getContentPane().add(btnpro);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.png")));
	btncel.setFont(new Font("verdana",Font.BOLD,12));	
	btncel.setBackground(c1);
	btncel.addActionListener(this);
        getContentPane().add(btncel);

	getContentPane().setBackground(c);
        setSize(getPreferredSize());
	
     }

public static void MyAdd()
	{
	AddColumn ac=new AddColumn();
	AddColumn ac1=new AddColumn();
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
		        ac.dbcombo.addItem(text);
			ac1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		ac.setVisible(true);
		ac1.setVisible(true);
		MysqlPlus.desktop.add(ac);
		MysqlPlus1.desktop.add(ac1);
	}

public static void MyDrop()
	{
	DropColumn dc=new DropColumn();
	DropColumn dc1=new DropColumn();
	
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
		        dc.dbcombo.addItem(text);
			dc1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		dc.setVisible(true);
		dc1.setVisible(true);
		MysqlPlus.desktop.add(dc);
		MysqlPlus1.desktop.add(dc1);
	}

public static void MyChange()
	{
	Change c=new Change();
	Change c1=new Change();
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
		        c.dbcombo.addItem(text);
			c1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		c.setVisible(true);
		c1.setVisible(true);
		MysqlPlus.desktop.add(c);
		MysqlPlus1.desktop.add(c1);
	}

public static void MyChange1()
	{
	Change1 c1=new Change1();
	Change1 c2=new Change1();
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
		        c1.dbcombo.addItem(text);
			c2.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		c1.setVisible(true);
		c2.setVisible(true);
		MysqlPlus.desktop.add(c1);
		MysqlPlus1.desktop.add(c2);
	}

public void itemStateChanged(ItemEvent ie)
	{
	if(ie.getItemSelectable()==radd)
		{
		type="Add";
		}
	else if(ie.getItemSelectable()==rdrop)
		{
		type="Drop";
		}
	else if(ie.getItemSelectable()==rchange)
		{
		type="Change";
		}
	else if(ie.getItemSelectable()==rchange1)
		{
		type="Change1";
		}
	}
public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btncel)	
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnpro)
		{
		if(type.equals("Add"))
			{
			this.setVisible(false);
			MyAdd();
			}
		else if(type.equals("Drop"))
			{
			this.setVisible(false);
			MyDrop();
			}			
		else if(type.equals("Change"))
			{
			this.setVisible(false);
			MyChange();
			}
		else if(type.equals("Change1"))
			{
			this.setVisible(false);
			MyChange1();
			}
		}
	}
}

class AlterTableLayout implements LayoutManager {

    public AlterTableLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 270 + insets.left + insets.right;
        dim.height = 231 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+16,224,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+56,224,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+96,224,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+136,224,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+192,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+192,104,24);}
    }
}
