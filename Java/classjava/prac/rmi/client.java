import java.rmi.*;
import java.net.*;
import java.io.*;

public class client
	{	
	public static void main(String args[])
		{
		try
			{
			String rurl="rmi://"+args[0]+"/server";
			myint i=(myint)Naming.lookup(rurl);
			DataInputStream dis=new DataInputStream(System.in);
			System.out.println("Enter A Number:");
			int n=Integer.parseInt(dis.readLine());
			int ans=i.sum(n);
			System.out.println("Sum Of Digits:"+ans);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}