import java.awt.*;
import java.applet.*;

/*
<applet  code="face"  width="250" height="250">
</applet>
*/

public class face extends Applet
	{	
	Image i;
	public void init()
		{
		i=getImage(getDocumentBase(),"human.gif");
    		}

	    public void paint(Graphics g) 
		{
      	                   g.drawImage(i, 0, 0, this);
	                   }		 
	}
