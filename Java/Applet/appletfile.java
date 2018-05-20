import java.awt.*;
import java.io.*;
import java.applet.*;

/*
<applet code="appletfile.class" width="250" height="250">
</applet>
*/

public class appletfile extends Applet
	{
	public void init()
		{
		byte data[]="This is a string of text.".getBytes();
		try
			{
			FileOutputStream fout=new FileOutputStream("file.txt");
			fout.write(data);
			fout.close();
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}


