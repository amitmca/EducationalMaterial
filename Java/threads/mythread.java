/**
 * @(#)mythread.java
 *
 *
 * @author 
 * @version 1.00 2009/2/1
 */
 class thread implements Runnable
	{
	Thread t;
	String name;
	thread(String tname)			
		{
		name=tname;
		t=new Thread(this,name);
		System.out.println("New Thread:"+t);
		t.start();
		}
	public void run()
		{
			try
			{
			System.out.println("This is from child thread");
			Thread.sleep(1000);
			System.out.println("This is again from child thread");
			}
			catch(InterruptedException e)
			{
			System.out.println("Child Thread Interrupted");
			}
		}		
	}

public class mythread 
	{
	   public static void main(String[] args) 
	   	{
	   		thread f=new thread("one");
	   		thread s=new thread("two");
	   		thread th=new thread("three");
	   		
	   		System.out.println("Thread one is alive:"+f.t.isAlive());
	   		System.out.println("Thread two is alive:"+s.t.isAlive());
	   		System.out.println("Thread three is alive:"+th.t.isAlive());
	   		
    		try
			{
			System.out.println("This is from main thread");
			Thread.sleep(1000);
			System.out.println("This is again from main thread");
			f.t.join();
			s.t.join();
			th.t.join();
			}
			catch(InterruptedException e)
			{
			System.out.println("Main Thread Interrupted");
			}
	   		System.out.println("Thread one is alive:"+f.t.isAlive());
	   		System.out.println("Thread two is alive:"+s.t.isAlive());
	   		System.out.println("Thread three is alive:"+th.t.isAlive());
    	}
}
