#include<stdio.h>
#include<string.h>
#include<conio.h>
void main()
{
	char *str,*substr,*ptr;
	clrscr();
	puts("\n\nEnter the string:");
	gets(str);
	puts("\n\nEnter the string to find:");
	gets(substr);
	ptr=strstr(str,substr);
	printf("\n\nThe substring is %s find:",ptr);
	getch();

}
