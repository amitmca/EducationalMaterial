#include<stdio.h>
#include<string.h>
main()
{
	char cmd[50],t1[20],t2[20],t3[20];
	while(1)
	{
		printf("\nMyshell$]");
		gets(cmd);
		sscanf(cmd,"%s%s%s",t1,t2,t3);
		if(strcmp(t1,"q")==0)
		exit(0);
		if(strcmp(t1,"count")==0)
		count(t2,t3);
		 
		else if(fork())
		{
			execlp(t1,t1,t2,t3,NULL);
			perror(t1);	
		}
		
	}
}

int count(char *h,char *s)
{
	int noc=0,now=0,nol=0;
	char ch;	
	FILE *fp;
	fp=fopen(s,"r");
	while((ch=getc(fp))!=EOF)
	{
		if(ch=='\t'||ch==' ')
		{
			now++;
		}
		else if(ch=='\n')
		{
			nol++;
			now++;
		}
		else
		{
			noc++;
		}
	}
	if(strcmp(h,"c")==0)
	printf("\nThe Total number of characters are %d",noc);
	else if(strcmp(h,"w")==0)
	printf("\nThe Total number of Words are %d",now);
	else if(strcmp(h,"l")==0)
	printf("\nThe The Total number of Lines are %d\n",nol);
	fclose(fp);
}
