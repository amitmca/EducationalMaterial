class NewThread1 implements Runnable
	{
	Thread t;
	String name;
	
	public NewThread1(String tname)
		{
		name=tname;
		t=new Thread(this,name);
		System.out.println("New Thread Created:"+t);
		t.start();
		}
	public void run()
		{
		try
			{
			for(int i=0;i<5;i++)
				{
				System.out.println(name+":  "+i);
				Thread.sleep(2000);
				}
			}
		catch(InterruptedException e)
			{
			System.out.println(e.getMessage());
			}
		System.out.println(name +" Exiting");
		}
	
	}

class JoinDemo
	{
	public static void main(String args[])
		{
		NewThread1 obj1=new NewThread1("One");
		NewThread1 obj2=new NewThread1("Two");

		System.out.println("Thread One is Alive:"+obj1.t.isAlive());
		System.out.println("Thread Two is Alive:"+obj2.t.isAlive());

		System.out.println("Waiting For Threads to terminate");
		
		try
			{
			obj1.t.join();
			obj2.t.join();
			}
		catch(Exception e1)
			{
			System.out.println(e1);
			}
		System.out.println("Thread One is Alive:"+obj1.t.isAlive());
		System.out.println("Thread Two is Alive:"+obj2.t.isAlive());
		}
	}	
	