import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Assign extends JFrame implements ActionListener
 {
    JTextField txtrow;
    JLabel label_1;
    JButton btngen;
    JButton btnshow;
   
   public static JTextField t[];
	
    public Assign() {
        AssignLayout customLayout = new AssignLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        txtrow = new JTextField("");
        getContentPane().add(txtrow);

        label_1 = new JLabel("Enter No.Of Rows");
        getContentPane().add(label_1);

        btngen = new JButton("Generate");
	btngen.addActionListener(this);
        getContentPane().add(btngen);

        btnshow = new JButton("Show");
	btnshow.addActionListener(this);
        getContentPane().add(btnshow);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

	public void actionPerformed(ActionEvent ae)
	{
	String a=txtrow.getText();
	int r=Integer.parseInt(a);
	if(ae.getSource()==btngen)
		{
		
		t=new JTextField[r];
		int x=25,y=150;
		for(int i=0;i<r;i++)
			{
			t[i]=new JTextField();
			t[i].setBounds(x,y,100,25);
			getContentPane().add(t[i]);
			y=y+25;
			repaint();
			}
		}
	if(ae.getSource()==btnshow)
		{
		String s[]=new String[50];

		for(int i=0;i<r;i++)
			{
			s[i]=t[i].getText();
			
			System.out.println(s[i]+"\n");
			}
		}
	}

    public static void main(String args[]) {
        Assign window = new Assign();

        window.setTitle("Assign");
        window.pack();
        window.show();
    }
}

class AssignLayout implements LayoutManager {

    public AssignLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 671 + insets.left + insets.right;
        dim.height = 565 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+280,insets.top+16,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+112,insets.top+16,112,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+408,insets.top+16,120,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+560,insets.top+16,72,24);}
    }
}
