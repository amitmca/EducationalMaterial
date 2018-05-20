import java.sql.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.lang.String;
import java.awt.geom.*;

public class ht
{
	public static void main(String args[])
	{
	ht at=new ht();
}
public ht()
{
	alldetails frame=new alldetails();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setResizable(false);
	frame.show();
}
}

class alldetails extends JFrame
{
	public alldetails ()
	{
	 	setTitle("All Customer Information");
		setSize(WIDTH,HEIGHT);
		 Container container = getContentPane();
		JPanel panel1=new JPanel();
		container.add(panel1);
		container.setLayout(new GridLayout(1,1));
		panel1.setLayout(new GridLayout(1,1));
		DefaultTableModel dfm=new DefaultTableModel();
		JTable table=new JTable(dfm);
		table.setRowHeight(20);
		//table.setFont(font);
		dfm.addColumn("Cust.no");
		dfm.addColumn("Cust name");
		dfm.addColumn("Cust Addr");
		dfm.addColumn("Cust Phone");
		dfm.addColumn("room type");
		dfm.addColumn("check in dt");
		dfm.addColumn("chk out dt");
		dfm.addColumn("occp");
		Object[] data=new Object[8];
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp=new JScrollPane(table,h,v);
		panel1.add(jsp);
		int j,x; 
		
	try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String filein;
			String cno[]=new String[100];
			String cname[]=new String[100];
			String caddr[]=new String[100];
			String cphone[]=new String[100];
			String rtype[]=new String[100];
			String ckin[]=new String[100];
			String chkout[]=new String[100];
			String occp[]=new String[100];
			int cntph=0;
			int i=0,cnt;
			FileWriter file=new FileWriter("hotel.doc",false);
			filein="Custno." + "--Custname" + "Custaddr"+"cphone"+"roomtype"+"chkindt"+"chkout"+"occp";
			file.write('\n'+filein+'\n'+'\n');
			
		Connection	con=DriverManager.getConnection("jdbc:odbc:reservation");
		Statement	st=con.createStatement();
		ResultSet	rs=st.executeQuery("Select * From reserve");
			while(rs.next())
			{
				cno[i]=rs.getString(1);
				cname[i]=rs.getString(2);
				caddr[i]=rs.getString(3);
				cphone[i]=rs.getString(4);
				rtype[i]=rs.getString(5);
				ckin[i]=rs.getString(6);
				chkout[i]=rs.getString(7);
			occp[i]=rs.getString(8);
			i++;
			}	
			for(cnt=0;cnt<i;cnt++)
			{
				data[0]=cno[cnt];
				data[0]=cname[cnt];
				data[0]=caddr[cnt];
		}
			rs.close();
			st.close();
			con.close();
			file.close();
		
	}
catch(Exception e)
{
}
}
 public static final int WIDTH = 800;
      public static final int HEIGHT = 575; 
      //private Font font = new Font("Arial",Font.TRUETYPE_FONT,13); 
    //  public static String filein; 


}
