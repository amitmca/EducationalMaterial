class class1
	{
	public int a;
	public int b;
	public int c;

	public void get(int x,int y)
		{
		a=x;
		b=y;
		}	
	public void process()
		{
		c=a+b;
		}
	public void put()
		{
		System.Console.WriteLine("Output is: "+c);
		}
	}
class myclass
	{
	public static void Main(string[] args)
		{
		class1 obj=new class1();
		obj.get(5,5);
		obj.process();
		obj.put();
		}
	}		