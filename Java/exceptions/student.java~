import java.io.*;

class AgeInvalidException extends Exception
	{
	}
class stud
	{
	int rno;
	String name;
	int age;
	stud(int r,String name1,int age1)
		{
		rno=r;
		name=name1;
		age=age1;
		}
	public void print()
		{
		System.out.println("\n RollNO\tName\tAge\n");
		System.out.println("------------------------------------");
		System.out.println(rno+"\t"+name+"\t"+age+"\n");
		System.out.println("------------------------------------");
		}
	}
class student
	{
	public static void main(String args[])throws IOException
		{
		int rno,age;
		String name;
			try
			{
			DataInputStream dis=new DataInputStream(System.in);
			System.out.print("Enter Roll Number:");
			rno=Integer.parseInt(dis.readLine());
			System.out.print("Enter Name:");
			name=dis.readLine();
			System.out.print("Enter Age:");
			age=Integer.parseInt(dis.readLine());
			stud s=new stud(rno,name,age);
			if(age<15 || age>21)
				throw new AgeInvalidException();
			else
				s.print();
			}		
		catch(AgeInvalidException e)
			{
			System.out.println("Age is not between 15 and 21");
			}
		}
	}
