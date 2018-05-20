class stringtest
	{
	public static void main(String args[])
		{
		String a="Hello";
		StringBuffer b=new StringBuffer("Hello");
		if(a.equals(b))
			{
			System.out.println("Inside A"); 
			}
		else
			{
			System.out.println("Inside B"); 
			}
		} 
	}