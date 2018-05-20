// Program for checking the file existance using fail(),bad(),good() functions

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<stdlib.h>

int main()
	{
	ifstream in;
	clrscr();
	in.open("amit.txt");
	if(in.good())
		{
		cout<<"\n File exists\n";
		}
	else
		{
		cerr<<"\n Sorry file not exists\n";
		exit(1);
		}
	getch();
	return 0;
	}
