import java.io.*;

class exc
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println("\n Enter value of a:");
		int a=Integer.parseInt(dis.readLine());
		System.out.println("\n Enter value of b:");
		int b=Integer.parseInt(dis.readLine());
		int c;
		try
			{
			c=a/b;
			System.out.println("Value of C:"+c);
			}
		catch(ArithmeticException e)
			{
			}
		finally
			{
			
			}
		}
	}
