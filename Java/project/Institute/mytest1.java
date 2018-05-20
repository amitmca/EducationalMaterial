import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mytest1 extends JFrame {
    JLabel lname;
    JTextField tname;
    JLabel lage;
    JTextField tage;
    JButton bshow;
    JButton bsave;
    ButtonGroup cbg;
    JRadioButton btech;
    JRadioButton mca;
    JLabel lquali;
    JButton bexit;
    JTextArea textarea_2;
    JScrollPane sp_textarea_2;
    JLabel label_2;
	  ImageIcon name,save,age,quali;

    public mytest1() {
        mytestLayout customLayout = new mytestLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        name=new ImageIcon("name.gif");
        lname = new JLabel(name);
        getContentPane().add(lname);

        tname = new JTextField("");
        getContentPane().add(tname);

        age=new ImageIcon("age.gif");
        lage = new JLabel(age);
        getContentPane().add(lage);

        tage = new JTextField("");
        getContentPane().add(tage);

        bshow = new JButton("SHOW");
        getContentPane().add(bshow);

        bsave = new JButton("SAVE");
        getContentPane().add(bsave);

        cbg = new ButtonGroup();
        btech = new JRadioButton("B.TECH", false);
        cbg.add(btech);
        getContentPane().add(btech);

        mca = new JRadioButton("MCA", false);
        cbg.add(mca);
        getContentPane().add(mca);

	quali=new ImageIcon("quali.gif");
        lquali = new JLabel(quali);
        getContentPane().add(lquali);

        bexit = new JButton("EXIT");
        getContentPane().add(bexit);

        textarea_2 = new JTextArea("");
        sp_textarea_2 = new JScrollPane(textarea_2);
        getContentPane().add(sp_textarea_2);

        save=new ImageIcon("save.gif");
        label_2 = new JLabel(save);
        getContentPane().add(label_2);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        mytest window = new mytest();

        window.setTitle("mytest");
        window.pack();
        window.show();
    }
}

class mytestLayout implements LayoutManager {

    public mytestLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 319 + insets.left + insets.right;
        dim.height = 422 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+40,128,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+40,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+88,128,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+88,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+208,80,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+208,80,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+128,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+152,72,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+136,184,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+208,72,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+248,272,160);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,312,24);}
    }
}
