import java.io.*;

class test	
	{
	int a;
	test()
		{
		a=10;
		}
	public void method()
		{
		System.out.println("Value Of a is:"+a);
		}
	}

class myclass
	{
	public static void main(String args[])
		{
		test t=new test();
		t.method();
		}
	}