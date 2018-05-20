import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="checkbox" height="250" width="250">
</applet>
*/

public class checkbox extends Applet implements ItemListener
	{
	Checkbox c1,c2;
	TextField t1;
	public void init()
		{
		c1=new Checkbox("1");
		add(c1);
		c1.addItemListener(this);

		c2=new Checkbox("2");
		add(c2);
		c2.addItemListener(this);

		t1=new TextField(20);
		add(t1);
		}
	
	public void itemStateChanged(ItemEvent e)
		{
		if(e.getItemSelectable()==c1)
			{
			t1.setText("Check Box 1 clicked");
			}
		else
		if(e.getItemSelectable()==c2)
			{
			t1.setText("Check Box 2 clicked");
			}
		}

	}


