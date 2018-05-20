import java.io.*;
import java.net.*;

public class UServer
	{
	private static DatagramSocket ds;
	private static DatagramPacket inp,outp;
	private static byte[] buffer;
	public static void main(String args[])
		{
		try
			{
			ds=new DatagramSocket(1234);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		HandleClient();
		}	
	public static void HandleClient()
		{
		String min="",mout="";
		try
			{
			while(!min.equals("close"))
				{
				buffer=new byte[256];
	
				inp=new DatagramPacket(buffer,buffer.length);
	
				ds.receive(inp);

				InetAddress host=inp.getAddress();

				int port=inp.getPort();

				min=new String(inp.getData(),0,inp.getLength());

				System.out.println(min+" is received from client");	

				mout="Message from Server";
	
				outp=new DatagramPacket(mout.getBytes(),mout.length(),host,port);

				ds.send(outp);
				}		
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}