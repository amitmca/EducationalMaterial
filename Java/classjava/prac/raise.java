import java.io.*;

class raise
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println("Enter a number:");
		try
			{
			int a=Integer.parseInt(dis.readLine());
			System.out.println(a);
			}
		catch(NumberFormatException e)
			{
			System.out.println(e);
			}
		}	
	}