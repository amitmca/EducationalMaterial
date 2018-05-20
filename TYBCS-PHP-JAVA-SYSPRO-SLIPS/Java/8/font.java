import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class font extends JFrame implements ItemListener
{
	JLabel l1,l2,l3;
	JCheckBox c1,c2;
	JComboBox cb,cb2;
	JTextField t1;
	
	public font()
	{
		setTitle("FontDisplay");
		setLayout(new FlowLayout());
	
		l1=new JLabel("Font");
		l2=new JLabel("Size");
		l3=new JLabel("Style");
	
		c1=new JCheckBox("Bold");
		c2=new JCheckBox("Italic");
		
	
		t1=new JTextField(30);
		cb=new JComboBox();
		cb2=new JComboBox();
		add(l1);
		
		cb.addItem("Arial");
		cb.addItem("Monospace");
		cb.addItem("Meera");
		add(cb);
		cb.addItemListener(this);		
		add(l2);
		cb2.addItem("10");
		cb2.addItem("20");
		cb2.addItem("30");
		add(cb2);
		cb2.addItemListener(this);
		add(l3);
		add(c1);
		c1.addItemListener(this);
		add(c2);
		
		add(t1);
		setVisible(true);
		setSize(400,200);
	}
	public void itemStateChanged(ItemEvent ie)
	{
	int fstyle=0;
	if(c1.isSelected())
		fstyle=Font.BOLD;
	if(c2.isSelected())
		fstyle=Font.ITALIC;
	
	Font f=new Font(cb.getSelectedItem()+"",fstyle,Integer.parseInt(cb2.getSelectedItem()+""));
	t1.setFont(f);
	}
	public static void main(String[] args)
	{
	 new font();
	}
}
		
