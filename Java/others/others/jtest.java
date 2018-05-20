
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class jtest extends JFrame implements Runnable
{
	
	private JLabel leno;
	private JLabel lename;
	private JTextField tno;
	private JTextField tname;
	private static JEditorPane edit;
	private JScrollPane jScrollPane2;
	private JButton bsave;
	private JButton bexit;
	private JPanel contentPane;
	Thread thr;


	public jtest()
	{
		super();
		thr=new Thread(this,"Display");
		thr.start();
		initializeComponent();
		

		this.setVisible(true);
	}


	private void initializeComponent()
	{
		leno = new JLabel();
		lename = new JLabel();
		tno = new JTextField();
		tname = new JTextField();
		edit = new JEditorPane();
		jScrollPane2 = new JScrollPane();
		bsave = new JButton();
		bexit = new JButton();
		contentPane = (JPanel)this.getContentPane();

		
		leno.setBackground(new Color(216, 225, 236));
		leno.setText("Emp No");
	
		lename.setText("Emp Name");
	

		jScrollPane2.setViewportView(edit);
	
		bsave.setBackground(new Color(236, 216, 231));
		bsave.setText("SAVE");
		bsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				bsave_actionPerformed(e);
			}

		});
	
		bexit.setText("EXIT");
		bexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				bexit_actionPerformed(e);
			}

		});
	
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(216, 220, 236));
		addComponent(contentPane, leno, 55,18,46,23);
		addComponent(contentPane, lename, 52,62,60,18);
		addComponent(contentPane, tno, 135,18,100,22);
		addComponent(contentPane, tname, 135,61,100,23);
		addComponent(contentPane, jScrollPane2, 42,158,220,100);
		addComponent(contentPane, bsave, 53,110,83,28);
		addComponent(contentPane, bexit, 150,109,83,28);
	
		this.setTitle("jtest - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(302, 320));
	}


	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}



	private void bsave_actionPerformed(ActionEvent e)
	{
	 Connection con1=null;
	 Statement stmt;
	String mess1="",s1;
	try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:SQLITE";
			con1=DriverManager.getConnection(url," "," ");
			stmt=con1.createStatement();
			if(e.getSource()==bsave)
				{
				String eno=tno.getText();
				String ename=tname.getText();
				s1="insert into emp values('"+eno+"',"+"'"+ename+"')";
				stmt.executeUpdate(s1);
				
				
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
	}

	private void bexit_actionPerformed(ActionEvent e)
	{
		this.setVisible(false);

	}
	public void run()
	{
	}

	public static void myshow()
	{
	Connection con2=null;
	
	Statement stmt1;
	try
			{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			String text=new String();
					
			con2=DriverManager.getConnection(url,"","");

			stmt1=con2.createStatement();

			String sql="select * from employee order by eno";

			ResultSet rs=stmt1.executeQuery(sql);

			int count=0;
			edit.setFont(new Font("verdana",Font.BOLD,16));
			while(rs.next())
				{
				text=text + rs.getString(1) +"     |    " + rs.getString(2) + "\n";
				edit.setText(text);
				Thread.sleep(1000);
				count++;
				}
			String p = Integer.toString(count);
			edit.setFont(new Font("verdana",Font.BOLD,20));
			edit.setText("Total Rows"+" : "+p);
			rs.close();
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
	}

	public static void main(String[] args)throws NullPointerException
	{
		myshow();
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new jtest();

	
	}


}
