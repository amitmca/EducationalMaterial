import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
<applet code="progress" width="100" height="100">
</applet>
*/

public class progress extends JApplet implements Runnable
	{
	JProgressBar jpb=new JProgressBar();
	Thread t;
	Container c;
	public void init()
		{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		setBackground(Color.pink);
		t=new Thread(this,"Progress Thread");
		t.start	();
		c.add(jpb);
		jpb.setStringPainted(true);
		}	
	public void run()
		{
		try
			{
			for(int i=10;i<100;i++)
				{
				jpb.setValue(jpb.getValue()+i);
				Thread.sleep(500);
				}
			}
		catch(InterruptedException e)
			{
			}
		c.remove(jpb);
		}
			
	}