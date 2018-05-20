import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="process" width="250" height="250">
</applet>
*/

class mybutton extends Button
	{
	process p;
	mybutton(process pref,String s)
		{
		super(s);
		p=pref;
		enableEvents(AWTEvent.ACTION_EVENT_MASK);
		}
	protected void processActionEvent(ActionEvent e)
		{
		super.processActionEvent(e);
		p.text1.setText("Hello From java");
		}
	}

public class process extends Applet
	{
	TextField text1;
	Button b1;
		public void init()	
		{
		text1=new TextField(20);
		add(text1);
		b1=new mybutton(this,"Click Here!");
		add(b1);
		}
	}