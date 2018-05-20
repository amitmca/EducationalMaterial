import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Views extends JInternalFrame implements ActionListener,ItemListener
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
	 
    public Views() 
	{
	super("Views");
	setLocation(350,100);
	ImageIcon i=new ImageIcon("images/bullet2.gif");
 	setFrameIcon(i);
        ViewsLayout customLayout = new ViewsLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        cbg = new ButtonGroup();
        create = new JRadioButton("Create View", true);
	create.setFont(new Font("verdana",Font.BOLD,12));	
	create.setBackground(c);
	create.addItemListener(this);
        cbg.add(create);
        getContentPane().add(create);

        drop = new JRadioButton("Drop View", false);
	drop.setFont(new Font("verdana",Font.BOLD,12));	
	drop.setBackground(c);
	drop.addItemListener(this);
        cbg.add(drop);
        getContentPane().add(drop);

        alter = new JRadioButton("Alter View", false);
	alter.setFont(new Font("verdana",Font.BOLD,12));	
	alter.setBackground(c);
	alter.addItemListener(this);
        cbg.add(alter);
        getContentPane().add(alter);

        exe = new JRadioButton("Execute View", false);
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
	CreateView cv=new CreateView();
	CreateView cv1=new CreateView();
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
		        cv.dbcombo.addItem(text);
			cv1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		cv.setVisible(true);
		MysqlPlus.desktop.add(cv);
		cv1.setVisible(true);
		MysqlPlus1.desktop.add(cv1);
	}

public static void MyDrop()
	{
	DropView dv=new DropView();
	DropView dv1=new DropView();
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
		        dv.dbcombo.addItem(text);
			dv1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		dv.setVisible(true);
		MysqlPlus.desktop.add(dv);
		dv1.setVisible(true);
		MysqlPlus1.desktop.add(dv1);
	}

public static void MyExecute()
	{
	ExecuteView ev=new ExecuteView();
	ExecuteView ev1=new ExecuteView();

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
		        ev.dbcombo.addItem(text);
			ev1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		ev.setVisible(true);
		MysqlPlus.desktop.add(ev);
		ev1.setVisible(true);
		MysqlPlus1.desktop.add(ev1);
	}


public static void MyAlter()
	{
	AlterView av=new AlterView();
	AlterView av1=new AlterView();	
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
		        av.dbcombo.addItem(text);
			av1.dbcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		av.setVisible(true);
		MysqlPlus.desktop.add(av);
		av1.setVisible(true);
		MysqlPlus1.desktop.add(av1);
	}

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
		else if(type.equals("Alter"))
			{
			this.setVisible(false);
			MyAlter();
			}
		else if(type.equals("Execute"))
			{
			this.setVisible(false);
			MyExecute();
			}
		}
	}
}
   



class ViewsLayout implements LayoutManager {

    public ViewsLayout() {
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
