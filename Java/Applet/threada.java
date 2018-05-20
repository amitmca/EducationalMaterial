import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
/*
<applet code="threada" width="250" height="250">
</applet>
*/

public class threada extends Applet implements Runnable
        {
        FileInputStream fin;
        FileOutputStream fout;
        Thread t;
        String msg="";
        int i;
        
        public void init()
                {
                setBackground(Color.pink);
                setForeground(Color.black);
                try
                        {
                        fin=new FileInputStream("test.txt");
                        fout=new FileOutputStream("test1.txt");
                        }
                catch(FileNotFoundException e)
                        {
                        }      
                catch(ArrayIndexOutOfBoundsException e1)
                        {
                        }   
                catch(AccessControlException e2)
                        {
                        }                                                               
                }
        public void start()
                {
                t=new Thread(this);
                t.start();
                }
        public void run()  
                {
                msg="Preparing to copy";
                msg=msg+"\n"+"Please wait while copying.....";
               
                try
                        {
                        do
                                {
                                i=fin.read();
                                if(i!=-1)
                                        fout.write(i);
                                 }while(i!=-1);
                         Thread.sleep(2000);                                 
                        msg=msg+"1 file copied";                                 
                        }
                catch(InterruptedException e1)
                        {
                        }      
                catch(IOException e2)
                        {
                        }

                                                                       
                }                
                              
        public void paint(Graphics g)
                {
                g.drawString(msg,50,30);
                }          
                                                                                            
        }