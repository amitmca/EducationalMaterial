import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class threadapplet2 extends Applet implements Runnable,ActionListener
	{
	Thread t;
	String name;
	TextArea txt;
	Button b,s;
	TextField tf;
	Label l;
	public void init()
		{
		l=new Label("How much Numbers:");
		add(l);
		tf=new TextField(10);
		add(tf);
		txt=new TextArea(5,15);
		add("area",txt);
		b=new Button("Start");
		add(b);
		b.addActionListener(this);	
			
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
		String str1=tf.getText();
		int n= Integer.valueOf(str1).intValue();
		int r=0,sum=0;
		
		try
			{
			for(int i=1;i<=n;i++)
				{
				while(i>0)
					{
					r=i%10;
					sum=sum+r*r*r;
					i=i/10;						
					Thread.sleep(2000);
					}
				String str = Integer.toString(sum);
				txt.setText(str);
				r=0;
				sum=0;
				}
		
			}
		catch(InterruptedException e)
			{ 
			}
									
		}
	}