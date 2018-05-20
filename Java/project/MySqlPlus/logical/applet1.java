import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="applet1" width="250" height="250">
</applet>
*/

public class applet1 extends Applet implements ActionListener
	{
	TextField t;
	Button b;
	public void init()
		{
		t=new TextField(20);
		add(t);
		b=new Button("Ok");
		add(b);
		b.addActionListener(this);
		}
	public void paint(Graphics g)
		{
		}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==b)
			{
			int a=Integer.parseInt(t.getText());
			TextField b[]=new TextField[a];
			for(int i=0;i<a;i++)
				{
				b[i]=new TextField();
				add(b[i]);
				}
			}
		}
	}	
