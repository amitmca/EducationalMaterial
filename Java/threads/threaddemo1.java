//Program for threads using Runnable interface

class mythread extends Thread
	{
	
	mythread()
		{
		super("New thread");
		System.out.println("Child thread :"+this);
		start();
		}
	public void run()
		{
		try
			{
			for(int i=5;i>0;i--)	
				System.out.println("Child Thread:"+i);	
			Thread.sleep(1000);	
			}			
		catch(InterruptedException e)
			{
			System.out.println("Child Interrupted:");	
			}
		System.out.println("Exiting Child Thread:");	
		}	
	}

class threaddemo1
	{
	public static void main(String args[])
		{
		mythread m=new mythread();
		try
			{
			for(int i=5;i>0;i--)	
				System.out.println("Main Thread:"+i);	
			Thread.sleep(1000);	
			}			
		catch(InterruptedException e)
			{
			System.out.println("Main thread Interrupted:");	
			}
		System.out.println("Exiting Main Thread:");	
		}
	}
