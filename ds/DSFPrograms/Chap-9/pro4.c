/*Program 9.4 : Program for sorting an integer array using bubble sort.*/
#include<conio.h>
#include<stdio.h>
void bubble_sort(int[],int);
void main()
{
	int a[30],n,i;
	printf("\nEnter no of elements :");
	scanf("%d",&n);
	printf("\nEnter array elements :");
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	bubble_sort(a,n);
		printf("\nSorted array is :");
	for(i=0;i<n;i++)
		printf("%d\t",a[i]);
	getch();
}
void bubble_sort(int a[],int n)
{
	int i,j,temp;
	for(i=1;i<n;i++)
		for(j=0;j<n-i;j++)
			if(a[j]>a[j+1])
			{
			   temp=a[j];
			   a[j]=a[j+1];
			   a[j+1]=temp;
			}
}

/*
         *** OUTPUT ***

Enter no of elements :5

Enter array elements :57 89 64 56 77 333

Sorted array is :56     57      64      77      89

*/
