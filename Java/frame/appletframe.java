import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="appletframe" width="300" height="300">
</applet>
*/

class myframe extends Frame
        {

        myframe(String title)
                {
                super(title);
                MyWindowAdapter wadapter=new MyWindowAdapter(this);
                addWindowListener(wadapter); 

                }
        public void paint(Graphics g)
                {
                g.drawString("This is a frame window",10,40);
                }                
       }
class MyWindowAdapter extends WindowAdapter
        {
        myframe mf;
        public MyWindowAdapter(myframe mf)
                {
                this.mf=mf;
                }
        public void windowClosing(WindowEvent e)
                {
                mf.setVisible(false);
                }                
        }       
public class appletframe extends Applet implements ActionListener,Runnable
         {
         Frame f;
         Thread t; 		
	 Button b;
	 TextField tf;
	 String msg="======";	
	 Image image;
         public void init()
                {
		t=new Thread(this,"Frame");
		t.start();
                f=new myframe("A frame window");
		b=new Button("Show Frame");
		add(b);
		b.addActionListener(this);
		tf=new TextField(20);
		add(tf);
                f.setSize(250,250);
		image=getImage(getDocumentBase(),"0002-1.gif");
		
                }      
	public void run()    
		{
		}
	public void actionPerformed(ActionEvent e)
		{

		try
			{
			if(e.getSource()==b)
				{
				tf.setText(msg);
				Thread.sleep(1000);
				msg=msg+"=====";
				tf.setText(msg);		
				Thread.sleep(1000);
	                	f.setVisible(true);  
				}
			}
		catch(InterruptedException e1)
			{
			}
		}
          
       public void stop()
                {
                f.setVisible(false);                
                }                 
        public void paint(Graphics g)
                {
		g.drawImage(image,0,0,this);
                }                                 
         }