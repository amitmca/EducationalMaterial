import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
/*
<applet code="progressbar" width=250 height=250>
</applet>
*/

public class jcon extends Applet
	{
	JProgressBar jp1;
	Button jb=new Button("Increment the process bar");
	public void init()
		{
		setLayout(new FlowLayout());	
		jp1=new JProgressBar();
		add(jp1);
		add(jb);
		jp1.setStringPainted(true);
		jb.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
				{
				jp1.setValue(jp1.getMaximum());
				}
			});
		}	
	}	
