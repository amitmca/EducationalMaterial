import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener
    {
    JLabel leftlogo;
    JLabel midlogo;
    JLabel label_2;
    JLabel line;
    JLabel label;
    JLabel labelserver;
    JTextField txthost;
    JLabel labelport;
    JTextField txtport;
    JLabel labelusr;
    JTextField txtusr;
    JLabel labelpass;
    JPasswordField txtpass;
    JButton btnok;
    JButton btnclr;
    JButton btncel;
    JLabel label_4;
    JLabel label_5;
    JLabel l1,l2,l3,l4;

    ImageIcon i1,i2,i3,i4,i5,i6,i7;
    JOptionPane jop; 
    Container cp;
	
   public Login()
       {
        LoginLayout customLayout = new LoginLayout();
	cp=getContentPane();
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
        

        i1=new ImageIcon("images/unixODBC.gif");
	i2=new ImageIcon("images/mysql.jpg");
	i3=new ImageIcon("images/connect.gif");
	i4=new ImageIcon("images/top-banner.jpg");
	i5=new ImageIcon("images/Star.gif");
 	i6=new ImageIcon("images/loading5.gif");
	i7=new ImageIcon("images/next.gif");

        getContentPane().setBackground(Color.pink); 
        leftlogo = new JLabel(i1);
        getContentPane().add(leftlogo);

        midlogo = new JLabel(i2);
        getContentPane().add(midlogo);

        label_2 = new JLabel(i3);
        getContentPane().add(label_2);

        line = new JLabel(i4);
        getContentPane().add(line);

        label = new JLabel("         Connect To MySQL");
	label.setForeground(Color.blue);
        getContentPane().add(label);

        labelserver = new JLabel("Server Host");
        getContentPane().add(labelserver);

        txthost = new JTextField("localhost");
	txthost.setFont(new Font("Verdana, Arial, Helvetica", Font.PLAIN, 14));
        getContentPane().add(txthost);

        labelport = new JLabel("Port");
        getContentPane().add(labelport);

        txtport = new JTextField("3306");
	txtport.setFont(new Font("Verdana, Arial, Helvetica", Font.PLAIN, 14));
        getContentPane().add(txtport);

        labelusr = new JLabel("UserName");
        getContentPane().add(labelusr);

        txtusr = new JTextField("root");
	txtusr.setFont(new Font("Verdana, Arial, Helvetica", Font.PLAIN, 14));
        getContentPane().add(txtusr);

        labelpass = new JLabel("Password");
        getContentPane().add(labelpass);

        txtpass = new JPasswordField ("");
	txtpass.setFont(new Font("Verdana, Arial, Helvetica", Font.PLAIN, 14));
        getContentPane().add(txtpass);
	txtpass.setEchoChar('*');

        btnok = new JButton("OK");
        getContentPane().add(btnok);

        btnclr = new JButton("Clear");
        getContentPane().add(btnclr);

        btncel = new JButton("Cancel");
        getContentPane().add(btncel);
	btnok.addActionListener(this);
	btnclr.addActionListener(this);
	btncel.addActionListener(this);

        label_4 = new JLabel(i5);
	getContentPane().add(label_4);
        label_5 = new JLabel(i5);
        getContentPane().add(label_5);

	l1=new JLabel("Connecting Please wait....");
	l2=new JLabel(i6);
	
	l4=new JLabel(i7);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
  
    public void actionPerformed(ActionEvent ae)
	{
	String host=txthost.getText();
	String port=txtport.getText();
	String user=txtusr.getText();
	String pass=txtpass.getText();

	if(ae.getSource()==btncel)
		{
		System.exit(0);
		}
	if(ae.getSource()==btnclr)
		{
		txthost.setText("");	
		txtport.setText("");	
		txtusr.setText("");	
		txtpass.setText("");	
		
		}
	if(ae.getSource()==btnok)
		{
		if(host.equals("") || port.equals("") || user.equals(""))
			{
			Toolkit.getDefaultToolkit().beep();	
			String str1 = "Please fill all the fields";
			jop.showMessageDialog(null,str1,str1, jop.ERROR_MESSAGE);
			}
		else
			{
			if(host.equals("localhost") && port.equals("3306") && user.equals("root") && pass.equals(""))
				{
				try
					{
					
					Thread.sleep(1000);
					add(l4);
					l4.setBounds(5,300,50,50);
					add(l1);
					l1.setBounds(50,300,500,50);
					add(l2);
					l2.setBounds(50,300,500,50);
					
					}
				catch(Exception e)
					{
					
					}

				}
			else	
				{
				Toolkit.getDefaultToolkit().beep();	
				jop.showMessageDialog(null,"Please check UserName and Password","Please check UserName and Password", jop.ERROR_MESSAGE);
				}
			}
		}
	}

    public static void main(String args[]) {
        Login window = new Login();

        window.setTitle("MYSQL QUERY BROWSER");
        window.pack();
        window.show();
    }
}

class LoginLayout implements LayoutManager {

    public LoginLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 410 + insets.left + insets.right;
        dim.height = 362 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,56,48);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+0,304,48);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+0,48,48);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+48,408,8);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+72,168,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+112,128,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+112,136,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+152,128,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+152,136,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+192,128,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+192,136,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+232,128,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+232,136,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+280,56,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+280,64,24);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+280,80,24);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+72,24,24);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+72,24,24);}
    }
}
