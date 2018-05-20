import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Describe extends JInternalFrame implements ItemListener,ActionListener
 {
    JLabel la;
    JLabel l1;
    JLabel label_2;
    JComboBox dbcombo;
    JComboBox tablecombo;
    JButton btnshow;
    JButton btncel;
    JTextArea data;
    JScrollPane sp_data;
    public static String db="";		
    public static String tables="",table="",sorttype="",type="",type1="";
    public static JTextField t[];
    public static String col_name="";
    public static int col=0;
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;	

    public Describe()
        {
	super("Describe Table");
	ImageIcon i2=new ImageIcon("images/logview.PNG");
	setFrameIcon(i2);
	setLocation(200,30);
        DescribeLayout customLayout = new DescribeLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

       
        la = new JLabel("Select Database Name :");
	la.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(la);

        l1 = new JLabel("Select Table Name :");
	l1.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(l1);

        label_2 = new JLabel("");
        getContentPane().add(label_2);

	dbcombo = new JComboBox();
	dbcombo.setBackground(Color.white);
	dbcombo.setForeground(Color.red);
	dbcombo.setFont(new Font("verdana", Font.BOLD, 12));	
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        tablecombo = new JComboBox();
	tablecombo.setBackground(Color.white);
	tablecombo.setFont(new Font("verdana", Font.BOLD, 12));
	tablecombo.setForeground(Color.red);
	tablecombo.addItemListener(this);
        getContentPane().add(tablecombo);

        btnshow = new JButton("Show",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
	btnshow.addActionListener(this);
        getContentPane().add(btnshow);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

        data = new JTextArea("");
	data.setEditable(false);
	sp_data = new JScrollPane(data);
        getContentPane().add(sp_data);

	Color c=new Color(238,249,255);
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
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnshow)
		{
		Connection con = null;
		try 
    		   {
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url+db,"root","");

		   Statement st=con.createStatement();
		
		   String sql="describe "+db+"."+table; 

		   ResultSet rs=st.executeQuery(sql);
		   
	           ResultSetMetaData md = rs.getMetaData();

		   col = md.getColumnCount();

		   String str[]=new String[50];
		   int k=0;
		   String r1="";
 
		   for (int j = 1; j <= col; j++)
                         {
			 String col_name = md.getColumnName(j);
			 r1=r1+col_name+"\t";
			 }
		   r1=r1+"\n";	
	 	   data.setFont(new Font("verdana", Font.BOLD, 14));
		   Color c1=new Color(220,231,170);
		   data.setBackground(c1);
	  	   data.setForeground(Color.red);
   		   data.append("\n===================================================================================\n");		 
		   data.setText(r1);	
		   data.append("====================================================================================\n");
		   String r="";	
		   while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=r + rs.getString(i)+"\t";
		       	  }  
			 r=r+"\n";
			 data.append(r);
			} 
   		   data.append("=====================================================================================\n");	
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

}

class DescribeLayout implements LayoutManager {

    public DescribeLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 522 + insets.left + insets.right;
        dim.height = 542 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+24,160,16);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+24,160,16);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+24,72,16);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+48,160,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+48,160,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+504,104,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+288,insets.top+504,112,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+88,496,408);}
    }
}
