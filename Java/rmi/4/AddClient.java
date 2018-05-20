import java.rmi.*;
import java.net.*;

public class AddClient
	{
	public static void main(String args[])
		{
		try
			{
			String url="rmi://"+args[0]+"/AddServer";

			AddServerIntf asi=(AddServerIntf)Naming.lookup(url);

			int a=asi.StrLength(args[1]);

			System.out.println("Length Of "+args[1]+" is :"+a);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}