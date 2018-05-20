// Program for Binary Operator overloading using member function
// When overloading a unary operator by using member function will not
// take argument but when overloaded using friend function takes one
// argument

#include<iostream.h>
#include<conio.h>
class complex
	{
	float x,y;
	public:
		complex()	{ }
		complex(float real,float imag)
			{
			x=real;
			y=imag;
			}
		complex operator +(complex);
		void display(void);
	};
complex complex::operator +(complex c)
	{
	complex temp;
	temp.x=x+c.x;
	temp.y=y+c.y;
	return(temp);
	}
void complex::display(void)
	{
	cout<<x<<"+i"<<y<<"\n";
	}
int main()
	{
	complex c1,c2,c3;
	clrscr();
	c1=complex(2.5,3.5);
	c2=complex(1.6,2.7);
	c3=c1+c2;		// c3=c1.operator +(c2);
	cout<<"\n C1:";c1.display();
	cout<<"\n C2:";c2.display();
	cout<<"\n C3:";c3.display();
	getch();
	return 0;
	}
