import java.io.*;
import java.net.*;

public class client
	{
	public static void main(String args[])throws IOException
		{
		BufferedReader in=null;
		PrintWriter out=null;
		Socket socket=null;
		try
			{
			socket=new Socket("127.0.0.1",6000);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
			}
		catch(Exception e)
			{
			System.out.println(e);
			System.exit(1);
			}
		try
			{
			BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
			String fromuser;
			String fromserver;
			while((fromserver=stdin.readLine())!=null)			
				{
				out.println("Server:"+fromserver);
				if(fromserver.equals("EXIT"))
					break;
				fromuser=stdin.readLine();
				if(fromuser!=null)
					System.out.println("Client:"+fromuser);
				out.println(fromuser);
				}
			}
		catch(Exception e)
			{
			System.out.println(e);
			System.exit(1);
			}
		}
	}