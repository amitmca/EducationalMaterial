import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="anonymousdemo" height="250" width="250">
</applet>
*/

public class anonymousdemo extends Applet
	{
	public void init()
		{
		addMouseListener(new MouseAdapter()
			{
			public void mouseClicked(MouseEvent me)
				{
				showStatus("Mouse Clicked");
				}
			});
		}
	}
