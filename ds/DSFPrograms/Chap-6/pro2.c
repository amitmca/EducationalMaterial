/*Program 6.2 : Program for tower of Honoi */
#include<stdio.h>
#include<conio.h>
void TOH(int n,char x,char y,char z);
void main()
{
	int n;
	printf("\n Enter number of plates:");
	scanf("%d",&n);
	TOH(n-1,'A','B','C');
	getch();
}
void TOH(int n,char x,char y,char z)
{
	if(n>0)
	{
		TOH(n-1,x,z,y);
		printf("\n%c -> %c",x,y);
		TOH(n-1,z,y,x);
	}
}
/*
          *** OUTPUT ***
 Enter number of plates:4

A -> B
A -> C
B -> C
A -> B
C -> A
C -> B
A -> B
*/

