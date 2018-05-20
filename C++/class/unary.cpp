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
	cout<<x<<"\n";
	cout<<y<<"\n";
	cout<<z<<"\n";
	}
void space::operator -()
	{
	x=-x;
	y=-y;
	z=-z;
	}
int main()
	{
	clrscr();
	space s;
	s.getdata(10,-20,30);
	cout<<"s::";
	s.display();
	-s;
	cout<<"s::";
	s.display();
	getch();
	return 0;
	}