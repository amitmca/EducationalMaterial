import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;


	public class DropDatabase extends JInternalFrame implements ActionListener,ItemListener
	{

		private JPanel pNew = new JPanel();
		private JLabel select;
		private ImageIcon i;
		private JButton btn,cel;
		private JComboBox c1;
		private JButton btnOpen;
		public String str="";
		public static Login l;
		public static String u=l.u;
		public static String p=l.pass;

		public DropDatabase()
			{
			super ("Drop Database", false, true, false, true);
			i=new ImageIcon("images/cancel.PNG");
			setFrameIcon(i);
			
			btn=new JButton("Show All Databases",new ImageIcon(ClassLoader.getSystemResource("images\\views.PNG")));
			btn.setFont(new Font("verdana", Font.BOLD, 12));
			btn.setBounds(25,10,200,25);
			btn.addActionListener(this);
			Color c=new Color(220,249,255);
			btn.setBackground(c);
			pNew.add(btn);

			select=new JLabel("Select Database Name:");
			select.setFont(new Font("verdana", Font.BOLD, 12));
			select.setBounds(25,45,175,25);
			pNew.add(select);
			
			c1 = new JComboBox();
			c1.setFont(new Font("verdana", Font.BOLD, 12));
			c1.setEditable(false);
			c1.setBounds(25,75,200,25);
			c1.addItemListener(this);
			pNew.add(c1);

			btnOpen = new JButton ("Drop",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
			btnOpen.setFont(new Font("verdana", Font.BOLD, 12));
			btnOpen.setBounds(25,115,110,25);
			btnOpen.addActionListener(this);
			pNew.add(btnOpen);

			cel = new JButton ("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\s_error.PNG")));
			cel.setFont(new Font("verdana", Font.BOLD, 12));
			cel.setBounds(150,115,110,25);
			cel.addActionListener(this);
			pNew.add(cel);

			
			pNew.setLayout (null);
			
			pNew.setBackground(c);
			getContentPane().add (pNew);

			
			}
	  public void itemStateChanged(ItemEvent ie)
		{
		str=(String)ie.getItem();
		}

	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==btn)
			{
			
			try
			     {
			    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
			     String url="jdbc:odbc:mysql";
				
			     Connection conn=DriverManager.getConnection(url,"root","");

			     Statement st=conn.createStatement();
	
	  		     String sql="show databases";

   			     st.executeQuery(sql);

 			     ResultSet rs=st.executeQuery(sql);

			     String text=" ";

		             while(rs.next())
			        {
			        text=rs.getString(1);
			        c1.addItem(text);
			        }
			     }
			 catch(Exception e)
			     {
			     String str2=e.getMessage();
			     JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
			     }
			}
		
		 if(ae.getSource()==btnOpen)
			{
			c1.setEditable(true);
			try
			  {
			  Class.forName("com.mysql.jdbc.Driver");

  			  String url="jdbc:mysql://localhost:3306/";
				
			 Connection conn = DriverManager.getConnection(url,u,p);		 
 
		          Statement st=conn.createStatement();
			
		          String sql="Drop Database "+str;
	
  	 		  st.execute(sql);
			
			  String str3="Database Dropped:"+str;

			  JOptionPane.showMessageDialog(null,str3,str3,JOptionPane.INFORMATION_MESSAGE); 		
		
			  this.setClosed(true);	
			  }
			catch(Exception e)
			  {
			  String str2=e.getMessage();
			  JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
			  }
			}
   		  if(ae.getSource()==cel)
			{	
			this.setVisible(false);
			} 
		  } 
	
	}
