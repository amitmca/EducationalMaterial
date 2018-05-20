import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="fact" width="250" height="250">
</applet>
*/

public class fact extends Applet implements ActionListener
        {
        Label l1,l2;
        TextField t1,t2;
        Button b,c;     
        String no="",no1="";
        int n,f=1;
        public void init()
                {
               
                l1=new Label("Enter A Number:");
                add(l1);
                t1=new TextField(10);
                add(t1);
                
                l2=new Label("Factorial is:");
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
                
                        if(e.getSource()==b)
                                {
                                no=t1.getText();
                                n=Integer.parseInt(no);
                                for(int i=1;i<=n;i++)
                                        f=f*i;
                                no1=Integer.toString(f);
                                t2.setText(no1);                                        
                                }
                
                                                                     
                if(e.getSource()==c)
                        {
                        t1.setText(" ");
                        t2.setText(" ");
                        }                                
                }                
                     
        }


