#include<stdio.h>
#include "conio.h"
#define CHAR 1			// CHAR=1
#define INT CHAR*2		// INT=2
#define FLOAT INT*INT		// FLOAT=4
void main()
	{
	int x=FLOAT,y=x*INT,z;	// x=4,y=8
	clrscr();
	printf("x=%d\ty=%d\n",x,y);
	z=x*y/FLOAT*FLOAT;	// 32/16
	printf("z=%d\n",z);
	getch();
	}

// Output =>512
