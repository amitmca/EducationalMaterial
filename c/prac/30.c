#include<stdio.h>
#include<stdlib.h>

 main()
{
	int a,b,c;
	system("clear");
	printf("\n Enter first side of triangle:");
	scanf("%d",&a);
	printf("\n Enter second side of triangle:");
	scanf("%d",&b);
	printf("\n Enter third side of triangle:");
	scanf("%d",&c);
	if((a+b)<c || (a+c)<b || (b+c)<a)
	{
		printf("\n Triangle Does Not Exist.");
		exit(0);
	}
	else
	if((a==b) && (b==c))
	{
		printf("\n The triangle is Equilateral.");
	}
	else
	if((a==b) || (a==c) || (b==c))
	{
		printf("\n Triangle is Isosceles.");
	}
	else
	{
		printf("\n Triangle is Scalen.");
	}

}
