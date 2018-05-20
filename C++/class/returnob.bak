// Returning Objects

#include<iostream.h>
#include<conio.h>
class complex
	{
	float x,y;
	public:
		void input(float real,float imag)
			{
			x=real;
			y=imag;
			}
		friend complex sum(complex,complex);
		void show(complex);
	};

complex sum(complex c1,complex c2)
	{
	complex c3;
	c3.x=c1.x+c2.x;
	c3.y=c1.y+c2.y;
	return(c3);
	}

void complex::show(complex c)
	{
	cout<<c.x<<" + i "<<c.y<<"\n";
	}

int main()
	{
	complex c1,c2,c3;
	clrscr();
	c1.input(2.5,3.2);
	c2.input(3.5,2.3);
	c3=sum(c1,c2);
	cout<<"c1:";	c1.show(c1);
	cout<<"c2:";	c2.show(c2);
	cout<<"c3:";	c3.show(c3);
	getch();
	return 0;
	}