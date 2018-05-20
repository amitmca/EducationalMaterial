import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SelectAll extends JFrame implements ActionListener
	 {
    JTextArea txt;
    JScrollPane sp_txt;
    JButton btnselect;

    public SelectAll() {
        SelectAllLayout customLayout = new SelectAllLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        txt = new JTextArea("A R Rahman Is Great");
        sp_txt = new JScrollPane(txt);
        getContentPane().add(sp_txt);

        btnselect = new JButton("Select");
	btnselect.addActionListener(this);
        getContentPane().add(btnselect);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btnselect)
		{
		txt.selectAll();
		}
	}

    public static void main(String args[]) {
        SelectAll window = new SelectAll();

        window.setTitle("SelectAll");
        window.pack();
        window.show();
    }
}

class SelectAllLayout implements LayoutManager {

    public SelectAllLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 300 + insets.left + insets.right;
        dim.height = 193 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+24,208,96);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+144,72,24);}
    }
}
