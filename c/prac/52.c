#include<stdio.h>
#include<conio.h>
main()
	{
	FILE *fp1,*fp2;
	char ch;
	clrscr();
	fp1=fopen("src.txt","r");
	fp2=fopen("dest.txt","w");
	while(!feof(fp1))
		{
		ch=getc(fp1);
		if(ch > 64 && ch < 92)
			{
			ch=ch+32;
			putc(ch,fp2);
			}
		else if(ch > 96 && ch < 123)
			{
			ch=ch-32;
			putc(ch,fp2);
			}
		}
	fclose(fp1);
	fclose(fp2);
	getch();
	return 0;
	}