#include<stdio.h>
main()
	{
	int a[20][20],i,j,r,c,sum=0;
	system("clear");
	printf("\nHow many Rows:");
	scanf("%d",&r);
	printf("\nHow many Columns:");
	scanf("%d",&c);
	printf("\nEnter the matrix elements:\n");
	for(i=0;i<r;i++)
		{
		for(j=0;j<c;j++)
			{
			printf("\nEnter [%d][%d] element:",i,j);
			scanf("%d",&a[i][j]);
			if(i==j)
				{
				sum=sum+a[i][j];
				}
			}
		}
	printf("\nThe Matrix elements are...\n");
	for(i=0;i<r;i++)
		{
		printf("|");
		for(j=0;j<c;j++)
			{
			printf(" %d ",a[i][j]);
			}
		printf("|\n");
		}
	printf("\nThe Sum Of Diagonal Elements is:%d\n",sum);
	}
