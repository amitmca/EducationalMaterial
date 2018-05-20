#include<stdio.h>

union u
	{
		char s;
		int num;
	}u1;
	main()
		{
			union u *ptr;
			ptr->num=5;
			printf("%d",ptr->num);
			ptr->s='a';
			printf("%c",ptr->s);
		}
