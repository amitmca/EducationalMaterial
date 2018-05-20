/*		AbstractButton Class

The abstract button classs provides the foundation of the button
classes in java.
 All buttons is swings are derived from AbstractButton class.

Object
	Component
		Container
			JComponent
				AbstractButton
					JButton

JButton includes
	setToolTipText to add tooltips to the button
	setMargins to set the insets in the button itself 
	doClick to click the button from the code,
	adding images to the button
	adding mnemonics to the button

*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*<applet code="JButtonImage" width=400 height=400></applet>*/

public class JButtonImage extends JApplet
{
	JTextField f=new JTextField(30);
	public void init()
	{
		Container cpane=getContentPane();
		cpane.setLayout(new FlowLayout());

		Icon normal=new ImageIcon("iconimg.gif");
		Icon rollover =new ImageIcon("img1.jpg");
		Icon disabled=new ImageIcon("img2.jpg");
		

		JButton b=new JButton();

		b.setRolloverEnabled(true);
		b.setIcon(normal);
		b.setRolloverIcon(rollover);
		b.setPressedIcon(disabled);
		
		
		cpane.add(b);
		cpane.add(f);

		
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				f.setText("Entering the data");
			}
		});
	}
	public void paintComponent(Graphics g)
	{
		showStatus("Testing Button");
	}
}

