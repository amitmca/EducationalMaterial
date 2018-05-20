import java.io.*;

class LengthInvalidException extends Exception
	{
	}	

class str
	{	
	String s;
	str(String s1)
		{
		s=s1;
		}	
	}
class strtest
	{
	public static void main(String args[])throws IOException
		{
		try
			{
			int i,n;
			i=1;
			DataInputStream dis=new DataInputStream(System.in);
			n=Integer.parseInt(dis.readLine());
			do
			{
			String temp;
			System.out.println("Enter a String:");
			temp=dis.readLine();
			str t=new str(temp);
			int len=temp.length();
			if(len<5)
				throw new LengthInvalidException();
			else 
				System.out.println(temp);
			}while(i<=5);
			}
		catch(LengthInvalidException e)
			{
			System.out.println("Length of String is less than 5");
			}
		catch(NumberFormatException e1)
			{
			}
		}
	}
