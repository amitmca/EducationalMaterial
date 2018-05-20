//student receipt


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;


class reprec extends JDialog implements ActionListener
{
	JComboBox studno=new JComboBox();
	JButton ok=new JButton("Ok");
	JButton close=new JButton("Close");
	reprec(JFrame parent)
	{
        super(parent,"Student Receipt",true);
		
		Container c = getContentPane();
		c.setLayout(null);
	
	    JLabel l=new JLabel("Select Student Number");
	    l.setForeground(Color.blue);
       try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String dsn="jdbc:odbc:hostel";
        	Connection con=DriverManager.getConnection(dsn,null,null);
            con.setAutoCommit(true);
            Statement stmt = con.createStatement();
            String sqlstr="select studno from student order by studno";
            ResultSet rs=stmt.executeQuery(sqlstr);
            while(rs.next())
            {
            	//adds in combobox of course name  from database
              	studno.addItem(""+rs.getInt(1)+"");
            }
            con.close();
        }
        catch(Exception e)
        {
			   JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
	    ok.setMnemonic('o');
	    close.setMnemonic('c');
	    
	    l.setBounds(10,40,200,20);
	    studno.setBounds(180,40,70,20);
	    ok.setBounds(70,100,70,30);
	    close.setBounds(170,100,70,30);
	    
	    ok.addActionListener(this);
	    close.addActionListener(this);
	    
	    c.add(l);
	    c.add(studno);
	    c.add(ok);
	    c.add(close);
	    
	    setSize(300,200);
	    setLocation(250,150);
	    setVisible(true);
	    
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==ok)
	  {
		   Runtime iexp;
		   ResultSet rs1;
		   int cno=0;
		   Process pro;
		   iexp = Runtime.getRuntime();
		   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","c:\\java\\stud.html"};
		   try
		   {
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		        Connection con = DriverManager.getConnection("jdbc:odbc:hostel",null,null);
		        Statement stmt = con.createStatement();
    
 		        String sql="Select studno,lastname,firstname,midname,class,cno,hno,rno from student where studno="+Integer.parseInt(studno.getSelectedItem().toString());
		        ResultSet rs = stmt.executeQuery(sql);
		        
		        File outFile = new File("c:\\java\\stud.html");
		        FileWriter out = new FileWriter(outFile);
		        
				//EEECAC yellow aaeef5 cyan
				out.write("</head><body bgcolor=\"#b6d3d3\" alink=\"#800080\">");
				//for logo of college
				out.write("<p align=\"center\"><input type=\"image\" name=\"I1\"");
				out.write("src=\"file:///C:/hostelon/collegelogo.jpg\"");
				out.write("align=\"bottom\" border=\"0\" width=\"140\" height=\"165\"></p>");
				out.write("<p align=\"center\"><font color=\"#0000FF\" size=\"3\"");
				out.write("face=\"Monotype Corsiva\"><strong>\"Hostel Admission System\"</strong></font></p>");
				out.write("<p align=\"center\"><font color=\"#0000FF\" size=\"3\"");
				out.write("face=\"Monotype Corsiva\"><strong>Nowrosjee Wadia College,Pune-411001.</strong></font></p>");
				out.write("<p align=\"center\"><font color=\"#FF0000\" size=\"6\"");
				out.write("face=\"Monotype Corsiva\"><strong><u> Fee Receipt</u></strong></font></p>");
				//for date
				//get current date
		        Calendar c = Calendar.getInstance();
		        String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
			 	int dd1=c.get(c.DATE);
			 	String mm1=months[(c.get(c.MONTH))];
			 	int yy1=c.get(c.YEAR);
			 	int hh=c.get(c.HOUR);
			 	int mm=c.get(c.MINUTE);
			 	int ss=c.get(c.SECOND);
		        String date=""+dd1+"-"+mm1+"-"+yy1+"";
		        String time=""+hh+":"+mm+":"+ss+"";
		        out.write("<table border=0 align=right><tr><td > <font color =\"000080\">Date: "+date +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Time:&nbsp;"+time+"</font></tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>");
				while(rs.next())
				{
					out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student No.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</strong></font><strong>");;
					out.write("</strong>"+rs.getString(1)+"</p>");
					out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student Name&nbsp;:</strong></font><strong>");;
					out.write("</strong>"+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"</p>");
					sql ="Select cname from course where cno="+rs.getInt(6);
			        Statement stmt1 = con.createStatement();
			        rs1 = stmt1.executeQuery(sql);
			        String coursename="";
			        while(rs1.next())
			        {
			        	coursename=rs1.getString(1);
			        }
			        out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Class&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:");
					out.write("</strong></font>"+rs.getString(5)+"<font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Course&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:");
					out.write("</strong></font>"+coursename+"</p>");
					out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hostel");
					out.write("No.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</strong></font>"+rs.getInt(7)+"");
					out.write("<font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Room");
					out.write("No.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</strong>");
					out.write("</font>"+rs.getInt(8)+"</p>");
					out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fee");
					out.write("Details&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write(":&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font></p>");			
			    }		    
			    	out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
					out.write("	color=\"#800000\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fee Number");
					out.write("	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date");
					out.write("	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D.D.");
					out.write("Number&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;Amount Paid</strong></font></p>");
					//form database
					sql="select feeno,date,ddno,amount from admission where studno="+Integer.parseInt(studno.getSelectedItem().toString())+" order by feeno";
					Statement stmt1 = con.createStatement();
					rs1 = stmt1.executeQuery(sql);
					int total=0;
					int amt=0;
			        while(rs1.next())
			        {
			        	out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
						out.write(" color=\"#800000\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font color=\"#800080\"> </font> ");
						out.write(""+rs1.getInt(1)+"");
						out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
						out.write(""+rs1.getDate(2)+"");
						out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=\"#800000\"><strong>&nbsp;</strong></font>");
						out.write(rs1.getString(3));
						out.write("<font color=\"#800000\">&nbsp;<strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font>&nbsp;&nbsp;&nbsp;");
						amt=rs1.getInt(4);
						total+=amt;
						out.write(""+amt+"");
						out.write("</p>");						      	
			        }
					out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
					out.write(" color=\"#800000\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
					out.write(" color=\"#800080\"><strong>&nbsp;&nbsp;-----------------------------------------------------------------------------------</strong></font></p>");
					out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
					out.write(" color=\"#800000\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
					out.write(" color=\"#800080\"><strong>&nbsp;</strong></font><font");
					out.write(" color=\"#000080\"><strong>Total Amount Paid =</strong></font><font");
					out.write(" color=\"#800080\"><strong> </strong></font><strong>");
					out.write(""+total+"");
					out.write("</strong></p>");
					sql="select * from totalfee ";	
					rs1=stmt1.executeQuery(sql);
					int totalfee=0;
					while(rs1.next())
					{
						totalfee=rs1.getInt(1);
					}
					int balance=totalfee-total;
					out.write("<p><font color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
					out.write(" color=\"#800000\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
					out.write(" color=\"#800080\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
					out.write("&nbsp;&nbsp;&nbsp;</strong></font><font color=\"#800000\"><strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></font><font");
					out.write(" color=\"#FF0000\"><strong>Balance&nbsp;=</strong></font><font");
					out.write(" color=\"#800080\"><strong> </strong></font><strong>");
					out.write(""+balance+"");
					out.write("</strong></p>");
		    		out.write("</body></html>");
		    		out.close();
		    		pro = iexp.exec(en);
		       		pro.waitFor();
					stmt.close();
					con.close();
		   } // end of try
		   catch(Exception e)
		   {
		        System.out.println(e);
		   }
	  }
	  else
	    dispose();	
	}
}
