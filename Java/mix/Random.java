import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

/*<applet code="Random" width=400 height=400></applet>*/

public class Random extends JApplet implements ActionListener
{
	JButton b1,b2,b3,b4;
	JTextField t1,t2,t3;
	int n1,n2,n3,s=0;
	
	public void init()
	{
		Container cc=getContentPane();
		cc.setLayout(new FlowLayout());
		
		b1=new JButton ("Number1");
		b2=new JButton ("Number2");
		b3=new JButton ("Accept No.");
		b4=new JButton ("Create");
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		
		cc.add(b1);
		cc.add(t1);
		cc.add(b2);
		cc.add(t2);
		cc.add(b3);
		cc.add(t3);
		cc.add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent ae)
	{
		Random r=new Random();
		
		if(ae.getActionCommand().equals("Number1"))
		{
			n1=r.nextInt(10);
			t1.setText(""+n1);
		}
		
		if(ae.getActionCommand().equals("Number2"))
		{
			n2=r.nextInt(100);
			t2.setText(""+n2);
		}
		
		if(ae.getActionCommand().equals("Accept No."))
		{
			n3=Integer.parseInt(t3.getText());
			
			if(n3==n1*n2)
			{
				s++;
				showStatus("Your /score is : +s");
			}
			
			else
			{
				s=0;
				showStatus("You Lose The Game.");
			}
		}
	
		if(ae.getActionCommand().equals("clear"));
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
	}
}
