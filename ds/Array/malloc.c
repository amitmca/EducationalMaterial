#include<stdio.h>
#include "conio.h"
 main()
	{
	int *p,n,i;
	clrscr();
	printf("\nHow many elements:");
	scanf("%d",&n);
	p=(int *)malloc(sizeof(int));
	if(p==NULL)
		{
		printf("\nMemory was not allocated\n");
		exit(0);
		}
	printf("\nEnter the elements:\n");
	for(i=0;i<n;i++)
		scanf("%d",p+i);
	printf("\nThe elements are:\n");
	for(i=0;i<n;i++)
		printf("%d\n",*(p+i));
	getch();
	}
