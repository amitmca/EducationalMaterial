/*Program 3.8 :	Program for reversing a number.*/
#include<stdio.h>
void main()
{
	int x,y;
	printf("\nEnter a number :");
	scanf("%d",&x);
	y=0;
	while(x!=0)
	{
		y=y*10+x%10;
		x=x/10;
	}
	printf("\n%d",y);
}
