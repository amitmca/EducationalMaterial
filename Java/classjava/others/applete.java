import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="applete" width=250 height=250>
</applet>

*/


public class applete extends Applet implements ActionListener
	{
	Label l;
	Button b;
	TextField t1,t2;
	public void init()
		{
		l=new Label("Enter A String:");
		add(l);
	
		b=new Button("Check");
		add(b);
		b.addActionListener(this);

		t1=new TextField(10);
		add(t1);
		t2=new TextField(20);
		add(t2);

		}
	public void actionPerformed(ActionEvent e)
		{
		String s1;
		if(e.getSource()==b)
			{
			String s=t1.getText();
			int n=s.length();
			if(n<5)
				s1="String Size less than 5";
			else
				s1="Thanks";
			t2.setText(s1);	
			}
		}	
	}	

