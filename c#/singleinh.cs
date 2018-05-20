using System;
class person
	{
	public int pno;
	public string pname; 

	public void get(int n,string name)
		{
		pno=n;
		pname=name;
		}	
	public void put()
		{
		System.Console.WriteLine("Number is:",pno);
		System.Console.WriteLine("Name is:",pname);
		}
	}
public class person1: person
	{
	public string padd; 
	override public void get(string add)
		{
		padd=add;	
		}
	override public void put()
		{
		System.Console.WriteLine("Address is:",padd);
		}
	}
class mainclass
	{
	public static void Main(string[] args)
		{
		person p=new person(10,"Amit");
		person p1=new person1("Baramati");
		p.get();
		p.put();
		p1.get();
		p1.put();
		}
	}		