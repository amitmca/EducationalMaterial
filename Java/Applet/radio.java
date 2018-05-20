import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="radio" height="250" width="250">
</applet>
*/

public class radio extends Applet implements ItemListener
	{
	CheckboxGroup r;
	Checkbox r1,r2;
	TextField t1;
	public void init()
		{
		r=new CheckboxGroup();
		
		r1=new Checkbox("1",false,r);
		add(r1);
		r1.addItemListener(this);

		r2=new Checkbox("2",false,r);
		add(r2);
		r2.addItemListener(this);

		t1=new TextField(20);
		add(t1);
		}
	
	public void itemStateChanged(ItemEvent e)
		{
		if(e.getItemSelectable()==r1)
			{
			t1.setText("Radio  1 clicked");
			}
		else
		if(e.getItemSelectable()==r2)
			{
			t1.setText("Radio 2 clicked");
			}
		}

	}


