import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddUser extends JInternalFrame implements ActionListener
 {
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    JTextField txtusr;
    JPasswordField txtpass;
    JButton btnadd;
    JButton btnclr;
    JButton btncel;
    public static String usr="",pass="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;
	
    public AddUser() 
    {
	super("Add User");
        AddUserLayout customLayout = new AddUserLayout();
	setLocation(275,120);
	ImageIcon i3=new ImageIcon("images/b_usradd.PNG");
 	setFrameIcon(i3);
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ImageIcon i=new ImageIcon("images/login.gif");  
        label_1 = new JLabel(i);
        getContentPane().add(label_1);

        label_2 = new JLabel("User Name     :");
	label_2.setFont(new Font("verdana",Font.BOLD,12));	
	label_2.setForeground(Color.red);
        getContentPane().add(label_2);

	ImageIcon i1=new ImageIcon("images/keys.gif");  
        label_3 = new JLabel(i1);
        getContentPane().add(label_3);

        label_4 = new JLabel("Password       :");
	label_4.setFont(new Font("verdana",Font.BOLD,12));
	label_4.setForeground(Color.red);
        getContentPane().add(label_4);

        txtusr = new JTextField("");
	txtusr.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(txtusr);

        txtpass = new JPasswordField("");
	txtpass.setFont(new Font("verdana",Font.BOLD,12));
	txtpass.setEchoChar('#');
        getContentPane().add(txtpass);

        btnadd = new JButton("Add",new ImageIcon(ClassLoader.getSystemResource("images\\upper_search_button.gif")));
	btnadd.addActionListener(this);
	btnadd.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btnadd);

        btnclr = new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("images\\goccc.gif")));
	btnclr.addActionListener(this);
	btnclr.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btnclr);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.addActionListener(this);
	btncel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btncel);
	Color c=new Color(238,249,255);
	getContentPane().setBackground(c);
        setSize(getPreferredSize());

      
    }

   public void actionPerformed(ActionEvent ae)
	{	
	usr=txtusr.getText();
	pass=txtpass.getText();

	if(ae.getSource()==btncel)
		{
		this.setVisible(false);		
		}	
	if(ae.getSource()==btnclr)
		{
		if(usr.equals("") && pass.equals(""))	
			{
			JOptionPane.showMessageDialog(null,"Fields are empty","Error",JOptionPane.ERROR_MESSAGE);
			}
		else
			{
			txtusr.setText("");
			txtpass.setText("");
			}
		}
	if(ae.getSource()==btnadd)
		{
		if(usr.equals("") || pass.equals(""))	
			{
			JOptionPane.showMessageDialog(null,"Please fill both the fields","Error",JOptionPane.ERROR_MESSAGE);
			}
		else
			{
			try
  		 	  {
		  	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url,"root","");

			  Statement st=con.createStatement();

			  String sql="create user "+usr; 

			  String sql1="set password for "+usr+"="+"password('"+pass+"')";

			  String k="\""+pass+"\""; 

			  String sql2="grant usage on *.* to "+usr+"@localhost identified by "+k;

			  st.executeUpdate(sql);  
			
			  st.executeUpdate(sql1);

			  st.executeUpdate(sql2);  

			  String str1="User "+usr+" Created";

			  JOptionPane.showMessageDialog(null,str1,"Created",JOptionPane.INFORMATION_MESSAGE);				

			  txtusr.setText("");
			  txtpass.setText("");
			  }
			catch(Exception e)
			  {
			  String str=e.getMessage(); 	
			  JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);	
   			  }
			}
		}	
	}
}


class AddUserLayout implements LayoutManager {

    public AddUserLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 440 + insets.left + insets.right;
        dim.height = 174 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+32,56,32);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+40,144,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+72,56,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+80,144,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+40,136,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+80,136,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+128,88,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+128,104,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+128,128,24);}
    }
}
