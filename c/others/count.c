#include<stdio.h>
main()
	{
	FILE *fp;
	char ch;
	int lc,wc,sc;
	system("clear");
	fp=fopen("text.txt","r");
	lc=0;
	wc=0;
	sc=0;
	if(!fp)
		{
		printf("\nPlease check the file\n");
		exit(1);
		}
	else
		{
		while(!feof(fp))
			{
			ch=fgetc(fp);
			if(ch=='\n')
				lc++;
			if(ch==' ')
				wc++;
			if(ch=='.')
				sc++;
			}
		}
	printf("\nThe Contents of the file are...\n");
	fclose(fp);
	fp=fopen("text.txt","r");
	while(!feof(fp))
		{
		ch=getc(fp);
		putchar(ch);
		}
	printf("\nLines = > %d\n",lc);
	printf("\nWords = >%d\n",wc);
	printf("\nSentences =>%d\n",sc);
	}
