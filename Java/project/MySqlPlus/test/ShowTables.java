import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class ShowTables extends JInternalFrame implements ActionListener,ItemListener
{
    JLabel ldb;
    JComboBox dbcombo;
    JLabel ltable;
    JComboBox tablecombo;
    JButton btnok;
    ImageIcon i;
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;
	 
    public ShowTables() 
	{
	super("Show Tables");
        ShowTablesLayout customLayout = new ShowTablesLayout();
	i=new ImageIcon("images/tables.png");
	setFrameIcon(i);
	setLocation(300,30);

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ldb = new JLabel("Select Database Name :");
	ldb.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ldb);

        dbcombo = new JComboBox();
	dbcombo.setFont(new Font("verdana", Font.BOLD, 12));
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        ltable = new JLabel("Tables :");
	ltable.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(ltable);

        tablecombo = new JComboBox();
	tablecombo.setFont(new Font("verdana", Font.BOLD, 12));
	tablecombo.addItemListener(this);
        getContentPane().add(tablecombo);

        btnok = new JButton("OK",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
	btnok.setFont(new Font("verdana", Font.BOLD, 12));
	btnok.addActionListener(this);
        getContentPane().add(btnok);
	
	Color c=new Color(245,249,255);
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
				
					con=DriverManager.getConnection(url+db,"root","");

			DatabaseMetaData meta = con.getMetaData();
			
			tables="";

     			ResultSet res = meta.getTables(null, null, null, new String[] {"TABLE"});
			
			tablecombo.removeAllItems();

			while (res.next()) 
		  	{
	         	tables=res.getString("TABLE_NAME");
		  	tablecombo.addItem(tables);
		  	}
		     
		     
		    }
	       
 	   	catch (java.lang.ClassNotFoundException e)
    		    {
  	 	    String str=e.getMessage(); 			
                    JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);;
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
	if(ae.getSource()==btnok)
		{
		this.setVisible(false);
		}
	}   
   

		
}

class ShowTablesLayout implements LayoutManager {

    public ShowTablesLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 284 + insets.left + insets.right;
        dim.height = 234 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+192,112,24);}
    }
}
