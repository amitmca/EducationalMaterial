import java.io.*;
import java.util.Random;

public final class randomg
	{
                 public static int rand(int lo, int hi)
           	     {
 	 Random rn = new Random();
                        int n = hi - lo + 1;
                        int i = rn.nextInt() % n;
                        if (i < 0)
                                i = -i;
                        return lo + i;
	        }
	  private static void log(String aMessage)
		{
	    System.out.println(aMessage);
	  }

	public static void main(String args[])
		{
		int ans=rand(0,1);
		 log("Generating 10 random integers in range 0..99.");
		System.out.println(ans);
		if(ans<0.5)
			System.out.println("Number generated is less than 0.5");
		else
			System.out.println("Number generated is greater than 0.5");
		}
	}
