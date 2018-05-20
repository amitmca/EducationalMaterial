import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
class frame extends Frame implements ActionListener
	{
	public static Connection con1=null;
	public JProgressBar pb1;	
	public Statement stmt;
	public JButton b1,b4,b2,b3;
	public Label l1,l2,l3;
	static String s1,s2;	
	static String mess1=" ";	
	public TextField t1,t2,t3,t4;
	public String val;
	public frame(String t)
		{
		super(t);
		setBackground(Color.cyan);
		this.setLayout(new FlowLayout());
		l1=new Label("Employee Number:");
		t1=new TextField(30);
		t2=new TextField(30);
		t3=new TextField(30);
		t4=new TextField(30);
		l2=new Label("Employee Name:");
		b1=new JButton("Insert",new ImageIcon("insert.png"));
		b4=new JButton("Delete",new ImageIcon("delete.png"));
		b2=new JButton("Close",new ImageIcon("error.png"));
		b3=new JButton("Clear",new ImageIcon("run.png"));
		pb1=new JProgressBar();
		l2=new Label("Employee Number to Delete:");
		this.add(l1);
		this.add(t1);
		this.add(t2);
		this.add(b1);
		this.add(pb1);
		this.add(t4);
		this.add(l2);
		this.add(t3);
		this.add(b4);
		this.add(b2);
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
				pb1.setValue(pb1.getMaximum());
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
public class jconnect extends Frame implements ActionListener
{
	public static Connection con=null;
	static String mess=" ";
	static String s=" ";
	public static Frame f; 
	public TextField t;
	public JButton b1,b2,i;
	public JProgressBar pb;	
	frame insert;
	public jconnect()
	{
	setBackground(Color.magenta);
	b1=new JButton("Check Connection",new ImageIcon("check.png"));
	b2=new JButton("Exit",new ImageIcon("error.png"));
	i=new JButton("INSERT/DELETE",new ImageIcon("fork.png"));
	t=new TextField(40);
	pb=new JProgressBar();
	this.setLayout(new FlowLayout());
	this.add(t);
	this.add(b1);
	this.add(b2);
	this.add(i);
	this.add(pb);
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
			pb.setValue(pb.getMaximum()-50);
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
	jconnect f=new jconnect();
	f.setSize(300,300);
	f.setTitle("my frame");
	f.show();
	}
}


