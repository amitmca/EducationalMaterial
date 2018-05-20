import java.io.*;
import java.net.*;

class UDPServer
	{	
	private static DatagramSocket ds;
	private static DatagramPacket inp,outp;

	public static void main(String args[])
		{
		try
			{
			ds=new DatagramSocket(1234);
			}		
		catch(SocketException e)
			{		
			System.out.println(e);
			System.exit(1);
			}
		HandleClient();
		}
	public static void HandleClient()
		{
		try
			{
			String min,mout;
			int n=0;
			byte[] buffer;
			while(true)
				{
				buffer =new byte[256];
				inp=new DatagramPacket(buffer,buffer.length);
				ds.receive(inp);

				InetAddress ca=inp.getAddress();
				int port=inp.getPort();
				min=new String(inp.getData(),0,inp.getLength());
				System.out.println("Message received");
				n++;

				mout="Message "+n+min;
				outp=new DatagramPacket(mout.getBytes(),mout.length(),ca,port);
				ds.send(outp);	
				}
			}
		catch(IOException e1)
			{
			}
		}
	}
