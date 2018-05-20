//creates frame for displaying student details in table

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class vstudentframe extends JDialog implements ActionListener
{
	vstudentframe(JFrame parent)
	{
		super(parent,"View of Student Details",true);
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
			JLabel l=new JLabel("Student Details");
			l.setFont(new Font("comic sans ms",Font.BOLD|Font.ITALIC,25));
			l.setForeground(Color.blue);
			ok = new JButton("Ok");
			ok.setMnemonic('o');
			ok.setFont(new Font("comic sans ms",Font.BOLD,15));
			ok.setForeground(Color.blue);
	
			String colheads[]={"Student No.","Last Name","First Name","Middle Name","Address","TelePhone No.","Birth Date","Blood Group","Sex","Class","Course","Hostel No.","Room No."};
		
            String sqlstr="select count(studno) from Student";
            ResultSet rs=stmt.executeQuery(sqlstr);
            int cnt=0;
            while(rs.next())
			{
			   cnt=rs.getInt(1);
			}
		    Object data[][]=new Object[cnt][13];
            sqlstr="select * from Student order by studno";
            rs=stmt.executeQuery(sqlstr);
            int i=0;
            while(rs.next())
			{
			   data[i][0]=""+rs.getInt(1)+"";
			   data[i][1]=rs.getString(2);
			   data[i][2]=rs.getString(3);
			   data[i][3]=rs.getString(4);
			   data[i][4]=rs.getString(5);
			   data[i][5]=""+rs.getInt(6)+"";
			   String birthdate=""+rs.getInt(7)+"-"+rs.getString(8)+"-"+rs.getInt(9)+"";
			   data[i][6]=birthdate;
			   data[i][7]=rs.getString(10);
			   data[i][8]=rs.getString(11);
			   data[i][9]=rs.getString(12);
			   String sqlstr1="Select cname from course where cno="+rs.getInt(13);
               Statement stmt2 = con.createStatement();
               ResultSet rs1=stmt2.executeQuery(sqlstr1);
               while(rs1.next())
               {
			      data[i][10]=rs1.getString(1);
               }
			   
			   data[i][11]=rs.getString(14);
			   data[i][12]=rs.getString(15);
			   i++;
			}
			JTable table=new JTable(data,colheads);
			table.setEnabled(false);
			table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
			JScrollPane jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            l.setBounds(230,10,400,70);
			jsp.setBounds(10,80,675,300);
			ok.setBounds(340,400,80,30);
			ok.addActionListener(this);
			c.add(l);
			c.add(jsp);
			c.add(ok);
			setSize(700,500);
			setLocation(50,70);
			setVisible(true);
        }//end of try
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,"In catch of hostel view");
        	JOptionPane.showMessageDialog(null,e.getMessage());
        }//end of catch
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		dispose();
	}
}