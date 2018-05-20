#include<stdio.h>
#include<conio.h>
void fibo(int n);
void main(void)
	{
	int n;
	clrscr();
	printf("\nHow many terms:");
	scanf("%d",&n);
	fibo(n);
	getch();
	}
void fibo(int n)
	{
	static int a=0,b=1,t;
	if(n<2)
		{
		a=0;
		b=1;
		}
	else
		{
		fibo(n-1);
		t=b;
		b=a+b;
		a=t;
		}
	printf("%d\n",a);
	}