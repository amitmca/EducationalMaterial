import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*
<applet code="mouse.class" width="500" height="500">
</applet>
*/
public class mouse extends Applet implements MouseListener,MouseMotionListener,KeyListener
{
      String m,mm,k;
      public void init()
      {
            m="";
            mm="";
            k="";
            System.out.println("Init");
            addMouseListener(this);
            addMouseMotionListener(this);
            addKeyListener(this);
      }
      public void paint(Graphics g)
      {
            g.drawString(m,10,10);
            g.drawString(mm,10,100);
            g.drawString(k,10,200);
      }
      public void start()
      {
}
public void stop()
{
      System.out.println("Stop");
}
public void destroy()
{
      System.out.println("Destroy");
}
public void mouseClicked(MouseEvent me)
{
      m=" Mouse Clicked";
      repaint();
}
public void mouseEntered(MouseEvent me)
{
      m=" Mouse Entered";
      repaint();
}
public void mouseExited(MouseEvent me)
{
      m=" Mouse Exited";
      repaint();
}
public void mousePressed(MouseEvent me)
{
      m=" Mouse Pressed";
      repaint();
}
public void mouseReleased(MouseEvent me)
{
      m=" Mouse Released";
      repaint();
}
public void mouseDragged(MouseEvent me)
{
      mm=" Mouse Dragged Positions"+me.getX()+","+me.getY();
      repaint();
}
public void mouseMoved(MouseEvent me)
{
      mm=" Mouse Moved"+me.getX()+","+me.getY();
      repaint();
}
public void keyPressed(KeyEvent ke)
{
      k=" Key Pressed :"+ke.getKeyChar();
      repaint();
}
public void keyReleased(KeyEvent ke)
{
      k=" Key Released:"+ke.getKeyChar();
      repaint();
}
public void keyTyped(KeyEvent ke)
{
      k=" Key Typed : Char "+ke.getKeyChar();
      repaint();
}
}
