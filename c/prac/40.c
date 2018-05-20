//Program to display column total and find maximum sum

#include<stdio.h>
#include<conio.h>

void main()
	{
	int i,j,a[20][20],r,c,col[20],max;
	clrscr();
	printf("\nHow many rows and columns:");
	scanf("%d%d",&r,&c);
	for(i=0;i<r;i++)
		{
		col[i]=0;
		}
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
			col[j]=col[j]+a[i][j];
			}
		printf("\n");
		}
	printf("\n\nColumn wise sum of elements is:\n\n");
	for(i=0;i<c;i++)
		{
		printf("%d\t",col[i]);
		}
	max=col[1];
	for(i=1;i<=c;i++)
		{
		if(col[i]>max)
			{
			max=col[i];
			}
		}
	printf("\n\n Maximum is:%d",max);
	getch();
	}