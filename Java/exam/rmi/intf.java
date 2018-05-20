import java.io.*;
import java.rmi.*;

public interface intf extends Remote
	{
	public void Interest_Calc(int p,int n,double r)throws IOException,RemoteException;
	}
	