#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

int main(int argc,char *argv[])
	{
	FILE *fp1,*fp2;
	char ch;
	clrscr();
	if(argc!=3)
		{
		puts(" Please provide 3 command line arguments");
		getch();
		exit(1);
		}
	fp1=fopen(argv[1],"r");
	fp2=fopen(argv[2],"w");
	if(!fp1)
		{
		printf("\n Cannot open source file\n");
		exit(1);
		}
	if(!fp2)
		{
		printf("\n Cannot open destination file\n");
		exit(1);
		}
	while(!feof(fp1))
		{
		ch=getc(fp1);
		putc(ch,fp2);
		}
	fclose(fp1);
	fclose(fp2);
	getch();
	return 0;
	}
