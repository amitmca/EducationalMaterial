import java.awt.*;
import java.applet.*;

/*
<applet code="parameter" width="250" height="250">
<param name=red value=120>
<param name=green value=50>
<param name=blue value=30>
</applet>
*/


public class parameter extends Applet
	{
	int r,g,b;	
	String s1,s2,s3;
	public void init()
		{
		s1=getParameter("red");
		r=Integer.parseInt(s1);

		s2=getParameter("green");
		g=Integer.parseInt(s2);

		s3=getParameter("blue");
		b=Integer.parseInt(s3);

				
		}
	public void paint(Graphics gff)
		{
		
		Color c=new Color(r,g,b);
		setBackground(c);

		}
	}