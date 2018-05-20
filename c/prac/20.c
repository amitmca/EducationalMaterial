#include<stdio.h>
#include<conio.h>
int sum(int x);
int rev(int x);
main()
	{
	int n,ans1,ans2;
	clrscr();
	printf("\nEnter the number:");
	scanf("%d",&n);
	ans1=sum(n);
	ans2=rev(n);
	printf("\nSum of Digits is:%d\n",ans1);
	printf("\nReverse is:%d\n",ans2);
	getch();
	return 0;
	}
int sum(int x)
	{
	int sum=0,r;
	while(x>0)
		{
		r=x%10;
		sum=sum+r;
		x=x/10;
		}
	return sum;
	}
int rev(int x)
	{
	int r=0,rev=0;
	while(x>0)
		{
		rev=r*10;
		r=rev+x%10;
		x=x/10;
		}
	return r;
	}