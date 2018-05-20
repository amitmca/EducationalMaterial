import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="appletctrls5" width="350" height="350">
</applet>  
*/

public class appletctrls5 extends Applet implements ActionListener
        {
        Label l;
        Button b;
        TextField t;
        String str;
        public void init()
                {
                l=new Label("Name",Label.LEFT);
                add(l);
                b=new Button("Ok");
                add(b);
                b.addActionListener(this);
                t=new TextField(10);
                add(t);                                                
                }
        public void actionPerformed(ActionEvent e)
                {
                if(e.getSource()==b)
                        {
                        str=t.getText();
                        l.setText(str);           
                        }                                                                
                }                
        }