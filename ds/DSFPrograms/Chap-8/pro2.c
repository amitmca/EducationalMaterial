/*Program 8.2 : Program to implement binary search algorithm*/
#include<stdio.h>
#include<conio.h>

void bubble_sort(int [],int);
int bin_search(int [],int,int);
void main()
{
	int a[30],n,i,key,result;
	printf("\nEnter number of elements :");
	scanf("%d",&n);
	printf("\nEnter the array elements :");
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	printf("\nEnter the element to be searched :");
		scanf("%d",&key);
	bubble_sort(a,n);
	result=bin_search(a,key,n);
	if(result==-1)
		printf("\nElement not found :");
	else
		printf("\nElement  is found at location %d",result+1);
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
int bin_search(int a[],int key,int n)
{
	int i,j,c;
	i=0;
	j=n-1;
	c=(i+j)/2;
	while(a[c]!=key && i<=j)
	{
		if(key>a[c])
			i=c+1;
		else
			j=c-1;
		c=(i+j)/2;
	}
	if(i<=j)
		return(c);
	return(-1);
}

/*
          *** OUTPUT ***
Enter number of elements :6

Enter the array elements :12 34 54 23 11 90

Enter the element to be searched :11

Element  is found at location 1
*/
