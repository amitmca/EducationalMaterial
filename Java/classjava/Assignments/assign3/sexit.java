import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class sexit extends JFrame  implements ActionListener
	{	
	JButton jb;
	Container c;
	public sexit()
		{
		c=getContentPane();
		jb=new JButton("Close");
		c.add(jb);
		jb.addActionListener(this);
		}		 
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==jb)
			{
			this.setVisible(false);
			}
		}
	public static void main(String args[])
		{
		sexit se=new sexit();
		se.setSize(200,200);
		se.show();
		}
	}
