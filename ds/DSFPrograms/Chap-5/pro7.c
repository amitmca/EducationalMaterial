/*Program 5.7 : Program to search an element in an array (using pointers).*/
#include<stdio.h>
int *search(int *p,int n,int x);
/* Function returns a pointer
   P gives the starting address of the array
   n - no. of elements in the array
   x - element to be searched */
void main()
{
	int a[30],x,*p,n;
	printf("\nEnter number of elements :");
	scanf("%d",&n);
	printf("\nEnter array elements :");
	for(p=a;p<a+n;p++)
		scanf("%d",p);
	printf("\nEnter the element to be searched :");
	scanf("%d",&x);
	p=search(a,n,x);
	if(p==NULL)
		printf("\nElement not found :");
	else
		printf("\nFound at the location = %d",p-a+1);
}
int *search(int *a,int n,int x)
{
	int *p;
	p=a;
	while(*p!=x && p<a+n)
		p++;
	if(p==a+n)
		return(NULL);
	return(p);
}

/*
       *** OUTPUT ***
Enter number of elements :4
Enter array elements :23
45
12
55

Enter the element to be searched :12

Found at the location = 3
Enter number of elements :4

Enter array elements :12
23
45
22

Enter the element to be searched :99

Element not found :
*/
