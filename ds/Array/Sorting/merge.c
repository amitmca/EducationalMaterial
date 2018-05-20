#include<stdio.h>
#include "conio.h"
void mergesort(int x[],int y[],int m,int n);
void accept(int x[],int n);
void print(int x[],int n);

main()
	{
	int m,n,a[10],i,b[10],k,c[20];
	clrscr();
	printf("\nHow many numbers in first array :");
	scanf("%d",&m);
	accept(a,m);
	print(a,m);
	printf("\nHow many numbers in second array :");
	scanf("%d",&n);
	accept(b,n);
	print(b,n);
	mergesort(a,b,m,n);
	printf("\n");
	getch();
	}
void accept(int x[],int n)
	{
	int i;
	printf("\nEnter the elements:====>\t");
	for(i=0;i<n;i++)
		{
		scanf("%d",&x[i]);
		}
	}
void print(int x[],int n)
	{
	int i;
	printf("\n\tThe elements are===>:");	
	for(i=0;i<n;i++)
		{	
		printf(" %d ",x[i]);
		}
	printf("\n");
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
		}
	}
void mergesort(int x[],int y[],int m,int n)
	{
	int k,c[20],j=0,t=m+n,i,temp;
	for(k=0;k<m;k++)
		{
		c[k]=x[k];
		}
	for(;k<t;k++,j++)
		{
		c[k]=y[j];
		}
	printf("\nThe Elements after Merging are....\n");
	print(c,t);
	for(i=0;i<t;i++)
		{
		for(j=0;j<t;j++)
			{
			if(c[i]<c[j])
				{
				temp=c[i];
				c[i]=c[j];
				c[j]=temp;
				}
			}
		}
	printf("\nThe elements after sorting are:\n\n");
	print(c,t);		
	}
