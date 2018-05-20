#include<stdio.h>
void main(int argc,char *argv[])
	{
	FILE *fp,*fp1;
	int l=0;
	char ch;
	clrscr();
	fp=fopen(argv[1],"r");
	fp1=fopen(argv[2],"w");
	while(!feof(fp))
		{
		fscanf(fp,"%c",&ch);
		if(ch=='.')
			{
			l++;
			}
		if(l%2==0)
			{
			fprintf(fp1,"%c",ch);
			}
		}
	printf("\n");
	fclose(fp);
	getch();
	}
