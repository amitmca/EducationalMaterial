#include<stdio.h>
#include<conio.h>
void mystrlwr(char *str);
main()
	{
	char str1[20],str2[20];
	clrscr();
	printf("\n Enter the String here:= ");
	scanf("%s",str1);
	mystrlwr(str1);
	getch();
	return 0;
	}
void mystrlwr(char *str)
	{
	printf("\nThe String in lower case is:\t");
	while(*str!='\0')
		{
		if((*str > 64) && (*str < 92))
			{
			*str=*str+32;
			printf("%c",*str);
			}
		str++;
		}
	printf("\n");
	}
