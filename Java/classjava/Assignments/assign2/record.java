
import java.io.*;

class student
	{
	static int rno[];
	static String name[];
	static float per[];
	static DataInputStream dis1=new DataInputStream(System.in);

	 student(int n)
		{
		rno=new int[n];
		name=new String[10];	
		per=new float[n];			
		}
	 static void get(int n)throws IOException
		{
		System.out.println("\nEnter information for "+" " +n+" "+" students\n");
		for(int i=0;i<n;i++)
			{
			System.out.print("Enter Roll Number of "+" "+i+" "+"student :");
			rno[i]=Integer.parseInt(dis1.readLine());
			System.out.print("Enter Name of "+" "+i+" "+"student :");
			name[i]=dis1.readLine();
			System.out.print("Enter Percentage of "+" "+i+" "+"student :");
			per[i]=Float.parseFloat(dis1.readLine());
			System.out.println("\n");
			}
		}
	 static void put(int n)throws IOException
		{
		System.out.println("\nRNO\tNAME\tPERCENTAGE\n");
		System.out.println("--------------------");
		for(int i=0;i<n;i++)
			{
			System.out.println(rno[i]+"\t"+name[i]+"\t"+per[i]);
			}
		}
	}

class record
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println("\n How many Students are there:");
		int p=Integer.parseInt(dis.readLine());
		student t=new student(p);
		t.get(p);
		t.put(p);
		}
	}