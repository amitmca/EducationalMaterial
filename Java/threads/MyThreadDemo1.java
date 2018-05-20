class mythread extends Thread
	{
	
	public mythread()
		{
		super("Example");		// Call to Superclass Constructor of Thread class
		System.out.println(this.currentThread()+"\t"+this.getName()+"\t"+this.getPriority());
		start();
		}
	public void run()
		{
		try
			{
			for(int i=0;i<5;i++)
				{
				System.out.println("inside new thread"+i);
				Thread.sleep(1000);			
				}
			}
		catch(InterruptedException ie)
			{
			System.out.println("New Thread Interrupted");
			}
		System.out.println("Exiting from New thread");
		}
	
	}

class MyThreadDemo1
	{
	public static void main(String[] args)	
		{
		mythread obj=new mythread();
		try
			{
			for(int j=0;j<5;j++)
				{
				System.out.println("Inside main thread"+j);
				Thread.sleep(1000);			
				}
			}
		catch(InterruptedException ie)
			{
			System.out.println(ie.getMessage());
			}		
		System.out.println("Exiting from main thread");
		}
	}