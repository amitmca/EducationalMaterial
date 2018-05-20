//Program to insert and delete elements in an array
#include<stdio.h>
#include<conio.h>
main()
	{
	int n,i,a[20],value,j;
	clrscr();
	printf("\nEnter How many numbers do you want in the array:");
	scanf("%d",&n);
	printf("\nEnter Array Elements:\n\n");
	for(i=0;i<n;i++)
		{
		scanf("%d",&a[i]);
		}
	printf("\nThe Array Elements are:\n\n\n");
	for(i=0;i<n;i++)
		{
		printf("\t%d",a[i]);
		}
	printf("\n\n\nEnter the index :");
	scanf("%d",&j);
	printf("\n\n\nEnter the value :");
	scanf("%d",&value);
	for(i=0;i<j-1;i++)
		{
		a[j]=value;
		}
	printf("\n");
	for(i=0;i<n+1;i++)
		{
		printf("%d\t",a[i]);
		}
	getch();
	return 0;
	}