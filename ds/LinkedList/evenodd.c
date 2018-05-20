#include<conio.h>
#include<stdio.h>
#define MAX 20
void main()
{
	int a[MAX],i,j=0,n,k=0,even[10],odd[10],prime[10];
	int l=0,p=2;
	clrscr();
	printf("\n\nEnter the size of  Array:");
	scanf("%d",&n);
	printf("\n\nEnter the Array Element:");
	for(i=0;i<n;i++)
	{
		printf("\n\nEnter the [%d] Element:",i);
		scanf("%d",&a[i]);
	}
	for(i=0;i<n;i++)
	{
		if(a[i]%2==0)
		{
			even[j++]=a[i];
		}
		else
		{
			odd[k++]=a[i];
		}
		if(a[i]%p==0)
		{
			prime[l++]=a[i];
			if(p==n)
			{
				break;
			}
			p++;
		}
	}

	i=0;
		printf("\n\nThe even number array is\n");
	while(i<j)
	{
		printf("\n\n%d",even[i]);
		i++;

	}
		printf("\n\nThe odd number array is...\n");
		i=0;
			while(i<j)
	{
		printf("\n\n%d",odd[i]);
		i++;

	}

	printf("\n\nThe Prime number array is...\n");
			i=0;
			while(i<l)
	{
		printf("\n\n%d",prime[i]);
		i++;

	}

	getch();
}


