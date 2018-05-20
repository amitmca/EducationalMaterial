import javax.swing.*;
import java.awt.*;

/*
<applet code="jlabel" width="250" height="250">
</applet>
*/

public class jlabel extends JApplet
	{	
	JLabel jl;
	public void init()
		{
		Container c=getContentPane();
		jl=new JLabel("AMIT",new ImageIcon("Redoubt_Image%202.jpg"),JLabel.CENTER);
		jl.setVerticalTextPosition(JLabel.BOTTOM);
		jl.setHorizontalTextPosition(JLabel.CENTER);
		c.add(jl);
		}
	}	