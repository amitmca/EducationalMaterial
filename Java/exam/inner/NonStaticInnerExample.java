class NonStaticInnerExample
	{
	class Inner
		{
		public void call()
			{
			System.out.println("Inside Inner Class");
			}
		}
	public static void main(String args[])
		{
		NonStaticInnerExample ie=new NonStaticInnerExample();
		Inner i=ie.new Inner();
		i.call();
		}
	}