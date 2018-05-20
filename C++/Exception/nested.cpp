// Program for Nested Try-Catch Block

#include<iostream.h>
#include "conio.h"


int main()
	{	
	int a,b;
	clrscr();
	cout<<"\n Enter Value Of a:";
	cin>>a;
	cout<<"\n Enter Value Of b:";
	cin>>b;
	try
		{
		try	
			{
			int x=a-b;
			if(x!=0)
				{
				cout<<"\n Result:"<<a/x<<"\n";
				}
			else
				{
				throw x;
				}
			}
		catch(int i)
			{
			throw i;
			}
		}
	catch(int a)
		{
		cout<<"\n Exception Caught\n";
		}
	getch();
	return 0;
	}
