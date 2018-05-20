//Program for Function with parameter and no return value
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,ans;
	void fact(int n);
	clrscr();
	printf("\nEnter the number:");
	scanf("%d",&n);
	fact(n);
	getch();
	return 0;
	}
void fact(int x)
	{
	int f=1,i;
	for(i=1;i<=x;i++)
		{
		f=f*i;
		}
	printf("\nThe Factorial is:%d",f);
	}