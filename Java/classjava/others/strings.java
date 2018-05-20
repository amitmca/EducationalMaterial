import java.io.*;
import java.util.*;

class strings
	{
	public static void main(String args[])throws IOException
		{
		String[] s=new String[10];

		DataInputStream dis=new DataInputStream(System.in);

		System.out.println("\n How many Strings:");
		int n=Integer.parseInt(dis.readLine());

		System.out.println("\n Enter" + " "+ n +" " +"Strings:");

		for(int i=0;i<n;i++)
			{
			s[i]=dis.readLine();	
			}
		System.out.println("\n Strings entered are:");
		for(int i=0;i<n;i++)
			{
			System.out.println(s[i]);
			}
		}

	}
	
