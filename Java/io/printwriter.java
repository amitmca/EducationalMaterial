import java.io.*;

class printwriter
	{
	public static void main(String args[])throws IOException
		{
		PrintWriter pw=new PrintWriter(System.out,true);
		pw.println("This is a string");
		int i=-7;
		pw.println(i);
		double d=4.5e-7;
		pw.println(d);	
		}
	} 
