//  program for bisection method
#include<stdio.h>
#include<conio.h>
#include<math.h>
float f(float x)
	{
	return(x*x*x+2*x-1);
	}
int  main(void)
	{
	float x0,x1,x2;
	clrscr();
	printf("\n Enter the number for x0=",x0);
	scanf("%f",&x0);
	printf("\n Enter the number for x1=",x1);
	scanf("%f",&x1);
	x2=(x0+x1)/2;
	while(fabs(f(x2))>=0.001 )
	{
	x2=(x0+x1)/2;
	if (f(x0)*f(x2)<0)
	x1=x2;
	else
	x0=x2;
	printf("\nThe value of x2=%f",x2) ;
	}
	getch();
	return 0;
	}



