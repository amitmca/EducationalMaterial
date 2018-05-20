import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;

public class ChangePassword
{
	public static void main(String args[])
	{	
	  ChangePassword aa = new ChangePassword();
    }
    public ChangePassword()
    {
		ChangePasswordFormFrame frame = new ChangePasswordFormFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show(true);
	}
	
}

class ChangePasswordFormFrame extends JFrame
{
	JTextField txtNPass,txtUserName;
	JPasswordField txtPass,txtNewPass,txtCPass;
	JCheckBox c;
	public ChangePasswordFormFrame()
	{
		setTitle("Change Password");
		setSize(380,380);
		setLocation(220,150);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		JLabel lblUserName = new JLabel("Old User Name");
		lblUserName.setBounds(50,50,100,25);
		contentPane.add(lblUserName);
		
		txtUserName = new JTextField(35);
		txtUserName.setBounds(180,50,130,25);
		contentPane.add(txtUserName);
		
		JLabel lblPass = new JLabel("Old Password");		
		lblPass.setBounds(50,100,100,25);
		contentPane.add(lblPass);
		
	    txtPass = new JPasswordField(35);
	    txtPass.setEchoChar('*');
		txtPass.setBounds(180,100,130,25);		
		contentPane.add(txtPass);
		
		JLabel lblNPass = new JLabel("New UserName");
		lblNPass.setBounds(50,150,150,25);
		contentPane.add(lblNPass);
		
	    txtNPass = new JTextField(35);
		txtNPass.setBounds(180,150,130,25);
		contentPane.add(txtNPass);
		
		JLabel lblNewPass = new JLabel("New Password");
		lblNewPass.setBounds(50,200,150,25);
		contentPane.add(lblNewPass);
		
	    txtNewPass = new JPasswordField(35);
	    txtNewPass.setEchoChar('*');
		txtNewPass.setBounds(180,200,130,25);
		contentPane.add(txtNewPass);
		
		JLabel lblCPass = new JLabel("Confirm Password");
		lblCPass.setBounds(50,250,150,25);
		contentPane.add(lblCPass);
		
	    txtCPass = new JPasswordField(35);
	    txtCPass.setEchoChar('*');
		txtCPass.setBounds(180,250,130,25);
		contentPane.add(txtCPass);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setMnemonic('O');
		btnOk.setBounds(130,300,80,25);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setBounds(230,300,80,25);
		contentPane.add(btnCancel);
		
		//Creating Border
 		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"");
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(30,30,300,260);
 		buttonPanel.setBorder(titled);
 		contentPane.add(buttonPanel);
 		
 		btnCancel.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				setVisible(false);
 				PasswordForm obj = new PasswordForm(); 				
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
	if(txtNPass.getText().equals("")||txtUserName.getText().equals("")
	  ||txtPass.getText().equals("")||txtNewPass.getText().equals("")
	  ||txtCPass.getText().equals(""))
	 {	 
	 		JOptionPane.showMessageDialog(f,new String("Fill the Form"));	 
	 }	
	 else
	 
		if(inputString1.equals(txtUserName.getText()))
		{
		  if (inputString2.equals(txtPass.getText()))
			{
			   try
			   {
			   	//Check Length
			   	if(txtNewPass.getText().length()<6)
				{
					JOptionPane.showMessageDialog
			 		(f,new String ("Password atleast 6 char long"));		
				}
				else
			   	//Check Two Password
			   	if(txtNewPass.getText().equals(txtCPass.getText()))
			   	{
			   	//Insert New Values in Databse			
 					PreparedStatement stmt1= con.prepareStatement
					("insert into Password values(?,?)");
		
 					stmt1.setString(1,txtNPass.getText());
				 	stmt1.setString(2,txtCPass.getText());					
 					stmt1.executeUpdate();
		
 					JOptionPane.showMessageDialog
				 (f,new String ("Password Changed"));
				 setVisible(false);
				 dispose();
 				PasswordForm obj = new PasswordForm();
				}
				else
				{
						JOptionPane.showMessageDialog
				 		(f,new String ("NewPassword Should be Same"));
				}
			   }//End of try
			    catch(Exception ee)
				{
					JOptionPane.showMessageDialog(f,
					new String("Error.."));
				}
			}//End of inner if			
		  }					 
	   }
      
 	catch(Exception ee)
	{		
	}	
   }
  });
  
 }//End of constructor
}