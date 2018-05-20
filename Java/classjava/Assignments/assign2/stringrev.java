import java.io.*;

class stringrev
	{
	public static  String reverse(String s)
	    {
  	    char[] chars = s.toCharArray();
	    for(int i=0;i< s.length()/2;++i)
		{
		char c = chars[i];
		chars[i] =  chars[chars.length-i-1];
		chars[chars.length-i-1] =  c;
		}	
	     return String.valueOf(chars);
	     }
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		String str;
		System.out.println("Enter A String:");
		str=dis.readLine();
		System.out.println(reverse(str));
		}
	}

