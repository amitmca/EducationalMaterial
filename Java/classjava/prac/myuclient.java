import java.io.*;
import java.net.*;
import java.util.*;

class myuclient
	{
	private static DatagramSocket ds;
	private static DatagramPacket inp,outp;
	private static byte[] buffer;
	private static InetAddress host;

	public static void main(String args[])
		{
		try
			{
			host=InetAddress.getLocalHost();
			}
		catch(Exception e)
			{
			System.out.println(e);
			System.exit(1);
			}
		HandleServer();
		}
	public static void HandleServer()
		{
		try
			{
			ds=new DatagramSocket();
			Scanner s=new Scanner(System.in);
			String mess="",resp="";
			while(!mess.equals("close"))
				{
				System.out.println("Enter Number:");
				mess=s.nextLine();
				if(!mess.equals("close"))
					{
					outp=new DatagramPacket(mess.getBytes(),mess.length(),host,1234);
					ds.send(outp);

					buffer=new byte[256];
					inp=new DatagramPacket(buffer,buffer.length);
					resp=new String(inp.getData(),0,inp.getLength());
					System.out.println("Factorial is:"+resp);
					}
				}
			}
		catch(IOException e)
			{
			}
		}
	}