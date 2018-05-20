import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DropTable extends JFrame {
    JLabel ldb;
    JComboBox dbcombo;
    JLabel ltable;
    JComboBox tablecombo;
    JButton btndrop;
    JButton button_2;

    public DropTable() {
        DropTableLayout customLayout = new DropTableLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ldb = new JLabel("Select Database Name :");
        getContentPane().add(ldb);

        dbcombo = new JComboBox();
        getContentPane().add(dbcombo);

        ltable = new JLabel("Select Table Name :");
        getContentPane().add(ltable);

        tablecombo = new JComboBox();
        getContentPane().add(tablecombo);

        btndrop = new JButton("Drop");
        getContentPane().add(btndrop);

        button_2 = new JButton("Cancel");
        getContentPane().add(button_2);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        DropTable window = new DropTable();

        window.setTitle("DropTable");
        window.pack();
        window.show();
    }
}

class DropTableLayout implements LayoutManager {

    public DropTableLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 297 + insets.left + insets.right;
        dim.height = 244 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+24,216,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+64,168,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+104,216,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+144,168,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+192,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+168,insets.top+192,112,24);}
    }
}
