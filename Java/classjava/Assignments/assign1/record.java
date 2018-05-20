import stud.*;
import java.io.*;

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