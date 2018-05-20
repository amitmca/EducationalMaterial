/*

1
1 2
1 2 3
1 2
1 
*/

#include<stdio.h>
#include "conio.h"
void pattern(int n)
	{
	int i,j;
	for(i=1;i<=n;i++)
		{
		for(j=1;j<=i;j++)
			{		
			printf("%d\t",j);
			}
		printf("\n");
		}
	for(i=n-1;i>=1;i--)
		{
		for(j=1;j<=i;j++)
			{		
			printf("%d\t",j);
			}
		printf("\n");
		}
	}
int main()
	{
	int n;
	clrscr();
	printf("\n Enter the Limit:");
	scanf("%d",&n);
	pattern(n);
	getch();
	}	
