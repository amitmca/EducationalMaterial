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
			System.out.println("Enter the First Number : "+args[1]);
			double a=Double.valueOf(args[1]).doubleValue();

			System.out.println("Enter the Second Number : "+args[2]);
			double b=Double.valueOf(args[2]).doubleValue();

			System.out.println("The Sum is : "+addServerIntf.add(a,b));
			}
		catch(Exception e)
			{
			System.out.println("Exception : "+e);
			}
		}
	}
