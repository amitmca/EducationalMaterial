        /* This screen accepts the User password and allows him to change it*/

import java.awt.* ;
import java.sql.* ;
import java.util.* ;
import javax.swing.* ;
import javax.swing.event.* ;
import java.awt.event.* ;

class ChangePassword extends JPanel
{
	 JButton okBut, cancelBut ;
       JLabel lblOldPwd, lblPwd , lblNewPwd ,lblImg;
       JPasswordField txtOldPwd, txtRetypePwd ,txtNewPwd;
	 ImageIcon iokBut, icancelBut ,imgLogin;



        ChangePassword()
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
			  okBut.setBounds(120,130,100,30);
	 		  cancelBut = new JButton ( "Cancel" ) ;
	 		  cancelBut.setBounds(240,130,100,30);

			  lblOldPwd = new JLabel ( "Old Password : " ) ;
			  lblOldPwd.setBounds(120,10,120,30);

			  lblPwd = new JLabel ( "New Password : " ) ;
			  lblPwd.setBounds(120,50,120,30);

			  lblNewPwd = new JLabel ( "Retype New Pwd : " ) ;
			  lblNewPwd.setBounds(120,90,120,30);

	 		  txtOldPwd = new JPasswordField ( 10 ) ;
			  txtOldPwd.setEchoChar ( '*' ) ;
			  txtOldPwd.setBounds(240,10,100,25);

	 		  txtRetypePwd = new JPasswordField ( 10 ) ;
	 		  txtRetypePwd.setEchoChar ( '*' ) ;
	 		  txtRetypePwd.setBounds(240,50,100,25);

			  txtNewPwd = new JPasswordField ( 10 ) ;
			  txtNewPwd.setEchoChar ( '*' ) ;
			  txtNewPwd.setBounds(240,90,100,25);

			  imgLogin = new ImageIcon("C:\\Rip\\Images\\Pid2.JPG");
			  lblImg = new JLabel("",imgLogin,JLabel.CENTER);
			  lblImg.setBounds(5,5,100,150);


	 	 }

	 	 void place ()
	 	 {
			   //setLayout ( new GridLayout (6, 3, 4, 4) ) ;
			   setLayout(null);
			   add ( lblOldPwd ) ;
			   add ( txtOldPwd ) ;
	           add ( lblPwd ) ;
	           add ( txtNewPwd ) ;
			   add ( lblNewPwd ) ;
			   add ( txtRetypePwd ) ;
	           add ( okBut ) ;
	           add ( cancelBut) ;
	           add(lblImg);
	 	 }

	 	 void giveListener ( )
	 	 {
	 		 okBut.addActionListener ( new ActList() ) ;
	 		 cancelBut.addActionListener ( new ActList() ) ;
	         txtOldPwd.requestFocus ( ) ;

	 	 }

	 public static void main(String[] args)
	 	{
	 		ChangePassword changePwd =  new ChangePassword ();
	 		JFrame frmChange = new JFrame("Login ");
	 		frmChange.setContentPane(changePwd);
	 		frmChange.setSize(370,200);

	 		// To center the frame
			Dimension dim = frmChange.getToolkit().getScreenSize();
					frmChange.setLocation(dim.width/2 - frmChange.getWidth()/2 ,
			dim.height/2 - frmChange.getHeight()/2 );

			//Place an Image on the Frame
			ImageIcon imgTours = new ImageIcon("C:\\rip\\images\\Login-key.gif");
		    frmChange.setIconImage(imgTours.getImage());

	 		frmChange.setVisible(true);

	 		WindowListener listener = new WindowAdapter ()
	 		{
	 			public void windowClosing(WindowEvent winevt)
	 			{
	 					System.exit(0);
	 			}
	 		} ;//End of WindowListener

	 		frmChange.addWindowListener(listener);


	 	}//End of Main

	 class ActList implements ActionListener
	 {

	 	public void actionPerformed ( ActionEvent e )
	    {
		  if ( e.getSource() == okBut )
		  {

			 char tempOld[] = txtOldPwd.getPassword() ;
			 String pwdOld = new String ( tempOld ) ;

			 char tempNew[] = txtNewPwd.getPassword() ;
			 String pwdNew = new String ( tempNew) ;

			 char tempRetype[] = txtRetypePwd.getPassword() ;
			 String pwdRetype = new String ( tempRetype ) ;

			if ( pwdOld.equals("") || pwdNew.equals("") || pwdRetype.equals("") )
		     {
				JOptionPane.showMessageDialog(null,"Please fill the fields","Incomplete Information",JOptionPane.ERROR_MESSAGE);
				return;
			 }
 			if (!(pwdNew.equals(pwdRetype)))
			{
	JOptionPane.showMessageDialog(null,"Enter New Password again","Invalid New Password",JOptionPane.ERROR_MESSAGE);
				return;

			}

		     try
		     {
                 Class.forName ( "sun.jdbc.odbc.JdbcOdbcDriver" ) ;
                 Connection con = DriverManager.getConnection ( "jdbc:odbc:Tours","","" ) ;
                 Statement stmt = con.createStatement ( ) ;


				String login = "";
				Logframe log = new Logframe();
				login =log.getLogin();

				String sql1  = "Select name from Login where name = '" + login + "' and Pwd = '" + pwdOld + "'"  ;

                ResultSet rs = stmt.executeQuery (sql1);
                rs.next();
                String ans  = rs.getString("Name");

               if (( ans.equals(login))) // Update the Pwd Field
			 {
				 String sql = "UPDATE Login set Pwd = '" + pwdRetype +"'" +
				 				" where name = '" + login + "' " ;
				 int ret =  stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog (null, "Your Password has been changed.","Saved",  JOptionPane.INFORMATION_MESSAGE);//,new ImageIcon ("tips.gif") ) ;
				txtOldPwd.setText("") ;
				txtNewPwd.setText("") ;
				txtRetypePwd.setText("") ;



			 }//End of if stmt

			else // The user entered an Invalid Pwd
			{
				JOptionPane.showMessageDialog (null, "Incorrect Login. Try Again.","Alert",  JOptionPane.INFORMATION_MESSAGE);//,new ImageIcon ("tips.gif") ) ;
				//txtOldPwd.requestFocus ( ) ;

			}


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

		 }// okButon
		  else if ( e.getSource() == cancelBut )
		  {
			Tours.frmLog.setVisible(false);
			Tours.frmTours.setVisible(true);
			Tours.frmTours.setEnabled(true);
		  }
	 }
	}


} //End of class LogFrame
