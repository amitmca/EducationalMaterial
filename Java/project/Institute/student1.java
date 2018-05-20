import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class student1 extends JFrame implements ActionListener

	{
    JLabel lname;
    JLabel laddr;
    JLabel lcontact;
    JLabel lgender;
    JTextField tname;
    JTextArea taddr;
    JScrollPane sp_taddr;
    JTextField tcontact;
    ButtonGroup cbg;
    JRadioButton rmale;
    JRadioButton rfemale;
    JButton bsubmit;
    JButton breset;
    JLabel mess;
    JButton bclose;
    ImageIcon icon;
    JOptionPane jop;
    
    public student1() 
	{
	this.setTitle("Student Information");
	this.setBackground(Color.pink);
        studentLayout customLayout = new studentLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        lname = new JLabel("Name");
        getContentPane().add(lname);

        laddr = new JLabel("Adress");
        getContentPane().add(laddr);

        lcontact = new JLabel("Contact");
        getContentPane().add(lcontact);

        lgender = new JLabel("Gender");
        getContentPane().add(lgender);

        tname = new JTextField("");
        getContentPane().add(tname);

        taddr = new JTextArea("");
        sp_taddr = new JScrollPane(taddr);
        getContentPane().add(sp_taddr);

        tcontact = new JTextField("");
        getContentPane().add(tcontact);

        cbg = new ButtonGroup();
        rmale = new JRadioButton("Male", false);
        cbg.add(rmale);
        getContentPane().add(rmale);

        rfemale = new JRadioButton("Female", false);
        cbg.add(rfemale);
        getContentPane().add(rfemale);

        bsubmit = new JButton("SUBMIT");
        getContentPane().add(bsubmit);

        breset = new JButton("RESET");
        getContentPane().add(breset);

	icon = new ImageIcon("serbot.gif");
	mess = new JLabel(icon);
        getContentPane().add(mess);

        bclose = new JButton("CLOSE");
        getContentPane().add(bclose);

	bsubmit.addActionListener(this);
	breset.addActionListener(this);
	bclose.addActionListener(this);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==bclose)
		{
		System.exit(0);
		}
	if(ae.getSource()==breset)
		{
		tname.setText("");
		taddr.setText("");
		tcontact.setText("");
		
		}	
	if(ae.getSource()==bsubmit)
		{
		String name="",addr="",contact="",gender="";
		name=tname.getText();
		addr=taddr.getText();
		contact=tcontact.getText();

		String mess1=" ",s1;
		Connection con1=null;
		Statement stmt;

		if(name.equals("") || addr.equals("") || contact.equals(""))
			{
			Toolkit.getDefaultToolkit().beep();	
			String str1 = "Please fill all the fields";
			jop.showMessageDialog(null,str1,str1, jop.ERROR_MESSAGE);
			}
		else
			{
			
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String url="jdbc:odbc:SQLITE";
			con1=DriverManager.getConnection(url," "," ");
			stmt=con1.createStatement();
			s1="insert into stud values('"+name+"',"+"'"+addr+"',"+"'"+contact+"',"+"'"+gender+"')";
			stmt.executeUpdate(s1);
			Msgadd ad=new Msgadd("");
			ad.setVisible(true);
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
		}
	}

    public static void main(String args[]) {
        student window = new student();

        window.setTitle("Student Information");
        window.pack();
        window.show();
    }
}

class studentLayout implements LayoutManager {

    public studentLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 513 + insets.left + insets.right;
        dim.height = 326 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+56,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+96,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+136,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+176,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+56,232,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+88,232,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+136,88,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+176,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+304,insets.top+176,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+216,104,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+216,72,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+8,216,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+216,96,24);}
    }
}
