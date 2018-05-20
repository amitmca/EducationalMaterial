import java.io.*;
import java.rmi.*;


public class client
	{	
	public static void main(String args[])
		{
		try	
			{
			String rurl="rmi://"+args[0]+"/server";
			intf i=(intf)Naming.lookup(rurl);
			DataInputStream dis=new DataInputStream(System.in);
			System.out.println("\n Enter the value of p:");
			int p=Integer.parseInt(dis.readLine());

			System.out.println("\n Enter the value of n:");
			int n=Integer.parseInt(dis.readLine());

			System.out.println("\n Enter the value of r:");
			double r=Double.parseDouble(dis.readLine());
			
			i.Interest_Calc(p,n,r);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}	
		}	
	}