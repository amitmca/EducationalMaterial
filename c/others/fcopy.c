//Program to swap the contents of two files
#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	FILE *fp1,*fp2,*fp3;
	char ch;
	clrscr();
	fp1=fopen("first.txt","r");
	fp2=fopen("temp.txt","w");
	while(!feof(fp1))
		{
		ch=fgetc(fp1);
		putc(ch,fp2);
		}
	fclose(fp1);
	fclose(fp2);
	fp1=fopen("first.txt","w");
	fp3=fopen("sec.txt","r");
	while(!feof(fp3))
		{
		ch=fgetc(fp3);
		putc(ch,fp1);
		}
	fclose(fp1);
	fclose(fp3);
	fp2=fopen("temp.txt","r");
	fp3=fopen("sec.txt","w");
	while(!feof(fp2))
		{
		ch=fgetc(fp2);
		putc(ch,fp3);
		}
	fclose(fp2);
	fclose(fp3);
	getch();
	return 0;
	}

