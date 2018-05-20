#include<stdio.h>
#include<conio.h>
main()
	{
	int i,j,temp,temp1,mid,n;
	clrscr();
	printf("\nHow many lines:");
	scanf("%d",&n);
	mid=n/2;
	temp1=mid;
	temp=mid+1;
	for(i=1;i<=mid+1;i++)
		{
		for(j=1;j<=temp;j++)
		printf(" ");
		for(j=1;j<=i;j++)
		printf("*");
		printf("\n");
		temp--;
		}
	for(i=mid;i>=1;i--)
		{
		for(j=1;j<=temp1;j++)
		printf(" ");
		for(j=1;j<=i;j++)
		printf("*");
		printf("\n");
		temp1++;
		}
	getch();
	return 0;
	}
