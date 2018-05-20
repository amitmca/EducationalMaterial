import java.rmi.*;

public class AddClient
	{	
	public static void main(String args[])throws RemoteException
		{
		try
			{
			String rurl="rmi://" + args[0] + "/AddServer";
	
			myintf asi=(myintf)Naming.lookup(rurl);

			int eno=Integer.parseInt(args[1]);
			
			asi.Search(eno);	
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}