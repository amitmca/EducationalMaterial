#include<stdio.h>
#include "conio.h"

struct queue
	{
	int front,rear;
	int items[10];
	}q[10];

void addq(int n,int i)
	{
	q[i].items[++q[i].rear]=n;
	}
int delq(int i)
	{
	return(q[i].items[++q[i].front]);
	}
void initq()
	{
	int i;
	for(i=0;i<10;i++)
		{
		q[i].front=q[i].rear=-1;
		}
	}
int isempty(int i)
	{
	return(q[i].front==q[i].rear);
	}
void print(int x[],int n)
	{
	int i;
	for(i=0;i<n;i++)
		{
		printf(" %d ",x[i]);
		}
	}
void Radix(int a[],int n)
	{
	int count,num,j,k,i,b[20];
	for(i=0;i<n;i++)
		{
		b[i]=a[i];
		}
	num=a[0];
	for(count=0;num>0;count++)
		num=num/10;
	for(k=1;k<=count;k++)
		{
		for(i=0;i<n;i++)
			{
			for(j=1;j<k;j++)
				a[i]=a[i]/10;
			addq(b[i],a[i]%10);
			}
		j=0;
		for(i=0;i<10;i++)
			while(!isempty(i))
				b[j++]=delq(i);
		for(i=0;i<n;i++)
		a[i]=b[i];
		}
	print(b,n);
	}

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
	printf("\n\n\n");
	Radix(a,n);
	getch();
	}
