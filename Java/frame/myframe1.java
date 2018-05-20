import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class myframe1 extends Frame implements Runnable
        {
        public String msg="Amit";
        public TextArea ta;
        Thread t;
        public myframe1()
                {
                t=new Thread(this,"DB");
                t.start();
                ta=new TextArea(5,15);
                this.add(ta);
                              
                }
        public void run()
                {
                        try
                        {
                        ta.setText(msg);
                        Thread.sleep(1000);
                        ta.setText("Again"+msg);
                        Thread.sleep(500);                        
                        }
                        catch(InterruptedException e)
                        {
                        }
                }                
        public static void main(String args[])
                {
                myframe1 f=new myframe1();
        	f.setSize(300,300);
	        f.setTitle("Database Connector");
        	f.show();
                }
                                            
        }