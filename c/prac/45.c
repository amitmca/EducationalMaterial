#include<stdio.h>
#include<conio.h>
main()
	{
	int a,b,c;
	clrscr();
	printf("\nEnter the three numbers:");
	scanf("%d%d%d",&a,&b,&c);
	if(a>b && a>c)
		{
		printf("\n%d is greater",a);
		}
	else if(b>a && b>c)
		{
		printf("\n%d is greater",b);
		}
	else 	{
		printf("\n%d is greater",c);
		}

	getch();
	return 0;
	}
