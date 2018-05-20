import java.rmi.*;

public interface myintf extends Remote
	{
	public void Search(int eno)throws RemoteException;
	}	