import java.net.*;
import java.io.*;

public class TCPClient
	{	
	public static void main(String 	args[])throws IOException
		{
		Socket socket=null;
		BufferedReader in=null;
		PrintWriter out=null;	

		try
			{
			socket=new Socket("127.0.0.1",6000);
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out=new PrintWriter(socket.getOutputStream(),true);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String fromclient=new String();
		while((fromclient=stdin.readLine()) !="-1")
			{
			out.println(fromclient);
			System.out.println(in.readLine());
			}
		out.close();
		in.close();
		stdin.close();
		socket.close();
		}
	}
	