import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DropUser extends JInternalFrame implements ActionListener,ItemListener
{
    JLabel label_1;
    JLabel label_2;
    JComboBox usrcombo;
    JButton btndrop;
    JButton btncel;
    public static String usr="";
    public static Login lr;
    public static String u=lr.u;
    public static String p=lr.pass;	

    public DropUser()
        {
	super("Drop User");
        DropUserLayout customLayout = new DropUserLayout();
        setLocation(275,120);
	ImageIcon i3=new ImageIcon("images/b_usrdrop.PNG");
 	setFrameIcon(i3);
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ImageIcon i=new ImageIcon("images/login.gif");  
        label_1 = new JLabel(i);
        getContentPane().add(label_1);

        label_2 = new JLabel("Select User Name :");
	label_2.setFont(new Font("verdana",Font.BOLD,12));	
	label_2.setForeground(Color.red);
        getContentPane().add(label_2);

        usrcombo = new JComboBox();
	usrcombo.setBackground(Color.white);
	usrcombo.setForeground(Color.red);
	usrcombo.setFont(new Font("verdana", Font.BOLD, 12));	
	usrcombo.addItemListener(this);
        getContentPane().add(usrcombo);

        btndrop = new JButton("Drop",new ImageIcon(ClassLoader.getSystemResource("images\\upper_search_button.gif")));
	btndrop.addActionListener(this);
	btndrop.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btndrop);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
        btncel.addActionListener(this);
	btncel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btncel);

	Color c=new Color(238,249,255);
	getContentPane().setBackground(c);
        setSize(getPreferredSize());
         
    }
public void itemStateChanged(ItemEvent ie)
	{
	if(ie.getSource()==usrcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			usr=(String)ie.getItem();
			}
		}
	}

public void actionPerformed (ActionEvent ae) 
     {	
     if(ae.getSource()==btncel)
	{
	this.setVisible(false);		
	}
     if(ae.getSource()==btndrop)
	{
	try
  		  {
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url,"root","");

		  Statement stmt=con.createStatement();

		  String sql="drop user "+usr;

		  String sql1="drop user "+usr+"@localhost";	

		  stmt.executeUpdate(sql1); 	

		  stmt.executeUpdate(sql);

		  String str2="User "+usr+" Dropped";

		  JOptionPane.showMessageDialog(null,str2,"Dropped",JOptionPane.INFORMATION_MESSAGE); 				

		  usrcombo.removeAllItems();	
	 	  }
		catch(Exception e)
		  {
		  String str2=e.getMessage();
		  JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 				
   		  } 	
	}
     }
   }

class DropUserLayout implements LayoutManager {

    public DropUserLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 320 + insets.left + insets.right;
        dim.height = 176 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+48,32,32);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+56,136,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+56,128,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+120,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+120,128,24);}
    }
}
