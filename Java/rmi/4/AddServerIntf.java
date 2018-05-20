import java.rmi.*;

public interface AddServerIntf extends Remote
	{
	public int StrLength(String str) throws RemoteException;
	}