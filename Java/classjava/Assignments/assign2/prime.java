import java.io.*;

class prime
	{
	public static void main(String args[])throws IOException
		{
		int n,prime=1,i;
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println("Enter a number:");
		n=Integer.parseInt(dis.readLine());
		for(i=2;i<n;i++)
			{
			if(n%i==0)
				{
				prime=0;
				break;
				}
			}
		if(prime==0)
			System.out.println("Number is not prime");
		else
			System.out.println("Number is  prime");	
		}
	}