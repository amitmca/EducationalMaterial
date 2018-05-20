#include<stdio.h>
#include "conio.h"

main()
	{
	int c=30;
	clrscr();
	printf("%d\t%d\t%d\t%d\n",c,c<<1>>2,c&10,c|100);
	getch();
	}

// Output => 30 15 10 126
