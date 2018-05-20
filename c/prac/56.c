//Program to print the sum of ASCII values of all characters of a string
#include<stdio.h>
#include<conio.h>
main()
	{
	int a=0;
	char *str;
	clrscr();
	printf("\nEnter the string:");
	scanf("%s",str);
	while(*str!='\0')
		{
		a=a+(*str);
		printf("\n%c = %d\n",*str,*str);
		str++;
		}
	printf("\n%d\n",a);
	getch();
	return 0;
	}