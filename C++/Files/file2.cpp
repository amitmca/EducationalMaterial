// Program for seekg(),seekp(),tellg(),tellp()

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<stdlib.h>

int main()
	{
	ifstream in;
	long l,m;
	clrscr();
	in.open("amit.txt",ios::in|ios::binary);
	if(in.good())
		{
		l=in.tellg();
		in.seekg(0,ios::end);
		m=in.tellg();
		in.close();
		cout<<"\n File Size is:"<<(m-1)<<" bytes.\n";
		}
	else
		{
		cerr<<"\n Sorry file not exists\n";
		exit(1);
		}
	
	getch();
	return 0;
	}
