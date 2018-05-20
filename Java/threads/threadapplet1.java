import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class threadapplet1 extends Applet implements Runnable,ActionListener
	{
	Thread t;
	String name;
	TextArea txt;
	Button b,c;
	TextField tf1,tf2;
	Label l,u;
	public void init()
		{
		l=new Label("Lower Limit:");
		add(l);
		u=new Label("Upper Limit:");
		add(u);
		tf1=new TextField(10);
		add(tf1);
		tf2=new TextField(10);
		add(tf2);
		txt=new TextArea(5,15);
		add("area",txt);
		b=new Button("Start");
		add(b);
		c=new Button("Clear");
		add(c);
		b.addActionListener(this);	
		c.addActionListener(this);
		}
	public void start()
		{
		t=new Thread(this,"Thread");
		t.start();
		}
	public void run()
		{

		}
	public void actionPerformed(ActionEvent e1)
		{
		String str1=tf1.getText();
		String str2=tf2.getText();
		int lower= Integer.valueOf(str1).intValue();
		int upper= Integer.valueOf(str2).intValue();
		if(e1.getSource()==b)
		{
		try
			{
			for(int i=lower;i<=upper;i++)
				{
				String str = Integer.toString(i*i);
				txt.setText(str);
				Thread.sleep(2000);
				}
			for(int i=lower;i<=upper;i++)
				{
				String str = Integer.toString(i*i*i);
				txt.setText(str);
				Thread.sleep(2000);
				}
			}
		catch(InterruptedException e)
			{ 
			}
		}
		if(e1.getSource()==c)
		{
		tf1.setText("");
		tf2.setText("");
		txt.setText("");	
		}
		}
	}