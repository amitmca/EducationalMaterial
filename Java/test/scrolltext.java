import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="scrolltext" height="250" width="250">
</applet>
*/
public class scrolltext extends Applet implements ItemListener,Runnable
	{
	List li;
	boolean stop;
	char ch;
	String msg="Java Programing";
	Thread t;
	public void init()
		{	
		li=new List();
		li.add("Red");
		li.add("Green");
		li.add("Blue");
		li.add("Maganta");
		li.add("pink");
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
			case 0:setForeground(Color.red); break;
			case 1:setForeground(Color.green); break;
			case 2:setForeground(Color.blue); break;
			case 3:setForeground(Color.magenta); break;
			case 4:setForeground(Color.pink); break;
			}
		}
	public void paint(Graphics g)
		{
		g.drawString(msg,100,300);
		}
	}