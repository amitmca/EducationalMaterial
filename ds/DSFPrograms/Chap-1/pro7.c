
/*Program 1.7 : Program to check positive or negative number.*/
#include<stdio.h>
// use of if statement
main()
{
	int x;
	printf("\nEnter the number :");
	scanf("%d",&x);
	if(x>0)
		printf("\nNumber is greater than zero ");
	else
		printf("\nNumber is less than zero ");
}
/*
          *** OUTPUT ***
// first run
Enter the number :5
Number is greater than zero

//second run
Enter the number :-5
Number is less than zero
*/
