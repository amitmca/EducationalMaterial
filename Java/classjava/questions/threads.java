import java.io.*;
import java.util.Random;


class mythread implements Runnable
	{
	String tname;
	Thread t;
	int a[]={50,25,30,45,70};	
	mythread()
		{
		t=new Thread(this,"Threads");
		t.start();
		}
	public void run()
		{
		Random rand = new Random();
		try
			{
			for(int i=0;i<5;i++)
				{
				System.out.println("Divide by 5:"+a[i]/5);
				Thread.sleep(500);	
				int r=rand.nextInt(100);
				System.out.println("Random Number Generated:"+r+"\n");
				}
			}
		catch(InterruptedException e)
			{
			}
		}
	}

class threads
	{
	public static void main(String args[])
		{
		mythread m=new mythread();
		}
	}