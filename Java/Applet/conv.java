import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="conv" width="250" height="250">
</applet>
*/

public class conv extends Applet implements ActionListener
        {
        Label l1,l2,l3,l4;
        TextField t1,t2,t3,t4;
        Button b,c;     
       
        public void init()
                {
               
                l1=new Label("Decimal Number:");
                add(l1);
                t1=new TextField(10);
                add(t1);
                
                l2=new Label("Binary Number:");
                add(l2);
                t2=new TextField(10);
                add(t2);  
                
                l3=new Label("Octal Number:");
                add(l3);
                t3=new TextField(10);
                add(t3); 
                
                l4=new Label("Hexadecimal Number:");
                add(l4);
                t4=new TextField(10);
                add(t4); 
                
                b=new Button("Calculate");
                add(b);
                b.addActionListener(this); 
                   
                c=new Button("Clear");
                add(c);
                c.addActionListener(this);            
                }
        public String getNumber(int n,int r)
                {
                String s="";
                int q;
                char c[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
                for(;n>0;n=n/r)
                        {
                        q=n%r;
                        s=new String(""+c[q]+s);
                        }
                return s;                        
                }                
        public void actionPerformed(ActionEvent e)
                {
                int num=Integer.parseInt(t1.getText());
                
                if(e.getSource()==b)
                                {
                                String bin1,oct1,hex1;
                                
                                bin1=getNumber(num,2);
                                t2.setText(bin1); 
                                
                                oct1=getNumber(num,8);
                                t3.setText(oct1);
                                
                                hex1=getNumber(num,16);
                                t4.setText(hex1);                                             
                                }
                
                                                                     
                if(e.getSource()==c)
                        {
                        t1.setText(" ");
                        t2.setText(" ");
                        t3.setText(" ");
                        t4.setText(" ");                        
                        }                                
                }                
                     
        }


