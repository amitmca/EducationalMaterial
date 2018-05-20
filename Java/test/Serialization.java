import java.io.*;

public class Serialization
	{
	public static void main(String args[])
		{		
		try
			{
			MyClass object1=new MyClass("Hello",7,7.2);
			System.out.println("Object1:"+object1);
			FileOutputStream fos=new FileOutputStream("serial.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(object1);
			oos.flush();
			oos.close();
			}
		catch(Exception e)
			{
			System.out.println("Exception During Serialization:"+e);
			System.exit(0);
			}
		try
			{
			MyClass object2;
			FileInputStream fis=new FileInputStream("serial.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			object2=(MyClass)ois.readObject();
			ois.close();
			System.out.println("Object2:"+object2);
			}
		catch(Exception e)
			{
			System.out.println("Exception During De-Serialization:"+e);
			System.exit(0);
			}
		}	
	}

class MyClass implements Serializable
	{	
	String s;
	int i;
	double d;
	public MyClass(String s,int i,double d)
		{
		this.s=s;
		this.i=i;
		this.d=d;
		}
	public String toString()
		{
		return "S="+s+";  i="+i+";  d="+d;
		}
	}		
