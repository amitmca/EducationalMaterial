import java.io.*;
import java.util.Random;

public final class randomg1
	{
         	public static void main(String args[])
		{
		/*Random randomGenerator = new Random();
		 for (int idx = 1; idx <= 10; ++idx)
 			{
			  int randomInt = randomGenerator.nextInt(1);	
			  if(randomInt<0.5)
			      System.out.println("Number generated is less than 0.5");
			else
			       System.out.println("Number generated is greater than 0.5");
			 }*/

		int minimum=0;
		int maximum=1;
		/*int randomNum = minimum + (int)(Math.random()*maximum);
	                  System.out.println(randomNum);*/

/*Random rn = new Random();
int n = maximum - minimum + 1;
int i = rn.nextInt() % n;
int randomNum =  minimum + i;
 System.out.println(randomNum);*/
/*
Random rand = new Random(); 
for (int j=0;j < 5;j++)
{
  System.out.println(rand.nextInt());
} 
*/

Random diceRoller = new Random();
for (int i = 0; i < 1; i++) {
  int roll = diceRoller.nextInt(6) + 1;
  System.out.println(roll);
}


		}
	}
