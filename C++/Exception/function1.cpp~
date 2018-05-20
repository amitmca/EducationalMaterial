// Program for Handling Exception from a function outside try block

#include<iostream.h>
#include "conio.h"

void XTest(int test)
	{
	cout<<"Inside XTest:"<<test<<endl;
	if(test) throw test;
	}
int main()
	{
	clrscr();
	try
		{
		XTest(0);
		XTest(1);
		XTest(2);
		}
	catch(int i)
		{
		cout<<"\n Exception:"<<i<<endl;
		}
	getch();
	return 0;
	}
