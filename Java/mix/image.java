import java.awt.*;
import java.applet.*;
import java.awt.image.*;

/*
<applet code="image" width=400 height=400>
</applet>
*/

public class image extends Applet
	{
	Image image;
	public void init()
		{
		image=getImage(getDocumentBase(),"image.jpg");
		}
	public void paint(Graphics g)
		{	
		g.drawImage(image,10,10,this);
		}
	
	}
