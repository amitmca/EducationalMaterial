import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class test extends JFrame implements ActionListener,ItemListener
    {
    JLabel lname;
    JLabel lage;
    JButton bsave;
    JLabel lquali;
    JTextField tname;
    JTextField tage;
    ButtonGroup cbg;
    JRadioButton rmale;
    JRadioButton rfemale;
    JButton breset;
    JButton bexit;
    String name,age,gender,space,newline;
    JOptionPane jop;
	  FileWriter fstream;
   	

    public test() {
        testLayout customLayout = new testLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
        getContentPane().setBackground(Color.white);
        lname = new JLabel("Name");
        getContentPane().add(lname);

        lage = new JLabel("Age");
        getContentPane().add(lage);

        bsave = new JButton("SAVE");
        getContentPane().add(bsave);

        lquali = new JLabel("Qualification");
        getContentPane().add(lquali);

        tname = new JTextField("");
        getContentPane().add(tname);

        tage = new JTextField("");
        getContentPane().add(tage);

        cbg = new ButtonGroup();
        rmale = new JRadioButton("Male", false);
	rmale.setBackground(Color.white);		
        cbg.add(rmale);
        getContentPane().add(rmale);
        rfemale = new JRadioButton("Female", false);
	rfemale.setBackground(Color.white);		
        cbg.add(rfemale);
        getContentPane().add(rfemale);

        breset = new JButton("RESET");
        getContentPane().add(breset);

        bexit = new JButton("EXIT");
        getContentPane().add(bexit);

	 
	

	bsave.addActionListener(this);
	breset.addActionListener(this);
	bexit.addActionListener(this);
        rmale.addItemListener(this);
	rfemale.addItemListener(this);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


 

    public void itemStateChanged(ItemEvent ie)
	{
	if(ie.getItemSelectable()==rmale)
		{
		gender="Male";
		}
	else if(ie.getItemSelectable()==rfemale)
		{
		gender="Female";
		}
	}	    
    public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==bsave)
		{
		name=tname.getText();
		age=tage.getText();
		space="         ";
		byte[] name1=name.getBytes();
		byte[] age1=age.getBytes();
		byte[] space1=space.getBytes();
		byte[] gender1=gender.getBytes();
		try
				{
				OutputStream fo=new FileOutputStream("file.txt",true);
				PrintWriter pow=new PrintWriter(fo,true); 
			
				for(int i=0;i<name1.length;i++)		
					fo.write(name1[i]);
				for(int i=0;i<space1.length;i++)		
					fo.write(space1[i]);
				for(int i=0;i<age1.length;i++)		
					fo.write(age1[i]);
				for(int i=0;i<space1.length;i++)		
					fo.write(space1[i]);
				for(int i=0;i<gender1.length;i++)		
					fo.write(gender1[i]);
				pow.println(); 	

				String str="Added Successfully";	
				jop.showMessageDialog(null,str,str, jop.INFORMATION_MESSAGE);
				}
			catch(IOException e1)
				{
				}
			
		}
	if(ae.getSource()==breset)
		{
		tname.setText("");
		tage.setText("");
		}	
	if(ae.getSource()==bexit)
		{
		System.exit(0);
		}
	}
	
    public static void main(String args[]) {
        test window = new test();

        window.setTitle("test");
        window.pack();
        window.show();
    }
}

class testLayout implements LayoutManager {

    public testLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 357 + insets.left + insets.right;
        dim.height = 255 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+32,72,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+80,72,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+192,72,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+128,72,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+32,152,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+80,152,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+128,72,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+128,88,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+192,72,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+192,72,24);}
    }
}
