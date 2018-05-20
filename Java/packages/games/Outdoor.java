package games;
import java.io.*;

public class Outdoor
	{
		String O[]=new String[5];
		public Outdoor(String p,String q,String r,String s)
			{
			O[0]=p;
			O[1]=q;
			O[2]=r;
			O[3]=s;
			}
		public void display()
			{
			System.out.println("1."+O[0]+"\n2."+O[1]+"\n3."+O[2]+"\n4."+O[3]);
			}

	}
