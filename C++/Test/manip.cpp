//Program for manipulators

#include<iostream.h>
#include "conio.h"
#include<iomanip.h>

int main()
	{
	int a=123;
	clrscr();
	cout.setf(ios::hex,ios::basefield);
	cout<<a;
	getch();
	return 0;
	}
