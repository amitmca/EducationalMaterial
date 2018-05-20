import java.net.*;
import java.io.*;

public class TCPServer
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
			System.exit(1);
			}

		Socket cs=null;
		try
			{
			cs=ss.accept();
			}
		catch(Exception e)
			{
			System.out.println(e);
			System.exit(1);
			}
		try
			{
			BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
			PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
			String str=in.readLine();
			out.println(str);	
			}	
		catch(Exception e)
			{
			System.out.println(e);
			}
		}	
	}