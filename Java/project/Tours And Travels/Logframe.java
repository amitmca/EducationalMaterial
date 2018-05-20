
	/* This screen accepts the User name and
		Password, thus authorising access to the application */

import java.awt.* ;
import java.sql.* ;
import java.util.* ;
import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.event.* ;

class Logframe extends JPanel
{
	public static Tours frmTours;
	 JButton okBut, cancelBut ;
	 JLabel lblId, lblPwd ,lblImg;
	 JTextField txtName ;
	 JPasswordField txtPwd ;
	 ImageIcon iokBut, icancelBut,imgLogin ;
	 public static JFrame frmLog;
	 public static String loginStr;
	 public static Logframe loginFrm ;

	 int counter = 0 ;


	 Logframe()
	 {
		     init ( ) ; //Place the controls on the screen
	 } // End of constuctor

	 void init ( )
	 	 {
	 		  initiate ( ) ;
	 		  place () ;
			  giveListener();
	 	 }

	 	 void initiate ( )
	 	 {
	 		  //iokBut = new ImageIcon ( "c:\\Rip\\Images\\check.gif" ) ;
	 		  //icancelBut = new ImageIcon ( "c:\\Rip\\Images\\wrong.gif" );

			  okBut = new JButton ( "Ok" ) ;
			  okBut.setBounds(120,90,100,30);

	 		  cancelBut = new JButton ( "Cancel" ) ;
	 		  cancelBut.setBounds(240,90,100,30);

	 		  imgLogin = new ImageIcon("C:\\Rip\\Images\\Pid1.JPG");
	 		  lblImg = new JLabel("",imgLogin,JLabel.CENTER);
	 		  lblImg.setBounds(5,5,100,120);

	 		  lblId = new JLabel ( "Login ID : ") ;
	 		  lblId.setBounds(120,10,100,30);
	 		  lblPwd = new JLabel ( "Password : ") ;
	 		  lblPwd.setBounds(120,50,100,30);

	 		  txtName = new JTextField (10) ;
	 		  txtName.setBounds(240,10,100,25);

	 		  txtPwd = new JPasswordField (10) ;
	 		  txtPwd.setEchoChar ('*') ;
	 		  txtPwd.setBounds(240,50,100,25);




	 	 }

	 	 void place ()
	 	 {
	 	    // setLayout ( new GridLayout (5, 2, 3, 3) ) ;
	 	    	setLayout(null);
	 	        add ( lblId ) ;
	 	        add ( txtName ) ;
	            add ( lblPwd ) ;
	            add ( txtPwd ) ;
	            add ( okBut ) ;
	            add ( cancelBut) ;
	            add(lblImg);
	 	 }

	 	 void giveListener ( )
	 	 {
	 		 okBut.addActionListener ( new ActList() ) ;
	 		 cancelBut.addActionListener ( new ActList() ) ;
	 		 txtPwd.addKeyListener(new KeyList());


	          txtName.requestFocus ( ) ;

	 	 }

	 	 void setLogin()
	 	 {
			 loginStr = txtName.getText(); // Store the login name
		 }// end of setLogin

		 String getLogin()
		 	 	 {
		 			 return loginStr ;
		 }// end of getLogin


		 public void verifyUser()
		 {
			char temp[] = txtPwd.getPassword() ;
			 String pwd = new String ( temp ) ;

			 if ( txtName.getText().equals("") || pwd.equals("") )
		     {
					JOptionPane.showMessageDialog(null,"Please fill both the fields","Incomplete Information",JOptionPane.ERROR_MESSAGE);
			 }
			 else
			 {
             counter++ ;
		     try
		     {
                 Class.forName ( "sun.jdbc.odbc.JdbcOdbcDriver" ) ;
                 Connection con = DriverManager.getConnection ( "jdbc:odbc:Tours","","" ) ;
                 Statement stmt = con.createStatement ( ) ;
				 String sql  =  "Select COUNT(*) from Login where Name = '" + txtName.getText() + "' and Pwd = '" + pwd +"'";
				 ResultSet rs = stmt.executeQuery (sql ) ;

					if ( counter == 3 )
					{
			 		   setVisible ( false ) ;
 				    }
		            while ( rs.next ( ) )
                   {

					 if (rs.getInt(1) == 1)
					{
							JOptionPane.showMessageDialog (null, "Authorization Granted...","Success",  JOptionPane.INFORMATION_MESSAGE);//,new ImageIcon ("tips.gif") ) ;
							loginFrm.setLogin();
							frmLog.setVisible(false);
							if(Tours.login != null)
							{
								Tours.login.setVisible(false);
							}

							RepMemList.mainFunc();
					}
					else
					{
							JOptionPane.showMessageDialog (null, "Incorrect Login. Try Again.","Alert",  JOptionPane.INFORMATION_MESSAGE);//,new ImageIcon ("tips.gif") ) ;
							txtName.setText ( "" ) ;
							txtPwd.setText ( "" ) ;
							txtName.requestFocus ( ) ;
					}



				 }//End of while

				 con.close ( ) ;
				 } // End of try Block
			 catch (ClassNotFoundException cnfe)
			 {
				   cnfe.printStackTrace ( ) ;
			 }

			 catch (SQLException se)
			 {
				   se.printStackTrace ( ) ;
			 }

		     } //end else
		 }// verify user

	 public static void main(String[] args)
	 	{
	 		loginFrm =  new Logframe();
	 		frmLog = new JFrame("Login ");
	 		frmLog.setContentPane(loginFrm);
	 		frmLog.setSize(350,150);
	 		frmLog.setResizable(false);

	 		// To center the frame
			Dimension dim = frmLog.getToolkit().getScreenSize();
					frmLog.setLocation(dim.width/2 - frmLog.getWidth()/2 ,
			dim.height/2 - frmLog.getHeight()/2 );

			//Place an Image on the Frame
			ImageIcon imgTours = new ImageIcon("C:\\rip\\images\\Login-key.gif");
		    frmLog.setIconImage(imgTours.getImage());

	 		frmLog.setVisible(true);

	 		WindowListener listener = new WindowAdapter ()
	 		{
	 			public void windowClosing(WindowEvent winevt)
	 			{
	 					System.exit(0);
	 			}
	 		} ;//End of WindowListener

	 		frmLog.addWindowListener(listener);


	 	}//End of Main

class KeyList implements KeyListener
{
		public void keyPressed(KeyEvent evtk)
		{
			int keyCode = evtk.getKeyCode();

			if(keyCode ==KeyEvent.VK_ENTER)
			{
				 verifyUser();
			}
		}//keypressed

		public void keyReleased(KeyEvent evt)
		{}

		public void keyTyped(KeyEvent evt)
		{}

}//End of class KeyList


class ActList implements ActionListener
{

	 	public void actionPerformed ( ActionEvent e )
	    {
		  if ( e.getSource() == okBut )
		  {

			 verifyUser();
		  }
		  else if ( e.getSource() == cancelBut )
		  {
			 System.exit(0);
		  }
	 }
	}


} //End of class LogFrame
