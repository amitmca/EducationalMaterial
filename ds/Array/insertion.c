/*Program for Insertion Sort*/
// Date :- 4-2-2008				Day:- Monday
#include<stdio.h>
#include"conio.h"
int x[20],i,n;
void accept(int x[],int n);
void inssort(int x[],int n);
void print(int x[],int n);
 main()
	{
	clrscr();
	printf("\nHow many numbers:");
	scanf("%d",&n);
	printf("\nEnter the elements:\n\n");
	accept(x,n);
	printf("\nThe elements before sorting are:\n\n");
	print(x,n);
	printf("\nThe elements after sorting are:\n\n");
	inssort(x,n);
	print(x,n);
	getch();
	}
void accept(int x[],int n)
	{
	for(i=1;i<=n;i++)
		{
		scanf("%d",&x[i]);
		}
	}
void print(int x[],int n)
	{
	for(i=1;i<=n;i++)
		{
		printf("%d\n",x[i]);
		}
	}
void inssort(int x[],int n)
	{
	int temp,j,k,i;
	for(i=1;i<=n;i++)
		{
		for(j=0;j<i;j++)
			{
			if(x[j] > x[i])
				{
				temp=x[j];
				x[j]=x[i];
				for(k=i;k>j;k--)
					{
					x[k]=x[k-1];
					}
					x[k+1]=temp;
				}
			}
		}
	}
