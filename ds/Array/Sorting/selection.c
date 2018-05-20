#include<stdio.h>
#include "conio.h"
void selection(int x[],int n);
void accept(int x[],int n);
void print(int x[],int n);
void main()
	{
	int n,a[10],i;
	clrscr();
	printf("\nHow many numbers:");
	scanf("%d",&n);
	accept(a,n);
	system("clear");
	/*printf("\nThe elements before sorting are:\n\n");
	print(a,n);*/
	printf("\n\n******* EXPLANATION  ********\n\n");
	selection(a,n);
	printf("\nThe elements after sorting are:\n\n");
	print(a,n);
	printf("\n");
	getch();
	}
void accept(int x[],int n)
	{
	int i;
	printf("\nEnter the elements:");
	for(i=0;i<n;i++)
		{
		scanf("%d",&x[i]);
		}
	}
void print(int x[],int n)
	{
	int i;
	for(i=0;i<n;i++)
		{
		printf(" %d",x[i]);
		}
	printf("\n\n");
	}
void selection(int x[],int n)
	{
	int indx,j,large,i;
	for(i=n-1;i>0;i--)
		{
		large=x[0];
		indx=0;
		for(j=1;j<=i;j++)
			if(x[j] > large)
				{
				large=x[j];
				indx=j;
				}
		x[indx]=x[i];
		x[i]=large;
		print(x,n);
		printf("\n");
		}
	}

