// Program for overloading Unary Operator using member function

#include<iostream.h>
#include<conio.h>
class space
	{
	int x,y,z;
	public:
		void getdata(int a,int b,int c)
		{
		x=a;
		y=b;
		z=c;
		}
		void display()
		{
		cout<<"x="<<x<<"\n";
		cout<<"y="<<y<<"\n";
		cout<<"z="<<z<<"\n";
		}
		void operator -()
		{
		x=-x;
		y=-y;
		z=-z;
		}

	};
int main()
	{
	space s;
	clrscr();
	s.getdata(1,2,3);
	cout<<"\n Before....\n";
	s.display();
	-s;
	cout<<"\n After....\n";
	s.display();
	getch();
	return 0;
	}