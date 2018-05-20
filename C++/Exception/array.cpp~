// Program for Handling Array Out Of Bound Exception

#include<iostream.h>
#include "conio.h"

int main()
	{
	char myarray[10];
	clrscr();
	try
		{
		for(int n=0;n<=10;n++)	
			{
			if(n>9) throw "Out Of Range";
			myarray[n]='z';
			}
		}
	catch(char *str)
		{
		cout<<"\n Exception:"<<str<<endl;
		}
	getch();
	return 0;
	}
