import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
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

public class LogScreen extends JFrame implements ActionListener
{
	JDialog jdLog;
	Container cLog;
	JTextField t1Log;
	JPasswordField t2Psswd;
	JButton btnOk;
	JButton btnCancel;
	JLabel l1LogName;
	JLabel l2Psswd;
	String logName;
	String logPsswd;
	char ch;
	JLabel mess,mess1;	
	
	JOptionPane jop;
	
	

	int cnt = 0;

	LogScreen()
	{
		jdLog = new JDialog();
		
		jdLog.setBounds(300,200,320,200);
		cLog = jdLog.getContentPane();
		cLog.setLayout(null);
		jdLog.setTitle("VIIT Login");

		cLog.setBackground(Color.black);

		

		t1Log = new JTextField();

		t1Log.setFont(new Font("verdana",Font.BOLD,13));

		t1Log.setBounds(170,20,130,30);

		t2Psswd = new JPasswordField();
		
		t2Psswd.setFont(new Font("verdana",Font.BOLD,13));
		
		t2Psswd.setBounds(170,60,130,30);
		t2Psswd.setEchoChar('*');


		btnOk = new JButton("Login");
		btnOk.setBounds(50,120,80,30);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(200,120,80,30);

		l1LogName = new JLabel("User Name: ");
		l1LogName.setForeground(Color.white);
		l1LogName.setBounds(20,20,150,20);

		l2Psswd = new JLabel("Password: ");
		l2Psswd.setForeground(Color.white);
		l2Psswd.setBounds(20,60,150,20);

		
		cLog.add(t1Log);
		cLog.add(t2Psswd);
		cLog.add(btnOk);
		cLog.add(btnCancel);
		cLog.add(l1LogName);
		cLog.add(l2Psswd);
		

		//btnOk.setEnabled(false);

		jdLog.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				jdLog.dispose();
			}
		});

		/*t2Psswd.addKeyListener(new KeyAdapter()
		{
			public void 	keyTyped(KeyEvent ke)
			{
				ch = ke.getKeyChar();
				if(ch>=65 && ch<=122)
				btnOk.setEnabled(true);
			}
		});*/

		btnCancel.addActionListener(this);
		btnOk.addActionListener(this);
		jdLog.show();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String btnCaption = ae.getActionCommand();

		 Connection con2=null;

		 Statement stmt1;

		logName = t1Log.getText();
		logPsswd = t2Psswd.getText();

		if(ae.getSource()==btnOk)
		{
		if(logName.equals("") || logPsswd.equals(""))
			{
			Toolkit.getDefaultToolkit().beep();	
			String str1 = "Please enter both the fields";
			jop.showMessageDialog(null,str1,str1, jop.ERROR_MESSAGE);
			t1Log.setBackground(Color.red);	
			t1Log.setForeground(Color.white);
			t2Psswd.setBackground(Color.red);
			t2Psswd.setForeground(Color.white);	
			
			}
		else
			{
			try
			{
						
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			String text=new String();
					
			con2=DriverManager.getConnection(url,"","");

			stmt1=con2.createStatement();

			String sql="select usr,pass from login ";

			ResultSet rs=stmt1.executeQuery(sql);

			String usr="",pass="";
			
			

			while(rs.next())
				{
		
				usr=rs.getString(1);
		
				pass=rs.getString(2);
				
				if(usr.equals(logName) && pass.equals(logPsswd))
					{
					String str = "You have Loggged in Successfully";
					Toolkit.getDefaultToolkit().beep();
					jop.showMessageDialog(null,str,str, jop.INFORMATION_MESSAGE);
					MainPage m=new MainPage();
					m.setVisible(true);	
					jdLog.setVisible(false);			
					}
				else	
					{
					Toolkit.getDefaultToolkit().beep();
					
					t1Log.setText("");
					t2Psswd.setText("");
					cnt++;
					
					throw new LogException();
					
					}
				}

			}
				
			catch(LogException e)
			{
				System.out.println(e);
				
			}
			catch(SQLException e1)
			{
			}
			catch(ClassNotFoundException e3)
			{
			
			}
			
			
			if(cnt == 3)
			{
			System.out.print("\n\n");
			jdLog.dispose();
			System.exit(0);
			}
		}	
		}

		if(btnCaption.equals("Cancel"))
		{
			jdLog.dispose();
			System.exit(0);
		}
	}

	public static void main(String args[])
	{
		LogScreen ls = new LogScreen();
	}
}
