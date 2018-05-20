#include<iostream.h>
#include "conio.h"

class A
	{	
	private:
		int a,b,c;
	public:
		A(int x,int y)
		{
		cout<<"\n Inside A's Constructor\n";
		a=x;
		b=y;
		c=a+b;
		cout<<"\n C:"<<c<<"\n";
		}
	};
	

int main()
	{
	A obj(2,3);	
	clrscr();
	getch();
	return 0;
	}
