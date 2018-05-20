//Program for Function with parameter and return value
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,ans;
	int fact(int n);
	clrscr();
	printf("\nEnter the number:");
	scanf("%d",&n);
	ans=fact(n);
	printf("\nThe Factorial is:%d",ans);
	getch();
	return 0;
	}
int fact(int x)
	{
	int f=1,i;
	for(i=1;i<=x;i++)
		{
		f=f*i;
		}
	return(f);
	}