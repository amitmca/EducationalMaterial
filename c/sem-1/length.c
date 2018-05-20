#include<stdio.h>
#include<conio.h>
int length(char *str);
void main()
	{
	int l;
	char *str;
	clrscr();
	printf("\nPlease enter the String:");
	gets(str);
	l=length(str);
	printf("\nThe Length of %s is %d:\n",str,l);
	getch();
	}
int length(char *str)
	{
	int l=0;
	while(*str!='\0')
		{
		l++;
		str++;
		}
	return l;
	}