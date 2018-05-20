// Program for getline()

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<stdlib.h>


int main()
	{
	static char arr[10];
	ifstream in("amit.txt");	
	clrscr();
	in.getline(arr,10,'o');
	cout<<arr<<endl;
	in.close();
	getch();
	return 0;
	}
