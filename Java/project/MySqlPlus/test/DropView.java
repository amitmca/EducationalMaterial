import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DropView extends JInternalFrame implements ItemListener,ActionListener 
 {
    JLabel l1;
    JLabel l2;
    JComboBox dbcombo;
    JButton btnalt;
    JButton btncel;
    JTextField txtview;
    public static String db="",viewname="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass; 
	
    public DropView() 
	{
	super("Drop View");
	setLocation(275,120);
	ImageIcon i=new ImageIcon("images/db.View.16x16.PNG");
 	setFrameIcon(i);

        DropViewLayout customLayout = new DropViewLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        l1 = new JLabel("Select Database Name :");
	l1.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l1);

        l2 = new JLabel("View Name :");
	l2.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l2);

        dbcombo = new JComboBox();
	dbcombo.setFont(new Font("verdana",Font.BOLD,12));
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

	btnalt = new JButton("Drop",new ImageIcon(ClassLoader.getSystemResource("images\\homesearch.PNG")));
	btnalt.setFont(new Font("verdana",Font.BOLD,12));
	btnalt.addActionListener(this);
        getContentPane().add(btnalt);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana",Font.BOLD,12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

        txtview = new JTextField("");
	txtview.setFont(new Font("verdana",Font.BOLD,12));
	txtview.setForeground(Color.red);
        getContentPane().add(txtview);

	Color c1=new Color(220,231,170);
	getContentPane().setBackground(c1);
        setSize(getPreferredSize());
    }
 public void itemStateChanged(ItemEvent ie)
	{

	if(ie.getSource()==dbcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			db=(String)dbcombo.getSelectedItem();
			}
		}
	}
	public void actionPerformed(ActionEvent ae)
	{	
	viewname=txtview.getText();

	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnalt)
		{
		if(viewname.equals(""))
			{
			String str2="Please enter the View Name";
			JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
			}
		else
			{
			try
			  {
			  Class.forName("com.mysql.jdbc.Driver");
				
			  String url="jdbc:mysql://localhost:3306/"+db;
				
			  Connection conn = DriverManager.getConnection(url,u,p);		
			
			  Statement st=conn.createStatement();
	
		  	  String sql="Drop view "+db+"."+viewname;
	
			  st.executeUpdate(sql);

			  String str1=viewname+" View Dropped";

			  txtview.setText("");

	 		  JOptionPane.showMessageDialog(null,str1,"View Dropped",JOptionPane.INFORMATION_MESSAGE); 		

	 		  }
			catch(Exception e)
			  {
		  	  String str2=e.getMessage();
			  JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		  	  }
			}
		}
	}

   
}

class DropViewLayout implements LayoutManager {

    public DropViewLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 454 + insets.left + insets.right;
        dim.height = 124 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,176,16);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+8,184,16);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+32,160,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+88,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+88,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+32,152,24);}
    }
}
