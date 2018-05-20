import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class DropTable extends JInternalFrame implements ActionListener,ItemListener
 {
    JLabel ldb;
    JComboBox dbcombo;
    JLabel ltable;
    JComboBox tablecombo;
    JButton btndrop;
    JButton btncel;
    String table="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;	

    public DropTable() 
	{
	super("Drop Table");
        DropTableLayout customLayout = new DropTableLayout();
	setLocation(300,30);

	ImageIcon i=new ImageIcon("images/droptable.PNG");
 	setFrameIcon(i);

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ldb = new JLabel("Select Database Name :");
	ldb.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ldb);

        dbcombo = new JComboBox();
	dbcombo.setFont(new Font("verdana", Font.BOLD, 12));
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        ltable = new JLabel("Select Table Name :");
	ltable.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ltable);

        tablecombo = new JComboBox();
	tablecombo.setFont(new Font("verdana", Font.BOLD, 12));
	tablecombo.addItemListener(this);
        getContentPane().add(tablecombo);

        btndrop = new JButton("Drop",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
	btndrop.setFont(new Font("verdana", Font.BOLD, 12));
	btndrop.addActionListener(this);
        getContentPane().add(btndrop);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana", Font.BOLD, 12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

	Color c=new Color(220,231,239);
	getContentPane().setBackground(c);
	setSize(getPreferredSize());

       }

public void itemStateChanged(ItemEvent ie)
	{
	String db="";
	String tables="";
	if(ie.getSource()==dbcombo)
		{
		db=(String)dbcombo.getSelectedItem();
		Connection con = null;
		try 
    		   {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url+db,"root","");

			DatabaseMetaData meta = con.getMetaData();
			
			tables="";

     			ResultSet res = meta.getTables(null, null, null, new String[] {"TABLE"});

			tablecombo.removeAllItems();

			while (res.next()) 
		  	{
	         	tables=res.getString("TABLE_NAME");
		  	tablecombo.addItem(tables);
		  	}
		     table=(String)tablecombo.getSelectedItem();
		     
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
public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btndrop)
		{
		String db=(String)dbcombo.getSelectedItem();
		try 
    		   {
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection con=DriverManager.getConnection(url+db,"root","");

		   Statement st=con.createStatement();
	
		   String sql="drop table "+table; 

		   st.executeUpdate(sql);

		   String msg="Table Dropped :"+table;	

		   JOptionPane.showMessageDialog(null,msg,msg,JOptionPane.INFORMATION_MESSAGE); 					
		   }
		catch (java.lang.ClassNotFoundException e)
    		    {
  	 	    String msg="Please check the Mysql Service is running or not";	

		    JOptionPane.showMessageDialog(null,msg,"Error",JOptionPane.ERROR_MESSAGE); 
		    	
    		    }
 		catch (SQLException e) 
     		    {
		    String msg=e.getMessage();	

		    JOptionPane.showMessageDialog(null,msg,"Error",JOptionPane.ERROR_MESSAGE); 
		    }	
		
		}
	}   
		 
}

class DropTableLayout implements LayoutManager {

    public DropTableLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 297 + insets.left + insets.right;
        dim.height = 244 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+24,216,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+64,168,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+104,216,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+144,168,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+192,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+192,112,24);}
    }
}
