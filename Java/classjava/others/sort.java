import java.io.*;

class sort
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		int a[]=new int[10];
		System.out.println("\n how many numbers:");
		int n=Integer.parseInt(dis.readLine());
		
		for(int i=0;i<n;i++)
			{
			System.out.println("\n Enter "+ i + " th element");
			a[i]=Integer.parseInt(dis.readLine());
			}
		System.out.println("\n The array elements are:");
		for(int i=0;i<n;i++)
			{
			System.out.println(a[i]);
			}
		for(int i=0;i<n;i++)
			{
			for(int j=0;j<n;j++)
				{
				if(a[i]<a[j])
					{
					int temp=a[i];
					    a[i]=a[j];
					    a[j]=temp;	
					}
				}
			}
		System.out.println("\n The sorted array elements are:");
		for(int i=0;i<n;i++)
			{
			System.out.println(a[i]);
			}
		}
	}
