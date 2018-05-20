import java.awt.*;
import java.applet.*;
import java.io.*;
 /*
 <applet code="threadapplet" width="200" height="200">
</applet>
 */
 
public class threadapplet extends Applet implements Runnable  
        {
        Thread t;
        FileInputStream fin;
        FileOutputStream fout;
        int i;
               
        public void init()
                {
                        try
                        {
                        fin=new FileInputStream("test.txt");
                        fout=new FileOutputStream("test1.txt");
                        }
                        catch(FileNotFoundException e)
                        {
                         return;
                        }
                        catch(ArrayIndexOutOfBoundsException e1)
                        {
                        return;
                        }
                setBackground(Color.cyan);
                setForeground(Color.red);
                }
         public void start()
                {
                t=new Thread(this);
                t.start();
                }
        public void run()
                {
                
                }                                 
        public void paint(Graphics g)
                {
                try
                        {                 
                        g.drawString("Preparing for copy.......",10,20);
                        Thread.sleep(200);
                        g.drawString("Please wait while copying...",10,20);
                       
                        do
                                {
                                i=fin.read();
                                if(i!=-1)
                                        fout.write(i);
  
                                }while(i!=-1);
                        Thread.sleep(1000);       
                        g.drawString("1 file copied",10,20);                                
                        }
                catch(IOException e1)
                        {
                        }                                
                catch(InterruptedException e)
                        {
                        }                                                                                                            
                }                                       
                        
        }
