import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RenameUser extends JInternalFrame implements ActionListener,ItemListener
 {
    JLabel label_1;
    JLabel label_2;
    JComboBox usrcombo;
    JButton btnren;
    JButton btncel;
    JLabel label_3;
    JLabel label_4;
    JTextField newusr;
    JLabel label_5;
    JLabel label_6;
    JTextField txtpass;	
    public static String ousr="",nusr="",pass="";
    public static Login lr;
    public static String u=lr.u;
    public static String p=lr.pass;

    public RenameUser()
       {
	super("Rename User");
        RenameUserLayout customLayout = new RenameUserLayout();
        setLocation(275,120);
	ImageIcon i3=new ImageIcon("images/icon_16_user_add.gif");
 	setFrameIcon(i3);
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ImageIcon i=new ImageIcon("images/login.gif");  
        label_1 = new JLabel(i);
        getContentPane().add(label_1);

        label_2 = new JLabel("Select User Name  :");
	label_2.setFont(new Font("verdana",Font.BOLD,12));	
	label_2.setForeground(Color.red);
        getContentPane().add(label_2);

        usrcombo = new JComboBox();
	usrcombo.setBackground(Color.white);
	usrcombo.setForeground(Color.red);
	usrcombo.setFont(new Font("verdana", Font.BOLD, 12));	
	usrcombo.addItemListener(this);
        getContentPane().add(usrcombo);

        btnren = new JButton("Rename",new ImageIcon(ClassLoader.getSystemResource("images\\upper_search_button.gif")));
	btnren.addActionListener(this);
	btnren.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btnren);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.addActionListener(this);
	btncel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btncel);

	ImageIcon i1=new ImageIcon("images/icon_16_user_add.gif");  
        label_3 = new JLabel(i1);
        getContentPane().add(label_3);

        label_4 = new JLabel("New User Name     :");
	label_4.setFont(new Font("verdana",Font.BOLD,12));	
	label_4.setForeground(Color.red);
        getContentPane().add(label_4);

        newusr = new JTextField("");
	newusr.setFont(new Font("verdana",Font.BOLD,12));	
	newusr.setForeground(Color.red);
        getContentPane().add(newusr);

	ImageIcon i2=new ImageIcon("images/keys.gif");
	label_5 = new JLabel(i2);
        getContentPane().add(label_5);

        label_6 = new JLabel("Password :");
	label_6.setFont(new Font("verdana",Font.BOLD,12));	
	label_6.setForeground(Color.red);
        getContentPane().add(label_6);

        txtpass = new JTextField("");
	txtpass.setFont(new Font("verdana",Font.BOLD,12));	
	txtpass.setForeground(Color.red);
        getContentPane().add(txtpass);

	Color c=new Color(238,249,255);
	getContentPane().setBackground(c);
        setSize(getPreferredSize());
        
    }

public void itemStateChanged(ItemEvent ie)
	{
	if(ie.getSource()==usrcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			ousr=(String)ie.getItem();
			}
		}
	}

public void actionPerformed (ActionEvent ae) 
     {	
     nusr=newusr.getText();
     pass=txtpass.getText();		
     if(ae.getSource()==btncel)
	{
	this.setVisible(false);		
	}
     if(ae.getSource()==btnren)
	{
	try
  		  {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url,"root","");

		  Statement stmt=con.createStatement();

		  String sql="rename user "+ousr+" to "+nusr;

		  String sql1="delete from mysql.user where user='"+ousr+"'";

		  String k="\""+pass+"\""; 

		  String sql2="grant usage on *.* to "+nusr+"@localhost identified by "+k;
	
		  stmt.executeUpdate(sql);

		  stmt.executeUpdate(sql1); 
		 
		  String str2="User "+ousr+" Renamed to "+nusr;

		  JOptionPane.showMessageDialog(null,str2,"Renamed",JOptionPane.INFORMATION_MESSAGE); 				

		  usrcombo.removeAllItems();	

		  newusr.setText("");	
	 	  }
		catch(Exception e)
		  {
		  String str2=e.getMessage();
		  JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 				
   		  } 
	}
     }
    
}


class RenameUserLayout implements LayoutManager {

    public RenameUserLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 320 + insets.left + insets.right;
        dim.height = 209 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+24,32,32);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+32,136,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+32,128,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+176,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+176,128,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+72,32,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+80,136,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+80,128,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+120,32,32);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+128,136,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+128,128,24);}
    }
}
