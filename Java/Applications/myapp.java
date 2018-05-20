import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;

/*
<applet code="myapp" width=250 height=250>
</applet>
*/

public class myapp extends Applet implements ActionListener 
	{	
	Button b;
	public void init()
		{
		b=new Button("Open");
		add(b);
		b.addActionListener(this);
		}
	public void actionPerformed(ActionEvent e)
		{
		try
			{
			ProcessBuilder p=new ProcessBuilder("calc.exe");
			p.start();
			}
		catch(IOException e1)		
			{
			}
		}
	public void paint(Graphics g)
		{
		
		}
	}
