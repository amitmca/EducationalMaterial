import java.io.*;

class test	
	{
	String s;
	test(String s1)
		{
		s=s1;
		}
	
	}
class test1
	{
	public void print(test t)
		{
		System.out.println(t.s);
		}
	}

class obj
	{
	public static void main(String args[])
		{
		test t=new test("Amit");
		test1 obj=new test1();
		obj.print(t);
		}
	}