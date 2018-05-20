import java.io.*;

class calculate
	{
	public void calc(int a[])
		{
		for(int i=0;i<a.length;i++)
			{
			a[i]=a[i]*2;
			}
		for(int i=0;i<a.length;i++)
			{
			System.out.println("a"+"["+i+"]"+"="+a[i]);
			}
		}
	
	}

class amethod
	{
	public static void main(String args[])
		{
		calculate c=new calculate();
		int a[]={1,2,3,4,5};
		c.calc(a);
		}	

	}