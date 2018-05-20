import java.io.*;
import java.lang.*;
import java.util.*;

class vehicle
{
	String company;
	float price;

	vehicle()
	{

	}	
	vehicle(String company,float price)
	{
		this.company=company;
		this.price=price;

	}
	void display()
	{
		System.out.println("Vehicle details...");
		System.out.println("Company Name:-"+company);
		System.out.println("Price:-"+price);


	}
	

}

class lightmotorvehicle extends vehicle
{
	float mileage;
	
	lightmotorvehicle()
	{
	}
	lightmotorvehicle(String company,float price,float mileage)
	{
		super(company,price);
		
		this.mileage=mileage;

	}
	void display()
	{	
		super.display();
		System.out.println("mileage:-"+mileage);
	
	}
	
}

class heavymotorvehicle extends vehicle
{
	float capacity;
	
	heavymotorvehicle()
	{
	}
	heavymotorvehicle(String company,float price,float capacity)
	{
		super(company,price);
		this.capacity=capacity;

	}
	void display()
	{
		super.display();		
		System.out.println("capacity:-"+capacity);
	
	}
	
}

class detail
{

	public static void main(String[] args)throws IOException
	{	
		
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		char v;
		int n;

		String company;
		float price;
		float mileage;
		float capacity;
	

		

		System.out.println("enter the no of vehicle:-");
		n=Integer.parseInt(br.readLine());

		lightmotorvehicle lmv[] = new lightmotorvehicle[n];
		heavymotorvehicle hmv[] = new heavymotorvehicle[n];

		for(int i=0;i<n;i++)
		{	
		System.out.println("enter the type of vehicle L/H:-");
		v=br.readLine().charAt(0);


			
			switch(v)
			{
			case 'l':
				System.out.println("Enter the company name");
				company=br.readLine();
				System.out.println("enter the price");
				price=Float.parseFloat(br.readLine());
				System.out.println("enter the mileage");
				mileage=Float.parseFloat(br.readLine());
				lmv[i]=new lightmotorvehicle(company,price,mileage);
				lmv[i].display();
					
			break;
		
			case 'h':
				System.out.println("Enter the company name");
				company=br.readLine();
				System.out.println("enter the price");
				price=Float.parseFloat(br.readLine());
				System.out.println("enter the capacity");
				capacity=Float.parseFloat(br.readLine());
				hmv[i]=new heavymotorvehicle(company,price,capacity);
				hmv[i].display();
				

			break;
			}



		
		}	

		
	}

}

