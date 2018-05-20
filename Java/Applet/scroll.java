import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="scroll" width="450" height="450">
</applet>
*/

public class scroll extends Applet implements ActionListener, ContainerListener {
    ScrollPane sp = new ScrollPane (ScrollPane.SCROLLBARS_ALWAYS);
    public void init () {
        setLayout (new BorderLayout ());
        Panel p = new Panel(new GridLayout (7, 8));
        p.addContainerListener (this);
        for (int j=0;j<50;j++)
            p.add (new Button ("Button-" + j));
        sp.add (p);
        add (sp, "Center");
    }
    public void componentAdded(ContainerEvent e) {
        if (e.getID() == ContainerEvent.COMPONENT_ADDED) {
            if (e.getChild() instanceof Button) {
                Button b = (Button)e.getChild();
                b.addActionListener(this);
            }
        }
    }
    public void componentRemoved(ContainerEvent e) {
    }
    public void actionPerformed (ActionEvent e) {
        Dimension d = sp.getViewportSize();
        sp.setScrollPosition ((int)(Math.random()*d.width), 
            (int)(Math.random()*d.height));
    }
}
