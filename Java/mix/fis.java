/*An Example Of FileInputStream */
import java.io.*;
class fis
	{
	public static void main(String args[])
		{	
		byte buf[]=new byte[64];
		try
			{
			FileInputStream in=new FileInputStream("amit.txt");
			in.read(buf,0,64);	
			}
		catch(Exception e)
			{
			System.out.println("Error : "+e.toString());
			}
		String s=new String(buf,0);
		System.out.println(s);
		}
	}
