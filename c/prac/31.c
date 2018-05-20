//Program for transpose of matrix using only one variable
#include<stdio.h>
#include<conio.h>
main()
	{
	int i,j,a[20][20],r,c,t;
	clrscr();
	printf("\nHow many rows and columns:");
	scanf("%d%d",&r,&c);
	printf("\nEnter matrix elements:\n\n");
	for(i=0;i<r;i++)
		{
		for(j=0;j<c;j++)
			{
			scanf("%d",&a[i][j]);
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
			if(i<j)
				{
				t=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=t;
				}
			}
		printf("\n");
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
	getch();
	return 0;
	}