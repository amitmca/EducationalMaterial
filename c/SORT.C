#include<stdio.h>
#include<conio.h>
void main()
	{
	int a[20][20],i,j,r,c,temp,k;
	clrscr();
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
	for(i=0;i<r;i++)
		{
		for(j=0;j<c;j++)
			{
			for(k=1;k<c;k++)
				{
				if(a[i][j] > a[i][k])
					{
					temp=a[i][j];
					a[i][j]=a[i][k];
					a[i][k]=temp;
					}
				}
			}
		}
	printf("\nThe Sorted Matrix elements are...\n");
	for(i=0;i<r;i++)
		{
		printf("|");
		for(j=0;j<c;j++)
			{
			printf(" %d ",a[i][j]);
			}
		printf("|\n");
		}
	getch();
	}
