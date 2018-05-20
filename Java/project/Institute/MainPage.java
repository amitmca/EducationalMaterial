import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPage extends JFrame {
    JLabel label_1;
    JLabel label_4;
    JButton bstud;
    JButton bcourse;
    JButton bschd;
    JButton bexam;
    JLabel label_3;
    ImageIcon i1,i2,i3;

    public MainPage() {
        MainPageLayout customLayout = new MainPageLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
	i1=new ImageIcon("images/front.jpg");
	i2=new ImageIcon("images/logo_header.jpg");
	i3=new ImageIcon("images/college.jpg");

        label_1 = new JLabel(i1);
        getContentPane().add(label_1);
	Color c=new Color(90,21,20);
         getContentPane().setBackground(c);
        label_4 = new JLabel(i2);
        getContentPane().add(label_4);

        bstud = new JButton("Student");
        getContentPane().add(bstud);

        bcourse = new JButton("Course");
        getContentPane().add(bcourse);

        bschd = new JButton("Schedule");
        getContentPane().add(bschd);

        bexam = new JButton("Examination");
        getContentPane().add(bexam);

        label_3 = new JLabel(i3);
        getContentPane().add(label_3);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        MainPage window = new MainPage();

        window.setTitle("Welcome To VIIT");
        window.pack();
        window.show();
    }
}

class MainPageLayout implements LayoutManager {

    public MainPageLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 651 + insets.left + insets.right;
        dim.height = 609 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+24,560,168);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+192,560,56);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+208,104,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+208,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+320,insets.top+208,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+456,insets.top+208,120,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+248,560,360);}
    }
}
