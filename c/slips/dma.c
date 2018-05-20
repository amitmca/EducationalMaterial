//Sorting elements,finding maximum,minimum of array using malloc function
#include<stdio.h>
#include<conio.h>
#include<alloc.h>
main()
	{
	int n,*p,i,t,j,max,min;
	clrscr();
	printf("\nHow many elements ?:");
	scanf("%d",&n);
	p=(int *)malloc(n*sizeof(int));
	if(p==NULL)
		{
		printf("\nMemory was not allocated\n");
		exit(0);
		}
	printf("\nEnter the elements:\n");
	for(i=0;i<n;i++)
		{
		scanf("%d",p+i);
		}
	printf("\nYou have entered :\n");
	for(i=0;i<n;i++)
		{
		printf("\n%d\n",p[i]);
		}
	for(i=0;i<n;i++)
		{
		for(j=i+1;j<n;j++)
			{
			if(p[i]>p[j])
				{
				t=p[i];
				p[i]=p[j];
				p[j]=t;
				}
			}
		}
	min=p[0];
	for(i=1;i<=n;i++)
		{
		if(min<p[i])
			{
			printf("\n\nMinimum element is:%d\n",min);
			break;
			}
		else
			{
			min=p[i];
			}
		}
	printf("\nAfter Sorting:\n");
	for(i=0;i<n;i++)
		{
		printf("\n%d\n",p[i]);
		}
	max=p[0];
	for(i=1;i<=n;i++)
		{
		if(max>p[i])
			{
			printf("\n\nMaximum element is:%d\n",max);
//			break;
			}
		else
			{
			max=p[i];
			}
		}
	free(p);
	getch();
	return 0;
	}