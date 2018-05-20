import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="color"  width="250"  height="250">
</applet>
*/

public class color extends Applet implements ActioListener,Runnable
	{
	List li;
	String msg="Java Programming is Great";
	Thread t;
	boolean stop;
	public void  init()
		{
		setFont(new Font("Verdana",Font.BOLD,14));
		li=new List();
		li.add("Red");
		li.add("Blue");
		li.add("Green");
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
		char ch;
		for(; ;)
			{
			try	
				{
				repaint();
				Thread.sleep(250);
				ch=msg.charAt(0);
				msg=msg.substring(1,msg.length());
				msg=msg + ch+" ";
				if(stop)
					break;
				}
			catch(InterruptedException e)
				{
				}
			}
		}
	public void stop()
		{
		stop=true;
		t=null;
		}
	public void itemStateChanged(ItemEvent ie)
		{
		String c=li.getSelectedItem();
		if(c.equals("Red"))
			setForeground(Color.red);
		else if(c.equals("Blue"))
			setForeground(Color.blue);
		else if(c.equals("Green"))
			setForeground(Color.green);
		}
	public void paint(Graphics g)
		{
		g.drawString(msg,500,400);
		}
	}