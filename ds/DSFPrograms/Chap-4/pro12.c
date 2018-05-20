
/*Program 4.12 : Program for checking of symmetry.*/
#include<stdio.h>
#include<conio.h>
int symmetry(int a[][10],int m);
void main()
{
	int a[10][10],m,i,j,result;
	printf("\n Enter the size of matrix :");
	scanf("%d",&m);
	/* Reading matrix elements */
	printf("\n Enter the values :");
	for(i=0;i<m;i++)
		for(j=0;j<m;j++)
			scanf("%d",&a[i][j]);
			result=symmetry(a,m);
			if(result==0)
				printf("\n Not symmetrical");
			else
				printf("\n Symmetrical");
			getch();
}
int symmetry(int a[][10],int m)
{
	int i,j;
	for(i=1;i<m;i++)
		for(j=0;j<i;j++)
			if(a[i][j]!=a[j][i])
			return(0);
	return(1);
}

/*
           *** OUTPUT ***
Enter the size of matrix :4
Enter the values :
1 2 3 4
2 1 4 3
3 4 1 3
4 3 3 1
Symmetrical
--------------------------------------------
Enter the size of matrix :4
Enter the values :
1 2 3 4
1 2 3 4
1 2 3 4
1 2 3 4
 Not symmetrical
*/
