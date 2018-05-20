import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;

public class PasswordForm
{
	public static void main(String args[])
	{		
		PasswordForm obj = new PasswordForm();
	}
	public PasswordForm()
	{
		PasswordFormFrame frame = new PasswordFormFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show(true);
	}
}

class PasswordFormFrame extends JFrame
{
	JTextField txtUserName;
	JPasswordField txtPass;
	JCheckBox c;
	public PasswordFormFrame()
	{
		setTitle("Password Form");
		setSize(343,300);
		setLocation(200,150);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(50,50,100,25);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField(35);	
		txtUserName.setBounds(150,50,130,25);
		contentPane.add(txtUserName);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(50,100,100,25);
		contentPane.add(lblPass);
		
	    txtPass = new JPasswordField(35);
	    txtPass.setEchoChar('*');
		txtPass.setBounds(150,100,130,25);
		contentPane.add(txtPass);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setMnemonic('O');
		btnOk.setBounds(100,200,80,25);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(200,200,80,25);
		btnCancel.setMnemonic('C');
		contentPane.add(btnCancel);
		
		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"");
 		
 		c = new JCheckBox("Change Password");
 		c.setBounds(50,150,130,25);
 		contentPane.add(c);
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(20,20,300,230);
 		buttonPanel.setBorder(titled);
 		contentPane.add(buttonPanel);

btnCancel.addActionListener(new ActionListener()
{
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
});	
btnOk.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
	String inputString1="",inputString2="";
	JFrame f= new JFrame();
	try
	{				
	  if(c.isSelected()==false)
	  {		
 	
 		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");						 	 		
		Connection con=DriverManager.getConnection
		("jdbc:odbc:SlotMgt","","");		 
		Statement stmt = con.createStatement();			
		ResultSet rs = stmt.executeQuery
		("Select * From Password");
		
		while(rs.next())
		{			
			inputString1=rs.getString(1);
			inputString2=rs.getString(2);
		}			
		
		if(inputString1.equals(txtUserName.getText()))
		{
		  if (inputString2.equals(txtPass.getText()))
			{
				SlotMgt S = new SlotMgt(); 
			}
		}
		else
		{
			JOptionPane.showMessageDialog(f,new String("Invalid Password"));			
			txtUserName.setText("");
			txtPass.setText("");						
		}
 		
	  }
	  else
	  {	
	  	setVisible(false);  	
	  	ChangePassword aa = new ChangePassword();	  
	  }
	}
 	catch(Exception ee)
	{
		JOptionPane.showMessageDialog(f,new String("Error.."));
	}
			
   }			
});
   

	}
}