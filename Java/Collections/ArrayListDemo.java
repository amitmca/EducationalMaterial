import java.util.*;

class ArrayListDemo
	{
	public static void main(String args[])
		{
		ArrayList a1=new ArrayList();
		ArrayList a2=new ArrayList();
					
		a1.add("A");
		a1.add("B");
		a1.add("C");
		a1.add("D");
		a1.add("E");
		a1.add("A");
		
		a2.addAll(a1);

		System.out.println("Contents Of Arraylist a2:"+a2);
		System.out.println("Size Of Arraylist is:"+a2.size());

		Object obj=a1.get(3);
		System.out.println(obj.toString());
		
		int i=a1.indexOf("A");
		System.out.println("index of A is:"+i);

		int j=a1.lastIndexOf("A");
		System.out.println("last index of A is:"+j);
		
		}
	}
