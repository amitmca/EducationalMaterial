// Program for convert characters from 1 file to another in uppercase using Command Line Arguments

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<iomanip.h>
#include<stdlib.h>

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
		char ch=(char)in.get();
		char uch=tolower(ch);
		out.put(uch);
		}	
	in.close();
	out.close();
	cout<<"\n Operation Successful";
	getch();
	return 0;
	}
