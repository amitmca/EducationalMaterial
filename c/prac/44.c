#include<stdio.h>
main()
	{
	int a[5][5],b[5][5],i,j,f=0,s=0;
	system("clear");
	printf("\nEnter the matrix 1 elements:\n");
	for(i=0;i<5;i++)
		{
		for(j=0;j<5;j++)
			{
			printf("\nEnter [%d][%d] element:",i,j);
			scanf("%d",&a[i][j]);
			if(a[i][j]==0)
				{			
				f++;
				}
			}
		}
	printf("\nThe Matrix 1 elements are...\n");
	for(i=0;i<5;i++)
		{
		printf("|");
		for(j=0;j<5;j++)
			{
			printf(" %d ",a[i][j]);
			}
		printf("|\n");
		}
	printf("\nEnter the matrix 2 elements:\n");
	for(i=0;i<5;i++)
		{
		for(j=0;j<5;j++)
			{
			printf("\nEnter [%d][%d] element:",i,j);
			scanf("%d",&b[i][j]);
			if(b[i][j]==0)
				{			
				s++;
				}
			}
		}
	printf("\nThe Matrix 2 elements are...\n");
	for(i=0;i<5;i++)
		{
		printf("|");
		for(j=0;j<5;j++)
			{
			printf(" %d ",b[i][j]);
			}
		printf("|\n");
		}
	printf("\nZero's in First Matrix:%d\n",f);
	printf("\nZero's in Second Matrix:%d\n",s);
	printf("\nThe Matrix with less number Zeros is:\n\n");
	if(f<s)
		{
		for(i=0;i<5;i++)
			{
			printf("|");
			for(j=0;j<5;j++)
				{
				printf(" %d ",a[i][j]);
				}
			printf("|\n");
			}
		}
	else
		{
		for(i=0;i<5;i++)
			{
			printf("|");
			for(j=0;j<5;j++)
				{
				printf(" %d ",b[i][j]);
				}
			printf("|\n");
			}
		}	
	}
