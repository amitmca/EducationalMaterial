import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFrame extends JFrame implements ActionListener {
    JLabel lblName;
    JTextField txtName;
    JButton btnOk;

    public TestFrame() {
        TestFrameLayout customLayout = new TestFrameLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        lblName = new JLabel("Enter your Name :");
        getContentPane().add(lblName);

        txtName = new JTextField("");
        getContentPane().add(txtName);

        btnOk = new JButton("Ok");
        getContentPane().add(btnOk);
	btnOk.addActionListener(this);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

   public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btnOk)
		{
		String str=txtName.getText();
		JOptionPane.showMessageDialog(null,str,"Message From Frame",JOptionPane.INFORMATION_MESSAGE); 
		}
	}	

    public static void main(String args[]) {
        TestFrame window = new TestFrame();

        window.setTitle("TestFrame");
        window.pack();
        window.show();
    }
}

class TestFrameLayout implements LayoutManager {

    public TestFrameLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 337 + insets.left + insets.right;
        dim.height = 187 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+48,144,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+48,128,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+120,72,24);}
    }
}
