/*Program 4.2 : Program to read and display the elements of an array along with the total, number of even and odd numbers.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int i,a[50],sum,n, even, odd;
	printf("\n Enter no of elements :");
	scanf("%d",&n);
	/* Reading values into Array */
	printf("\n Enter the values :");
	for(i=0;i<n;i++)
	scanf("%d",&a[i]);
	/* computation of total */
	sum=0; even = odd = 0;
	for(i=0;i<n;i++)
	{
		sum = sum+a[i];
		if(a[i]%2==0)
			even++;
		else
			odd++;
	}
	/* printing of all elements of array */
	for(i=0;i<n;i++)
	printf("\n a[%d]=%d",i,a[i]);
	/* printing of total */
	printf("\n sum=%d\n even=%d\n odd=%d",sum,even,odd);
}

/*
                 *** OUTPUT ***
 Enter no of elements : 3
 Enter the values :  1     	2       3
 a[0]=1
 a[1]=2
 a[2]=3
 sum=6
 Even=1
 Odd=2
*/
