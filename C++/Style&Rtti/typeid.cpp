// Program for typeid operator

// Classes containing virtual functions are called as polymorphic classes

// Here A and B are polymorphic classes

#include<iostream.h>
#include "conio.h"

using namespace std;

struct A
	{
	virtual ~A()		//virtual destructor
		{
		}
	};

struct B:A	
	{
	};

struct C
	{
	};

struct D:C
	{
	};


int main()
	{
	B bobject;
	A *ap=&bobject;
	A &ar=bobject;
	clrscr();
	cout<<"ap:"<<typeid(*ap).name()<<endl;
	cout<<"ar:"<<typeid(ar).name()<<endl;
	D dobject;
	C *cp=&dobject;
	C &cr=dobject;
	cout<<"cp:"<<typeid(*cp).name()<<endl;
	cout<<"cr:"<<typeid(cr).name()<<endl;
	getch();
	return 0;
	}
