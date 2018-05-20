/*Program 5.1 :	Write a program to interchange contents of two variables x 
			and y. Variables x and y are accessed through pointers.*/

#include<stdio.h>
void main()
{
	int x,y,*p1,*p2,temp;
	p1=&x;
	p2=&y;
	x=5;
	y=10;
	temp=*p1; // interchanging values
	*p1=*p2;
	*p2=temp;
    printf("\nAfter swapping :");
	printf("\n x=%d\n y=%d",x,y);
}

/*
        *** OUTPUT ***
After swapping :
 x=10
 y=5
*/
