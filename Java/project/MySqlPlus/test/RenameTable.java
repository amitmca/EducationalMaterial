import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RenameTable extends JInternalFrame implements ActionListener,ItemListener
   {
    JLabel ldb;
    JComboBox dbcombo;
    JLabel ltable;
    JComboBox tablecombo;
    JLabel newtable;
    JTextField ntable;
    JButton btnren;
    JButton btncel;
    public static String db="",tables="",table="",newname="",col_name=""; 	
    public static int col=0;
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;


    public RenameTable()
	{
	super("Rename Table");
	setLocation(275,120);
	ImageIcon i=new ImageIcon("images/b_browse.PNG");
 	setFrameIcon(i);

        RenameTableLayout customLayout = new RenameTableLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ldb = new JLabel("Select Database Name :");
	ldb.setForeground(Color.red);
	ldb.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ldb);

        dbcombo = new JComboBox();
	dbcombo.addItemListener(this);
	dbcombo.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(dbcombo);

        ltable = new JLabel("Select Table Name :");
	ltable.setForeground(Color.red);
	ltable.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ltable);

        tablecombo = new JComboBox();
	tablecombo.addItemListener(this);
	tablecombo.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(tablecombo);

        newtable = new JLabel("New Table Name :");
	newtable.setForeground(Color.red);
	newtable.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(newtable);

        ntable = new JTextField("");
	ntable.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ntable);

        btnren = new JButton("Rename",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
	btnren.addActionListener(this);
	btnren.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(btnren);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.addActionListener(this);
	btncel.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(btncel);

	Color c=new Color(220,249,255);
	getContentPane().setBackground(c);
        setSize(getPreferredSize());
     }
public void itemStateChanged(ItemEvent ie)
	{	
	if(ie.getSource()==dbcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
		{
		db=(String)dbcombo.getSelectedItem();
		Connection con = null;
		try 
    		   {
			Class.forName("com.mysql.jdbc.Driver");

			String url="jdbc:mysql://localhost:3306/"+db;
			
                	con = DriverManager.getConnection(url,u,p);

			DatabaseMetaData meta = con.getMetaData();
			
			tables="";

     			ResultSet res = meta.getTables(null, null, null, new String[] {"TABLE"});
			
			tablecombo.removeAllItems();

			while (res.next()) 
		  	{
	         	tables=res.getString("TABLE_NAME");
		  	tablecombo.addItem(tables);
			repaint();
		  	}
		     
		     
		    }
	       
 	   	catch (java.lang.ClassNotFoundException e)
    		    {
  	 	    String str=e.getMessage(); 			
		    JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);
		    }
 		catch (SQLException e) 
     		    {
		    String str=e.getMessage(); 			
                    JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);
		    }
		}
		}
	if(ie.getSource()==tablecombo)
		{
		   if(ie.getStateChange()==ItemEvent.SELECTED)
		   {
		   table=(String)ie.getItem();
 		   }
		}
	}
public void actionPerformed(ActionEvent ae)

	{	
	Connection con = null;
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnren)
		{
		newname=ntable.getText();
		if(newname.equals(""))
			{
			JOptionPane.showMessageDialog(null,"Please enter New Table Name","ERROR",JOptionPane.ERROR_MESSAGE); 					
			}
		else
			{
			try
  		  	  {
			  Class.forName("com.mysql.jdbc.Driver");

		  	  String url="jdbc:mysql://localhost:3306/";
			
        	          con = DriverManager.getConnection(url+db,u,p);

			  Statement stmt=con.createStatement();

			  String sql="rename table "+table+" to "+newname;

			  String r="Table name "+table+" Changed to "+newname;	

			  stmt.executeUpdate(sql);

			  JOptionPane.showMessageDialog(null,r,"Rename Done",JOptionPane.INFORMATION_MESSAGE); 					
			  }	
			catch(Exception e)
		  	  {
		 	  String str=e.getMessage(); 			
			  JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);		
   			  }
			}
		}
	}
}

class RenameTableLayout implements LayoutManager {

    public RenameTableLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 399 + insets.left + insets.right;
        dim.height = 221 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+32,184,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+32,144,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+80,184,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+80,144,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+128,184,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+128,144,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+176,128,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+176,120,24);}
    }
}
