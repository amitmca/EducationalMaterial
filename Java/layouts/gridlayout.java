import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class gridlayout extends JFrame implements ActionListener
	{
	JLabel l1;
	JTextField t1;
	JButton b;
	String msg="";	
	gridlayout()
		{
		Container cc;
		cc = getContentPane();
	        cc.setLayout(null );
		setBackground(Color.pink);
		setLayout(null);
		l1=new JLabel("First",Label.LEFT);
		add(l1);
		l1.setBounds(20,20,100,10);
		
		t1=new JTextField(20);
		add(t1);
		t1.setBounds(110,18,180,20);

		b=new JButton("Connect");
		add(b);
	        b.setBounds(20,50,100,10);
		b.addActionListener(this);
		}
	public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==b)
			{
			try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				msg="Driver loaded";
				t1.setText(msg);
				String url="jdbc:odbc:mysql";
				Connection conn=DriverManager.getConnection(url);
				msg=msg+"  "+"Connection Created";
			}
			catch(Exception e1)
				{
				msg=msg+e1;
				t1.setText(msg);
				}
			}
		}
	public static void main(String args[])
		{
		gridlayout g=new gridlayout();
		g.setSize(300,200);
		g.show();
		}
	}
