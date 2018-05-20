import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="mouse" height="250" width="250">
</applet>
*/

public class mouse extends Applet implements MouseListener,MouseMotionListener
	{
	int x,y;
	TextField txt;
	public void init()
		{
		txt=new TextField(50);
		add(txt);
		addMouseListener(this);
		addMouseMotionListener(this);
		}
	public void mouseClicked(MouseEvent a)
		{
		x=a.getX();
		y=a.getY();
		txt.setText("     "+"Mouse Clicked:(X="+x+",Y="+y+")");
		}
	public void mousePressed(MouseEvent a)
		{
		x=a.getX();
		y=a.getY();
		txt.setText("     "+"Mouse Pressed:(X="+x+",Y="+y+")");
		}
	public void mouseDragged(MouseEvent a)
		{
		x=a.getX();
		y=a.getY();
		txt.setText("     "+"Mouse Dragged:(X="+x+",Y="+y+")");
		}
	public void mouseReleased(MouseEvent a)
		{
		x=a.getX();
		y=a.getY();
		txt.setText("     "+"Mouse Released:(X="+x+",Y="+y+")");
		}
	public void mouseMoved(MouseEvent a)
		{
		x=a.getX();
		y=a.getY();
		txt.setText("     "+"Mouse Moved:(X="+x+",Y="+y+")");
		}
	public void mouseExited(MouseEvent a)
		{
		x=a.getX();
		y=a.getY();
		txt.setText("     "+"Mouse Exited:(X="+x+",Y="+y+")");
		}
	public void mouseEntered(MouseEvent a)
		{
		x=a.getX();
		y=a.getY();
		txt.setText("     "+"Mouse Entered:(X="+x+",Y="+y+")");
		}
	}
