// Program for using Exception Specification

#include<iostream.h>
#include "conio.h"

void function(int i) throw(int,double)
	{	
	if(i==1)	throw 12;
	if(i==2) 	throw 1234.2;
	}
void function1(int i) throw()
	{	
	if(i==1)	throw 12;
	if(i==2)	throw 1234.2;
	}
void function2(int i)
	{
	if(i==1)	throw 12;
	if(i==2)	throw 1234.2;	
	}
int main()
	{	
	clrscr();
		try
		{
		function(1);
		function(2);
		function2(2);
		function1(1);
		}
		catch(int i)
		{
		cout<<" caught integer :"<<i<<endl;
		}
		catch(double d)
		{
		cout<<" caught double :"<<d<<endl;
		}
	getch();
	return 0;
	}
