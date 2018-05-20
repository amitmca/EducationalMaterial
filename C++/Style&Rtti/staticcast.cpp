//Program for static_cast operator

#include<iostream.h>
#include "conio.h"

int main()
	{
	int a=53,b=2;
	clrscr();
	float d=a/b;
	float m=static_cast<float>(a)/b;
	cout<<"\nd="<<d<<endl;
	cout<<"\nm="<<m<<endl;
	getch();
	return 0;
	}
