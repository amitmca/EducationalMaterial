//creates frame for changing password
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class changepassframe extends JDialog implements ActionListener
{
	JTextField username;
	JPasswordField password,newpassword,repassword;
	JButton ok,cancel;
	changepassframe(JFrame parent,String user1)
	{
		//true for modal
		super(parent,"Change Password",true);
		Container c = getContentPane();
		c.setLayout(null);
		 
		 JLabel user=new JLabel("User Name");
		 username= new JTextField(20);
		 JLabel pass=new JLabel("Old Password");
		 password=new JPasswordField(20);
		 JLabel newpass=new JLabel("New Password");
		 newpassword=new JPasswordField(20);
		 JLabel repass=new JLabel("Retype NewPassword");
		 repassword=new JPasswordField(20);
		 //sets the user name
		 username.setText(user1);
		 username.setEditable(false);
		 	 
		ok=new JButton("Ok");
		ok.setMnemonic('o');
		cancel=new JButton("Cancel");
		cancel.setMnemonic('c');
		
		//set bounds(xth pos,yth pos,width,height)
		user.setBounds(30,30,100,20);
		username.setBounds(220,30,150,20);
		username.setToolTipText("Current Username ");
		pass.setBounds(30,60,140,20);
		password.setBounds(220,60,150,20);//for old password
		password.setToolTipText("Old Password");
		newpass.setBounds(30,90,140,20);
		newpassword.setBounds(220,90,150,20);//for new password field
		newpassword.setToolTipText("Type New Password");
		repass.setBounds(30,120,180,20);
		repassword.setBounds(220,120,150,20);//for retyping new password
		repassword.setToolTipText("Retype New Password");
		ok.setBounds(100,160,60,30);
		ok.setToolTipText("Change Password");
		cancel.setBounds(200,160,110,30);
		cancel.setToolTipText("Cancel");
		
		Font f=new Font("verdana",Font.BOLD,14);
        Color col=new Color(0,0,255); 
        user.setFont(f );  
        user.setForeground(Color.blue);
        pass.setFont(f );  
        newpass.setFont(f );
        repass.setFont(f );
        pass.setForeground(Color.blue);
        newpass.setForeground(Color.blue);
        repass.setForeground(Color.blue);
        username.setForeground(Color.blue);
        password.setForeground(Color.blue);
        newpassword.setForeground(Color.blue);
        repassword.setForeground(Color.blue);
        
        password.setFont(f);
        newpassword.setFont(f);
        repassword.setFont(f);
        
        username.setFont(f);
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
		c.add(pass);
		c.add(password);
		c.add(newpass);
		c.add(newpassword);
		c.add(repass);
		c.add(repassword);
		password.requestFocus(true);
		setLocation(180,150);
		setSize(410,230);
        setVisible(true);
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
            String sqlstr="select * from login where username ='"+username.getText()+"';" ;
            ResultSet rs=stmt.executeQuery(sqlstr);
            
            char pass[]=password.getPassword();
            String upass=new String(pass);
            if(upass.trim().equals(""))
            {
              JOptionPane.showMessageDialog(null,"Type Old Password","Error Message",JOptionPane.ERROR_MESSAGE);
              password.requestFocus(true);
              return;
            }
            //check whether user has entered ' in old password
			 for(int i=0;i<upass.length();i++)
      		   {
      		   	  char ch = upass.charAt(i);
				  if((ch==39))
				  {
						JOptionPane.showMessageDialog(null,"Don't   insert  '   character in old password field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						password.setText("");
						password.requestFocus();
						return;
				  }
				 else
				  {
				  } 
		      }
		      	char pass1[]=newpassword.getPassword();
              	char repass[]=repassword.getPassword();
              	
              	String newpass=new String(pass1);
              	//check for new password entered or not
              	if(newpass.trim().equals(""))
            	{
              		JOptionPane.showMessageDialog(null,"Type New Password","Error Message",JOptionPane.ERROR_MESSAGE);
              		newpassword.requestFocus(true);
              		return;
            	}
            	//check whether user has entered ' in new password field
				 for(int i=0;i<newpass.length();i++)
	      		   {
	      		   	  char ch = newpass.charAt(i);
					  if((ch==39))
					  {
							JOptionPane.showMessageDialog(null,"Don't  insert  '   character in new password field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							newpassword.setText("");
							newpassword.requestFocus();
							return;
					  }
					 else
					  {
					  } 
			      }
			    //check whether user has entered ' in retype password field
              	String repass1=new String(repass);
              	if(repass1.trim().equals(""))
            	{
              		JOptionPane.showMessageDialog(null,"Retype New Password","Error Message",JOptionPane.ERROR_MESSAGE);
              		repassword.requestFocus(true);
              		return;
            	}
            	  //check whether user has entered ' in retype password field
				 for(int i=0;i<repass1.length();i++)
	      		   {
	      		   	  char ch = repass1.charAt(i);
					  if((ch==39))
					  {
							JOptionPane.showMessageDialog(null,"Don't   insert  '   character in Retype password field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
							repassword.setText("");
							repassword.requestFocus();
							return;
					  }
					 else
					  {
					  } 
			      }

            while(rs.next())
            {
            //check for old password is correct or not
            if (upass.trim().equalsIgnoreCase(rs.getString(2)))
            {
            	//if new password retyped correctly
              	if (newpass.trim().equalsIgnoreCase(repass1.trim()))
              	{
              		sqlstr="update login set password ='"+newpass.trim() + "' where username ='"+username.getText().trim()+"';" ;
              		Statement stt=con.createStatement();
              		stt.executeUpdate(sqlstr);
              		JOptionPane.showMessageDialog(null,"Password has been Changed !!!");
              		dispose();
              	}
              	else
              	{
              		JOptionPane.showMessageDialog(null,"Retype Password Correctly");
              		repassword.setText("");
              		repassword.requestFocus();
              	}
              	
             }
             //if old password is incorrect
           else
            {
             	JOptionPane.showMessageDialog(null,"Old  password  is  incorrect");
             	password.setText("");
             	newpassword.setText("");
             	repassword.setText("");
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
	{dispose();}
   }
}

