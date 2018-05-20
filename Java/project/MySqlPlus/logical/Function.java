import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Function extends JFrame implements ActionListener
{
    JTextArea data;
    JScrollPane sp_data;
    JButton btnchk;

    public Function() 
	{
        FunctionLayout customLayout = new FunctionLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));

        getContentPane().setLayout(customLayout);

        data = new JTextArea("");
        sp_data = new JScrollPane(data);
        getContentPane().add(sp_data);

        btnchk = new JButton("Check It");
	btnchk.addActionListener(this);
        getContentPane().add(btnchk);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
public void actionPerformed(ActionEvent ae)
	{
	String d=data.getText();	
	if(ae.getSource()==btnchk)
		{
		//boolean b=d.contentEquals("\n");
		System.out.println(d);
		/*if()
			{
			System.out.println("ok");
			}
		else
			{
			System.out.println("no ok");
			}*/
		}		
	}

    public static void main(String args[]) {
        Function window = new Function();

        window.setTitle("Function");
        window.pack();
        window.show();
    }
}

class FunctionLayout implements LayoutManager {

    public FunctionLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 466 + insets.left + insets.right;
        dim.height = 327 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+48,328,200);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+272,88,24);}
    }
}
