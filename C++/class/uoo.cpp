// Program for unary Operator overloading using member function
// When overloading a unary operator by using member function will not
// take argument but when overloaded using friend function takes one
// argument
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
	cout<<"x="<<x<<"\n";
	cout<<"y="<<y<<"\n";
	cout<<"z="<<z<<"\n";
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
	s.getdata(10,-20,30);
	cout<<"S=";
	s.display();
	-s;
	cout<<"\nS=";
	s.display();
	getch();
	return 0;
	}