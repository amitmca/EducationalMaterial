import java.util.*;
class amit
	{	
	public static void main(String args[])		
		{
		String a[]={"amit","ajit","rohit"};
		Random rand = new Random();
		int num = rand.nextInt(2);
		System.out.println(a[num]);
		}
	}