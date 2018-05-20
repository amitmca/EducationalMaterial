/*Program 3.13 :A sample program showing use of continue.*/
#include<stdio.h>
void main()
{
	float x;
	while(1)
	{
		printf("\nEnter a number(-1 to terminate) :");
		scanf("%f",&x);
		if(x==-1)
			break;
		if(x==0)
			continue;
		printf("\nReciprocal of %f = %f",x,(1/x));
	}
}

/*
        *** OUTPUT ***
Enter a number(-1 to terminate) :2

Reciprocal of 2.000000 = 0.500000
Enter a number(-1 to terminate) :0

Enter a number(-1 to terminate) :-1
*/
