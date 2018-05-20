import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="scrolltext" width="250" height="200">
</applet>
*/

public class scrolltext extends Applet implements Runnable,ItemListener
	{
	List li;
	String msg="Java Programming";
	char ch;
	Thread t;
	boolean stop;
	public void init()
		{
		li=new List();
		li.add("Red");
		li.add("Green");
		li.add("Blue");
		li.add("Magenta");
		li.add("yellow");
		li.setBounds(15,25,100,75);
		add(li);	
		li.addItemListener(this);
		}
	public void start()
		{
		t=new Thread(this);
		stop=false;
		t.start();
		}
	public void run()
		{
		for(; ;)
			{
			try
				{
				repaint();
				Thread.sleep(250);
				ch=msg.charAt(0);
				msg=msg.substring(1,msg.length());
				msg=msg+ch;
				if(stop)
					break;
				}
			catch(InterruptedException e)
				{
				}
			}
		}

	public void itemStateChanged(ItemEvent ie)
		{
		int i=li.getSelectedIndex();
		switch(i)
			{
			case 0: setForeground(Color.red); break;
			case 1: setForeground(Color.green); break;
			case 2: setForeground(Color.blue); break;
			case 3: setForeground(Color.magenta); break;
			case 4: setForeground(Color.yellow); break;
			}
		}

	public void paint(Graphics g)
		{
		g.drawString(msg,75,140);
		}
	}