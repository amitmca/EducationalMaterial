import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Triggers extends JInternalFrame implements ActionListener,ItemListener
 {
    ButtonGroup cbg;
    JRadioButton create;
    JRadioButton drop;
    JRadioButton alter;
    JRadioButton exe;
    JButton btnpro;
    JButton btncel;
    JLabel label_3;
    Color c=new Color(220,249,255);
    public static String type="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;
	
    public Triggers() 
	{
	super("Triggers");
	setLocation(350,100);
	ImageIcon i=new ImageIcon("images/bullet3.gif");
 	setFrameIcon(i);
        TriggersLayout customLayout = new TriggersLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        cbg = new ButtonGroup();
        create = new JRadioButton("Create Trigger", true);
	create.setFont(new Font("verdana",Font.BOLD,12));	
	create.setBackground(c);
	create.addItemListener(this);
        cbg.add(create);
        getContentPane().add(create);

        drop = new JRadioButton("Drop Trigger", false);
	drop.setFont(new Font("verdana",Font.BOLD,12));	
	drop.setBackground(c);
	drop.addItemListener(this);
        cbg.add(drop);
        getContentPane().add(drop);

        alter = new JRadioButton("Alter Trigger", false);
	alter.setFont(new Font("verdana",Font.BOLD,12));	
	alter.setBackground(c);
	alter.addItemListener(this);
        cbg.add(alter);
        getContentPane().add(alter);

        exe = new JRadioButton("Execute Trigger", false);
	exe.setFont(new Font("verdana",Font.BOLD,12));	
	exe.setBackground(c);
	exe.addItemListener(this);
        cbg.add(exe);
        getContentPane().add(exe);

        btnpro = new JButton("Continue",new ImageIcon(ClassLoader.getSystemResource("images\\anihand.gif")));
	btnpro.setForeground(Color.red);
	btnpro.setFont(new Font("verdana",Font.BOLD,12));
	btnpro.addActionListener(this);
        getContentPane().add(btnpro);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.png")));
	btncel.setForeground(Color.red);
	btncel.addActionListener(this);
        getContentPane().add(btncel);

        label_3 = new JLabel("Select Your Choice");
	label_3.setFont(new Font("verdana",Font.BOLD,15));
	
        getContentPane().add(label_3);
	
      	getContentPane().setBackground(c);
	setSize(getPreferredSize());
     }

public static void MyCreate()
	{
	CreateTrigger ct=new CreateTrigger();
	CreateTrigger ct1=new CreateTrigger();
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
		        ct.dbcombo.addItem(text);
			ct1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		ct.setVisible(true);
		ct1.setVisible(true);
		MysqlPlus.desktop.add(ct);
		MysqlPlus1.desktop.add(ct1);
	}

public static void MyDrop()
	{
	DropTrigger dt=new DropTrigger();
	DropTrigger dt1=new DropTrigger();
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
			dt1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		dt.setVisible(true);
		MysqlPlus.desktop.add(dt);
		dt1.setVisible(true);
		MysqlPlus.desktop.add(dt1);
	}

/*public static void MyExecute()
	{
	ExecuteTrigger et=new ExecuteTrigger();
	
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
		        et.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		et.setVisible(true);
		
		MysqlPlus.desktop.add(et);
	}


public static void MyAlter()
	{
	AlterTrigger at=new AlterTrigger();
	
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
		        at.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		at.setVisible(true);
		
		MysqlPlus.desktop.add(at);
	}
*/
public void itemStateChanged(ItemEvent ie)
	{
	if(ie.getItemSelectable()==create)
		{
		type="Create";
		}
	else if(ie.getItemSelectable()==drop)
		{
		type="Drop";
		}
	else if(ie.getItemSelectable()==alter)
		{
		type="Alter";
		}
	else if(ie.getItemSelectable()==exe)
		{
		type="Execute";
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
		if(type.equals("Create"))
			{
			this.setVisible(false);
			MyCreate();
			}
		else if(type.equals("Drop"))
			{
			this.setVisible(false);
			MyDrop();
			}			
		/*else if(type.equals("Alter"))
			{
			this.setVisible(false);
			MyAlter();
			}
		else if(type.equals("Execute"))
			{
			this.setVisible(false);
			MyExecute();
			}*/
		}
	}
}
   



class TriggersLayout implements LayoutManager {

    public TriggersLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 280 + insets.left + insets.right;
        dim.height = 240 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+40,200,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+80,200,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+120,200,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+160,200,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+200,144,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+200,104,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+8,208,24);}
    }
}
