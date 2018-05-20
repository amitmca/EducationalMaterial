import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*
<applet code="mouse" width="250" height="250">
</applet>
*/

public class mouse extends Applet implements MouseListener,MouseMotionListener
	{
	TextField t;
	String msg="";
	int x=0,y=0;
	public void init()
		{
		t=new TextField(20);
		add(t);
		addMouseListener(this);
		addMouseMotionListener(this);
		}
	public void mouseClicked(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Clicked "+"  "+x+"  "+y;
		repaint();
		}
	public void mouseEntered(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Entered "+"  "+x+"  "+y;
		repaint();
		}
	public void mouseExited(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Exited "+"  "+x+"  "+y;
		repaint();
		}
	public void mousePressed(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Pressed "+"  "+x+"  "+y;
		repaint();
		}
	public void mouseReleased(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Released "+"  "+x+"  "+y;
		repaint();
		}
	public void mouseDragged(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Dragged "+"  "+x+"  "+y;
		repaint();
		}
	public void mouseMoved(MouseEvent me)
		{
		x=me.getX();
		y=me.getY();
		msg="Mouse Moved "+"  "+x+"  "+y;
		repaint();
		}
	public void paint(Graphics g)
		{
		t.setText(msg);
		}
	}
