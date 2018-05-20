import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class License extends JInternalFrame implements ActionListener
    {
    JTextArea textarea_1;
    JScrollPane sp_textarea_1;
    JTextField txtdays;
    JLabel label_1;
    JLabel limage;
    JButton btnbuy;
    JButton btneval;
    String lic[]={"\n\n\nThis is a demonstration version of AmiSoft's MysqlPlus Database Manager\n"+
		  "product. This version is UN-limited, with the exception that you cannot\n"+
	          "license a database file for use with the MysqlPlus COM DLL.  You can\n"+
		  "purchase a MysqlPlus license by clicking the Buy Now button below. After\n"+
		  "you have paid, you will be given the download location for the full version\n"+
		  "and your license key will be emailed to you within 24 hours."};
	  		
  	
    public License()
	 {
	super("License");
        LicenseLayout customLayout = new LicenseLayout();
	ImageIcon i=new ImageIcon("images/exclamic.jpg");
	ImageIcon i1=new ImageIcon("images/alert.gif");
	setFrameIcon(i1);

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        textarea_1 = new JTextArea(lic[0]);
	textarea_1.setEditable(false);
	textarea_1.setFont(new Font("verdana",Font.BOLD,12));
        sp_textarea_1 = new JScrollPane(textarea_1);
        getContentPane().add(sp_textarea_1);

	Random rand = new Random();
	int num = rand.nextInt(31);
	String days=Integer.toString(num);

        txtdays = new JTextField(days);
	txtdays.setFont(new Font("verdana",Font.BOLD,15));
	txtdays.setForeground(Color.red);
        getContentPane().add(txtdays);

        label_1 = new JLabel("Days Remaining");
	label_1.setFont(new Font("verdana",Font.BOLD,10));
        getContentPane().add(label_1);

        limage = new JLabel(i);
        getContentPane().add(limage);

        btnbuy = new JButton("Buy Now");
	btnbuy.setFont(new Font("verdana",Font.BOLD,10));
	btnbuy.addActionListener(this);
        getContentPane().add(btnbuy);

        btneval = new JButton("Continue Evaluation");
	btneval.setFont(new Font("verdana",Font.BOLD,10));
	btneval.addActionListener(this);
        getContentPane().add(btneval);
	Color c=new Color(220,249,255);
	getContentPane().setBackground(c);

        setSize(getPreferredSize());
        
    }
public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btneval)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnbuy)
		{
		Buy b = new Buy("Buy", "Help/buy.htm");
		this.setVisible(false);
		MysqlPlus.desktop.add (b);
		b.show ();
		}	
	}
    
}

class LicenseLayout implements LayoutManager {

    public LicenseLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 541 + insets.left + insets.right;
        dim.height = 288 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+8,496,208);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+248,32,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+248,104,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+232,48,40);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+248,insets.top+248,96,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+352,insets.top+248,160,24);}
    }
}
