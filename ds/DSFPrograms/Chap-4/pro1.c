/*Program 4.1 :	Program to display array elements with their addresses.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	int a[3]={5,4,3};
	printf("\n a[0] ,value=%d : address=%u",a[0],&a[0]);
	printf("\n a[1] ,value=%d : address=%u",a[1],&a[1]);
	printf("\n a[2] ,value=%d : address=%u",a[2],&a[2]);
	getch();
}

/*
        *** OUTPUT ***
 a[0] ,value=5 : address=65520
 a[1] ,value=4 : address=65522
 a[2] ,value=3 : address=65524
*/

