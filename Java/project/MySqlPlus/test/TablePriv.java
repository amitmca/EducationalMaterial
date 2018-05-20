import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TablePriv extends JInternalFrame implements ActionListener,ItemListener
 {
    JLabel label_1;
    JLabel label_2;
    JComboBox usrcombo;
    JLabel label_3;
    JLabel label_4;
    JComboBox dbcombo;
    JLabel lpriv;
    JCheckBox cselect;
    JCheckBox cinsert;
    JCheckBox cdelete;
    JCheckBox cupdate;
    JCheckBox cdrop;
    JCheckBox ccreate;
    JCheckBox cwith;
    JLabel label_7;
    JTextArea prev;
    JScrollPane sp_priv;
    JButton btngrant;
    JButton btncel;
    JLabel label_5;
    JLabel label_6;
    JComboBox tablecombo;	
    public static String db="",usr="",table="",with="",select="",insert="",update="",delete="",drop="",create="";	
    public static Login lr;
    public static String u=lr.u;
    public static String p=lr.pass;
    Color c=new Color(238,249,255);
    public static int se=0,in=0,up=0,de=0,dr=0,cr=0;	

    public TablePriv() 
	{
	super("Grant Table Level Privileges");
	setLocation(350,75);
	ImageIcon i=new ImageIcon("images/table.png");
 	setFrameIcon(i);
        TablePrivLayout customLayout = new TablePrivLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ImageIcon i2=new ImageIcon("images/login.gif");  
        label_1 = new JLabel(i2);
	getContentPane().add(label_1);

        label_2 = new JLabel("Select User Name :");
	label_2.setFont(new Font("verdana",Font.BOLD,12));	
	label_2.setForeground(Color.red);
        getContentPane().add(label_2);

        usrcombo = new JComboBox();
	usrcombo.setBackground(Color.white);
	usrcombo.setForeground(Color.red);
	usrcombo.setFont(new Font("verdana", Font.BOLD, 12));	
	usrcombo.addItemListener(this);
        getContentPane().add(usrcombo);

        ImageIcon i1=new ImageIcon("images/database.PNG");  
        label_3 = new JLabel(i1);
        getContentPane().add(label_3);

        label_4 = new JLabel("Select Database Name :");
	label_4.setFont(new Font("verdana",Font.BOLD,12));	
	label_4.setForeground(Color.red);
        getContentPane().add(label_4);

        dbcombo = new JComboBox();
	dbcombo.setBackground(Color.white);
	dbcombo.setForeground(Color.red);
	dbcombo.setFont(new Font("verdana", Font.BOLD, 12));	
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        lpriv = new JLabel("Privileges :");
	lpriv.setFont(new Font("verdana",Font.BOLD,12));	
	lpriv.setForeground(Color.red);
        getContentPane().add(lpriv);

        cselect = new JCheckBox("Select");
	cselect.setBackground(c);
	cselect.setForeground(Color.red);
	cselect.setFont(new Font("verdana", Font.BOLD, 12));	
	cselect.addItemListener(this);
        getContentPane().add(cselect);

        cinsert = new JCheckBox("Insert");
	cinsert.setBackground(c);
	cinsert.setForeground(Color.red);
	cinsert.setFont(new Font("verdana", Font.BOLD, 12));	
	cinsert.addItemListener(this);
        getContentPane().add(cinsert);

        cdelete = new JCheckBox("Delete");
	cdelete.setBackground(c);
	cdelete.setForeground(Color.red);
	cdelete.setFont(new Font("verdana", Font.BOLD, 12));	
	cdelete.addItemListener(this);
        getContentPane().add(cdelete);

        cupdate = new JCheckBox("Update");
	cupdate.setBackground(c);
	cupdate.setForeground(Color.red);
	cupdate.setFont(new Font("verdana", Font.BOLD, 12));	
	cupdate.addItemListener(this);
        getContentPane().add(cupdate);

        cdrop = new JCheckBox("Drop");
	cdrop.setBackground(c);
	cdrop.setForeground(Color.red);
	cdrop.setFont(new Font("verdana", Font.BOLD, 12));	
	cdrop.addItemListener(this);
        getContentPane().add(cdrop);

        ccreate = new JCheckBox("Create");
	ccreate.setBackground(c);
	ccreate.setForeground(Color.red);
	ccreate.setFont(new Font("verdana", Font.BOLD, 12));	
	ccreate.addItemListener(this);
        getContentPane().add(ccreate);

        cwith = new JCheckBox("With Grant Option");
	cwith.setBackground(c);
	cwith.setForeground(Color.red);
	cwith.setFont(new Font("verdana", Font.BOLD, 10));	
	cwith.addItemListener(this);
        getContentPane().add(cwith);

        label_7 = new JLabel("Privilege Statement :");
	label_7.setFont(new Font("verdana",Font.BOLD,10));	
	label_7.setForeground(Color.red);
        getContentPane().add(label_7);

        prev = new JTextArea("");
        sp_priv = new JScrollPane(prev);
	prev .setForeground(Color.red);
	prev .setFont(new Font("verdana", Font.BOLD, 12));
	prev.setEditable(false);
        getContentPane().add(sp_priv);

        btngrant = new JButton("Grant",new ImageIcon(ClassLoader.getSystemResource("images\\submitS.png")));
	btngrant.addActionListener(this);
	btngrant.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btngrant);
	
        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.png")));
	btncel.addActionListener(this);
	btncel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btncel);

	ImageIcon i3=new ImageIcon("images/table.png");  
        label_5 = new JLabel(i3);
        getContentPane().add(label_5);

        label_6 = new JLabel("Select Table Name :");
	label_6.setFont(new Font("verdana",Font.BOLD,12));	
	label_6.setForeground(Color.red);
        getContentPane().add(label_6);

        tablecombo = new JComboBox();
	tablecombo.setBackground(Color.white);
	tablecombo.setForeground(Color.red);
	tablecombo.setFont(new Font("verdana", Font.BOLD, 12));	
	tablecombo.addItemListener(this);
        getContentPane().add(tablecombo);
	
	getContentPane().setBackground(c);
        setSize(getPreferredSize());
   
    }
