import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="scrollbars" width="250" height="250">
</applet>
*/

public class scrollbars extends Applet implements AdjustmentListener,MouseMotionListener
        {
        String msg="";
        Scrollbar v,h;
        public void init()
                {
                int width=Integer.parseInt(getParameter("width"));
                int height=Integer.parseInt(getParameter("height"));
                v=new Scrollbar(Scrollbar.VERTICAL,0,1,0,height);
                h=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,width);
                add(v);
                add(h);
                v.addAdjustmentListener(this);
                h.addAdjustmentListener(this);
                addMouseMotionListener(this);
                }
        public void mouseMoved(MouseEvent me)
                {
                }
        public void mouseDragged(MouseEvent e)
                {
                int x=e.getX();
                int y=e.getY();
                v.setValue(y);
                h.setValue(x);
                repaint();
                }                                
        public void adjustmentValueChanged(AdjustmentEvent e1)
                {
                repaint();
                }         
        public void paint(Graphics g)
                {
                msg="Vertical:"+v.getValue();
                msg=msg+",  Horizontal:"+h.getValue();
                g.drawString(msg,6,160);
                g.drawString("*",h.getValue(),v.getValue());
                }                       
        }  