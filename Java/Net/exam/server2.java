import java.net.*;
import java.io.*;

class server2
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
				int n=Integer.parseInt(line);
				int f=1;
				for(int i=1;i<=n;i++)
					{
					f=f*i;
					}	
				System.out.println("Factorial is:"+f);
				}
			catch(IOException e2)
				{
				System.out.println(e2);	
				System.exit(-1);
				}
			}
		}
	}