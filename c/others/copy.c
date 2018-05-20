#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	FILE *fp1,*fp2,*fp3;
	char ch;
	clrscr();
	fp1=fopen(argv[1],"r");
	fp2=fopen("temp.txt","w");
	if(!fp1)
		{
		printf("\nError in opening file\n");
		exit(1);
		}
	if(!fp2)
		{
		printf("\nError in creating file\n");
		exit(1);
		}
	else
		{
		while(!feof(fp1))
			{
			ch=fgetc(fp1);
			putc(ch,fp2);
			}
		}
	fclose(fp1);
	fclose(fp2);
	fp1=fopen(argv[1],"w");
	fp3=fopen(argv[2],"r");
	if(!fp1)
		{
		printf("\nError in opening file\n");
		exit(1);
		}
	if(!fp3)
		{
		printf("\nError in creating file\n");
		exit(1);
		}
	else
		{
		while(!feof(fp3))
			{
			ch=fgetc(fp3);
			putc(ch,fp1);
			}
		}
	fclose(fp1);
	fclose(fp3);
	fp2=fopen("temp.txt","r");
	fp3=fopen(argv[2],"w");
	if(!fp2)
		{
		printf("\nError in opening file\n");
		exit(1);
		}
	if(!fp3)
		{
		printf("\nError in creating file\n");
		exit(1);
		}
	else
		{
		while(!feof(fp2))
			{
			ch=fgetc(fp2);
			putc(ch,fp3);
			}
		}
	fclose(fp2);
	fclose(fp3);
	getch();
	return 0;
	}
