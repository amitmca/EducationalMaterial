import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="appletctrls2.class" width="350" height="350">
</applet>  
*/

public class appletctrls2 extends Applet implements ItemListener
        {
        Checkbox c1,c2,c3,c4;
        CheckboxGroup cbg1,cbg2;
        String msg="",msg1="";
        public void init()
                {
                cbg1=new CheckboxGroup();
                cbg2=new CheckboxGroup();
                
                c1=new Checkbox("Winodows 98",cbg1,true);
                c2=new Checkbox("Windows NT",cbg1,false);
                c3=new Checkbox("Fedora",cbg2,true);
                c4=new Checkbox("PCQ",cbg2,false);     
                           
                add(c1);
                add(c2);
                add(c3);                        
                add(c4);
                 
                c1.addItemListener(this);
                c2.addItemListener(this);
                c3.addItemListener(this);
                c4.addItemListener(this);
                }
        public void itemStateChanged(ItemEvent e)
                {
                repaint();
                }         
        public void paint(Graphics g)
                {
               
                msg=msg+cbg1.getSelectedCheckbox().getLabel();
                msg1=msg1+cbg2.getSelectedCheckbox().getLabel();
                g.drawString(msg,6,100);
                g.drawString(msg1,6,130);
                }                                              
        }