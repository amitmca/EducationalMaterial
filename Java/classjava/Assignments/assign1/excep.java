import java.io.*;

class myexception extends Exception
	{
	myexception(String s)
		{
		super(s);
		}
	}

class excep
	{
	public static void main(String args[]) throws IOException 
		{
		DataInputStream dis=new DataInputStream(System.in);
		String num=dis.readLine();
		try
			{
			Integer.parseInt(num);
				throw new myexception("This is not an integer");
			}
		catch(myexception  e)
			{
			System.out.println(e.getMessage());
			}
		catch(NumberFormatException e)
			{
			}
		}
	}