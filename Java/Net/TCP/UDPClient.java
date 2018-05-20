import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient
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
		AccessServer();
		}	
	public static void AccessServer()
		{
		String mess="",resp="";
		
		try
			{
			ds=new DatagramSocket();
			Scanner s=new Scanner(System.in);
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
					System.out.println("Server:"+resp);
					}
				}		
			}
		catch(Exception e)
			{
			System.out.println(e);
			System.exit(1);
			}
		}
	}