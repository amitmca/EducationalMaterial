
// Program for Traffic Signal

import java.awt.*;
import java.applet.*;

/*
<applet  code="traffic"  width="250" height="250">
</applet>
*/

public  class traffic extends Applet 
	{
	boolean r=true,g=false,y=false;
	
	public void init()
		{
		(new Threadtraffic(this)).start();
		}
	public void paint(Graphics gr)
		{
		gr.drawOval(100,50,30,30);
		gr.drawOval(100,100,30,30);
		gr.drawOval(100,150,30,30);
		if(r==true)
			{
			gr.setColor(Color.red);
			gr.fillOval(100,50,30,30);
			}
		if(y==true)
			{
			gr.setColor(Color.yellow);
			gr.fillOval(100,100,30,30);
			}
		if(g==true)
			{
			gr.setColor(Color.green);
			gr.fillOval(100,150,30,30);
			}
		}
	}
class Threadtraffic extends Thread
	{	
	traffic t;
	public Threadtraffic(traffic tfc)
		{
		t=tfc;
		}
	public void run()	
		{
		try
			{
			while(true)
				{
				sleep(1000);
				if(t.r==true)
					{
					t.r=false;
					t.g=true;
					}
				else if(t.g==true)
					{
					t.g=false;
					t.y=true;
					}
				else if(t.y==true)
					{
					t.y=false;
					t.r=true;
					}
				t.repaint();
				}
			}
		catch(InterruptedException e)
			{
			}
		}
	}