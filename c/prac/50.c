#include<stdio.h>
#include<conio.h>
void main()
	{
	int a[10],b[10],c[20],i,j=0,l,n,m;
	clrscr();
	printf("\nHow many elements in first array:");
	scanf("%d",&m);
	printf("\nEnter the elements:");
	for(i=0;i<m;i++)
		{
		scanf("%d",&a[i]);
		}
	printf("\nHow many elements in second array:");
	scanf("%d",&n);
	printf("\nEnter the elements:");
	for(i=0;i<n;i++)
		{
		scanf("%d",&b[i]);
		}
	 for(i=0;i<m;i++)
		 {
		 c[i]=a[i];
		 }
	 for(;i<m+n;i++,j++)
		 {
		 c[i]=b[j];
		 }
	printf("\nElements before merging and sorting are...\n");
	 for(i=0;i<m+n;i++)
		 printf("\n%d",c[i]);

	 for(i=0;i<m+n;i++)
	 {
	 for(j=i+1;j<m+n;j++)
		{
		if(c[i]>c[j])
			{
			l=c[i];
			c[i]=c[j];
			c[j]=l;
			}
		}
	 }
	 printf("\nThe merged and sorted array elemensts are\n");
	 for(i=0;i<m+n;i++)
	 printf("\n%d\n",c[i]);
	 getch();
	}
