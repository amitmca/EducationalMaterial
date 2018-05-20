// Program for copy contents of 1 to another using Command Line Arguments

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<iomanip.h>
#include<stdlib.h>
#include<ctype.h>

int main(int argc,char *argv[])
	{
	clrscr();
	if(argc!=3)
		{
		cout<<"argc="<<argc<<"\n";
		cout<<"Error in arguments\n";
		exit(1);
		}
	ifstream in;
	ofstream out;

	in.open(argv[1]);
	if(in.fail())
		{
		cout<<"Could not open source file"<<argv[1]<<"\n";
		exit(1);
		}

	out.open(argv[2]);
	if(out.fail())
		{
		cout<<"Could not open destination file"<<argv[2]<<"\n";
		exit(1);
		}

	while(!in.eof())
		{
		in.seekg(0);
		char ch=(char)in.get();
		char uch=toupper(ch);
		out.put(uch);
		in.seekg(1,ios::cur);
		}	
	in.close();
	out.close();
	cout<<"\n 1 File copied";
	getch();
	return 0;
	}
