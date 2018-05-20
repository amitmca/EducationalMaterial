import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class progress extends JFrame implements Runnable
	{
	JProgressBar jpb=new JProgressBar();
	Thread t;
	Container c;
	public progress()
		{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		//setBackground(Color.pink);
		t=new Thread(this,"Progress Thread");
		t.start	();
		c.add(jpb);
		Label l=new Label("Please wait while saving......");
		l.setFont(new Font("verdana",Font.BOLD,12));
		l.setForeground(Color.red);
		add(l);
		jpb.setStringPainted(true);
		this.setSize(175,100);
		this.setVisible(true);
		}	
	public void run()
		{
		try
			{
			for(int i=10;i<100;i++)
				{
				jpb.setValue(jpb.getValue()+i);
				Thread.sleep(100);
				}
			}
		catch(InterruptedException e)
			{
			}
		c.remove(jpb);
		}
	/*public static void main(String a[])
		{
		progress p=new progress();
		}*/
	}