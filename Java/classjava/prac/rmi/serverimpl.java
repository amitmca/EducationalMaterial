import java.rmi.*;
import java.io.*;
import java.rmi.server.*;

public class serverimpl extends UnicastRemoteObject implements myint
	{
	public serverimpl()throws RemoteException
		{
		}
	public int sum(int n)throws IOException,RemoteException
		{
		int sum=0,r=0;
		while(n>0)
			{
			r=n%10;
			sum=sum+r;
			n=n/10;
			}
		return(sum);
		}
	}
