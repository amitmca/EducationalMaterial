import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.sql.*;


class LogException extends Exception
{	
	JOptionPane jop;

	public LogException()
	{
		String str = "Invalid Username/Password";
		jop.showMessageDialog(null,str,str, jop.ERROR_MESSAGE);
	}

	public String toString()
	{
		String message = "\n\n\t\tSorry! Your Could not Login";
		
		return message;
	}
}

public class Login extends JFrame implements ActionListener
 {
    JLabel midlogo;
    JLabel lbserver;
    JTextField txtserver;
    JLabel lbport;
    JTextField txtport;
    JLabel lbuser;
    JTextField txtusr;
    JLabel lbpass;
    JPasswordField txtpass;
    JButton btnOk;
    JButton btnClr;
    JButton btnCel;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel header;
    ImageIcon i;
    JOptionPane jop;
    int cnt = 0;
    public static  String u=" ",p="",p1="";
    public static String server="",port="",usr="",pass=""; 

    public static JFrame frame;
  	
    public Login() 
	{
        LoginLayout customLayout = new LoginLayout();

        getContentPane().setFont(new Font("Verdana, Arial, Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
	setLocation(300,200);
	setIconImage (getToolkit().getImage ("Images/password.PNG"));	
	setTitle("MysqlPlus Administrator 1.0");
	this.setResizable( false );
	getContentPane().setBackground(Color.white);
	

        i=new ImageIcon("images/loginheader.jpg");
	midlogo = new JLabel(i);
        getContentPane().add(midlogo);


        lbserver = new JLabel("Server",new ImageIcon("images/star.gif"),JLabel.LEFT);
	lbserver.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,13));	
        getContentPane().add(lbserver);

        txtserver = new JTextField("localhost");
	txtserver.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,12));	
	txtserver.setHorizontalAlignment (JTextField.CENTER);
	txtserver.setToolTipText ("Host Name");	
        getContentPane().add(txtserver);

        lbport = new JLabel("Port",new ImageIcon("images/star.gif"),JLabel.LEFT);
	lbport.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,13));	
        getContentPane().add(lbport);

        txtport = new JTextField("3306");
	txtport.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,12));
	txtport.setHorizontalAlignment (JTextField.CENTER);
	txtport.setToolTipText ("Mysql Port Number");			
        getContentPane().add(txtport);

        lbuser = new JLabel("Username",new ImageIcon("images/star.gif"),JLabel.LEFT);
	lbuser.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,13));
        getContentPane().add(lbuser);

        txtusr = new JTextField("");
	txtusr.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,12));	
	txtusr.setHorizontalAlignment (JTextField.CENTER);
	txtusr.setToolTipText ("Mysql User Name");	
        getContentPane().add(txtusr);

        lbpass = new JLabel("Password",new ImageIcon("images/star.gif"),JLabel.LEFT);
	lbpass.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,13));
        getContentPane().add(lbpass);

        txtpass = new JPasswordField("");
	txtpass.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,12));	
	txtpass.setHorizontalAlignment (JTextField.CENTER);
	txtpass.setToolTipText ("Mysql Password");	
        getContentPane().add(txtpass);

        btnOk = new JButton("Ok",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
        getContentPane().add(btnOk);
	btnOk.addActionListener(this);

        btnClr = new JButton("Clear");
        getContentPane().add(btnClr);
	btnClr.addActionListener(this);

        btnCel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
        getContentPane().add(btnCel);
	btnCel.addActionListener(this);

        l1 = new JLabel(":");
        getContentPane().add(l1);

        l2 = new JLabel(":");
        getContentPane().add(l2);

        l3 = new JLabel(":");
        getContentPane().add(l3);

        l4 = new JLabel(":");
        getContentPane().add(l4);

        header = new JLabel("Connect To Mysql Server Instance");
	header.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,14));	
	header.setForeground(Color.red);
        getContentPane().add(header);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
  


 public void actionPerformed(ActionEvent e)
	{
	Object obj = e.getSource();
	
	server=txtserver.getText();
	port=txtport.getText();
	usr=txtusr.getText();
	pass=txtpass.getText();

	
	if(obj==btnCel)
		{
		System.exit(0);
		}
	if(obj==btnClr)
		{
		txtserver.setText("");
		txtport.setText("");
		txtusr.setText("");
		txtpass.setText("");
		}
	if(obj==btnOk)
		{
		if(server.equals("") || port.equals("") || usr.equals("") || pass.equals(""))
			{
			Toolkit.getDefaultToolkit().beep();	
			JOptionPane.showMessageDialog(null,"Please enter all the fields","Error",JOptionPane.ERROR_MESSAGE);
			txtserver.setBackground(Color.pink);
			txtport.setBackground(Color.pink);
			txtusr.setBackground(Color.pink);
			txtpass.setBackground(Color.pink);
			txtserver.setForeground(Color.white);
			}
		else
			{
			try
			  {
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
			  String url="jdbc:odbc:mysql1";
			
			  Connection conn=DriverManager.getConnection(url);
		
			  Statement st=conn.createStatement();

			  String sql="select user,Password from mysql.user where user='"+usr+"'";

			  ResultSet rs=st.executeQuery(sql);

			 
			  while(rs.next())
				{
				u=rs.getString(1);
			 	p=rs.getString(2);
				}
			  st.executeUpdate("create user temp");

			  String sql1="set password for temp=password('"+pass+"')";
			
			  st.executeUpdate(sql1);

			  String sql2="select Password from mysql.user where user='temp'";

			  ResultSet rs1=st.executeQuery(sql2);

			 
			  while(rs1.next())
				{
			 	p1=rs1.getString(1);
				}		
                           
			  if(p.equals(p1))
				{
				st.executeUpdate("drop user temp");
				if(usr.equals("root"))
					{
					this.setVisible(false);
					MysqlPlus m=new MysqlPlus();
					m.setVisible(true);	
					}
				else
					{
					MysqlPlus1 m1=new MysqlPlus1();
					this.setVisible(false);
					m1.setVisible(true);	
					}
				}
			  else
				{
				st.executeUpdate("drop user temp");
				Toolkit.getDefaultToolkit().beep();
				txtserver.setText("");
				txtport.setText("");
				txtusr.setText("");
				txtpass.setText("");
				cnt++;
				throw new LogException();	
				}
			 

			  conn.close();
			  }

		       catch(Exception e1)
			  {
			  String str=e1.getMessage();
			  JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);
			  }
			if(cnt == 3)
			{
			this.dispose();
			System.exit(0);
			}
		      }
		}
	
	}

   
}

class LoginLayout implements LayoutManager {

    public LoginLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 421 + insets.left + insets.right;
        dim.height = 360 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,424,64);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+104,112,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+104,144,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+152,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+152,144,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+200,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+200,144,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+248,112,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+248,144,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+296,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+296,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+296,96,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+104,16,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+152,16,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+200,16,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+248,16,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+72,288,16);}
    }
}
