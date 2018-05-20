	using System;
	class read
	{
	public static void Main(string[] args)
		{
		int f=1,i;
		System.Console.WriteLine("Enter the number:");
		int n=Console.ReadLine().ToInt16();

		for(i=1;i<=n;i++)
			{
			f=f*i;
			}
		System.Console.WriteLine("The Factorial is:"+f);
		}
	}