/*Program for Radix Sort*/
// Date :- 4-2-2008				Day:- Monday
#include<stdio.h>
#include"conio.h"
int x[20],i,n;

 

int maximum(int x[],int n)
	{
	int i,max;
	max=x[0];
	for(i=0;i<n;i++)
		{
		if(x[i]>max)
			{
			max=x[i];
			}
		}
	return(max);		
	}	

int digit(int m)
	{
	int count=0,rem;
	while(m>0)
		{
		rem=m%10;
		m=m/10;
		count++;
		}
	return(count);
	}

void accept(int x[],int n)
	{
	for(i=0;i<n;i++)
		{
		scanf("%d",&x[i]);
		}
	}
void print(int x[],int n)
	{
	for(i=0;i<n;i++)
		{
		printf("%d\n",x[i]);
		}
	}
void radixsort(int a[],int n,int d)
	{
	int i,k,l,j,k1=0,rem;
	int temp[20],dummay[20];
	for(i=0;i<n;i++)
	{
		dummay[i]=a[i];
	}
	for(l=1;l<=d;l++)
	{
		for(j=0;j<n;j++)
		{
			temp[j]=a[j]%10;
			a[j]=a[j]/10;
			printf("\nTemp[%d]=%d",j,temp[j]);
		}
		k=maximum(temp,n);
		printf("\n\nThe maximu is:%d",k);
		for(j=0;j<n;j++)
		{
			for(i=0;i<=k;i++)
			{

			if(temp[j]==i)
				{
				a[i]=dummay[j];
				printf("\n\narr[%d]=%d",i,a[i]);
				}
			}
		}
	}

	}
main()
	{
	int m,d;
	clrscr();
	printf("\nHow many numbers:");
	scanf("%d",&n);
	printf("\nEnter the elements:\n\n");
	accept(x,n);
	printf("\nThe elements before sorting are:\n\n");
	print(x,n);
	printf("\nThe elements after sorting are:\n\n");
	m=maximum(x,n);
	d=digit(m);
	radixsort(x,n,d);
	print(x,n);
	getch();
	}