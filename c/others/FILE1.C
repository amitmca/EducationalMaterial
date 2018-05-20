#include<stdio.h>
#include<conio.h>
#include<ctype.h>


int main()
	{
	FILE *fp,*fp1;
	char ch,*fname;
	clrscr();
	fname="myfile.txt";
	fp=fopen(fname,"w");
	if(!fp)
		{
		printf("\n Unable to open file\n");
		exit(1);
		}
	else
		{
		do
			{
			scanf("%c",&ch);
			putc(ch,fp);
			}while(ch!='\n');
		}
	fclose(fp);
	fp=fopen(fname,"r");
	fp1=fopen("tmp1.txt","w");
	if(!fp)
		{
		printf("\n Unable to open source file\n");
		exit(1);
		}
	if(!fp1)
		{
		printf("\n Unable to open destination file\n");
		exit(1);
		}
	while(!feof(fp))
		{
		ch=getc(fp);
		putc(ch,fp1);
		}
	printf("\n 1 file copied");
	getch();
	return 0;
	}