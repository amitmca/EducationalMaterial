import java.rmi.*;
import java.net.*;
public class AddCilent
	{
	public static void main(String args[])
		{
		try
			{
			String addServerURL="rmi://" + args[0]  + "/AddServer";
			AddServerIntf addServerIntf=(AddServerIntf)Naming.lookup(addServerURL);
			System.out.println("Enter the First Number : "+args[1]);
			int a=Integer.valueOf(args[1]).integerValue();
			}
		catch(Exception e)
			{
			System.out.println("Exception : "+e);
			}
		}
	}
