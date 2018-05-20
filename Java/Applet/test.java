import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class test extends Applet implements ActionListener
	{
	TextField t1,t2;
	Button b;
	
	public void init()
		{
		Label l1=new Label("Your Text Here:",Label.LEFT);
		add(l1);
		t1=new TextField(30);
		add(t1);
		t2=new TextField(30);
		add(t2);
		b=new Button("DISPLAY");
		add(b);
		b.addActionListener(this);
		}
	public void paint(Graphics g)
		{
		}
	public void actionPerformed(ActionEvent e)
		{
		String c=e.getActionCommand();
		if(/*e.getSource()==b*/ c.equals("DISPLAY"))
			{
			String msg=t1.getText();
			t2.setText(msg);
			}
		}
	}