#include<stdio.h>
#include "conio.h"
void bubble(int x[],int n);
void print(int x[],int n);
void main()
	{
	int n,a[10],i;
	clrscr();
	printf("\nHow many numbers:");
	scanf("%d",&n);
	printf("\nEnter the elements:");
	for(i=0;i<n;i++)
		{
		scanf("%d",&a[i]);
		}
	clrscr();
	printf("\nThe elements before sorting are:\n");
	print(a,n);
	printf("\n\n  ******* Explanation ******* ");
	bubble(a,n);
	printf("\nThe elements after sorting are:\n\n");
	print(a,n);
	printf("\n");
	getch();
	}
void print(int x[],int n)
	{
	int i;
	for(i=0;i<n;i++)
		{
		printf(" %d ",x[i]);
		}
	}
void bubble(int x[],int n)
	{
	int pass,j,switched=1,temp;
	for(pass=0;pass<n-1 && switched==1;pass++)
		{
		switched=0;
		for(j=0;j<n-pass-1;j++)
			{
			if(x[j] > x[j+1])
				{
				switched=1;
				printf("\nInterchanging elements %d and %d",x[j],x[j+1]);
				temp=x[j];
				x[j]=x[j+1];
				x[j+1]=temp;
				}	
			}
		printf("\n\npass %d  = = = = >",pass);
		print(x,n);
		printf("\n");
		}
	printf("\n");
	}

