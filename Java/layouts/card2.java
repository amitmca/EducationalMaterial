import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="card2" width="250" height="250">
</applet>
*/
class cardPanel extends Panel
	{
	Button b;
	Label l;
	TextField t;	
	cardPanel(card2 applet,String cno)
		{
		b=new Button("Next Card");
		b.addActionListener(applet);
		add(b);
		int c=Integer.parseInt(cno);
		if(c==1)
			{
			l=new Label("This is card :"+cno);
			add(l);
			}
		else if(c==2)
			{
			t=new TextField(10);
			add(t);
			}
		}
	}


public class card2 extends Applet implements ActionListener
	{
	int index=1;
	CardLayout cl;
	cardPanel panel1,panel2,panel3;
	public void init()
		{
		cl=new CardLayout();
		setLayout(cl);
		panel1=new cardPanel(this,"one");
		panel2=new cardPanel(this,"two");
		panel3=new cardPanel(this,"three");
		add("first",panel1);
		add("second",panel2);
		add("third",panel3);
		cl.show(this,"first");
		}		
	public void actionPerformed(ActionEvent ae)
		{
		switch(++index)
			{
			case 1:
				cl.show(this,"first");
				break;
			case 2:
				cl.show(this,"second");
				break;
			case 3:
				cl.show(this,"third");
				break;
			}
		if(index==3) index=0;
		repaint();
		}
	}