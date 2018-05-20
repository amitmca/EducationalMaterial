//My command Line Editor

#include<stdio.h>
#include<conio.h>
main()
	{
	FILE *fp1,*fp2,*t;
	char cmd[20],first[20],f1[20],f2[20],ch[20];
	clrscr();
	printf("\ncmd :");
	gets(cmd);
	sscanf(cmd,"%s %s %s",&first,&f1,&f2);
	if(strcmp(first,"copy")==0)
		{
		fp1=fopen(f1,"r");
		fp2=fopen(f2,"w");
		while(!feof(fp1))
			{
			fscanf(fp1," %s",ch);
			fprintf(fp2," %s\n",ch);
			}
		printf("\n1 file(s) is copied\n");
		fclose(fp1);
		fclose(fp2);
		}
	if(strcmp(first,"swap")==0)
		{
		fp1=fopen(f1,"r");	// first file to temp file
		t=fopen("t.txt","w");
		while(!feof(fp1))
			{
			fscanf(fp1," %s",ch);
			fprintf(t," %s\n",ch);
			}
		fclose(fp1);
		fclose(t);

		fp1=fopen(f1,"w");	// second file to first file
		fp2=fopen(f2,"r");
		while(!feof(fp2))
			{
			fscanf(fp2," %s",ch);
			fprintf(fp1," %s\n",ch);
			}
		fclose(fp1);
		fclose(fp2);

		t=fopen("t.txt","r");
		fp2=fopen(f2,"w");   	// temp file to second file
		while(!feof(t))
			{
			fscanf(t," %s",ch);
			fprintf(fp2," %s\n",ch);
			}
		fclose(fp2);
		fclose(t);

		}
	getch();
	return 0;
	}
