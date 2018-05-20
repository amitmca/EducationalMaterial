//Program for check whether the no is prime or not
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,i,prime=1;
//	clrscr();
	printf("\nEnter The Number:");
	scanf("%d",&n);
	for(i=2;i<n;i++)
		{
		if(n%i==0)
			{
			prime=0;
			break;
			}
		}
	if(prime==0)
		printf("\nThe Number is not prime");
	else
		printf("\nThe Number is prime");
	getch();
	return 0;
	}