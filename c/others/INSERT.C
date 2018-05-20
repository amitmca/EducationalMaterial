#include<stdio.h>
#include<conio.h>

void main()
	{
	int a[20],i,b[20],j,k,n;
	clrscr();
	printf("\n How many numbers:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		{
		scanf("%d",&a[i]);
		}
	j=n-1;
	k=0;
	for(i=0;i<n;i++)
		{	
		if(a[i]%2!=0)
			{
			b[j]=a[i];
			j--;
			}
		else
			{
			b[k]=a[i];
			k++;
			}
		}
	for(j=0;j<n;j++)
		{
		printf("\n%d",b[j]);
		}
	getch();
	}
