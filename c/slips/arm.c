//Program to check whether entered number is armstrong number or not
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,sum=0,r=0,t;
//	clrscr();
	printf("\nEnter the number to check:-");
	scanf("%d",&n);
	t=n;
	while(n>0)
		{
		r=n%10;
		sum=sum+r*r*r;
		n=n/10;
		}
	if(sum==t)
		printf("\nNumber is armstrong");
	else
		printf("\nNumber is not a armstrong");
	getch();
	return 0;
	}
