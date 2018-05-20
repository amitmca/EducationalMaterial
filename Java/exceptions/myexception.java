import java.io.*;

class SmallNumberException extends Exception
	{
	}
class ProperNumberException extends Exception
	{
	}
class GreaterNumberException extends Exception
	{
	}
class myexception 
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream in=new DataInputStream(System.in);
		System.out.println("\nPlease enter a number:");
		int n=Integer.parseInt(in.readLine());
		try
			{
			if(n>=0 && n<=5)
				throw new SmallNumberException();
			else if(n>5 && n<=10)
				throw new ProperNumberException();
			else if(n>10)
				throw new GreaterNumberException();
			}
		catch(SmallNumberException s)
			{
			System.out.println("A Small Number is Entered");
			}
		catch(ProperNumberException p)
			{
			System.out.println("A proper Number is Entered");
			}	
		catch(GreaterNumberException g)
			{
			System.out.println("A Greater Number is Entered");
			}
		finally
			{
			int f=1;
			for(int i=1;i<=n;i++)
				{
				f=f*i;
				}
			System.out.println("Factorial Is : "+f);
			}
		}
	}
