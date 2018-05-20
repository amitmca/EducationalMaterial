import java.awt.*;
import java.applet.*;

/*
<applet code="draw" width="300" height="300">
</applet>
*/

public class draw extends Applet
	{	
	public void init()
		{
		}
	public void paint(Graphics g)
		{
		g.drawOval(100,100,50,50);
		//g.setBackground(Color.red);
		g.fillOval(100,100,50,50);
		}
	}
