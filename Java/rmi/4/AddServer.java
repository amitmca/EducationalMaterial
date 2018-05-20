import java.rmi.*;
import java.net.*;

public class AddServer
	{
	public static void main(String args[])
		{
		try
			{
			AddServerImpl asi=new AddServerImpl();		
			Naming.rebind("AddServer",asi);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}