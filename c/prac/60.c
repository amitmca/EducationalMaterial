//Program to display row and column total and grand total
#include<stdio.h>
#include<conio.h>
main()
	{
	int i,j,a[20][20],r,c,row[20],col[20],gt=0;
	clrscr();
	printf("\nHow many rows and columns:");
	scanf("%d%d",&r,&c);
	for(i=0;i<r;i++)
		{
		row[i]=0;
		col[i]=0;
		}
	printf("\nEnter matrix elements:\n\n");
	for(i=0;i<r;i++)
		{
		for(j=0;j<c;j++)
			{
			scanf("%d",&a[i][j]);
			gt=gt+a[i][j];
			}
		}
	printf("\nMatrix elements are:\n\n");
	for(i=0;i<r;i++)
		{
		for(j=0;j<c;j++)
			{
			printf("%d\t",a[i][j]);
			}
		printf("\n");
		}
	for(i=0;i<r;i++)
		{
		for(j=0;j<c;j++)
			{
			row[i]=row[i]+a[i][j];
			col[j]=col[j]+a[i][j];
			}
		printf("\n");
		}
	printf("\nRow wise sum of elements is:\n\n");
	for(i=0;i<r;i++)
		{
		printf("%d\t",row[i]);
		}
	printf("\n\nColumn wise sum of elements is:\n\n");
	for(i=0;i<c;i++)
		{
		printf("%d\t",col[i]);
		}
	printf("\n\nGrand Total:%d",gt);
	getch();
	return 0;
	}