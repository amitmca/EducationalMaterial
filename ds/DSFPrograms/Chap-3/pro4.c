/*Program 3.4 :Program for finding largest among three numbers. Program reads three numbers from the user and prints the largest number.*/

#include<stdio.h>
void main()
{
	int A,B,C;
	printf("\nEnter three numbers :");
	scanf("%d%d%d",&A,&B,&C);
	if(A>B)
		if(A>C)
			printf("\n %d is largest number ",A);
		else
			printf("\n %d is largest number ",C);
		else
			if(B>C)
				printf("\n %d is largest number ",B);
			else
				printf("\n %d is largest number ",C);
}

/*
       *** OUTPUT ***
Enter three numbers :34 56 -3

 56 is largest number
*/

