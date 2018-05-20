/*Program 5.2 :	Write a program to find the sum of the elements of an array.Use pointers.*/
#include<stdio.h>
void main()
{
	int a[30],n,*p,SUM;
	printf("\n Enter no. of elements :");
	scanf("%d",&n);
	/* loop for reading */
	for(p=a;p<a+n;p++)
	{
		printf("\nEnter next element :");
		scanf("%d",p);
	}
	for(p=a,SUM=0;p<a+n;p++)
		SUM+=*p;
	printf("\nSUM = %d",SUM);
}

/*
         *** OUTPUT ***
 Enter no. of elements :3

Enter next element :5

Enter next element :4

Enter next element :6

SUM = 15
*/
