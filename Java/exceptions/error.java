import java.io.*;
impotr java.util.Random;

class error
	{
	public static void main(String rags[])
		{
		int a=0,b=0,c=0;
		Random r=new Random();
		for(int i=0;i<32000;i++)
			{
			try
				{
				b=r.nextInt();
				c=r.nextInt();
				a=12345/(b/c);
				}
			catch(ArithmeticException e)
				{
				System.out.println("Division BY Zero");
				a=0;
				}
			System.out.println("a:"+a);
			}
		}
	}
