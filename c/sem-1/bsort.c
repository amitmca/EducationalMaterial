//Program for Bubble Sort
#include<stdio.h>
#include<conio.h>
void bubblesort(int n);
void main(void)
	{
	int n;
	clrscr();
	cprintf("\nHow may numbers:");
	scanf("%d",&n);
	bubblesort(n);
	getch();
	}
void bubblesort(int n)
	{
	int i,t,j,a[20];
	cprintf("\nEnter the array elements:\n");
	for(i=0;i<n;i++)
		{
		cprintf("\nEnter %d element:",i+1);
		scanf("%d",&a[i]);
		}
	for(i=0;i<n;i++)
		{
		for(j=i+1;j<n;j++)
			{
			if(a[i]>a[j])
				{
				t=a[i];
				a[i]=a[j];
				a[j]=t;
				}
			}
		}
	cprintf("\nThe elements in sorted order are:\n");
	for(i=0;i<n;i++)
		{
		cprintf("\n%d\n",a[i]);
		}
	}
