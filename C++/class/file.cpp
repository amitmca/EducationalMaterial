#include<iostream.h>
#include<fstream.h>
#include "conio.h"

int main()
	{
	ofstream outfile("amit");
	clrscr();
	char name[30];
	cout<<"\n Enter Name:";
	cin>>name;
	outfile<<name;
	outfile.close();
	ifstream infile("amit");
	infile>>name;
	cout<<name;
	getch();
	return 0;
	}
