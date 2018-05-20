import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
/*
<applet code="frame" width=300 height=200>
</applet>
*/
class labelframe extends Frame implements ActionListener
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
	public labelframe(String t)
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
/* class labelframe extends JFrame implements ActionListener
	{
	Container contentPane=getContentPane();
	JButton b=new JButton("Check...");
	JTextField t1=new JTextField(30);
	public static Connection con=null;
	static String mess=" ";
	labelframe(String t)
		{
		super(t);
		setLayout(new FlowLayout());
		this.add(b);
		this.add(t1);
		b.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent e)
		{
		try
			{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql:fy";
			con=DriverManager.getConnection(url,"mca"," ");
			mess="Connected to the Database";
			}
		catch(Exception e1)
			{
			mess="Not Connected";
			}
		if(e.getSource()==b)
			{
			t1.setText(mess);
			}
		}
	
	}*/
public class frame extends JApplet implements ActionListener
	{
	
	JButton b1,b2;
	JProgressBar jp1;
	labelframe window;
	
	public void init()
		{
		setBackground(Color.white);
		Container contentPane=getContentPane();
		contentPane.setLayout(new FlowLayout());	
		jp1=new JProgressBar();
		ImageIcon i=new ImageIcon("n.png");
		b1=new JButton("Connect.....",i);
		add(b1);
		b1.addActionListener(this);
		ImageIcon i1=new ImageIcon("back.png");
		b2=new JButton("Hide.....",i1);
		contentPane.add(b2);
		contentPane.add(jp1);
		b2.addActionListener(this);
		window=new labelframe("Java Window");
		window.setSize(500,500);
		}
	public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==b1)
			{
			jp1.setValue(jp1.getMaximum());
			window.setVisible(true);
			}
		if(e.getSource()==b2)
			{
			jp1.setValue(jp1.getMinimum());
			window.setVisible(false);
			}
		}
	public void paint(Graphics g)
		{
		showStatus("Connecting to Database.....................");
		}
	
	}

