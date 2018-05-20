#include<stdio.h>
#include "conio.h"

main()
	{
	char str[20],ch,*t;
	int i;
	clrscr();
	printf("\nEnter the String:");
	scanf("%s",str);
	puts(str);
	printf("\nEnter the Character:");
	ch=getchar();
	t=str;
	i=0;
	while(*t!='\0')
		{
		if(*t==ch)
			{
			printf("\n%c at position %d",ch,i);
			i++;
			}
		t++;
		}
	getch();
	}
