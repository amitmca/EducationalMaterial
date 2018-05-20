#include<stdio.h>
//#include<conio.h>
void main(int argc,char *argv[])
	{
	FILE *fp1,*fp2;
	char ch;
//	clrscr();
	fp1=fopen(argv[0],"r");
	fp2=fopen(argv[1],"w");
	while(!feof(fp1))
		{
		fscanf(fp1," %c",&ch);
		fprintf(fp2," %c\n",ch);
		}
	printf("\n1 file(s) is copied\n");
	fclose(fp1);
	fclose(fp2);
	}
