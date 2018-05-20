import java.io.*;
import java.net.*;

class myserver
	{	
	public static void main(String args[])throws IOException
		{
		ServerSocket ss=null;
		try
			{
			ss=new ServerSocket(6000);
			}
		catch(IOException e)
			{		
			System.out.println(e);
			System.exit(1);
			}
		Socket cs=null;
		try
			{
			cs=ss.accept();
			}
		catch(IOException e1)
			{		
			System.out.println(e1);
			System.exit(1);
			}
		BufferedReader in=null;
		while(true)
			{
			try
				{
				in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
				String str=in.readLine();
				int n=Integer.parseInt(str);
				int t=n,r=0,sum=0;
				while(n>0)
					{
					r=n%10;
					sum=sum+r*r*r;
					n=n/10;
					}	
				if(sum==t)
					System.out.println("ArmStrong");
				else
					System.out.println("Not ArmStrong");
				}
			catch(IOException e2)
				{		
				System.out.println(e2);
				System.exit(-1);
				}
		
			}
		}
	}