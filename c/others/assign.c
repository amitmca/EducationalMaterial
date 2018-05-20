#include<stdio.h>
#include<conio.h>
main()
	{
	int i,j,k;
	clrscr();
	for(i=2;i<=10;i++)
		{
		for(j=1;j<=10;j++)
			{
			k=j*2;
			printf("%d\t",k);
			}
		}
	getch();
	return 0;
	}