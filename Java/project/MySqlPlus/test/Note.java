import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Note extends JInternalFrame 
  {
    JLabel label_1;
    JLabel label_2;
    JLabel label_3;
    JLabel label_4;
    ImageIcon i;	

    public Note() 
        {
	super("Note");
	ImageIcon i2=new ImageIcon("images/blink.gif");
	setFrameIcon(i2);
	setLocation(200,5);
        NoteLayout customLayout = new NoteLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Note :");
	label_1.setFont(new Font("verdana",Font.BOLD,12));
	label_1.setForeground(Color.yellow);
        getContentPane().add(label_1);

	//i=new ImageIcon("images/arrowlg.gif");
        label_2 = new JLabel("==>");
	label_1.setForeground(Color.red);	
        getContentPane().add(label_2);

        label_3 = new JLabel("Use Database.Table Syntax");
	label_3.setForeground(Color.blue);
	label_3.setFont(new Font("verdana",Font.BOLD,13));
        getContentPane().add(label_3);

        label_4 = new JLabel("Example : select * from mysql.user;");
	label_4.setForeground(Color.blue);
	label_4.setFont(new Font("verdana",Font.BOLD,13));
        getContentPane().add(label_4);

        Color c=new Color(220,180,170);
	getContentPane().setBackground(c); 
        setSize(getPreferredSize());
        }
   
  }


class NoteLayout implements LayoutManager {

    public NoteLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 608 + insets.left + insets.right;
        dim.height = 40 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+0,48,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+56,insets.top+0,48,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+0,464,16);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+24,464,16);}
    }
}
