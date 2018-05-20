/*Program 4.8 : Program to show the use of two dimensional array.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[10][10],m,n,i,j;
	/* physical size of the array is 10*10
	whereas a specified size of the array
	of the size m*n can be stored in array a */
	/*
	m - no of rows
	n - no of columns
	*/
	printf("\n Enter the rows and columns :");
	scanf("%d %d",&m,&n);
	/* Reading m*n elements */
	for(i=0;i<m;i++)    /* m rows */
		for(j=0;j<n;j++)  /* inside each row there are n columns */
		{
			printf("\n Enter the value of(%d)(%d)=",i,j);
			scanf("%d",&a[i][j]);
		}
	/* printing of all elements of 2-D array */
	for(i=0;i<m;i++)
	{
	    printf("\n");   /* each row starts from newline */
	    for(j=0;j<n;j++)
		printf("%d\t",a[i][j]);
	}
	getch();
}

/*
            *** OUTPUT ***
  Enter the rows and columns :3 4
 Enter the value of(0)(0)=2
 Enter the value of(0)(1)=1
 Enter the value of(0)(2)=0
 Enter the value of(0)(3)=5
 Enter the value of(1)(0)=9
 Enter the value of(1)(1)=3
 Enter the value of(1)(2)=6
 Enter the value of(1)(3)=1
 Enter the value of(2)(0)=4
 Enter the value of(2)(1)=6
 Enter the value of(2)(2)=7
 Enter the value of(2)(3)=8
 2       1       0       5
 9       3       6       1
 4       6       7       8
*/
