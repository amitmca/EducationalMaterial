#include<iostream.h>
#include<fstream.h>
#include "conio.h"

int main()
	{
	ofstream fout;
	clrscr();
	fout.open("fname");
	fout<<"Amit\n";
	fout<<"Ajit\n";
	fout.close();
	fout.open("surname");
	fout<<"Bhalerao\n";
	fout<<"Kulkarni\n";
	fout.close();
	const int N=80;
	char line[N];
	ifstream fin;
	fin.open("fname");
	while(fin)
		{
		fin.getline(line,N);
		cout<<line;
		}
	fin.close();
	fin.open("surname");
	while(fin)
		{
		fin.getline(line,N);
		cout<<line;
		}
	fin.close();
	getch();
	return 0;
	}
