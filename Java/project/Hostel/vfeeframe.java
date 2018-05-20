//creates frame for displaying fee details in table

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class vfeeframe extends JDialog implements ActionListener
{
	vfeeframe(JFrame parent)
	{
		super(parent,"View of Student Fee Details",true);
		JButton ok;
		try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            
            Container c= getContentPane();
			c.setLayout(null);
			JLabel l=new JLabel("Student Fee Details");
			l.setFont(new Font("comic sans ms",Font.BOLD|Font.ITALIC,25));
			l.setForeground(Color.blue);
			ok = new JButton("Ok");
			ok.setMnemonic('o');
			ok.setFont(new Font("comic sans ms",Font.BOLD,15));
			ok.setForeground(Color.blue);
	
			String colheads[]={"Fee No.","Student No.","D.D. Number","Amount (in Rs.)","Date"};
		
            String sqlstr="select count(feeno) from admission";
            ResultSet rs=stmt.executeQuery(sqlstr);
            int cnt=0;
            while(rs.next())
			{
			   cnt=rs.getInt(1);
			}
		    Object data[][]=new Object[cnt][5];
            sqlstr="select * from admission order by feeno";
            rs=stmt.executeQuery(sqlstr);
            int i=0;
            while(rs.next())
			{
			   data[i][0]=""+rs.getInt(1)+"";
			   data[i][1]=""+rs.getInt(2)+"";
			   data[i][2]=rs.getString(3);
			   data[i][3]=""+rs.getInt(4)+"";
			   data[i][4]=rs.getDate(5);
			   i++;
			}
			JTable table=new JTable(data,colheads);
			table.setEnabled(false);
			table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
			JScrollPane jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            
            l.setBounds(200,10,400,70); 			
			jsp.setBounds(100,80,420,150);
			ok.setBounds(280,300,80,30);
			ok.addActionListener(this);
			c.add(l);
			c.add(jsp);
			c.add(ok);
			setSize(650,400);
			setLocation(80,130);
			setVisible(true);
			
        }//end of try
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,"In catch of fee view");
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }//end of catch
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		dispose();
	}
}