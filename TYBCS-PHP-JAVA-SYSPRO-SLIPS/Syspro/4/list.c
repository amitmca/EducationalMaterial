#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<dirent.h>
#include<sys/stat.h>
#include<fcntl.h>

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

		if(strcmp(t1,"list")==0)
		list(t2,t3);
		 
		else if(fork())
		{
			execlp(t1,t1,t2,t3,NULL);
			perror(t1);	
		}
		
	}
}
void list(char *c,char *dn)
{
	DIR *d;
	struct dirent *f;
	struct stat s;
	d=opendir(dn);
	int cnt=0;
	if(strcmp(c,"f")==0)
	{	
		printf("The files in this Directory are:\n");
		while((f=readdir(d))!=NULL)
		printf("%s\n",f->d_name);
	}
	else if(strcmp(c,"n")==0)
	{
		printf("The total content of directory:");
		while((f=readdir(d))!=NULL)
		{
			cnt++;
		}
		printf("%d",cnt);
	}
	else if(strcmp(c,"i")==0)
	{
		while((f=readdir(d))!=NULL)
		{
			stat(f->d_name,&s);
			printf("The INODE No.:%d\t\t NAME of file is:%s\n",s.st_ino,f->d_name);
		}
	}		
}
