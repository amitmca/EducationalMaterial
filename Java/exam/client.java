import java.io.*;
import java.net.*;

public class client	
	{	
	public static void main(String args[])
		{
		PrintWriter out=null;
		BufferedReader in=null;
		Socket socket=null;
		try
			{
			socket=new Socket("127.0.0.1",8000);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		try	
			{
			BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
			String fromserver,fromclient;
			while((fromserver=stdin.readLine())!=null)
				{
				out.println("Server:"+fromserver);
				if(fromserver.equals("close"))
					break;
				fromclient=stdin.readLine();
				if(fromclient!=null)
					System.out.println("Client:"+fromclient);
				out.println(fromclient);	
				}
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}