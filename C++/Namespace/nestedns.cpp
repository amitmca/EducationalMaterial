//Program for nested NameSpace

#include<iostream.h>
#include "conio.h"


namespace Name1
	{
	double i;
	namespace Name2
		{
		double j;
		}
	}

int main()
	{
	Name1::i=20.5;

	Name1::Name2::j=30.5;	//valid
	clrscr();
	cout<<"i="<<Name1::i<<"\n";
	cout<<"j="<<Name1::Name2::j<<"\n";
	using namespace Name1;
	cout<<"i="<<i<<"\n";
	cout<<"j="<<Name2::j<<"\n";
	getch();
	return 0;
	}
