import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JInternalFrame implements ActionListener 
 {

    JLabel limage;
    JLabel lfirst;
    JButton btnok;
    JLabel label_3;
    ImageIcon i;	

    public About()
        {
	super("About MysqlPlus");
        AboutLayout customLayout = new AboutLayout();
	setLocation(300,200);
	getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

	ImageIcon i1=new ImageIcon("images/b_selboard.PNG");
 	setFrameIcon(i1);

	i=new ImageIcon("images/launcher.png");
	limage = new JLabel(i);
        getContentPane().add(limage);

        lfirst = new JLabel("MysqlPlus Version 1.0");
	lfirst.setFont(new Font("verdana",Font.BOLD,12));
	lfirst.setForeground(Color.white);	
        getContentPane().add(lfirst);

        btnok = new JButton("OK",new ImageIcon(ClassLoader.getSystemResource("images\\s_okay.PNG")));
	btnok.addActionListener(this);
        getContentPane().add(btnok);

        label_3 = new JLabel("Copyright (C) AmiSoft Software Corporation");
	label_3.setFont(new Font("verdana",Font.BOLD,9));
	label_3.setForeground(Color.white);
        getContentPane().add(label_3);
	
	Color c=new Color(183,194,242);
	getContentPane().setBackground(c);
        setSize(getPreferredSize());
        }
public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btnok)
		{
		this.setVisible(false);
		}
	}
  
}

class AboutLayout implements LayoutManager {

    public AboutLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 389 + insets.left + insets.right;
        dim.height = 77 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+32,48,32);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+8,216,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+304,insets.top+0,72,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+64,insets.top+40,248,24);}
    }
}
