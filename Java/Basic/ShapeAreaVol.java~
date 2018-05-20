import java.io.*;

abstract class Shape
	{
	double radius,ht;
	Shape(double a,double b)
		{
		radius=a;
		ht=b;
		}
	abstract double volume();
	abstract double area();
	}

class Cylinder extends Shape
	{
		Cylinder(double a,double b)
		{
		super(a,b);
		}
		double area()
		{
		System.out.println("\n Area Of Cylinder:");
		return(2*3.14*radius*ht);
		}
		double volume()
		{
		System.out.println("\n Volume Of Cylinder:");
		return(3.14*radius*radius*ht);
		}
	}

class Sphere extends Shape
	{
		Sphere(double a)
		{
		super(a,0);
		}
		double area()
		{
		System.out.println("\n Area Of Sphere:");
		return(4*3.14*radius*radius);
		}
		double volume()
		{
		System.out.println("\n Volume Of Cylinder:");
		return(4*3.14*radius*radius*radius)/3;
		}
	}
class Cone extends Shape
	{
		Cone(double a,double b)
		{
		super(a,b);
		}
		double area()
		{
		System.out.println("\n Area Of Cone:");
		return((3.14*radius)*(radius+ht));
		}
		double volume()
		{
		System.out.println("\n Volume Of Cone:");
		return(3.14*radius*radius*ht)/3;
		}
	}

class ShapeAreaVol 
	{
	public static void main(String args[])		
		{
		Cylinder c;
		Sphere s;
		Cone c1;
		try
			{
			c=new Cylinder(3,6);
			System.out.println(c.area());
			System.out.println(c.volume());

			s=new Sphere(5);
			System.out.println(s.area());
			System.out.println(s.volume());		

			c1=new Cone(2,4);
			System.out.println(c1.area());
			System.out.println(c1.volume());
			}
		catch(Exception e)
			{
			}
		}
	}
