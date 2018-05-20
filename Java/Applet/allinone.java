import java.awt.*;
import java.applet.*;

/*
<applet code="allinone" width="350" height="350">
</applet>
*/

class mypanel extends Panel
	{
	Label l;
	Button b;
	TextField t;
	TextArea ta;
	Checkbox c;
	Choice ch;
	List li;

	mypanel()
		{
		setLayout(new GridBagLayout());		
		l=new Label("Label",Label.LEFT);
		add(l);

		t=new TextField(20);
		add(t);
		}
	}

public class allinone extends Applet
	{
	mypanel p;
	public void init()
		{

		p=new mypanel();
		add(p);
		}
	}
