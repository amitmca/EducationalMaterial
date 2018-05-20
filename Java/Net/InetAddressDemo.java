import java.net.*;

public class InetAddressDemo
	{	
	public static void main(String args[])
		{
		try
			{
//			InetAddress addr=InetAddress.getByName("http://localhost/Tennis"); 
//			System.out.println(addr);

			InetAddress alladdr[]=InetAddress.getAllByName("");
			for(int i=0;i<alladdr.length;i++)
				System.out.println(alladdr[i]);

			
			}
		catch(UnknownHostException e)
			{ 
			System.out.println(e);
			}
		}
	}