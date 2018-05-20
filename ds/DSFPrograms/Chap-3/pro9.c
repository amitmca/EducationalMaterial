/*Program 3.9 :	Write a program to find the sum of first 10 natural numbers using do-while loop.*/
#include<stdio.h>
void main()
{
	int i,sum;
	sum=0;
	i=1;
	do
	{
		sum=sum+i;
		i=i+1;
	}while(i<=10);
	printf("\n%d",sum);
}
/*
           *** OUTPUT ***
55
*/
