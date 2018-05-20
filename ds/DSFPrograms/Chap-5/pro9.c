/*Program 5.9 : Write a program that displays sum of the elements passed as command line arguments.*/
#include<stdio.h>
#include<stdlib.h>
void main(int argc,char* argv[])
{
	int i;
	float result;
	result=0.00;
	for(i=1;i<argc;i++)
	result=result+atoi(argv[i]);
	/* Function atoi(),converts a number
	   represented as a string to number */
	   printf("\nResult = %f",result);
}
/*
              *** OUTPUT ***
 15.3 9.4 3.8
Result = 28.5
*/
