import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class AddServerImpl extends JFrame implements ActionListener
   {
    JLabel label_1;
    JTextArea contents;
    JScrollPane sp_contents;
    JTextField fname;
    JButton bshow;

    public AddServerImpl() {
        AddServerImplLayout customLayout = new AddServerImplLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        label_1 = new JLabel("Enter File Name");
        getContentPane().add(label_1);

        contents = new JTextArea("");
        sp_contents = new JScrollPane(contents);
        getContentPane().add(sp_contents);

        fname = new JTextField("");
        getContentPane().add(fname);

        bshow = new JButton("SHOW");
        getContentPane().add(bshow);
        bshow.addActionListener(this);
        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

   public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==bshow)
		{
		String filename=fname.getText();
		 int i;	
                                    String temp="";
		try
			{
			FileInputStream fin=new FileInputStream(filename);
			    do
			        {
			         i=fin.read();
			                        if(i!=-1)
				{
				temp=Integer.toString(i);
		                                   contents.setText(temp);
				}
		                          }while(i!=-1);
			}
		catch(FileNotFoundException e)
			{
			contents.setText(e.getMessage());
			}
		catch(ArrayIndexOutOfBoundsException e1)
			{
			return;
			}
		catch(IOException e2)
			{
			return;
			}
		}
	}

    public static void main(String args[]) {
        AddServerImpl window = new AddServerImpl();

        window.setTitle("AddServerImpl");
        window.pack();
        window.show();
    }
}

class AddServerImplLayout implements LayoutManager {

    public AddServerImplLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 494 + insets.left + insets.right;
        dim.height = 358 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+16,160,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+104,456,248);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+296,insets.top+16,168,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+200,insets.top+64,72,24);}
    }
}
