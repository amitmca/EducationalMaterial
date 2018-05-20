
/*Program 3.12 : A sample program showing break statement to end the loop.*/
#include<stdio.h>
void main()
{
	int sum,i;
	sum=0;
	 clrscr();

	for(i=1;i<=500;i++)
	{
		sum=sum+i;
		if(sum>=30)
			break;
		printf("\n looping");
	}
	printf("\n Sum exceeds 30");
}

/*
         *** OUTPUT **
 looping
 looping
 looping
 looping
 looping
 looping
 looping
 Sum exceeds 30
*/
