//Program for Insertion Sort
#include<stdio.h>
#include<conio.h>
void inssort(int n);
void main(void)
	{
	int n;
	clrscr();
	printf("\nHow may numbers:");
	scanf("%d",&n);
	inssort(n);
	getch();
	}
void inssort(int n)
	{
	int i,k,key,a[20];
	printf("\nEnter the array elements:\n");
	for(i=0;i<n;i++)
		{
		printf("\nEnter %d element:",i+1);
		scanf("%d",&a[i]);
		}
	for(k=1;k<n;k++)
		{
		key=a[k];
		for(i=k-1;i>=0 && a[i]>key;i--)
			a[i+1]=a[i];
			a[i+1]=key;
		}
	printf("\nThe elements in sorted order are:\n");
	for(i=0;i<n;i++)
		{
		printf("\n%d\n",a[i]);
		}
	}
