/*Program 5.3 : Illustration of 'Call By Reference'.*/
# include <stdio.h>
void swap (int *P, int *q);
void main ()
{	int x, y;
	x = 10; y = 5;
	swap (&x, &y);
	printf("\n values of x and y after swapping :");
	printf("\n x=%d \n y=%d", x, y);
}
void swap (int *p, int *q)
{	int temp;
	temp = *p; *p = *q;
	* q = temp;
}

/*
      *** OUTPUT ***
 values of x and y after swapping :
 x=5
 y=10
*/
