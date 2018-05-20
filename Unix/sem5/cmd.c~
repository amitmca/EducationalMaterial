#include<sys/types.h>
#include<sys/wait.h>
#include<dirent.h>
#include<stdio.h>
#define MAXSIZE 1000

int main(int argc,char *argv[])
	{
	char buf[MAXSIZE];
	pid_t pid;
	int status;
	printf("%% ");
	while(fgets(buf,MAXSIZE,stdin)!=NULL)
		{
		buf[strlen(buf)-1]=0;
		if((pid=fork()) < 0)
			printf("\n Fork Error");
		else if(pid==0)	/* Child */
			{
			execlp(buf,buf,(char *) 0);
			printf("couldn't execute :%s",buf);
			exit(127);
			}
		if((pid=waitpid(pid,&status,0)) < 0)	/* Parent */
			printf("waitpid error");
		printf("%% ");	
		}
	exit(0);
	}
