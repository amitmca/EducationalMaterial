 // Program for overloading Binary Operator using friend function

#include<iostream.h>
#include<conio.h>

class complex
	{
	float real,imag;
	public:
		complex()	{	}
		complex(float x,float y)
		{
		real=x;
		imag=y;
		}
		void display(void)
		{
		cout<<real<<"+ j"<<imag<<"\n";
		}
		friend complex operator +(complex,complex);
	};

complex operator +(complex a,complex b)
	{
	return complex((a.real+b.real),(a.imag+b.imag));
	}

int main()
	{
	complex c1,c2,c3;
	clrscr();
	c1=complex(2,3.5);
	c2=complex(3,2.3);
	c3=c1+c2;     // c3=operator+(c1,c2);
	c3.display();
	getch();
	return 0;
	}