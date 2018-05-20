//Program for Multiplication of matrices
#include<stdio.h>
#include<conio.h>
main()
	{
	int c1,r1,c2,r2,i,j,a[20][20],b[20][20],c[20][20],k;
	clrscr();
	printf("\nHow many Rows and Colums for first matrix:");
	scanf("%d%d",&r1,&c1);
	printf("\nHow many Rows and Colums for second matrix:");
	scanf("%d%d",&r2,&c2);
	printf("\nEnter entries for First Matrix:\n\n");
	for(i=0;i<r1;i++)
		{
		for(j=0;j<c1;j++)
			{
			scanf("%d",&a[i][j]);
			}
		}
	printf("\nEnter entries for Second Matrix:\n\n");
	for(i=0;i<r2;i++)
		{
		for(j=0;j<c2;j++)
			{
			scanf("%d",&b[i][j]);
			}
		}
	printf("\nThe entries for First Matrix are....\n\n");
	for(i=0;i<r1;i++)
		{
		printf("\n");
		for(j=0;j<c1;j++)
			{
			printf("%d\t",a[i][j]);
			}
		printf("\n");
		}
	printf("\nThe entries for Second Matrix are....\n\n");
	for(i=0;i<r2;i++)
		{
		printf("\n");
		for(j=0;j<c2;j++)
			{
			printf("%d\t",b[i][j]);
			}
		printf("\n");
		}
	for(i=0;i<r1;i++)	//row
		{
		for(j=0;j<c2;j++)	//column
			{
			c[i][j]=0;
			for(k=0;k<c1;k++)
				{
				c[i][j]=c[i][j]+(a[i][k]*b[k][j]);
				}
			}
		}
	printf("\nThe entries for Resultant Matrix are....\n\n");
	for(i=0;i<r1;i++)
		{
		printf("\n");
		for(j=0;j<c1;j++)
			{
			printf("%d\t",c[i][j]);
			}
		printf("\n");
		}
	getch();
	return 0;
	}