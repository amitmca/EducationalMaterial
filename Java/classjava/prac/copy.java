import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

/*
<applet code="copy" height="300" width="300">
</applet>	
*/

public class copy extends JApplet implements ActionListener
	{
	Container cp=getContentPane();
	JButton cut1,copy1,paste1,cut2,copy2,paste2;
	JTextArea ta1,ta2;
	String text="";
	ImageIcon icon;	
	Border b;

	public void init()
		{
		cp.setLayout(null);	
		icon=new ImageIcon("btn_exit.png");
		b=BorderFactory.createMatteBorder(10,5,10,5,icon);
	
		ta1=new JTextArea("",10,30);
		ta1.setBounds(15,15,125,100);
		cp.add(ta1);

		ta2=new JTextArea("",10,30);
		ta2.setBounds(160,15,125,100);
		cp.add(ta2);

		cut1=new JButton("CUT");
		cut1.setBounds(45,125,75,25);
		cut1.setBorder(b);
		cp.add(cut1);

		cut2=new JButton("CUT");
		cut2.setBounds(175,125,75,25);
		cp.add(cut2);

		copy1=new JButton("COPY");
		copy1.setBounds(45,175,75,25);
		cp.add(copy1);

		copy2=new JButton("COPY");
		copy2.setBounds(175,175,75,25);
		cp.add(copy2);

		paste1=new JButton("PASTE");
		paste1.setBounds(45,225,75,25);
		cp.add(paste1);

		paste2=new JButton("PASTE");
		paste2.setBounds(175,225,75,25);
		cp.add(paste2);

		cut1.addActionListener(this);
		copy1.addActionListener(this);
		paste1.addActionListener(this);	

		cut2.addActionListener(this);
		copy2.addActionListener(this);
		paste2.addActionListener(this);	
		}
	public void actionPerformed(ActionEvent ae)
		{
		
		if(ae.getSource()==copy1)
			{
			text=ta1.getText();
			}
		if(ae.getSource()==paste2)
			{
			ta2.setFont(new Font("verdana",Font.BOLD,14));
			ta2.setText(text);
			showStatus("Copy Completed");
			}

		if(ae.getSource()==copy2)
			{
			text=ta2.getText();
			}
		if(ae.getSource()==paste1)
			{
			ta1.setFont(new Font("verdana",Font.BOLD,14));
			ta1.setText(text);
			showStatus("Copy Completed");
			}
		}
	}