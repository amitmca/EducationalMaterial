#include<stdio.h>
#include "conio.h"
void bsort(int a[],int n)
	{
	int i,j,t;
	for(i=0;i<n-1;i++)
		{
		for(j=1;j<i-1;j++)
			{
			if(a[i] < a[j])
				{
				t=a[i];
				a[i]=a[j];
				a[j]=t;
				}
			}
		}
	}
main()
	{
	int a[20],i,n;
	clrscr();
	printf("\nHow many values:");
	scanf("%d",&n);
	printf("\nEnter the values one by one:\n");
	for(i=0;i<n;i++)
		{
		scanf("%d",&a[i]);
		}
	printf("\nValues Before Sorting are.......\n");
	for(i=0;i<n;i++)
		{
		printf("\n%d\n",a[i]);
		}
	bsort(a,n);
	printf("\nValues After Sorting are.......\n");
	for(i=0;i<n;i++)
		{
		printf("\n%d\n",a[i]);
		}
	getch();
	}
