#include<stdio.h>
#include<conio.h>
main()
	{
	int year;
	clrscr();
	textcolor(2);
	cprintf("\nEnter the Year:");
	scanf("%d",&year);
	if(year%4==0)
		{
		cprintf("\nThe Year %d is leap",year);
		}
	else
		{
		cprintf("\nThe Year %d is not leap",year);
		}
	getch();
	return 0;
	}