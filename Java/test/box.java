import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/*
<applet code="box" height="250" width="250">
</applet>
*/

public class box extends JApplet
	{
	public box()
		{
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());	
		JPanel jp=new JPanel();
		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"Information");
		jp.setBorder(titled);
		jp.setLayout(new BoxLayout(jp,BoxLayout.X_AXIS));
		jp.add(Box.createGlue());
		jp.add(new JTextField("Text 1"));
		jp.add(Box.createGlue());
		jp.add(new JTextField("Text 2"));
		jp.add(Box.createGlue());
		jp.add(new JTextField("Text 3"));
		jp.add(Box.createGlue());
		cp.add(jp);
		}
	
	}


