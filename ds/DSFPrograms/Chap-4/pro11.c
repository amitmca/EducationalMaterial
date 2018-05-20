/*Program 4.11 : Program to find the transpose of square matrix.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[10][10],m,i,j,temp;
	/* actual size of matrix is m*n
	i,j  - for scanning of array
	temp - for interchanging of a[i][j] and a[j][i] */
	printf("\n Enter the size of matrix :");
	scanf("%d",&m);
	/* Reading elements of matrix */
	printf("\n Enter the values :");
	for(i=0;i<m;i++)
		for(j=0;j<m;j++)
			scanf("%d",&a[i][j]);
	//to print original square matrix
	printf("\noriginal square matrix is");
	for(i=0;i<m;i++)
	{
		printf("\n");
		for(j=0;j<m;j++)
			printf("%d\t",a[i][j]);
	}
	/* Finding transpose */
	for(i=1;i<m;i++)
		for(j=0;j<i;j++)
		{
			temp=a[i][j];
			a[i][j]=a[j][i];
			a[j][i]=temp;
		}
	/* printing of all elements of final matrix */
	printf("\nTranspose matrix is :");
	for(i=0;i<m;i++)
	{
		printf("\n");
		for(j=0;j<m;j++)
			printf("%d\t",a[i][j]);
	}
	getch();
}

/*
        *** OUTPUT ***
 Enter the size of matrix :4
Enter matrix data :5 4 9 6
                    4 1 0 3
                    2 2 5 4
                    6 1 0 5

 Sum of elements of major diagonal = 16
 Sum of element of minor diagonal = 14
 Enter the size of matrix :4

 Enter the values :5 1 9 6
                   2 0 8 4
                   9 6 5 2
                   1 0 0 1

original square matrix is
5       1       9       6
2       0       8       4
9       6       5       2
1       0       0       1
Transpose matrix is :
5       2       9       1
1       0       6       0
9       8       5       0
6       4       2       1
*/
