#include<stdio.h>
#include<conio.h>
void main()
	{
	FILE *fp;
	char ch;
	clrscr();
	fp=fopen("prog.c","r");
	if(!fp)
		{
		printf("\nError in opening file\n");
		exit(1);
		}
	else
		{
		while(!feof(fp))
			{
			fscanf(fp,"%c",&ch);
			printf("%c",ch);
			}
		}
	getch();
	}