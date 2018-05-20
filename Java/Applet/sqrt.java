import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.lang.Math.*;

/*
<applet code="sqrt" width="250" height="250">
</applet>
*/

public class sqrt extends Applet implements ActionListener
        {
        Label l1,l2;
        TextField t1,t2;
        Button b,c;     
       
        public void init()
                {
               
                l1=new Label("Number:");
                add(l1);
                t1=new TextField(10);
                add(t1);
                
                l2=new Label("SQUARE  ROOT:");
                add(l2);
                t2=new TextField(10);
                add(t2);  
                
      
                b=new Button("Calculate");
                add(b);
                b.addActionListener(this); 
                   
                c=new Button("Clear");
                add(c);
                c.addActionListener(this);            
                }
                    
        public void actionPerformed(ActionEvent e)
                {
                int num=Integer.parseInt(t1.getText());
                
                if(e.getSource()==b)
                     {
                     double s=Math.sqrt(num);
                     String m=Double.toString(s);
                     t2.setText(m);                                                             
                     }
                
                                                                     
                if(e.getSource()==c)
                        {
                        t1.setText(" ");
                        t2.setText(" ");
                        }                                
                }                
                     
        }


