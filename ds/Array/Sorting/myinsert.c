#include<stdio.h>
#include "conio.h"

int n,x[20],i,k,y;

void accept(int x[],int n)
	{
	printf("\nEnter the elements:");
	for(i=0;i<n;i++)
		{
		scanf("%d",&x[i]);
		}
	}
void print(int x[],int n)
	{
	printf("\n\n");
	for(i=0;i<n;i++)
		{
		printf(" %d ",x[i]);
		}
	printf("\n\n");
	}
void InsertionSort(int x[],int n)
	{
	for(k=1;k<n;k++)
		{
		y=x[k];
		for(i=k-1;i>=0 && y < x[i];i--)
			x[i+1]=x[i];
			x[i+1]=y;
		print(x,n);
		}

	}
void main()
	{
	clrscr();
	printf("\nHow many Elements:");
	scanf("%d",&n);
	accept(x,n);
	//print(x,n);
	InsertionSort(x,n);
	printf("\nAfter Sorting:");
	print(x,n);
	getch();
	}
