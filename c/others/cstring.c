//Program to count the words repeated in a given string

#include<stdio.h>
#include<conio.h>

void main()
	{
	char *str,ch,*str1;
	int i=0,j;
	clrscr();
	printf("\nEnter the string:");
	gets(str);
	while(*str!='\0')
		{
		ch=*str;
		if(ch==' ' || ch=='.')
			{
			strcpy(str1,str);
			i++;
			}
		str++;
		}
	printf("\nThe Spaces are:%d",i);
	printf("%s",str1);
	getch();
	}