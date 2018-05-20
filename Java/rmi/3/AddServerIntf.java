import java.rmi.*;
public interface AddServerIntf extends Remote
	{
	int fact(int n)throws RemoteException;
	}
