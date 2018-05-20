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
		void display()
		{
		cout<<x<<"+i"<<y<<endl;
		}
		complex operator+(complex);
	};
complex complex::operator +(complex c)
	{
	return complex((x+c.x),(y+c.y));
	}

int main()
	{
	complex c1,c2,c3;
	c1=complex(2.1,3.1);
	c2=complex(2.5,3.5);
	clrscr();
	c3=c1.operator+(c2);
	//c3=c1+c2;
	c3.display();
	getch();
	return 0;
	}

