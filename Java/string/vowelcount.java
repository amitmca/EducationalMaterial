import java.*;

class vowelcount
	{
	public static void main(String args[])
		{
		String str="amitueio";
		int l,i,c=0;
		l=str.length();
		System.out.println("Length:"+l);
		
		for(i=0;i<l;i++)
			{
			if(str.charAt(i)=='a' || str.charAt(i)=='A' || str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='E' || str.charAt(i)=='i' || str.charAt(i)=='I' || str.charAt(i)=='o' || str.charAt(i)=='O' || str.charAt(i)=='u' || str.charAt(i)=='U')
				{
				c++;
				}
			}
		System.out.println("Total Number Of Vowels are:"+c);
		}
	}