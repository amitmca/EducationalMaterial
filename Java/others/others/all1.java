import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
import java.sql.*;

public class all1 extends Applet implements ActionListener
 {
    JLabel leno;
    JLabel lename;
    JTextField t1;
    JTextField t2;
    JButton bsave;
    JButton bexit;
    JTextArea ta;
    JScrollPane sp_ta;
    JButton bshow;
   


    public void init() 
	{
        all1Layout customLayout = new all1Layout();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
	

        setLayout(customLayout);
	setBackground(Color.pink);
        leno = new JLabel(" NO");
        add(leno);

        lename = new JLabel("NAME");
        add(lename);

        t1 = new JTextField("");
        add(t1);

        t2 = new JTextField("");
        add(t2);

        bsave = new JButton("SAVE");
        add(bsave);

        bexit = new JButton("EXIT");
        add(bexit);

        ta = new JTextArea("",30,70);
        sp_ta = new JScrollPane(ta);
        add(sp_ta);

        bshow = new JButton("SHOW");
        add(bshow);
	
	bsave.addActionListener(this);
	bshow.addActionListener(this);
	bexit.addActionListener(this);

        setSize(getPreferredSize());

       }

   public void actionPerformed(ActionEvent e)
	{
	 Connection con1=null;
	 Statement stmt;
	 String val,mess1="",s1;

	if(e.getSource()==bsave)
		{
		try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:SQLITE";
			con1=DriverManager.getConnection(url," "," ");
			stmt=con1.createStatement();
			String eno=t1.getText();
			String ename=t2.getText();
			s1="insert into emp values('"+eno+"',"+"'"+ename+"')";
			stmt.executeUpdate(s1);
			val="Record Added";
			ta.setText(val);
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
	if(e.getSource()==bexit)
		{
		this.setVisible(false);
		}
	if(e.getSource()==bshow)
		{
		try
			{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			String text=new String();
					
			con1=DriverManager.getConnection(url,"","");

			stmt=con1.createStatement();

			String sql="select * from emp order by eno";

			ResultSet rs=stmt.executeQuery(sql);

			int count=0;
			ta.setFont(new Font("verdana",Font.BOLD,16));
			while(rs.next())
				{
				text=text + rs.getString(1) +"     |    " + rs.getString(2) + "\n";
				ta.setText(text);
				
				count++;
				}
			String p = Integer.toString(count);
			ta.setFont(new Font("verdana",Font.BOLD,20));
			ta.append("Total Rows"+" : "+p);
			rs.close();
			}
		catch(Exception e1)
			{
			System.out.println(e1);
			}
		}
	}

    public static void main(String args[]) {
        all1 applet = new all1();
        Frame window = new Frame("all1");

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        applet.init();
        window.add("Center", applet);
        window.pack();
        window.setVisible(true);
    }
}

class all1Layout implements LayoutManager {

    public all1Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 275 + insets.left + insets.right;
        dim.height = 302 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+16,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+56,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+16,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+56,96,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+96,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+96,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+160,216,104);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+104,insets.top+96,72,24);}
    }
}
