
/*Program 6.1 :	Program for finding factorial of a number through the use 
			of recursive function */
#include<stdio.h>
#include<conio.h>
int fact(int);
void main()
{
	int x,n;
	printf("\n Enter the value of n :");
	scanf("%d",&n);
	x=fact(n);
	printf("\n %d",x);
	getch();
}
int fact(int n)
{
	if(n==0)
		return(1);
	return(n*fact(n-1));
}

/*
         *** OUTPUT ***
 Enter the value of n :5

 120

*/
