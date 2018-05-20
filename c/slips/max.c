//Program for finding maximum of Three numbers
#include<stdio.h>
#include<conio.h>
main()
	{
	int a,b,c;
	clrscr();
	printf("\nPlease Enter three values:");
	scanf("%d%d%d",&a,&b,&c);
	if(a > b && a > c)
		{
		printf("\n%d is Maximum",a);
		}
	else if(b > a && b > c)
		{
		printf("\n%d is Maximum",b);
		}
	else
		printf("\n%d is Maximum",c);
	getch();
	return 0;
	}