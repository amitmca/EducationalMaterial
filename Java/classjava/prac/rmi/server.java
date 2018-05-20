import java.rmi.*;
import java.net.*;

public class server
	{	
	public static void main(String args[])
		{
		try
			{
			serverimpl s=new serverimpl();
			Naming.rebind("server",s);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}