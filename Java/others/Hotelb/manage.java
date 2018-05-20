import java.awt.*;
import java.*;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;

public class manage
{
	public static void main(String args[])
	{
		manage ma=new manage();
	}
	manage()
	{
	facility frame=new facility();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLocation(10,10);
    frame.setResizable (false);
    frame.show();
	}
}


class facility extends JFrame
{
	facility()
	{
		setTitle("Facility  Details");
      	setSize(WIDTH, HEIGHT);
	  	Container contentPane = getContentPane();
      	
      	DefaultTableModel dfm=new DefaultTableModel();
    	JTable table = new JTable(dfm);
    	Border border = null;
    	border = BorderFactory.createMatteBorder(2, 2,2, 2, Color.black);
    	table.setBounds(100,100,200,300);
    	table.setRowHeight(10);
    	table.setFont(font);
    	dfm.addColumn( "Facility No.");
    	dfm.addColumn( "Facility Name");
    	dfm.addColumn( "Rate");
     	contentPane.add(table);
    Object[] data=new Object[3];
    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
    JScrollPane jsp = new JScrollPane(table, v, h);
	contentPane.add(jsp);
	int j , x ;
	contentPane.setLayout(null);
      try
       {
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        String url = "jdbc:odbc:dbhotel";
	        
	        String ino[]    = new String[100];
	        String iname[]  = new String[100];
	        String rate[]= new String[100];
	        //String cphoneno[]    = new String[100];
	        //String chkindt[]=new String[100];
	        //String chkout[] =new String[100];
	        
	        
	        int i = 0,cnt ;		
			    	
	        Connection con = DriverManager.getConnection(url);
	        Statement stmt = con.createStatement();
	       
	        String sqlselect = 
	        " SELECT * FROM  faci;";
	        ResultSet rs = stmt.executeQuery(sqlselect);
	        while(rs.next())
	        {
	        	   ino[i]=rs.getString(1);
	               iname[i]=rs.getString(2);
	               rate[i]=rs.getString(3);
	               //cphoneno[i]=rs.getString(4);
	               //chkindt[i]=rs.getString(5);
	              // chkout[i]=rs.getString(6);
	               i++;
	        }
	        
	         for(cnt=0 ; cnt<i ; cnt++)
	         {
				   data[0]=ino[cnt];				   
				   data[1]=iname[cnt];
				   data[2]=rate[cnt];
				  // data[3]=cphoneno[cnt];
				   //data[4]=chkindt[cnt];
				  // data[5]=chkout[cnt];
				   dfm.addRow(data);
		}
			 
			      
				 
	        con.close();	        
			
        }
    
	      catch(Exception e)
	      {
	           System.out.println(e.getMessage());
	      } 
  }
      public static final int WIDTH = 800;
      public static final int HEIGHT = 575; 
      private Font font = new Font("Arial",Font.TRUETYPE_FONT,13); 
     
}
		