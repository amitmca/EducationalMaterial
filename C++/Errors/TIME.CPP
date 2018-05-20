#include<time.h>
#include<iostream.h>
#include<string.h>
#include<conio.h>
#include<stdio.h>

class time12
	{
	struct tm *newtime=localtime(&ltime);
	time_t ltime=time(&ltime);
	cout<<"The Date and Time is:"<<asctime(&newtime);
	};

int main()
	{
	clrscr();
	getch();
	return 0;
	}