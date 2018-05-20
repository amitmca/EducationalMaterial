import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="choice11" width="250" height="250">
</applet>
*/

class MyChoice11 extends Choice {
    MyChoice11 () {
	super ();
	enableEvents (AWTEvent.ITEM_EVENT_MASK);
    }
    protected void processItemEvent(ItemEvent e) {
	ItemSelectable ie = e.getItemSelectable();
	System.out.println ("Item Selected: " + ie.getSelectedObjects()[0]);
	// If you do not call super.processItemEvent()
	// no listener will be notified
	super.processItemEvent (e);
    }
}

public class choice11 extends Applet implements ItemListener {
    Choice c;
    public void init () {
        String []fonts;
        fonts = Toolkit.getDefaultToolkit().getFontList();
        c = new MyChoice11();
        for (int i = 0; i < fonts.length; i++) {
            c.add (fonts[i]);
        }
	add (c);
	c.addItemListener (this);
   }
    public void itemStateChanged(ItemEvent e)  {
	ItemSelectable ie = e.getItemSelectable();
	System.out.println ("State Change: " + ie.getSelectedObjects()[0]);
    }
}
