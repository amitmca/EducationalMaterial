import java.io.*;

class Finally
	{
	static void procA()
		{
		try
			{
			System.out.println("Inside procA");
			throw new RuntimeException("demo");
			}
		finally
			{
			System.out.println("procA 's finally");
			}
		}
	static void procB()
		{
		try
			{
			System.out.println("Inside procB");
			return;
			}
		finally
			{
			System.out.println("procB 's finally");
			}
		}		
	static void procC()
		{
		try
			{
			System.out.println("Inside procC");
			}
		finally
			{
			System.out.println("procC 's finally");
			}
		}		
	public static void main(String args[])
		{
		try
			{
			procA();
			}
		catch(RuntimeException e)
			{
			System.out.println("Caught:"+e);
			}
		procB();
		procC();
		}
	}