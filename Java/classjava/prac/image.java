import java.awt.*;
import java.applet.*;

/*
<applet code="image" width="250" height="250">
</applet>
*/

public class image extends Applet
	{
	Image i;
	public void init()
		{
		i=getImage(getDocumentBase(),"btn_exit.png");
		}
	public void paint(Graphics g)
		{
		g.drawImage(i,0,0,this);
		}
	}
