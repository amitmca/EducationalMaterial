//Program to write vowels and consonents in their respective files
#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	FILE *fp1,*fp2;
	char ch;
	int c,v;
	clrscr();
	c=0,v=0;
	fp1=fopen("vowel.txt","w");
	fp2=fopen("consonent.txt","w");
	do
			{
			ch=getchar();
			if(ch=='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch=='I' || ch=='o' || ch=='O' || ch=='u' || ch=='U')
				{
				putc(ch,fp1);
				v++;
				}
			else
				{
			
				putc(ch,fp2);
				c++;
				}
			}while(ch!='\n');
	fclose(fp1);
	fclose(fp2);
	printf("\nVowels :%d\n",v);
	printf("\nConsonents :%d\n",v);
	getch();
	return 0;
	}
