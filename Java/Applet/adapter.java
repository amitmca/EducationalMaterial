import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="adapter" height="250" width="250">
</applet>
*/

public class adapter extends Applet
	{
	public String s="Hello From Java";
	public void init()
		{
		addMouseListener(new ma(this));
		}
	public void paint(Graphics g)
		{
		g.drawString(s,30,100);
		}
	}

class ma extends MouseAdapter
	{
	adapter a;
	ma(adapter a1)
		{
		a=a1;
		}
	public void mouseClicked(MouseEvent e)
		{
		a.s="Hello From Java";
		a.repaint();
		}
	public void mousePressed(MouseEvent e1)
		{
		a.showStatus("Amit");
		a.repaint();
		}
	public void mouseReleased(MouseEvent e2)
		{
		a.showStatus("Mouse Released");
		}
	}

