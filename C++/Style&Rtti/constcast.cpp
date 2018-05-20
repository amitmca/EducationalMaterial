//Program for const_cast operator

#include<iostream.h>
#include "conio.h"

using namespace std;

void f(int *p)
	{
	cout<<*p<<endl;
	}

int main()
	{
	const int a1=40;
	const int *b1=&a1;
	clrscr();
	int *c1=const_cast<int>(b1);
	f(c1);
	getch();
	return 0;
	}
