#include<stdio.h>
#include "conio.h"
void bubble(int x[],int n);
void print(int x[],int n);
main()
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
	int pass,j,s=0,temp,c=0;
	for(pass=1;pass<n;pass++)
		{
		s=0;
		for(j=0;j<n-pass;j++)
			{
			c++;
			if(x[j] > x[j+1])
				{
				s++;
				printf("\nInterchanging elements %d and %d",x[j],x[j+1]);
				temp=x[j];
				x[j]=x[j+1];
				x[j+1]=temp;
				s=1;
				}
			if(s==0)
				break;		
			}
		printf("\n\npass %d  = = = = >",pass);
		print(x,n);
		printf("\n");
		}
	printf("\ns=%d,c=%d\n",s,c);
	}

