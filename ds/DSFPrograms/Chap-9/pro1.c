/*Program 9.1 : A sample program for insertion sort (for an array of integers)*/
#include<conio.h>
#include<stdio.h>
void insertion_sort(int[],int);
void main()
{
	int a[50],n,i;
	printf("\nEnter no of elements :");
	scanf("%d",&n);
	printf("\nEnter array elements :");
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
		insertion_sort(a,n);
                  printf("\nSorted array is :");
	for(i=0;i<n;i++)
		printf("%d\t",a[i]);
	getch();
}
void insertion_sort(int a[],int n)
{
	int i,j,temp;
	for(i=1;i<n;i++)
	{
		temp=a[i];
		for(j=i-1;j>=0 && a[j]>temp;j--)
			a[j+1]=a[j];
		a[j+1]=temp;
	}
}

/*
         *** OUTPUT ***
Enter no of elements :5

Enter array elements :57 89 64 56 77 333

Sorted array is :56     57      64      77      89

*/
