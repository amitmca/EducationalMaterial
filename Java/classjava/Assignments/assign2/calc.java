import java.io.*;

class calc
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		int a,b,ans,choice;
		do
			{
			System.out.println("\n 1) ADDITION \t 2) SUBTRACTION  \t 3) MULTIPLICATION \t 4) DIVISION\n");
			System.out.println("Your Choice:");
			choice=Integer.parseInt(dis.readLine());
			switch(choice)
				{
				case 1:
				System.out.println("First Number:");
				a=Integer.parseInt(dis.readLine());
				System.out.println("Second Number:");
				b=Integer.parseInt(dis.readLine());
				ans=a+b;
				System.out.println("Adddtion is:"+ans);
				break;
					
				case 2:
				System.out.println("First Number:");
				a=Integer.parseInt(dis.readLine());
				System.out.println("Second Number:");
				b=Integer.parseInt(dis.readLine());
				ans=a-b;
				System.out.println("SUBTRACTION is:"+ans);
				break;	
	
				case 3:
				System.out.println("First Number:");
				a=Integer.parseInt(dis.readLine());
				System.out.println("Second Number:");
				b=Integer.parseInt(dis.readLine());
				ans=a*b;
				System.out.println("MULTIPLICATION is:"+ans);
				break;	
	
				case 4:
				System.out.println("First Number:");
				a=Integer.parseInt(dis.readLine());
				System.out.println("Second Number:");
				b=Integer.parseInt(dis.readLine());
				ans=a/b;
				System.out.println("DIVISION is:"+ans);
				break;

				case 5:	
					System.exit(0);			
				}	
			}while(choice!=5);
		}
	}