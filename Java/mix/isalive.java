import java.lang.*;
import java.io.*;
class mythread implements Runnable
	{
	Thread t;
	String str;
	int n;
	mythread(String s)
		{
		str=s;
		t=new Thread(this,"New thread");
		t.start();
		System.out.println(t);
		}
	public void run()
		{
		try
			{
			for(int i=0;i<5;i++)
				{
				System.out.println(str+" : "+i);
				Thread.sleep(1000);
				}
			}	
		catch(InterruptedException e)
			{
			System.out.println("Child Thread Is Interrupted");
			}
		System.out.println(str +"  exiting....");
		}
	}
class isalive
	{
	public static void main(String args[])throws IOException
		{
		mythread obj1=new mythread("one");
		mythread obj2=new mythread("two");
		mythread obj3=new mythread("three");
		System.out.println("Thread 1 is alive : " +obj1.t.isAlive());
		System.out.println("Thread 2 is alive : " +obj2.t.isAlive());
		System.out.println("Thread 3 is alive : " +obj3.t.isAlive());
		try
			{
			System.out.println("Waiting For the thread to finish");
			obj1.t.join();
			obj2.t.join();
			obj3.t.join();
			Thread.sleep(1000);
			}	
		catch(InterruptedException e)
			{
			System.out.println("Main Thread Is Interrupted");
			}
		System.out.println("Thread 1 is alive : "+obj1.t.isAlive());
		System.out.println("Thread 2 is alive : "+obj2.t.isAlive());
		System.out.println("Thread 3 is alive : "+obj3.t.isAlive());
		System.out.println("Main thread exiting....");
		}
	}
