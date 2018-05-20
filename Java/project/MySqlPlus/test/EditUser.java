import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class EditUser extends JInternalFrame implements ActionListener,ItemListener
 {
    ButtonGroup cbg;
    JRadioButton chusr;
    JRadioButton chpass;
    JButton btncon;
    JButton btncel;
    JLabel label_1;
    JLabel label_2;
    Color c=new Color(238,249,255);
    public static String type="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;

    public EditUser() 
     {
	super("Edit User");
        EditUserLayout customLayout = new EditUserLayout();
        setLocation(275,120);
	ImageIcon i3=new ImageIcon("images/b_usredit.PNG");
 	setFrameIcon(i3);
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        cbg = new ButtonGroup();
        chusr = new JRadioButton("Change User Name", false);
	chusr.setFont(new Font("verdana",Font.BOLD,12));	
	chusr.setBackground(c);
	chusr.setForeground(Color.red);
	chusr.addItemListener(this);
        cbg.add(chusr);
        getContentPane().add(chusr);

        chpass = new JRadioButton("Change Password", false);
	chpass.setFont(new Font("verdana",Font.BOLD,12));	
	chpass.setBackground(c);
	chpass.setForeground(Color.red);
	chpass.addItemListener(this);
        cbg.add(chpass);
        getContentPane().add(chpass);

        btncon = new JButton("Continue",new ImageIcon(ClassLoader.getSystemResource("images\\submitS.PNG")));
	btncon.addActionListener(this);
	btncon.setFont(new Font("verdana",Font.BOLD,12));	
        getContentPane().add(btncon);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.addActionListener(this);
	btncel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btncel);

        ImageIcon i=new ImageIcon("images/login.gif");  
        label_1 = new JLabel(i);
        getContentPane().add(label_1);

        ImageIcon i1=new ImageIcon("images/keys.gif");  
        label_2 = new JLabel(i1);
        getContentPane().add(label_2);
	
	getContentPane().setBackground(c);
        setSize(getPreferredSize());
  
    }

   public static void ChangeUser()
	{
	RenameUser ru=new RenameUser();

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
		        ru.usrcombo.addItem(text);
		        }
		    }
		 catch(Exception e)
		     {
		     String str2=e.getMessage();
		     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
		     }	
		
		ru.setVisible(true);
		
		MysqlPlus.desktop.add(ru);
	}	

    public static void ChangePass()
	{
	ChangePassword cp=new ChangePassword();
	
		try
		  {
		   Class.forName("com.mysql.jdbc.Driver");

  	           String url="jdbc:mysql://localhost:3306/";
				
		   Connection conn=DriverManager.getConnection(url,u,p);		
			
		   Statement st=conn.createStatement();
	
	  	   String sql="select user from mysql.user";

   		   st.executeQuery(sql);

 		   ResultSet rs=st.executeQuery(sql);

		   String text=" ";

		   while(rs.next())
		        {
		        text=rs.getString(1);
		        cp.usrcombo.addItem(text);
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
	if(ie.getItemSelectable()==chusr)
		{
		type="UserName";
		}
	else if(ie.getItemSelectable()==chpass)
		{
		type="Password";
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
		if(type.equals("UserName"))
			{
			this.setVisible(false);
			ChangeUser();
			}
		else
			{
			this.setVisible(false);
			ChangePass();
			}
		}
	}
   }

class EditUserLayout implements LayoutManager {

    public EditUserLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 294 + insets.left + insets.right;
        dim.height = 159 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+16,216,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+64,216,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+25,insets.top+120,120,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+120,120,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+16,32,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+64,32,24);}
    }
}
