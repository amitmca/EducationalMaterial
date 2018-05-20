import java.awt.*;
import java.applet.*;
import java.sql.*;
import java.awt.event.*;

/*
<applet code="jdbc" width=250 height=250>
</applet>
*/

public class jdbc extends Applet implements ActionListener
	{
	Button b;
	TextField t;
	String mess=" ";
	
	public void init()
		{
		b=new Button("Connect...");
		t=new TextField(35);
		add(b);
		add(t);
		b.addActionListener(this);
		}	
	private void connectToDB(ActionEvent e)
	 {
           try
	    {
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
	     String url="jdbc:odbc:Access";	

             Connection con = DriverManager.getConnection(url);

	     mess="Connected to the Database";

             }
	   catch(SQLException ex)
	     {
             mess="SQL Error ";
             }
	   catch(ClassNotFoundException ex)
	     {
             mess="ClassNotFound Exception ";
             }
         }
	 public void actionPerformed(ActionEvent e)   
                    {
                    connectToDB(e);
                    }

	} // end of main
