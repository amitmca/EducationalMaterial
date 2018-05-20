#include<stdio.h>
#include<conio.h>
main()
	{
	FILE *fp1,*fp2;
	char ch,ch1;
	int c=0,v=0;
	clrscr();
	fp1=fopen("vowel.txt","w");
	fp2=fopen("con.txt","w");
	do
		{
		ch=getchar();
		if((ch=='a') || (ch=='A') ||(ch=='e') ||(ch=='E') ||(ch=='i') ||(ch=='I') ||(ch=='o') ||(ch=='O') ||(ch=='u') ||(ch=='U'))
			{
			putc(ch,fp1);
			v++;
			}
		else
			{
			putc(ch,fp2);
			if(ch!='\n')
				{
				c++;
				}
			}
		}while(ch!='\n');
	fclose(fp1);
	fclose(fp2);
	fp1=fopen("vowel.txt","r");
	do
		{
		ch=fgetc(fp1);
		putchar(ch);
		}while(!feof(fp1));
	printf("\nNumber Of Vowels are:%d\n",v);
	fp2=fopen("con.txt","r");
	do
		{
		ch1=fgetc(fp2);
		putchar(ch1);
		}while(!feof(fp2));
	printf("\nNumber Of Consonents are:%d\n",c);
	fclose(fp1);
	fclose(fp2);
	getch();
	return 0;
	}

