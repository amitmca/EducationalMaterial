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

class multithreaddemo1
	{
	public static void main(String args[])
		{
		mythread m=new mythread("one");
		mythread n=new mythread("two");
		mythread o=new mythread("three");
		System.out.println("Thread one is alive:"+m.t.isAlive());
                System.out.println("Thread two is alive:"+n.t.isAlive());
                System.out.println("Thread three is alive:"+o.t.isAlive());                
		try
			{
                        System.out.println("Waiting for threads finish");
                        m.t.join();
                        n.t.join();
                        o.t.join();
                        }			
		catch(InterruptedException e)
			{
			System.out.println("Main thread Interrupted:");	
			}
		System.out.println("Thread one is alive:"+m.t.isAlive());
                System.out.println("Thread two is alive:"+n.t.isAlive());
                System.out.println("Thread three is alive:"+o.t.isAlive());   	
		System.out.println("Exiting Main Thread:");	
		}
	}
