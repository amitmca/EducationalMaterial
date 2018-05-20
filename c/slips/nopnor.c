//Program for Function with no parameter and no return value
#include<stdio.h>
#include<conio.h>
main()
	{
	void fact();
	clrscr();
	fact();
	getch();
	return 0;
	}
void fact()
	{
	int f=1,i,n;
	printf("\nEnter the number:");
	scanf("%d",&n);
	for(i=1;i<=n;i++)
		{
		f=f*i;
		}
	printf("\nThe Factorial is:%d",f);
	}