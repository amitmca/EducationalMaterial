import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf
	{
	public AddServerImpl()throws RemoteException,IOException 
		{
		}
	public  int vowelcount()throws RemoteException,IOException 
		{
		int l,i,c=0;
		String str="";
		System.out.println("Enter A String:");
		DataInputStream dis=new DataInputStream(System.in);	
		str=dis.readLine();
		l=str.length();
				
		for(i=0;i<l;i++)
			{
			if(str.charAt(i)=='a' || str.charAt(i)=='A' || str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='E' || str.charAt(i)=='i' || str.charAt(i)=='I' || str.charAt(i)=='o' || str.charAt(i)=='O' || str.charAt(i)=='u' || str.charAt(i)=='U')
				{
				c++;
				}
			}
		return c;	
		}
	}

