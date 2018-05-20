//Program to Overload a Binary Operator Using Friend Function

#include<iostream.h>
#include "conio.h"

class overload
	{
	int hours,mins;
	public:
		overload()	{	}
		overload(int h ,int m)
			{
			hours=h;
			mins=m;
			}
		friend overload operator +(overload,overload);
		void display(void);
	};
overload operator +(overload a,overload b)
	{
	return overload((a.hours+b.hours),(a.mins+b.mins));
	}
void overload::display(void)
	{
	cout<<hours<<" : "<<mins<<"\n";
	}
int main()
	{
	overload c1,c2,c3;
	clrscr();
	c1=overload(12,23);
	c2=overload(14,25);
	c3=c1+c2;
	cout<<"C1=";c1.display();
	cout<<"C2=";c2.display();
	cout<<"C3=";c3.display();
	getch();
	return 0;
	}
