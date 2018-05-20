#include<stdio.h>
#include "conio.h"

int n,x[20],i,j,temp,swap=1,pass,indx,large,k,y;

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
void BubbleSort(int x[],int n)
	{
	for(pass=0;pass<n-1 && swap==1;pass++)
		{
		swap=0;
		for(j=0;j<n-pass-1;j++)
			{
			if(x[j] > x[j+1])
				{
				swap=1;
				temp=x[j];
				x[j]=x[j+1];
				x[j+1]=temp;
				}
			}
		}
	}
void SelectionSort(int x[],int n)
	{
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
		}
	}
void InsertionSort(int x[],int n)
	{
	for(k=1;k<n;k++)
		{
		y=x[k];
		for(i=k-1;i>=0 && y < x[i];i--)
			x[i+1]=x[i];
			x[i+1]=y;
		}

	}
void main()
	{
	clrscr();
	printf("\nHow many Elements:");
	scanf("%d",&n);
	accept(x,n);
	print(x,n);
	printf("\nUsing Bubble Sort:\n\n");
	BubbleSort(x,n);
	print(x,n);
	printf("\nUsing Selection Sort:\n\n");
	SelectionSort(x,n);
	print(x,n);
	printf("\nUsing Insertion Sort:\n\n");
	InsertionSort(x,n);
	print(x,n);
	getch();
	}