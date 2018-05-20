import java.awt.*;
import java.applet.*;

/*
<applet code="border" width="250" height="250">
</applet>
*/

public class border extends Applet
	{
	public void init()
		{
		setLayout(new BorderLayout());
		add(new Button("North1"),BorderLayout.NORTH);
		add(new TextField(10),BorderLayout.NORTH);
		add(new TextField(30),BorderLayout.SOUTH);
		add(new Button("West"),BorderLayout.WEST);
		add(new Button("East"),BorderLayout.EAST);		
		add(new Button("Center"),BorderLayout.CENTER);
		}
	}


