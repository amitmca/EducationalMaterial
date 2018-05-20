import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Ass1b1 extends JFrame implements ActionListener
{	
	JFrame f;
	JTextArea t;
	JTextField cname,code,rcname,scname;
	JButton badd,brem,bsearch;
	Hashtable ht;
	public Ass1b1()
	{
		f=new JFrame("STD code");
		f.setVisible(true);
		f.setSize(400,400);
		f.setLayout(new FlowLayout());
		ht=new Hashtable();
		t=new JTextArea(20,20);
		cname=new JTextField(20);
		code=new JTextField(20);
		rcname=new JTextField(20);
		scname=new JTextField(20);
		badd=new JButton("Add");
		brem=new JButton("Remove");
		bsearch=new JButton("Search");
		ht.put("pune",343);
		ht.put("mumbai",543);
		ht.put("nashik",532);
		ht.put("nagar",748);
		f.add(t);
		f.add(cname);
		f.add(code);
		f.add(badd);
		badd.addActionListener(this);
		f.add(rcname);
		f.add(brem);
		brem.addActionListener(this);
		f.add(scname);
		f.add(bsearch);
		bsearch.addActionListener(this);
		f.pack();
		display();
	}
	public void display()
	{
	t.setText("");
	Enumeration keys=ht.keys();
	Enumeration value=ht.elements();	 
		while(keys.hasMoreElements())
		{
		t.setText(t.getText()+"\n"+keys.nextElement()+""+value.nextElement());
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==badd)
		ht.put(cname.getText(),code.getText());
		display();
		
		if(ae.getSource()==brem)
		ht.remove(rcname.getText());
		display();
		
		if(ae.getSource()==bsearch)
			if(ht.containsKey(scname.getText()))
			{
			JOptionPane.showMessageDialog(f,"found");
			}
			else
			{
			JOptionPane.showMessageDialog(f,"not found");
			}
	}
	public static void main(String[] args)
	{
	new Ass1b1();
	}
}
