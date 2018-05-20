//My command Line Editor
#include<stdio.h>
#include<conio.h>
main()
	{
	FILE *fp1,*fp2;
	int pid;
	char cmd[20],first[20],f1[20],f2[20],ch[20],ch1;
	clrscr();
	printf("\n********* WELCOME TO MY COMMAND LINE EDITOR **********\n\n");
	printf("\nEnter 'help' for help\n");
	while(strcmp(cmd,"exit")!=0)
		{
		printf("\ncmd :");
		gets(cmd);
		sscanf(cmd,"%s %s %s",&first,&f1,&f2);
		if(strcmp(first,"create")==0)
			{
			fp1=fopen(f1,"w");
			if(!fp1)
				{
				printf("\nError in creating file\n");
				}
			else
			{
			while(ch1!='$')
				{
				ch1=getchar();
				putc(ch1,fp1);
				}
			}
			fclose(fp1);
			}
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
		if(strcmp(first,"type")==0)
			{
			fp1=fopen(f1,"r");
			if(!fp1)
				{
				printf("\nPlease check the file\n");
				}
			else
				{
				while(!feof(fp1))
					{
					fscanf(fp1," %s",ch);
					printf(" %s ",ch);
					}
				printf("\n");
				}
			fclose(fp1);
			}
		if(strcmp(first,"remove")==0)
			{
			unlink(f1);
			printf("\n1 file(s) is removed\n");
			}
		if(strcmp(first,"clear")==0)
			{
			clrscr();
			}
		if(strcmp(cmd,"help")==0)
			{
			printf("\n****** WELCOME ******\n\n");
			printf("\n\================================\n");
			printf("\n Name\tSyntax\n");
			printf("\n\================================\n");
			printf("\n create\tcreate filename\n");
			printf("\n copy\tcopy firstfile secondfile\n");
			printf("\n remove\tremove filepath\n");
			printf("\n type\ttype filename\n");
			printf("\n clear\tclear\n");
			printf("\n exit\texit\n");
			printf("\n\================================\n");
			}
		}
	getch();
	return 0;
	}
