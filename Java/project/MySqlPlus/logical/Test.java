import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Test extends JFrame implements ActionListener
  {
    JTextField textfield_1;
    JLabel label_1;
    JButton button_1;
    JTextField t[];	

    public Test() {
        TestLayout customLayout = new TestLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        textfield_1 = new JTextField("");
        getContentPane().add(textfield_1);

        label_1 = new JLabel("Enter A Number");
        getContentPane().add(label_1);

        button_1 = new JButton("Generate");
	button_1.addActionListener(this);
        getContentPane().add(button_1);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==button_1)
		{
		String str=textfield_1.getText();
		int a=Integer.valueOf(str);
		int x=30,y=100;
		t=new JTextField[a];
		for(int i=1;i<=a;i++)
			{
			t=new JTextField[i];
			t[i].setBounds(x,y,100,25);
			getContentPane().add(t[i]);
			y=y+25;
			}	
	
		}
	}	

    public static void main(String args[]) {
        Test window = new Test();

        window.setTitle("Test");
        window.pack();
        window.show();
    }
}

class TestLayout implements LayoutManager {

    public TestLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 393 + insets.left + insets.right;
        dim.height = 328 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+184,insets.top+16,136,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+16,152,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+280,152,24);}
    }
}
