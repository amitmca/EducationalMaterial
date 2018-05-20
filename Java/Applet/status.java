import java.awt.*;
import java.applet.*;

/*
<applet code="status" width="250" height="250">
</applet>
*/

public class status extends Applet implements MouseListener 
        {
        public void init()
                {
                setBackground(Color.cyan);
                }
        public void paint(Graphics g)
                {
                g.drawString("This is a program for status bar",10,20);
                int x=getX();
                String v = Integer.toString(x);
                showStatus(v);                        
                }                
        }