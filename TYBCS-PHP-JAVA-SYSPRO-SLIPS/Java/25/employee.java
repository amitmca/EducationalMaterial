import java.lang.*;
import java.util.*;
import java.io.*;

class emp
{
	private int id;
	private String name;
	private String dept;
	float sal;

	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

	emp(){}
	
	emp(int id,String name,String dept,float sal)
	{
		this.id=id;
		this.name=name;
		this.dept=dept;
		this.sal=sal;
	}
	void accept()throws IOException
	{
		System.out.println("Enter the employee id,name,dept,salary");
		id=Integer.parseInt(br.readLine());
		name=br.readLine();
		dept=br.readLine();
		sal=Float.parseFloat(br.readLine());
	}

	void display()
	{
		System.out.println("\nemployee detail as below: \n");
		System.out.println("*******************************");
		System.out.println("ID :"+id);
		System.out.println("Name :"+name);
		System.out.println("Dept :"+dept);
		System.out.println("Salary :"+sal);

	}

}


class manager extends emp
{
	private float bonus;
	float total;
	void accept() throws IOException
	{
		super.accept();
		System.out.println("\n Enter the bonus.:\n");
		bonus=Float.parseFloat(br.readLine());
	
	}
	void display()
	{
		total=sal+bonus;
		super.display();
		System.out.println("Bonus Rupees:"+bonus);
		System.out.println("Maximum Total salary:"+total);
	


	}
}
class employee
{
	public static void main(String[] args) throws IOException
	{	
		float max=0;
		int a=0;
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("\n Enter no:::\n");	
		int n=Integer.parseInt(br.readLine());
		manager m[]=new manager[n];
		
		for(int i=0;i<n;i++)
		{
			m[i]=new manager();
			m[i].accept();
		}
		for(int i=0;i<n;i++)
		{
			m[i].display();
			
		}
		for(int i=0;i<n-1;i++)
		{
			if(m[i].total<m[i+1].total)
			{
				
				a=i;
			}
			

		}
		
		System.out.println("MAX SAL..");
		m[a].display();
	}

}



