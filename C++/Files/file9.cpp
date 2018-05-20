// Program for putback()

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<stdlib.h>



int main()
	{
	char ch;
	ifstream in("amit.txt");	
	clrscr();
	in.get(ch);
	cout<<ch<<endl;
	in.putback(ch);
	cout<<ch<<endl;
	in.get(ch);
	cout<<ch<<endl;
	in.close();
	getch();
	return 0;
	}
