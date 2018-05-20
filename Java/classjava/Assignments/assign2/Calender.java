import java.io.*;

class Calender
{
	public static void main (String arg[])
	{
	
	DataInputStream in=new DataInputStream(System.in);
	
	int month=0,counter=0;
		
	try
	{
		System.out.println("Jan--->1");
		System.out.println("Feb--->2");
		System.out.println("March--->3");
		System.out.println("April--->4");
		System.out.println("May--->5");
		System.out.println("June--->6");
		System.out.println("July--->7");
		System.out.println("Aug--->8");
		System.out.println("Sept--->9");
		System.out.println("Oct--->10");
		System.out.println("Nov--->11");
		System.out.println("Dec--->12");

		
		System.out.println("Press Number--->");
		month=Integer.parseInt(in.readLine());
		
		if(month==1 ||month==3 ||month==5 ||month==7 ||month==9||month==11 )
		{
			for(int i=1;i<=31;i++)
			{
				System.out.print(i+"   ");
				if (counter==6)
				{
					System.out.println();
					counter=0;
				}
				counter++;
			}
		}
		else
		if(month==4 ||month==6 ||month==8 ||month==10 ||month==12)
		{
			for(int i=1;i<=30;i++)
			{
				System.out.print(i+"   ");
				if (counter==6)
				{					
					System.out.println();
					counter=0;
				}
				counter++;
			}
		}
		else	
		if(month==2)
		{
			for(int i=1;i<=28;i++)
			{
				System.out.print(i+"   ");
				if (counter==6)
				{					
					System.out.println();
					counter=0;
				}
				counter++;
			}
		}
		else
		{
				System.out.print("InValid Entery");
		}
			
	}
	
	catch(Exception ee)
	{
	}
	
	}
}
