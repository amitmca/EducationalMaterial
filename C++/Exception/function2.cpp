// Program for Handling Exception from a function outside try block

#include<iostream.h>
#include "conio.h"

void XTest(int test)
	{
	cout<<"Inside XTest:"<<test<<endl;
	try
		{
		if(test) throw test;
		}
	catch(int i)
		{
		cout<<"\n Exception:"<<i<<endl;
		}
	}
int main()
	{
	clrscr();
	XTest(1);
	XTest(2);
	XTest(3);
	getch();
	return 0;
	}
