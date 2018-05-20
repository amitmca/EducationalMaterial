import java.util.*;

class SampleThread extends Thread
{
	static int a[];	
	int s,e;
	static int sum;
	public SampleThread(int s,int e)
	{
	this.s=s;
	this.e=e;
	Random r=new Random();
	a=new int[1000];
	for(int i=s; i<=e;i++)
		{
		int num=(r.nextInt())%100;
		num=(num<0)?(num-1):(num*1);
		a[i]=num;
		
		}
	}
	public void run()
	{
		for(int i=s; i<=e;i++)
		{
			sum=sum+a[i];
		}
	}
}
class Ass5seta2
{
	public static void main(String[] args)
	{
		try
		{
			SampleThread t[]=new SampleThread[10];
			for(int i=0;i<10;i++)
			{
			t[i]=new SampleThread(i*100,(i*100+99));
			}
			for(int i=0;i<10;i++)
			{
			t[i].start();
			t[i].join();			
			}
			System.out.println("Sum:"+SampleThread.sum);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
