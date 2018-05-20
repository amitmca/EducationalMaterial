import java.rmi.*;
import java.net.*;
public class AddClient
	{
	public static void main(String args[])
		{
		try
			{
			String addServerURL="rmi://" + args[0]  + "/AddServer";
			AddServerIntf addServerIntf=(AddServerIntf)Naming.lookup(addServerURL);
			System.out.println("The First Number is: "+args[1]);
			int n=Integer.valueOf(args[1]).intValue();

			System.out.println("The Factorial is:"+addServerIntf.fact(n));			
			}
		catch(Exception e)
			{
			System.out.println("Exception : "+e);
			}
		}
	}
