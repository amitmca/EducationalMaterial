import java.rmi.*;
import java.rmi.server.*;
public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf
	{
	public AddServerImpl()throws RemoteException 
		{
		}
	
	public int StrLength(String str)throws RemoteException
		{
		int len=str.length();
		return len;
		}
	}