class stringtest
	{	
	public static void main(String args[])
		{
		String s="select * from amit.register";
		int start=0;
		int end=7;
		/*char buf[]=new char[end-start];
		s.getChars(start,end,buf,0);	
		String s1=new String(buf);*/
		String sub=s.substring(start,end);
		System.out.println(sub);
		}
	}
