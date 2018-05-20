//Program for Overloading Unary Operator using friend function

#include<iostream.h>
#include<conio.h>

class space
	{
	int x,y,z;
	public:
		void getdata(int a,int b,int c);
		void display(void);
		friend void operator -(space &s);
	};

void space::getdata(int a,int b,int c)
	{
	x=a;
	y=b;
	z=c;
	}

void space::display(void)
	{
	cout<<"x="<<x<<"\n\n";
	cout<<"y="<<y<<"\n\n";
	cout<<"z="<<z<<"\n\n";
	}

void operator -(space &s)
	{
	s.x=-s.x;
	s.y=-s.y;
	s.z=-s.z;
	}

int main()
	{
	space s;
	clrscr();
	s.getdata(-10,-20,30);
	cout<<"s=\n";
	s.display();
	-s;
	cout<<"s=\n";
	s.display();
	getch();
	return 0;
	}