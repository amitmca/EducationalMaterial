import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf
	{	
	public AddServerImpl()throws RemoteException
		{
		}
	public int Add(int a,int b,int c)
		{
		int d=a+b+c;
		return d;
		}	
	}