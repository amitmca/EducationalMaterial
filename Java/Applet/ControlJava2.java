import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Font;

public class ControlJava2 extends Applet {
Font f = new Font("TimesRoman", Font.BOLD, 60);
String Message;

public void init() {
  Message = new String("Java Test");
}

public void SetMessage(String MsgText) {
   Message = MsgText;
   repaint();
}

public void SetFont(String NewFont, int NewSize) {
   f = new Font(NewFont,Font.BOLD,NewSize);
   repaint();
}

public void paint(Graphics g) {
  g.setFont(f);
  g.drawString(Message, 15, 50);
  }
}

