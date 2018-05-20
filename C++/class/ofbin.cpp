//Program to Overload a Binary Operator Using Friend Function

#include<iostream.h>
#include "conio.h"

class complex
	{
	float x,y;
	public:
		complex()	{	}
		complex(float real,float imag)
			{
			x=real;
			y=imag;
			}
		friend complex operator +(complex,complex);
		void display(void);
	};
complex operator +(complex a,complex b)
	{
	return complex((a.x+b.x),(a.y+b.y));
	}
void complex::display(void)
	{
	cout<<x<<" +j "<<y<<"\n";
	}
int main()
	{
	complex c1,c2,c3;
	clrscr();
	c1=complex(2.5,3.5);
	c2=complex(1.6,2.7);
	c3=c1+c2;
	cout<<"C1=";c1.display();
	cout<<"C2=";c2.display();
	cout<<"C3=";c3.display();
	getch();
	return 0;
	}
