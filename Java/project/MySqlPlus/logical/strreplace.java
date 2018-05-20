class strreplace
	{
	public static void main(String args[])
		{
		String str="This is a '\\'";

		String str1=str.replace('\\','\\');

		System.out.println(str1);
		}
	}