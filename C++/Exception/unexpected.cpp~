// Program for handling Unexcepted Exception

#include<iostream.h>
#include "conio.h"
#include<exception>
#include<string.h>
#include<stdlib.h>
 using namespace std;

class Up	{	};
class Fit	{	};
void g();
void f(int i)	throw(Up,Fit)
	{	
	switch(i)
		{
		case 1:	throw Up();
		case 2:	throw Fit();
		}
	g();
	}
void g()
	{
	throw 47;
	}
void my_unexpected()
	{	
	cout<<"Unexpected exception thrown";
	exit(1);
	}
int main()
	{	
	clrscr();
	set_unexpected(my_unexpected);
	for(int i=1;i<=3;i++)
		{
		try
			{
			f(i);
			}
		catch(Up)
			{
			cout<<"Up Caught"<<endl;
			}
		catch(Fit)
			{
			cout<<"Fit Caught"<<endl;
			}
		}
	getch();
	return 0;
	}
