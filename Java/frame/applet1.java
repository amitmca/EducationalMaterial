import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;


public class applet1 extends JFrame implements ActionListener
	{
	Container cp=getContentPane();
	JTextField t=new JTextField();
	
	public applet1()
		{
		setLayout(null);
		t.setBounds(10,10,100,25);
		cp.add(t);
		}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==
		}
	public static void main(String args[])
		{
		applet1 a=new applet1();
		a.setVisible(true);
		a.show();
		}
	}