class InnerExample
	{
	static class Inner
		{
		public void call()
			{
			System.out.println("Inside Inner Class");
			}
		}
	public static void main(String args[])
		{
		Inner i=new Inner();
		i.call();
		}
	}