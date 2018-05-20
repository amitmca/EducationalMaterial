import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="appletctrls" width="350" height="350">
</applet>  
*/

public class appletctrls extends Applet implements ActionListener
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
                       /* String txt=l.getText();
                        l.setText("Text Changed");
                        b.setLabel("Pressed Ok");*/
                        str=t.getText();
                        int n = Integer.valueOf(str).intValue();
                        TextField tf[]=new TextField[n];
                        Button bb[]=new Button[n];
                        for(int i=0;i<n;i++)
                                {
                                tf[i]=new TextField(10);
                                add(tf[i]);
                                bb[i]=new Button("Ok");
                                add(bb[i]);
                                }            
                        }                                                                
                }                
        }