// Program for ignore()

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<stdlib.h>


int main()
	{
	ifstream in("amit.txt");	
	static char arr[10];
	clrscr();
	in.ignore(6,'l');
	in.read(arr,10);
	cout<<arr<<endl;
	in.close();
	getch();
	return 0;
	}
