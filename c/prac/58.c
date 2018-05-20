#include<stdio.h>
#define ALLOCATE (int *)malloc(n)

main()
	{
	int *p,n,i,j,t;
	clrscr();
//	system("clear");
	printf("\nHow many numbers:");
	scanf("%d",&n);
	p=ALLOCATE;
	for(i=0;i<n;i++)
		{
		printf("\nEnter %d element:",i+1);
		scanf("%d",&p[i]);
		}

	for(i=0;i<n;i++)
		{
		for(j=i+1;j<=n;j++)
			{
			if(p[i]>p[j])
				{
				t=p[i];
				p[i]=p[j];
				p[j]=t;
				}
			}
		}
	printf("\nSorted elements are...\n");
	for(i=0;i<n;i++)
		{
		printf("\n%d\n",p[i]);
		}
	}
