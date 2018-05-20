import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {
    JTextArea ta;
    JScrollPane sp_textarea_1;
    JLabel label_1;

    public Server() {
        ServerLayout customLayout = new ServerLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ta = new JTextArea("");
        sp_textarea_1 = new JScrollPane(ta);
        getContentPane().add(sp_textarea_1);

        label_1 = new JLabel("FROM CLIENT");
        getContentPane().add(label_1);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        Server window = new Server();

        window.setTitle("Server");
        window.pack();
        window.show();
    }
}

class ServerLayout implements LayoutManager {

    public ServerLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 324 + insets.left + insets.right;
        dim.height = 292 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+64,248,184);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+24,216,24);}
    }
}
