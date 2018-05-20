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
int BinSearch(int x[],int n,int ele)
	{
	int top,bottom,mid;
	top=1;
	bottom=n-1;
	while(top<=bottom)
		{
		mid=(top+bottom)/2;
		if(x[mid]==ele)
			{
			return(mid+1);
			}
		else
			{
			if(ele < x[mid])
				bottom=mid-1;
			else
				top=mid+1;
			}
		}
	return -1;
	}
main()
	{
	int ans;
	clrscr();
	printf("\nHow many elements ? :");
	scanf("%d",&n);
	Read(x,n);
	Display(x,n);
	printf("\nEnter the Number to Search:");
	scanf("%d",&ele);
	ans=BinSearch(x,n,ele);
	if(ans!=-1)
		printf("\nFinded\n");
	else
		printf("\nNot Finded\n");
	getch();
	}
