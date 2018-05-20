import java.io.*;
import java.util.*;

class rand
	{	
	public static void main(String args[])
		{
		Random r=new Random();
		int n=r.nextInt(1);
		if(n<0.5)
			System.out.println("Number is less than 0.5");		
		else
			System.out.println("Number is greater than 0.5");
		}
	}