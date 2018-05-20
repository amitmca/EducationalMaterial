import java.net.*;
import java.io.*;

public class TCPClient
	{
	public static void main(String args[])
		{
		BufferedReader in=null;
		PrintWriter out=null;
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
		BufferedReader stdin=null;
		String fromclient="",fromserver="";
		try
			{
			while((fromserver=stdin.readLine())!=null)
				{
				stdin=new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Server:"+fromserver);

				if(fromserver.equals("Bye"))
					break;
				fromclient=stdin.readLine();
			
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