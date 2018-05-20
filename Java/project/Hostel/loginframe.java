import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

//=====================================================================================================================================================================================================================================================================================================================================================================================

//create frame for login
class loginframe extends JFrame implements ActionListener
{
	JComboBox username;
	JPasswordField password;
	mainframe menuhandle;
	JButton ok,cancel;
		
	loginframe()
	{
		super("Login");
			
		Container c = getContentPane();
		c.setLayout(null);
		//c.setForeground(Color.blue);
        //c.setBackground(Color.cyan);
		 
		JLabel user=new JLabel("User Name");
		username= new JComboBox();
		JLabel pass=new JLabel("Password");
		password=new JPasswordField(20);
		ok=new JButton("Ok");
		ok.setMnemonic('o');
		cancel=new JButton("Cancel");
		cancel.setMnemonic('c');
		
		//set bounds(xth pos,yth pos,width,height)
		user.setBounds(40,30,100,20);
		username.setToolTipText("User name");
		username.setBounds(140,30,150,20);
		pass.setBounds(40,60,100,20);
		password.setBounds(140,60,150,20);
		password.setToolTipText("Password");
		ok.setBounds(70,100,60,30);
		ok.setToolTipText("Login");
		cancel.setBounds(190,100,110,30);
		cancel.setToolTipText("Cancel");
		
		Font f=new Font("verdana",Font.BOLD,14);
        Color col=new Color(0,0,255); 
        user.setFont(f );  
        user.setForeground(Color.black);
        pass.setFont(f );  
        pass.setForeground(Color.black);
        username.setForeground(Color.black);
        password.setForeground(Color.black);
        password.setFont(f);
        username.setFont(f);
        
		ok.setFont(f);
		ok.setForeground(Color.black);
		cancel.setForeground(Color.red);
		
		try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select * from login";
            ResultSet rs=stmt.executeQuery(sqlstr);
           while(rs.next())
            {
            	username.addItem(rs.getString(1));
            }
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e.getMessage());
        }
		//first add event listener to the control and then add it to the container
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		c.add(ok);
		c.add(cancel);
		c.add(user);
		c.add(username);
		c.add(pass);
		c.add(password);
		setLocation(250,150);
		setSize(340,190);
        setVisible(true);
	}
	
	public static void main(String args[])
    {
        new loginframe();  //creates loginframe instance for calling constructor
    }
  
   public void actionPerformed(ActionEvent ae)
   {
   	//get the name of the object 
   	//by which action event has been performed
   	if(ae.getSource()==ok)
   	{
   		String uname= username.getSelectedItem().toString();
		char pass[]= password.getPassword();
		String upass =  new String (pass);
		//check passwrod entered or not
		if(upass.trim().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Enter Password","Error Message",JOptionPane.ERROR_MESSAGE);
			password.requestFocus(true);
			return;
		}
		//check whether user has entered ' in password field
			 for(int i=0;i<upass.length();i++)
      		   {
      		   	  char ch = upass.charAt(i);
				  if((ch==39))
				  {
						JOptionPane.showMessageDialog(null,"Don't  insert  '  character in password field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						password.setText("");
						password.requestFocus();
						return;
				  }
				 else
				  {
				  } 
		      }
		
        try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select password from login where username='"+uname+"'";
            ResultSet rs=stmt.executeQuery(sqlstr);
           while(rs.next())
            {
              if(upass.trim().equalsIgnoreCase(rs.getString(1)))
              {
              	 dispose();
                 mainframe mf=new mainframe(uname);
		        //disables menu item if user is other than Admin
			    if(!uname.trim().equalsIgnoreCase("Admin"))
		    	{
		      	    mf.addhostel.setEnabled(false);//add hostel entry
		      	    mf.feedues.setEnabled(false);//fee dues report
		            mf.removeuser.setEnabled(false);
		      		mf.adduser.setEnabled(false);
		      		mf.modifyhostel.setEnabled(false);
		      		mf.deletehostel.setEnabled(false);//delete entries
		      		mf.admission.setEnabled(false);
		      		mf.deletefee.setEnabled(false);
		      		mf.addfee.setEnabled(false);	  
		      		mf.totalfee.setEnabled(false);
                 }
              }
              else
              {
              	JOptionPane.showMessageDialog(null,"Incorrect Password");
        	  	password.setText("");
        	  	password.requestFocus();
              }
            }
            con.close();
		}
		catch(Exception e)
		{
			   JOptionPane.showMessageDialog(null,e.getMessage());
		}
	 }
	else
	if(ae.getSource()==cancel)
	  dispose();
   }
}