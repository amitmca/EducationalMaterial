//Program for Overloading Unary Operator
#include<iostream.h>
#include<conio.h>
class space
	{
	int x,y,z;
	public:
		void getdata(int a,int b,int c);
		void display(void);
		void operator -();
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
void space::operator -()
	{
	x=-x;
	y=-y;
	z=-z;
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