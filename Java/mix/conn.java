import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class conn extends JFrame implements ActionListener
	{
	public static Connection con=null;
	public Statement stmt;
	static String mess=" ";
	public JTextField t;
	public JButton b;
	
	public conn()
	{
	b=new JButton("Check");
	t=new JTextField(30);
	this.add(t);
	this.add(b);
	b.addActionListener(this);	
	
	}	
	public void actionPerformed(ActionEvent e)
		{
		try
			{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql:fy";
			mess="Driver Loaded";
			con=DriverManager.getConnection(url,"mca"," ");
			
			}
			catch(SQLException e1)
			{
			mess=mess+e1;
			}
			catch(ClassNotFoundException e2)
			{
			mess=mess+e2;
			}
		if(e.getSource()==b)
			{
			t.setText(mess);
			}
		}
	public static void main(String args[])
		{
		conn c=new conn();
		c.setSize(300,300);
		c.setTitle("my frame");
		c.show();
		}	
	}



