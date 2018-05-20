#include<stdio.h>
main(int argc,char *argv[])
	{
	FILE *fp1,*fp2;
	int pid;
	char cmd[20],first[20],f1[20],f2[20],ch;
	system("clear");
	printf("\nEnter 'help' for help"); 
	while(strcmp(cmd,"exit")!=0)
		{
		printf("\nmyshell :");
		gets(cmd);
		sscanf(cmd,"%s %s %s",&first,&f1,&f2);
		if(strcmp(first,"copy")==0)
			{
			fp1=fopen(f1,"r");
			fp2=fopen(f2,"a");
			while(!feof(fp1))
				{
				fscanf(fp1,"%c",&ch);
				fprintf(fp2,"%c",ch);
				}
			fclose(fp1);
			fclose(fp2);
			}
		if(strcmp(first,"remove")==0)
			{
			unlink(f1);
			}
		if(strcmp(cmd,"help")==0)
			{
			printf("\n Name\tSyntax\n\n");
			printf("\n copy\tcopy firstfile secondfile\n"); 
			}
		else
			{
			pid=fork();	
			system(cmd);
			}
		}
	}
