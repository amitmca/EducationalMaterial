//Program for Transpose of matrices
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
		}
	printf("\nThe Transpose Matrix Entries are....\n\n");
	for(i=0;i<c;i++)
		{
		printf("\n");
		for(j=0;j<r;j++)
			{
			printf("%d\t",a[i][j]);
			}
		printf("\n");
		}

	getch();
	return 0;
	}