import java.rmi.*;
import java.io.*;

public interface myint extends Remote
	{
	public int sum(int n)throws RemoteException,IOException;		
	}