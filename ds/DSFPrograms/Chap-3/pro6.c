/*Program 3.6 :	Program for finding sum of the numbers. Program accepts numbers from the user. User enters -1 as the last number to terminate reading. Sum of numbers is printed.*/
#include<stdio.h>
void main()
{
	int sum=0,x;
	beg:printf("\nEnter a number(-1 to terminate) : ");
	scanf("%d",&x);
	if(x==-1)
		goto last;
	sum=sum+x;
	goto beg;
	last:printf("\nSum = %d",sum);
}

/*
           *** OUTPUT ***
Enter a number(-1 to terminate) : 23

Enter a number(-1 to terminate) : 12

Enter a number(-1 to terminate) : 4

Enter a number(-1 to terminate) : -1

Sum = 39
*/
