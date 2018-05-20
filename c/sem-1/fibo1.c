#include<stdio.h>
#include<conio.h>
long int fibo(int n);
void main(void)
	{
	int n,i;
	clrscr();
	printf("\nHow many terms:");
	scanf("%d",&n);
	for(i=1;i<=n;i++)
		{
		printf("%d\n",fibo(i));
		}
	getch();
	}
long int fibo(int n)
	{
	if((n==1) || (n==2))
		return 1;
	else
		return fibo(n-1)+fibo(n-2);
	}