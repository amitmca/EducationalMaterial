#include<stdio.h>
//#include<conio.h>
main()
	{
	int n,r=0,rev=0,t;
//	clrscr();
	printf("\nEnter the number:");
	scanf("%d",&n);
	t=n;
	while(n>0)
		{
		rev=r*10;
		r=rev+n%10;
		n=n/10;
		}
	if(r==t)
		printf("\nPallindrome");
	else
		printf("\nNot Pallindrome");
	getch();
	return 0;
	}