//Program fro printing n rows of 
/*
A
A B
A B C
A B C D
|
|
|
*/
#include<stdio.h>
main()
	{
	char str[20];
	int i,j,p,c;
	clrscr();
	printf("\nEnter the string:");
	scanf("%s",str);
	c=strlen(str);
	p=1;
	for(i=0;i<c;i++)
		{
		for(j=0;j<p;j++)
			{
			printf("%c ",str[j]);
			}
		printf("\n");
		p++;
		}
	getch();
	return 0;
	}
