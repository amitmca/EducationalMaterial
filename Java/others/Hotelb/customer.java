//customer details


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;

public class customer
{
   public static void main(String arg[]) 
   {  
    customer ac=new customer();
   }
   public customer()
   {
   	  details frame = new details();
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setResizable (false);
      frame.show();
   }
}

class details extends JFrame 
{ 
   public details() 
   {  
      setTitle("Customer  Details");
      setSize(WIDTH, HEIGHT);

      Container contentPane = getContentPane();
      JPanel panel1 = new JPanel();
      contentPane.add(panel1);
      contentPane.setLayout(new GridLayout(1,1));
      panel1.setLayout(new GridLayout(1,1));

	DefaultTableModel dfm=new DefaultTableModel();
    JTable table = new JTable(dfm);
    table.setRowHeight(20);
    table.setFont(font);
    dfm.addColumn( "Cust No.");
    dfm.addColumn( "Cust Name");
    dfm.addColumn( "Cust Address");
    dfm.addColumn( "Cust Phoneno.");
    dfm.addColumn( "Chkin date");
    dfm.addColumn( "Chkout date");
    
    Object[] data=new Object[6];
    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
    JScrollPane jsp = new JScrollPane(table, v, h);
	panel1.add(jsp);

	int j , x ;
	
      try
       {
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        String url = "jdbc:odbc:hotel";
	        
	        String cno[]    = new String[100];
	        String cname[]  = new String[100];
	        String caddr[]= new String[100];
	        String cphoneno[]    = new String[100];
	        String chkindt[]=new String[100];
	        String chkout[] =new String[100];
	        
	        int cntphn = 0 , cntmbl = 0 , cntmail = 0;
	        int i = 0,cnt ;		
			FileWriter fo = new FileWriter("customerdetails.doc",false);
			filein = " Cust No. " + "* Cust Name " + "* Cust Address " + "* Cust Phoneno " + "*chkindt " + "*chkoutdt";
			fo.write('\n'+filein+'\n'+'\n');
	        	
	        Connection con = DriverManager.getConnection(url);
	        Statement stmt = con.createStatement();
	       
	        String sqlselect = 
	        " SELECT * FROM  customer;";
	        ResultSet rs = stmt.executeQuery(sqlselect);
	        while(rs.next())
	        {
	        	   cno[i]=rs.getString(1);
	               cname[i]=rs.getString(2);
	               caddr[i]=rs.getString(3);
	               cphoneno[i]=rs.getString(4);
	               chkindt[i]=rs.getString(5);
	               chkout[i]=rs.getString(6);
	               i++;
	        }
	        
	         for(cnt=0 ; cnt<i ; cnt++)
	         {
				   data[0]=cno[cnt];				   
				   data[1]=cname[cnt];
				   data[2]=caddr[cnt];
				   data[3]=cphoneno[cnt];
				   data[4]=chkindt[cnt];
				   data[5]=chkout[cnt];
				  
	
		
		dfm.addRow(data);
		}
			 
			      
				 
	        con.close();	        
			fo.close();
        }
    
	      catch(Exception e)
	      {
	           System.out.println(e.getMessage());
	      } 
  }
      public static final int WIDTH = 800;
      public static final int HEIGHT = 575; 
      private Font font = new Font("Arial",Font.TRUETYPE_FONT,13); 
      public static String filein; 
}