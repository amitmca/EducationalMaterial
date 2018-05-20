//PROGRAM FOR OVERLOADING THE BINARY AND UNARY MINUS OPERATOR

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class over_load
{
		int x,y,z;
		public:
			void getdata(int a,int b,int c);
			void display();
			void operator-();
			void operator*();
};
void over_load::getdata(int a,int b,int c)
{
	x=a;
	y=b;
	z=c;
}
void over_load::display()
{

		cout<<"\n\n\tX= "<<x
			<<"\n\n\tY= "<<y
			<<"\n\n\tZ= "<<z;
}
void over_load::operator-()
{
	x=-x;
	y=-y;
	z=-z;
}
void over_load::operator*()
{
			x=x*x;
			y=y*y;
			z=z*z;
}
int main()
{
	over_load O;
	clrscr();
	O.getdata(10,20,30);
	cout<<"Origanal data";
	O.display();
	-O;
	cout<<"\n\nThe minus operator overload:";
	O.display();
	*O;
	cout<<"\n\nThe plus operator overload:";
	O.display();
	getch();
	return 0;
}