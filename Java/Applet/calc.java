import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="calc" width=250 height=250>
</applet>
*/

public class calc extends Applet implements ActionListener
        {
        Button on,clear,add,sub,mul,div,equal;
        TextField input;
        int no1,no2,ans;
        char oper; 
        public void init()
                {
                Label l=new Label("Input",Label.LEFT);
                add=new Button("+");
                sub=new Button("-");
                mul=new Button("*");
                div=new Button("/");
                equal=new Button("=");
                on=new Button("On");
                clear=new Button("Clear");
                input=new TextField(20);
                add(l);
                add(input);
                add(add);
                add(sub);
                add(mul);
                add(div);
                add(equal);
                add(on);
                add(clear);
                add.addActionListener(this);
                sub.addActionListener(this);
                mul.addActionListener(this);
                div.addActionListener(this);
                equal.addActionListener(this);
                on.addActionListener(this);
                clear.addActionListener(this);                
                }
        public void actionPerformed(ActionEvent e)
                {
                Button b=(Button)e.getSource();
                if(b==add || b==sub || b==mul || b==div)
                        {
                        no1=Integer.parseInt(input.getText());
                        oper=b.getLabel().charAt(0);
                        input.setText("");
                        }
                if(b==equal)
                        {
                        no2=Integer.parseInt(input.getText());
                        switch(oper)
                                {
                                case '+':
                                        ans=no1+no2;
                                        break;
                                        
                                case '-':
                                        ans=no1-no2;
                                        break;                                        
                                        
                               case '*':
                                        ans=no1*no2;
                                        break;
                               case '/':
                                        ans=no1/no2;
                                        break;                                                                              
                                }
                        input.setText(Integer.toString(ans));                                
                        }                        
                if(b==clear)
                        {
                        input.setText("");
                        }                 
                if(b==on)
                        {
                        input.setEnabled(true);
                        add.setEnabled(true);
                        sub.setEnabled(true);
                        mul.setEnabled(true);
                        div.setEnabled(true);                        
                        }                                                                       
                }                
        }