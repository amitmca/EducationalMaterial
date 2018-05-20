import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class emp extends JFrame implements ActionListener
{
    JLabel leno;
    JLabel label_2;
    JTextField teno;
    JLabel lename;
    JTextField tname;
    JLabel lsalary;
    JTextField tsal;
    JLabel ldesig;
    JTextField tdesig;
    JButton bsave;
    JButton bshow;
    JButton bexit;
    JTextArea ta;
    JScrollPane sp_ta;

    JOptionPane jop;

    public emp() {
        empLayout customLayout = new empLayout();
	
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);


        leno = new JLabel("Employee Number");
	leno.setForeground(Color.blue);
        getContentPane().add(leno);

        label_2 = new JLabel("EMPLOYEE DETAILS");
	label_2.setForeground(Color.red);
	
        getContentPane().add(label_2);

        teno = new JTextField("");
	teno.setBackground(Color.yellow);
	teno.setFont(new Font("verdana",Font.BOLD,14));
        getContentPane().add(teno);

        lename = new JLabel("Employee Name");
	lename.setForeground(Color.blue);
        getContentPane().add(lename);

        tname = new JTextField("");
	tname.setBackground(Color.yellow);
	tname.setFont(new Font("verdana",Font.BOLD,14));
        getContentPane().add(tname);

        lsalary = new JLabel("Salary");
	lsalary.setForeground(Color.blue);
        getContentPane().add(lsalary);

        tsal = new JTextField("");
	tsal.setBackground(Color.yellow);
	tsal.setFont(new Font("verdana",Font.BOLD,14));
        getContentPane().add(tsal);

        ldesig = new JLabel("Designation");
	ldesig.setForeground(Color.blue);
        getContentPane().add(ldesig);

        tdesig = new JTextField("");
	tdesig.setBackground(Color.yellow);
	tdesig.setFont(new Font("verdana",Font.BOLD,14));
        getContentPane().add(tdesig);

        bsave = new JButton("SAVE");
        getContentPane().add(bsave);

        bshow = new JButton("SHOW");
        getContentPane().add(bshow);

        bexit = new JButton("EXIT");
        getContentPane().add(bexit);

        ta = new JTextArea("");
	ta.setBackground(Color.pink);
	ta.setFont(new Font("verdana",Font.BOLD,12));
        sp_ta = new JScrollPane(ta);
        getContentPane().add(sp_ta);

	bsave.addActionListener(this);
	bshow.addActionListener(this);
	bexit.addActionListener(this);

        setSize(getPreferredSize());
	
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

	public void actionPerformed(ActionEvent ae)
	{
	Connection conn;
	Statement stmt;
	
	if(ae.getSource()==bshow)
		{
		try
			{

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	
			String url="jdbc:odbc:wodbc";

			conn=DriverManager.getConnection(url,"","");
	
			String sql="select * from employee order by eno";
	
			stmt=conn.createStatement();
	
			ResultSet rs=stmt.executeQuery(sql);

			String text="";

			int count=0;

			while(rs.next())
				{
				
				text=text+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\n"; 
				ta.setText(text);
				++count;
				}
			//String p = Integer.toString(count);
			//String status="Total Rows"+" : "+count;
			//showStatus(status);
			}
		catch(Exception e)
			{
			}
		}

	if(ae.getSource()==bsave)
		{
		try
			{	
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:wodbc";
			conn=DriverManager.getConnection(url,"","");
			stmt=conn.createStatement();
			String no=teno.getText();
			String name=tname.getText();
			String sal=tsal.getText();
			String desig=tdesig.getText();
			
			if(no.equals("") || name.equals("") || sal.equals("") || desig.equals(""))
				{
				Toolkit.getDefaultToolkit().beep();	
				String str1 = "Please fill all the fields";
				jop.showMessageDialog(null,str1,str1, jop.ERROR_MESSAGE);
				}
			else
				{
				String sql1="insert into employee values('"+no+"','"+name+"','"+sal+"','"+desig+"')";
				stmt.executeUpdate(sql1);
				ta.setText("Record Is Added");
				}
			}
		catch(Exception e)
			{
			}
		}
	if(ae.getSource()==bexit)
		{
		progress m=new progress();
		emp e=new emp();
		m.setVisible(true);
		String str2 = "Are you sure ?";
		int r=jop.showConfirmDialog(null,str2,str2, jop.YES_NO_OPTION);
		if(r==jop.YES_OPTION)
			{
			e.setVisible(false);
			m.setVisible(false);
			System.exit(0);
			}
		else if(r==jop.NO_OPTION)
			{
			e.setVisible(true);
			}
		
		}
	}

    public static void main(String args[]) {
        emp window = new emp();
	window.setTitle("***** Employee Details *****");
      
        window.pack();
        window.show();
    }
}

class empLayout implements LayoutManager {

    public empLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 385 + insets.left + insets.right;
        dim.height = 385 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+64,160,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+24,168,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+64,96,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+104,160,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+104,96,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+144,160,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+144,96,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+184,160,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+184,96,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+224,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+224,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+304,insets.top+224,72,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+256,336,128);}
    }
}
