//Program for Extending a Unnamed NameSpace

#include<iostream.h>
#include "conio.h"

using namespace std;

namespace 
	{
	void func(int);
	}
namespace
	{	
	void func(int i)
		{		
		cout<<i<<endl;	
		}
	}

int main()
	{
	clrscr();
	func(10);
	
	getch();
	return 0;
	}
