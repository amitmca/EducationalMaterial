/*Program 4.9 : Program for addition of two matrices.*/
#include<stdio.h>
#include<conio.h>
void add(int[][10],int[][10],int[][10],int,int);
void read(int[][10],int,int);
void print(int[][10],int,int);
void main()
{
	int a[10][10],b[10][10],c[10][10],m,n;
	printf("\n Enter the size of matrix :");
	scanf("%d%d",&m,&n);
	printf("\n Enter the elements of 1'st matrix");
	read(a,m,n);
	printf("\n Enter the elements of 2'nd matrix");
	read(b,m,n);
	add(a,b,c,m,n);
                  printf("\n1'st matrix is:");
	print(a,m,n);
                  printf("\n2'nd matrix is:");
	print(b,m,n);
                  printf("\nresult matrix is:");
	print(c,m,n);
}
void add(int x[][10],int y[][10],int z[][10],int m,int n)
{
	int j,i;
	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			z[i][j]=x[i][j]+y[i][j];
}
void read(int x[][10],int m,int n)
{
	int i,j;
	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
		{
			scanf("%d",&x[i][j]);
		}
}
void print(int x[][10],int m,int n)
{
	int i,j;
	for(i=0;i<m;i++)
	{
		printf("\n");
		for(j=0;j<n;j++)
			printf("%d\t",x[i][j]);
	}
}

/*
         *** OUTPUT ***
Enter the size of matrix :3 4
Enter the elements of 1'st matrix 
0 0 0 0
1 1 1 1
2 2 2 2
Enter the elements of 2'nd matrix
1 2 3 4
1 2 3 4
1 2 3 4
1'st matrix is:
0       0       0       0
1       1       1       1
2       2       2       2
2'nd matrix is:
1       2       3       4
1       2       3       4
1       2       3       4
result matrix is:
1       2       3       4
2       3       4       5
3       4       5       6
*/
