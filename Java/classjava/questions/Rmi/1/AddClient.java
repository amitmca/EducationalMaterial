import java.rmi.*;

public class AddClient
	{	
	public static void main(String args[])
		{
		try
			{
			String rurl="rmi://" + args[0] + "/AddServer";
	
			AddServerIntf asi=(AddServerIntf)Naming.lookup(rurl);
			
			
	
			int ans=asi.Add(20,5,23);
		
			System.out.println("The Addition is:"+ans);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}