#include<stdio.h>
#include "conio.h"
void ShellSort(int x[],int n);
void print(int x[],int n);
int main()
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
	ShellSort(a,n);
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
void ShellSort(int x[],int n)
	{
	int i,j,mid,temp,k=0;
	mid=(n+1)/2;
	for(i=0;i<n;i++)
		{
		for(j=0;j<mid;j++)
			{
			if(x[j]>x[mid+k+1])
				{
				temp=x[j];
				x[j]=x[mid+k+1];
				x[mid+k+1]=x[j];
				}
			k++;	
			}
		}
	}

