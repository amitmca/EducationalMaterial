import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

public class impl extends UnicastRemoteObject implements intf
	{	
	public impl()throws RemoteException
		{
		}
	public void Interest_Calc(int p,int n,double r)
		{
		double si=(p*n*r)/100;
		System.out.println("Value Of Simple interest is:"+si);
		}	
	}