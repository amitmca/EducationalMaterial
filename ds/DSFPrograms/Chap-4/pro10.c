/*Example 4.10 :Write a C-program to find the sum of major and minor diagonal of m ´ n matrix.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[10][10],n,i,j,major,minor;
	printf("\n Enter size of the matrix(n for n ´ n) :");
	scanf("%d", &n);
	printf("\n Enter matrix data :");
	for(i =0; i<n; i++)
		for(j=0; j<n; j++)
			scanf
			("%d", &a[i][j]);
/* For any element aij Q n major diagonal i = j and for an element on minor diagonal 
i + j = n */
major = minor = 0;
	for(i = 0; i<n; i++)
	{
		major = major + a[i] [i];
		minor = minor + a [i] [n - i - 1];
	}
	printf("\n Sum of elements of major diagonal = %d", major);
	printf("\n Sum of element of minor diagonal = %d", minor);
	getch();
}

/*
          *** OUTPUT ***
Enter size of the matrix(n for n ¦ n) :4

Enter matrix data :5 4 9 6
                   4 1 0 3
                   2 2 5 4
                   6 1 0 5

Sum of elements of major diagonal = 16
Sum of element of minor diagonal = 14
*/
