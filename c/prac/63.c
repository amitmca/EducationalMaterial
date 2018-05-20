#include<stdio.h>
#include<conio.h>
void main()
{
	int a=97,A=65,n,i,j;
	clrscr();
	printf("\n\nEnter the line:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		for(j=0;j<=i;j++)
		{
				printf("%d%c  ",a++,A++);
		}
		printf("\n");
		a=97;A=65;
	}
	getch();
}

