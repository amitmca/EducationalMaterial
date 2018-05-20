/*Program 4.4 : Program for insertion of an element at the specified location.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[30],x,n,i,loc;
	/*
		x   - element to be inserted
		n   - no.of elements in the array
		i   - for scanning of the array
		loc - place where the new element is to be inserted 	*/
	printf("\n Enter no of elements :");
	scanf("%d",&n);
	/* read n elements in an array  */
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);
	printf("\n Enter the element to be inserted :");
	scanf("%d",&x);
	printf("\n Enter the location");
	scanf("%d",&loc);
	/* create space at the specified location */
	for(i=n-1;i>=loc-1;i--)
		a[i+1]=a[i];
	n++;
	a[loc-1]=x;      /* Element inserted  */
	/* Printing of result */
	for(i=0;i<n;i++)
		printf("\n %d",a[i]);
}

/*
           *** OUTPUT ***
 Enter no of elements :4
12 13 14 15

 Enter the element to be inserted :20

 Enter the location 2

 12
 20
 13
 14
 15
*/
