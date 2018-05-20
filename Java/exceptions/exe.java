import java.io.*;

class exe
	{
	public static void main(String args[])
		{
		try
			{
			int a=0;
			int b=42/a;
			System.out.println("b:"+b);
			}
		catch(ArithmeticException e)
			{
			System.out.println("Division By Zero");
			}
		}
	}