import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class frame extends Frame implements ActionListener
	{
	public static Connection con1=null;
	public Statement stmt;
	public Button b1,b2,b3,b4;
	public Label l1,l2,l3;
	static String s1,s2;	
	static String mess1=" ";	
	public TextField t1,t2,t3,t4;
	public String val;
	public frame(String t)
		{
		super(t);
		setBackground(Color.white);
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

		t3=new TextField(45);
		t3.setBounds(50,200,100,25);
		this.add(t3);
	
		b2=new Button("Clear");
		b2.setBounds(70,200,100,25);
		this.add(b2);
				
		b3=new Button("Close");
		b3.setBounds(80,100,100,25);
		this.add(b3);

		b1.addActionListener(this);	
		b2.addActionListener(this);	
		b3.addActionListener(this);	
		}
	public void actionPerformed(ActionEvent event)
		{
		if(event.getSource()==b1)
			try
			{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql:fy";
			con1=DriverManager.getConnection(url,"mca"," ");
			stmt=con1.createStatement();
			if(event.getSource()==b1)
				{
				String eno=t1.getText();
				String ename=t2.getText();
				s1="insert into emp values('"+eno+"',"+"'"+ename+"')";
				stmt.executeUpdate(s1);
				val="New Record Added";
				t4.setText(val);
				}
			if(event.getSource()==b4)
				{
				s2="delete from emp where eno='t3.getText()'";
				stmt.executeUpdate(s2);
				System.out.println("Record Deleted");
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
		if(event.getSource()==b2)
			{	
			System.exit(0);
			}
		if(event.getSource()==b3)
			{	
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			}
		}
	}
public class connect extends Frame implements ActionListener
{
	public static Connection con=null;
	static String mess=" ";
	static String s=" ";
	public static Frame f; 
	public TextField t;
	public Button b1,b2,i;
		
	frame insert;
	public connect()
	{
	setBackground(Color.yellow);
	setForeground(Color.magenta);
	b1=new Button("Check Connection");
	b2=new Button("Exit");
	i=new Button("INSERT/DELETE");
	t=new TextField(40);
	this.setLayout(new FlowLayout());
	this.add(t);
	this.add(b1);
	this.add(b2);
	this.add(i);
	b1.addActionListener(this);	
	b2.addActionListener(this);	
	i.addActionListener(this);
	insert=new frame("INSERT/DELETE");
	insert.setSize(300,300);	
	}	
	public void actionPerformed(ActionEvent e)
		{
		try
			{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql:fy";
			mess="Driver Loaded";
			con=DriverManager.getConnection(url,"mca"," ");
			mess=mess+"\t" +"Connection Created";
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
		}


public static void main(String args[])
	{
	connect f=new connect();
	f.setSize(300,300);
	f.setTitle("my frame");
	f.show();
	}
}


