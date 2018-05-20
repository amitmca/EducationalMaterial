import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class combo extends JFrame implements ItemListener
 {
    JComboBox combobox_1;
    JTextField txt;
    JComboBox combobox_2;

    public combo() {
        comboLayout customLayout = new comboLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        combobox_1 = new JComboBox();
        combobox_1.addItem("item1");
        combobox_1.addItem("item2");
	combobox_1.addItemListener(this);
        getContentPane().add(combobox_1);

        txt = new JTextField("");
        getContentPane().add(txt);

        combobox_2 = new JComboBox();
        combobox_2.addItem("item3");
        combobox_2.addItem("item4");
	combobox_2.addItemListener(this);
        getContentPane().add(combobox_2);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
public void itemStateChanged(ItemEvent ie)
	{
	String a="",b="";
	if(ie.getSource()==combobox_1)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			a=(String)ie.getItem();
			txt.setText(a);
			}
		}
	else if(ie.getSource()==combobox_2)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			b=(String)ie.getItem();
			txt.setText(b);
			}
		}
	}

    public static void main(String args[]) {
        combo window = new combo();

        window.setTitle("combo");
        window.pack();
        window.show();
    }
}

class comboLayout implements LayoutManager {

    public comboLayout() {
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
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+72,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+136,176,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+72,72,24);}
    }
}
