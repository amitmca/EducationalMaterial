//Program for threads using Runnable interface

class mythread implements Runnable
	{
	Thread t;
	String name;
	mythread(String tname)
		{
		name=tname;	
		t=new Thread(this,name);
		System.out.println("New thread :"+t);
		t.start();
		}
	public void run()
		{
		try
			{
			for(int i=5;i>0;i--)	
				System.out.println(name+":"+i);	
			Thread.sleep(1000);	
			}			
		catch(InterruptedException e)
			{
			System.out.println(name+"Interrupted...");	
			}
		System.out.println(name+"Exiting...");	
		}	
	}

class multithreaddemo
	{
	public static void main(String args[])
		{
		mythread m=new mythread("one");
		mythread n=new mythread("two");
		mythread o=new mythread("three");
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
