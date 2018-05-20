struct struct1 
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
		System.Console.WriteLine("Outpuit is: "+c);
		}
	}
class mystruct
	{
	public static void Main(string[] args)
		{
		struct1 obj=new struct1();
		obj.get(5,5);
		obj.process();
		obj.put();
		}
	}		