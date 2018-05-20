import java.awt.*;
import javax.swing.*;

/*
<applet code="check" width="250" height="250">
</applet>
*/

public class check extends JApplet
	{	
	Container cp=getContentPane();
	JLabel l;
	public void init()
		{
		l=new JLabel("This is my Label");
		cp.add(l);
		}
	public void paint(Graphics g)
		{
		}
	}
