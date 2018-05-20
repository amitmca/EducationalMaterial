//Program to check whether entered Year is leap or not
#include<stdio.h>
#include<conio.h>
main()
	{
	int leap=0,year;
	clrscr();
	printf("\nEnter The Year:=");
	scanf("%d",&year);
	if((year%400==0) || (year%4==0) && (year%100!=0))
		{
		leap=1;
		}
	else
		{
		leap=0;
		}
	if(leap==1)
		{
		printf("\nThe Year is Leap\n");
		}
	else
		{
		printf("\nThe Year is Not Leap\n");
		}
	getch();
	return 0;
	}