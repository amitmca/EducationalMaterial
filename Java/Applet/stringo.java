import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="stringo" width=250 height=250>
</applet>
*/

public class stringo extends Applet implements ActionListener
        {
        Label l;
        TextField t1,t2,t3,t4,t5;
        Button b1,b2,b3,b4;
        public void init()
                {
                setLayout(new GridLayout(5,2,5,5));
		setFont(new Font("Times New Roman",Font.BOLD,16));
                l=new Label("Enter String",Label.CENTER);
                add(l);
                t1=new TextField(10);
                add(t1);
                
                b1=new Button("LOWER");
                add(b1);
                b1.addActionListener(this);
                t2=new TextField(10);
                add(t2);
                                                
                b2=new Button("UPPER");
                add(b2);
                b2.addActionListener(this);
                t3=new TextField(10);
                add(t3);
                
                b3=new Button("BOLD");
                add(b3);
                b3.addActionListener(this);
                t4=new TextField(10);
                add(t4);
                
                b4=new Button("ITALIC");
                add(b4);
                b4.addActionListener(this);
                t5=new TextField(10);
                add(t5);                                                
                }
        public void actionPerformed(ActionEvent e)
                {
                String s=t1.getText();
                if(e.getSource()==b1)
                        {
                        t2.setText(s.toLowerCase());
                        }
                if(e.getSource()==b2)
                        {
                        t3.setText(s.toUpperCase());
                        }                 
                if(e.getSource()==b3)
                        {
                        t4.setText(s);
                        t4.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,14));
                        }   
                if(e.getSource()==b4)
                        {
                        t5.setText(s);
                        t5.setFont(new Font("Arial",Font.ITALIC,14));
                        }                                                     
                }                 
        }
        
        

