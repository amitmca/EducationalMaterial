#include<stdio.h>
#include<conio.h>
void main()
		{
		int i,n,a[20],loc,j=0,b[20];
		clrscr();
		printf("\nHow many elements:");
		scanf("%d",&n);
		printf("\nEnter the elements:");
		for(i=0;i<n;i++)
			{
			scanf("%d",&a[i]);
			}
		printf("\nThe elements are:\n");
		for(i=0;i<n;i++)
			{
			printf("%d\n",a[i]);
			}
		printf("\nEnter the location:");
		scanf("%d",&loc);
		for(i=loc;i>=0;i--)
			{
			if(a[loc] > a[i-1])
				{
				j++;
				}
			}
		printf("\nNumber Of Elements:%d\n",j);
		getch();
		}
