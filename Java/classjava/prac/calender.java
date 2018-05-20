import java.io.*;

class calender
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		int month=0,count=0;
		System.out.println("\n Month:");
		month=Integer.parseInt(dis.readLine());

		if(month==1 || month==3 || month==5 || month==7 || month==9 || month==11)
			{
			for(int i=1;i<=31;i++)
				{
				System.out.print(i+" ");
				if(count==6)
					{
					System.out.println();
					count=0;
					}
				count++;
				}
			}
		else if(month==4 || month==6 || month==8 || month==10 || month==12)
			{
			for(int i=1;i<=30;i++)
				{
				System.out.print(i+" ");
				if(count==6)
					{
					System.out.println();
					count=0;
					}
				count++;
				}
			}
		else if(month==2)
			{
			for(int i=1;i<=28;i++)
				{
				System.out.print(i+" ");
				if(count==6)
					{
					System.out.println();
					count=0;
					}
				count++;
				}
			}
		else 
			{
			System.out.println("Invalid Month");
			}
		}
	}	