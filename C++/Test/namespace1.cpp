//Program for user defined NameSpace for constants

#include<iostream.h>
#include "conio.h"

namespace constants
	{
	float pi=3.1416;
	double e=2.71828;
	}
int main()
	{
	using namespace constants;
	clrscr();
	float a=pi*2*2;
	cout<<a<<endl;

	getch();
	return 0;
	}
