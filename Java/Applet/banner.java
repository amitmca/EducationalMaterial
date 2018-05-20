import java.awt.*;
import java.applet.*;
/*
<applet code="banner" width="250" height="250">
</applet>
*/

public class banner extends Applet implements Runnable
        {
        String msg="This is an example";
        Thread t=null;
        int state;
        boolean flag;
        public void init()
                {
                setBackground(Color.cyan);
                setForeground(Color.red);
                }
        public void start()
                {
                t=new Thread(this);
                flag=false;
                t.start();
                }
        public void run()
                {
                char ch;
                for(; ;)
                        {
                        try
                                {
                                repaint();
                                Thread.sleep(250);
                                ch=msg.charAt(0);
                                msg=msg.substring(1,msg.length());
                                msg=msg+ch;
                                if(flag)
                                        break;
                                                                                
                                }
                          catch(InterruptedException e)
                                {
                                }                                      
                        }
                }                        
         public void stop()
                {
                flag=true;
                t=null;
                }                         
        public void paint(Graphics g)
                {
                g.drawString(msg,50,30);
                }                                                                                
        }