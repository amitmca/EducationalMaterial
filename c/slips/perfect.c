//Program for chechk whether the no is perfect or not
//A number is perfect number if it's sum of factors is the number itself
//for e.g. 6=1+2+3 so 6 is a perfect number
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,sum=0,i;
	clrscr();
	printf("\nEnter The Number:");
	scanf("%d",&n);
	for(i=1;i<n;i++)
		{
		if(n%i==0)
			sum=sum+i;
		}
	if(sum==n)
		printf("\nThe Number is Perfect");
	else
		printf("\nThe Number is not Perfect");
	getch();
	return 0;
	}