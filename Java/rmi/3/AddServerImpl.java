import java.rmi.*;
import java.rmi.server.*;
public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf
	{
	public AddServerImpl()throws RemoteException 
		{
		}
	public int fact(int n)throws RemoteException 
		{
		int f=1;
		for(int i=1;i<=n;i++)
			{
			f=f*i;
			}
		return f;
		}
	}
