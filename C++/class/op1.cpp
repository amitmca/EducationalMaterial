
#include<iostream.h>
#include "conio.h"

class person
	{
	};
int main()
	{
	person abc;
	clrscr();
	getch();
	cout<<"abc is a";
	cout<<typeid(abc).name()<<"\n";
	return 0;
	}
