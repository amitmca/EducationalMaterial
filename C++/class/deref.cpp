#include<iostream.h>
#include<conio.h>
class M
	{
	int x,y;
	public:
	void set_xy(int a,int b)
		{
		x=a;
		y=b;
		}
	friend int sum(M m);
	};
int sum(M m)
	{
	int M::*px=&M::x;		// Pointer to data member
	int M::*py=&M::y;
	M*pm=&m;
	int  S=m.*px+pm->*py;	//
	return S;
	}
int main()
	{
	M n;
	clrscr();
	void(M::*pt)(int,int)=&M::set_xy;
	(n.*pt)(10,20);
	cout<<"sum="<<sum(n)<<"\n";
	M*op=&n;
	(op->*pt)(30,40);
	cout<<"sum="<<sum(n)<<"\n";
	getch();
	return 0;
	}