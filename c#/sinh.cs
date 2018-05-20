	using System;
	class A
	{
	private int a;
	public void get(int a1)
		{	
		a=a1;
		}
	public void put()
		{
		System.Console.WriteLine("value Of a is:",a);
		}
	}
	class sinh
	{
	public static void Main(string[] args)
		{
		A obj=new A(10);
		obj.get();
		obj.put();
		}
	}
	