//Program to calculate a^b
#include<stdio.h>
#include<math.h>
main()
	{
	int a,b,c;
//	clrscr();
	printf("\nEnter First number:");
	scanf("%d",&a);
	printf("\nEnter Second number:");
	scanf("%d",&b);
	c=pow(a,b);
	printf("\nThe Answer is:%d",c);
//	getch();
	return 0;
	}