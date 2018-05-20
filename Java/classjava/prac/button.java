import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
<applet code="button" height="200" width="300">
</applet>	
*/
public class button extends JApplet implements ActionListener
	{
	Container cp=getContentPane();
	JButton red,green,blue;	
	JTextArea ta;
	public void init()
		{
		cp.setLayout(null);

		red=new JButton("RED");
		red.setBounds(25,25,75,25);
		red.setForeground(Color.red);
		red.setBackground(Color.black);
		cp.add(red);
		
		green=new JButton("GREEN");
		green.setBounds(105,25,75,25);
		green.setForeground(Color.green);
		green.setBackground(Color.black);
		cp.add(green);

		blue=new JButton("BLUE");
		blue.setBounds(185,25,75,25);
		blue.setForeground(Color.blue);
		blue.setBackground(Color.black);
		cp.add(blue);

		ta=new JTextArea("",10,30);
		ta.setBounds(25,50,240,100);
		cp.add(ta);

		red.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		}		
	public void actionPerformed(ActionEvent ae)
		{
		ta.setFont(new Font("verdana",Font.BOLD,20));
		if(ae.getSource()==red)
			{
			ta.setText("Red Button Pressed");
			cp.setBackground(Color.red);		
			red.Enabled=false;
			}
		else if(ae.getSource()==green)
			{
			ta.setText("Green Button Pressed");
			cp.setBackground(Color.green);
			}
		else if(ae.getSource()==blue)
			{
			ta.setText("Blue Button Pressed");
			cp.setBackground(Color.blue);
			}
		}
	}
