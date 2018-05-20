import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class frame extends Frame implements ActionListener
	{
	public static Connection con1=null;
	public Statement stmt;
	public Button b1,b2,b3;
	public Label l1,l2;
	static String s1,s2;	
	static String mess1=" ";	
	public TextField t1,t2,t3,t4;
	public String val;
	public frame(String t)
		{
		super(t);
		setBackground(Color.green);
		setForeground(Color.red);
		l1=new Label("Employee No:");
		l1.setBounds(60,50,100,25);
		this.add(l1);

		l2=new Label("Employee Name:");
		l2.setBounds(60,100,100,25);
		this.add(l2);

		t1=new TextField(30);
		t1.setBounds(180,50,100,25);
		this.add(t1);

		t2=new TextField(30);
		t2.setBounds(180,100,100,25);
		this.add(t2);

		b1=new Button("Insert");
  		b1.setBounds(30,150,100,25);
		this.add(b1);

		t3=new TextField(60);
		t3.setBounds(50,200,100,25);
		this.add(t3);
	
		b2=new Button("Clear");
		b2.setBounds(150,200,100,25);
		this.add(b2);
				
		b3=new Button("Close");
		b3.setBounds(400,200,100,20);
		this.add(b3);

		b1.addActionListener(this);	
		b2.addActionListener(this);	
		b3.addActionListener(this);	
		}
	public void actionPerformed(ActionEvent event)
		{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:SQL";
			con1=DriverManager.getConnection(url," "," ");
			stmt=con1.createStatement();
			if(event.getSource()==b1)
				{
				String eno=t1.getText();
				String ename=t2.getText();
				s1="insert into employee values('"+eno+"',"+"'"+ename+"')";
				stmt.executeUpdate(s1);
				val="Record Added";
				t3.setText(val);
				}
			}
		catch(SQLException e2)
			{
			mess1=mess1+e2;
			}
		catch(ClassNotFoundException e3)
			{
			mess1=mess1+e3;
			}
		if(event.getSource()==b3)
			{
			setVisible(false);
			}
		if(event.getSource()==b2)
			{	
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			}
		}
	}
class frame1 extends Frame implements ActionListener
	{
	public static Connection con1=null;
	public Statement stmt;
	public Button b1,b2,b3;
	public Label l1;
	static String s1;	
	static String mess1=" ";	
	public TextField t1,t2;
	public String val;
	public frame1(String t)
		{
		super(t);
		setBackground(Color.green);
		setForeground(Color.red);
		l1=new Label("Employee No:");
		l1.setBounds(60,50,100,25);
		this.add(l1);

		t1=new TextField(30);
		t1.setBounds(180,50,100,25);
		this.add(t1);

		b1=new Button("Delete");
  		b1.setBounds(30,150,100,25);
		this.add(b1);

		t2=new TextField(60);
		t2.setBounds(50,200,100,25);
		this.add(t2);

		b2=new Button("Clear");
		b2.setBounds(150,200,100,25);
		this.add(b2);
				
		b3=new Button("Close");
		b3.setBounds(400,200,100,20);
		this.add(b3);

		b1.addActionListener(this);	
		b2.addActionListener(this);	
		b3.addActionListener(this);	
		}
	public void actionPerformed(ActionEvent event)
		{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:SQL";
			con1=DriverManager.getConnection(url," "," ");
			stmt=con1.createStatement();
			if(event.getSource()==b1)
				{
				String eno=t1.getText();
				s1="delete from employee where eno='"+Integer.parseInt(eno)+"'";
				stmt.executeUpdate(s1);
				val="Record Deleted";
				t2.setText(val);
				}
			}
		catch(SQLException e2)
			{
			mess1=mess1+e2;
			}
		catch(ClassNotFoundException e3)
			{
			mess1=mess1+e3;
			}
		if(event.getSource()==b3)
			{
			setVisible(false);
			}
		if(event.getSource()==b2)
			{	
			t1.setText(" ");
			t2.setText(" ");
			}
		}
	}

public class sqlserver extends Frame implements ActionListener
{
	public static Connection con=null;
	static String mess=" ";
	static String s=" ";
	public static Frame f; 
	
	public TextField t;
	public Button b1,b2,i,d;
		
	frame insert;
	frame1 delete;

	public sqlserver()
	{
	setBackground(Color.yellow);
	setForeground(Color.magenta);

	b1=new Button("Check Connection");

	this.setLayout(new FlowLayout());	

	b2=new Button("Exit");
	i=new Button("INSERT");
	d=new Button("DELETE");
	t=new TextField(40);
	t.setBounds(60,50,100,25);
	this.add(t);



	this.add(b1);
	this.add(b2);
	this.add(i);
	this.add(d);
	b1.addActionListener(this);	
	b2.addActionListener(this);	
	i.addActionListener(this);
	d.addActionListener(this);
	insert=new frame("INSERT");
	delete=new frame1("DELETE");
	insert.setSize(300,300);	
	delete.setSize(300,300);	
	}	
	
	public void actionPerformed(ActionEvent e)
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:SQL";
			con=DriverManager.getConnection(url," "," ");
			mess="Driver Loaded";
			mess=mess+"  " +"Connection Created";
			}
		catch(SQLException e1)
			{
			mess=mess+e1;
			}
		catch(ClassNotFoundException e2)
			{
			mess=mess+e2;
			}
		if(e.getSource()==b1)
			{
			t.setText(mess);
			}
		if(e.getSource()==b2)
			{
			System.exit(0);
			}
		if(e.getSource()==i)
			{
			insert.setVisible(true);
			}
		if(e.getSource()==d)
			{
			delete.setVisible(true);
			}
		}


public static void main(String args[])
	{
	sqlserver f=new sqlserver();
	f.setSize(300,300);
	f.setTitle("my frame");
	f.show();
	}
}


