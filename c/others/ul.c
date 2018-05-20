#include<stdio.h>
#include<ctype.h>
main()
	{
	FILE *fp1,*fp2;
	char ch,ch1,ch2;
	system("clear");
	fp1=fopen("ab.txt","r");
	fp2=fopen("bc.txt","w");
	if(!fp1)
		{
		printf("\nError in opening file\n");
		exit(1);
		}
	else
		{
		while(!feof(fp1))
			{
			ch=fgetc(fp1);
			if(isupper(ch))
				{
				ch1=tolower(ch);
				putc(ch1,fp2);
				}	
			else if(islower(ch))
				{
				ch2=toupper(ch);
				putc(ch2,fp2);
				}
			}
		}
	}
