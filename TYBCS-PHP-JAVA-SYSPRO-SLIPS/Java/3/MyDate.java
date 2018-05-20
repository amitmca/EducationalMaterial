import java.io.*;

class InvalidDateException extends Exception
	{
		InvalidDateException()
		{
		System.out.print("Exception :Date is invalid");
		}
	}

class MyDate
{
	int d;
	int m;
	int y;
	MyDate()
	{
	}
	MyDate(int d,int m,int y)
	{
		this.d=d;
		this.m=m;
		this.y=y;
	}
	public static void main(String args[]) throws IOException
	{
		int a,b,c;
		System.out.println("Enter date :");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		a=Integer.parseInt(br.readLine());
		b=Integer.parseInt(br.readLine());
		c=Integer.parseInt(br.readLine());
	
	try
	{
		if(b<1 || b>=13)
			throw new InvalidDateException();
		switch(b)
		{
		case 1: case 3: case 5: case 7: case 9: case 10: case 12:
			if(a <=0 || a >=32)
				throw new InvalidDateException();
		break;
		case 4: case 6: case 8: case 11:
			if(a<=0 || a>=31)
				throw new InvalidDateException();
		break;
		case 2 :
			if(a<=0 || a>=29)
				throw new InvalidDateException();
		break;
		}
		System.out.println(a+"/"+b+"/"+c);
	}
	catch(InvalidDateException e)
	{}
	finally{}
	}
}
