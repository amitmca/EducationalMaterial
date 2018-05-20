import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="keylist1" width="250" height="250">
</applet>
*/ 

public class keylist1 extends Applet implements KeyListener
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
                int key=e.getKeyCode();
                switch(key)
                        {
                        case KeyEvent.VK_F1:
                                msg=msg+"<F1>";
                                break;
                                
                        case KeyEvent.VK_F2:
                                msg=msg+"<F2>";
                                break;
                              
                        case KeyEvent.VK_F3:
                                msg=msg+"<F3>";
                                break;      
                                
                       case KeyEvent.VK_PAGE_DOWN:
                                msg=msg+"<PgDn>";
                                break;            
                                
                      case KeyEvent.VK_PAGE_UP:
                                msg=msg+"<PgUp>";
                                break;        

                      case KeyEvent.VK_LEFT:
                                msg=msg+"<Left Arrow>";
                                break;      
                                
                     case KeyEvent.VK_RIGHT:
                                msg=msg+"<Right Arrow>";
                                break;                                                                                                                                                                      
                        }
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