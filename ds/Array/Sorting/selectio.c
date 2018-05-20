#include<stdio.h>
#include "conio.h"

int x[20],n,i,j;

void Read(int x[],int n)	// Read elements of array
	{
	printf("\nEnter the elements:\n\n");
	for(i=0;i<n;i++)
		{
		printf("\nEnter [%d] element:",i);
		scanf("%d",&x[i]);
		}
	}
void Print(int x[],int n)	// Print elements of array
	{
	printf("\nThe elements are:\n\n");
	for(i=0;i<n;i++)
		{
		printf(" %d\t",x[i]);
		}
	printf("\n\n");
	}
void SelectionSort(int x[],int n)   // Sorting using Selection Sort
	{
	int t;
	for(i=0;i<n;i++)
		{
		for(j=i;j<n;j++)
			{
			if(x[i] > x[j])
				{
				t=x[i];
				x[i]=x[j];
				x[j]=t;
				}
			}
		}
	}
void main()
	{
	clrscr();
	printf("\nHow many elements:");
	scanf("%d",&n);
	Read(x,n);
	printf("\n Before Sorting:\n\n\n");
	Print(x,n);
	SelectionSort(x,n);
	printf("\nPress enter key to get result.......\n\n");
	getch();
	printf("\n After Sorting:\n\n\n");
	Print(x,n);
	printf("\nPress any key to exit.......");
	getch();
	}
