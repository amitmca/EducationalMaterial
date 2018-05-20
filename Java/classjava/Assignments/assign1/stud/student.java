package stud;
import java.io.*;

public class student
	{
	static int rno[];
	static String name[];
	static float per[];
	static DataInputStream dis1=new DataInputStream(System.in);

	public student(int n)
		{
		rno=new int[n];
		name=new String[10];	
		per=new float[n];			
		}
	public static void get(int n)throws IOException
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
	public static void put(int n)throws IOException
		{
		System.out.println("\nRNO\tNAME\tPERCENTAGE\n");
		System.out.println("--------------------");
		for(int i=0;i<n;i++)
			{
			System.out.println(rno[i]+"\t"+name[i]+"\t"+per[i]);
			}
		}
	}
