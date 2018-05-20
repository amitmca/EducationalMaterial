import java.io.*;

class exc1
	{
	public static void main(String args[])throws IOException
		{
		int number;
		for(int i=0;i<args.length;i++)
			{
			try
				{
				number=Integer.parseInt(args[i]);
				}
			catch(NumberFormatException e)
				{
				System.out.println("\n Please enter only numbers");
				}
			}
		}
	}
