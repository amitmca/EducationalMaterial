#include<stdio.h>
#include<conio.h>
main()
	{
	int a,b,p;
	clrscr();
	printf("\nEnter Two Numbers:");
	scanf("%d%d",&a,&b);
	p=a*b;
	while(a!=b)
		{
		if(a > b)
			a=a-b;
		else
			b=b-a;
		}
	printf("\nGCD is:%d",a);
	printf("\nLCM is:%d\n",p/a);
	getch();
	}
