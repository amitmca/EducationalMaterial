#include<stdio.h>
#include<conio.h>
int rec_fibo(int i,int n);
void main()
	{
	int n;
	clrscr();
	printf("\nHow many terms:");
	scanf("%d",&n);
	printf("\n0\n");
	rec_fibo(0,n);
	getch();
	}
int rec_fibo(int i,int n)
	{
	int a=0,b=1,c;
	if(i>9)
		{
		return(-1);
		}
	else
		{
	for(i=1;i<n;i++)
		{
		c=a+b;
		printf("\n%d\n",b);
		a=b;
		b=c;
		rec_fibo(i,0);
		}
		}
	}
