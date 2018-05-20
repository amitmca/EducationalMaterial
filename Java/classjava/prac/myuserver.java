import java.io.*;
import java.net.*;

class myuserver
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
		try	
			{
			String min="",mout="";
			
			while(true)
				{
				buffer=new byte[256];
				inp=new DatagramPacket(buffer,buffer.length);
				ds.receive(inp);
				min=new String(inp.getData(),0,inp.getLength());
				InetAddress ca=inp.getAddress();
				int port=inp.getPort();

				int n=Integer.parseInt(min);
				int f=1;
				for(int i=1;i<=n;i++)
					f=f*i;
				System.out.println("Factorial is:"+f);
				mout=Integer.toString(f);
				outp=new DatagramPacket(mout.getBytes(),mout.length(),ca,port);
				ds.send(outp);
				}
			}
		catch(IOException e1)
			{
			}
		}
	}