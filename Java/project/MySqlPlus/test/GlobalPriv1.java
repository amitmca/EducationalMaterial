import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class GlobalPriv1 extends JInternalFrame implements ActionListener,ItemListener
  {
    JLabel label_1;
    JComboBox usrcombo;
    JLabel label_2;
    JLabel label_3;
    JTextArea prev;
    JScrollPane sp_prev;
    JButton btngrant;
    JButton btncel;
    public static String usr="";	
    public static Login lr;
    public static String u=lr.u;
    public static String p=lr.pass;
    Color c=new Color(238,249,255);

    public GlobalPriv1() 
	{
	super("Revoke Global Level Privileges");
	setLocation(350,100);
	ImageIcon i=new ImageIcon("images/feeds.png");
 	setFrameIcon(i);
        GlobalPriv1Layout customLayout = new GlobalPriv1Layout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Select User Name :");
	label_1.setFont(new Font("verdana",Font.BOLD,12));	
	label_1.setForeground(Color.red);	
        getContentPane().add(label_1);

        usrcombo = new JComboBox();
	usrcombo.setBackground(Color.white);
	usrcombo.setForeground(Color.red);
	usrcombo.setFont(new Font("verdana", Font.BOLD, 12));	
	usrcombo.addItemListener(this);
        getContentPane().add(usrcombo);

	ImageIcon i1=new ImageIcon("images/login.gif");  
        label_2 = new JLabel(i1);
        getContentPane().add(label_2);

        
        label_3 = new JLabel("Privilege Statement :");
	label_3.setFont(new Font("verdana",Font.BOLD,12));	
	label_3.setForeground(Color.red);
        getContentPane().add(label_3);

        prev = new JTextArea("");
        sp_prev = new JScrollPane(prev);
	prev .setForeground(Color.red);
	prev .setFont(new Font("verdana", Font.BOLD, 12));
	prev.setEditable(false);
        getContentPane().add(sp_prev);

        btngrant = new JButton("Revoke",new ImageIcon(ClassLoader.getSystemResource("images\\submitS.png")));
	btngrant.addActionListener(this);
	btngrant.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btngrant);
	
        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.png")));
	btncel.addActionListener(this);
	btncel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btncel);

	
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
     String with="";	
     if(ae.getSource()==btncel)
	{
	this.setVisible(false);		
	}
     if(ae.getSource()==btngrant)
	{
	try
	   {
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			
	   Statement st=conn.createStatement();

	   String sql="revoke all on *.* from "+usr+"@localhost ";

	   prev.setText(sql);	

	   st.executeUpdate(sql);

	   String str="Revoked";

	   JOptionPane.showMessageDialog(null,str,"Revoke",JOptionPane.INFORMATION_MESSAGE); 				

	   prev.setText("");

	   usrcombo.removeAllItems();		
	   }
	catch(Exception e)
	   {
	   String str2=e.getMessage();
	   JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
	   }
	}		
     }
}

class GlobalPriv1Layout implements LayoutManager {

    public GlobalPriv1Layout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 499 + insets.left + insets.right;
        dim.height = 284 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+48,176,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+48,152,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+40,32,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+152,168,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+144,288,56);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+232,120,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+232,128,24);}
    }
}
