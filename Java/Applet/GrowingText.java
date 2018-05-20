import java.awt.*;

import java.applet.*;

/*
<applet code="GrowingText" width="500" height="500">
</applet>
*/

public class GrowingText extends Applet implements Runnable {

  String fontName = "TimesRoman", text = "AMIT", bgColor, fgColor;

  Thread killme = null;

  boolean threadSuspended = false, blur = false;

  int fonts[] = { 8, 12, 14, 18, 24, 36,48,96 };

  int delay = 500, numFonts = 6, fontIndex = 0, fontStyle;

  Font appFont;

  public void init() {

    String param;

    boolean fontBold = true, fontItalic = false;

    param = getParameter("text");

    if (param != null) { text = param; }

    param = getParameter("delay");

    if (param != null) { delay = Integer.parseInt(param); }

    param = getParameter("fontName");

    if (param != null) { fontName = param; }

    param = getParameter("fontBold");

    if (param != null) { fontBold = param.equals("true"); }

    param = getParameter("fontItalic");

    if (param != null) { fontItalic = param.equals("true"); }

    fontStyle = (fontBold ? Font.BOLD : Font.PLAIN) +

      (fontItalic ? Font.ITALIC : Font.PLAIN);

    bgColor = getParameter("bgColor");

    if (bgColor == null) { bgColor = "Color.pink"; }

    setBackground(colorFromString(bgColor, Color.pink));

    fgColor = getParameter("fgColor");

    if (fgColor == null) { fgColor = "Color.green"; }

    setForeground(colorFromString(fgColor, Color.blue));

    param = getParameter("blur");

    if (param != null) { blur = param.equals("true"); }

    /* Resize applet to fit string with largest font.

       Only works in JDK appletviewer, Netscape ignores it */

    /* FontMetrics fm = getFontMetrics(new Font(fontName, fontStyle, fonts[numFonts-1]));

resize(fm.stringWidth(s) + 20, appFont.getSize() + 20); */

  }

  public void start() {

    if (killme == null) {

      killme = new Thread(this);

      killme.start();

    }

  }

  public void stop() {

    if (killme != null) {

      killme.stop();

      killme = null;

    }

  }

  public void run() {

    while (killme != null) {

      repaint();

      try { Thread.sleep(delay); } catch (InterruptedException e) {};

    }

    killme = null;

  }

  public void update(Graphics g) {

    if (blur) {

      if (fontIndex > numFonts - 1 ) {

        g.clearRect(0, 0, size().width, size().height);

      }

      paint(g);

    } else {

      g.clearRect(0, 0, size().width, size().height);

      paint(g);

    }

  }

  public void paint(Graphics g) {

    if (bgColor.equalsIgnoreCase("random")) {

      setBackground(colorFromString(bgColor, Color.lightGray));

    }

    if (fgColor.equalsIgnoreCase("random")) {

      setForeground(colorFromString(fgColor, Color.black));

    }

    if (fontIndex > numFonts - 1 ) {

      fontIndex = 0;

    }

    g.setFont(appFont = new Font(fontName, fontStyle, fonts[fontIndex++]));

    FontMetrics fm = getFontMetrics(appFont);

    g.drawString(text, (size().width - fm.stringWidth(text))/2,

      (size().height/2)+10);

  }

  public boolean mouseDown(Event evt, int x, int y) {

    if (threadSuspended) {

      killme.resume();

    } else {

      killme.suspend();

    }

    threadSuspended = !threadSuspended;

    return true;

  }

  public Color colorFromString(String str, Color defaultColor) {

    if (str.equalsIgnoreCase("random")) {

      return new Color((int)(Math.random() * 256),  (int)(Math.random() * 256), (int)(Math.random() * 256));

} else {

      try {

        Integer i = Integer.valueOf(str, 16);

        return new Color(i.intValue());

      } catch (NumberFormatException e) {

         return defaultColor;

      }

    }

  }

  public String getAppletInfo() {

    return "GrowingText effect by Jamie M. Hall, 1996";

  }

}