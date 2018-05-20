//Program for swapping two variables without using third variable
#include<stdio.h>
#include<conio.h>
main()
	{
	int a,b,t;
	clrscr();
	printf("\nEnter the value of a:");
	scanf("%d",&a);
	printf("\nEnter the value of b:");
	scanf("%d",&b);
	printf("\nValues of a and b before swapping:a=%d b=%d\n",a,b);
	a=a+b;
	b=a-b;
	a=a-b;
	printf("\nValues of a and b after swapping:a=%d b=%d\n",a,b);
	getch();
	return 0;
	}