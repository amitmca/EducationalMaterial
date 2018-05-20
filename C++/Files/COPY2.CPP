#include<iostream.h>
#include<conio.h>
#include<fstream.h>
#include<stdlib.h>

int main(int ac,char *av[])
	{
	ofstream outfile;
	ifstream infile;
	char ch;
	clrscr();
	infile.open(av[1]);
	outfile.open(av[2]);
	if(ac!=3)
		{
		cout<<"\nPlease supply 3 cmd line arguments\n";
		exit(1);
		}
	if(infile.fail())
		{
		cout<<"\n Unable to open source file\n";
		exit(1);
		}
	if(outfile.fail())
		{
		cout<<"\n Unable to open destination file\n";
		exit(1);
		}
	while(!infile.eof())
		{
		infile.seekg(0);
		ch=(char)infile.get();
		outfile.put(ch);
		infile.seekg(1,ios::cur);
		}
	infile.close();
	outfile.close();
	getch();
	return 0;
	}
