	using System;
	class arr
	{
	public static void Main(string[] args)
		{
		int i,c=0;
		int[] a=new int[10];
		System.Console.WriteLine("How many elements:");
		int n=Console.ReadLine().ToInt16();
		System.Console.WriteLine("Enter array elements:");
		for(i=0;i<n;i++)
			{		
			a[i]=Console.ReadLine().ToInt16();	
			}
		System.Console.WriteLine("Enter element to search:");
		int s=Console.ReadLine().ToInt16();
		for(i=0;i<n;i++)
			{		
			if(s==a[i])
				{
				c++;		
				}
			}
		System.Console.WriteLine("The element " +s +" is occured " +c +" times in the array.");				
		}
	}