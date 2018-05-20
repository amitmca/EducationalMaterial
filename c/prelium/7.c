#include<stdio.h>
#include<conio.h>
main()
	{
	char *str1,*str2;
	clrscr();
	printf("\nEnter Your String:");
	scanf("%s",str1);
	while(*str1!='\0')
		{
		if(*str1=='y')
			{
			*str2=*str1-24;
			printf("%c",*str2);
			}
		else
			{
			*str2=*str1+2;
			printf("%c",*str2);
			}
		str1++;
		str2++;
		}
	*str2='\0';
	getch();
	return 0;
	}
