#include<stdio.h>
#include "/mnt/D:/Programs/conio.h"

main()
	{
	char ch='y';
	int i=0;
	clrscr();
	do
		{
		i++;
		printf("\nIncrement or not(y/n):");
		ch=getche();
		}while(ch=='y');
	printf("\nValue Of i is:%d\n",i);
	getch();
	}
