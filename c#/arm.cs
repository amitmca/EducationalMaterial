	using System;
	class arm
	{
	public static void Main(string[] args)
		{
		int r=0,sum=0,t;
		System.Console.WriteLine("Enter the number:");
		int n=Console.ReadLine().ToInt16();
		t=n;
		while(n>0)
			{
			r=n%10;
			sum=sum+r*r*r;
			n=n/10;
			}
		if(sum==t)	
			System.Console.WriteLine("The number " +t +" is Armstrong");
		else
			System.Console.WriteLine("The number " +t +" is not Armstrong");
		}
	}