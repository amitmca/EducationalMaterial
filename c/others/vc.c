//Program to write vowels and consonent in their respective files and count it
#include<stdio.h>
#include<conio.h>
main()
	{
	FILE *fp1,*fp2;
	char ch;
	int c=0,v=0;
	clrscr();
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
			else if(ch!='\n')
				{
				putc(ch,fp2);
				c++;
				}
			}while(ch!='\n');
	fclose(fp1);
	fclose(fp2);
	fp1=fopen("vowel.txt","r");
	fp2=fopen("consonent.txt","r");
	if(!fp1)
		{
		printf("\nError whilw opening file");
		exit(1);
		}
	printf("\nThe contents of Vowels.txt are...\n");
	while(!feof(fp1))
		{
		ch=getc(fp1);
		putchar(ch);
		}
	printf("\nNumber of Vowels :%d",v);
	printf("\nThe contents of Consonent.txt are...\n");
	while(!feof(fp2))
		{
		ch=getc(fp2);
		putchar(ch);
		}
	printf("\nNumber Of Consonents :%d\n",c);
	getch();
	return 0;
	}
