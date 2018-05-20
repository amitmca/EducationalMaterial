import java.net.*;
import java.io.*;

class server4
	{
	public static void main(String args[])throws IOException 
		{
		ServerSocket serversocket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		try
			{
			serversocket=new ServerSocket(8000);
			}	
		catch(IOException e)
			{
			System.out.println(e);
			System.exit(1);
			}
		Socket cs=null;
		try
			{
			cs=serversocket.accept();
			
			}
		catch(IOException e1)
			{
			System.out.println(e1);
			System.exit(1);
			}
		while(true)
			{
			try
				{
				out=new PrintWriter(cs.getOutputStream(),true);
				in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
				String line=in.readLine();
				String ucase=line.toUpperCase();
				System.out.println("UpperCase is:"+ucase);
				}
			catch(IOException e2)
				{
				System.out.println(e2);	
				System.exit(-1);
				}
			}
		}
	}