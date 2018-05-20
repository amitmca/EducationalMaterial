       import javax.swing.JApplet;
       import java.awt.Dimension;
       import java.awt.Toolkit;
       import java.awt.BorderLayout;
       import javax.swing.JFrame;
       import javax.swing.UIManager;
       import javax.swing.JButton;
       import java.awt.Rectangle;
       import javax.swing.JTextArea;
       import java.awt.event.ActionListener;
       import java.awt.event.ActionEvent;
       import java.sql.*;
       import javax.swing.JLabel;

	/*
	<applet code="Applet1" width=300 height=300>
	</applet>
	*/
       
       public class Applet1 extends JApplet
	 {
         private JButton DbConnect = new JButton();

         private JTextArea empValues = new JTextArea();

         private Connection con;

         private JLabel jLabel1 = new JLabel();
       
         public Applet1() 
		{
         	}

         public void init() 
	   {
            try 
	     {
             jbInit();
             }
            catch(Exception e)
             {
             e.printStackTrace();
             }
         }
       
         private void jbInit() throws Exception
	   {
           this.getContentPane().setLayout(null);

           DbConnect.setText("Click to Connect to DB");

           DbConnect.setBounds(new Rectangle(90, 225, 175, 40));

           DbConnect.addActionListener(new ActionListener() 
               {
               public void actionPerformed(ActionEvent e)   
                    {
                    connectToDB(e);
                    }
               });
           empValues.setBounds(new Rectangle(40, 50, 310, 150));
           jLabel1.setText("Emp Records :");
           jLabel1.setBounds(new Rectangle(45, 20, 155, 20));
           this.getContentPane().add(jLabel1, null);
           this.getContentPane().add(empValues, null);
           this.getContentPane().add(DbConnect, null);

         }
       
       
         private void connectToDB(ActionEvent e)
	 {
           try
	    {
             DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());

             con = DriverManager.getConnection("jdbc:odbc:Access");

 empValues.setText("Connected to the Database");

             }
	   catch (SQLException ex)
	     {
             System.out.println("Connection Error =  "  + ex.toString());
             }
         }
         
        
       }
