//creates frame for tree view

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class treeview extends JDialog implements ActionListener
{
	JButton ok;
	JTree tree;
	treeview(JFrame parent)
	{
		super(parent,"Hostel Tree View",true);
		
		Container c=getContentPane();
		c.setLayout(null);
		JLabel l=new JLabel("Tree View of Hostel");
		l.setFont(new Font("comic sans ms",Font.BOLD|Font.ITALIC,25));
		l.setForeground(Color.blue);
		ok = new JButton("Ok");
		ok.setMnemonic('o');
		ok.setFont(new Font("comic sans ms",Font.BOLD,15));
		ok.setForeground(Color.blue);
		
		DefaultMutableTreeNode top=new DefaultMutableTreeNode("Hostel Details");  
		
		try
	        {
	        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        	String dsn="jdbc:odbc:hostel";
	        	Connection con=DriverManager.getConnection(dsn,null,null);
	            con.setAutoCommit(true);
	            Statement stmt = con.createStatement();
				String sqlstr="select * from hostel order by hno";
				ResultSet rs=stmt.executeQuery(sqlstr);
				while(rs.next())
				{
					int h=rs.getInt(1);
	  	   	        DefaultMutableTreeNode hn= new DefaultMutableTreeNode("Hostel No: "+h+" ("+rs.getString(3)+")");
	  	   	        //adds hostel number to top
	  	   	        top.add(hn);
	  	   	        int room=rs.getInt(4);
   					for(int i=1;i<=room;i++)
					{
						DefaultMutableTreeNode rn= new DefaultMutableTreeNode("Room No: "+i);
						//adds room number to hotel 
						hn.add(rn);
						String sql1="select lastname,firstname,midname,class,cno from student where hno="+h+" and rno="+i+" order by studno";
						Statement stmt2=con.createStatement();
						ResultSet rs1=stmt2.executeQuery(sql1);
						while(rs1.next())
						{
							//get course name from db
							String sql2="select cname from course where cno="+rs1.getInt(5);
							Statement stmt3=con.createStatement();
							ResultSet rs2=stmt3.executeQuery(sql2);
							while(rs2.next())
							{
							   DefaultMutableTreeNode sn=new DefaultMutableTreeNode("Student : "+rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" ("+rs1.getString(4)+" "+rs2.getString(1)+")");
							   //adds student details to room
							   rn.add(sn);
							 }
						}
					}
				}
	         }
	         catch(Exception e)
	        {
	        	JOptionPane.showMessageDialog(null,e.getMessage());
	        }//end of catch
	        
	        tree=new JTree(top);
	        JScrollPane jsp=new JScrollPane(tree,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        
	        l.setBounds(230,10,400,70);
	        jsp.setBounds(100,100,500,320);
	        ok.setBounds(300,450,60,30);
	        ok.setMnemonic('o');
	        ok.setToolTipText("Close");
	        ok.addActionListener(this);
	        
	        c.add(l);
	        c.add(jsp);
	        c.add(ok);
	        setSize(750,530);
	        setLocation(20,50);
	        setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		dispose();
	}
}