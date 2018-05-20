import java.io.*;

class mytest
	{
		
	public static void main(String args[])
		{
		try
			{
			DataInputStream dis=new DataInputStream(System.in);
			}	
		catch(IOException ioe)
			{
			System.out.println("IOException");
			}
		catch(Exception e)
			{
			System.out.println("Exception");
			}
		}	
	}	