import java.io.*;

class thread implements Runnable
	{
	Thread t;	
	public thread()
		{
		t=new Thread(this,"My Thread");
		t.start();
		}
	public void run() 
		{
		try
			{
			System.out.println("How many Digits:");
			DataInputStream dis=new DataInputStream(System.in);
			int n=Integer.parseInt(dis.readLine());
			int no=0;
	
			for(int i=1;i<=n;i++)
				{
				no=no+i;
				System.out.println(no);
				Thread.sleep(500);
				}	
			}
		catch(InterruptedException e)
			{
			}
		catch(IOException e1)
			{
			}
		}
	}
class mythread
	{	
	public static void main(String args[])
		{
		thread ob=new thread();
		try
			{
			for(int j=0;j<3;j++)
				{
				System.out.println("Amit");
				Thread.sleep(500);
				}
			}
		catch(InterruptedException e)
			{
			}	
		}
	}