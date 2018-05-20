import java.rmi.*;
import java.net.*;

public class AddServer
	{
	public static void main(String args[])
		{
		try
			{
			AddServerImpl as=new AddServerImpl();
			Naming.rebind("AddServer",as);
			}	
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}