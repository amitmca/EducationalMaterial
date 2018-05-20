import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*
<applet code="change" height="250" width="250">
</applet>
*/

public class change extends Applet implements ActionListener,ItemListener
	{	
	Label l;
	TextField t;
	Button b;
	Choice fo;
	String msg;
	JOptionPane jop;

	public void init()
		{
		l=new Label("Enter a Text Here:");
		add(l);
			
		t=new TextField(20);
		add(t);
		
		b=new Button("CHANGE");
		add(b);
		b.addActionListener(this);

		fo=new Choice();
		fo.add("Times New Roman");
		fo.add("Verdana");
		fo.add("Arial");	
	
		add(fo);
		}
	public void actionPerformed(ActionEvent ae)
		{
		String take=t.getText();
		String blank=" ";
		if(ae.getSource()==b)
			{
			if(take.equals(blank))
				{
				msg="Error";
				jop.showMessageDialog(null,msg,msg, jop.INFORMATION_MESSAGE);
				}
			else
				{
				String font=fo.getSelectedItem();
				setFont(new Font(font,Font.BOLD,15));
				msg=t.getText();
				}
			}
		else
			{
			msg="Thanks";
			jop.showMessageDialog(null,msg,msg, jop.INFORMATION_MESSAGE);
			}
		repaint();
		}
	public void itemStateChanged(ItemEvent ie)
		{
		repaint();
		}
	public void paint(Graphics g)
		{
		
		g.drawString(msg,100,100);
		}
	}