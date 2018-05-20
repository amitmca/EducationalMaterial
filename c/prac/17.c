//Program to print Fibonacci's Series
#include<stdio.h>
#define ALLOCATE (int *)malloc(n)
main()
	{
	int n,a=0,b=1,c,i,*p;
	system("clear");
	printf("\n How many elements do you want in the series:");
	scanf("%d",&n);
	p=ALLOCATE;
	printf("\n Memory is allocated now.....\n");
	printf("\n\t%d\t\n",a);
	for(i=1;i<=n;i++)
		{
		c=a+b;
		printf("\t%d\t\n",b);
		a=b;
		b=c;
		}
	free(p);
	printf("\n Memory is freed now.....\n\n");
	}
