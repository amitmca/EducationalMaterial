import figures.*;

class Triangle extends Figure
	{
	float r=0.0f;
	public Triangle(int radius)
		{
		r=radius;
		}	
	public void area()
		{
		double a=3.14*r;
		System.out.println("Area is:"+a);	
		}
	}

class myfig
	{
	public static void main(String args[])
		{
		Triangle tri=new Triangle(6);
		tri.area();
		}
	}