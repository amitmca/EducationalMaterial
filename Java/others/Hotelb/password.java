//password form for hotel reservation system

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class password
{
	public static void main(String args[])
	{
		password pass=new password();
	}
	
	public password()
	{
		passform frame=new passform();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.show();
	}
}
class passform extends JFrame
{
	public passform()
	{
		setTitle("Password Form");
		setSize(300,300);
		setResizable(false);
		
		Container cpane=getContentPane();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		
		JLabel j1=new JLabel("User Name");
		j1.setForeground(Color.blue);
		p1.add(j1);
		JTextField username=new JTextField(15);
		p1.add(username);
		username.setFont(font);
		username.setText("     Administrator ");
		username.setEnabled (false);
		
		JLabel j2=new JLabel("Password");
        j2.setForeground(Color.blue);
		p2.add(j2);
		password1=new JPasswordField(15);
		p2.add(password1);
		password1.setFont(font);
		password1.addActionListener(new RightAction());
		JButton ok=new JButton("OK");
		p3.add(ok);
		ok.setFont(font);
		ok.addActionListener(new RightAction());
		ok.setCursor(cur);
		ok.setForeground(color);
		
		JButton cancel=new JButton("Cancel");
		p3.add(cancel);
		cancel.setFont(font);
		cancel.setCursor(cur);
		cancel.setForeground(color);
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		cpane.add(p1);
		cpane.add(p2);
		cpane.add(p3);
		cpane.setLayout(new GridLayout(3,2));
	}
	
	private Font font = new Font("Tahoma",Font.BOLD,13);   
    Cursor cur = new Cursor(HAND_CURSOR);
    Color color = new Color(0,0,255);
    public static final int	HAND_CURSOR	= 12;
	private JTextField password1;
	private class RightAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String pass=password1.getText();
			if(pass.equals("amol"))
			{
				dummy prj=new dummy();
				passform.this.dispose();
				
				}
				else
				{
					JOptionPane.showMessageDialog(passform.this,"         Please try Again !","Invalid Password !!!",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	