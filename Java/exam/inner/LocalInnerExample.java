class LocalInnerExample
	{
	public void m1()
		{
		class Inner
			{
			public void call()
				{
				System.out.println("Inside Inner Class");
				}
			}
		Inner i=new Inner();
		i.call();	
		}	
	public static void main(String args[])
		{
		LocalInnerExample ie=new LocalInnerExample();
		ie.m1();
		}
	}