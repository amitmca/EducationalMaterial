import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;

/*
<applet code="copy" width="250" height="250">
</applet>
*/

public class copy extends JApplet implements ActionListener
 {
    JTextArea ta1;
    JScrollPane sp_ta1;
    JButton cut1;
    JButton paste1;
    JTextArea ta2;
    JScrollPane sp_ta2;
    JButton copy1;
    JButton cut2;
    JButton copy2;
    JButton paste2;
    String text="",text1="";
	
    public void init() {
        copyLayout customLayout = new copyLayout();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);
	  setBackground(Color.cyan);	
        ta1 = new JTextArea("");
        sp_ta1 = new JScrollPane(ta1);
        add(sp_ta1);

        cut1 = new JButton("CUT");
        add(cut1);

        paste1 = new JButton("PASTE");
        add(paste1);

        ta2 = new JTextArea("");
        sp_ta2 = new JScrollPane(ta2);
        add(sp_ta2);

        copy1 = new JButton("COPY");
        add(copy1);

        cut2 = new JButton("CUT");
        add(cut2);

        copy2 = new JButton("COPY");
        add(copy2);

        paste2 = new JButton("PASTE");
        add(paste2);

        setSize(getPreferredSize());
 	  cut1.addActionListener(this);
	  copy1.addActionListener(this);
	  paste1.addActionListener(this);

 	  cut2.addActionListener(this);
	  copy2.addActionListener(this);
	  paste2.addActionListener(this);

    }
public void actionPerformed(ActionEvent ae)
	{
	
	if(ae.getSource()==copy1)
		{
		text=ta1.getText();
		}
	if(ae.getSource()==paste2)
		{
		ta2.setText(text);
		}
	if(ae.getSource()==copy2)
		{
		text=ta2.getText();
		}
	if(ae.getSource()==paste1)
		{
		ta1.setText(text);
		}
	
	}


    public static void main(String args[]) {
        copy applet = new copy();
        Frame window = new Frame("copy");

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        applet.init();
        window.add("Center", applet);
        window.pack();
        window.setVisible(true);
    }
}

class copyLayout implements LayoutManager {

    public copyLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 542 + insets.left + insets.right;
        dim.height = 184 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+24,248,104);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+144,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+144,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+24,264,104);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+144,72,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+144,72,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+376,insets.top+144,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+456,insets.top+144,72,24);}
    }
}
