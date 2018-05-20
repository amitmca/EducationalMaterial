/*An Example Of FileOutputStream */
import java.io.*;
class fos
	{
	public static void main(String args[])
		{	
		byte buf[]=new byte[64];
		try
			{
			System.in.read(buf,0,64);	
			}
		catch(Exception e)
			{
			System.out.println("Error : "+e.toString());
			}
		try
			{
			FileOutputStream out=new FileOutputStream("ajit");
			out.write(buf);
			}
		catch(Exception e)
			{
			System.out.println("Error : "+e.toString());
			}
		}
	}
