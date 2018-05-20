import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;

/*
<applet code="button"  height="250" width="250">
</applet>
*/

public class button extends Applet implements ActionListener
    {
    JButton red;
    JButton green;
    JButton blue;
    TextArea txta;

    public void init() {
        buttonLayout customLayout = new buttonLayout();

        setFont(new Font("Helvetica", Font.PLAIN, 12));
        setLayout(customLayout);
	this.setFont(new Font("verdana",Font.ITALIC,14));
        red = new JButton("RED",new ImageIcon("default-icon.ico"));
        add(red);

        green = new JButton("GREEN");
        add(green);

        blue = new JButton("BLUE");
        add(blue);

        txta = new TextArea(" ",10,30);
        add(txta);

        setSize(getPreferredSize());
	red.addActionListener(this);
	green.addActionListener(this);
	blue.addActionListener(this);

    }

	public	void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==red)
			{
			txta.setText("YOU HAVE PRESSED RED BUTTON");
			this.setBackground(Color.red);
			}
		else if(e.getSource()==green)
			{
			txta.setText("YOU HAVE PRESSED GREEN BUTTON");
			this.setBackground(Color.green);
			}
		else if(e.getSource()==blue)
			{
			txta.setText("YOU HAVE PRESSED BLUE BUTTON");
			this.setBackground(Color.blue);
			}
		}	
	
    public static void main(String args[]) {
        button applet = new button();
        Frame window = new Frame("button");

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

class buttonLayout implements LayoutManager {

    public buttonLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 320 + insets.left + insets.right;
        dim.height = 240 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+56,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+56,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+56,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+96,insets.top+128,152,80);}
    }
}
