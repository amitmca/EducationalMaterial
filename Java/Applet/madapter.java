import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="madapter" width="250" height="250">
</applet> 
*/ 

public class madapter extends Applet
        {
        public void init()
                {
                addMouseListener(new MyMouseAdapter(this));
                addMouseMotionListener(new MyMouseMotionAdapter(this));
                }
        }
class MyMouseAdapter extends MouseAdapter
        {
        madapter m;
        public MyMouseAdapter(madapter m)
                {
                this.m=m;
                } 
        public void mouseClicked(MouseEvent e)
                {
                m.showStatus("Mouse Clicked");
                }   
        public void mouseReleased(MouseEvent e1)
                {
                m.showStatus("Mouse Released");
                }
        }

class MyMouseMotionAdapter extends MouseMotionAdapter
        {
        madapter m;
        public MyMouseMotionAdapter(madapter m)
                {
                this.m=m;
                }        
        public void mouseDragged(MouseEvent e1)
                {
                m.showStatus("Mouse Dragged");
                }                 
        }         
