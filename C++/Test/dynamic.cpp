#include<iostream.h>
#include "conio.h"

struct A
	{
	virtual void f()
		{
		cout<<"Class A";
		}
	};

struct B:A
	{
	virtual void f()
		{
		cout<<"Class B";
		}
	};


struct C:A
	{
	virtual void f()
		{
		cout<<"Class C";
		}
	};
void f(A *arg)
	{
	B *bp=dynamic_cast<B *>(arg);
	C *cp=dynamic_cast<C *>(arg);
	if(bp)
		bp->f();
	else if(cp)
		cp->f();
	else
		arg->f();
	}
int main()
	{
	A a;
	C c;
	clrscr();
	A *ap=&c;
	A *cp=&a;
	f(ap);
	f(cp);
	getch();
	return 0;
	}	
