//Program for printing upper and lower triangular matrices
#include<stdio.h>
#include<conio.h>
main()
	{
	int c,r,i,j,a[20][20],t;
	clrscr();
	printf("\nHow many Rows:");
	scanf("%d",&r);
	printf("\nHow many Columns:");
	scanf("%d",&c);
	printf("\nEnter Matrix Entries:\n\n\n");
	for(i=0;i<r;i++)
		{
		for(j=0;j<c;j++)
			{
			scanf("%d",&a[i][j]);
			}
		}
	printf("\nThe Matrix Entries are....\n\n");
	for(i=0;i<r;i++)
		{
		printf("\n");
		for(j=0;j<c;j++)
			{
			printf("%d\t",a[i][j]);
			}
		printf("\n");
		}
	printf("\nThe Upper Triangular matrix entries are:\t");
	for(i=0;i<r;i++)
		{
		for(j=0;j<c;j++)
			{
			if(i<j)
				{
				printf("%d\t",a[i][j]);
				}
			else
				{
				continue;
				}
			}
		}
	printf("\n\n\nThe lower Triangular matrix entries are:\t");
	for(i=0;i<c;i++)
		{
		for(j=0;j<r;j++)
			{
			if(j<i)
				{
				printf("%d\t",a[i][j]);
				}
			else
				{
				continue;
				}
			}
		}

	getch();
	return 0;
	}