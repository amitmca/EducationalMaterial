import java.awt.*;
import java.applet.*;

/*
<applet code="image" width=400 height=400>
</applet>
*/


public class myframe extends Frame
	{
	Image image;
	/*public void init()
		{

		}*/
	public void paint(Graphics g)
		{	
		g.drawImage(image,10,10,this);
		}	
	public myframe()
		{
		image=getImage(getDocumentBase(),"image.jpg");	
		}
	public static void main(String args[])
		{
		myframe f=new myframe();
		f.setSize(300,300);
		f.setTitle("My Frame");
		f.show();
		}
	}
