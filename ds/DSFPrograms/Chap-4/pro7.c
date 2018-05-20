/*Program 4.7 : Program for merging of two array.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[30],b[30],c[30],i,j,k,n1,n2;
	/*
	n1 - no of elements in the array 'a'
	n2 - no of elements in the array 'b'
	*/
	printf("\n Enter no of elements in 1'st array :");
	scanf("%d",&n1);
	for(i=0;i<n1;i++)
		scanf("%d",&a[i]);
	printf("\n Enter no of elements in 2'nd array :");
	scanf("%d",&n2);
	for(i=0;i<n2;i++)
		scanf("%d",&b[i]);
	i=0;j=0;k=0;  /* merging starts */
	while(i<n1 && j<n2)
	{
		if(a[i]<=b[j])
		{
			c[k]=a[i];
			i++;k++;
		}
		else
		{
			c[k]=b[j];
			k++;j++;
		}
	}
	/* Some statements in array 'a'are still remaining
	   where as the array 'b' is exhausted
	*/
	while(i<n1)
	{
		c[k]=a[i];
		i++;k++;
	}
	/* some elements in array b are still remaining
	   whereas the array 'a'is exhausted
	*/
	while(j<n2)
	{
		c[k]=b[j];
		k++;j++;
	}
	/* Displaying elements of array 'c' */
                  printf("\nMerged array is :");
	for(i=0;i<n1+n2;i++)
	printf("\n %d",c[i]);
}

/*
       *** OUTPUT ***
  Enter no of elements in 2'nd array :5
4 2 4 5 6

Merged array is :
 4
 2
 4
 5
 5
 6
 15
 9
 11
 13
*/
