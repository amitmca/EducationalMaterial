import java.io.*;
import java.net.*;

public class server
	{
	public static void main(String args[])
		{
		ServerSocket ss=null;
		try
			{
			ss=new ServerSocket(8000);	
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		Socket cs=null;
		try
			{
			cs=ss.accept();
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		String str;
		try
			{
			do
				{
				BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
				str=in.readLine();
				System.out.println("Hello "+str);
				}while(!str.equals("close"));
			}
		
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}