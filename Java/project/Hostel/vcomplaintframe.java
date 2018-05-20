//creates frame for displaying complaint details in table

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class vcomplaintframe extends JDialog implements ActionListener
{
	vcomplaintframe(JFrame parent)
	{
		super(parent,"View of Complaint Details",true);
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
			JLabel l=new JLabel("Complaint Details");
			l.setFont(new Font("comic sans ms",Font.BOLD|Font.ITALIC,25));
			l.setForeground(Color.blue);
			ok = new JButton("Ok");
			ok.setMnemonic('o');
			ok.setFont(new Font("comic sans ms",Font.BOLD,15));
			ok.setForeground(Color.blue);
	
			String colheads[]={"Complaint No.","Student No.","Complaint Details"};
		
            String sqlstr="select count(compno) from Complaint";
            ResultSet rs=stmt.executeQuery(sqlstr);
            int cnt=0;
            while(rs.next())
			{
			   cnt=rs.getInt(1);
			}
		    Object data[][]=new Object[cnt][3];
            sqlstr="select * from Complaint order by compno";
            rs=stmt.executeQuery(sqlstr);
            int i=0;
            while(rs.next())
			{
			   data[i][0]=""+rs.getInt(1)+"";
			   data[i][1]=rs.getString(2);
			   data[i][2]=rs.getString(3);
			   i++;
			}
			JTable table=new JTable(data,colheads);
			table.setEnabled(false);
			table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
			JScrollPane jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            
            l.setBounds(230,10,400,70);
			jsp.setBounds(100,80,400,150);
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
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }//end of catch
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		dispose();
	}
}