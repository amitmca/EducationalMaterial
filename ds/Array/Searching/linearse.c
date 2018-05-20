#include<stdio.h>
#include "conio.h"

int x[20],n,i,ele,temp,j,f=0;

void Read(int x[],int n)
	{
	printf("\nEnter the array elements:");
	for(i=0;i<n;i++)
		{
		scanf("%d",&x[i]);
		}
	}
void Display(int x[],int n)
	{
	printf("\nThe array elements are:\n\n");
	for(i=0;i<n;i++)
		{
		printf("%d\n",x[i]);
		}
	}
void ExchangeSort(int x[],int n)
	{
	for(i=0;i<n;i++)
		{
		for(j=0;j<n;j++)
			{
			if(x[i]<x[j])
				{
				temp=x[i];
				x[i]=x[j];
				x[j]=temp;
				}
			}
		}
	}
void SortedSearch(int x[],int n,int ele)
	{
	int f=0;
	for(i=0;i<n;i++)
		{
		if(x[i]>ele)
			break;
		else
			{
			if(x[i]<=ele)
				if(x[i]==ele)
					f=f+1;
			}
		}
	if(f>0)
		{
		printf("\nThe Number %d is Finded\n",ele);
		}
	else
		{
		printf("\nThe Number %d is not Finded\n",ele);
		}
	}
void UnsortedSearch(int x[],int n,int ele)
	{
	for(i=0;i<n;i++)
		{
		if(x[i]==ele)
			{
			printf("\nThe Number %d is  Finded\n",ele);
			break;
			}
		else
			{
			printf("\nThe Number %d is not  Finded\n",ele);
			break;
			}
		}
	}
main()
	{
	clrscr();
	printf("\nHow many elements ? :");
	scanf("%d",&n);
	Read(x,n);
	Display(x,n);
	printf("\nEnter the Number to Search:");
	scanf("%d",&ele);
	UnsortedSearch(x,n,ele);
	ExchangeSort(x,n);
	SortedSearch(x,n,ele);
	getch();
	}

