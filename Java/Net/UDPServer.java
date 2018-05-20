import java.io.*;
import java.net.*;

public class UDPServer
	{	
	private static DatagramSocket ds;
	private static DatagramPacket inp,outp;
	private static byte [] buffer;

	public static void main(String args[])
		{
		try
			{
			ds=new DatagramSocket(1234);
			}
		catch(SocketException e)
			{
			System.out.println("Unable to attach to port");
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
			do
				{
				buffer=new byte[256];
				inp=new DatagramPacket(buffer,buffer.length);
				ds.receive(inp);

				InetAddress ca=inp.getAddress();
				int port=inp.getPort();
				min=new String(inp.getData(),0,inp.getLength());
				if(!min.equals("close"))
					{
					System.out.println("Message Received");
					n++;
					mout="Message  "+n+":"+min;
					outp=new DatagramPacket(mout.getBytes(),mout.length(),ca,port);
					ds.send(outp);
					}
				else
					{
					System.exit(0);
					}	
				}while(!min.equals("close"));
			}
		catch(IOException e)
			{
			}
		finally
			{
			ds.close();
			}
		}
	}