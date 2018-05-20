class mythread implements Runnable
	{
	Thread t;
	mythread()
		{
		t=new Thread(this,"New thread");
		System.out.println("Child thread :"+t);
		t.start();
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

class threaddemo
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
