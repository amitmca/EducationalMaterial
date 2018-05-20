
/*Program 2.1 :	Write a program to print the 5th and 6th bit of a number. Use bitwise operator.*/
#include <stdio.h>
#include <conio.h>
void main ( )
{
		int x, mark1, mark2;
		printf("\n Enter a number :");
		scanf("%d", &x);
		mark1 = 0X0020;
		mark2 = 0X0040;
		if(x & mark1 ==0)
			printf("\n 5th bit = 0");
		else
			printf("\n 5th bit = 1");
		if(x & mark2 ==0)
			printf("\n 6th bit = 0");
		else
			printf("\n 6th bit = 1");
	}

/*
        *** OUTPUT ***
 Enter a number :54

 5th bit = 1
 6th bit = 1
*/
