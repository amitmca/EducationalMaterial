#include<iostream.h>
#include "conio.h"

int main()
	{
	int a=53,b=2;
	clrscr();
	float d=a/b;
	cout<<"d="<<d<<endl;
	float m=static_cast<float>(a)/b;
	cout<<"m="<<m<<endl;
	getch();
	return 0;
	}	
