import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="appletctrls4" width="350" height="350">
</applet>  
*/

public class appletctrls4 extends Applet implements ItemListener
        {
        List win,linux;   
        String msg=""; 
        public void init()
                {
                win=new List(3,true);
                linux=new List(3,false);
                
                win.add("Windows 98");
                win.add("Windows 2000");
                win.add("Windows XP");
                
                linux.add("Fedora 6");
                linux.add("Fedora 8");
                linux.add("Fedora 10");                
                 
                add(win);
                add(linux);
                linux.select(1);
                
                win.addItemListener(this);
                linux.addItemListener(this);                 
                
                }
        public void itemStateChanged(ItemEvent e)
                {
                repaint();
                }         
        public void paint(Graphics g)
                {
                int idx[];
                msg="Current Windows OS:";
                idx=win.getSelectedIndexes();
                for(int i=0;i<idx.length;i++)
                        msg=msg+win.getItem(idx[i])+" ";
                g.drawString(msg,6,120);
                msg="Current Linux OS:";
                msg=msg+linux.getSelectedItem();
                g.drawString(msg,6,140);                                                        
                }                                              
        }