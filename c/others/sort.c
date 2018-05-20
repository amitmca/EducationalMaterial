#include<stdio.h>
main(int argc,char *argv[])
	{
	int i,n[10],c,j,t,s;
//	system("clear");
	c=0;
	for(i=1;i<argc;i++)
		{
		n[i]=atoi(argv[i]);
		c++;
		}
	for(i=1;i<=c;i++)
		{
		for(j=i+1;j<=c;j++)
			{
			if(n[i]<n[j])
				{
				t=n[i];
				n[i]=n[j];
				n[j]=t;
				}
			}
		}
	printf("\nThe Sorted elements are:\n\n");
	printf("\nIndex \t\tValue\n");
	for(i=1;i<=c;i++)
		{
		printf("\n%d\t\t%d\n",i,n[i]);
		}
	printf("\nEnter the element to search:");
	scanf("%d",&s);
	for(i=1;i<=c;i++)
		{
		if(s==n[i])
			{
			printf("\nThe element %d is found at %d position\n",s,i);
			}
		}

	}

