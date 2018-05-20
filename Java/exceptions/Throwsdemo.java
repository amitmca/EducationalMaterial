import java.io.*;

class Throwsdemo
	{
	static void demoproc()throws IllegalAccessException
		{
		System.out.println("Inside method");
		throw new IllegalAccessException("demo");
		}
	public static void main(String args[])
	{
	try		
		{
		demoproc();
		}
	catch(IllegalAccessException e)
		{
		System.out.println("caught: "+e);
		}
	}
	}
	
