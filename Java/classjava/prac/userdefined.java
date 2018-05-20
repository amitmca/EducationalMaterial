import java.io.*;

class myexception extends Exception
	{
	myexception(String  s)
		{
		System.out.println(s);
		}
	}

class userdefined
	{	
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		int a,b,c;
		System.out.println("First Number:");
		a=Integer.parseInt(dis.readLine());
		
		System.out.println("Second Number:");
		b=Integer.parseInt(dis.readLine());
			
		try
			{
			if(b==0)
				throw new myexception("Second number cannot be zero");
			else
				{
				c=a/b;
				System.out.println("Division is:"+c);
				}
			}
		catch(myexception e)
			{
				
			}
		}
	}