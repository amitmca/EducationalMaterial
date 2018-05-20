//Program for dynamic_cast operator

#include<iostream.h>
#include "conio.h"

using namespace std;

struct A
	{
	virtual void f()
		{
		cout<<"Class A"<<endl;
		}
	};

struct B:A
	{		
	virtual void f()
		{
		cout<<"Class B"<<endl;
		}
	};

struct C:A
	{		
	virtual void f()
		{
		cout<<"Class C"<<endl;
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
	A aobj;
	C cobj;
	A *ap=&cobj;
	A *ap2=&aobj;
	clrscr();
	f(ap);
	f(ap2);
	getch();
	return 0;
	}
