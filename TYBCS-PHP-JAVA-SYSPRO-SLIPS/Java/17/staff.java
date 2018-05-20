import java.io.*;
import java.lang.*;
import java.util.*;

abstract class staff
{
	String name;
	String add;

	staff()
	{

	}
	staff(String name,String add)
	{
		this.name=name;
		this.add=add;
	}
	void display()
	{
		System.out.println("Staff details...");
		System.out.println("Name of staff member:-"+name);
		System.out.println("Address of staff member:-"+add);

	}

	 
}

class PartTimeStaff extends staff
{
	int nohr;
	float rph;

	PartTimeStaff()
	{

	}
	PartTimeStaff(String name,String add,int nohr,float rph)
	{	
		super(name,add);
		this.nohr=nohr;
		this.rph=rph;

	}
	void display()
	{
		super.display();
		System.out.println("no of hr :"+nohr);
		System.out.println("rate/hr :"+rph);
		

	}


}

class FullTimeStaff extends staff
{
	String dept;
	float sal;
	
	FullTimeStaff()
	{

	}
	FullTimeStaff(String name,String add,String dept,float sal)
	{
		super(name,add);
		this.dept=dept;
		this.sal=sal;
	}
	void display()
	{
		super.display();
		System.out.println("Department:"+dept);
		System.out.println("Salary:"+sal);

	}

}

class detail
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		char c;

		String name;
		String add;
		int nohr;
		float rph;
		String dept;
		float sal;

		System.out.println("enter the no of staff :-");
		n=Integer.parseInt(br.readLine());

		PartTimeStaff pts[]=new PartTimeStaff[n];
		FullTimeStaff fts[]=new FullTimeStaff[n];

		for(int i=0;i<n;i++)
		{

			System.out.println("enter the type of vehicle P/F:-");
			c=br.readLine().charAt(0);
		
			switch(c)
			{
			case 'p':
				System.out.println(" For Part time work..");
				System.out.println(" enter the name of staff");
				name=br.readLine();
				System.out.println(" enter the address of staff");
				add=br.readLine();
				System.out.println(" enter the no of hr");
				nohr=Integer.parseInt(br.readLine());
				System.out.println(" enter rate per hour");
				rph=Float.parseFloat(br.readLine());
				
				pts[i]=new PartTimeStaff(name,add,nohr,rph);
				pts[i].display();
			break;
			
			case 'f':
				System.out.println(" For full time work..");
				System.out.println(" enter the name of staff");
				name=br.readLine();
				System.out.println(" enter the address of staff");
				add=br.readLine();
				System.out.println(" enter the dept of staff");
				dept=br.readLine();
				
				System.out.println("enter the salary");
				sal=Float.parseFloat(br.readLine());
				
				fts[i]=new FullTimeStaff(name,add,dept,sal);
				fts[i].display();
			break;
			}


		}
		




	}

}

