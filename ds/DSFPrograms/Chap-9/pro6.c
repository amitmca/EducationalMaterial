/*Program 9.6 : Program for implementation of merge sort.*/
#include<stdio.h>
#include<conio.h>
#define MAX 30
void merge_sort(int[],int,int);
void merge(int[],int,int,int);
void main()
{
	int a[30],n,i;
	printf("\n No. of elements :");
	scanf("%d",&n);
	printf("Enter array elements :");
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	merge_sort(a,0,n-1);
	printf("\n Sorted data ->\n");
	for(i=0;i<n;i++)
		printf("%d\t",a[i]);
	getch();
}
void merge_sort(int a[],int i,int j)
{
	int k;
	if(i<j)
	{
		k=(i+j)/2;
		merge_sort(a,i,k);
		merge_sort(a,k+1,j);
		merge(a,i,k,j);
	}
}
void merge(int a[],int l,int m,int u)
{
	int c[MAX];
	int i,j,k;
	/* First array is supposed to be
	   from location l to m of array a[] */
	/* Second array is supposed to be from m+1
	   to u of array a[] */
	/* Array c[] is used for merging */
	/* after merging array c[] is copied back to a[] */
	i=l;
	j=m+1;
	k=0;
	while(i<=m && j<=u)
	{
		if(a[i] < a[j])
		{
			c[k]=a[i];
			k++;i++;
		}
		else
		{
			c[k]=a[j];
			k++;j++;
		}
	}
	while(i<=m)
	{
		c[k]=a[i];
		i++;k++;
	}
	while(j<=u)
	{
		c[k]=a[j];
		k++;j++;
	}
	for(i=l,j=0;i<=u;i++,j++)
		a[i]=c[j];
}

/*
       *** OUTPUT ***
 No. of elements :4
Enter array elements :32 56 22 1

 Sorted data ->
1       22      32      56
*/
