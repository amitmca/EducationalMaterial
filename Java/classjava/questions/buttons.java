import java.awt.*;
import java.applet.*;

/*
<applet code="buttons" height="250" width="250">
</applet>
*/

public class buttons extends Applet
	{
	Button b1,b2,b3,b4,b5;
	public void init()
		{
		setLayout(new GridLayout(2,3,10,10));
		b1=new Button("First");
		add(b1);
		b2=new Button("Second");
		add(b2);
		b3=new Button("Third");
		add(b3);
		b4=new Button("Fourth");
		add(b4);
		b5=new Button("Fifth");
		add(b5);
		}
	}

