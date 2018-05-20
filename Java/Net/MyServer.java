import java.net.*;
import java.io.*;

public class MyServer
	{	
	public static void main(String args[])throws IOException
		{
		ServerSocket ss=null;
		try
			{
			ss=new ServerSocket(4454);
			System.out.println(InetAddress.getLocalHost());
			}
		catch(IOException e)
			{
			System.out.println("Could not listen on port:4454");
			System.exit(1);
			}
		Socket cs=null;
		try
			{
			cs=ss.accept();
			}
		catch(IOException e)
			{
			System.out.println("Accept Failed");
			System.exit(1);
			}
		PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
		BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
		out.println("Connected");
		while(true)
			{
			try
				{
				String line=in.readLine();
				out.println(line);
				}
			catch(IOException e)
				{
				System.out.println("Read Failed");
				System.exit(-1);
				}
			}
		}
	}