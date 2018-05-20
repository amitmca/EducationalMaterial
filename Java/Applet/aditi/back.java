import java.awt.*;
import java.applet.*;

/*
<applet code="back" width="250" height="250">
</applet>
*/

public class back extends Applet
	{
	Image i;
	public void init()
		{
		i=getImage(getDocumentBase(),"logo_header.jpg");
		this.setBackground(i);
		}
	public void paint(Graphics g)
		{
		}
	}
