//Program to calculate factorial of a number
#include<stdio.h>
#include<conio.h>
main()
	{
	long int n;
	int i,f=1;
	clrscr();
	printf("\nEnter The Number:-");
	scanf("%d",&n);
	for(i=1;i<=n;i++)
		{
		f=f*i;
		}
	printf("\nFactorial Of %d is %d",n,f);
	getch();
	return 0;
	}