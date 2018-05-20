import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

	public class ShowUsers extends JInternalFrame implements ActionListener
	{

		private JPanel pNew = new JPanel();
		private JTextArea ta;
		private JButton btnShow, btnCancel;
		private long id=0;
		private ImageIcon i;		
                public static Login l;
		public static String u=l.u;	
		public static String p=l.pass;

		public ShowUsers ()
			 {

			
			super ("Show Users", false, true, false, true);
			setSize (375, 375);
			i=new ImageIcon("images/b_usrlist.PNG");
			setFrameIcon(i);
			setLocation(250,100);
		
			ta=new JTextArea("",10,30);
			ta.setFont(new Font("verdana",Font.BOLD,12));
			ta.setBounds (35, 35, 300, 250);    
		        ta.setEditable(false);
			ta.setForeground(Color.blue);

			btnShow = new JButton ("SHOW",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
			btnShow.setFont(new Font("verdana",Font.BOLD,12));
			btnShow.setBounds (75, 285, 100, 25);
			btnShow.addActionListener (this);

			btnCancel = new JButton ("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
			btnCancel.setFont(new Font("verdana",Font.BOLD,12));
			btnCancel.setBounds (175, 285, 100, 25);
			btnCancel.addActionListener (this);


			try
				{
				setMaximum(true);
				
				}
			catch(Exception e)
				{
				}


			pNew.setLayout (null);
			pNew.add (ta);
			pNew.add (btnShow);
			pNew.add (btnCancel);
			Color c=new Color(220,249,255);
			pNew.setBackground(c);
			getContentPane().add (pNew);
			setVisible (true);
 
		}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==btnCancel)
			{
			this.setVisible(false);
			}
		if(ae.getSource()==btnShow)
			{
			try
			  {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");	
						
			  Statement st=conn.createStatement();
	
	  		  String sql="select User from mysql.user";

   			  st.executeQuery(sql);

 			  ResultSet rs=st.executeQuery(sql);

			  String text=" ";

 			  int count=0;

		          while(rs.next())
			     {
			     text=text + rs.getString(1) + "\n";

			     count++;

			     }
			 ta.setText(text);

  			 String str1="Total Users:"+count;

  			 JOptionPane.showMessageDialog(null,str1,str1,JOptionPane.INFORMATION_MESSAGE); 		

			 }
			 catch(Exception e)
			 {
			 String str2=e.getMessage();
			 JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
			 }
			}
				
		}
			
	}
