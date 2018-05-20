//creates frame for adding new user
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class adduserframe extends JDialog implements ActionListener
{
	JTextField username;
	JPasswordField newpassword,repassword;
	JButton ok,cancel;
	adduserframe(JFrame parent)
	{
		//true for modal
		super(parent,"Add User",true);
		Container c = getContentPane();
		c.setLayout(null);
		 
		 JLabel user=new JLabel("User Name");
		 username= new JTextField(20);
		 JLabel newpass=new JLabel("Password");
		 newpassword=new JPasswordField(20);
		 JLabel repass=new JLabel("Retype Password");
		 repassword=new JPasswordField(20);
		 	 
   		 ok=new JButton("Ok");
		 ok.setMnemonic('o');
		 cancel=new JButton("Cancel");
		 cancel.setMnemonic('c');
		
		//set bounds(xth pos,yth pos,width,height)
		user.setBounds(30,30,100,20);
		username.setBounds(220,30,150,20);
		username.setToolTipText("Username ");
		newpass.setBounds(30,60,140,20);
		newpassword.setBounds(220,60,150,20);//for new password field
		newpassword.setToolTipText("Type Password");
		repass.setBounds(30,90,180,20);
		repassword.setBounds(220,90,150,20);//for retyping new password
		repassword.setToolTipText("Retype  Password");
		ok.setBounds(100,130,60,30);
		ok.setToolTipText("Add User");
		cancel.setBounds(200,130,110,30);
		cancel.setToolTipText("Cancel");
		
		Font f=new Font("verdana",Font.BOLD,14);
        Color col=new Color(0,0,255); 
        
        user.setFont(f );  
        username.setFont(f);
        newpass.setFont(f );
        repass.setFont(f );
        newpassword.setFont(f);
        repassword.setFont(f);
        
        user.setForeground(Color.blue);
        newpass.setForeground(Color.blue);
        repass.setForeground(Color.blue);
        username.setForeground(Color.blue);
        newpassword.setForeground(Color.blue);
        repassword.setForeground(Color.blue);
        
        c.setForeground(Color.blue);
        c.setBackground(Color.cyan);
		ok.setFont(f);
		ok.setForeground(Color.blue);
		cancel.setForeground(Color.red);
		//first add event listener to the control and then add it to the container
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		c.add(ok);
		c.add(cancel);
		c.add(user);
		c.add(username);
		c.add(newpass);
		c.add(newpassword);
		c.add(repass);
		c.add(repassword);
		setLocation(180,150);
		setSize(410,200);
        setVisible(true);
        username.requestFocus(true);
	}
	  
   public void actionPerformed(ActionEvent ae)
   {
   	if(ae.getSource()==ok)
   	{
   		try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select * from login";
            ResultSet rs=stmt.executeQuery(sqlstr);
            //check for user name typed
         	if(username.getText().trim().equals(""))
   			{
   				JOptionPane.showMessageDialog(null,"Enter User name","Add User",JOptionPane.ERROR_MESSAGE);
   				username.requestFocus(true);
   				return;
   			}
   			for(int i=0;i<username.getText().length();i++)
      		   {
      		   	  char ch = username.getText().charAt(i);
				  if((ch==39))
				  {
						JOptionPane.showMessageDialog(null,"Don't   insert  '  character in User Name field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						username.setText("");
						username.requestFocus();
						return;
				  }
				 else
				  {
				  } 
		      }
            while(rs.next())
            {
            	//if user name already exist
                if (username.getText().trim().equalsIgnoreCase(rs.getString(1)))
                {
            		JOptionPane.showMessageDialog(null,"User Already Exist");
            		username.setText("");
            		username.requestFocus(true);
            		return;
                }
            }
            char pass[]=newpassword.getPassword();
			String password1=new String(pass);
			char repass[]=repassword.getPassword();
			String password2=new String(repass);
		
            //check for password typed or not
	   		if(password1.trim().equals(""))
	   		{
	   			JOptionPane.showMessageDialog(null,"Type Password","Error Message",JOptionPane.ERROR_MESSAGE);
	   			newpassword.requestFocus(true);
	   			return;
	   		}
	   		//check for password retyped or not
	   		if(password2.trim().equals(""))
	   		{
	   			JOptionPane.showMessageDialog(null,"Retype Password","Error Message",JOptionPane.ERROR_MESSAGE);
	   			repassword.requestFocus(true);
	   			return;
	   		}
            //check whether password retyped correctly
            if(!password1.trim().equalsIgnoreCase(password2.trim()))
            {
            	JOptionPane.showMessageDialog(null,"Retype Password Correctly","Retype Password",JOptionPane.DEFAULT_OPTION);
            	repassword.requestFocus(true);
                repassword.setText("");
            	return;
            }
            //write code for adding user
            if(JOptionPane.showConfirmDialog(null,"Do you want to add user?")==JOptionPane.YES_OPTION)
            {
                sqlstr="Insert into login values('"+username.getText().trim()+"','"+password1.trim()+"')";
                stmt.executeUpdate(sqlstr);
            	JOptionPane.showMessageDialog(null,"User added Succesfully !!!");
            	dispose();
            }
         }
        catch(Exception e)
        {
        	   JOptionPane.showMessageDialog(null,e.getMessage());
        }
   }
	else
	if(ae.getSource()==cancel)
	{dispose();}
   }
}
