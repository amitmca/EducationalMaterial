import java.awt.*;
import java.applet.*;
/*
<applet code="aditi.class" width="350" height="350">
</applet>

*/

public class aditi extends Applet implements Runnable
        {
        Image i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
	Thread thr;
	String msg="    WELCOME";
	TextField t;
        public void init()
                {
		thr=new Thread(this,"Aditi");
		thr.start();
		this.setFont(new Font("verdana",Font.BOLD,16));
		t=new TextField(12);
		setBackground(Color.pink);
		setForeground(Color.red);
		t.setBackground(Color.yellow);
		add(t);
		i1=getImage(getDocumentBase(),"0002-1.gif");
                i2=getImage(getDocumentBase(),"image001.gif");
		i3=getImage(getDocumentBase(),"nokia.jpg");
		i4=getImage(getDocumentBase(),"lg.jpg");
		i5=getImage(getDocumentBase(),"sony.jpg");
		i6=getImage(getDocumentBase(),"samsung.jpg");
		i7=getImage(getDocumentBase(),"vodafone.jpg");
		i8=getImage(getDocumentBase(),"motorola.jpg");
		i9=getImage(getDocumentBase(),"o2.jpg");
		i10=getImage(getDocumentBase(),"bar2.gif");
		
                }


	public void run()
		{
		}	

        public void paint(Graphics g)
                {
                g.drawImage(i1,20,20,this);
                g.drawImage(i2,300,30,this);
		try
			{

			t.setText(msg);
			Thread.sleep(400);
			msg=" TO WORLD OF";
			t.setText(msg);
			Thread.sleep(400);
			msg="      MOBILES";
			t.setText(msg);
			msg="    WELCOME";

			g.drawImage(i3,760,35,this);				
			Thread.sleep(500);
			g.drawImage(i4,760,35,this);				
			Thread.sleep(400);
			g.drawImage(i5,760,35,this);
			Thread.sleep(300);
			g.drawImage(i6,760,35,this);
			Thread.sleep(200);
			g.drawImage(i7,760,35,this);
			Thread.sleep(200);
			g.drawImage(i8,760,35,this);
			Thread.sleep(100);
			g.drawImage(i9,760,35,this);
			Thread.sleep(100);
			g.drawImage(i10,0,115,this);
			}
		catch(InterruptedException e)
			{
			}
                }                 
        }
