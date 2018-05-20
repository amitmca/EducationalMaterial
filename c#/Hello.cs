using System.IO;

class test
	{
	int a,b,c;
	public test(int x,int y)
		{
		a=x;
		b=y;
		}
	public void print()
		{
		c=a+b;		
		System.Console.WriteLine("Addition is:"+c);	
		}
	}
public class Hello
{
public static void Main()
	{
	test t=new test(10,20);
	t.print();
	}
}		
