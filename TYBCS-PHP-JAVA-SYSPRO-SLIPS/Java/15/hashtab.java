import java.io.*;
import java.util.*;
class Student
{
	public static void main(String args[])throws IOException
	{
		Hashtable hs=new Hashtable();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter how many no of students:");
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Name:");
			String name=br.readLine();
			System.out.println("Enter Percentage:");
			float per=Float.parseFloat(br.readLine());
			hs.put(name,per);


		}
		Enumeration keys=hs.keys();
		Enumeration values=hs.elements();
		System.out.println("Details of Student:");
		while(keys.hasMoreElements())
		{
			System.out.println("Name:"+keys.nextElement());
			System.out.println("Percentage:"+values.nextElement());
		}
		System.out.println("Enter name of student to be serched:");	
		String name1=br.readLine();
		keys=hs.keys();
		values=hs.elements();
		while(keys.hasMoreElements())
		{

			String str=(String)keys.nextElement(); 
			if(str.equals(name1))
			{
				System.out.println("Percentage of "+name1+" is:"+hs.get(name1));
			}

		}


	}
}
