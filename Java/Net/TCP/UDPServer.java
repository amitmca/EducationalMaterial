import java.io.*;
import java.net.*;

public class UDPServer
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
			System.exit(1);
			}
		HandleClient();
		}	
	public static void HandleClient()
		{
		String min="",mout="";
		try
			{
			do
				{
				buffer=new byte[256];
				inp=new DatagramPacket(buffer,buffer.length);
				ds.receive(inp);
				min=new String(inp.getData(),0,inp.getLength());
				if(min.equals("close"))
					break;
				System.out.println(min+" is received");
				InetAddress ca=inp.getAddress();
				int port=inp.getPort();
				mout="Message is Received";
				outp=new DatagramPacket(mout.getBytes(),mout.length(),ca,port);				
				ds.send(outp);
				}while(!min.equals("close"));
			}
		catch(Exception e)
			{
			System.out.println(e);
			System.exit(1);
			}
		}
	}