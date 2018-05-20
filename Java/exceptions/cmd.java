import java.io.*;

class cmd
	{
	public static void main(String args[])
		{
		int n=Integer.parseInt(args[0]);
		int i,f=1;
		for(i=1;i<=n;i++)
			{
			f=f*i;
			}
		System.out.println("Factorial Is:"+f);
		}
	}