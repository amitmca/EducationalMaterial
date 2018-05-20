import java.util.*;
import java.io.*;
class Arraylist
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		ArrayList al=new ArrayList();
		System.out.println("Enter the no of elements");
		int n=Integer.parseInt(br.readLine());
		//System.out.println("Initialsize of al:"+al.size());
		//System.out.println("Enter the elements:");
		for(int i=0;i<n;i++)
		{
			System.out.println("enter the element "+i+":");
			int item=Integer.parseInt(br.readLine());
			if(!al.contains(item))
				al.add(item);
		}
		System.out.println("the contents of elements before sorting are:"+al);
		Collections.sort(al);
		System.out.println("the elements after sorting are:"+al);
	}
}