public void itemStateChanged(ItemEvent ie)
	{
	if(ie.getSource()==usrcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			usr=(String)ie.getItem();
			}
		}

	if(ie.getSource()==dbcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			db=(String)ie.getItem();
			try 
    		  	 {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url+db,"root","");

			 DatabaseMetaData meta = con.getMetaData();
			
			 String tables="";

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
  	 	         String str2=e.getMessage();
	                 JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		         }
 		         catch (SQLException e) 
     		         {
		         String str2=e.getMessage();
		         JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		         }	
			}
		}
	if(ie.getSource()==tablecombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			table=(String)ie.getItem();
			
			}
		}

	if(ie.getSource()==cwith)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			with="with grant option";
			}
		else
			{
			with="";
			}
		}

	if(ie.getSource()==cselect)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			select="select";
			se++;	
			}
		else
			{
			select="";
			se=0;
			}
		}

	if(ie.getSource()==cinsert)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			insert="insert";
			in++;
			}
		else
			{
			insert="";
			in=0;
			}
		}

	if(ie.getSource()==cdelete)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			delete="delete";
			de++;
			}
		else
			{
			delete="";
			de=0;	
			}
		}
	if(ie.getSource()==cupdate)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			update="update";
			up++;
			}
		else
			{
			update="";
			up=0;
			}
		}

	if(ie.getSource()==cdrop)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			drop="drop";
			dr++;
			}
		else
			{
			drop="";	
			dr=0;
			}
		}

	if(ie.getSource()==ccreate)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			create="create";
			cr++;
			}
		else
			{
			create="";
			cr=0;
			}
		}
	}

public void actionPerformed (ActionEvent ae) 
     {	
     String p1="";
	if(se==1) 
		{
		p1=p1+"select";
		}
	if(in==1)
		{
		p1=p1+",insert";
		}
	if(de==1)
		{
		p1=p1+",delete";
		}
	if(up==1)
		{
		p1=p1+",update";
		}
	if(dr==1)
		{
		p1=p1+",drop";
		}	
	if(cr==1)
		{
		p1=p1+",create";
		}
	if(se==1 && in==1 && de==1 && up==1 && dr==1 && cr==1)
		{
		p1="select,insert,delete,update,drop,create";
		}
	     
     if(ae.getSource()==btncel)
	{
	this.setVisible(false);		
	}
     if(ae.getSource()==btngrant)
	{
	try
	   {
	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			
	   Statement st=conn.createStatement();

	   String sql="grant "+p1+" on "+db+"."+table+" to "+usr+"@localhost "+with;

	   prev.setText(sql);	

	   st.executeUpdate(sql);

	   String str="Granted";

	   JOptionPane.showMessageDialog(null,str,"Grant",JOptionPane.INFORMATION_MESSAGE); 				

	   prev.setText("");

	   usrcombo.removeAllItems();		
	   dbcombo.removeAllItems();
	   }
	catch(Exception e)
	   {
	   String str2=e.getMessage();
	   JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
	   }
	}
	se=0;in=0;up=0;de=0;dr=0;cr=0;
	}		
   
}

class TablePrivLayout implements LayoutManager {

    public TablePrivLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 392 + insets.left + insets.right;
        dim.height = 489 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+16,32,32);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+24,152,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+24,144,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+72,32,32);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+80,172,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+80,144,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+168,152,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+208,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+256,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+304,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+208,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+256,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+304,72,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+344,144,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+392,136,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+384,200,56);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+448,112,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+448,120,24);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+128,32,32);}
        c = parent.getComponent(19);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+136,152,24);}
        c = parent.getComponent(20);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+136,144,24);}
    }
}
