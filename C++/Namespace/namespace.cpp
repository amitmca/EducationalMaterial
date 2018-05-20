//Program for user defined NameSpace

#include<iostream.h>
#include "conio.h"

using std::cout;
using std::endl;

namespace first 
	{
	int a=1,b=2,c=3,d=4,e=5;
	}

namespace second
	{
	double var=3.1416;
	}

int main()
	{
	using namespace second;
	clrscr();
	cout<<var<<endl;
	cout<<(var*2)<<endl;
	using first::c;
	cout<<c<<endl;
	getch();
	return 0;
	}
