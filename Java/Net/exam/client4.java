import java.net.*;
import java.io.*;

class client4
	{
	public static void main(String args[])throws IOException
		{
		Socket socket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		try
			{
			socket=new Socket("127.0.0.1",8000);
			out=new PrintWriter(socket.getOutputStream(),true);			
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			}
		catch(UnknownHostException e)
			{
			System.out.println("Don't know about host");
			System.exit(1);
			}
		
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String fromserver;
		String fromclient=new String();
		String fromUser=new String();

		while((fromclient=stdin.readLine())!="-1")
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