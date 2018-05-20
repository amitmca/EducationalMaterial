import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class threadapplet extends Applet implements Runnable,ActionListener
	{
	Thread t;
	String name;
	TextArea txt;
	Button b,s;
	TextField tf;
	Label l;
	public void init()
		{
		l=new Label("How much times:");
		add(l);
		tf=new TextField(10);
		add(tf);
		txt=new TextArea(5,15);
		add("area",txt);
		b=new Button("Start");
		add(b);
		s=new Button("Stop");
		add(s);
		b.addActionListener(this);	
		s.addActionListener(this);	
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
		Object obj=e.getSource();
		String str1=tf.getText();
		int n= Integer.valueOf(str1).intValue();
		if(e1.getSource()==b)			
		{
		try
			{
			for(int i=1;i<=n;i++)
				{
				String str = Integer.toString(i*2);
				txt.setText(str);
				Thread.sleep(2000);
				}
			}
		catch(InterruptedException e)
			{ 
			}
		}
		else
			{
			txt.setText("You Have pressed Stop Button");
			}							
		}
	}