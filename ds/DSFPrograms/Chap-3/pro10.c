/*Program 3.10 :Write a program to find the sum of the first ten natural numbers using for-loop.*/
#include<stdio.h>
void main()
{
	int i,sum;
	sum=0;
	for(i=0;i<=10;i++)
		sum+=i;
	printf("\n%d",sum);
}
/*
           *** OUTPUT ***
55
*/
