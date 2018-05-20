import java.io.*;

class test	
	{
	public void add(int a,int b)
		{
		int c=a+b;
		System.out.println("Value Of c is:"+c);
		}
	public void add(double a,double b)
		{
		double d=a+b;
		System.out.println("Value Of d is:"+d);
		}
	}

class om
	{
	public static void main(String args[])
		{
		test t=new test();
		t.add(2,3);
		t.add(2.5,3.5);
		}
	}