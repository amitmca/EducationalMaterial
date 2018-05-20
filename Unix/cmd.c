#include<stdio.h>
main(int argc,char *argv[])
	{
	FILE *fp1,*fp2;
	char cmd[20],first[20],f1[20],f2[20],ch;
	system("clear");
	printf("\nFirst CLA%s\n",argv[0]);
	if(strcmp(argv[1],"copy")==0)
		{
		fp1=fopen(argv[2],"r");
		printf("\nSecond CLA:%s\n",argv[2]);
		fp2=fopen(argv[3],"a");
		printf("\nThird CLA:%s\n",argv[2]);
		while(!feof(fp1))
			{
			fscanf(fp1,"%c",&ch);
			fprintf(fp2,"%c",ch);
			}
		printf("\n1 file(s) is copied\n");
		fclose(fp1);
		fclose(fp2);
		}
	}
/*	system("gcc test.c");
	system("./a.out");
	printf("\n");
	system("c++ test.cpp");
	system("./a.out");
	system("javac test.java");
	system("java test");
	system("date");
	system("time");
	system("cal");*/
