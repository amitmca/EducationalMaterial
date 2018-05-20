import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


class LogException extends Exception
{	
	JOptionPane jop;

	public LogException()
	{
		String str = "Invalid Username/Password";
		jop.showMessageDialog(null,str,str, jop.ERROR_MESSAGE);
	}

	public String toString()
	{
		String message = "\n\n\t\tSorry! Your Could not Login";
		
		return message;
	}
}


public class LoginScreen extends JFrame implements ActionListener
    {
    JLabel login;
    JLabel luname;
    JLabel lpass;
    JLabel login1;
    JTextField tname;
    JTextField tpass;
    JButton blogin;
    JButton breset;
    ImageIcon i;
    int cnt = 0;
    JOptionPane jop;
    JLabel mess,mess1;

    public LoginScreen() {
        LoginScreenLayout customLayout = new LoginScreenLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
	Color c=new Color(62,50,20);
         getContentPane().setBackground(c);
        i=new ImageIcon("images/viitlogo.gif");
        login = new JLabel(i);
        getContentPane().add(login);

        luname = new JLabel("User Name");
	luname.setForeground(Color.blue);
        getContentPane().add(luname);

        lpass = new JLabel("Password");
	lpass.setForeground(Color.blue);
        getContentPane().add(lpass);

        login1 = new JLabel("LOGIN");
	login1.setFont(new Font("verdana",Font.BOLD,25));
	login1.setForeground(Color.red);
	getContentPane().add(login1);

        tname = new JTextField("");
	tname.setFont(new Font("verdana",Font.BOLD,15));	
        getContentPane().add(tname);

        tpass = new JPasswordField("");
	tpass.setFont(new Font("verdana",Font.BOLD,15));	
        getContentPane().add(tpass);

        blogin = new JButton("Login");
        getContentPane().add(blogin);

        breset = new JButton("Reset");
        getContentPane().add(breset);

	mess=new JLabel("<html>" + "<font color=\"#FF0000\">" + "<b>" + 
"Connected." + "</b>" + "</font>" + "</html>");
		mess1=new JLabel("<html>" + "<font color=\"#FF0000\">" + "<b>" + 
"Not Connected." + "</b>" + "</font>" + "</html>");	

        setSize(getPreferredSize());
	blogin.addActionListener(this);
	breset.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


	public void actionPerformed(ActionEvent ae)
	{
	
		 Connection con2=null;

		 Statement stmt1;
		String logName="",logPsswd="";
		logName = tname.getText();
		logPsswd = tpass.getText();

		if(ae.getSource()==blogin)
		{
		if(logName.equals("") || logPsswd.equals(""))
			{
			Toolkit.getDefaultToolkit().beep();	
			String str1 = "Please enter both the fields";
			jop.showMessageDialog(null,str1,str1, jop.ERROR_MESSAGE);
			
			
			}
		else
			{
			try
			{
						
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			String text=new String();
					
			con2=DriverManager.getConnection(url,"","");

			stmt1=con2.createStatement();

			String sql="select usr,pass from login ";

			ResultSet rs=stmt1.executeQuery(sql);

			String usr="",pass="";
			
			
			Thread.sleep(500);

			while(rs.next())
				{
		
				usr=rs.getString(1);
		
				pass=rs.getString(2);
				
				if(usr.equals(logName) && pass.equals(logPsswd))
					{
					add(mess);
					mess.setBounds(120,180,80,30);	
					
					Thread.sleep(1000);
					String str = "You have Loggged in Successfully";
					Toolkit.getDefaultToolkit().beep();
					jop.showMessageDialog(null,str,str, jop.INFORMATION_MESSAGE);
					//MainPage m=new MainPage();
					//m.setVisible(true);
					//this.setVisible(false);	
					}
				else	
					{
					Toolkit.getDefaultToolkit().beep();
					add(mess1);
					mess1.setBounds(120,180,80,30);	
					
					tname.setText("");
					tpass.setText("");
					cnt++;
					
					throw new LogException();
					
					}
				}

			}
			catch(InterruptedException e)
			{
			
			}	
			catch(LogException e)
			{
				System.out.println(e);
				remove(mess1);	
			}
			catch(SQLException e1)
			{
			}
			catch(ClassNotFoundException e3)
			{
			
			}
			
			
			if(cnt == 3)
			{
			System.out.print("\n\n");
			System.exit(0);
			}
		}	
		}

		if(ae.getSource()==breset)
		{
		tname.setText("");
		tpass.setText("");
		}
	}





    public static void main(String args[]) {
        LoginScreen window = new LoginScreen();

        window.setTitle("Login");
        window.pack();
        window.show();
    }
}

class LoginScreenLayout implements LayoutManager {

    public LoginScreenLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 598 + insets.left + insets.right;
        dim.height = 410 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+192,insets.top+0,216,184);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+232,120,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+144,insets.top+288,120,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+184,104,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+232,152,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+280,152,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+208,insets.top+336,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+336,72,24);}
    }
}
