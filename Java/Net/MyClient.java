import java.net.*;
import java.io.*;

public class MyClient
	{	
	public static void main(String args[])throws IOException
		{
		Socket mys=null;
		PrintWriter out=null;
		BufferedReader in=null;
		try
			{
			mys=new Socket("comp",4454);
			out=new PrintWriter(mys.getOutputStream(),true);
			in=new BufferedReader(new InputStreamReader(mys.getInputStream()));
			}
		catch(UnknownHostException e)
			{
			System.out.println("Don't Know about host");
			System.exit(1);
			}
		catch(IOException e1)
			{
			System.out.println("Couldn't get I/O");
			System.exit(1);
			}
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String fromserver;
		String fromusr;
		while((fromserver=in.readLine())!=null)
			{
			System.out.println("Server:"+fromserver);
			if(fromserver.equals("Bye."))
				break;
			fromusr=stdin.readLine();
			if(fromusr!=null)
				{
				System.out.println("Client:"+fromusr);
				out.println(fromusr);
				}
			}
		out.close();
		in.close();
		stdin.close();
		mys.close();
		}
	}