// Slip 21 


import java.io.*;
//seta2
class Student1
{
	int rn;
	float per;
	String name;
	static int cnt;
	static 
	{
	cnt=1000;
	}
	public Student1()
	{
	}
	public Student1(float per,String name)
	{
	rn=cnt++;
	this.name=name;
	this.per=per;
	}
	public String toString()
	{
	return("\nRoll Number :"+rn+"Name :"+name+"Percentage :"+per);
	}
	public static  void sort(Student1 c[])
	{
		for(int i=0; i<c.length-1; i++)
		{
		for(int j=i+1; j<c.length; j++)
		{
			if(c[i].per>c[j].per)
			{
			Student1 temp=c[i];
			c[i]=c[j];
			c[j]=temp;
			}
		}
		}
	}
}
public class Student
{
	public static void main(String args[])  throws Exception
	{
		String name;
		float per;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n;
		System.out.println("Enter n:");
		n=Integer.parseInt(br.readLine());
		Student1 c[]=new Student1[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter name and percentage:");
			name=br.readLine();
			per=Float.parseFloat(br.readLine());
			c[i]=new Student1(per,name);
		}
		System.out.println("Before sort");
		for(int i=0;i<n;i++)
		{
			System.out.println(c[i]);
		}
	
		System.out.println("After sort");
		for(int i=0;i<n;i++)
		{
			Student1.sort(c);
			System.out.println(c[i]);
		}
	}
}
