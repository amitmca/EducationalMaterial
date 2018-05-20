/*Program 3.3 : A sample program showing if() else statement.*/
#include<stdio.h>
void main()
{
	int x;
	printf("\n Enter a number :");
	scanf("%d",&x);
	if(x>0)
	{
		printf("\n x is a positive number ");
		printf("\n value of x = %d",x);
	}
	else
	{
		printf("\n x is a negative number ");
		printf("\n value of x = %d",x);
	}
}

/*
     *** OUTPUT ***
---first run---
Enter a number :5
x is a positive number
value of x = 5

---second run---
Enter a number :-5
x is a negative number
value of x = -5
*/

