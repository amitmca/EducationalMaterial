import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="mouse" width="250" height="250">
</applet>
*/

public class mouse extends Applet implements MouseListener,MouseMotionListener
	{
	int x,y;
	String msg="";
	public void init()
		{
		addMouseListener(this);
		addMouseMotionListener(this);
		}
	public void mouseClicked(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Clicked at position x="+x+" y="+y;
		showStatus(msg);
		}
	
	public void mousePressed(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Pressed at position x="+x+" y="+y;
		showStatus(msg);
		}

	public void mouseReleased(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Released at position x="+x+" y="+y;
		showStatus(msg);
		}

	public void mouseEntered(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Entered at position x="+x+" y="+y;
		showStatus(msg);
		}

	public void mouseExited(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Exited at position x="+x+" y="+y;
		showStatus(msg);
		}
	

	public void mouseDragged(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Dragged at position x="+x+" y="+y;
		showStatus(msg);
		}

	public void mouseMoved(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Moved at position x="+x+" y="+y;
		showStatus(msg);
		}
	}
