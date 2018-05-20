import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ChangePassword extends JInternalFrame implements ActionListener,ItemListener 
   {
    JLabel label_1;
    JLabel label_2;
    JComboBox usrcombo;
    JButton btnchn;
    JButton btncel;
    JLabel label_3;
    JLabel label_4;
    JPasswordField opass;
    JLabel label_5;
    JLabel label_6;
    JPasswordField npass;
    public static String usr="",op="",np="",ptmp="",p1="",p2="";
    public static Login lr;
    public static String u=lr.u;
    public static String p=lr.pass;

    public ChangePassword() 
      {
	super("Change Password");
        ChangePasswordLayout customLayout = new ChangePasswordLayout();
	setLocation(275,120);
	ImageIcon i3=new ImageIcon("images/keys.gif");
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

        btnchn = new JButton("Change",new ImageIcon(ClassLoader.getSystemResource("images\\upper_search_button.gif")));
	btnchn.addActionListener(this);
	btnchn.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btnchn);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.addActionListener(this);
	btncel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btncel);

	ImageIcon i1=new ImageIcon("images/keys.gif");  
        label_3 = new JLabel(i1);
	label_3.setFont(new Font("verdana",Font.BOLD,12));	
	label_3.setForeground(Color.red);
        getContentPane().add(label_3);

        label_4 = new JLabel("Old Password        :");
	label_4.setFont(new Font("verdana",Font.BOLD,12));	
	label_4.setForeground(Color.red);
        getContentPane().add(label_4);

        opass = new JPasswordField("");
	opass.setEchoChar('#');
	opass.setFont(new Font("verdana",Font.BOLD,12));	
	opass.setForeground(Color.red);
        getContentPane().add(opass);

	ImageIcon i2=new ImageIcon("images/Login-Icon.jpg"); 
        label_5 = new JLabel(i2);
        getContentPane().add(label_5);

        label_6 = new JLabel("New Password      :");
	label_6.setFont(new Font("verdana",Font.BOLD,12));	
	label_6.setForeground(Color.red);
        getContentPane().add(label_6);

        npass = new JPasswordField("");
	npass.setEchoChar('#');
	npass.setFont(new Font("verdana",Font.BOLD,12));	
	npass.setForeground(Color.red);
        getContentPane().add(npass);

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
			usr=(String)ie.getItem();
			}
		}
	}

public void actionPerformed (ActionEvent ae) 
     {	
     op=opass.getText();	
     np=npass.getText();	
 	
     if(ae.getSource()==btncel)
	{
	this.setVisible(false);		
	}
     if(ae.getSource()==btnchn)
	{
	if(op.equals("") || np.equals(""))
	{
	JOptionPane.showMessageDialog(null,"Please fill all the fields","Error",JOptionPane.ERROR_MESSAGE); 				
	}
	else
	{
	try
  		  {
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url,"root","");

		  Statement st=con.createStatement();

		  String sql="select user,Password from mysql.user where user='"+usr+"'";

		  ResultSet rs=st.executeQuery(sql);

		  while(rs.next())
			{
			ptmp=rs.getString(2);
			}

		  st.executeUpdate("create user temp");

		  String sql1="set password for temp=password('"+op+"')";
			
		  st.executeUpdate(sql1);

		  String sql2="select Password from mysql.user where user='temp'";

		  ResultSet rs1=st.executeQuery(sql2);

		  while(rs1.next())
			{
		 	p1=rs1.getString(1);
			}
		  st.executeUpdate("create user temp1");

		  String sql3="set password for temp1=password('"+np+"')";
			
		  st.executeUpdate(sql3);

		  String sql4="select Password from mysql.user where user='temp1'";

		  ResultSet rs2=st.executeQuery(sql4);

		  while(rs2.next())
			{
		 	p2=rs2.getString(1);
			}
				
        	  if(ptmp.equals(p1))
			{
			st.executeUpdate("drop user temp");
			st.executeUpdate("drop user temp1");
			
			String sql5="update mysql.user set Password='"+p2+"' where user='"+usr+"'";
			
			st.executeUpdate(sql5);	

			String str2="Password Changed";

		  	JOptionPane.showMessageDialog(null,str2,"Changed",JOptionPane.INFORMATION_MESSAGE); 				
			}
		  else
			{
			st.executeUpdate("drop user temp");
			st.executeUpdate("drop user temp1");
			JOptionPane.showMessageDialog(null,"Password Does Not Matches","ERROR",JOptionPane.ERROR_MESSAGE); 				
			}
		  usrcombo.removeAllItems();	
		  opass.setText("");
		  npass.setText("");
	 	  }
		catch(Exception e)
		  {
		  String str2=e.getMessage();
		  JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 				
   		  } 
	    }
	} 	
     }

}

class ChangePasswordLayout implements LayoutManager {

    public ChangePasswordLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 320 + insets.left + insets.right;
        dim.height = 196 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+168,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+168,128,24);}
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
