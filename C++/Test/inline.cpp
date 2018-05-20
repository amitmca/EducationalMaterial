//Program for showing use of inline function 

#include<iostream.h>
#include "conio.h"

class interest
	{
	int p,n;
	float r;
	public:
		interest(int p1,int n1,float r1)
		{
		p=p1;
		n=n1;
		r=r1;
		}
		float simple1()
		{
		return (p*n*r)/100;
		}
		float simple2();
	};
inline float interest::simple2()
	{
	float si=(p*n*r)/100;
	return si;
	}

int main()
	{	
	interest i(1200,1,2.5);
	clrscr();
	float ans=i.simple1();
	cout<<"\n Simple Interest is:"<<ans;
	interest i1(1500,3,3.2);
	float ans1=i1.simple2();
	cout<<"\n Simple Interest is:"<<ans1;
	getch();
	return 0;
	}
