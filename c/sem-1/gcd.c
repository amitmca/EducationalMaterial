#include<stdio.h>
#include<conio.h>
int gcd(int x,int y);
void main(void)
	{
	int a,b;
	clrscr();
	printf("\nEnter two numbers:");
	scanf("%d%d",&a,&b);
	a=abs(a);
	b=abs(a);
	printf("\nGCD is:%d",gcd(a,b));
	getch();
	}
int gcd(int x,int y)
	{
	if(y==0)
		return x;
	else
		return (gcd(y,x%y));
	}