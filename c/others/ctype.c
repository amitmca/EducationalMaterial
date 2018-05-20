#include<stdio.h>
#include<ctype.h>
main()
	{
	char ch,ch1;
	system("clear");
	ch=getchar();
	if(isupper(ch))
		{
		ch1=tolower(ch);
		putchar(ch1);
		}

	}
