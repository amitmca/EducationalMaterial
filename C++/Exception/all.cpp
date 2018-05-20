// Program for Catching all Exceptions

#include<iostream.h>
#include "conio.h"

void myexception(int i)
	{	
		try
		{
		if(i==0)	throw i;		// Throw integer
		if(i==1)	throw 'i';		// Throw Character
		if(i==2)	throw 1.2;		// Throw Double
		}
		catch(int x)
		{
		cout<<"\n Integer Exception Caught";
		}
		catch(...)
		{
		cout<<"\n Exception Caught";
		}
	}
int main()
	{
	clrscr();
	myexception(0);
	myexception(1);
	myexception(2);
	getch();
	return 0;
	}
