import java.awt.*;
import java.applet.*;

/*
<applet code="Draw" width="250" height="250">
</applet>
*/

 class DrawingRegion extends Canvas
	{	
	public DrawingRegion()
		{
		setSize(100,50);
		}
	public void paint(Graphics g)
		{
		g.drawRect(0,0,99,49);
		g.drawString("A Canvas",20,20);
		}
	}

public class Draw extends Applet
	{
	public void init()
		{
		DrawingRegion r=new DrawingRegion();
		add(r);
		}
	}
	
