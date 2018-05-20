import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="appletctrls2.class" width="350" height="350">
</applet>  
*/

public class appletctrls2 extends Applet implements ItemListener
        {
        Checkbox c1,c2,c3;
        CheckboxGroup cbg;
        String msg="";
        public void init()
                {
                c1=new Checkbox("Winodows 98/Xp",cbg,true);
                c2=new Checkbox("Windows NT/2000",cbg,false);
                c3=new Checkbox("Unix",cbg,false);
                add(c1);
                add(c2);
                add(c3);                         
                c1.addItemListener(this);
                c2.addItemListener(this);
                c3.addItemListener(this);
                }
        public void itemStateChanged(ItemEvent e)
                {
                repaint();
                }         
        public void paint(Graphics g)
                {
                msg="Current Selection:";
                msg=msg+cbg.getSelectedCheckbox().getLabel();
                g.drawString(msg,6,100);
                }                                              
        }