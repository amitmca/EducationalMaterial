import java.io.*;

class test
	{
	public int[] calc()
		{
		int a[]={1,2,3,4,5};
		return a;
		}
	}
class returna
	{
	public static void main(String args[])
		{
		test t=new test();
		int a[]=t.calc();
		for(int i=0;i<a.length;i++)
			{	
			a[i]=a[i]*2;
			System.out.println("a"+"["+i+"]"+"="+a[i]);
			}
		}
	}