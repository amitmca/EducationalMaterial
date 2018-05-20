//Program to copy the contents of one file to another
#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	FILE *fp1,*fp2;
	char ch;
	clrscr();
	fp1=fopen(argv[1],"r");
	fp2=fopen(argv[2],"w");
	while(!feof(fp1))
		{
		ch=fgetc(fp1);
		putc(ch,fp2);
		}
	fclose(fp1);
	fclose(fp2);
	printf("\n1 file(S) is copied\n");
	getch();
	return 0;
	}

