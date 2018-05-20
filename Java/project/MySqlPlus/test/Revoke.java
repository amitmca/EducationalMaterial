import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Revoke extends JInternalFrame implements ActionListener,ItemListener
   {
    ButtonGroup cbg;
    JRadioButton radglo;
    JRadioButton raddb;
    JRadioButton radtb;
    JRadioButton radcol;
    JButton btncon;
    JButton btncel;
    Color c=new Color(238,249,255);
    public static String type="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;

    public Revoke()
        {
	super("Revoke");
	setLocation(350,100);
	ImageIcon i=new ImageIcon("images/checkmark_orange.gif");
 	setFrameIcon(i);
        RevokeLayout customLayout = new RevokeLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        cbg = new ButtonGroup();
        radglo = new JRadioButton("Global Level", false);
	radglo.setFont(new Font("verdana",Font.BOLD,12));	
	radglo.setBackground(c);
	radglo.addItemListener(this);
        cbg.add(radglo);
        getContentPane().add(radglo);

        raddb = new JRadioButton("Database Level", false);
	raddb.setFont(new Font("verdana",Font.BOLD,12));	
	raddb.setBackground(c);
	raddb.addItemListener(this);
        cbg.add(raddb);
        getContentPane().add(raddb);

        radtb = new JRadioButton("Table Level", false);
	radtb.setFont(new Font("verdana",Font.BOLD,12));	
	radtb.setBackground(c);
	radtb.addItemListener(this);
        cbg.add(radtb);
        getContentPane().add(radtb);

        radcol = new JRadioButton("Column Level", false);
	radcol.setFont(new Font("verdana",Font.BOLD,12));	
	radcol.setBackground(c);
	radcol.addItemListener(this);
        cbg.add(radcol);
        getContentPane().add(radcol);

        btncon = new JButton("Continue",new ImageIcon(ClassLoader.getSystemResource("images\\homesearch.PNG")));
	btncon.setFont(new Font("verdana",Font.BOLD,12));	
	Color c1=new Color(140,196,170);	
	btncon.setBackground(c1);
	btncon.addActionListener(this);
        getContentPane().add(btncon);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.png")));
	btncel.setFont(new Font("verdana",Font.BOLD,12));	
	btncel.setBackground(c1);
	btncel.addActionListener(this);
        getContentPane().add(btncel);

	getContentPane().setBackground(c);
        setSize(getPreferredSize());

    }
public void Global()
	{
	GlobalPriv1 gp=new GlobalPriv1();	
	try
	     {
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			
	     Statement st=conn.createStatement();
	
	     String sql="select user from mysql.user";

	     st.executeQuery(sql);

	     ResultSet rs=st.executeQuery(sql);

	     String text=" ";

             while(rs.next())
	        {
	        text=rs.getString(1);
	        gp.usrcombo.addItem(text);
	        }
	     }
	 catch(Exception e)
	     {
	     String str2=e.getMessage();
	     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
	     }	
	gp.setVisible(true);
	MysqlPlus.desktop.add(gp);
	}

public void Database()
	{
	DatabasePriv1 dp=new DatabasePriv1();	
	try
	     {
	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			
	     Statement st=conn.createStatement();
		
	     Statement st1=conn.createStatement();	
	
	     String sql="select user from mysql.user";

	     String sql1="show databases";	

	     ResultSet rs=st.executeQuery(sql);
	     ResultSet rs1=st1.executeQuery(sql1);		
		
	     String text=" ";

             while(rs.next())
	        {
	        text=rs.getString(1);
	        dp.usrcombo.addItem(text);
	        }
	     
	     String text1=" ";

             while(rs1.next())
	        {
	        text1=rs1.getString(1);
	        dp.dbcombo.addItem(text1);
	        }	
	     }
	 catch(Exception e)
	     {
	     String str2=e.getMessage();
	     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
	     }	
	dp.setVisible(true);
	MysqlPlus.desktop.add(dp);
	}

public void Table()
	{
	TablePriv1 tp=new TablePriv1();	
	try
	     {
	     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			
	     Statement st=conn.createStatement();
		
	     Statement st1=conn.createStatement();	

	     Statement st2=conn.createStatement();		
	
	     String sql="select user from mysql.user";

	     String sql1="show databases";	

	 
	     ResultSet rs=st.executeQuery(sql);
	     ResultSet rs1=st1.executeQuery(sql1);		
	     		
		
	     String text=" ";

             while(rs.next())
	        {
	        text=rs.getString(1);
	        tp.usrcombo.addItem(text);
	        }
	     
	     String text1=" ";

             while(rs1.next())
	        {
	        text1=rs1.getString(1);
	        tp.dbcombo.addItem(text1);
	        }
		
	     }
	 catch(Exception e)
	     {
	     String str2=e.getMessage();
	     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
	     }	
	tp.setVisible(true);
	MysqlPlus.desktop.add(tp);
	}

public void Column()
	{
	ColumnPriv cp=new ColumnPriv();	
	try
	     {
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			
	     Statement st=conn.createStatement();
		
	     Statement st1=conn.createStatement();	

	     Statement st2=conn.createStatement();		
	
	     String sql="select user from mysql.user";

	     String sql1="show databases";	

	 
	     ResultSet rs=st.executeQuery(sql);
	     ResultSet rs1=st1.executeQuery(sql1);		
	     		
		
	     String text=" ";

             while(rs.next())
	        {
	        text=rs.getString(1);
	        cp.usrcombo.addItem(text);
	        }
	     
	     String text1=" ";

             while(rs1.next())
	        {
	        text1=rs1.getString(1);
	        cp.dbcombo.addItem(text1);
	        }
		
	     }
	 catch(Exception e)
	     {
	     String str2=e.getMessage();
	     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
	     }	
	cp.setVisible(true);
	MysqlPlus.desktop.add(cp);
	}


public void itemStateChanged(ItemEvent ie)
	{
	if(ie.getItemSelectable()==radglo)
		{
		type="Global";
		}
	else if(ie.getItemSelectable()==raddb)
		{
		type="Database";
		}
	else if(ie.getItemSelectable()==radtb)
		{
		type="Table";
		}
	else if(ie.getItemSelectable()==radcol)
		{
		type="Column";
		}
	}
public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btncel)	
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btncon)
		{
		if(type.equals("Global"))
			{
			this.setVisible(false);
			Global();
			}
		else if(type.equals("Database"))
			{
			this.setVisible(false);
			Database();
			}			
		else if(type.equals("Table"))
			{
			this.setVisible(false);
			Table();
			}
		else if(type.equals("Column"))
			{
			this.setVisible(false);
			Column();
			}
		}
	}
}

class RevokeLayout implements LayoutManager {

    public RevokeLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 256 + insets.left + insets.right;
        dim.height = 247 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+32,192,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+72,192,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+112,192,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+152,192,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+6,insets.top+200,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+140,insets.top+200,112,24);}
    }
}
