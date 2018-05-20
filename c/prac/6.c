//Program using recursion and without using recursion
#include<stdio.h>
#include<conio.h>
#include "facth.h"
#include "facth1.h"
main()
	{
	int n,o1,o2;
	clrscr();
	printf("\nEnter the number here:");
	scanf("%d",&n);
	o1=non_rec(n);
	printf("\nFactorial without using recursion is:%d\n",o1);
	o2=rec(n);
	printf("\nFactorial witht using recursion is:%d\n",o2);
	getch();
	return 0;
	}
