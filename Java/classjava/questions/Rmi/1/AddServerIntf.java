import java.rmi.*;


public interface AddServerIntf extends Remote
	{	
	public int Add(int a,int b,int c)throws RemoteException;
	} 