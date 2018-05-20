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

			int ans=addServerIntf.vowelcount();
			
			System.out.println("Total Voewls are:"+ans);			
			}
		catch(Exception e)
			{
			System.out.println("Exception : "+e);
			}
		}
	}
