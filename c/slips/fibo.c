//Program for Fibonacci's Series
//1	2	3	5	8	13	21	34
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,a=0,b=1,c,i;
	clrscr();
	printf("\nHow many numbers:");
	scanf("%d",&n);
	printf("\nThe Fibonacci's Series is....\n\n");
	for(i=1;i<=n;i++)
		{
		c=a+b;
		printf("%d\t",b);
		a=b;
		b=c;
		}
	getch();
	return 0;
	}