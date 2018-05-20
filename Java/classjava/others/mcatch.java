import java.io.*;

class mcatch
	{
	public static void main(String args[])throws IOException
		{
		int a[]={5,10};
		int b=0;
		try
			{
			int c=a[2]/a[1];
			
			}
		catch(ArrayIndexOutOfBoundsException e)
			{
			System.out.println(e);
			}
		try
			{
			int d=a[1]/b;
			}	
		catch(ArithmeticException e1)
			{
			System.out.println(e1);
			}

		}
	}
