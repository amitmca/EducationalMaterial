/*Program 4.3 :	Program for deletion of an element from the specified location.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[30],n,i,j;
	/*
		n - no.of elements stored in array
		i - for scanning the array
		j - location of the element to be deleted
	*/
	printf("\n Enter no of elements :");
	scanf("%d",&n);
	/* read n elements in an array  */
	printf("\n Enter %d elements :",n);
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	/* read the location of the element to be deleted */
	printf("\n location of the element to be deleted :");
	scanf("%d",&j);
	/* loop for the deletion  */
	while(j<n)
	{
		a[j-1]=a[j];
		j++;
	}
	n--;    /* no of elements reduced by 1 */
	/* loop for printing  */
	for(i=0;i<n;i++)
	printf("\n %d",a[i]);
	getch();
}
/*
          *** OUTPUT ***
 Enter no of elements :4

 Enter 4 elements :23 45 67 12

 location of the element to be deleted :3

 23
 45
 12
*/
