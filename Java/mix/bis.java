/*An Example Of BufferedInputStream */
import java.io.*;
class bis
	{
	public static void main(String args[])
		{	
		BufferedInputStream in=new BufferedInputStream(System.in);
		byte buf[]=new byte[10];
		try
			{
			in.read(buf,0,10);
			}
		catch(Exception e)
			{
			System.out.println("Error : "+e.toString());
			}
		String s=new String(buf,0);
		System.out.println(s);
		}
	}
