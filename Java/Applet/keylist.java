import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="keylist" width="250" height="250">
</applet>
*/ 

public class keylist extends Applet implements KeyListener
        {
        String msg=" ";
        int x=10,y=20;
        public void init()
                {
                addKeyListener(this);
                requestFocus();
                }
        public void keyPressed(KeyEvent e)
                {
                showStatus("Key Down");
                }                
        public void keyReleased(KeyEvent e1)
                {
                showStatus("Key Up");
                }                
        public void keyTyped(KeyEvent e2)
                {
                msg=msg+e2.getKeyChar();
                repaint();
                }         
        public void paint(Graphics g)
                {
                g.drawString(msg,x,y);
                }                                               
        }