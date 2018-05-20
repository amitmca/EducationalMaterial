package addp;
import java.sql.*;
import java.io.*;

public class addition1 
	{
		
	public void add() 
		{
		try
		{
		DataInputStream in=new DataInputStream(System.in);

		System.out.println("Enter First Number:");
		
		int a=Integer.parseInt(in.readLine());

		System.out.println("Enter Second Number:");

		int b=Integer.parseInt(in.readLine());

		int c=a+b;

		System.out.println("Addition is:" +c);
		}
		catch(IOException e)
		{
		}
		
		}
	}

