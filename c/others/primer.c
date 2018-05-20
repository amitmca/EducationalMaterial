//Program to print prime numbers in the given range
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,i,j,l,u;
	//clrscr();
	printf("\nEnter the lower limit:");
	scanf("%d",&l);
	printf("\nEnter the upper limit:");
	scanf("%d",&u);
	for(i=l;i<=u;i++)
	{
	for(j=2;j<i;j++)
		{
		if(i%j!=0)
			{
			printf("\n%d",i);
			break;
			}
		}
	}
	getch();
	return 0;
	}