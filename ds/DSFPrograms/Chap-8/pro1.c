/*Program 8.1 : A sample program for sequential search*/
#include<stdio.h>
#include<conio.h>
int sequential_search(int a[],int key,int n);
void main()
{
	int a[50],n,key,i;
	printf("\nNo.of elements :");
	scanf("%d",&n);
	printf("\nEnter %d numbers :",n);
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	printf("element to be searched :");
	scanf("%d",&key);
	i=sequential_search(a,key,n);
	if(i==-1)
		printf("\n Not found");
	else
		printf("\nFound at location = %d",i+1);
	getch();
}
int sequential_search(int a[],int key,int n)
{
	int i;
	i=0;
	while(i<n && key != a[i])
		i++;
	/* search terminates here */

	if(i<n)
		return(i);
	return(-1);
}

/*
           *** OUTPUT ***
No.of elements :4

Enter 4 numbers :66 77 88 99
element to be searched :88

Found at location = 3
*/
