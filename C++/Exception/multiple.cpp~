// Program for Multiple Catch Statements

#include<iostream.h>
#include "conio.h"

void myexception(int i)
	{	
		try
		{
		if(i==0)	throw i;		// Throw integer
		else if(i==1)	throw 'i';		// Throw Character
		else if(i==2)	throw 3.14;		// Throw Double
		else if(i==3)	throw 6.114;		// Throw Float
		}
		catch(int i)
		{
		cout<<"\n Integer Exception Caught";
		}
		catch(char c)
		{
		cout<<"\n Character Exception Caught";
		}
		catch(float f)
		{
		cout<<"\n Float Exception Caught";
		}
		catch(double d)
		{
		cout<<"\n Double Exception Caught";
		}
	}
int main()
	{
	clrscr();
	myexception(0);
	myexception(1);
	myexception(2);
	myexception(3);
	getch();
	return 0;
	}
