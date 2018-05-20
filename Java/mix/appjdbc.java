import java.sql.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*
<applet code="appjdbc" width=250 height=250>
</applet>
*/

public class appjdbc extends Applet implements ActionListener
	{
	public static Connection con=null;
	public String mess=null;
	public Statement stmt;
	public TextField t1;
	public Button b1,b2;

	public void paint(Graphics g)
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	
			System.out.println("Connected");
	
			con=DriverManager.getConnection("jdbc:odbc:amit");
	
			stmt=con.createStatement();
			}
		catch(Exception e1)
			{
			mess="Not Connected";
			}
		}
		

	public appjdbc()

		{
		t1=new TextField(10);

		b1=new Button("Connect");
	
		add(t1);

		add(b1);	
		
		b1.addActionListener(this);

		}

	public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==b1)
			{
			t1.setText(mess);
			}
		}
	}

	
	
		
	


