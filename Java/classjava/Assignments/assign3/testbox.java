import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class testbox extends Applet implements ActionListener
	{
	Label l1,l2;
	TextField t1,t2;
	Button b;
	String msg="";
	public void init()
		{
		l1=new Label("Source:");
		add(l1);
		t1=new TextField(10);
		add(t1);	
		l2=new Label("Destination:");
		add(l2);
		t2=new TextField(10);
		add(t2);		
		b=new Button("Copy");
		add(b);
		b.addActionListener(this);
		}
	public void actionPerformed(ActionEvent e)
		{
		msg=t1.getText();
		t2.setText(msg);
		}
	}


