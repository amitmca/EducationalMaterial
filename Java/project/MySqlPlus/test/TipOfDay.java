import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TipOfDay extends JInternalFrame implements ActionListener
    {
    JButton btnnext;
    JButton btnclose;
    JTextArea txttip;
    JScrollPane sp_txttip;
    JLabel limage;
    JLabel label_2;
    JLabel hand;
    ImageIcon i,i1,i2;

    String t1[]={"Mysql Supports for int char\n" + "float Blob varchar text number date "
		 ,"You can export and import your\n"+" data to and from MysqlPlus"
		 ,"Change mysql account password with\n"+"mysqladmin -u root password yourpassword"
		 ,"Use select to retrieve data from tables\n\n"+"Syntax:\n\n"+"select column name from tablename"
		 ,"Insert Data to your Mysql table using\n\n"+"Syntax:\n\n"+"Insert into tablename values(,,,,,,)"
		 ,"You Can Change the status of Mysql using\n\n"+"\t1)Start Services\n\n"+"\n\t2)Stop Services"
		 ,"Update Data of Mysql table using\n\n"+"Syntax:\n\n"+"update tablename set columnname=value where condition"
		 ,"Delete Data Of Mysql table using\n\n"+"Syntax:\n\n"+"delete from tablename where condition"
		 ,"Create View in Mysql As\n\n"+"\tCREATE\n"+"\t[ALGORITHM = {MERGE | TEMPTABLE | UNDEFINED}]\n"+"\tVIEW [database_name]. [view_name]AS\n"+"\t[SELECT statement]"
		 ,"Use MysqlPlusQueryBrowser to fire your customize queries\n"+"use database.tablename syntax "};
	
    public TipOfDay()  
     {
	super("Tip Of Day");
	Color c=new Color(183,194,242);
        TipOfDayLayout customLayout = new TipOfDayLayout();
	i=new ImageIcon("images/tips.gif");
	i1=new ImageIcon("images/next.gif");
	i2=new ImageIcon("images/tips1.gif");
	setFrameIcon(i2);

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        btnnext = new JButton("Next",new ImageIcon(ClassLoader.getSystemResource("images\\nextarrow.PNG")));
	btnnext.setFont(new Font("verdana", Font.BOLD, 10));
	btnnext.addActionListener(this);
        getContentPane().add(btnnext);

        btnclose = new JButton("Close",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btnclose.setFont(new Font("verdana", Font.BOLD, 10));
	btnclose.addActionListener(this);
        getContentPane().add(btnclose);

        txttip = new JTextArea("We Support for Data ManiPulation Language Commands\n"+" and Data Definition Language Commands");
	txttip.setFont(new Font("verdana", Font.BOLD, 12));
	txttip.setForeground(Color.red);
	txttip.setEditable(false);
	sp_txttip = new JScrollPane(txttip);
        getContentPane().add(sp_txttip);

        limage = new JLabel(i);
        getContentPane().add(limage);

        label_2 = new JLabel("Did You Know...");
	label_2.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(label_2);

        hand = new JLabel(i1);
        getContentPane().add(hand);
	
	getContentPane().setBackground(c);
	
        setSize(getPreferredSize());

       
    }
	public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btnclose)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnnext)
		{
		Random rand = new Random();
		int num = rand.nextInt(10);
		txttip.setText("");
		String a=t1[num];
		txttip.setText(a);
		}
	}

}
class TipOfDayLayout implements LayoutManager {

    public TipOfDayLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 545 + insets.left + insets.right;
        dim.height = 277 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+336,insets.top+248,104,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+448,insets.top+248,88,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+32,456,208);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+8,56,48);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+80,insets.top+8,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+64,48,24);}
    }
}
