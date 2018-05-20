#include<iostream.h>
#include "conio.h"

struct A
	{
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
	B bobj;
	clrscr();
	A *ap=&bobj;
	A &ar=bobj;
	cout<<"ap="<<typeid(*ap).name()<<endl;
	cout<<"ar="<<typeid(ar).name()<<endl;
	D dobj;
	C *cp=&dobj;
	C &cr=dobj;
	cout<<"cp="<<typeid(*cp).name()<<endl;
	cout<<"cr="<<typeid(cr).name()<<endl;
	getch();
	return 0;
	}
