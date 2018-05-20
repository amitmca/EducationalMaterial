import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CreateView extends JInternalFrame implements ItemListener,ActionListener 
  {
    JLabel l1;
    JLabel l2;
    JComboBox dbcombo;
    JLabel l5;
    public static JTextArea textarea_1;
    JScrollPane sp_textarea_1;
    JButton btnalt;
    JButton btncel;
    public static String db="",viewname="";
    public static JTextField txtview;	
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;
	
    public CreateView()
	{
	super("Create New View");
	setLocation(275,120);
	ImageIcon i=new ImageIcon("images/db.View.16x16.PNG");
 	setFrameIcon(i);
        CreateViewLayout customLayout = new CreateViewLayout();

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

        l5 = new JLabel("Create View As");
	l5.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l5);

        textarea_1 = new JTextArea("");
	textarea_1.setFont(new Font("verdana",Font.BOLD,12));
        sp_textarea_1 = new JScrollPane(textarea_1);
        getContentPane().add(sp_textarea_1);

        btnalt = new JButton("Create",new ImageIcon(ClassLoader.getSystemResource("images\\homesearch.PNG")));
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

        setSize(getPreferredSize());
	Color c1=new Color(220,231,170);
	getContentPane().setBackground(c1);
       
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
	String a=textarea_1.getText();
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnalt)
		{
		if(viewname.equals("") || a.equals(""))
			{
			String str2="Please enter the fields";
			JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
			}
		else
			{
			try
			  {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url+db,"root","");	
			
			  Statement st=conn.createStatement();
	
		  	  String sql="Create view "+db+"."+viewname+" as "+a;
	
			  st.executeUpdate(sql);

			  String str1=viewname+" View Created";

			  txtview.setText("");
			  textarea_1.setText("");	

	 		  JOptionPane.showMessageDialog(null,str1,"View Created",JOptionPane.INFORMATION_MESSAGE); 		

	 		  }
			catch(Exception e)
			  {
		  	  String str2=e.getMessage();
			  JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
		  	  }
			}
		}
	}
}


class CreateViewLayout implements LayoutManager {

    public CreateViewLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 454 + insets.left + insets.right;
        dim.height = 201 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+96,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+88,320,48);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+160,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+160,120,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+32,152,24);}
    }
}
