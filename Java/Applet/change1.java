import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

/*
<applet code="change1" height="250" width="250">
</applet>
*/

public class change1 extends JApplet implements ActionListener
	{	
	JLabel l;
	JTextField t;
	JButton b;
	JOptionPane jop;
	public void init()
		{
		Container c=getContentPane();
		l=new JLabel("Enter Text Here:");
		c.add(l);

		t=new JTextField(20);
		c.add(t);
	
		b=new JButton("Click");
		c.add(b);
		b.addActionListener(this);
		}		
	public void actionPerformed(ActionEvent ae)
		{
		
		String str = "Please enter the text";
		if(ae.getSource()==b)
			{
			jop.showMessageDialog(null,str,str, jop.INFORMATION_MESSAGE);
			}
		}
	
	}