//Program for call by reference
#include<stdio.h>
#include<conio.h>
main()
	{
	int n;
	void fact(int *n);
	clrscr();
	fact(&n);
	getch();
	return 0;
	}
void fact(int *x)
	{
	int f=1,i,a;
	x=&a;
	printf("\nEnter the number:");
	scanf("%d",&a);
	for(i=1;i<=a;i++)
		{
		f=f*i;
		}
	printf("\nThe Factorial is:%d",f);
	}