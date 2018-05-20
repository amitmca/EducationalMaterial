import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class display extends JFrame implements ActionListener
{
    JLabel eno;
    JLabel ename;
    public static JTextField teno;
    public static JTextField tename;
    JButton bfirst;
    JButton bnext;
    JButton bprev;
    JButton blast;
    JButton bexit;	 
     public static JOptionPane jop;	
  
    public display() {
        displayLayout customLayout = new displayLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
        getContentPane().setBackground(Color.pink);	

        eno = new JLabel("Emp No");
        getContentPane().add(eno);

        ename = new JLabel("Emp Name");
        getContentPane().add(ename);

        teno = new JTextField("");
        getContentPane().add(teno);
        teno.setFont(new Font("verdana",Font.BOLD,13));
        teno.setForeground(Color.red);	
        teno.setBackground(Color.yellow);

        tename = new JTextField("");
        getContentPane().add(tename);
        tename.setFont(new Font("verdana",Font.BOLD,13));	
        tename.setForeground(Color.red);
        tename.setBackground(Color.yellow);
        

        bfirst = new JButton("FIRST");
        bfirst.setBackground(Color.black);
        bfirst.setForeground(Color.green);	
        getContentPane().add(bfirst);

        bnext = new JButton("NEXT");
        bnext.setBackground(Color.black);
        bnext.setForeground(Color.green);		
        getContentPane().add(bnext);

        bprev = new JButton("PREV");
        bprev.setBackground(Color.black);
        bprev.setForeground(Color.green);	
        getContentPane().add(bprev);

        blast = new JButton("LAST");
        blast.setBackground(Color.black);
        blast.setForeground(Color.green);	
        getContentPane().add(blast);

        bexit=new JButton("EXIT");
        bexit.setBounds(135,165,100,25);
        bexit.setBackground(Color.green);
        bexit.setForeground(Color.red);	
       getContentPane().add(bexit);	

       teno.setEditable(false);	
       tename.setEditable(false);

        setSize(getPreferredSize());
        bfirst.addActionListener(this);
        bnext.addActionListener(this);
        bprev.addActionListener(this);
        blast.addActionListener(this);
        bexit.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

 public static void First()
	{
	Statement stmt;
	ResultSet rs;
	Connection conn;
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		String url="jdbc:odbc:SQLITE";

	                 conn=DriverManager.getConnection(url);

		stmt=conn.createStatement();

 		String sql="select * from emp order by eno asc"; 

		rs=stmt.executeQuery(sql);

		if(rs.next())
			{
			teno.setText(""+rs.getString(1));
			tename.setText(rs.getString(2));
			}
			else
			{
			teno.setText("");
			tename.setText("");		
			}
		}
		catch(ClassNotFoundException e)
		{
		System.out.println(e);
		}
		catch(SQLException e1)
		{
		}
	}

    public  static void Last()
	{
	Statement stmt;
	ResultSet rs;
	Connection conn;
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	
	                  String url="jdbc:odbc:SQLITE";

	                  conn=DriverManager.getConnection(url);

		stmt=conn.createStatement();
						
		String sql="select * from emp order by eno desc"; 

		rs=stmt.executeQuery(sql);

		if(rs.next())
			{
			teno.setText(""+rs.getString(1));
			tename.setText(rs.getString(2));
			}
		else
			{
			teno.setText("");
			tename.setText("");		
			}
		}
		catch(ClassNotFoundException e)
		{
		System.out.println(e);
		}
		catch(SQLException e1)
		{
		}
	}

    public static void Next()
	{
	Statement stmt;
	ResultSet rs;
	Connection conn;
	if(teno.getText().trim().equals("")==false)
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		                 	String url="jdbc:odbc:SQLITE";

		                 conn=DriverManager.getConnection(url);
	
			stmt=conn.createStatement();

			String sql="select * from emp where eno >"+Integer.parseInt(teno.getText())+" order by eno asc"; 

			rs=stmt.executeQuery(sql);

			if(rs.next())
				{
				teno.setText(""+rs.getString(1));
				tename.setText(rs.getString(2));
				}
			else
				{
				teno.setText("");
				tename.setText("");		
				}
			}
			catch(ClassNotFoundException e)
			{
			System.out.println(e);
			}
			catch(SQLException e1)
			{
			}
		}
		else
			{
			First();
			jop.showMessageDialog(null,"No More Rows Available","No More Rows Available",jop.PLAIN_MESSAGE);
			}
	} 	

   public static void Prev()
	{
	Statement stmt;
	ResultSet rs;
	Connection conn;
	if(teno.getText().trim().equals("")==false)
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		                 	String url="jdbc:odbc:SQLITE";

		                 conn=DriverManager.getConnection(url);
	
			stmt=conn.createStatement();

			String sql="select * from emp where eno <"+Integer.parseInt(teno.getText())+" order by eno desc"; 

			rs=stmt.executeQuery(sql);

			if(rs.next())
				{
				teno.setText(""+rs.getString(1));
				tename.setText(rs.getString(2));
				}
			else
				{
				teno.setText("");
				tename.setText("");		
				}
			}
			catch(ClassNotFoundException e)
			{
			System.out.println(e);
			}
			catch(SQLException e1)
			{
			}
		}
		else
			{
			First();
			jop.showMessageDialog(null,"No More Rows Available","No More Rows Available",jop.PLAIN_MESSAGE);
			}
	} 	

    public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==bfirst)
		{
		First();
		}
	if(ae.getSource()==blast)
		{
		Last();	
		}
	if(ae.getSource()==bnext)
		{
		Next();
		}
	if(ae.getSource()==bprev)
		{
		Prev();	
		}
	if(ae.getSource()==bexit)
		{
		System.exit(0);
		}
	}
	
    public static void main(String args[]) {
        display window = new display();

        window.setTitle("DISPLAYING THE RECORDS ");
        window.pack();
        window.show();
    }
}

class displayLayout implements LayoutManager {

    public displayLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 354 + insets.left + insets.right;
        dim.height = 200 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+32,96,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+72,96,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+32,144,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+72,144,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+128,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+128,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+128,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+128,72,24);}
    }
}
