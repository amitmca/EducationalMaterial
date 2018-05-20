import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Engines extends JInternalFrame implements ActionListener
{
    JTextArea txtengines;
    JScrollPane sp_txtengines;
    JLabel label_1;
    JButton btnok;
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;
 	
    public Engines() 
     {
	super ("Mysql Engines");
	setSize (280, 175);
	ImageIcon i=new ImageIcon("images/database_tools.PNG");
	setFrameIcon(i);
	setLocation(200,40);
        EnginesLayout customLayout = new EnginesLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        txtengines = new JTextArea("");
	txtengines.setFont(new Font("verdana", Font.BOLD, 13));
	txtengines.setEditable(false);
	txtengines.setForeground(Color.red);
	Color c=new Color(238,249,255);
	txtengines.setBackground(c);
        sp_txtengines = new JScrollPane(txtengines);
        getContentPane().add(sp_txtengines);

        label_1 = new JLabel("Mysql Engines");
	label_1.setForeground(Color.blue);
	label_1.setFont(new Font("verdana", Font.BOLD, 18));
        getContentPane().add(label_1);

        btnok = new JButton("Close",new ImageIcon(ClassLoader.getSystemResource("images\\s_error.PNG")));
	btnok.addActionListener(this);
	btnok.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(btnok);

        setSize(getPreferredSize());

	try
		  {
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");		
			
		  Statement st=conn.createStatement();
	
		  ResultSet rs=st.executeQuery("SHOW ENGINES");

		  String text=" ";

		  String title="   Engine\tSupport\tComment\n";

		  txtengines.setText(title);		

		  txtengines.append("==============================================================\n");


	          while(rs.next())
		     {
		     text=text + "  "+ rs.getString(1) +"\t  "+rs.getString(2) +"\t  "+rs.getString(3) +"\n\n";
		     }
		 txtengines.append(text);

		 }
		 catch(Exception e)
		 {
		 String str2=e.getMessage();
		 System.out.println(str2);
		 }
	Color c1=new Color(220,231,170);
	getContentPane().setBackground(c1);
    }
public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btnok)
		{
		this.setVisible(false);
		}
	}    
}

class EnginesLayout implements LayoutManager {

    public EnginesLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 643 + insets.left + insets.right;
        dim.height = 513 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,632,432);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,168,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+480,112,24);}
    }
}
