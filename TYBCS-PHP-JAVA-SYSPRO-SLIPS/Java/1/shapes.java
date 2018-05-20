import java.io.*;
import java.lang.*;
import java.util.*;

abstract class shape
{
	abstract void calArea();
	abstract void calValume();
}

class sphere extends shape
{
	float r,a,v;

	sphere()
	{
	}	
	sphere(float r)
	{
		this.r=r;
	}
	void calArea()
	{	
		a=(4*3.14f*r*r);
	}
	void calValume()
	{
		v=((4/3f)*3.14f*r*r*r);
	}
	void display()
	{
		System.out.println("\n Detail of sphere");
		System.out.println("Area:"+a);
		System.out.println("Valume:"+v);
	}
}
class cone extends shape
{
	float r,h,a,v;
	
	cone()
	{
	}
	cone(float r,float h)
	{
		this.r=r;
		this.h=h;
	}
	void calArea()
	{
		a=(3.14f*r*(r*h));
	}
	void calValume()
	{
		v=((1/3f)*(3.14f)*(r*r)*h);	
	}
	void display()
	{
		System.out.println("\n Detail of Cone");
		System.out.println("Area:"+a);
		System.out.println("Valume:"+v);

	}

}	

class cylinder extends shape
{
	float r,h,a,v;
	cylinder()
	{
	}	
	cylinder(float r,float h)
	{
		this.r=r;
		this.h=h;
	}
	void calArea()
	{
		a=(2*(3.14f)*r*(h+r));
	}	
	void calValume()
	{
		v=(3.14f*r*r*h);
	}
	void display()
	{
		System.out.println("\n Detail of Cylinder");
		System.out.println("Area:"+a);
		System.out.println("Valume:"+v);	

	}
}

class shapes
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
				
		char v;
		float r,l,b,h,a,val;
		int w;


	
		System.out.println("\n Enter the no of times you want to work.\n");
		n=Integer.parseInt(br.readLine());
	
		sphere sp[]=new sphere[n];
		cone   c[]=new cone[n];				
		cylinder syl[]=new cylinder[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("s  - for sphere");
			System.out.println("c  - for cone");
			System.out.println("l  - for cylinder");
			



			System.out.println("\n Please select the shape");
			w=br.readLine().charAt(0);
			
			switch(w)
			{
			 case 's':
				System.out.println("\n Enter the info about sphere");
			 	System.out.println("\n Enter the radius ");
				r=Float.parseFloat(br.readLine());		
				
				sp[i]=new sphere(r);
				sp[i].calArea();
				sp[i].calValume();
				sp[i].display();
			break;
			case 'c':
				System.out.println("\n Enter the info about cone");

				System.out.println("\n Enter the radius");
				r=Float.parseFloat(br.readLine());		
				System.out.println("\n Enter the Hight ");
				h=Float.parseFloat(br.readLine());
				
				c[i]=new cone(r,h);				
				c[i].calArea();
				c[i].calValume();	
				c[i].display();
			break;
			case 'l':
				System.out.println("\n Enter the info about cylinder");

				System.out.println("\n Enter the radius");
				r=Float.parseFloat(br.readLine());		
				System.out.println("\n Enter the Hight");
				h=Float.parseFloat(br.readLine());

				syl[i]=new cylinder(r,h);
				syl[i].calArea();
				syl[i].calValume();				
				syl[i].display();
			break;

			}
	

		}

	}	


}
