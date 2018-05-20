
#include<iostream.h>
#include "conio.h"

class currency
	{
	int c1,c2;
	public:
		currency(int x,int y)
		{
		c1=x;
		c2=y;
		}
		void convert()
		{
		c1=c2+10;
		cout<<"c1="<<c1;
		}
	};

int main()
	{
	currency obj(200,400);
	clrscr();
	obj.convert();
	getch();
	return 0;
	}
