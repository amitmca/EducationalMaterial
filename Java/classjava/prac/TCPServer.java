import java.net.*;
import java.io.*;

public class TCPServer
	{	
	public static void main(String 	args[])throws IOException
		{
		ServerSocket ss=null;
		try
			{
			ss=new ServerSocket(6000);
			}
		catch(IOException e)
			{
			System.out.println(e);
			System.exit(1);
			}
		Socket cs=null;
		try
			{
			cs=ss.accept();	
			}
		catch(IOException e1)
			{
			System.out.println(e1);
			System.exit(1);
			}
		PrintWriter out=null;
		BufferedReader in=null;
		while(true)
		{
		try
			{
			in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
			String line=in.readLine();
			System.out.println(line);
			}
		catch(IOException e2)
			{
			System.out.println(e2);
			System.exit(-1);
			}
		}
		}
	}
	