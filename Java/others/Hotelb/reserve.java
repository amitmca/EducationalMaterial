//frame for reservation of room
//ie customer in front of receptionist and want to reserve room on spot 
//and start living from current day & time


import java.awt.event.*;
import java.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.sql.*;


public class  reserve
{
	public static void main(String args[])
	{
		reserve re=new reserve();
	}
	public reserve()
	{
	reserving frame=new reserving();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocation(100,10);
    frame.setResizable (false);
    frame.show();
	}
}

class reserving extends JFrame
{
	public reserving()
	{
		setTitle("Reservation Of Room");
		setSize(HEIGHT,WIDTH);
		setResizable(false);
		
		Container contentPane=getContentPane();
		
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		JPanel panel4=new JPanel();
		JPanel panel5=new JPanel();
		JPanel panel6=new JPanel();
		JPanel panel7=new JPanel();
		JPanel panel8=new JPanel();
		JPanel panel9=new JPanel();
	
		panel1.add(new JLabel("Customer Info"));
		
		panel2.add(new JLabel("Cust No"));
		cno=new JTextField(4);
		panel2.add(cno);
		panel2.add(new JLabel("   "));
		panel2.add(new JLabel("Room No"));
		rno=new JTextField(4);
		panel2.add(rno);
		
		
		
		
		panel3.add(new JLabel("Cust Name"));
		cname=new JTextField(30);
		panel3.add(cname);
		
		
		panel4.add(new JLabel("Cust Addr"));
		 caddr=new JTextField(30);
		panel4.add(caddr);
		
		
		panel5.add(new JLabel("Cust Phoneno"));
	 	cphone=new JTextField(10);
	 	panel5.add(cphone);
	 			
				
		panel6.add(new JLabel("Chk in date"));
		chkin=new JTextField(10);
		panel6.add(chkin);
		
		
		panel6.add(new JLabel("Chk out date"));
		chkout=new JTextField(10);
		panel6.add(chkout);
		
		panel9.add(new JLabel("Room Type"));
		JComboBox rt=new JComboBox();
		panel9.add(rt);
		
		
		
		
		
		 JButton reserveb=new JButton("Reserve");
		 panel8.add(reserveb);
		 reserveb.addActionListener(new Reserveb());
      	 Cursor cur = new Cursor(HAND_CURSOR);
      	 reserveb.setCursor(cur);
      	 Color color = new Color(0,0,255);
      	 reserveb.setForeground(color);
		 reserveb.setCursor(cur);
		 JButton closeb = new JButton("Close");
         panel8.add(closeb);
         closeb.setCursor(cur);
         closeb.addActionListener(new
         ActionListener()
          {
           public void actionPerformed(ActionEvent event)
           {
            reserving.this.dispose();
           } 
         });
         
          contentPane.add(panel1);
          
	    
	      contentPane.add(panel3);
	      contentPane.add(panel4);
	      contentPane.add(panel5);
	      contentPane.add(panel2);
	      contentPane.add(panel6);      
	      contentPane.add(panel7);
	      contentPane.add(panel8);
	      
	      
	      contentPane.setLayout(new GridLayout(8,1));
     
     try
       {
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        String url = "jdbc:odbc:hotel";
	        String rtype[]=new String[100];
	        String rt1[]=new String[100];
	        int i=0,j;			
	        Connection con = DriverManager.getConnection(url);
	        Statement stmt = con.createStatement();
	        
	        String sqlselect1 = 
	        " SELECT rtype" + 
	        " FROM room;";
	        
	        ResultSet rs = stmt.executeQuery(sqlselect1);			
	        while(rs.next()) 
	        {
               rtype[i]=rs.getString (1);
	           i++;
	        }	
    	    for(j=0;j<i;j++)
	        {
	        	rt.addItem (rtype[j]);
	        }
	      }
	      catch(Exception e)
	      {
	           System.out.println(e.getMessage());
	      }   
   }
		public static final int	HAND_CURSOR	= 12;
	 	public static final int WIDTH = 500;
   		public static final int HEIGHT = 450; 
   		private JTextField cname,cno,caddr,rno,chkin,chkout,cphone; 
	   
	   
	   private class Reserveb implements ActionListener
	   {
	   public void actionPerformed(ActionEvent e)
	   {
	   	String cname1,cadr1,cphone1,cno1,rno1,chkin1,chkout1;
	   	cname1="'"+cname.getText()+"'";
	   	cadr1="'"+caddr.getText()+"'";
	   	cphone1="'"+cphone.getText()+"'";
	   	cno1="'"+cno.getText()+"'";
	   	rno1="'"+rno.getText()+"'";
	   	chkin1="'"+chkin.getText()+"'";
	   	chkout1="'"+chkout.getText()+"'";
	   	
	   	  		
	   	   	try
	   	   	{
	   	   		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	   	   	
	   	   	
	   	   	}
	   	   	
	   	  catch(java.lang.ClassNotFoundException e1) 
	{
		System.err.print("ClassNotFoundException: "); 
		System.err.println(e1.getMessage());
	}
	   
	   try
	    {
	   	 	
	   	
	   	
	   	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        String url = "jdbc:odbc:hotel";
	   	 	Connection con = DriverManager.getConnection(url);
	        Statement st=con.createStatement();
	        String str="Select cno from customer";
	        ResultSet rs1=st.executeQuery(str);
	        int i=0,max=0,custno=0;
	        while(rs1.next())
	        {
	        custno=rs1.getInt(1);
	        if(custno>max)
	        {
	        	max=custno;
	        	
	        }
	        i++;
	        }
	        custno=max+1;
	        
	        Statement st1=con.createStatement();
	        String str1="Insert into customer values"+"("+custno+","+cname1+","+cadr1+","+cphone1+","+chkin1+","+chkout1+");";
	       
	        st1.executeUpdate(str1);
	      }
	      
	       catch(Exception e11)
	    {
	    	System.out.print(e11);
	 		}
	    	  
	     
	     
	   
	   }
	   
	}
	   
}
