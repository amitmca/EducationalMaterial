import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="appletctrls3" width="350" height="350">
</applet>  
*/

public class appletctrls3 extends Applet implements ItemListener
        {
        Choice win,linux;   
        String msg=""; 
        public void init()
                {
                win=new Choice();
                linux=new Choice();
                
                win.add("Windows 98");
                win.add("Windows 2000");
                win.add("Windows XP");
                
                linux.add("Fedora 6");
                linux.add("Fedora 8");
                linux.add("Fedora 10");                
                 
                add(win);
                add(linux);
                
                win.addItemListener(this);
                linux.addItemListener(this);                 
                
                }
        public void itemStateChanged(ItemEvent e)
                {
                repaint();
                }         
        public void paint(Graphics g)
                {
                msg="Current Windows OS:";
                msg=msg+win.getSelectedItem();
                g.drawString(msg,6,100);
                
                msg="Current Linux OS:";
                msg=msg+linux.getSelectedItem();
                g.drawString(msg,6,140);
                     
                }                                              
        }