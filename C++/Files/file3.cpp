// Program for get() and put()

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<stdlib.h>

int main()
	{
	ifstream in;
	long l,m;
	char ch;
	clrscr();
	in.open("amit.txt",ios::in|ios::binary);
	if(in.good())
		{
		while(!in.eof())
			{
			ch=in.get();
			cout.put(ch);
			}
		}
	else
		{
		cerr<<"\n Sorry file not exists\n";
		exit(1);
		}
	
	getch();
	return 0;
	}
