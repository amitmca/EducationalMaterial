//Program for addition of digits of a number
//e.g. 789=>24=>6
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,sum=0,r=0,sum1=0,digit=0;
	clrscr();
	printf("\nEnter the Number :-");
	scanf("%d",&n);
	while(n>0)
		{
		r=n%10;
		sum=sum+r;
		n=n/10;
		}
	while(sum > 0)
		{
		digit=sum%10;
		sum1=sum1+digit;
		sum=sum/10;
		}
	printf("\nSum is:%d",sum1);
	getch();
	return 0;
	}
