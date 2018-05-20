//creates frame for adding fee details 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class feedetailframe extends JDialog implements ActionListener
{
	JButton ok,cancel;
	JComboBox studno;
	JTextField ddno,amt;
	feedetailframe(JFrame parent)
	{
		super(parent,"Fee Details",true);
		Container c=getContentPane();
		c.setLayout(null);
		JLabel stno,dno,amtl;
		
		stno=new JLabel("Student Number");
		dno=new  JLabel("D.D. Number");
		amtl=new  JLabel("Amount (in Rs.)");
		
		studno=new JComboBox();
		ddno=new JTextField();
		amt=new JTextField();
		
		ok=new JButton("Ok");
		ok.setMnemonic('o');
		cancel=new JButton("Close");
		cancel.setMnemonic('c');

        studno.setToolTipText("Student Number");
        ddno.setToolTipText("D.D. Number");
        amt.setToolTipText("Amount (in Rs.)");
        ok.setToolTipText("Save Record");
        cancel.setToolTipText("Cancel");
        
        stno.setBounds(50,30,100,20);
        stno.setForeground(Color.red);
        studno.setBounds(160,30,60,20);
        dno.setBounds(50,70,100,20);
        dno.setForeground(Color.red);
        ddno.setBounds(160,70,100,20);
        amtl.setBounds(50,110,100,20);
        amtl.setForeground(Color.red);
        amt.setBounds(160,110,70,20);
        ok.setBounds(90,180,50,30);
        cancel.setBounds(200,180,90,30);
        ok.setForeground(Color.blue);
		cancel.setForeground(Color.red);
        
        try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select studno from student order by studno";
            ResultSet rs=stmt.executeQuery(sqlstr);
            //add student numbers from db
            while(rs.next())
            {
            	studno.addItem(""+rs.getInt(1)+"");
            }         
         }
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,"In catch of hostel view");
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }//end of catch
        
        ok.addActionListener(this);
        cancel.addActionListener(this);
 		c.add(stno);
		c.add(dno);
		c.add(amtl);
		c.add(ok);
		c.add(cancel);
		c.add(studno);
		c.add(ddno);
		c.add(amt);
		setLocation(100,80);
		setSize(400,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			if(ddno.getText().equals(""))
      		{
      			JOptionPane.showMessageDialog(null,"Enter D.D. Number","Error Message",JOptionPane.ERROR_MESSAGE);
      			ddno.requestFocus(true);
				return;
      		}
      		//check whether user has entered '
			 for(int i=0;i<ddno.getText().length();i++)
      		   {
      		   	  char ch = ddno.getText().charAt(i);
				  if((ch==39))
				  {
						JOptionPane.showMessageDialog(null,"Don't  insert  '  character in D.D. Number field","Incorrect Format",JOptionPane.ERROR_MESSAGE);
						ddno.requestFocus();
						return;
				  }
				 else
				  {
				  } 
		      }
  			if(amt.getText().equals(""))
      		   {
      			  JOptionPane.showMessageDialog(null,"Enter Total Amount","Error Message",JOptionPane.ERROR_MESSAGE);
      			  amt.requestFocus(true);
					return;
      		   }
      		   for(int i=0;i<amt.getText().length();i++)
      		   {
      		   	  char ch = amt.getText().charAt(i);
				  if(ch>='0'&&ch<='9')
				  {
				  }
				 else
				  {
				 	JOptionPane.showMessageDialog(null,"Enter Numerical Value For Amount","Incorrect Format",JOptionPane.ERROR_MESSAGE);
					amt.setText("");
					amt.requestFocus();
					return;
				  } 
		      }
      	try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            //get current date
        	Calendar c = Calendar.getInstance();
        	String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	 		int dd1=c.get(c.DATE);
	 		String mm1=months[(c.get(c.MONTH))];
	 		int yy1=c.get(c.YEAR);
        	String date=""+dd1+"-"+mm1+"-"+yy1+"";

            String sql="Select max(feeno) from admission";
            ResultSet r=stmt.executeQuery(sql);
            int fee=0;
            while(r.next())
            {
            	fee=r.getInt(1)+1;
            }

        	String sqlstr="Insert into admission values(" +fee+","+ Integer.parseInt(studno.getSelectedItem().toString())+",'"+ddno.getText()+"',"+Integer.parseInt(amt.getText())+",'"+date+"')";
        	if (JOptionPane.showConfirmDialog(null,"Do you want to Save the Record?")==JOptionPane.YES_OPTION)
            {
                 //add in admission table
                 stmt.executeUpdate(sqlstr);
                 JOptionPane.showMessageDialog(null,"Record Saved Successfully !!!");
                 ok.setEnabled(false);
                 cancel.setText("Close");
                 cancel.setToolTipText("Close");
            }
            con.close();
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }
	}//end of if "ok"
	
		if(ae.getSource()==cancel)
		  dispose();
	}
}
