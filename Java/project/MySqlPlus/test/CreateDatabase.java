import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

	public class CreateDatabase extends JInternalFrame implements ActionListener
	{

		private JPanel pNew = new JPanel();
		private JLabel lbdbname;
		private JTextField txtdbname;
		private JButton btnOk, btnCancel;
		private ImageIcon i;
		Login l;

		String u=l.u;
		String p=l.pass;
		
		public CreateDatabase ()
			{
			super ("Create New Database", false, true, false, true);
			setSize (280, 175);
			i=new ImageIcon("images/database.PNG");
			setFrameIcon(i);
			lbdbname = new JLabel ("Database Name:");
			lbdbname.setFont(new Font("verdana", Font.BOLD, 12));
			lbdbname.setBounds (10, 45, 125, 25);    
		        txtdbname = new JTextField ();
			txtdbname.setFont(new Font("verdana", Font.BOLD, 12));
			txtdbname.setBounds (145,45, 125, 25);
			txtdbname.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,15));
			txtdbname.setForeground(Color.red);
			txtdbname.setHorizontalAlignment (JTextField.RIGHT);
			txtdbname.setToolTipText ("Please enter Database Name here...");

			btnOk = new JButton ("Create",new ImageIcon(ClassLoader.getSystemResource("images\\ok.PNG")));
			btnOk.setFont(new Font("verdana", Font.BOLD, 12));
			btnOk.setBounds (20, 100, 100, 25);
			btnOk.addActionListener (this);

			btnCancel = new JButton ("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
			btnCancel.setFont(new Font("verdana", Font.BOLD, 12));
			btnCancel.setBounds (150, 100, 100, 25);
			btnCancel.addActionListener (this);

			txtdbname.addKeyListener (new KeyAdapter () {
				public void keyTyped (KeyEvent ke) {
					char c = ke.getKeyChar ();
					if ( ((Character.isDigit (c)) || (c == KeyEvent.VK_BACK_SPACE))) {
						getToolkit().beep ();
						ke.consume ();
					}
				}
			}
			);
			try
				{
				setMaximum(true);
				Rectangle r=new Rectangle(10,10,280,175);	
				setNormalBounds(r);
				}
			catch(Exception e)
				{
				}
			pNew.setLayout (null);
			pNew.add (lbdbname);
			pNew.add (txtdbname);
			pNew.add (btnOk);
			pNew.add (btnCancel);
			Color c=new Color(220,249,255);
			pNew.setBackground(c);
			getContentPane().add (pNew);
			setVisible (true);
 		}

	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==btnCancel)
			{
			this.setVisible(false);
			}
		if(ae.getSource()==btnOk)
			{
			String dname="";
			dname=txtdbname.getText();
			if(dname.equals(""))
				{
				Toolkit.getDefaultToolkit().beep();	
				JOptionPane.showMessageDialog(null,"Please enter Database Name","Please enter Database Name",JOptionPane.ERROR_MESSAGE);
				}
			else
				{
				try
					{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");		
			
					Statement st=conn.createStatement();
	
					String sql="Create Database "+dname;
	
					st.execute(sql);
		
					String str1="Database Created :  "+dname;

					JOptionPane.showMessageDialog(null,str1,str1,JOptionPane.INFORMATION_MESSAGE); 		

					txtdbname.setText("");

             	
					}
				catch(Exception e)
					{
					String str2=e.getMessage();
					JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 		
					}
				}
			}	
		}
			
	}
