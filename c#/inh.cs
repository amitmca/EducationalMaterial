	using System;
	
	class student
	{

	private int rno;
	private string sname;
	private float per;
	
	public student()
		{
		rno=02;
		sname="Amit";
		per=(float)77.66;
		}
	public int getno()
		{
		return rno;
		}	
	public void setno(int n)
		{
		rno=n;
		}
	public string getname()
		{
		return sname;
		}
	public void setname(string name)
		{
		sname=name;
		}
	public float getper()
		{
		return per;
		}
	public void setper(float p)
		{
		per=p;
		}
	}
class student1:student
	{
	public student1()
		{
		setno(10);
		setname("Yogesh");
		setper((float)75.50);
		}
	}
class student2:student
	{
	public student2()
		{
		setno(25);
		setname("Abhijit");
		setper((float)73.50);
		}
	}
class inh
	{
	public static void Main(string[] args)
		{
		student s=new student();
		student1 s1=new student1();
		student2 s2=new student2();
		System.Console.WriteLine("S:# Number={0},# Name={1},Percentage={2}",s.getno(),s.getname(),s.getper());
		System.Console.WriteLine("S1:# Number={0},# Name={1},Percentage={2}",s1.getno(),s1.getname(),s1.getper());
		System.Console.WriteLine("S2:# Number={0},# Name={1},Percentage={2}",s2.getno(),s2.getname(),s2.getper());
		}
	}
