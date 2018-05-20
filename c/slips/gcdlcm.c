//Program to calculate GCD and LCM
// GCD - Greatest Common Divisor(Highest Commom Factor(HCF))
// LCM - Lowest Common Multiple  (Lowest Common Factor(LCF))
#include<stdio.h>
#include<conio.h>
main()
	{
	int a,b,prod;
	clrscr();
	printf("\nEnter the numbers:");
	scanf("%d%d",&a,&b);
	prod=a*b;
	while(a!=b)
		{
		if(a > b)
			a=a-b;
		else
			b=b-a;
		}
	printf("\n\nThe GCD is : %d ",a);
	printf("\n\nThe LCM is : %d",prod/a);
	getch();
	return 0;
	}