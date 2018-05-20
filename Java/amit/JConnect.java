import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JConnect extends JFrame
	{
	jpanel j;
	public JConnect()
		{
		super("Database Application");
		Container contentPane=getContentPane();
		j=new jpanel();
		contentPane.add(j);
		}
	public static void main(String args[])
		{
		final JFrame f=new JConnect();
		f.setBounds(100,100,300,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		f.addWindowListener(new windowAdapter()
			{
			public void windowClosed(windowEvent e)
				{
				System.exit(0);
				}
			});
		}
	}
class jpanel extends JPanel	
	{
	jpanel()
		{
		setBackground(color.white);
		}
	public void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		g.drawString("Swing using JPanel and JFrame !!",50,30);
		g.drawString("This is the Solution !",90,120);
		g.drawString("\"Closing me ends the applicatoion as well\"",35,150);
		}
	}
