import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import java.io.*;

public class rooms
{
   public static void main(String arg[]) 
   {  
    rooms ac=new rooms();
   }
   public rooms()
   {
   	  detailsroom frame = new detailsroom();
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setResizable (false);
      frame.show();
   }
}

class detailsroom extends JFrame 
{ 
   public detailsroom() 
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
    dfm.addColumn( "Room No.");
    dfm.addColumn( "Room Type");
    dfm.addColumn( "Room Status");
    dfm.addColumn( "Cust No.");
    
    Object[] data=new Object[7];
    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
    JScrollPane jsp = new JScrollPane(table, v, h);
	panel1.add(jsp);

	int j , x ;
	
      try
       {
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        String url = "jdbc:odbc:hotel";
	        String rno[] = new String[100];
	        String rtype[] = new String[100];
	        String rstatus[] = new String[100];
	        String cno[] = new String[100];
	        
	        int cntphn = 0 , cntmbl = 0 , cntmail = 0;
	        int i = 0,cnt ;		
			FileWriter fo = new FileWriter("roomdetails.doc",false);
			filein = " Room No. " + "* Room Type " + "* Room Status " + "* Cust no. ";
			fo.write('\n'+filein+'\n'+'\n');
	        	
	        Connection con = DriverManager.getConnection(url);
	        Statement stmt = con.createStatement();
	       
	        String sqlselect = 
	        " SELECT * FROM  room;";
	        ResultSet rs = stmt.executeQuery(sqlselect);
	        while(rs.next())
	        {
	        	   rno[i]=rs.getString(1);
	               rtype[i]=rs.getString(2);
	               rstatus[i]=rs.getString(3);
	               cno[i]=rs.getString(4);
	               i++;
	        }
	        
	         for(cnt=0 ; cnt<i ; cnt++)
	         {
				   data[0]=rno[cnt];				   
				   data[1]=rtype[cnt];
				   data[2]=rstatus[cnt];
				   data[3]=cno[cnt];
				  
	
		
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