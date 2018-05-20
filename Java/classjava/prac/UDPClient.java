import java.io.*;
import java.util.*;
import java.net.*;

class UDPClient
	{
	private static InetAddress host;
	private static DatagramSocket ds;
	private static DatagramPacket inp,outp;
	private static byte[] buffer;

	public static void main(String args[])
		{
		try
			{
			host=InetAddress.getLocalHost();
			}		
		catch(UnknownHostException e)
			{
			
			}
		AccessServer();
		}
	public static void AccessServer()
		{
		try
			{
			ds=new DatagramSocket();
			Scanner s=new Scanner(System.in);
			String mess="",resp="";
			while(!mess.equals("close"))
				{
				System.out.println("Enter Message:");
				mess=s.nextLine();
				if(!mess.equals("close"))
					{
					outp=new DatagramPacket(mess.getBytes(),mess.length(),host,1234);
					ds.send(outp);

					buffer=new byte[256];
					inp=new DatagramPacket(buffer,buffer.length);
					resp=new String(inp.getData(),0,inp.getLength());
					System.out.println("Server>"+resp);
					}
				}
			}
		catch(IOException e)
			{
			}
		}
	}