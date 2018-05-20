import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="appletctrls6" width="350" height="350">
</applet>  
*/

public class appletctrls6 extends Applet implements ActionListener
        {
        Label l,l1;
        Button b;
        TextField t,t1;
        String str,str1;
        TextArea ta;
        public void init()
                {
                l=new Label("Username",Label.LEFT);
                add(l);
                t=new TextField(10);
                add(t);             
                l1=new Label("Password:",Label.RIGHT);
                add(l1);
                t1=new TextField(10);
                add(t1);
                t1.setEchoChar('*');             
                b=new Button("Submit");
                ta=new TextArea("",10,30);
                add(b);
                add(ta);
                b.addActionListener(this);
                }
        public void actionPerformed(ActionEvent e)
                {
                str=t.getText();
                str1=t1.getText();
                ta.setText(str);
                ta.append(str1);
                }

        }