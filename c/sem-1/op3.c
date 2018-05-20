#include<stdio.h>
#include "conio.h"
const int * sample();
const int a=124;
void main()
	{
	int x;
	const int * sample();
	char *p;
	clrscr();
	p=sample();
	printf("%d",*p);	
	getch();
	}
const int * sample()
	{
	return(&a);
	}

// Output =>124
