import mca.*;
import java.io.*;
public class pkg1
	{
	public static void main(String args[])throws IOException
		{
		DataInputStream dis=new DataInputStream(System.in);

		System.out.println("First Number(Integer):");
		int a=Integer.parseInt(dis.readLine());

		System.out.println("Second Number(Integer):");
		int b=Integer.parseInt(dis.readLine());

		System.out.println("Addition is:");
		Mathematics m=new Mathematics();
		int ans=m.add(a,b);
		System.out.println(ans);

		System.out.println("Third Number(Integer):");
		int c=Integer.parseInt(dis.readLine());
		Maximum m1=new Maximum();		
		int ans1=m1.max(a,b,c);
		System.out.println("Maximum is:");
		System.out.println(ans1);

		System.out.println("First Number(Float):");
		float p=Float.parseFloat(dis.readLine());

		System.out.println("Second Number(Float):");
		float q=Float.parseFloat(dis.readLine());

		System.out.println("Third Number(Float):");
		float r=Float.parseFloat(dis.readLine());

		float s=m.add(p,q,r);
		System.out.println("Addition is:"+s);
		}
	}
