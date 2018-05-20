import java.io.*;

class prime
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println("Enter a number:");
		try
			{
			int n=Integer.parseInt(dis.readLine());
			int p=1;
			for(int i=2;i<=n;i++)
				{
				if(n%i==0)
					p=0;
				break;
				}
			if(p==0)
				System.out.println("Number is not prime");
			else
				System.out.println("Number is prime");	
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}	
	}