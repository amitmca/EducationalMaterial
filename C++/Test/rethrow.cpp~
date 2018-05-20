#include<iostream.h>

void divide(double x,double y)
	{
	cout<<"\n Inside Function ";
	try
		{
		if(y==0.0)
			throw y;
		else
			cout<<"Division:"<<x/y<<"\n";
		}
	catch(double)
		{
		cout<<"\n Caught double inside function \n";
		throw;	
		}
	cout<<"\n Outside Function\n";
	}
int main()
	{
		
	cout<<"\n Inside Main\n";
	try
		{
		divide(10.5,2.0);	
		divide(20.0,0.0);
		}
	catch(double)
		{
		cout<<"\n Caught Double Inside Main\n";
		}
	cout<<"\n Outside main\n";

	return 0;
	}
