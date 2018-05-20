#include<stdio.h>
#include<conio.h>
main()
	{
	FILE *fp;
	char ch,ch1;
	int a;
	clrscr();
	fp=fopen("c:\\tc\c.txt","r");
	if(!fp)
		{
		printf("\nError in opening file\n\n");
		exit(1);
		}
	printf("\nEnter the character to check:");
	scanf("%c",&ch);
	a=0;
	while(!feof(fp))
		{
		ch1=getc(fp);
		if(ch==ch1)
			a++;
		if(ch1=='\n')
			{
			ch1=getc(fp);
			if(ch==ch1)
			a++;
			}
		}
	printf("\n a:%d\n",a);
	getch();
	return 0;
	}