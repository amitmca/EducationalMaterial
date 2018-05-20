import java.io.*;
import java.net.*;

public class server
	{
	public static void main(String args[])throws IOException
		{
		ServerSocket ss=null;
		try
			{
			ss=new ServerSocket(6000);
			}
		catch(Exception e)
			{	
			System.out.println(e);
			System.exit(1);
			}
		Socket cs=null;
		try
			{
			cs=ss.accept();
			}
		catch(Exception e1)
			{	
			System.out.println(e1);
			System.exit(1);
			}
		while(true)
			{
			try
				{
				BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
				String line=in.readLine();
				System.out.println(line.toUpperCase());	
				}
			catch(Exception e2)
				{
				System.out.println(e2);
				System.exit(1);
				}
			}
		}
	}