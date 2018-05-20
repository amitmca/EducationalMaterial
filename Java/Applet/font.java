import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="font" width="250" height="250">
</applet>

*/

public class font extends Applet implements ActionListener
	{
	List f,weight,size;
	TextArea ta;
	TextField t;
	String msg="";
	Button b;	
	public void init()
		{
		setLayout(new GridLayout(5,2,5,5));
		f=new List();
		weight=new List();
		size=new List();
		
		t=new TextField(20);
		add(t);

		f.add("Arial");
		f.add("Verdana");
		f.add("Times New Roman");
		add(f);

		weight.add("BOLD");
		add(weight);

		size.add("8");
		size.add("16");
		size.add("32");
		size.add("48");
		add(size);

		b=new Button("Preview");
		add(b);
		b.addActionListener(this);
		
		f.addActionListener(this);
		weight.addActionListener(this);
		size.addActionListener(this);

		ta=new TextArea(" ",5,30);
		add(ta);
		}

	public void actionPerformed(ActionEvent e)
		{
		if(e.getSource()==b)
			{
			repaint();
			msg=t.getText();
		String fo,w,si;
		int s;
		fo=f.getSelectedItem();
		w=weight.getSelectedItem();
		si=size.getSelectedItem();
		s=Integer.valueOf(si).intValue();
		setFont(new Font(fo,Font.BOLD,s));
		ta.setText(msg);	
			}
		}

	public void paint(Graphics g)
		{
		repaint();	
		}
	}
