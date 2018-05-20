#include<stdio.h>
#include<conio.h>
void main()
{
	int n,i,j,temp,k;
	clrscr();
	printf("\n\nEnter the line:");
	scanf("%d",&n);
	temp=n;
	for(i=1;i<=n;i++)
	{     k=i;
		for(j=1;j<=temp;j++)
		{
		printf("%d\t",k=k+j);
		}
		temp--;
	printf("\n");
	}
	getch();
}
