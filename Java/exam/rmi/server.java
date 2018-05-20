import java.io.*;
import java.rmi.*;


public class server 
	{	
	public static void main(String args[])
		{
		try	
			{
			impl i=new impl();
			Naming.rebind("server",i);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}	
		}	
	}