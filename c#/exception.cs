using System;
class exception
	{
	public static void Main(string[] args)
		{
		
		try
			{
			int []a=new int[5];
			for(int i=0;i<10;i++)
				{
				a[i]=i;
				}	
			}
		catch(IndexOutOfRangeException e)
			{
			System.Console.WriteLine("The Exception is caught");
			}
		finally
			{
			int f=1,i,n=5;
			for(i=1;i<=n;i++)
				{
				f=f*i;
				}
			System.Console.WriteLine("This is finally block");
			System.Console.WriteLine("The Factorial is:"+f);
			}
		}
	}		