import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;


	public class Open extends JInternalFrame implements ActionListener,ItemListener
	{

		private JPanel pNew = new JPanel();
		private JLabel select;
		private ImageIcon i;
		private JButton btn,cel;
		private JComboBox c1;
		private JButton btnOpen;
		public String str="";
	
		public Open ()
			{
			super ("Open an Existing Database", false, true, false, true);
			i=new ImageIcon("images/def.PNG");
			setFrameIcon(i);
			
			btn=new JButton("Show All Databases",new ImageIcon(ClassLoader.getSystemResource("images\\views.PNG")));
			btn.setBounds(25,10,200,25);
			btn.addActionListener(this);
			btn.setBackground(Color.yellow);
			pNew.add(btn);

			select=new JLabel("Select Database Name:");
			select.setBounds(25,45,150,25);
			pNew.add(select);
			
			c1 = new JComboBox();
			c1.setEditable(false);
			c1.setBounds(25,75,200,25);
			c1.addItemListener(this);
			pNew.add(c1);

			btnOpen = new JButton ("Open",new ImageIcon(ClassLoader.getSystemResource("images\\def.PNG")));
			btnOpen.setBounds(25,115,110,25);
			btnOpen.addActionListener(this);
			pNew.add(btnOpen);

			cel = new JButton ("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\s_error.PNG")));
			cel.setBounds(150,115,110,25);
			cel.addActionListener(this);
			pNew.add(cel);
			
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
		if(ae.getSource()==btn)
			{
			
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
			
			c1.setEditable(true);
			
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
		  if(ae.getSource()==cel)
			{	
			this.setVisible(false);
			}
		  } 
	
	}
