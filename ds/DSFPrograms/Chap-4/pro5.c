/*Program 4.5 : Program to copy all elements of an array into another array.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[30],b[30],i,n;
	/* Element of an array 'a' will be copied into array 'b'
	i -> for scanning of an array
	x -> no. of elements in the array */
	printf("\n Enter no of elements :");
	scanf("%d",&n);
	/* Reading values into Array */
	printf("\n Enter the values :");
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	/* Copying data from array 'a' to array 'b */
	for(i=0;i<n;i++)
	b[i]=a[i];
	/* printing of all elements of array */
	printf("the copied array is :");
                  for(i=0;i<n;i++)
	printf("b[%d]=%d\t",i,b[i]);
	getch();
}

/*
            *** OUTPUT ***
 Enter no of elements :5

 Enter the values :12 22 32 42 52
the copied array is :b[0]=12b[1]=22b[2]=32b[3]=42b[4]=52
*/
