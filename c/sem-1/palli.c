//Program for Pallindrome Number
#include<stdio.h>
#include<conio.h>
void pallindrome(int n);
void main()
	{
	int n;
	clrscr();
	printf("\nPlease enter the number:");
	scanf("%d",&n);
	pallindrome(n);
	getch();
	}
	void pallindrome(int n)
	{
	int r=0,rev=0,t;
	t=n;
	while(n>0)
		{
		rev=r*10;
		r=rev+n%10;
		n=n/10;
		}
	if(r==t)
		printf("\nThe Number is Pallindrome\n");
	else
		printf("\nThe Number is not Pallindrome\n");
	}
