package stud;

import java.io.*;

public class student1	
	{
	public static int r[];
	public static String name[];
	public static float per[];
	public static DataInputStream dis=new DataInputStream(System.in);

	public student1(int n)
		{
		r=new int[n];
		name=new String[n];
		per=new float[n];
		}
	public static void get(int n)throws IOException 
		{
		System.out.println("Enter the information for  "+n+"  students\n"); 
		for(int i=0;i<n;i++)
			{
			System.out.println("Roll No for "+i+" Student");
			r[i]=Integer.parseInt(dis.readLine());

			System.out.println("Name for "+i+" Student");
			name[i]=dis.readLine();

			System.out.println("Percentage for "+i+" Student");
			per[i]=Float.parseFloat(dis.readLine());
			}
		}
	public static void put(int n)
		{
		System.out.println("\nRoll No\tName\tPercentage\n");
		System.out.println("-------------------------------------\n");
		for(int i=0;i<n;i++)
			{
			System.out.println(r[i]+"\t"+name[i]+"\t"+per[i]+"\n");
			}
		System.out.println("-------------------------------------\n");
		}
	}

