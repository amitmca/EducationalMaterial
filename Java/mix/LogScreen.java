import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


class LogException extends Exception
{	
	JOptionPane jop;

	public LogException()
	{
		String str = "Oh!! Incorrect Login!!!!!!!";
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

	JOptionPane jop;
	
	JLabel image;
	ImageIcon icon;

	int cnt = 0;

	LogScreen()
	{
		jdLog = new JDialog();
		jdLog.setBounds(360,270,350,250);
		cLog = jdLog.getContentPane();
		cLog.setLayout(null);
		jdLog.setTitle("Login Screen");

		t1Log = new JTextField();
		t1Log.setBounds(170,20,130,30);

		t2Psswd = new JPasswordField();
		t2Psswd.setBounds(170,60,130,30);
		t2Psswd.setEchoChar('*');



		btnOk = new JButton("Ok");
		btnOk.setBounds(50,120,80,30);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(200,120,80,30);

		l1LogName = new JLabel("User Name: ");
		l1LogName.setBounds(20,20,150,20);

		l2Psswd = new JLabel("Password: ");
		l2Psswd.setBounds(20,60,150,20);

		icon = new ImageIcon("236.gif");
		image = new JLabel(icon);
		image.setBounds(110,120,80,30);

		cLog.add(t1Log);
		cLog.add(t2Psswd);
		cLog.add(btnOk);
		cLog.add(btnCancel);
		cLog.add(l1LogName);
		cLog.add(l2Psswd);
		cLog.add(image);

		btnOk.setEnabled(false);

		jdLog.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				jdLog.dispose();
			}
		});

		t2Psswd.addKeyListener(new KeyAdapter()
		{
			public void 	keyTyped(KeyEvent ke)
			{
				ch = ke.getKeyChar();
				if(ch>=65 && ch<=122)
				btnOk.setEnabled(true);
			}
		});

		btnCancel.addActionListener(this);
		btnOk.addActionListener(this);
		jdLog.show();
	}

	public void actionPerformed(ActionEvent ae)
	{
		String btnCaption = ae.getActionCommand();

		if(btnCaption.equals("Ok"))
		{
			try
			{

				logName = t1Log.getText();
				logPsswd = t2Psswd.getText();
				if(logName.equals(logPsswd))
				{
					String str = "Oh!! Congrats You have Login Successfully!!!";
					jop.showMessageDialog(null,str,str, jop.INFORMATION_MESSAGE);
				//	System.out.print("\n");
				//	System.out.print("\t\tOh!! Congrats You have Login Successfully!!!"+"\n\n");

					jdLog.dispose();
					System.exit(0);
				}

				else
				{
					t1Log.setText("");
					t2Psswd.setText("");

					cnt++;
					throw new LogException();
				}
			}
			catch(LogException e)
			{
				System.out.println(e);
			}

			if(cnt == 3)
			{
				System.out.print("\n\n");
				jdLog.dispose();
				System.exit(0);
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
