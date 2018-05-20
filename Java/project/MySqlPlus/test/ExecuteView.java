import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ExecuteView extends JInternalFrame implements ItemListener,ActionListener 
{
    JLabel l1;
    JLabel l2;
    JComboBox dbcombo;
    JTextArea textarea_1;
    JScrollPane sp_textarea_1;
    JButton btnalt;
    JButton btncel;
    JTextField txtview;
    JButton btnclr;
    public static int col=0;  
    public static String db="",viewname="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;

    public ExecuteView() 
	{
	super("Execute View");
	setLocation(275,75);
	ImageIcon i=new ImageIcon("images/db.View.16x16.PNG");
 	setFrameIcon(i);

        ExecuteViewLayout customLayout = new ExecuteViewLayout();

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

        textarea_1 = new JTextArea("");
	textarea_1.setFont(new Font("verdana",Font.BOLD,12));
        sp_textarea_1 = new JScrollPane(textarea_1);
        getContentPane().add(sp_textarea_1);
        
        btnalt = new JButton("Execute",new ImageIcon(ClassLoader.getSystemResource("images\\homesearch.PNG")));
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

        btnclr = new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("images\\def.PNG")));
	btnclr.setFont(new Font("verdana",Font.BOLD,12));
	btnclr.addActionListener(this);
        getContentPane().add(btnclr);

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
	
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnalt)
		{
		if(viewname.equals(""))
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
	
		  	  String sql="select * from "+db+"."+viewname;
	
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

		   textarea_1.setForeground(Color.red);
   		   textarea_1.append("\n==========================================================\n");		 
		   textarea_1.setText(r1);	
		   textarea_1.append("============================================================\n");
		   String r="";	
		   while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=r + rs.getString(i)+"\t";
		       	  }  
			 r=r+"\n";
			 textarea_1.append(r);
			} 
   		   textarea_1.append("===========================================================================\n");				  
	 		  }
			catch(Exception e)
			  {
		  	  String str2=e.getMessage();
			  JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
		  	  }
			}
		}
	if(ae.getSource()==btnclr)
		{
		txtview.setText("");
		textarea_1.setText("");
		}
	}
   
}

class ExecuteViewLayout implements LayoutManager {

    public ExecuteViewLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 437 + insets.left + insets.right;
        dim.height = 504 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+8,152,16);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+32,160,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+72,424,384);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+472,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+472,120,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+32,152,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+472,128,24);}
    }
}
