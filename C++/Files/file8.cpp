// Program for peek()

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<stdlib.h>



int main()
	{
	char ch;
	ifstream in("amit.txt");	
	clrscr();
	_unlink("amit.txt");
	in.close();
	getch();
	return 0;
	}
