
class array
	{
	public static void Main(string[] args)
		{
		char[] name=new char[] {'A','M','I','T',(char) 0};
		int c=0;
		while(name[c]!=0)
			{
			System.Console.Write("{0}",name[c]);
			c++;
			}

		}
	}		