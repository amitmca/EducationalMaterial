// Program for handling Uncaught Exception

#include<iostream.h>
#include "conio.h"
#include<exception>
#include<string.h>
#include<stdlib.h>
using namespace std;

void terminator()
	{	
	cout<<"\n I'll be back !"<<endl;
	abort();	
	}	
void (*old_terminate) ()=set_terminate(terminator);
class Botch
	{
	public:
		class Fruit	{	};
	void f()
		{
		cout<<"Botch::f()"<<endl;
		throw Fruit();
		}
	~Botch()
		{
		throw 'c';
		}
	};
int main()
	{	
	clrscr();
	try
		{
		Botch b;
		b.f();
		}
	catch(...)
		{
		cout<<"Inside catch(...)"<<endl;
		}
	getch();
	return 0;
	}
