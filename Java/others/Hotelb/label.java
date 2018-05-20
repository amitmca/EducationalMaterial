import java.awt.*;
import javax.swing.*;
/*<applet code="label" width=100 height=100></applet>*/

public class label extends JApplet
{
	public void init()
	{
		Container cpane=getContentPane();
		//create imageicon
		ImageIcon ii=new ImageIcon("collegelogo.jpg");
		//create label
		JLabel jl =new JLabel("collegelogo.jpg",ii,JLabel.CENTER);
		cpane.add(jl);
	}
}
