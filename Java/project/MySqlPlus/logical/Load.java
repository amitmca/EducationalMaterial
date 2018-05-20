import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;


	public class Load extends JInternalFrame implements ActionListener,ItemListener
	{

		private JPanel pNew = new JPanel();
		private JLabel dbname,select;
		private JTextField txtdbname;
		private ImageIcon i;
		private JRadioButton create,open;
		private ButtonGroup bg;
		private JComboBox c1;
		private JButton btnCreate,btnOpen;
		public String str="";
	
		public Load ()
			{
			super ("Databases", false, true, false, true);
			i=new ImageIcon("images/database.PNG");
			setFrameIcon(i);
					
			create=new JRadioButton("Create New Database");
			create.setBounds(25,20,250,25);	
			create.setBackground(Color.yellow);
			create.addActionListener(this);
			pNew.add(create);
			
			open=new JRadioButton("Open an Existing Database");
			open.setBounds(25,50,250,25);	
			open.setBackground(Color.yellow);
			open.addActionListener(this);
			pNew.add(open);

			bg=new ButtonGroup();	
			bg.add(create);
			bg.add(open);

			dbname=new JLabel("Database Name:");
			dbname.setBounds(25,80,250,25);
			pNew.add(dbname);
			
			txtdbname=new JTextField();
			txtdbname.setBounds(25,100,200,25);
			txtdbname.setEditable(false);
			pNew.add(txtdbname);

			btnCreate = new JButton ("Create",new ImageIcon(ClassLoader.getSystemResource("images\\s_okay.PNG")));
			btnCreate.setBounds(45,130,125,25);
			btnCreate.setEnabled(false);
			btnCreate.addActionListener(this);
			pNew.add(btnCreate);	

			select=new JLabel("Select Database Name:");
			select.setBounds(25,160,250,25);
			pNew.add(select);
			
			c1 = new JComboBox();
			c1.setEditable(false);
			c1.setBounds(25,190,200,25);
			c1.addItemListener(this);
			pNew.add(c1);

			btnOpen = new JButton ("OPen",new ImageIcon(ClassLoader.getSystemResource("images\\def.PNG")));
			btnOpen.setBounds(45,225,125,25);
			btnOpen.setEnabled(false);
			btnOpen.addActionListener(this);
			pNew.add(btnOpen);
			
			pNew.setLayout (null);
			pNew.setBackground(Color.yellow);
			getContentPane().add (pNew);
			}
	  public void itemStateChanged(ItemEvent ie)
		{
		
		try
			{
			Class.forName("com.mysql.jdbc.Driver");

		        String url="jdbc:mysql://localhost:3306/";
				
 		        Connection conn=DriverManager.getConnection(url,"root","amit12");		

		        Statement st=conn.createStatement();
			
			str=(String)ie.getItem();

	 	        String sql="use "+str;
	
  		        st.execute(sql);
		
			}
		catch(Exception e)
			{
			String str2=e.getMessage();
			JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			}
		}

	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==create)
			{
			txtdbname.setEditable(true);
			c1.setEditable(false);
			btnCreate.setEnabled(true);
			}
		if(ae.getSource()==btnCreate)
			{
			String dname=txtdbname.getText();
			if(dname.equals(""))
				{
				Toolkit.getDefaultToolkit().beep();	
				JOptionPane.showMessageDialog(null,"Please enter Database Name","Please enter Database Name",JOptionPane.ERROR_MESSAGE);
				}
			else
			{
			try
			   {
			   Class.forName("com.mysql.jdbc.Driver");

  			   String url="jdbc:mysql://localhost:3306/";
				
			   Connection conn=DriverManager.getConnection(url,"root","amit12");				
			
			   Statement st=conn.createStatement();
	
			   String sql="Create Database "+dname;
	
	  		   st.execute(sql);
		
		  	   String str1="Database Created :  "+dname;

 			   JOptionPane.showMessageDialog(null,str1,str1,JOptionPane.INFORMATION_MESSAGE); 		
		
			   this.setClosed(true);	
				
  			   }
			catch(Exception e)
			   {
			   String str2=e.getMessage();
			   JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			   }
			 }
			}	
		else if(ae.getSource()==open)
			{
			txtdbname.setEditable(false);
			c1.setEditable(true);	
			btnOpen.setEnabled(true);
			try
			     {
			     Class.forName("com.mysql.jdbc.Driver");

  			     String url="jdbc:mysql://localhost:3306/";
				
			     Connection conn=DriverManager.getConnection(url,"root","amit12");				
			
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
			     JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			     }
			}
		 	
		  if(ae.getSource()==btnOpen)
			{
			txtdbname.setEditable(false);
			c1.setEditable(true);
			btnCreate.setEnabled(false);
			btnOpen.setEnabled(true);
			try
				{
				String str2="Using "+str+".....";	
				JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.INFORMATION_MESSAGE); 		
				this.setClosed(true);
				}
			catch(Exception e)
				{
				}
			}
		  } 	
	     
	}
