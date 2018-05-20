// Program for Handling Exception from a function outside try block

#include<iostream.h>
#include "conio.h"
#include<string.h>

class test
	{
	public:
		char str[30];
		int a;
	test()
		{
		*str=0;
		a=0;
		}
	test(char *s,int e)
		{
		strcpy(str,s);
		a=e;
		}
	};
int main()
	{
	int i;
	clrscr();
	try	
		{
		cout<<"Enter a positive number:";
		cin>>i;
		if(i<0)
			throw test("Entered number is not positive",i);
		}
	catch(test e)
		{	
		cout<<e.str<<":";
		cout<<e.a<<"\n";
		}
	getch();
	return 0;
	}
